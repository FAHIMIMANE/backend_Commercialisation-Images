package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.EtatAbonnement;
import com.ird.faa.ws.rest.provided.vo.EtatAbonnementVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EtatAbonnementAdminService extends AbstractService<EtatAbonnement,Long,EtatAbonnementVo>{



    /**
    * find EtatAbonnement from database by code (reference)
    * @param code - reference of EtatAbonnement
    * @return the founded EtatAbonnement , If no EtatAbonnement were
    *         found in database return  null.
    */
    EtatAbonnement findByCode(String code);

    /**
    * find EtatAbonnement from database by id (PK) or code (reference)
    * @param id - id of EtatAbonnement
    * @param code - reference of EtatAbonnement
    * @return the founded EtatAbonnement , If no EtatAbonnement were
    *         found in database return  null.
    */
    EtatAbonnement findByIdOrCode(EtatAbonnement etatAbonnement);


/**
    * delete EtatAbonnement from database
    * @param id - id of EtatAbonnement to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete EtatAbonnement from database by code (reference)
    *
    * @param code - reference of EtatAbonnement to be deleted
    * @return 1 if EtatAbonnement deleted successfully
    */
    int deleteByCode(String code);





}
