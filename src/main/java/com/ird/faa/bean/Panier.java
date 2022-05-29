package com.ird.faa.bean;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.List;


import javax.persistence.*;


@Entity
@Table(name = "panier")
public class Panier {

    @Id
    @SequenceGenerator(name = "panier_seq", sequenceName = "panier_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "panier_seq")
    private Long id;

    @Column(length = 500)
    private String reference;
    private BigDecimal prixTotal;

    @ManyToOne
    private EtatPanier etatPanier;

    @OneToMany(mappedBy = "panier")
    private List<PanierItem> panierItems;

    public Panier() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public BigDecimal getPrixTotal() {
        return this.prixTotal;
    }

    public void setPrixTotal(BigDecimal prixTotal) {
        this.prixTotal = prixTotal;
    }

    public EtatPanier getEtatPanier() {
        return this.etatPanier;
    }

    public void setEtatPanier(EtatPanier etatPanier) {
        this.etatPanier = etatPanier;
    }

    public List<PanierItem> getPanierItems() {
        return this.panierItems;
    }

    public void setPanierItems(List<PanierItem> panierItems) {
        this.panierItems = panierItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Panier panier = (Panier) o;
        return id != null && id.equals(panier.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

