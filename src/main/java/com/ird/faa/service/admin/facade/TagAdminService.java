package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.Tag;
import com.ird.faa.ws.rest.provided.vo.TagVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TagAdminService extends AbstractService<Tag,Long,TagVo>{



    /**
    * find Tag from database by code (reference)
    * @param code - reference of Tag
    * @return the founded Tag , If no Tag were
    *         found in database return  null.
    */
    Tag findByCode(String code);

    /**
    * find Tag from database by id (PK) or code (reference)
    * @param id - id of Tag
    * @param code - reference of Tag
    * @return the founded Tag , If no Tag were
    *         found in database return  null.
    */
    Tag findByIdOrCode(Tag tag);


/**
    * delete Tag from database
    * @param id - id of Tag to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete Tag from database by code (reference)
    *
    * @param code - reference of Tag to be deleted
    * @return 1 if Tag deleted successfully
    */
    int deleteByCode(String code);





}
