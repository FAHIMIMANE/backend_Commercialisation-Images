package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Contract;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface ContractDao extends JpaRepository<Contract,Long> {



    @Query("SELECT item FROM Contract item ORDER BY item.dateDebut ASC")
    List<Contract> findAll();

    Contract findByReference(String reference);

    int deleteByReference(String reference);


    List<Contract> findByTypeContratId(Long id);

    int deleteByTypeContratId(Long id);


}
