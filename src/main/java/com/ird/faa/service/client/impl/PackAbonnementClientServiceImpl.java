package com.ird.faa.service.client.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.PackAbonnement;
import com.ird.faa.dao.PackAbonnementDao;
import com.ird.faa.service.client.facade.PackAbonnementClientService;

import com.ird.faa.ws.rest.provided.vo.PackAbonnementVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class PackAbonnementClientServiceImpl extends AbstractServiceImpl<PackAbonnement> implements PackAbonnementClientService {

@Autowired
private PackAbonnementDao packAbonnementDao;



@Autowired
private EntityManager entityManager;


@Override
public List<PackAbonnement> findAll(){
        String query = "SELECT o FROM PackAbonnement o where 1=1 ";
        query+= " ORDER BY o.dateMin";
        return entityManager.createQuery(query).getResultList();
}
    @Override
    public PackAbonnement findByNombreImageMax(Double nombreImageMax){
    if( nombreImageMax==null) return null;
    return packAbonnementDao.findByNombreImageMax(nombreImageMax);
    }

    @Override
    @Transactional
    public int deleteByNombreImageMax(Double  nombreImageMax) {
    return packAbonnementDao.deleteByNombreImageMax(nombreImageMax);
    }
    @Override
    public PackAbonnement findByIdOrNombreImageMax(PackAbonnement packAbonnement){
    PackAbonnement resultat=null;
    if(packAbonnement != null){
    if(StringUtil.isNotEmpty(packAbonnement.getId())){
    resultat= packAbonnementDao.getOne(packAbonnement.getId());
    }else if(StringUtil.isNotEmpty(packAbonnement.getNombreImageMax())) {
    resultat= packAbonnementDao.findByNombreImageMax(packAbonnement.getNombreImageMax());
    }
    }
    return resultat;
    }

@Override
public PackAbonnement findById(Long id){
if(id==null) return null;
return packAbonnementDao.getOne(id);
}

@Override
public PackAbonnement findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(packAbonnementDao.findById(id).isPresent())  {
packAbonnementDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public PackAbonnement update(PackAbonnement packAbonnement){
PackAbonnement foundedPackAbonnement = findById(packAbonnement.getId());
if(foundedPackAbonnement==null) return null;
else{
return  packAbonnementDao.save(packAbonnement);
}
}

@Override
public PackAbonnement save (PackAbonnement packAbonnement){

    PackAbonnement result =null;
    PackAbonnement foundedPackAbonnement = findByNombreImageMax(packAbonnement.getNombreImageMax());
    if(foundedPackAbonnement == null){




    PackAbonnement savedPackAbonnement = packAbonnementDao.save(packAbonnement);

    result = savedPackAbonnement;
    }

    return result;
}

@Override
public List<PackAbonnement> save(List<PackAbonnement> packAbonnements){
List<PackAbonnement> list = new ArrayList<>();
for(PackAbonnement packAbonnement: packAbonnements){
list.add(save(packAbonnement));
}
return list;
}



@Override
@Transactional
public int delete(PackAbonnement packAbonnement){
    if(packAbonnement.getNombreImageMax()==null) return -1;

    PackAbonnement foundedPackAbonnement = findByNombreImageMax(packAbonnement.getNombreImageMax());
    if(foundedPackAbonnement==null) return -1;
packAbonnementDao.delete(foundedPackAbonnement);
return 1;
}


public List<PackAbonnement> findByCriteria(PackAbonnementVo packAbonnementVo){

String query = "SELECT o FROM PackAbonnement o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",packAbonnementVo.getId());
            query += SearchUtil.addConstraint( "o", "nombreImageMax","=",packAbonnementVo.getNombreImageMax());
            query += SearchUtil.addConstraint( "o", "reduction","=",packAbonnementVo.getReduction());
        query += SearchUtil.addConstraintDate( "o", "dateMin","=",packAbonnementVo.getDateMin());
        query += SearchUtil.addConstraintDate( "o", "dateMax","=",packAbonnementVo.getDateMax());
            query += SearchUtil.addConstraintMinMax("o","nombreImageMax",packAbonnementVo.getNombreImageMaxMin(),packAbonnementVo.getNombreImageMaxMax());
            query += SearchUtil.addConstraintMinMax("o","reduction",packAbonnementVo.getReductionMin(),packAbonnementVo.getReductionMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateMin",packAbonnementVo.getDateMinMin(),packAbonnementVo.getDateMinMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateMax",packAbonnementVo.getDateMaxMin(),packAbonnementVo.getDateMaxMax());
    query+= " ORDER BY o.dateMin";
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<PackAbonnement> packAbonnements){
if(ListUtil.isNotEmpty(packAbonnements)){
packAbonnements.forEach(e->packAbonnementDao.delete(e));
}
}
@Override
public void update(List<PackAbonnement> packAbonnements){
if(ListUtil.isNotEmpty(packAbonnements)){
packAbonnements.forEach(e->packAbonnementDao.save(e));
}
}





    }
