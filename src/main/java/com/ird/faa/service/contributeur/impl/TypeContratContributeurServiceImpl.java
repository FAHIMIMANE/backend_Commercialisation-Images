package com.ird.faa.service.contributeur.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.TypeContrat;
import com.ird.faa.dao.TypeContratDao;
import com.ird.faa.service.contributeur.facade.TypeContratContributeurService;

import com.ird.faa.ws.rest.provided.vo.TypeContratVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class TypeContratContributeurServiceImpl extends AbstractServiceImpl<TypeContrat> implements TypeContratContributeurService {

@Autowired
private TypeContratDao typeContratDao;



@Autowired
private EntityManager entityManager;


@Override
public List<TypeContrat> findAll(){
        return typeContratDao.findAll();
}

@Override
public TypeContrat findById(Long id){
if(id==null) return null;
return typeContratDao.getOne(id);
}

@Override
public TypeContrat findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(typeContratDao.findById(id).isPresent())  {
typeContratDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public TypeContrat update(TypeContrat typeContrat){
TypeContrat foundedTypeContrat = findById(typeContrat.getId());
if(foundedTypeContrat==null) return null;
else{
return  typeContratDao.save(typeContrat);
}
}

@Override
public TypeContrat save (TypeContrat typeContrat){




    return typeContratDao.save(typeContrat);


}

@Override
public List<TypeContrat> save(List<TypeContrat> typeContrats){
List<TypeContrat> list = new ArrayList<>();
for(TypeContrat typeContrat: typeContrats){
list.add(save(typeContrat));
}
return list;
}



@Override
@Transactional
public int delete(TypeContrat typeContrat){
    if(typeContrat.getId()==null) return -1;
    TypeContrat foundedTypeContrat = findById(typeContrat.getId());
    if(foundedTypeContrat==null) return -1;
typeContratDao.delete(foundedTypeContrat);
return 1;
}


public List<TypeContrat> findByCriteria(TypeContratVo typeContratVo){

String query = "SELECT o FROM TypeContrat o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",typeContratVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",typeContratVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "description","LIKE",typeContratVo.getDescription());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<TypeContrat> typeContrats){
if(ListUtil.isNotEmpty(typeContrats)){
typeContrats.forEach(e->typeContratDao.delete(e));
}
}
@Override
public void update(List<TypeContrat> typeContrats){
if(ListUtil.isNotEmpty(typeContrats)){
typeContrats.forEach(e->typeContratDao.save(e));
}
}





    }
