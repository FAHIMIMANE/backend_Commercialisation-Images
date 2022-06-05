package com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.CategorieItem;
import com.ird.faa.ws.rest.provided.vo.CategorieItemVo;

@Component
public class CategorieItemConverter extends AbstractConverter<CategorieItem, CategorieItemVo> {

    @Autowired
    private CategorieImageConverter categorieImageConverter;
    @Autowired
    private ImageConverter imageConverter;
    private Boolean image;
    private Boolean categorieImage;

    public CategorieItemConverter() {
        init(true);
    }

    @Override
    public CategorieItem toItem(CategorieItemVo vo) {
        if (vo == null) {
            return null;
        } else {
            CategorieItem item = new CategorieItem();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (vo.getImageVo() != null && this.image)
                item.setImage(imageConverter.toItem(vo.getImageVo()));
            if (vo.getCategorieImageVo() != null && this.categorieImage)
                item.setCategorieImage(categorieImageConverter.toItem(vo.getCategorieImageVo()));


            return item;
        }
    }

    @Override
    public CategorieItemVo toVo(CategorieItem item) {
        if (item == null) {
            return null;
        } else {
            CategorieItemVo vo = new CategorieItemVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));

            if (item.getImage() != null && this.image) {
                vo.setImageVo(imageConverter.toVo(item.getImage()));
            }
            if (item.getCategorieImage() != null && this.categorieImage) {
                vo.setCategorieImageVo(categorieImageConverter.toVo(item.getCategorieImage()));
            }

            return vo;
        }
    }

    public void init(Boolean value) {
        image = value;
        categorieImage = value;
    }


    public CategorieImageConverter getCategorieImageConverter() {
        return this.categorieImageConverter;
    }

    public void setCategorieImageConverter(CategorieImageConverter categorieImageConverter) {
        this.categorieImageConverter = categorieImageConverter;
    }

    public ImageConverter getImageConverter() {
        return this.imageConverter;
    }

    public void setImageConverter(ImageConverter imageConverter) {
        this.imageConverter = imageConverter;
    }

    public boolean isImage() {
        return this.image;
    }

    public void setImage(boolean image) {
        this.image = image;
    }

    public boolean isCategorieImage() {
        return this.categorieImage;
    }

    public void setCategorieImage(boolean categorieImage) {
        this.categorieImage = categorieImage;
    }


}
