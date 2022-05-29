package com.ird.faa.service.client.facade;

import java.util.List;
import com.ird.faa.bean.TagBucket;
import com.ird.faa.ws.rest.provided.vo.TagBucketVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface TagBucketClientService extends AbstractService<TagBucket,Long,TagBucketVo>{





/**
    * delete TagBucket from database
    * @param id - id of TagBucket to be deleted
    *
    */
    int deleteById(Long id);



    List<TagBucket> findByBucketId(Long id);

    int deleteByBucketId(Long id);
    List<TagBucket> findByTagCode(String code);

    int deleteByTagCode(String code);

    List<TagBucket> findByTagId(Long id);

    int deleteByTagId(Long id);







}
