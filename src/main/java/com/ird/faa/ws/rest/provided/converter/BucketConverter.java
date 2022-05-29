package com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Bucket;
import com.ird.faa.ws.rest.provided.vo.BucketVo;

@Component
public class BucketConverter extends AbstractConverter<Bucket, BucketVo> {

    @Autowired
    private StateBucketConverter stateBucketConverter;
    @Autowired
    private ContributeurConverter contributeurConverter;
    @Autowired
    private ImageConverter imageConverter;
    private Boolean stateBucket;
    private Boolean contributeur;
    private Boolean images;

    public BucketConverter() {
        init(true);
    }


    @Override
    public Bucket toItem(BucketVo vo) {
        if (vo == null) {
            return null;
        } else {
            Bucket item = new Bucket();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getNom()))
                item.setNom(vo.getNom());
            if (StringUtil.isNotEmpty(vo.getDateCreation()))
                item.setDateCreation(DateUtil.parse(vo.getDateCreation()));
            if (StringUtil.isNotEmpty(vo.getLibelle()))
                item.setLibelle(vo.getLibelle());
            if (vo.getStateBucketVo() != null && this.stateBucket)
                item.setStateBucket(stateBucketConverter.toItem(vo.getStateBucketVo()));
            if (vo.getContributeurVo() != null && this.contributeur)
                item.setContributeur(contributeurConverter.toItem(vo.getContributeurVo()));

            if (ListUtil.isNotEmpty(vo.getImagesVo()) && this.images)
                item.setImages(imageConverter.toItem(vo.getImagesVo()));

            return item;
        }
    }

    @Override
    public BucketVo toVo(Bucket item) {
        if (item == null) {
            return null;
        } else {
            BucketVo vo = new BucketVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));

            if (StringUtil.isNotEmpty(item.getNom()))
                vo.setNom(item.getNom());

            if (item.getDateCreation() != null)
                vo.setDateCreation(DateUtil.formateDate(item.getDateCreation()));
            if (StringUtil.isNotEmpty(item.getLibelle()))
                vo.setLibelle(item.getLibelle());

            if (item.getStateBucket() != null && this.stateBucket) {
                vo.setStateBucketVo(stateBucketConverter.toVo(item.getStateBucket()));
            }
            if (item.getContributeur() != null && this.contributeur) {
                vo.setContributeurVo(contributeurConverter.toVo(item.getContributeur()));
            }
            if (ListUtil.isNotEmpty(item.getImages()) && this.images) {
                imageConverter.init(true);
                imageConverter.setBucket(false);
                vo.setImagesVo(imageConverter.toVo(item.getImages()));
                imageConverter.setBucket(true);
            }

            return vo;
        }
    }

    public void init(Boolean value) {
        stateBucket = value;
        contributeur = value;
        images = value;
    }


    public StateBucketConverter getStateBucketConverter() {
        return this.stateBucketConverter;
    }

    public void setStateBucketConverter(StateBucketConverter stateBucketConverter) {
        this.stateBucketConverter = stateBucketConverter;
    }

    public ContributeurConverter getContributeurConverter() {
        return this.contributeurConverter;
    }

    public void setContributeurConverter(ContributeurConverter contributeurConverter) {
        this.contributeurConverter = contributeurConverter;
    }

    public ImageConverter getImageConverter() {
        return this.imageConverter;
    }

    public void setImageConverter(ImageConverter imageConverter) {
        this.imageConverter = imageConverter;
    }

    public boolean isStateBucket() {
        return this.stateBucket;
    }

    public void setStateBucket(boolean stateBucket) {
        this.stateBucket = stateBucket;
    }

    public boolean isContributeur() {
        return this.contributeur;
    }

    public void setContributeur(boolean contributeur) {
        this.contributeur = contributeur;
    }


    public Boolean getImages() {
        return images;
    }

    public void setImages(Boolean images) {
        this.images = images;
    }
}
