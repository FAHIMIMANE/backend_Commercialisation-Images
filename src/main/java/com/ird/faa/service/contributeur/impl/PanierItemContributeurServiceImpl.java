package com.ird.faa.service.contributeur.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.PanierItem;
        import com.ird.faa.bean.Image;
        import com.ird.faa.bean.Panier;
import com.ird.faa.dao.PanierItemDao;
import com.ird.faa.service.contributeur.facade.PanierItemContributeurService;
        import com.ird.faa.service.contributeur.facade.PanierContributeurService;
        import com.ird.faa.service.contributeur.facade.ImageContributeurService;

import com.ird.faa.ws.rest.provided.vo.PanierItemVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class PanierItemContributeurServiceImpl extends AbstractServiceImpl<PanierItem> implements PanierItemContributeurService {

@Autowired
private PanierItemDao panierItemDao;

        @Autowired
        private PanierContributeurService panierService ;
        @Autowired
        private ImageContributeurService imageService ;


@Autowired
private EntityManager entityManager;


@Override
public List<PanierItem> findAll(){
        return panierItemDao.findAll();
}

        @Override
        public List<PanierItem> findByImageReference(String reference){
        return panierItemDao.findByImageReference(reference);
        }

        @Override
        @Transactional
        public int deleteByImageReference(String reference){
        return panierItemDao.deleteByImageReference(reference);
        }

        @Override
        public List<PanierItem> findByImageId(Long id){
        return panierItemDao.findByImageId(id);
        }

        @Override
        @Transactional
        public int deleteByImageId(Long id){
        return panierItemDao.deleteByImageId(id);
        }

        @Override
        public List<PanierItem> findByPanierId(Long id){
        return panierItemDao.findByPanierId(id);
        }

        @Override
        @Transactional
        public int deleteByPanierId(Long id){
        return panierItemDao.deleteByPanierId(id);
        }


@Override
public PanierItem findById(Long id){
if(id==null) return null;
return panierItemDao.getOne(id);
}

@Override
public PanierItem findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(panierItemDao.findById(id).isPresent())  {
panierItemDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public PanierItem update(PanierItem panierItem){
PanierItem foundedPanierItem = findById(panierItem.getId());
if(foundedPanierItem==null) return null;
else{
return  panierItemDao.save(panierItem);
}
}

@Override
public PanierItem save (PanierItem panierItem){



    findImage(panierItem);
    findPanier(panierItem);

    return panierItemDao.save(panierItem);


}

@Override
public List<PanierItem> save(List<PanierItem> panierItems){
List<PanierItem> list = new ArrayList<>();
for(PanierItem panierItem: panierItems){
list.add(save(panierItem));
}
return list;
}



@Override
@Transactional
public int delete(PanierItem panierItem){
    if(panierItem.getId()==null) return -1;
    PanierItem foundedPanierItem = findById(panierItem.getId());
    if(foundedPanierItem==null) return -1;
panierItemDao.delete(foundedPanierItem);
return 1;
}


public List<PanierItem> findByCriteria(PanierItemVo panierItemVo){

String query = "SELECT o FROM PanierItem o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",panierItemVo.getId());
            query += SearchUtil.addConstraint( "o", "prix","=",panierItemVo.getPrix());
            query += SearchUtil.addConstraint( "o", "reduction","=",panierItemVo.getReduction());
            query += SearchUtil.addConstraint( "o", "prixApresReduction","=",panierItemVo.getPrixApresReduction());
            query += SearchUtil.addConstraintMinMax("o","prix",panierItemVo.getPrixMin(),panierItemVo.getPrixMax());
            query += SearchUtil.addConstraintMinMax("o","reduction",panierItemVo.getReductionMin(),panierItemVo.getReductionMax());
            query += SearchUtil.addConstraintMinMax("o","prixApresReduction",panierItemVo.getPrixApresReductionMin(),panierItemVo.getPrixApresReductionMax());
    if(panierItemVo.getImageVo()!=null){
        query += SearchUtil.addConstraint( "o", "image.id","=",panierItemVo.getImageVo().getId());
            query += SearchUtil.addConstraint( "o", "image.reference","LIKE",panierItemVo.getImageVo().getReference());
    }

    if(panierItemVo.getPanierVo()!=null){
        query += SearchUtil.addConstraint( "o", "panier.id","=",panierItemVo.getPanierVo().getId());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findImage(PanierItem panierItem){
        Image loadedImage =imageService.findByIdOrReference(panierItem.getImage());

    if(loadedImage==null ) {
    return;
    }
    panierItem.setImage(loadedImage);
    }
    private void findPanier(PanierItem panierItem){
        Panier loadedPanier = null;
        if(panierItem.getPanier() != null && panierItem.getPanier().getId() !=null)
        loadedPanier =panierService.findById(panierItem.getPanier().getId());

    if(loadedPanier==null ) {
    return;
    }
    panierItem.setPanier(loadedPanier);
    }

@Override
@Transactional
public void delete(List<PanierItem> panierItems){
if(ListUtil.isNotEmpty(panierItems)){
panierItems.forEach(e->panierItemDao.delete(e));
}
}
@Override
public void update(List<PanierItem> panierItems){
if(ListUtil.isNotEmpty(panierItems)){
panierItems.forEach(e->panierItemDao.save(e));
}
}





    }
