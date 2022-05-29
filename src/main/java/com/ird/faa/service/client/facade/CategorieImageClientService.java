package com.ird.faa.service.client.facade;

import java.util.List;
import com.ird.faa.bean.CategorieImage;
import com.ird.faa.ws.rest.provided.vo.CategorieImageVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface CategorieImageClientService extends AbstractService<CategorieImage,Long,CategorieImageVo>{





/**
    * delete CategorieImage from database
    * @param id - id of CategorieImage to be deleted
    *
    */
    int deleteById(Long id);









}
