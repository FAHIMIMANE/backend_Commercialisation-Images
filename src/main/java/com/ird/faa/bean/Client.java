package com.ird.faa.bean;

import java.util.Objects;
import java.util.List;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;

import com.ird.faa.security.bean.User;


@Entity
@Table(name = "client")
public class Client extends User {


    public Client(String username) {
        super(username);
    }

    @Column(length = 500)
    private String numeroMatricule;
    @Column(length = 500)
    private String emailPrincipale;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String resume;

//    @Column(columnDefinition = "boolean default false")
//    private boolean credentialsNonExpired = false;
//    @Column(columnDefinition = "boolean default false")
//    private boolean enabled = false;
//    @Column(columnDefinition = "boolean default false")
//    private boolean accountNonExpired = false;
//    @Column(columnDefinition = "boolean default false")
//    private boolean accountNonLocked = false;
//    @Column(columnDefinition = "boolean default false")
//    private boolean passwordChanged = false;
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    @Temporal(TemporalType.DATE)
//    private Date createdAt;
//    @JsonFormat(pattern = "yyyy-MM-dd")
//    @Temporal(TemporalType.DATE)
//    private Date updatedAt;
//    @Column(length = 500)
//    private String username;
//    @Column(length = 500)
//    private String password;
//    @Column(length = 500)
//    private String prenom;
//    @Column(length = 500)
//    private String nom;
    @Column(length = 500)
    private String equivalenceAvecPanelErc;
    @Column(length = 500)
    private String baseHorizon;
    @Transient
    private String role;
    @Column(length = 500)
    private String numeroDeTel;
    @Column(length = 500)
    private String codePostal;
    @Column(length = 500)
    private String rib;

    public List<Bucket> getBuckets() {
        return buckets;
    }

    public void setBuckets(List<Bucket> buckets) {
        this.buckets = buckets;
    }

    @OneToMany(mappedBy = "client")
    private List<Bucket> buckets;

    @OneToMany(mappedBy = "client")
    private List<Image> images;

    public Client() {
        super();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroMatricule() {
        return this.numeroMatricule;
    }

    public void setNumeroMatricule(String numeroMatricule) {
        this.numeroMatricule = numeroMatricule;
    }

    public String getEmailPrincipale() {
        return this.emailPrincipale;
    }

    public void setEmailPrincipale(String emailPrincipale) {
        this.emailPrincipale = emailPrincipale;
    }

    public String getResume() {
        return this.resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

//    public boolean getCredentialsNonExpired() {
//        return this.credentialsNonExpired;
//    }
//
//    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
//        this.credentialsNonExpired = credentialsNonExpired;
//    }

//    public boolean getEnabled() {
//        return this.enabled;
//    }
//
//    public void setEnabled(boolean enabled) {
//        this.enabled = enabled;
//    }

//    public boolean getAccountNonExpired() {
//        return this.accountNonExpired;
//    }
//
//    public void setAccountNonExpired(boolean accountNonExpired) {
//        this.accountNonExpired = accountNonExpired;
//    }

//    public boolean getAccountNonLocked() {
//        return this.accountNonLocked;
//    }
//
//    public void setAccountNonLocked(boolean accountNonLocked) {
//        this.accountNonLocked = accountNonLocked;
//    }

//    public boolean getPasswordChanged() {
//        return this.passwordChanged;
//    }
//
//    public void setPasswordChanged(boolean passwordChanged) {
//        this.passwordChanged = passwordChanged;
//    }
//
//    public Date getCreatedAt() {
//        return this.createdAt;
//    }
//
//    public void setCreatedAt(Date createdAt) {
//        this.createdAt = createdAt;
//    }
//
//    public Date getUpdatedAt() {
//        return this.updatedAt;
//    }
//
//    public void setUpdatedAt(Date updatedAt) {
//        this.updatedAt = updatedAt;
//    }
//
//    public String getUsername() {
//        return this.username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }

//    public String getPassword() {
//        return this.password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getPrenom() {
//        return this.prenom;
//    }
//
//    public void setPrenom(String prenom) {
//        this.prenom = prenom;
//    }

//    public String getNom() {
//        return this.nom;
//    }
//
//    public void setNom(String nom) {
//        this.nom = nom;
//    }

    public String getEquivalenceAvecPanelErc() {
        return this.equivalenceAvecPanelErc;
    }

    public void setEquivalenceAvecPanelErc(String equivalenceAvecPanelErc) {
        this.equivalenceAvecPanelErc = equivalenceAvecPanelErc;
    }

    public String getBaseHorizon() {
        return this.baseHorizon;
    }

    public void setBaseHorizon(String baseHorizon) {
        this.baseHorizon = baseHorizon;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNumeroDeTel() {
        return this.numeroDeTel;
    }

    public void setNumeroDeTel(String numeroDeTel) {
        this.numeroDeTel = numeroDeTel;
    }

    public List<Image> getImages() {
        return this.images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getCodePostal() {
        return this.codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getRib() {
        return this.rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id != null && id.equals(client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

