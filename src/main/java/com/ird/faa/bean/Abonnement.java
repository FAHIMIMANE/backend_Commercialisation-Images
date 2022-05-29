package com.ird.faa.bean;

import java.util.Objects;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;



@Entity
@Table(name = "abonnement")
public class Abonnement   {

@Id
    @SequenceGenerator(name="abonnement_seq",sequenceName="abonnement_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="abonnement_seq")
private Long id;

            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateDebut ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateFin ;
            private Double tarif ;
            private Double reduction ;

    @ManyToOne
    private EtatAbonnement etatAbonnement ;
    @ManyToOne
    private Client client ;
    @ManyToOne
    private PackAbonnement packAbonnement ;


public Abonnement(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public Date getDateDebut(){
            return this.dateDebut;
            }
            public void setDateDebut(Date dateDebut){
            this.dateDebut = dateDebut;
            }
            public Date getDateFin(){
            return this.dateFin;
            }
            public void setDateFin(Date dateFin){
            this.dateFin = dateFin;
            }
            public Double getTarif(){
            return this.tarif;
            }
            public void setTarif(Double tarif){
            this.tarif = tarif;
            }
            public EtatAbonnement getEtatAbonnement(){
            return this.etatAbonnement;
            }
            public void setEtatAbonnement(EtatAbonnement etatAbonnement){
            this.etatAbonnement = etatAbonnement;
            }
            public Double getReduction(){
            return this.reduction;
            }
            public void setReduction(Double reduction){
            this.reduction = reduction;
            }
            public Client getClient(){
            return this.client;
            }
            public void setClient(Client client){
            this.client = client;
            }
            public PackAbonnement getPackAbonnement(){
            return this.packAbonnement;
            }
            public void setPackAbonnement(PackAbonnement packAbonnement){
            this.packAbonnement = packAbonnement;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abonnement abonnement = (Abonnement) o;
        return id != null && id.equals(abonnement.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

