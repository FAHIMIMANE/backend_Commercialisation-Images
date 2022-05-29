package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.CategorieImage;


@Repository
public interface CategorieImageDao extends JpaRepository<CategorieImage,Long> {







}
