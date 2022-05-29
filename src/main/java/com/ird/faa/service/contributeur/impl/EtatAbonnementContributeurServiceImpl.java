package com.ird.faa.service.contributeur.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.EtatAbonnement;
import com.ird.faa.dao.EtatAbonnementDao;
import com.ird.faa.service.contributeur.facade.EtatAbonnementContributeurService;

import com.ird.faa.ws.rest.provided.vo.EtatAbonnementVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EtatAbonnementContributeurServiceImpl extends AbstractServiceImpl<EtatAbonnement> implements EtatAbonnementContributeurService {

@Autowired
private EtatAbonnementDao etatAbonnementDao;



@Autowired
private EntityManager entityManager;


@Override
public List<EtatAbonnement> findAll(){
        return etatAbonnementDao.findAll();
}
    @Override
    public EtatAbonnement findByCode(String code){
    if( code==null) return null;
    return etatAbonnementDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return etatAbonnementDao.deleteByCode(code);
    }
    @Override
    public EtatAbonnement findByIdOrCode(EtatAbonnement etatAbonnement){
    EtatAbonnement resultat=null;
    if(etatAbonnement != null){
    if(StringUtil.isNotEmpty(etatAbonnement.getId())){
    resultat= etatAbonnementDao.getOne(etatAbonnement.getId());
    }else if(StringUtil.isNotEmpty(etatAbonnement.getCode())) {
    resultat= etatAbonnementDao.findByCode(etatAbonnement.getCode());
    }
    }
    return resultat;
    }

@Override
public EtatAbonnement findById(Long id){
if(id==null) return null;
return etatAbonnementDao.getOne(id);
}

@Override
public EtatAbonnement findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(etatAbonnementDao.findById(id).isPresent())  {
etatAbonnementDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public EtatAbonnement update(EtatAbonnement etatAbonnement){
EtatAbonnement foundedEtatAbonnement = findById(etatAbonnement.getId());
if(foundedEtatAbonnement==null) return null;
else{
return  etatAbonnementDao.save(etatAbonnement);
}
}

@Override
public EtatAbonnement save (EtatAbonnement etatAbonnement){

    EtatAbonnement result =null;
    EtatAbonnement foundedEtatAbonnement = findByCode(etatAbonnement.getCode());
    if(foundedEtatAbonnement == null){




    EtatAbonnement savedEtatAbonnement = etatAbonnementDao.save(etatAbonnement);

    result = savedEtatAbonnement;
    }

    return result;
}

@Override
public List<EtatAbonnement> save(List<EtatAbonnement> etatAbonnements){
List<EtatAbonnement> list = new ArrayList<>();
for(EtatAbonnement etatAbonnement: etatAbonnements){
list.add(save(etatAbonnement));
}
return list;
}



@Override
@Transactional
public int delete(EtatAbonnement etatAbonnement){
    if(etatAbonnement.getCode()==null) return -1;

    EtatAbonnement foundedEtatAbonnement = findByCode(etatAbonnement.getCode());
    if(foundedEtatAbonnement==null) return -1;
etatAbonnementDao.delete(foundedEtatAbonnement);
return 1;
}


public List<EtatAbonnement> findByCriteria(EtatAbonnementVo etatAbonnementVo){

String query = "SELECT o FROM EtatAbonnement o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",etatAbonnementVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",etatAbonnementVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",etatAbonnementVo.getCode());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<EtatAbonnement> etatAbonnements){
if(ListUtil.isNotEmpty(etatAbonnements)){
etatAbonnements.forEach(e->etatAbonnementDao.delete(e));
}
}
@Override
public void update(List<EtatAbonnement> etatAbonnements){
if(ListUtil.isNotEmpty(etatAbonnements)){
etatAbonnements.forEach(e->etatAbonnementDao.save(e));
}
}





    }
