package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.PanierItem;


@Repository
public interface PanierItemDao extends JpaRepository<PanierItem,Long> {





    List<PanierItem> findByImageReference(String reference);
    int deleteByImageReference(String reference);

    List<PanierItem> findByImageId(Long id);

    int deleteByImageId(Long id);

    List<PanierItem> findByPanierId(Long id);

    int deleteByPanierId(Long id);


}
