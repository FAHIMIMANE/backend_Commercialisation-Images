package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Signature;
        import com.ird.faa.bean.Contributeur;
        import com.ird.faa.bean.Contract;
import com.ird.faa.dao.SignatureDao;
import com.ird.faa.service.chercheur.facade.SignatureChercheurService;
        import com.ird.faa.service.chercheur.facade.ContributeurChercheurService;
        import com.ird.faa.service.chercheur.facade.ContractChercheurService;

import com.ird.faa.ws.rest.provided.vo.SignatureVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class SignatureChercheurServiceImpl extends AbstractServiceImpl<Signature> implements SignatureChercheurService {

@Autowired
private SignatureDao signatureDao;

        @Autowired
        private ContributeurChercheurService contributeurService ;
        @Autowired
        private ContractChercheurService contractService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Signature> findAll(){
        String query = "SELECT o FROM Signature o where 1=1 ";
        query+= " ORDER BY o.dateSignature";
        return entityManager.createQuery(query).getResultList();
}

        @Override
        public List<Signature> findByContributeurNumeroMatricule(String numeroMatricule){
        return signatureDao.findByContributeurNumeroMatricule(numeroMatricule);
        }

        @Override
        @Transactional
        public int deleteByContributeurNumeroMatricule(String numeroMatricule){
        return signatureDao.deleteByContributeurNumeroMatricule(numeroMatricule);
        }

        @Override
        public List<Signature> findByContributeurId(Long id){
        return signatureDao.findByContributeurId(id);
        }

        @Override
        @Transactional
        public int deleteByContributeurId(Long id){
        return signatureDao.deleteByContributeurId(id);
        }


        @Override
        public List<Signature> findByContractReference(String reference){
        return signatureDao.findByContractReference(reference);
        }

        @Override
        @Transactional
        public int deleteByContractReference(String reference){
        return signatureDao.deleteByContractReference(reference);
        }

        @Override
        public List<Signature> findByContractId(Long id){
        return signatureDao.findByContractId(id);
        }

        @Override
        @Transactional
        public int deleteByContractId(Long id){
        return signatureDao.deleteByContractId(id);
        }


@Override
public Signature findById(Long id){
if(id==null) return null;
return signatureDao.getOne(id);
}

@Override
public Signature findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(signatureDao.findById(id).isPresent())  {
signatureDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Signature update(Signature signature){
Signature foundedSignature = findById(signature.getId());
if(foundedSignature==null) return null;
else{
return  signatureDao.save(signature);
}
}

@Override
public Signature save (Signature signature){



    findContributeur(signature);
    findContract(signature);

    return signatureDao.save(signature);


}

@Override
public List<Signature> save(List<Signature> signatures){
List<Signature> list = new ArrayList<>();
for(Signature signature: signatures){
list.add(save(signature));
}
return list;
}



@Override
@Transactional
public int delete(Signature signature){
    if(signature.getId()==null) return -1;
    Signature foundedSignature = findById(signature.getId());
    if(foundedSignature==null) return -1;
signatureDao.delete(foundedSignature);
return 1;
}


public List<Signature> findByCriteria(SignatureVo signatureVo){

String query = "SELECT o FROM Signature o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",signatureVo.getId());
        query += SearchUtil.addConstraintDate( "o", "dateSignature","=",signatureVo.getDateSignature());
            query += SearchUtil.addConstraintMinMaxDate("o","dateSignature",signatureVo.getDateSignatureMin(),signatureVo.getDateSignatureMax());
    if(signatureVo.getContributeurVo()!=null){
        query += SearchUtil.addConstraint( "o", "contributeur.id","=",signatureVo.getContributeurVo().getId());
            query += SearchUtil.addConstraint( "o", "contributeur.numeroMatricule","LIKE",signatureVo.getContributeurVo().getNumeroMatricule());
    }

    if(signatureVo.getContractVo()!=null){
        query += SearchUtil.addConstraint( "o", "contract.id","=",signatureVo.getContractVo().getId());
            query += SearchUtil.addConstraint( "o", "contract.reference","LIKE",signatureVo.getContractVo().getReference());
    }

    query+= " ORDER BY o.dateSignature";
return entityManager.createQuery(query).getResultList();
}

    private void findContributeur(Signature signature){
        Contributeur loadedContributeur =contributeurService.findByIdOrNumeroMatricule(signature.getContributeur());

    if(loadedContributeur==null ) {
    return;
    }
    signature.setContributeur(loadedContributeur);
    }
    private void findContract(Signature signature){
        Contract loadedContract =contractService.findByIdOrReference(signature.getContract());

    if(loadedContract==null ) {
    return;
    }
    signature.setContract(loadedContract);
    }

@Override
@Transactional
public void delete(List<Signature> signatures){
if(ListUtil.isNotEmpty(signatures)){
signatures.forEach(e->signatureDao.delete(e));
}
}
@Override
public void update(List<Signature> signatures){
if(ListUtil.isNotEmpty(signatures)){
signatures.forEach(e->signatureDao.save(e));
}
}





    }
