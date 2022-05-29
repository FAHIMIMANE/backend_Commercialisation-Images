package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.StateBucket;
import com.ird.faa.ws.rest.provided.vo.StateBucketVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface StateBucketAdminService extends AbstractService<StateBucket,Long,StateBucketVo>{



    /**
    * find StateBucket from database by code (reference)
    * @param code - reference of StateBucket
    * @return the founded StateBucket , If no StateBucket were
    *         found in database return  null.
    */
    StateBucket findByCode(String code);

    /**
    * find StateBucket from database by id (PK) or code (reference)
    * @param id - id of StateBucket
    * @param code - reference of StateBucket
    * @return the founded StateBucket , If no StateBucket were
    *         found in database return  null.
    */
    StateBucket findByIdOrCode(StateBucket stateBucket);


/**
    * delete StateBucket from database
    * @param id - id of StateBucket to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete StateBucket from database by code (reference)
    *
    * @param code - reference of StateBucket to be deleted
    * @return 1 if StateBucket deleted successfully
    */
    int deleteByCode(String code);





}
