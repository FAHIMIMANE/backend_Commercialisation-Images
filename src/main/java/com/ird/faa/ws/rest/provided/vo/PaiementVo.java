package  com.ird.faa.ws.rest.provided.vo;

    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;

public class PaiementVo {

    private String id ;
    private String code ;
    private String montantHt ;
    private String montantTtc ;
    private String montantTva ;
    private String datePaiement ;
    private String pourcentageReduction ;


            private String montantHtMax ;
            private String montantHtMin ;
            private String montantTtcMax ;
            private String montantTtcMin ;
            private String montantTvaMax ;
            private String montantTvaMin ;
            private String datePaiementMax ;
            private String datePaiementMin ;
            private String pourcentageReductionMax ;
            private String pourcentageReductionMin ;

        private OffreReductionVo offreReductionVo ;


    public PaiementVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getCode(){
        return this.code;
        }

        public void setCode(String code){
        this.code = code;
        }
        public String getMontantHt(){
        return this.montantHt;
        }

        public void setMontantHt(String montantHt){
        this.montantHt = montantHt;
        }
        public String getMontantTtc(){
        return this.montantTtc;
        }

        public void setMontantTtc(String montantTtc){
        this.montantTtc = montantTtc;
        }
        public String getMontantTva(){
        return this.montantTva;
        }

        public void setMontantTva(String montantTva){
        this.montantTva = montantTva;
        }
        public String getDatePaiement(){
        return this.datePaiement;
        }

        public void setDatePaiement(String datePaiement){
        this.datePaiement = datePaiement;
        }
        public String getPourcentageReduction(){
        return this.pourcentageReduction;
        }

        public void setPourcentageReduction(String pourcentageReduction){
        this.pourcentageReduction = pourcentageReduction;
        }


            public String getMontantHtMax(){
            return this.montantHtMax;
            }

            public String getMontantHtMin(){
            return this.montantHtMin;
            }

            public void setMontantHtMax(String montantHtMax){
            this.montantHtMax = montantHtMax;
            }

            public void setMontantHtMin(String montantHtMin){
            this.montantHtMin = montantHtMin;
            }

            public String getMontantTtcMax(){
            return this.montantTtcMax;
            }

            public String getMontantTtcMin(){
            return this.montantTtcMin;
            }

            public void setMontantTtcMax(String montantTtcMax){
            this.montantTtcMax = montantTtcMax;
            }

            public void setMontantTtcMin(String montantTtcMin){
            this.montantTtcMin = montantTtcMin;
            }

            public String getMontantTvaMax(){
            return this.montantTvaMax;
            }

            public String getMontantTvaMin(){
            return this.montantTvaMin;
            }

            public void setMontantTvaMax(String montantTvaMax){
            this.montantTvaMax = montantTvaMax;
            }

            public void setMontantTvaMin(String montantTvaMin){
            this.montantTvaMin = montantTvaMin;
            }

            public String getDatePaiementMax(){
            return this.datePaiementMax;
            }

            public String getDatePaiementMin(){
            return this.datePaiementMin;
            }

            public void setDatePaiementMax(String datePaiementMax){
            this.datePaiementMax = datePaiementMax;
            }

            public void setDatePaiementMin(String datePaiementMin){
            this.datePaiementMin = datePaiementMin;
            }

            public String getPourcentageReductionMax(){
            return this.pourcentageReductionMax;
            }

            public String getPourcentageReductionMin(){
            return this.pourcentageReductionMin;
            }

            public void setPourcentageReductionMax(String pourcentageReductionMax){
            this.pourcentageReductionMax = pourcentageReductionMax;
            }

            public void setPourcentageReductionMin(String pourcentageReductionMin){
            this.pourcentageReductionMin = pourcentageReductionMin;
            }


        public OffreReductionVo getOffreReductionVo(){
        return this.offreReductionVo;
        }

        public void setOffreReductionVo(OffreReductionVo offreReductionVo){
        this.offreReductionVo = offreReductionVo;
        }


            }
