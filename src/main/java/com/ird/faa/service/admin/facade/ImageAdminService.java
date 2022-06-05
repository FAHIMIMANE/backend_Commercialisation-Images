package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.Image;
import com.ird.faa.ws.rest.provided.vo.ImageVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface ImageAdminService extends AbstractService<Image,Long,ImageVo>{



    /**
    * find Image from database by reference (reference)
    * @param reference - reference of Image
    * @return the founded Image , If no Image were
    *         found in database return  null.
    */
    Image findByReference(String reference);

    /**
    * find Image from database by id (PK) or reference (reference)
    * @param id - id of Image
    * @param reference - reference of Image
    * @param image
     * @return the founded Image , If no Image were
    *         found in database return  null.
    */
    Image findByIdOrReference(Image image);

    Image save(Image image);
    int save(Image[] images);

    /**
    * delete Image from database
    * @param id - id of Image to be deleted
    *
    */
    int deleteById(Long id);


    List<Image> findByClientNumeroMatricule(String numeroMatricule);

    int deleteByClientNumeroMatricule(String numeroMatricule);

    List<Image> findByClientId(Long id);

    int deleteByClientId(Long id);

    List<Image> findByBucketId(Long id);

    int deleteByBucketId(Long id);
    List<Image> findByTypeImageCode(String code);

    int deleteByTypeImageCode(String code);

    List<Image> findByTypeImageId(Long id);

    int deleteByTypeImageId(Long id);


    /**
    * delete Image from database by reference (reference)
    *
    * @param reference - reference of Image to be deleted
    * @return 1 if Image deleted successfully
    */
    int deleteByReference(String reference);





}
