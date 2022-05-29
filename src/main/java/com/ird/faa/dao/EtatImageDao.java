package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.EtatImage;


@Repository
public interface EtatImageDao extends JpaRepository<EtatImage,Long> {




    EtatImage findByCode(String code);

    int deleteByCode(String code);



}
