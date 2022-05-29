package com.ird.faa.service.client.facade;

import java.util.List;
import com.ird.faa.bean.OffreReduction;
import com.ird.faa.ws.rest.provided.vo.OffreReductionVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface OffreReductionClientService extends AbstractService<OffreReduction,Long,OffreReductionVo>{



    /**
    * find OffreReduction from database by qteMin (reference)
    * @param qteMin - reference of OffreReduction
    * @return the founded OffreReduction , If no OffreReduction were
    *         found in database return  null.
    */
    OffreReduction findByQteMin(Double qteMin);

    /**
    * find OffreReduction from database by id (PK) or qteMin (reference)
    * @param id - id of OffreReduction
    * @param qteMin - reference of OffreReduction
    * @return the founded OffreReduction , If no OffreReduction were
    *         found in database return  null.
    */
    OffreReduction findByIdOrQteMin(OffreReduction offreReduction);


/**
    * delete OffreReduction from database
    * @param id - id of OffreReduction to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete OffreReduction from database by qteMin (reference)
    *
    * @param qteMin - reference of OffreReduction to be deleted
    * @return 1 if OffreReduction deleted successfully
    */
    int deleteByQteMin(Double qteMin);





}
