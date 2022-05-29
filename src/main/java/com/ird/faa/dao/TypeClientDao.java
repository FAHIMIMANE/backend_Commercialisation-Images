package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.TypeClient;


@Repository
public interface TypeClientDao extends JpaRepository<TypeClient,Long> {




    TypeClient findByCode(String code);

    int deleteByCode(String code);



}
