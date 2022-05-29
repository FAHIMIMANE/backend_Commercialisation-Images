package com.ird.faa.service.client.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.StateBucket;
import com.ird.faa.dao.StateBucketDao;
import com.ird.faa.service.client.facade.StateBucketClientService;

import com.ird.faa.ws.rest.provided.vo.StateBucketVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class StateBucketClientServiceImpl extends AbstractServiceImpl<StateBucket> implements StateBucketClientService {

@Autowired
private StateBucketDao stateBucketDao;



@Autowired
private EntityManager entityManager;


@Override
public List<StateBucket> findAll(){
        return stateBucketDao.findAll();
}
    @Override
    public StateBucket findByCode(String code){
    if( code==null) return null;
    return stateBucketDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return stateBucketDao.deleteByCode(code);
    }
    @Override
    public StateBucket findByIdOrCode(StateBucket stateBucket){
    StateBucket resultat=null;
    if(stateBucket != null){
    if(StringUtil.isNotEmpty(stateBucket.getId())){
    resultat= stateBucketDao.getOne(stateBucket.getId());
    }else if(StringUtil.isNotEmpty(stateBucket.getCode())) {
    resultat= stateBucketDao.findByCode(stateBucket.getCode());
    }
    }
    return resultat;
    }

@Override
public StateBucket findById(Long id){
if(id==null) return null;
return stateBucketDao.getOne(id);
}

@Override
public StateBucket findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(stateBucketDao.findById(id).isPresent())  {
stateBucketDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public StateBucket update(StateBucket stateBucket){
StateBucket foundedStateBucket = findById(stateBucket.getId());
if(foundedStateBucket==null) return null;
else{
return  stateBucketDao.save(stateBucket);
}
}

@Override
public StateBucket save (StateBucket stateBucket){

    StateBucket result =null;
    StateBucket foundedStateBucket = findByCode(stateBucket.getCode());
    if(foundedStateBucket == null){




    StateBucket savedStateBucket = stateBucketDao.save(stateBucket);

    result = savedStateBucket;
    }

    return result;
}

@Override
public List<StateBucket> save(List<StateBucket> stateBuckets){
List<StateBucket> list = new ArrayList<>();
for(StateBucket stateBucket: stateBuckets){
list.add(save(stateBucket));
}
return list;
}



@Override
@Transactional
public int delete(StateBucket stateBucket){
    if(stateBucket.getCode()==null) return -1;

    StateBucket foundedStateBucket = findByCode(stateBucket.getCode());
    if(foundedStateBucket==null) return -1;
stateBucketDao.delete(foundedStateBucket);
return 1;
}


public List<StateBucket> findByCriteria(StateBucketVo stateBucketVo){

String query = "SELECT o FROM StateBucket o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",stateBucketVo.getId());
            query += SearchUtil.addConstraint( "o", "code","LIKE",stateBucketVo.getCode());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",stateBucketVo.getLibelle());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<StateBucket> stateBuckets){
if(ListUtil.isNotEmpty(stateBuckets)){
stateBuckets.forEach(e->stateBucketDao.delete(e));
}
}
@Override
public void update(List<StateBucket> stateBuckets){
if(ListUtil.isNotEmpty(stateBuckets)){
stateBuckets.forEach(e->stateBucketDao.save(e));
}
}





    }
