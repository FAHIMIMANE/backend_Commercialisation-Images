package com.ird.faa.service.contributeur.facade;

import java.util.List;
import com.ird.faa.bean.Bucket;
import com.ird.faa.ws.rest.provided.vo.BucketVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface BucketContributeurService extends AbstractService<Bucket,Long,BucketVo>{





/**
    * delete Bucket from database
    * @param id - id of Bucket to be deleted
    *
    */
    int deleteById(Long id);


    List<Bucket> findByStateBucketCode(String code);

    int deleteByStateBucketCode(String code);

    List<Bucket> findByStateBucketId(Long id);

    int deleteByStateBucketId(Long id);
    List<Bucket> findByContributeurNumeroMatricule(String numeroMatricule);

    int deleteByContributeurNumeroMatricule(String numeroMatricule);

    List<Bucket> findByContributeurId(Long id);

    int deleteByContributeurId(Long id);







}
