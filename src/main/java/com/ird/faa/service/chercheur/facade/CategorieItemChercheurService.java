package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.CategorieItem;
import com.ird.faa.ws.rest.provided.vo.CategorieItemVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface CategorieItemChercheurService extends AbstractService<CategorieItem,Long,CategorieItemVo>{





/**
    * delete CategorieItem from database
    * @param id - id of CategorieItem to be deleted
    *
    */
    int deleteById(Long id);


    List<CategorieItem> findByImageReference(String reference);

    int deleteByImageReference(String reference);

    List<CategorieItem> findByImageId(Long id);

    int deleteByImageId(Long id);

    List<CategorieItem> findByCategorieImageId(Long id);

    int deleteByCategorieImageId(Long id);







}
