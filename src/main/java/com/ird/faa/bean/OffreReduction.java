package com.ird.faa.bean;

import java.util.Objects;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;



@Entity
@Table(name = "offre_reduction")
public class OffreReduction   {

@Id
    @SequenceGenerator(name="offre_reduction_seq",sequenceName="offre_reduction_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="offre_reduction_seq")
private Long id;

            private Double qteMin ;
            private Double qteMax ;
            private Double pourcentage ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateMin ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateMax ;



public OffreReduction(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public Double getQteMin(){
            return this.qteMin;
            }
            public void setQteMin(Double qteMin){
            this.qteMin = qteMin;
            }
            public Double getQteMax(){
            return this.qteMax;
            }
            public void setQteMax(Double qteMax){
            this.qteMax = qteMax;
            }
            public Double getPourcentage(){
            return this.pourcentage;
            }
            public void setPourcentage(Double pourcentage){
            this.pourcentage = pourcentage;
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
        OffreReduction offreReduction = (OffreReduction) o;
        return id != null && id.equals(offreReduction.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

