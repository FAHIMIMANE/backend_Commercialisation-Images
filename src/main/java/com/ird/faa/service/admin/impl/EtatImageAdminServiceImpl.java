package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.EtatImage;
import com.ird.faa.dao.EtatImageDao;
import com.ird.faa.service.admin.facade.EtatImageAdminService;

import com.ird.faa.ws.rest.provided.vo.EtatImageVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class EtatImageAdminServiceImpl extends AbstractServiceImpl<EtatImage> implements EtatImageAdminService {

@Autowired
private EtatImageDao etatImageDao;



@Autowired
private EntityManager entityManager;


@Override
public List<EtatImage> findAll(){
        return etatImageDao.findAll();
}
    @Override
    public EtatImage findByCode(String code){
    if( code==null) return null;
    return etatImageDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return etatImageDao.deleteByCode(code);
    }
    @Override
    public EtatImage findByIdOrCode(EtatImage etatImage){
    EtatImage resultat=null;
    if(etatImage != null){
    if(StringUtil.isNotEmpty(etatImage.getId())){
    resultat= etatImageDao.getOne(etatImage.getId());
    }else if(StringUtil.isNotEmpty(etatImage.getCode())) {
    resultat= etatImageDao.findByCode(etatImage.getCode());
    }
    }
    return resultat;
    }

@Override
public EtatImage findById(Long id){
if(id==null) return null;
return etatImageDao.getOne(id);
}

@Override
public EtatImage findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(etatImageDao.findById(id).isPresent())  {
etatImageDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public EtatImage update(EtatImage etatImage){
EtatImage foundedEtatImage = findById(etatImage.getId());
if(foundedEtatImage==null) return null;
else{
return  etatImageDao.save(etatImage);
}
}

@Override
public EtatImage save (EtatImage etatImage){

    EtatImage result =null;
    EtatImage foundedEtatImage = findByCode(etatImage.getCode());
    if(foundedEtatImage == null){




    EtatImage savedEtatImage = etatImageDao.save(etatImage);

    result = savedEtatImage;
    }

    return result;
}

@Override
public List<EtatImage> save(List<EtatImage> etatImages){
List<EtatImage> list = new ArrayList<>();
for(EtatImage etatImage: etatImages){
list.add(save(etatImage));
}
return list;
}



@Override
@Transactional
public int delete(EtatImage etatImage){
    if(etatImage.getCode()==null) return -1;

    EtatImage foundedEtatImage = findByCode(etatImage.getCode());
    if(foundedEtatImage==null) return -1;
etatImageDao.delete(foundedEtatImage);
return 1;
}


public List<EtatImage> findByCriteria(EtatImageVo etatImageVo){

String query = "SELECT o FROM EtatImage o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",etatImageVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",etatImageVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",etatImageVo.getCode());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<EtatImage> etatImages){
if(ListUtil.isNotEmpty(etatImages)){
etatImages.forEach(e->etatImageDao.delete(e));
}
}
@Override
public void update(List<EtatImage> etatImages){
if(ListUtil.isNotEmpty(etatImages)){
etatImages.forEach(e->etatImageDao.save(e));
}
}





    }
