package com.ird.faa.service.client.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.CategorieImage;
import com.ird.faa.dao.CategorieImageDao;
import com.ird.faa.service.client.facade.CategorieImageClientService;

import com.ird.faa.ws.rest.provided.vo.CategorieImageVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class CategorieImageClientServiceImpl extends AbstractServiceImpl<CategorieImage> implements CategorieImageClientService {

@Autowired
private CategorieImageDao categorieImageDao;



@Autowired
private EntityManager entityManager;


@Override
public List<CategorieImage> findAll(){
        return categorieImageDao.findAll();
}

@Override
public CategorieImage findById(Long id){
if(id==null) return null;
return categorieImageDao.getOne(id);
}

@Override
public CategorieImage findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(categorieImageDao.findById(id).isPresent())  {
categorieImageDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public CategorieImage update(CategorieImage categorieImage){
CategorieImage foundedCategorieImage = findById(categorieImage.getId());
if(foundedCategorieImage==null) return null;
else{
return  categorieImageDao.save(categorieImage);
}
}

@Override
public CategorieImage save (CategorieImage categorieImage){




    return categorieImageDao.save(categorieImage);


}

@Override
public List<CategorieImage> save(List<CategorieImage> categorieImages){
List<CategorieImage> list = new ArrayList<>();
for(CategorieImage categorieImage: categorieImages){
list.add(save(categorieImage));
}
return list;
}



@Override
@Transactional
public int delete(CategorieImage categorieImage){
    if(categorieImage.getId()==null) return -1;
    CategorieImage foundedCategorieImage = findById(categorieImage.getId());
    if(foundedCategorieImage==null) return -1;
categorieImageDao.delete(foundedCategorieImage);
return 1;
}


public List<CategorieImage> findByCriteria(CategorieImageVo categorieImageVo){

String query = "SELECT o FROM CategorieImage o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",categorieImageVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",categorieImageVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "description","LIKE",categorieImageVo.getDescription());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<CategorieImage> categorieImages){
if(ListUtil.isNotEmpty(categorieImages)){
categorieImages.forEach(e->categorieImageDao.delete(e));
}
}
@Override
public void update(List<CategorieImage> categorieImages){
if(ListUtil.isNotEmpty(categorieImages)){
categorieImages.forEach(e->categorieImageDao.save(e));
}
}





    }
