package com.ird.faa.bean;

import java.util.Objects;
import java.util.List;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;


@Entity
@Table(name = "bucket")
public class Bucket {

    @Id
    @SequenceGenerator(name = "bucket_seq", sequenceName = "bucket_seq",
            allocationSize = 1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bucket_seq")
    private Long id;

    @Column(length = 500)
    private String nom;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Column(length = 500)
    private String libelle;

    @ManyToOne
    private StateBucket stateBucket;
    @ManyToOne
    private Contributeur contributeur;

    @OneToMany(mappedBy = "bucket")
    private List<Image> images;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Bucket() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Image> getImages() {
        return this.images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDateCreation() {
        return this.dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public StateBucket getStateBucket() {
        return this.stateBucket;
    }

    public void setStateBucket(StateBucket stateBucket) {
        this.stateBucket = stateBucket;
    }

    public Contributeur getContributeur() {
        return this.contributeur;
    }

    public void setContributeur(Contributeur contributeur) {
        this.contributeur = contributeur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bucket bucket = (Bucket) o;
        return id != null && id.equals(bucket.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

