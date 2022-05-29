package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.CategorieItem;


@Repository
public interface CategorieItemDao extends JpaRepository<CategorieItem,Long> {





    List<CategorieItem> findByImageReference(String reference);
    int deleteByImageReference(String reference);

    List<CategorieItem> findByImageId(Long id);

    int deleteByImageId(Long id);

    List<CategorieItem> findByCategorieImageId(Long id);

    int deleteByCategorieImageId(Long id);


}
