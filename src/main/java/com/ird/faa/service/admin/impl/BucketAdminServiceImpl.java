package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Bucket;
        import com.ird.faa.bean.StateBucket;
        import com.ird.faa.bean.Contributeur;
        import com.ird.faa.bean.Image;
import com.ird.faa.dao.BucketDao;
import com.ird.faa.service.admin.facade.BucketAdminService;
        import com.ird.faa.service.admin.facade.StateBucketAdminService;
        import com.ird.faa.service.admin.facade.ContributeurAdminService;
        import com.ird.faa.service.admin.facade.ImageAdminService;

import com.ird.faa.ws.rest.provided.vo.BucketVo;
import com.ird.faa.service.util.*;
        import com.ird.faa.bean.Image;
        import com.ird.faa.service.admin.facade.ImageAdminService;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class BucketAdminServiceImpl extends AbstractServiceImpl<Bucket> implements BucketAdminService {

@Autowired
private BucketDao bucketDao;

        @Autowired
        private StateBucketAdminService stateBucketService ;
        @Autowired
        private ContributeurAdminService contributeurService ;
        @Autowired
        private ImageAdminService imageService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Bucket> findAll(){
        String query = "SELECT o FROM Bucket o where 1=1 ";
        query+= " ORDER BY o.dateCreation";
        return entityManager.createQuery(query).getResultList();
}

        @Override
        public List<Bucket> findByStateBucketCode(String code){
        return bucketDao.findByStateBucketCode(code);
        }

        @Override
        @Transactional
        public int deleteByStateBucketCode(String code){
        return bucketDao.deleteByStateBucketCode(code);
        }

        @Override
        public List<Bucket> findByStateBucketId(Long id){
        return bucketDao.findByStateBucketId(id);
        }

        @Override
        @Transactional
        public int deleteByStateBucketId(Long id){
        return bucketDao.deleteByStateBucketId(id);
        }


        @Override
        public List<Bucket> findByContributeurNumeroMatricule(String numeroMatricule){
        return bucketDao.findByContributeurNumeroMatricule(numeroMatricule);
        }

        @Override
        @Transactional
        public int deleteByContributeurNumeroMatricule(String numeroMatricule){
        return bucketDao.deleteByContributeurNumeroMatricule(numeroMatricule);
        }

        @Override
        public List<Bucket> findByContributeurId(Long id){
        return bucketDao.findByContributeurId(id);
        }

        @Override
        @Transactional
        public int deleteByContributeurId(Long id){
        return bucketDao.deleteByContributeurId(id);
        }


@Override
public Bucket findById(Long id){
if(id==null) return null;
return bucketDao.getOne(id);
}

@Override
public Bucket findByIdWithAssociatedList(Long id){
    Bucket bucket  = findById(id);
    findAssociatedLists(bucket);
    return bucket;
}

    private void findAssociatedLists(Bucket bucket){
    if(bucket!=null && bucket.getId() != null) {
            List<Image> images = imageService.findByBucketId(bucket.getId());
            bucket.setImages(images);
    }
    }
    private void deleteAssociatedLists(Long id){
    if(id != null ) {
            imageService.deleteByBucketId(id);
    }
    }

    private void updateAssociatedLists(Bucket bucket){
    if(bucket !=null && bucket.getId() != null){
            List
            <List<Image>> resultImages= imageService.getToBeSavedAndToBeDeleted(imageService.findByBucketId(bucket.getId()),bucket.getImages());
            imageService.delete(resultImages.get(1));
            associateImage(bucket,resultImages.get(0));
            imageService.update(resultImages.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
int res=0;
if(bucketDao.findById(id).isPresent())  {
    deleteAssociatedLists(id);
bucketDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Bucket update(Bucket bucket){
Bucket foundedBucket = findById(bucket.getId());
if(foundedBucket==null) return null;
else{
    updateAssociatedLists(bucket);
return  bucketDao.save(bucket);
}
}

@Override
public Bucket save (Bucket bucket){

    Bucket result =null;


    findStateBucket(bucket);
    findContributeur(bucket);

    Bucket savedBucket = bucketDao.save(bucket);

        saveImages(savedBucket,bucket.getImages());
    result = savedBucket;

    return result;
}

@Override
public List<Bucket> save(List<Bucket> buckets){
List<Bucket> list = new ArrayList<>();
for(Bucket bucket: buckets){
list.add(save(bucket));
}
return list;
}

        private List<Image> prepareImages(Bucket bucket,List<Image> images){
        for(Image image:images ){
        image.setBucket(bucket);
        }
        return images;
        }


@Override
@Transactional
public int delete(Bucket bucket){
    if(bucket.getId()==null) return -1;
    Bucket foundedBucket = findById(bucket.getId());
    if(foundedBucket==null) return -1;
bucketDao.delete(foundedBucket);
return 1;
}


public List<Bucket> findByCriteria(BucketVo bucketVo){

String query = "SELECT o FROM Bucket o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",bucketVo.getId());
            query += SearchUtil.addConstraint( "o", "nom","LIKE",bucketVo.getNom());
        query += SearchUtil.addConstraintDate( "o", "dateCreation","=",bucketVo.getDateCreation());
            query += SearchUtil.addConstraint( "o", "libelle","LIKE",bucketVo.getLibelle());
            query += SearchUtil.addConstraintMinMaxDate("o","dateCreation",bucketVo.getDateCreationMin(),bucketVo.getDateCreationMax());
    if(bucketVo.getStateBucketVo()!=null){
        query += SearchUtil.addConstraint( "o", "stateBucket.id","=",bucketVo.getStateBucketVo().getId());
            query += SearchUtil.addConstraint( "o", "stateBucket.code","LIKE",bucketVo.getStateBucketVo().getCode());
    }

    if(bucketVo.getContributeurVo()!=null){
        query += SearchUtil.addConstraint( "o", "contributeur.id","=",bucketVo.getContributeurVo().getId());
            query += SearchUtil.addConstraint( "o", "contributeur.numeroMatricule","LIKE",bucketVo.getContributeurVo().getNumeroMatricule());
    }

    query+= " ORDER BY o.dateCreation";
return entityManager.createQuery(query).getResultList();
}
        private  void saveImages(Bucket bucket,List<Image> images){

        if (ListUtil.isNotEmpty(bucket.getImages())) {
        List<Image> savedImages = new ArrayList<>();
        images.forEach(element -> {
        element.setBucket(bucket);
         imageService.save(element);
        });
        bucket.setImages(savedImages);
        }
        }

    private void findStateBucket(Bucket bucket){
        StateBucket loadedStateBucket =stateBucketService.findByIdOrCode(bucket.getStateBucket());

    if(loadedStateBucket==null ) {
    return;
    }
    bucket.setStateBucket(loadedStateBucket);
    }
    private void findContributeur(Bucket bucket){
        Contributeur loadedContributeur =contributeurService.findByIdOrNumeroMatricule(bucket.getContributeur());

    if(loadedContributeur==null ) {
    return;
    }
    bucket.setContributeur(loadedContributeur);
    }

@Override
@Transactional
public void delete(List<Bucket> buckets){
if(ListUtil.isNotEmpty(buckets)){
buckets.forEach(e->bucketDao.delete(e));
}
}
@Override
public void update(List<Bucket> buckets){
if(ListUtil.isNotEmpty(buckets)){
buckets.forEach(e->bucketDao.save(e));
}
}

        private void associateImage(Bucket bucket, List<Image> image) {
        if (ListUtil.isNotEmpty(image)) {
        image.forEach(e -> e.setBucket(bucket));
        }
        }




    }
