package com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Image;
import com.ird.faa.ws.rest.provided.vo.ImageVo;

@Component
public class ImageConverter extends AbstractConverter<Image, ImageVo> {

    @Autowired
    private BucketConverter bucketConverter;
    @Autowired
    private CategorieItemConverter categorieItemConverter;
    @Autowired
    private ClientConverter clientConverter;
    @Autowired
    private TypeImageConverter typeImageConverter;
    private Boolean client;
    private Boolean bucket;
    private Boolean typeImage;
    private Boolean categorieItems;

    public ImageConverter() {
        init(true);
    }

    @Override
    public Image toItem(ImageVo vo) {
        if (vo == null) {
            return null;
        } else {
            Image item = new Image();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getReference()))
                item.setReference(vo.getReference());
            if (StringUtil.isNotEmpty(vo.getPrix()))
                item.setPrix(NumberUtil.toDouble(vo.getPrix()));
            if (StringUtil.isNotEmpty(vo.getDescription()))
                item.setDescription(vo.getDescription());
            if (StringUtil.isNotEmpty(vo.getExtension()))
                item.setExtension(vo.getExtension());
            if (StringUtil.isNotEmpty(vo.getTaille()))
                item.setTaille(NumberUtil.toDouble(vo.getTaille()));
            if (StringUtil.isNotEmpty(vo.getResolution()))
                item.setResolution(NumberUtil.toDouble(vo.getResolution()));
            if (vo.getClientVo() != null && this.client)
                item.setClient(clientConverter.toItem(vo.getClientVo()));
            if (vo.getBucketVo() != null && this.bucket)
                item.setBucket(bucketConverter.toItem(vo.getBucketVo()));
            if (vo.getTypeImageVo() != null && this.typeImage)
                item.setTypeImage(typeImageConverter.toItem(vo.getTypeImageVo()));

            if (ListUtil.isNotEmpty(vo.getCategorieItemsVo()) && this.categorieItems)
                item.setCategorieItems(categorieItemConverter.toItem(vo.getCategorieItemsVo()));

            return item;
        }
    }

    @Override
    public ImageVo toVo(Image item) {
        if (item == null) {
            return null;
        } else {
            ImageVo vo = new ImageVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));

            if (StringUtil.isNotEmpty(item.getReference()))
                vo.setReference(item.getReference());

            if (item.getPrix() != null)
                vo.setPrix(NumberUtil.toString(item.getPrix()));

            if (StringUtil.isNotEmpty(item.getDescription()))
                vo.setDescription(item.getDescription());

            if (StringUtil.isNotEmpty(item.getExtension()))
                vo.setExtension(item.getExtension());

            if (item.getTaille() != null)
                vo.setTaille(NumberUtil.toString(item.getTaille()));

            if (item.getResolution() != null)
                vo.setResolution(NumberUtil.toString(item.getResolution()));

            if (item.getClient() != null && this.client) {
                vo.setClientVo(clientConverter.toVo(item.getClient()));
            }
            if (item.getBucket() != null && this.bucket) {
                vo.setBucketVo(bucketConverter.toVo(item.getBucket()));
            }
            if (item.getTypeImage() != null && this.typeImage) {
                vo.setTypeImageVo(typeImageConverter.toVo(item.getTypeImage()));
            }
            if (ListUtil.isNotEmpty(item.getCategorieItems()) && this.categorieItems) {
                categorieItemConverter.init(true);
                categorieItemConverter.setImage(false);
                vo.setCategorieItemsVo(categorieItemConverter.toVo(item.getCategorieItems()));
                categorieItemConverter.setImage(true);
            }

            return vo;
        }
    }

    public void init(Boolean value) {
        client = value;
        bucket = value;
        typeImage = value;
        categorieItems = value;
    }


    public BucketConverter getBucketConverter() {
        return this.bucketConverter;
    }

    public void setBucketConverter(BucketConverter bucketConverter) {
        this.bucketConverter = bucketConverter;
    }

    public CategorieItemConverter getCategorieItemConverter() {
        return this.categorieItemConverter;
    }

    public void setCategorieItemConverter(CategorieItemConverter categorieItemConverter) {
        this.categorieItemConverter = categorieItemConverter;
    }

    public ClientConverter getClientConverter() {
        return this.clientConverter;
    }

    public void setClientConverter(ClientConverter clientConverter) {
        this.clientConverter = clientConverter;
    }

    public TypeImageConverter getTypeImageConverter() {
        return this.typeImageConverter;
    }

    public void setTypeImageConverter(TypeImageConverter typeImageConverter) {
        this.typeImageConverter = typeImageConverter;
    }

    public boolean isClient() {
        return this.client;
    }

    public void setClient(boolean client) {
        this.client = client;
    }

    public boolean isBucket() {
        return this.bucket;
    }

    public void setBucket(boolean bucket) {
        this.bucket = bucket;
    }

    public boolean isTypeImage() {
        return this.typeImage;
    }

    public void setTypeImage(boolean typeImage) {
        this.typeImage = typeImage;
    }


    public Boolean isCategorieItems() {
        return this.categorieItems;
    }

    public void setCategorieItems(Boolean categorieItems) {
        this.categorieItems = categorieItems;
    }


}
