package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.TypeContrat;
import com.ird.faa.ws.rest.provided.vo.TypeContratVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TypeContratAdminService extends AbstractService<TypeContrat,Long,TypeContratVo>{





/**
    * delete TypeContrat from database
    * @param id - id of TypeContrat to be deleted
    *
    */
    int deleteById(Long id);









}
