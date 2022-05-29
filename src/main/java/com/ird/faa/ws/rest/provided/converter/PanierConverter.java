package com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Panier;
import com.ird.faa.ws.rest.provided.vo.PanierVo;

@Component
public class PanierConverter extends AbstractConverter<Panier, PanierVo> {

    @Autowired
    private PanierItemConverter panierItemConverter;
    @Autowired
    private EtatPanierConverter etatPanierConverter;
    private Boolean etatPanier;
    private Boolean panierItems;

    public PanierConverter() {
        init(true);
    }

    @Override
    public Panier toItem(PanierVo vo) {
        if (vo == null) {
            return null;
        } else {
            Panier item = new Panier();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getReference()))
                item.setReference(vo.getReference());
            if (StringUtil.isNotEmpty(vo.getPrixTotal()))
                item.setPrixTotal(NumberUtil.toBigDecimal(vo.getPrixTotal()));
            if (vo.getEtatPanierVo() != null && this.etatPanier)
                item.setEtatPanier(etatPanierConverter.toItem(vo.getEtatPanierVo()));

            if (ListUtil.isNotEmpty(vo.getPanierItemsVo()) && this.panierItems)
                item.setPanierItems(panierItemConverter.toItem(vo.getPanierItemsVo()));

            return item;
        }
    }

    @Override
    public PanierVo toVo(Panier item) {
        if (item == null) {
            return null;
        } else {
            PanierVo vo = new PanierVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));

            if (StringUtil.isNotEmpty(item.getReference()))
                vo.setReference(item.getReference());

            if (item.getPrixTotal() != null)
                vo.setPrixTotal(NumberUtil.toString(item.getPrixTotal()));

            if (item.getEtatPanier() != null && this.etatPanier) {
                vo.setEtatPanierVo(etatPanierConverter.toVo(item.getEtatPanier()));
            }
            if (ListUtil.isNotEmpty(item.getPanierItems()) && this.panierItems) {
                panierItemConverter.init(true);
                panierItemConverter.setPanier(false);
                vo.setPanierItemsVo(panierItemConverter.toVo(item.getPanierItems()));
                panierItemConverter.setPanier(true);
            }

            return vo;
        }
    }

    public void init(Boolean value) {
        etatPanier = value;
        panierItems = value;
    }


    public PanierItemConverter getPanierItemConverter() {
        return this.panierItemConverter;
    }

    public void setPanierItemConverter(PanierItemConverter panierItemConverter) {
        this.panierItemConverter = panierItemConverter;
    }

    public EtatPanierConverter getEtatPanierConverter() {
        return this.etatPanierConverter;
    }

    public void setEtatPanierConverter(EtatPanierConverter etatPanierConverter) {
        this.etatPanierConverter = etatPanierConverter;
    }

    public boolean isEtatPanier() {
        return this.etatPanier;
    }

    public void setEtatPanier(boolean etatPanier) {
        this.etatPanier = etatPanier;
    }


    public Boolean isPanierItems() {
        return this.panierItems;
    }

    public void setPanierItems(Boolean panierItems) {
        this.panierItems = panierItems;
    }


}
