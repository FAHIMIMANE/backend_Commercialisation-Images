package com.ird.faa.bean;

import java.util.Objects;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;



@Entity
@Table(name = "pack_abonnement")
public class PackAbonnement   {

@Id
    @SequenceGenerator(name="pack_abonnement_seq",sequenceName="pack_abonnement_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="pack_abonnement_seq")
private Long id;

            private Double nombreImageMax ;
            private Double reduction ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateMin ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateMax ;



public PackAbonnement(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public Double getNombreImageMax(){
            return this.nombreImageMax;
            }
            public void setNombreImageMax(Double nombreImageMax){
            this.nombreImageMax = nombreImageMax;
            }
            public Double getReduction(){
            return this.reduction;
            }
            public void setReduction(Double reduction){
            this.reduction = reduction;
            }
            public Date getDateMin(){
            return this.dateMin;
            }
            public void setDateMin(Date dateMin){
            this.dateMin = dateMin;
            }
            public Date getDateMax(){
            return this.dateMax;
            }
            public void setDateMax(Date dateMax){
            this.dateMax = dateMax;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PackAbonnement packAbonnement = (PackAbonnement) o;
        return id != null && id.equals(packAbonnement.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

