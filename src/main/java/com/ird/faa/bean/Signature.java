package com.ird.faa.bean;

import java.util.Objects;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import javax.persistence.*;



@Entity
@Table(name = "signature")
public class Signature   {

@Id
    @SequenceGenerator(name="signature_seq",sequenceName="signature_seq",
    allocationSize=1, initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="signature_seq")
private Long id;

            @JsonFormat(pattern="yyyy-MM-dd")
            @Temporal(TemporalType.DATE)
            private Date dateSignature ;

    @ManyToOne
    private Contributeur contributeur ;
    @ManyToOne
    private Contract contract ;


public Signature(){
super();
}


            public Long getId(){
            return this.id;
            }
            public void setId(Long id){
            this.id = id;
            }
            public Date getDateSignature(){
            return this.dateSignature;
            }
            public void setDateSignature(Date dateSignature){
            this.dateSignature = dateSignature;
            }
            public Contributeur getContributeur(){
            return this.contributeur;
            }
            public void setContributeur(Contributeur contributeur){
            this.contributeur = contributeur;
            }
            public Contract getContract(){
            return this.contract;
            }
            public void setContract(Contract contract){
            this.contract = contract;
            }

        @Override
        public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Signature signature = (Signature) o;
        return id != null && id.equals(signature.id);
        }

        @Override
        public int hashCode() {
        return Objects.hash(id);
        }

}

