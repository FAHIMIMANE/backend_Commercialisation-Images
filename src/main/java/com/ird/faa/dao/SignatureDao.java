package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Signature;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface SignatureDao extends JpaRepository<Signature,Long> {



    @Query("SELECT item FROM Signature item ORDER BY item.dateSignature ASC")
    List<Signature> findAll();


    List<Signature> findByContributeurNumeroMatricule(String numeroMatricule);
    int deleteByContributeurNumeroMatricule(String numeroMatricule);

    List<Signature> findByContributeurId(Long id);

    int deleteByContributeurId(Long id);
    List<Signature> findByContractReference(String reference);
    int deleteByContractReference(String reference);

    List<Signature> findByContractId(Long id);

    int deleteByContractId(Long id);


}
