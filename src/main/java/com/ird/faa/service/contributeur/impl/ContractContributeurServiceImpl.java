package com.ird.faa.service.contributeur.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Contract;
        import com.ird.faa.bean.TypeContrat;
        import com.ird.faa.bean.Signature;
import com.ird.faa.dao.ContractDao;
import com.ird.faa.service.contributeur.facade.ContractContributeurService;
        import com.ird.faa.service.contributeur.facade.TypeContratContributeurService;
        import com.ird.faa.service.contributeur.facade.SignatureContributeurService;

import com.ird.faa.ws.rest.provided.vo.ContractVo;
import com.ird.faa.service.util.*;
        import com.ird.faa.bean.Signature;
        import com.ird.faa.service.contributeur.facade.SignatureContributeurService;

    import com.ird.faa.service.core.facade.ArchivableService;
import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class ContractContributeurServiceImpl extends AbstractServiceImpl<Contract> implements ContractContributeurService {

@Autowired
private ContractDao contractDao;

    @Autowired
    private ArchivableService<Contract> archivableService;
        @Autowired
        private TypeContratContributeurService typeContratService ;
        @Autowired
        private SignatureContributeurService signatureService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Contract> findAll(){
        String query = "SELECT o FROM Contract o where 1=1 ";
        query+= " ORDER BY o.dateDebut";
        return entityManager.createQuery(query).getResultList();
}
        @Override
        public List<Contract> findByTypeContratId(Long id){
        return contractDao.findByTypeContratId(id);
        }

        @Override
        @Transactional
        public int deleteByTypeContratId(Long id){
        return contractDao.deleteByTypeContratId(id);
        }

    @Override
    public Contract findByReference(String reference){
    if( reference==null) return null;
    return contractDao.findByReference(reference);
    }

    @Override
    @Transactional
    public int deleteByReference(String  reference) {
    return contractDao.deleteByReference(reference);
    }
    @Override
    public Contract findByIdOrReference(Contract contract){
    Contract resultat=null;
    if(contract != null){
    if(StringUtil.isNotEmpty(contract.getId())){
    resultat= contractDao.getOne(contract.getId());
    }else if(StringUtil.isNotEmpty(contract.getReference())) {
    resultat= contractDao.findByReference(contract.getReference());
    }
    }
    return resultat;
    }

@Override
public Contract findById(Long id){
if(id==null) return null;
return contractDao.getOne(id);
}

@Override
public Contract findByIdWithAssociatedList(Long id){
    Contract contract  = findById(id);
    findAssociatedLists(contract);
    return contract;
}
    @Override
    public Contract archiver(Contract contract) {
    if (contract.getArchive() == null) {
    contract.setArchive(false);
    }
    contract.setArchive(true);
    contract.setDateArchivage(new Date());
    contractDao.save(contract);
    return contract;

    }

    @Override
    public Contract desarchiver(Contract contract) {
    if (contract.getArchive() == null) {
    contract.setArchive(false);
    }
    contract.setArchive(false);
    contractDao.save(contract);
    return contract;
    }


    private void findAssociatedLists(Contract contract){
    if(contract!=null && contract.getId() != null) {
            List<Signature> signatures = signatureService.findByContractId(contract.getId());
            contract.setSignatures(signatures);
    }
    }
    private void deleteAssociatedLists(Long id){
    if(id != null ) {
            signatureService.deleteByContractId(id);
    }
    }

    private void updateAssociatedLists(Contract contract){
    if(contract !=null && contract.getId() != null){
            List
            <List<Signature>> resultSignatures= signatureService.getToBeSavedAndToBeDeleted(signatureService.findByContractId(contract.getId()),contract.getSignatures());
            signatureService.delete(resultSignatures.get(1));
            associateSignature(contract,resultSignatures.get(0));
            signatureService.update(resultSignatures.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
int res=0;
if(contractDao.findById(id).isPresent())  {
    deleteAssociatedLists(id);
contractDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Contract update(Contract contract){
Contract foundedContract = findById(contract.getId());
if(foundedContract==null) return null;
else{
    archivableService.prepare(contract);
    updateAssociatedLists(contract);
return  contractDao.save(contract);
}
}
    private void prepareSave(Contract contract){
        contract.setDateCreation(new Date());
        if(contract.getDateArchivage() == null)
        contract.setDateArchivage(new Date());
                    if(contract.getArchive() == null)
                contract.setArchive(false);




    }

@Override
public Contract save (Contract contract){
    prepareSave(contract);

    Contract result =null;
    Contract foundedContract = findByReference(contract.getReference());
    if(foundedContract == null){



    findTypeContrat(contract);

    Contract savedContract = contractDao.save(contract);

        saveSignatures(savedContract,contract.getSignatures());
    result = savedContract;
    }

    return result;
}

@Override
public List<Contract> save(List<Contract> contracts){
List<Contract> list = new ArrayList<>();
for(Contract contract: contracts){
list.add(save(contract));
}
return list;
}

        private List<Signature> prepareSignatures(Contract contract,List<Signature> signatures){
        for(Signature signature:signatures ){
        signature.setContract(contract);
        }
        return signatures;
        }


@Override
@Transactional
public int delete(Contract contract){
    if(contract.getReference()==null) return -1;

    Contract foundedContract = findByReference(contract.getReference());
    if(foundedContract==null) return -1;
contractDao.delete(foundedContract);
return 1;
}


public List<Contract> findByCriteria(ContractVo contractVo){

String query = "SELECT o FROM Contract o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",contractVo.getId());
        query += SearchUtil.addConstraintDate( "o", "dateDebut","=",contractVo.getDateDebut());
        query += SearchUtil.addConstraintDate( "o", "dateFin","=",contractVo.getDateFin());
            query += SearchUtil.addConstraint( "o", "objet","LIKE",contractVo.getObjet());
            query += SearchUtil.addConstraint( "o", "contenu","LIKE",contractVo.getContenu());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",contractVo.getReference());
            query += SearchUtil.addConstraint( "o", "archive","=",contractVo.getArchive());
        query += SearchUtil.addConstraintDate( "o", "dateArchivage","=",contractVo.getDateArchivage());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",contractVo.getDateCreation());
            query += SearchUtil.addConstraintMinMaxDate("o","dateDebut",contractVo.getDateDebutMin(),contractVo.getDateDebutMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateFin",contractVo.getDateFinMin(),contractVo.getDateFinMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateArchivage",contractVo.getDateArchivageMin(),contractVo.getDateArchivageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",contractVo.getDateCreationMin(),contractVo.getDateCreationMax());
    if(contractVo.getTypeContratVo()!=null){
        query += SearchUtil.addConstraint( "o", "typeContrat.id","=",contractVo.getTypeContratVo().getId());
    }

    query+= " ORDER BY o.dateDebut";
return entityManager.createQuery(query).getResultList();
}
        private  void saveSignatures(Contract contract,List<Signature> signatures){

        if (ListUtil.isNotEmpty(contract.getSignatures())) {
        List<Signature> savedSignatures = new ArrayList<>();
        signatures.forEach(element -> {
        element.setContract(contract);
         signatureService.save(element);
        });
        contract.setSignatures(savedSignatures);
        }
        }

    private void findTypeContrat(Contract contract){
        TypeContrat loadedTypeContrat = null;
        if(contract.getTypeContrat() != null && contract.getTypeContrat().getId() !=null)
        loadedTypeContrat =typeContratService.findById(contract.getTypeContrat().getId());

    if(loadedTypeContrat==null ) {
    return;
    }
    contract.setTypeContrat(loadedTypeContrat);
    }

@Override
@Transactional
public void delete(List<Contract> contracts){
if(ListUtil.isNotEmpty(contracts)){
contracts.forEach(e->contractDao.delete(e));
}
}
@Override
public void update(List<Contract> contracts){
if(ListUtil.isNotEmpty(contracts)){
contracts.forEach(e->contractDao.save(e));
}
}

        private void associateSignature(Contract contract, List<Signature> signature) {
        if (ListUtil.isNotEmpty(signature)) {
        signature.forEach(e -> e.setContract(contract));
        }
        }




    }
