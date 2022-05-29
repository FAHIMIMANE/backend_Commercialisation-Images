package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.TypePaiement;
import com.ird.faa.ws.rest.provided.vo.TypePaiementVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TypePaiementChercheurService extends AbstractService<TypePaiement,Long,TypePaiementVo>{



    /**
    * find TypePaiement from database by code (reference)
    * @param code - reference of TypePaiement
    * @return the founded TypePaiement , If no TypePaiement were
    *         found in database return  null.
    */
    TypePaiement findByCode(String code);

    /**
    * find TypePaiement from database by id (PK) or code (reference)
    * @param id - id of TypePaiement
    * @param code - reference of TypePaiement
    * @return the founded TypePaiement , If no TypePaiement were
    *         found in database return  null.
    */
    TypePaiement findByIdOrCode(TypePaiement typePaiement);


/**
    * delete TypePaiement from database
    * @param id - id of TypePaiement to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete TypePaiement from database by code (reference)
    *
    * @param code - reference of TypePaiement to be deleted
    * @return 1 if TypePaiement deleted successfully
    */
    int deleteByCode(String code);





}
