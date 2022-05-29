package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.OffreReduction;
import com.ird.faa.dao.OffreReductionDao;
import com.ird.faa.service.chercheur.facade.OffreReductionChercheurService;

import com.ird.faa.ws.rest.provided.vo.OffreReductionVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class OffreReductionChercheurServiceImpl extends AbstractServiceImpl<OffreReduction> implements OffreReductionChercheurService {

@Autowired
private OffreReductionDao offreReductionDao;



@Autowired
private EntityManager entityManager;


@Override
public List<OffreReduction> findAll(){
        String query = "SELECT o FROM OffreReduction o where 1=1 ";
        query+= " ORDER BY o.dateMin";
        return entityManager.createQuery(query).getResultList();
}
    @Override
    public OffreReduction findByQteMin(Double qteMin){
    if( qteMin==null) return null;
    return offreReductionDao.findByQteMin(qteMin);
    }

    @Override
    @Transactional
    public int deleteByQteMin(Double  qteMin) {
    return offreReductionDao.deleteByQteMin(qteMin);
    }
    @Override
    public OffreReduction findByIdOrQteMin(OffreReduction offreReduction){
    OffreReduction resultat=null;
    if(offreReduction != null){
    if(StringUtil.isNotEmpty(offreReduction.getId())){
    resultat= offreReductionDao.getOne(offreReduction.getId());
    }else if(StringUtil.isNotEmpty(offreReduction.getQteMin())) {
    resultat= offreReductionDao.findByQteMin(offreReduction.getQteMin());
    }
    }
    return resultat;
    }

@Override
public OffreReduction findById(Long id){
if(id==null) return null;
return offreReductionDao.getOne(id);
}

@Override
public OffreReduction findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(offreReductionDao.findById(id).isPresent())  {
offreReductionDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public OffreReduction update(OffreReduction offreReduction){
OffreReduction foundedOffreReduction = findById(offreReduction.getId());
if(foundedOffreReduction==null) return null;
else{
return  offreReductionDao.save(offreReduction);
}
}

@Override
public OffreReduction save (OffreReduction offreReduction){

    OffreReduction result =null;
    OffreReduction foundedOffreReduction = findByQteMin(offreReduction.getQteMin());
    if(foundedOffreReduction == null){




    OffreReduction savedOffreReduction = offreReductionDao.save(offreReduction);

    result = savedOffreReduction;
    }

    return result;
}

@Override
public List<OffreReduction> save(List<OffreReduction> offreReductions){
List<OffreReduction> list = new ArrayList<>();
for(OffreReduction offreReduction: offreReductions){
list.add(save(offreReduction));
}
return list;
}



@Override
@Transactional
public int delete(OffreReduction offreReduction){
    if(offreReduction.getQteMin()==null) return -1;

    OffreReduction foundedOffreReduction = findByQteMin(offreReduction.getQteMin());
    if(foundedOffreReduction==null) return -1;
offreReductionDao.delete(foundedOffreReduction);
return 1;
}


public List<OffreReduction> findByCriteria(OffreReductionVo offreReductionVo){

String query = "SELECT o FROM OffreReduction o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",offreReductionVo.getId());
            query += SearchUtil.addConstraint( "o", "qteMin","=",offreReductionVo.getQteMin());
            query += SearchUtil.addConstraint( "o", "qteMax","=",offreReductionVo.getQteMax());
            query += SearchUtil.addConstraint( "o", "pourcentage","=",offreReductionVo.getPourcentage());
        query += SearchUtil.addConstraintDate( "o", "dateMin","=",offreReductionVo.getDateMin());
        query += SearchUtil.addConstraintDate( "o", "dateMax","=",offreReductionVo.getDateMax());
            query += SearchUtil.addConstraintMinMax("o","qteMin",offreReductionVo.getQteMinMin(),offreReductionVo.getQteMinMax());
            query += SearchUtil.addConstraintMinMax("o","qteMax",offreReductionVo.getQteMaxMin(),offreReductionVo.getQteMaxMax());
            query += SearchUtil.addConstraintMinMax("o","pourcentage",offreReductionVo.getPourcentageMin(),offreReductionVo.getPourcentageMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateMin",offreReductionVo.getDateMinMin(),offreReductionVo.getDateMinMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateMax",offreReductionVo.getDateMaxMin(),offreReductionVo.getDateMaxMax());
    query+= " ORDER BY o.dateMin";
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<OffreReduction> offreReductions){
if(ListUtil.isNotEmpty(offreReductions)){
offreReductions.forEach(e->offreReductionDao.delete(e));
}
}
@Override
public void update(List<OffreReduction> offreReductions){
if(ListUtil.isNotEmpty(offreReductions)){
offreReductions.forEach(e->offreReductionDao.save(e));
}
}





    }
