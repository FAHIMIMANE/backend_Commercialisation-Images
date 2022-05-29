package com.ird.faa.service.contributeur.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.TypePaiement;
import com.ird.faa.dao.TypePaiementDao;
import com.ird.faa.service.contributeur.facade.TypePaiementContributeurService;

import com.ird.faa.ws.rest.provided.vo.TypePaiementVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class TypePaiementContributeurServiceImpl extends AbstractServiceImpl<TypePaiement> implements TypePaiementContributeurService {

@Autowired
private TypePaiementDao typePaiementDao;



@Autowired
private EntityManager entityManager;


@Override
public List<TypePaiement> findAll(){
        return typePaiementDao.findAll();
}
    @Override
    public TypePaiement findByCode(String code){
    if( code==null) return null;
    return typePaiementDao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String  code) {
    return typePaiementDao.deleteByCode(code);
    }
    @Override
    public TypePaiement findByIdOrCode(TypePaiement typePaiement){
    TypePaiement resultat=null;
    if(typePaiement != null){
    if(StringUtil.isNotEmpty(typePaiement.getId())){
    resultat= typePaiementDao.getOne(typePaiement.getId());
    }else if(StringUtil.isNotEmpty(typePaiement.getCode())) {
    resultat= typePaiementDao.findByCode(typePaiement.getCode());
    }
    }
    return resultat;
    }

@Override
public TypePaiement findById(Long id){
if(id==null) return null;
return typePaiementDao.getOne(id);
}

@Override
public TypePaiement findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(typePaiementDao.findById(id).isPresent())  {
typePaiementDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public TypePaiement update(TypePaiement typePaiement){
TypePaiement foundedTypePaiement = findById(typePaiement.getId());
if(foundedTypePaiement==null) return null;
else{
return  typePaiementDao.save(typePaiement);
}
}

@Override
public TypePaiement save (TypePaiement typePaiement){

    TypePaiement result =null;
    TypePaiement foundedTypePaiement = findByCode(typePaiement.getCode());
    if(foundedTypePaiement == null){




    TypePaiement savedTypePaiement = typePaiementDao.save(typePaiement);

    result = savedTypePaiement;
    }

    return result;
}

@Override
public List<TypePaiement> save(List<TypePaiement> typePaiements){
List<TypePaiement> list = new ArrayList<>();
for(TypePaiement typePaiement: typePaiements){
list.add(save(typePaiement));
}
return list;
}



@Override
@Transactional
public int delete(TypePaiement typePaiement){
    if(typePaiement.getCode()==null) return -1;

    TypePaiement foundedTypePaiement = findByCode(typePaiement.getCode());
    if(foundedTypePaiement==null) return -1;
typePaiementDao.delete(foundedTypePaiement);
return 1;
}


public List<TypePaiement> findByCriteria(TypePaiementVo typePaiementVo){

String query = "SELECT o FROM TypePaiement o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",typePaiementVo.getId());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",typePaiementVo.getLibelle());
            query += SearchUtil.addConstraint( "o", "code","LIKE",typePaiementVo.getCode());
return entityManager.createQuery(query).getResultList();
}


@Override
@Transactional
public void delete(List<TypePaiement> typePaiements){
if(ListUtil.isNotEmpty(typePaiements)){
typePaiements.forEach(e->typePaiementDao.delete(e));
}
}
@Override
public void update(List<TypePaiement> typePaiements){
if(ListUtil.isNotEmpty(typePaiements)){
typePaiements.forEach(e->typePaiementDao.save(e));
}
}





    }
