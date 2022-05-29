package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Bucket;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface BucketDao extends JpaRepository<Bucket,Long> {



    @Query("SELECT item FROM Bucket item ORDER BY item.dateCreation ASC")
    List<Bucket> findAll();


    List<Bucket> findByStateBucketCode(String code);
    int deleteByStateBucketCode(String code);

    List<Bucket> findByStateBucketId(Long id);

    int deleteByStateBucketId(Long id);
    List<Bucket> findByContributeurNumeroMatricule(String numeroMatricule);
    int deleteByContributeurNumeroMatricule(String numeroMatricule);

    List<Bucket> findByContributeurId(Long id);

    int deleteByContributeurId(Long id);


}
