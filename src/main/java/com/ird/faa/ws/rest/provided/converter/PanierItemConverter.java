package com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.PanierItem;
import com.ird.faa.ws.rest.provided.vo.PanierItemVo;

@Component
public class PanierItemConverter extends AbstractConverter<PanierItem, PanierItemVo> {

    @Autowired
    private PanierConverter panierConverter;
    @Autowired
    private ImageConverter imageConverter;
    private Boolean image;
    private Boolean panier;

    public PanierItemConverter() {
        init(true);
    }

    @Override
    public PanierItem toItem(PanierItemVo vo) {
        if (vo == null) {
            return null;
        } else {
            PanierItem item = new PanierItem();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getPrix()))
                item.setPrix(NumberUtil.toBigDecimal(vo.getPrix()));
                item.setPrix(NumberUtil.toBigDecimal(vo.getPrix()));
            if (StringUtil.isNotEmpty(vo.getReduction()))
                item.setReduction(NumberUtil.toDouble(vo.getReduction()));
            if (StringUtil.isNotEmpty(vo.getPrixApresReduction()))
                item.setPrixApresReduction(NumberUtil.toDouble(vo.getPrixApresReduction()));
            if (vo.getImageVo() != null && this.image)
                item.setImage(imageConverter.toItem(vo.getImageVo()));
            if (vo.getPanierVo() != null && this.panier)
                item.setPanier(panierConverter.toItem(vo.getPanierVo()));


            return item;
        }
    }

    @Override
    public PanierItemVo toVo(PanierItem item) {
        if (item == null) {
            return null;
        } else {
            PanierItemVo vo = new PanierItemVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));

            if (item.getPrix() != null)
                vo.setPrix(NumberUtil.toString(item.getPrix()));

            if (item.getReduction() != null)
                vo.setReduction(NumberUtil.toString(item.getReduction()));

            if (item.getPrixApresReduction() != null)
                vo.setPrixApresReduction(NumberUtil.toString(item.getPrixApresReduction()));

            if (item.getImage() != null && this.image) {
                vo.setImageVo(imageConverter.toVo(item.getImage()));
            }
            if (item.getPanier() != null && this.panier) {
                vo.setPanierVo(panierConverter.toVo(item.getPanier()));
            }

            return vo;
        }
    }

    public void init(Boolean value) {
        image = value;
        panier = value;
    }


    public PanierConverter getPanierConverter() {
        return this.panierConverter;
    }

    public void setPanierConverter(PanierConverter panierConverter) {
        this.panierConverter = panierConverter;
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

    public boolean isPanier() {
        return this.panier;
    }

    public void setPanier(boolean panier) {
        this.panier = panier;
    }


}
