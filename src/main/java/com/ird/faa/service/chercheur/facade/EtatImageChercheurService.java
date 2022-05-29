package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.EtatImage;
import com.ird.faa.ws.rest.provided.vo.EtatImageVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EtatImageChercheurService extends AbstractService<EtatImage,Long,EtatImageVo>{



    /**
    * find EtatImage from database by code (reference)
    * @param code - reference of EtatImage
    * @return the founded EtatImage , If no EtatImage were
    *         found in database return  null.
    */
    EtatImage findByCode(String code);

    /**
    * find EtatImage from database by id (PK) or code (reference)
    * @param id - id of EtatImage
    * @param code - reference of EtatImage
    * @return the founded EtatImage , If no EtatImage were
    *         found in database return  null.
    */
    EtatImage findByIdOrCode(EtatImage etatImage);


/**
    * delete EtatImage from database
    * @param id - id of EtatImage to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete EtatImage from database by code (reference)
    *
    * @param code - reference of EtatImage to be deleted
    * @return 1 if EtatImage deleted successfully
    */
    int deleteByCode(String code);





}
