package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.OffreReduction;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface OffreReductionDao extends JpaRepository<OffreReduction,Long> {



    @Query("SELECT item FROM OffreReduction item ORDER BY item.dateMin ASC")
    List<OffreReduction> findAll();

    OffreReduction findByQteMin(Double qteMin);

    int deleteByQteMin(Double qteMin);



}
