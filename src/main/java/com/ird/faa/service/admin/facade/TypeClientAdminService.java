package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.TypeClient;
import com.ird.faa.ws.rest.provided.vo.TypeClientVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TypeClientAdminService extends AbstractService<TypeClient,Long,TypeClientVo>{



    /**
    * find TypeClient from database by code (reference)
    * @param code - reference of TypeClient
    * @return the founded TypeClient , If no TypeClient were
    *         found in database return  null.
    */
    TypeClient findByCode(String code);

    /**
    * find TypeClient from database by id (PK) or code (reference)
    * @param id - id of TypeClient
    * @param code - reference of TypeClient
    * @return the founded TypeClient , If no TypeClient were
    *         found in database return  null.
    */
    TypeClient findByIdOrCode(TypeClient typeClient);


/**
    * delete TypeClient from database
    * @param id - id of TypeClient to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete TypeClient from database by code (reference)
    *
    * @param code - reference of TypeClient to be deleted
    * @return 1 if TypeClient deleted successfully
    */
    int deleteByCode(String code);





}
