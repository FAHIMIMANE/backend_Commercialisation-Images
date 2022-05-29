package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.TagBucket;


@Repository
public interface TagBucketDao extends JpaRepository<TagBucket,Long> {






    List<TagBucket> findByBucketId(Long id);

    int deleteByBucketId(Long id);
    List<TagBucket> findByTagCode(String code);
    int deleteByTagCode(String code);

    List<TagBucket> findByTagId(Long id);

    int deleteByTagId(Long id);


}
