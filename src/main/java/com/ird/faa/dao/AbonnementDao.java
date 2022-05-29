package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Abonnement;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface AbonnementDao extends JpaRepository<Abonnement,Long> {



    @Query("SELECT item FROM Abonnement item ORDER BY item.dateDebut ASC")
    List<Abonnement> findAll();


    List<Abonnement> findByEtatAbonnementCode(String code);
    int deleteByEtatAbonnementCode(String code);

    List<Abonnement> findByEtatAbonnementId(Long id);

    int deleteByEtatAbonnementId(Long id);
    List<Abonnement> findByClientNumeroMatricule(String numeroMatricule);
    int deleteByClientNumeroMatricule(String numeroMatricule);

    List<Abonnement> findByClientId(Long id);

    int deleteByClientId(Long id);
    List<Abonnement> findByPackAbonnementNombreImageMax(Double nombreImageMax);
    int deleteByPackAbonnementNombreImageMax(Double nombreImageMax);

    List<Abonnement> findByPackAbonnementId(Long id);

    int deleteByPackAbonnementId(Long id);


}
