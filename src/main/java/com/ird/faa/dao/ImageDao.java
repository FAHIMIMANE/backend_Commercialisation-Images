package com.ird.faa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.ird.faa.bean.Image;


@Repository
public interface ImageDao extends JpaRepository<Image,Long> {




    Image findByReference(String reference);

    int deleteByReference(String reference);

    List<Image> findByClientNumeroMatricule(String numeroMatricule);
    int deleteByClientNumeroMatricule(String numeroMatricule);

    List<Image> findByClientId(Long id);

    int deleteByClientId(Long id);

    List<Image> findByBucketId(Long id);

    int deleteByBucketId(Long id);
    List<Image> findByTypeImageCode(String code);
    int deleteByTypeImageCode(String code);

    List<Image> findByTypeImageId(Long id);

    int deleteByTypeImageId(Long id);


}
