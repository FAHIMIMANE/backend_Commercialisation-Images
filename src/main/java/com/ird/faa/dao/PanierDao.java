package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Panier;


@Repository
public interface PanierDao extends JpaRepository<Panier,Long> {





    List<Panier> findByEtatPanierCode(String code);
    int deleteByEtatPanierCode(String code);

    List<Panier> findByEtatPanierId(Long id);

    int deleteByEtatPanierId(Long id);


}
