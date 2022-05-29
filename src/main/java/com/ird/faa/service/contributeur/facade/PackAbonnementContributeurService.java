package com.ird.faa.service.contributeur.facade;

import java.util.List;
import com.ird.faa.bean.PackAbonnement;
import com.ird.faa.ws.rest.provided.vo.PackAbonnementVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface PackAbonnementContributeurService extends AbstractService<PackAbonnement,Long,PackAbonnementVo>{



    /**
    * find PackAbonnement from database by nombreImageMax (reference)
    * @param nombreImageMax - reference of PackAbonnement
    * @return the founded PackAbonnement , If no PackAbonnement were
    *         found in database return  null.
    */
    PackAbonnement findByNombreImageMax(Double nombreImageMax);

    /**
    * find PackAbonnement from database by id (PK) or nombreImageMax (reference)
    * @param id - id of PackAbonnement
    * @param nombreImageMax - reference of PackAbonnement
    * @return the founded PackAbonnement , If no PackAbonnement were
    *         found in database return  null.
    */
    PackAbonnement findByIdOrNombreImageMax(PackAbonnement packAbonnement);


/**
    * delete PackAbonnement from database
    * @param id - id of PackAbonnement to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete PackAbonnement from database by nombreImageMax (reference)
    *
    * @param nombreImageMax - reference of PackAbonnement to be deleted
    * @return 1 if PackAbonnement deleted successfully
    */
    int deleteByNombreImageMax(Double nombreImageMax);





}
