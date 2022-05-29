package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.TypeContrat;
import com.ird.faa.ws.rest.provided.vo.TypeContratVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TypeContratChercheurService extends AbstractService<TypeContrat,Long,TypeContratVo>{





/**
    * delete TypeContrat from database
    * @param id - id of TypeContrat to be deleted
    *
    */
    int deleteById(Long id);









}
