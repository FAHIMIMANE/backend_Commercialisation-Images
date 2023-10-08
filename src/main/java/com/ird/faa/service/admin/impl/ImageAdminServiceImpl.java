package com.ird.faa.service.admin.impl;

import java.util.Arrays;
import java.util.List;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

import com.ird.faa.bean.Image;
import com.ird.faa.bean.Client;
import com.ird.faa.bean.Bucket;
import com.ird.faa.bean.TypeImage;
import com.ird.faa.bean.CategorieItem;
import com.ird.faa.dao.ImageDao;
import com.ird.faa.service.admin.facade.ImageAdminService;
import com.ird.faa.service.admin.facade.BucketAdminService;
import com.ird.faa.service.admin.facade.CategorieItemAdminService;
import com.ird.faa.service.admin.facade.ClientAdminService;
import com.ird.faa.service.admin.facade.TypeImageAdminService;

import com.ird.faa.ws.rest.provided.vo.ImageVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class ImageAdminServiceImpl extends AbstractServiceImpl<Image> implements ImageAdminService {

    @Autowired
    private ImageDao imageDao;

    @Autowired
    private BucketAdminService bucketService;
    @Autowired
    private CategorieItemAdminService categorieItemService;
    @Autowired
    private ClientAdminService clientService;
    @Autowired
    private TypeImageAdminService typeImageService;


    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Image> findAll() {
        return imageDao.findAll();
    }

    @Override
    public List<Image> findByClientNumeroMatricule(String numeroMatricule) {
        return imageDao.findByClientNumeroMatricule(numeroMatricule);
    }
    @Override
    public Long countImageByType(String code) {
        return imageDao.countImageByType(code);
    }

    @Override
    @Transactional
    public int deleteByClientNumeroMatricule(String numeroMatricule) {
        return imageDao.deleteByClientNumeroMatricule(numeroMatricule);
    }

    @Override
    public List<Image> findByClientId(Long id) {
        return imageDao.findByClientId(id);
    }

    @Override
    @Transactional
    public int deleteByClientId(Long id) {
        return imageDao.deleteByClientId(id);
    }

    @Override
    public List<Image> findByBucketId(Long id) {
        return imageDao.findByBucketId(id);
    }

    @Override
    @Transactional
    public int deleteByBucketId(Long id) {
        return imageDao.deleteByBucketId(id);
    }


    @Override
    public List<Image> findByTypeImageCode(String code) {
        return imageDao.findByTypeImageCode(code);
    }

    @Override
    @Transactional
    public int deleteByTypeImageCode(String code) {
        return imageDao.deleteByTypeImageCode(code);
    }

    @Override
    public List<Image> findByTypeImageId(Long id) {
        return imageDao.findByTypeImageId(id);
    }

    @Override
    @Transactional
    public int deleteByTypeImageId(Long id) {
        return imageDao.deleteByTypeImageId(id);
    }

    @Override
    public Image findByReference(String reference) {
        if (reference == null) return null;
        return imageDao.findByReference(reference);
    }

    @Override
    public Image findByIdOrReference(Image image) {
        Image resultat = null;
        if (image != null) {
            if (StringUtil.isNotEmpty(image.getId())) {
                resultat = imageDao.getOne(image.getId());
            } else if (StringUtil.isNotEmpty(image.getReference())) {
                resultat = imageDao.findByReference(image.getReference());
            }
        }
        return resultat;
    }

    @Override
    public Image save(Image image) {
        Image result = null;
        Image foundedImage = findByReference(image.getReference());
        if (foundedImage == null) {


            findClient(image);
            findBucket(image);
            findTypeImage(image);

            Image savedImage = imageDao.save(image);

            saveCategorieItems(savedImage, image.getCategorieItems());
            result = savedImage;
        }

        return result;
    }

    @Override
    @Transactional
    public int deleteByReference(String reference) {
        return imageDao.deleteByReference(reference);
    }

    @Override
    public int save(Image[] images) {
        Arrays.stream(images).forEach(this::save);
        return 1;
    }


    @Override
    public Image findById(Long id) {
        if (id == null) return null;
        return imageDao.getOne(id);
    }

    @Override
    public Image findByIdWithAssociatedList(Long id) {
        Image image = findById(id);
        findAssociatedLists(image);
        return image;
    }

    private void findAssociatedLists(Image image) {
        if (image != null && image.getId() != null) {
            List<CategorieItem> categorieItems = categorieItemService.findByImageId(image.getId());
            image.setCategorieItems(categorieItems);
        }
    }

    private void deleteAssociatedLists(Long id) {
        if (id != null) {
            categorieItemService.deleteByImageId(id);
        }
    }

    private void updateAssociatedLists(Image image) {
        if (image != null && image.getId() != null) {
            List
                    <List<CategorieItem>> resultCategorieItems = categorieItemService.getToBeSavedAndToBeDeleted(categorieItemService.findByImageId(image.getId()), image.getCategorieItems());
            categorieItemService.delete(resultCategorieItems.get(1));
            associateCategorieItem(image, resultCategorieItems.get(0));
            categorieItemService.update(resultCategorieItems.get(0));

        }
    }

    @Transactional
    public int deleteById(Long id) {
        int res = 0;
        if (imageDao.findById(id).isPresent()) {
            deleteAssociatedLists(id);
            imageDao.deleteById(id);
            res = 1;
        }
        return res;
    }


    @Override
    public Image update(Image image) {
        Image foundedImage = findById(image.getId());
        if (foundedImage == null) return null;
        else {
            updateAssociatedLists(image);
            return imageDao.save(image);
        }
    }

//    @Override
//    public Image save(Image image) {
//
//        Image result = null;
//        Image foundedImage = findByReference(image.getReference());
//        if (foundedImage == null) {
//
//
//            findClient(image);
//            findBucket(image);
//            findTypeImage(image);
//
//            Image savedImage = imageDao.save(image);
//
//            saveCategorieItems(savedImage, image.getCategorieItems());
//            result = savedImage;
//        }
//
//        return result;
//    }
//@Override
//public Image save(Image image) {
//    Image result = null;
//    if (findByReference(image.getReference()) != null) return "ce nom deja existe";
//    else {
//        Image entity = imageDao.save(image);
//        Image savedImage = imageDao.save(image);
//        result = savedImage;
//    }
//    return result;
//}
    @Override
    public List<Image> save(List<Image> images) {
        List<Image> list = new ArrayList<>();
        for (Image image : images) {
            list.add(save(image));
        }
        return list;
    }

    private List<CategorieItem> prepareCategorieItems(Image image, List<CategorieItem> categorieItems) {
        for (CategorieItem categorieItem : categorieItems) {
            categorieItem.setImage(image);
        }
        return categorieItems;
    }


    @Override
    @Transactional
    public int delete(Image image) {
        if (image.getReference() == null) return -1;

        Image foundedImage = findByReference(image.getReference());
        if (foundedImage == null) return -1;
        imageDao.delete(foundedImage);
        return 1;
    }


    public List<Image> findByCriteria(ImageVo imageVo) {

        String query = "SELECT o FROM Image o where 1=1 ";

        query += SearchUtil.addConstraint("o", "id", "=", imageVo.getId());
        query += SearchUtil.addConstraint("o", "reference", "LIKE", imageVo.getReference());
        query += SearchUtil.addConstraint("o", "prix", "=", imageVo.getPrix());
        query += SearchUtil.addConstraint("o", "description", "LIKE", imageVo.getDescription());
        query += SearchUtil.addConstraint("o", "extension", "LIKE", imageVo.getExtension());
        query += SearchUtil.addConstraint("o", "taille", "=", imageVo.getTaille());
        query += SearchUtil.addConstraint("o", "resolution", "=", imageVo.getResolution());
        query += SearchUtil.addConstraintMinMax("o", "prix", imageVo.getPrixMin(), imageVo.getPrixMax());
        query += SearchUtil.addConstraintMinMax("o", "taille", imageVo.getTailleMin(), imageVo.getTailleMax());
        query += SearchUtil.addConstraintMinMax("o", "resolution", imageVo.getResolutionMin(), imageVo.getResolutionMax());
        if (imageVo.getClientVo() != null) {
            query += SearchUtil.addConstraint("o", "client.id", "=", imageVo.getClientVo().getId());
            query += SearchUtil.addConstraint("o", "client.numeroMatricule", "LIKE", imageVo.getClientVo().getNumeroMatricule());
        }

        if (imageVo.getBucketVo() != null) {
            query += SearchUtil.addConstraint("o", "bucket.id", "=", imageVo.getBucketVo().getId());
        }

        if (imageVo.getTypeImageVo() != null) {
            query += SearchUtil.addConstraint("o", "typeImage.id", "=", imageVo.getTypeImageVo().getId());
            query += SearchUtil.addConstraint("o", "typeImage.code", "LIKE", imageVo.getTypeImageVo().getCode());
        }

        return entityManager.createQuery(query).getResultList();
    }

    private void saveCategorieItems(Image image, List<CategorieItem> categorieItems) {

        if (ListUtil.isNotEmpty(image.getCategorieItems())) {
            List<CategorieItem> savedCategorieItems = new ArrayList<>();
            categorieItems.forEach(element -> {
                element.setImage(image);
                categorieItemService.save(element);
            });
            image.setCategorieItems(savedCategorieItems);
        }
    }

    private void findClient(Image image) {
        Client loadedClient = clientService.findByIdOrNumeroMatricule(image.getClient());

        if (loadedClient == null) {
            return;
        }
        image.setClient(loadedClient);
    }

    private void findBucket(Image image) {
        Bucket loadedBucket = null;
        if (image.getBucket() != null && image.getBucket().getId() != null)
            loadedBucket = bucketService.findById(image.getBucket().getId());

        if (loadedBucket == null) {
            return;
        }
        image.setBucket(loadedBucket);
    }

    private void findTypeImage(Image image) {
        TypeImage loadedTypeImage = typeImageService.findByIdOrCode(image.getTypeImage());

        if (loadedTypeImage == null) {
            return;
        }
        image.setTypeImage(loadedTypeImage);
    }

    @Override
    @Transactional
    public void delete(List<Image> images) {
        if (ListUtil.isNotEmpty(images)) {
            images.forEach(e -> imageDao.delete(e));
        }
    }

    @Override
    public void update(List<Image> images) {
        if (ListUtil.isNotEmpty(images)) {
            images.forEach(e -> imageDao.save(e));
        }
    }

    private void associateCategorieItem(Image image, List<CategorieItem> categorieItem) {
        if (ListUtil.isNotEmpty(categorieItem)) {
            categorieItem.forEach(e -> e.setImage(image));
        }
    }


}
