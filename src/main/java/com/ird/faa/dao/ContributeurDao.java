package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Contributeur;


@Repository
public interface ContributeurDao extends JpaRepository<Contributeur,Long> {

    Contributeur findByUsername(String username);

    @Query("UPDATE Contributeur c SET c.enabled = true WHERE c.username = ?1")
    int updateEnabled(String username);


    Contributeur findByNumeroMatricule(String numeroMatricule);

    int deleteByNumeroMatricule(String numeroMatricule);



}
