package com.ird.faa.service.client.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Paiement;
        import com.ird.faa.bean.OffreReduction;
import com.ird.faa.dao.PaiementDao;
import com.ird.faa.service.client.facade.PaiementClientService;
        import com.ird.faa.service.client.facade.OffreReductionClientService;

import com.ird.faa.ws.rest.provided.vo.PaiementVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class PaiementClientServiceImpl extends AbstractServiceImpl<Paiement> implements PaiementClientService {

@Autowired
private PaiementDao paiementDao;

        @Autowired
        private OffreReductionClientService offreReductionService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Paiement> findAll(){
        String query = "SELECT o FROM Paiement o where 1=1 ";
        query+= " ORDER BY o.datePaiement";
        return entityManager.createQuery(query).getResultList();
}

        @Override
        public List<Paiement> findByOffreReductionQteMin(Double qteMin){
        return paiementDao.findByOffreReductionQteMin(qteMin);
        }

        @Override
        @Transactional
        public int deleteByOffreReductionQteMin(Double qteMin){
        return paiementDao.deleteByOffreReductionQteMin(qteMin);
        }

        @Override
        public List<Paiement> findByOffreReductionId(Long id){
        return paiementDao.findByOffreReductionId(id);
        }

        @Override
        @Transactional
        public int deleteByOffreReductionId(Long id){
        return paiementDao.deleteByOffreReductionId(id);
        }

    @Override
    public Paiement findByCode(String code){
    if( code==null) return null;
    return paiementDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return paiementDao.deleteByCode(code);
    }
    @Override
    public Paiement findByIdOrCode(Paiement paiement){
    Paiement resultat=null;
    if(paiement != null){
    if(StringUtil.isNotEmpty(paiement.getId())){
    resultat= paiementDao.getOne(paiement.getId());
    }else if(StringUtil.isNotEmpty(paiement.getCode())) {
    resultat= paiementDao.findByCode(paiement.getCode());
    }
    }
    return resultat;
    }

@Override
public Paiement findById(Long id){
if(id==null) return null;
return paiementDao.getOne(id);
}

@Override
public Paiement findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(paiementDao.findById(id).isPresent())  {
paiementDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Paiement update(Paiement paiement){
Paiement foundedPaiement = findById(paiement.getId());
if(foundedPaiement==null) return null;
else{
return  paiementDao.save(paiement);
}
}

@Override
public Paiement save (Paiement paiement){

    Paiement result =null;
    Paiement foundedPaiement = findByCode(paiement.getCode());
    if(foundedPaiement == null){



    findOffreReduction(paiement);

    Paiement savedPaiement = paiementDao.save(paiement);

    result = savedPaiement;
    }

    return result;
}

@Override
public List<Paiement> save(List<Paiement> paiements){
List<Paiement> list = new ArrayList<>();
for(Paiement paiement: paiements){
list.add(save(paiement));
}
return list;
}



@Override
@Transactional
public int delete(Paiement paiement){
    if(paiement.getCode()==null) return -1;

    Paiement foundedPaiement = findByCode(paiement.getCode());
    if(foundedPaiement==null) return -1;
paiementDao.delete(foundedPaiement);
return 1;
}


public List<Paiement> findByCriteria(PaiementVo paiementVo){

String query = "SELECT o FROM Paiement o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",paiementVo.getId());
            query += SearchUtil.addConstraint( "o", "code","LIKE",paiementVo.getCode());
            query += SearchUtil.addConstraint( "o", "montantHt","=",paiementVo.getMontantHt());
            query += SearchUtil.addConstraint( "o", "montantTtc","=",paiementVo.getMontantTtc());
            query += SearchUtil.addConstraint( "o", "montantTva","=",paiementVo.getMontantTva());
        query += SearchUtil.addConstraintDate( "o", "datePaiement","=",paiementVo.getDatePaiement());
            query += SearchUtil.addConstraint( "o", "pourcentageReduction","=",paiementVo.getPourcentageReduction());
            query += SearchUtil.addConstraintMinMax("o","montantHt",paiementVo.getMontantHtMin(),paiementVo.getMontantHtMax());
            query += SearchUtil.addConstraintMinMax("o","montantTtc",paiementVo.getMontantTtcMin(),paiementVo.getMontantTtcMax());
            query += SearchUtil.addConstraintMinMax("o","montantTva",paiementVo.getMontantTvaMin(),paiementVo.getMontantTvaMax());
            query += SearchUtil.addConstraintMinMaxDate("o","datePaiement",paiementVo.getDatePaiementMin(),paiementVo.getDatePaiementMax());
            query += SearchUtil.addConstraintMinMax("o","pourcentageReduction",paiementVo.getPourcentageReductionMin(),paiementVo.getPourcentageReductionMax());
    if(paiementVo.getOffreReductionVo()!=null){
        query += SearchUtil.addConstraint( "o", "offreReduction.id","=",paiementVo.getOffreReductionVo().getId());
            query += SearchUtil.addConstraint( "o", "offreReduction.qteMin","=",paiementVo.getOffreReductionVo().getQteMin());
    }

    query+= " ORDER BY o.datePaiement";
return entityManager.createQuery(query).getResultList();
}

    private void findOffreReduction(Paiement paiement){
        OffreReduction loadedOffreReduction =offreReductionService.findByIdOrQteMin(paiement.getOffreReduction());

    if(loadedOffreReduction==null ) {
    return;
    }
    paiement.setOffreReduction(loadedOffreReduction);
    }

@Override
@Transactional
public void delete(List<Paiement> paiements){
if(ListUtil.isNotEmpty(paiements)){
paiements.forEach(e->paiementDao.delete(e));
}
}
@Override
public void update(List<Paiement> paiements){
if(ListUtil.isNotEmpty(paiements)){
paiements.forEach(e->paiementDao.save(e));
}
}





    }
