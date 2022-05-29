package com.ird.faa.bean;

import java.util.Objects;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;



@Entity
@Table(name = "paiement")
public class Paiement   {

@Id
    @SequenceGenerator(name="paiement_seq",sequenceName="paiement_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="paiement_seq")
private Long id;

            @Column(length = 500)
            private String code;
            private Double montantHt ;
            private Double montantTtc ;
            private Double montantTva ;
            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date datePaiement ;
            private Double pourcentageReduction ;

    @ManyToOne
    private OffreReduction offreReduction ;


public Paiement(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public String getCode(){
            return this.code;
            }
            public void setCode(String code){
            this.code = code;
            }
            public Double getMontantHt(){
            return this.montantHt;
            }
            public void setMontantHt(Double montantHt){
            this.montantHt = montantHt;
            }
            public Double getMontantTtc(){
            return this.montantTtc;
            }
            public void setMontantTtc(Double montantTtc){
            this.montantTtc = montantTtc;
            }
            public Double getMontantTva(){
            return this.montantTva;
            }
            public void setMontantTva(Double montantTva){
            this.montantTva = montantTva;
            }
            public Date getDatePaiement(){
            return this.datePaiement;
            }
            public void setDatePaiement(Date datePaiement){
            this.datePaiement = datePaiement;
            }
            public Double getPourcentageReduction(){
            return this.pourcentageReduction;
            }
            public void setPourcentageReduction(Double pourcentageReduction){
            this.pourcentageReduction = pourcentageReduction;
            }
            public OffreReduction getOffreReduction(){
            return this.offreReduction;
            }
            public void setOffreReduction(OffreReduction offreReduction){
            this.offreReduction = offreReduction;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paiement paiement = (Paiement) o;
        return id != null && id.equals(paiement.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

