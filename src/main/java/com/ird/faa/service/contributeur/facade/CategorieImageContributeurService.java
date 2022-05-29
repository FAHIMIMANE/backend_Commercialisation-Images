package com.ird.faa.service.contributeur.facade;

import java.util.List;
import com.ird.faa.bean.CategorieImage;
import com.ird.faa.ws.rest.provided.vo.CategorieImageVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface CategorieImageContributeurService extends AbstractService<CategorieImage,Long,CategorieImageVo>{





/**
    * delete CategorieImage from database
    * @param id - id of CategorieImage to be deleted
    *
    */
    int deleteById(Long id);









}
