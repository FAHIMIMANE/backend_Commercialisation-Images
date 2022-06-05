package com.ird.faa.bean;

import java.util.Objects;


import javax.persistence.*;


@Entity
@Table(name = "categorie_image")
public class CategorieImage {

    @Id
    @SequenceGenerator(name = "categorie_image_seq", sequenceName = "categorie_image_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categorie_image_seq")
    private Long id;

    @Column(length = 500)
    private String libelle;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;


    public CategorieImage() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategorieImage categorieImage = (CategorieImage) o;
        return id != null && id.equals(categorieImage.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

