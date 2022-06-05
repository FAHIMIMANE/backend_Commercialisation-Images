package com.ird.faa.service.contributeur.impl;

import java.util.Arrays;
import java.util.List;

import java.util.ArrayList;

import com.ird.faa.bean.Client;
import com.ird.faa.security.bean.Role;
import com.ird.faa.security.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Contributeur;
        import com.ird.faa.bean.Bucket;
import com.ird.faa.dao.ContributeurDao;
import com.ird.faa.service.contributeur.facade.ContributeurContributeurService;
        import com.ird.faa.service.contributeur.facade.BucketContributeurService;

import com.ird.faa.ws.rest.provided.vo.ContributeurVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class ContributeurContributeurServiceImpl extends AbstractServiceImpl<Contributeur> implements ContributeurContributeurService {

@Autowired
private ContributeurDao contributeurDao;

        @Autowired
        private BucketContributeurService bucketService ;
    @Autowired
    private UserService userService;

@Autowired
private EntityManager entityManager;

    @Override
    public Contributeur findByUsername(String username){
    return contributeurDao.findByUsername(username);
    }

@Override
public List<Contributeur> findAll(){
        return contributeurDao.findAll();
}
    @Override
    public Contributeur findByNumeroMatricule(String numeroMatricule){
    if( numeroMatricule==null) return null;
    return contributeurDao.findByNumeroMatricule(numeroMatricule);
    }

    @Override
    @Transactional
    public int deleteByNumeroMatricule(String  numeroMatricule) {
    return contributeurDao.deleteByNumeroMatricule(numeroMatricule);
    }
    @Override
    public Contributeur findByIdOrNumeroMatricule(Contributeur contributeur){
    Contributeur resultat=null;
    if(contributeur != null){
    if(StringUtil.isNotEmpty(contributeur.getId())){
    resultat= contributeurDao.getOne(contributeur.getId());
    }else if(StringUtil.isNotEmpty(contributeur.getNumeroMatricule())) {
    resultat= contributeurDao.findByNumeroMatricule(contributeur.getNumeroMatricule());
    }else if(StringUtil.isNotEmpty(contributeur.getUsername())) {
    resultat = contributeurDao.findByUsername(contributeur.getUsername());
    }
    }
    return resultat;
    }

@Override
public Contributeur findById(Long id){
if(id==null) return null;
return contributeurDao.getOne(id);
}

@Override
public Contributeur findByIdWithAssociatedList(Long id){
    Contributeur contributeur  = findById(id);
    findAssociatedLists(contributeur);
    return contributeur;
}

    private void findAssociatedLists(Contributeur contributeur){
    if(contributeur!=null && contributeur.getId() != null) {
            List<Bucket> buckets = bucketService.findByContributeurId(contributeur.getId());
            contributeur.setBuckets(buckets);
    }
    }
    private void deleteAssociatedLists(Long id){
    if(id != null ) {
            bucketService.deleteByContributeurId(id);
    }
    }

    private void updateAssociatedLists(Contributeur contributeur){
    if(contributeur !=null && contributeur.getId() != null){
            List
            <List<Bucket>> resultBuckets= bucketService.getToBeSavedAndToBeDeleted(bucketService.findByContributeurId(contributeur.getId()),contributeur.getBuckets());
            bucketService.delete(resultBuckets.get(1));
            associateBucket(contributeur,resultBuckets.get(0));
            bucketService.update(resultBuckets.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
int res=0;
if(contributeurDao.findById(id).isPresent())  {
    deleteAssociatedLists(id);
contributeurDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Contributeur update(Contributeur contributeur){
Contributeur foundedContributeur = findById(contributeur.getId());
if(foundedContributeur==null) return null;
else{
    updateAssociatedLists(contributeur);
return  contributeurDao.save(contributeur);
}
}
    private void prepareSave(Contributeur contributeur){
                contributeur.setCredentialsNonExpired(true);
                contributeur.setEnabled(true);
                contributeur.setAccountNonExpired(true);
                contributeur.setAccountNonLocked(true);
                contributeur.setPasswordChanged(true);




    }

@Override
public Contributeur saveWithBucket(Contributeur contributeur){
    prepareSave(contributeur);

    Contributeur result =null;
        Contributeur foundedContributeur = findByNumeroMatricule(contributeur.getNumeroMatricule());
        Contributeur foundedContributeurByUsername = findByNumeroMatricule(contributeur.getNumeroMatricule());
        if(foundedContributeur == null && foundedContributeurByUsername == null){




    Contributeur savedContributeur = contributeurDao.save(contributeur);

        saveBuckets(savedContributeur,contributeur.getBuckets());
    result = savedContributeur;
    }

    return result;
}
    @Override
    public Contributeur save(Contributeur contributeur) {
        contributeur.setRoles(Arrays.asList(new Role("ROLE_CLIENT")));
        contributeur.setBaseHorizon("nonos"+System.currentTimeMillis());
        userService.prepareSave(contributeur);
        Contributeur savedContributeur = contributeurDao.save(contributeur);
        return savedContributeur;
    }
@Override
public List<Contributeur> save(List<Contributeur> contributeurs){
List<Contributeur> list = new ArrayList<>();
for(Contributeur contributeur: contributeurs){
list.add(save(contributeur));
}
return list;
}

        private List<Bucket> prepareBuckets(Contributeur contributeur,List<Bucket> buckets){
        for(Bucket bucket:buckets ){
        bucket.setContributeur(contributeur);
        }
        return buckets;
        }


@Override
@Transactional
public int delete(Contributeur contributeur){
    if(contributeur.getNumeroMatricule()==null) return -1;

    Contributeur foundedContributeur = findByNumeroMatricule(contributeur.getNumeroMatricule());
    if(foundedContributeur==null) return -1;
contributeurDao.delete(foundedContributeur);
return 1;
}


public List<Contributeur> findByCriteria(ContributeurVo contributeurVo){

String query = "SELECT o FROM Contributeur o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",contributeurVo.getId());
            query += SearchUtil.addConstraint( "o", "numeroMatricule","LIKE",contributeurVo.getNumeroMatricule());
            query += SearchUtil.addConstraint( "o", "emailPrincipale","LIKE",contributeurVo.getEmailPrincipale());
            query += SearchUtil.addConstraint( "o", "resume","LIKE",contributeurVo.getResume());
            query += SearchUtil.addConstraint( "o", "credentialsNonExpired","=",contributeurVo.getCredentialsNonExpired());
            query += SearchUtil.addConstraint( "o", "enabled","=",contributeurVo.getEnabled());
            query += SearchUtil.addConstraint( "o", "accountNonExpired","=",contributeurVo.getAccountNonExpired());
            query += SearchUtil.addConstraint( "o", "accountNonLocked","=",contributeurVo.getAccountNonLocked());
            query += SearchUtil.addConstraint( "o", "passwordChanged","=",contributeurVo.getPasswordChanged());
        query += SearchUtil.addConstraintDate( "o", "createdAt","=",contributeurVo.getCreatedAt());
        query += SearchUtil.addConstraintDate( "o", "updatedAt","=",contributeurVo.getUpdatedAt());
            query += SearchUtil.addConstraint( "o", "username","LIKE",contributeurVo.getUsername());
            query += SearchUtil.addConstraint( "o", "password","LIKE",contributeurVo.getPassword());
            query += SearchUtil.addConstraint( "o", "prenom","LIKE",contributeurVo.getPrenom());
            query += SearchUtil.addConstraint( "o", "nom","LIKE",contributeurVo.getNom());
            query += SearchUtil.addConstraint( "o", "cin","LIKE",contributeurVo.getCin());
            query += SearchUtil.addConstraint( "o", "numeroTelephone","LIKE",contributeurVo.getNumeroTelephone());
            query += SearchUtil.addConstraint( "o", "adresse","LIKE",contributeurVo.getAdresse());
            query += SearchUtil.addConstraint( "o", "codePostale","LIKE",contributeurVo.getCodePostale());
            query += SearchUtil.addConstraintMinMaxDate("o","createdAt",contributeurVo.getCreatedAtMin(),contributeurVo.getCreatedAtMax());
            query += SearchUtil.addConstraintMinMaxDate("o","updatedAt",contributeurVo.getUpdatedAtMin(),contributeurVo.getUpdatedAtMax());
return entityManager.createQuery(query).getResultList();
}
        private  void saveBuckets(Contributeur contributeur,List<Bucket> buckets){

        if (ListUtil.isNotEmpty(contributeur.getBuckets())) {
        List<Bucket> savedBuckets = new ArrayList<>();
        buckets.forEach(element -> {
        element.setContributeur(contributeur);
         bucketService.save(element);
        });
        contributeur.setBuckets(savedBuckets);
        }
        }


@Override
@Transactional
public void delete(List<Contributeur> contributeurs){
if(ListUtil.isNotEmpty(contributeurs)){
contributeurs.forEach(e->contributeurDao.delete(e));
}
}
@Override
public void update(List<Contributeur> contributeurs){
if(ListUtil.isNotEmpty(contributeurs)){
contributeurs.forEach(e->contributeurDao.save(e));
}
}

        private void associateBucket(Contributeur contributeur, List<Bucket> bucket) {
        if (ListUtil.isNotEmpty(bucket)) {
        bucket.forEach(e -> e.setContributeur(contributeur));
        }
        }




    }
