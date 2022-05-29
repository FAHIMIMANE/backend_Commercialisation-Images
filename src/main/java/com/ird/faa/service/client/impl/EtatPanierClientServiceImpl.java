package com.ird.faa.service.client.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.EtatPanier;
import com.ird.faa.dao.EtatPanierDao;
import com.ird.faa.service.client.facade.EtatPanierClientService;

import com.ird.faa.ws.rest.provided.vo.EtatPanierVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EtatPanierClientServiceImpl extends AbstractServiceImpl<EtatPanier> implements EtatPanierClientService {

@Autowired
private EtatPanierDao etatPanierDao;



@Autowired
private EntityManager entityManager;


@Override
public List<EtatPanier> findAll(){
        return etatPanierDao.findAll();
}
    @Override
    public EtatPanier findByCode(String code){
    if( code==null) return null;
    return etatPanierDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return etatPanierDao.deleteByCode(code);
    }
    @Override
    public EtatPanier findByIdOrCode(EtatPanier etatPanier){
    EtatPanier resultat=null;
    if(etatPanier != null){
    if(StringUtil.isNotEmpty(etatPanier.getId())){
    resultat= etatPanierDao.getOne(etatPanier.getId());
    }else if(StringUtil.isNotEmpty(etatPanier.getCode())) {
    resultat= etatPanierDao.findByCode(etatPanier.getCode());
    }
    }
    return resultat;
    }

@Override
public EtatPanier findById(Long id){
if(id==null) return null;
return etatPanierDao.getOne(id);
}

@Override
public EtatPanier findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(etatPanierDao.findById(id).isPresent())  {
etatPanierDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public EtatPanier update(EtatPanier etatPanier){
EtatPanier foundedEtatPanier = findById(etatPanier.getId());
if(foundedEtatPanier==null) return null;
else{
return  etatPanierDao.save(etatPanier);
}
}

@Override
public EtatPanier save (EtatPanier etatPanier){

    EtatPanier result =null;
    EtatPanier foundedEtatPanier = findByCode(etatPanier.getCode());
    if(foundedEtatPanier == null){




    EtatPanier savedEtatPanier = etatPanierDao.save(etatPanier);

    result = savedEtatPanier;
    }

    return result;
}

@Override
public List<EtatPanier> save(List<EtatPanier> etatPaniers){
List<EtatPanier> list = new ArrayList<>();
for(EtatPanier etatPanier: etatPaniers){
list.add(save(etatPanier));
}
return list;
}



@Override
@Transactional
public int delete(EtatPanier etatPanier){
    if(etatPanier.getCode()==null) return -1;

    EtatPanier foundedEtatPanier = findByCode(etatPanier.getCode());
    if(foundedEtatPanier==null) return -1;
etatPanierDao.delete(foundedEtatPanier);
return 1;
}


public List<EtatPanier> findByCriteria(EtatPanierVo etatPanierVo){

String query = "SELECT o FROM EtatPanier o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",etatPanierVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",etatPanierVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",etatPanierVo.getCode());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<EtatPanier> etatPaniers){
if(ListUtil.isNotEmpty(etatPaniers)){
etatPaniers.forEach(e->etatPanierDao.delete(e));
}
}
@Override
public void update(List<EtatPanier> etatPaniers){
if(ListUtil.isNotEmpty(etatPaniers)){
etatPaniers.forEach(e->etatPanierDao.save(e));
}
}





    }
