package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Tag;
import com.ird.faa.dao.TagDao;
import com.ird.faa.service.chercheur.facade.TagChercheurService;

import com.ird.faa.ws.rest.provided.vo.TagVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class TagChercheurServiceImpl extends AbstractServiceImpl<Tag> implements TagChercheurService {

@Autowired
private TagDao tagDao;



@Autowired
private EntityManager entityManager;


@Override
public List<Tag> findAll(){
        return tagDao.findAll();
}
    @Override
    public Tag findByCode(String code){
    if( code==null) return null;
    return tagDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return tagDao.deleteByCode(code);
    }
    @Override
    public Tag findByIdOrCode(Tag tag){
    Tag resultat=null;
    if(tag != null){
    if(StringUtil.isNotEmpty(tag.getId())){
    resultat= tagDao.getOne(tag.getId());
    }else if(StringUtil.isNotEmpty(tag.getCode())) {
    resultat= tagDao.findByCode(tag.getCode());
    }
    }
    return resultat;
    }

@Override
public Tag findById(Long id){
if(id==null) return null;
return tagDao.getOne(id);
}

@Override
public Tag findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(tagDao.findById(id).isPresent())  {
tagDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Tag update(Tag tag){
Tag foundedTag = findById(tag.getId());
if(foundedTag==null) return null;
else{
return  tagDao.save(tag);
}
}

@Override
public Tag save (Tag tag){

    Tag result =null;
    Tag foundedTag = findByCode(tag.getCode());
    if(foundedTag == null){




    Tag savedTag = tagDao.save(tag);

    result = savedTag;
    }

    return result;
}

@Override
public List<Tag> save(List<Tag> tags){
List<Tag> list = new ArrayList<>();
for(Tag tag: tags){
list.add(save(tag));
}
return list;
}



@Override
@Transactional
public int delete(Tag tag){
    if(tag.getCode()==null) return -1;

    Tag foundedTag = findByCode(tag.getCode());
    if(foundedTag==null) return -1;
tagDao.delete(foundedTag);
return 1;
}


public List<Tag> findByCriteria(TagVo tagVo){

String query = "SELECT o FROM Tag o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",tagVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",tagVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",tagVo.getCode());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<Tag> tags){
if(ListUtil.isNotEmpty(tags)){
tags.forEach(e->tagDao.delete(e));
}
}
@Override
public void update(List<Tag> tags){
if(ListUtil.isNotEmpty(tags)){
tags.forEach(e->tagDao.save(e));
}
}





    }
