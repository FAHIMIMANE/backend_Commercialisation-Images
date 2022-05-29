package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.EtatPanier;
import com.ird.faa.ws.rest.provided.vo.EtatPanierVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface EtatPanierAdminService extends AbstractService<EtatPanier,Long,EtatPanierVo>{



    /**
    * find EtatPanier from database by code (reference)
    * @param code - reference of EtatPanier
    * @return the founded EtatPanier , If no EtatPanier were
    *         found in database return  null.
    */
    EtatPanier findByCode(String code);

    /**
    * find EtatPanier from database by id (PK) or code (reference)
    * @param id - id of EtatPanier
    * @param code - reference of EtatPanier
    * @return the founded EtatPanier , If no EtatPanier were
    *         found in database return  null.
    */
    EtatPanier findByIdOrCode(EtatPanier etatPanier);


/**
    * delete EtatPanier from database
    * @param id - id of EtatPanier to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete EtatPanier from database by code (reference)
    *
    * @param code - reference of EtatPanier to be deleted
    * @return 1 if EtatPanier deleted successfully
    */
    int deleteByCode(String code);





}
