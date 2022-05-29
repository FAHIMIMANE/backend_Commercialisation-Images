package com.ird.faa.service.contributeur.facade;

import java.util.List;
import com.ird.faa.bean.TypeContributeur;
import com.ird.faa.ws.rest.provided.vo.TypeContributeurVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TypeContributeurContributeurService extends AbstractService<TypeContributeur,Long,TypeContributeurVo>{



    /**
    * find TypeContributeur from database by code (reference)
    * @param code - reference of TypeContributeur
    * @return the founded TypeContributeur , If no TypeContributeur were
    *         found in database return  null.
    */
    TypeContributeur findByCode(String code);

    /**
    * find TypeContributeur from database by id (PK) or code (reference)
    * @param id - id of TypeContributeur
    * @param code - reference of TypeContributeur
    * @return the founded TypeContributeur , If no TypeContributeur were
    *         found in database return  null.
    */
    TypeContributeur findByIdOrCode(TypeContributeur typeContributeur);


/**
    * delete TypeContributeur from database
    * @param id - id of TypeContributeur to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete TypeContributeur from database by code (reference)
    *
    * @param code - reference of TypeContributeur to be deleted
    * @return 1 if TypeContributeur deleted successfully
    */
    int deleteByCode(String code);





}
