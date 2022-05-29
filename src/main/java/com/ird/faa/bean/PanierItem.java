package com.ird.faa.bean;

import java.math.BigDecimal;
import java.util.Objects;


import javax.persistence.*;


@Entity
@Table(name = "panier_item")
public class PanierItem {

    @Id
    @SequenceGenerator(name = "panier_item_seq", sequenceName = "panier_item_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "panier_item_seq")
    private Long id;

    private BigDecimal prix;
    private Double reduction;
    private Double prixApresReduction;

    @ManyToOne
    private Image image;
    @ManyToOne
    private Panier panier;


    public PanierItem() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Panier getPanier() {
        return this.panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    public BigDecimal getPrix() {
        return this.prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public Double getReduction() {
        return this.reduction;
    }

    public void setReduction(Double reduction) {
        this.reduction = reduction;
    }

    public Double getPrixApresReduction() {
        return this.prixApresReduction;
    }

    public void setPrixApresReduction(Double prixApresReduction) {
        this.prixApresReduction = prixApresReduction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PanierItem panierItem = (PanierItem) o;
        return id != null && id.equals(panierItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

