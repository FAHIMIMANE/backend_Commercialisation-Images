package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.TypeContributeur;


@Repository
public interface TypeContributeurDao extends JpaRepository<TypeContributeur,Long> {




    TypeContributeur findByCode(String code);

    int deleteByCode(String code);



}
