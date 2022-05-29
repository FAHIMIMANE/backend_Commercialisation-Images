package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.Paiement;
import com.ird.faa.ws.rest.provided.vo.PaiementVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface PaiementAdminService extends AbstractService<Paiement,Long,PaiementVo>{



    /**
    * find Paiement from database by code (reference)
    * @param code - reference of Paiement
    * @return the founded Paiement , If no Paiement were
    *         found in database return  null.
    */
    Paiement findByCode(String code);

    /**
    * find Paiement from database by id (PK) or code (reference)
    * @param id - id of Paiement
    * @param code - reference of Paiement
    * @return the founded Paiement , If no Paiement were
    *         found in database return  null.
    */
    Paiement findByIdOrCode(Paiement paiement);


/**
    * delete Paiement from database
    * @param id - id of Paiement to be deleted
    *
    */
    int deleteById(Long id);


    List<Paiement> findByOffreReductionQteMin(Double qteMin);

    int deleteByOffreReductionQteMin(Double qteMin);

    List<Paiement> findByOffreReductionId(Long id);

    int deleteByOffreReductionId(Long id);


    /**
    * delete Paiement from database by code (reference)
    *
    * @param code - reference of Paiement to be deleted
    * @return 1 if Paiement deleted successfully
    */
    int deleteByCode(String code);





}
