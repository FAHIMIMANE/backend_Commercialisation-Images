package com.ird.faa.service.client.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.TypeContributeur;
import com.ird.faa.dao.TypeContributeurDao;
import com.ird.faa.service.client.facade.TypeContributeurClientService;

import com.ird.faa.ws.rest.provided.vo.TypeContributeurVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class TypeContributeurClientServiceImpl extends AbstractServiceImpl<TypeContributeur> implements TypeContributeurClientService {

@Autowired
private TypeContributeurDao typeContributeurDao;



@Autowired
private EntityManager entityManager;


@Override
public List<TypeContributeur> findAll(){
        return typeContributeurDao.findAll();
}
    @Override
    public TypeContributeur findByCode(String code){
    if( code==null) return null;
    return typeContributeurDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return typeContributeurDao.deleteByCode(code);
    }
    @Override
    public TypeContributeur findByIdOrCode(TypeContributeur typeContributeur){
    TypeContributeur resultat=null;
    if(typeContributeur != null){
    if(StringUtil.isNotEmpty(typeContributeur.getId())){
    resultat= typeContributeurDao.getOne(typeContributeur.getId());
    }else if(StringUtil.isNotEmpty(typeContributeur.getCode())) {
    resultat= typeContributeurDao.findByCode(typeContributeur.getCode());
    }
    }
    return resultat;
    }

@Override
public TypeContributeur findById(Long id){
if(id==null) return null;
return typeContributeurDao.getOne(id);
}

@Override
public TypeContributeur findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(typeContributeurDao.findById(id).isPresent())  {
typeContributeurDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public TypeContributeur update(TypeContributeur typeContributeur){
TypeContributeur foundedTypeContributeur = findById(typeContributeur.getId());
if(foundedTypeContributeur==null) return null;
else{
return  typeContributeurDao.save(typeContributeur);
}
}

@Override
public TypeContributeur save (TypeContributeur typeContributeur){

    TypeContributeur result =null;
    TypeContributeur foundedTypeContributeur = findByCode(typeContributeur.getCode());
    if(foundedTypeContributeur == null){




    TypeContributeur savedTypeContributeur = typeContributeurDao.save(typeContributeur);

    result = savedTypeContributeur;
    }

    return result;
}

@Override
public List<TypeContributeur> save(List<TypeContributeur> typeContributeurs){
List<TypeContributeur> list = new ArrayList<>();
for(TypeContributeur typeContributeur: typeContributeurs){
list.add(save(typeContributeur));
}
return list;
}



@Override
@Transactional
public int delete(TypeContributeur typeContributeur){
    if(typeContributeur.getCode()==null) return -1;

    TypeContributeur foundedTypeContributeur = findByCode(typeContributeur.getCode());
    if(foundedTypeContributeur==null) return -1;
typeContributeurDao.delete(foundedTypeContributeur);
return 1;
}


public List<TypeContributeur> findByCriteria(TypeContributeurVo typeContributeurVo){

String query = "SELECT o FROM TypeContributeur o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",typeContributeurVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",typeContributeurVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",typeContributeurVo.getCode());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<TypeContributeur> typeContributeurs){
if(ListUtil.isNotEmpty(typeContributeurs)){
typeContributeurs.forEach(e->typeContributeurDao.delete(e));
}
}
@Override
public void update(List<TypeContributeur> typeContributeurs){
if(ListUtil.isNotEmpty(typeContributeurs)){
typeContributeurs.forEach(e->typeContributeurDao.save(e));
}
}





    }
