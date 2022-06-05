package com.ird.faa.bean;

import java.util.Objects;
import java.util.List;


import javax.persistence.*;


@Entity
@Table(name = "image")
public class Image {

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private  String type;
    @Id
    @SequenceGenerator(name = "image_seq", sequenceName = "image_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_seq")
    private Long id;

    @Column(length = 500)
    private String reference;
    private Double prix;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(length = 500)
    private String extension;
    private Double taille;
    private Double resolution;

    @ManyToOne
    private Client client;
    @ManyToOne
    private Bucket bucket;
    @ManyToOne
    private TypeImage typeImage;

    @OneToMany(mappedBy = "image")
    private List<CategorieItem> categorieItems;

    public Image() {
        super();
    }

    public Image(String reference, String type, byte[] picByte) {
        this.reference = reference;
        this.type = type;
        this.picByte = picByte;
    }

    @Lob
    private byte[] picByte;

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

    public Double getPrix() {
        return this.prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExtension() {
        return this.extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Double getTaille() {
        return this.taille;
    }

    public void setTaille(Double taille) {
        this.taille = taille;
    }

    public Double getResolution() {
        return this.resolution;
    }

    public void setResolution(Double resolution) {
        this.resolution = resolution;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Bucket getBucket() {
        return this.bucket;
    }

    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
    }

    public List<CategorieItem> getCategorieItems() {
        return this.categorieItems;
    }

    public void setCategorieItems(List<CategorieItem> categorieItems) {
        this.categorieItems = categorieItems;
    }

    public TypeImage getTypeImage() {
        return this.typeImage;
    }

    public void setTypeImage(TypeImage typeImage) {
        this.typeImage = typeImage;
    }

    public byte[] getPicByte() {
        return picByte;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return id != null && id.equals(image.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

