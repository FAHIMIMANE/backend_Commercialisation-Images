package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.CategorieItem;
        import com.ird.faa.bean.Image;
        import com.ird.faa.bean.CategorieImage;
import com.ird.faa.dao.CategorieItemDao;
import com.ird.faa.service.chercheur.facade.CategorieItemChercheurService;
        import com.ird.faa.service.chercheur.facade.CategorieImageChercheurService;
        import com.ird.faa.service.chercheur.facade.ImageChercheurService;

import com.ird.faa.ws.rest.provided.vo.CategorieItemVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class CategorieItemChercheurServiceImpl extends AbstractServiceImpl<CategorieItem> implements CategorieItemChercheurService {

@Autowired
private CategorieItemDao categorieItemDao;

        @Autowired
        private CategorieImageChercheurService categorieImageService ;
        @Autowired
        private ImageChercheurService imageService ;


@Autowired
private EntityManager entityManager;


@Override
public List<CategorieItem> findAll(){
        return categorieItemDao.findAll();
}

        @Override
        public List<CategorieItem> findByImageReference(String reference){
        return categorieItemDao.findByImageReference(reference);
        }

        @Override
        @Transactional
        public int deleteByImageReference(String reference){
        return categorieItemDao.deleteByImageReference(reference);
        }

        @Override
        public List<CategorieItem> findByImageId(Long id){
        return categorieItemDao.findByImageId(id);
        }

        @Override
        @Transactional
        public int deleteByImageId(Long id){
        return categorieItemDao.deleteByImageId(id);
        }

        @Override
        public List<CategorieItem> findByCategorieImageId(Long id){
        return categorieItemDao.findByCategorieImageId(id);
        }

        @Override
        @Transactional
        public int deleteByCategorieImageId(Long id){
        return categorieItemDao.deleteByCategorieImageId(id);
        }


@Override
public CategorieItem findById(Long id){
if(id==null) return null;
return categorieItemDao.getOne(id);
}

@Override
public CategorieItem findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(categorieItemDao.findById(id).isPresent())  {
categorieItemDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public CategorieItem update(CategorieItem categorieItem){
CategorieItem foundedCategorieItem = findById(categorieItem.getId());
if(foundedCategorieItem==null) return null;
else{
return  categorieItemDao.save(categorieItem);
}
}

@Override
public CategorieItem save (CategorieItem categorieItem){



    findImage(categorieItem);
    findCategorieImage(categorieItem);

    return categorieItemDao.save(categorieItem);


}

@Override
public List<CategorieItem> save(List<CategorieItem> categorieItems){
List<CategorieItem> list = new ArrayList<>();
for(CategorieItem categorieItem: categorieItems){
list.add(save(categorieItem));
}
return list;
}



@Override
@Transactional
public int delete(CategorieItem categorieItem){
    if(categorieItem.getId()==null) return -1;
    CategorieItem foundedCategorieItem = findById(categorieItem.getId());
    if(foundedCategorieItem==null) return -1;
categorieItemDao.delete(foundedCategorieItem);
return 1;
}


public List<CategorieItem> findByCriteria(CategorieItemVo categorieItemVo){

String query = "SELECT o FROM CategorieItem o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",categorieItemVo.getId());
    if(categorieItemVo.getImageVo()!=null){
        query += SearchUtil.addConstraint( "o", "image.id","=",categorieItemVo.getImageVo().getId());
            query += SearchUtil.addConstraint( "o", "image.reference","LIKE",categorieItemVo.getImageVo().getReference());
    }

    if(categorieItemVo.getCategorieImageVo()!=null){
        query += SearchUtil.addConstraint( "o", "categorieImage.id","=",categorieItemVo.getCategorieImageVo().getId());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findImage(CategorieItem categorieItem){
        Image loadedImage =imageService.findByIdOrReference(categorieItem.getImage());

    if(loadedImage==null ) {
    return;
    }
    categorieItem.setImage(loadedImage);
    }
    private void findCategorieImage(CategorieItem categorieItem){
        CategorieImage loadedCategorieImage = null;
        if(categorieItem.getCategorieImage() != null && categorieItem.getCategorieImage().getId() !=null)
        loadedCategorieImage =categorieImageService.findById(categorieItem.getCategorieImage().getId());

    if(loadedCategorieImage==null ) {
    return;
    }
    categorieItem.setCategorieImage(loadedCategorieImage);
    }

@Override
@Transactional
public void delete(List<CategorieItem> categorieItems){
if(ListUtil.isNotEmpty(categorieItems)){
categorieItems.forEach(e->categorieItemDao.delete(e));
}
}
@Override
public void update(List<CategorieItem> categorieItems){
if(ListUtil.isNotEmpty(categorieItems)){
categorieItems.forEach(e->categorieItemDao.save(e));
}
}





    }
