package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.PanierItem;
import com.ird.faa.ws.rest.provided.vo.PanierItemVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface PanierItemAdminService extends AbstractService<PanierItem,Long,PanierItemVo>{





/**
    * delete PanierItem from database
    * @param id - id of PanierItem to be deleted
    *
    */
    int deleteById(Long id);


    List<PanierItem> findByImageReference(String reference);

    int deleteByImageReference(String reference);

    List<PanierItem> findByImageId(Long id);

    int deleteByImageId(Long id);

    List<PanierItem> findByPanierId(Long id);

    int deleteByPanierId(Long id);







}
