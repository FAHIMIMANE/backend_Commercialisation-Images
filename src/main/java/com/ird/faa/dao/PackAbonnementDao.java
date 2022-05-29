package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.PackAbonnement;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface PackAbonnementDao extends JpaRepository<PackAbonnement,Long> {



    @Query("SELECT item FROM PackAbonnement item ORDER BY item.dateMin ASC")
    List<PackAbonnement> findAll();

    PackAbonnement findByNombreImageMax(Double nombreImageMax);

    int deleteByNombreImageMax(Double nombreImageMax);



}
