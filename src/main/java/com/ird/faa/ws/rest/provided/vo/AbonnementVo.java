package  com.ird.faa.ws.rest.provided.vo;

    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;

public class AbonnementVo {

    private String id ;
    private String dateDebut ;
    private String dateFin ;
    private String tarif ;
    private String reduction ;


            private String dateDebutMax ;
            private String dateDebutMin ;
            private String dateFinMax ;
            private String dateFinMin ;
            private String tarifMax ;
            private String tarifMin ;
            private String reductionMax ;
            private String reductionMin ;

        private EtatAbonnementVo etatAbonnementVo ;
        private ClientVo clientVo ;
        private PackAbonnementVo packAbonnementVo ;


    public AbonnementVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getDateDebut(){
        return this.dateDebut;
        }

        public void setDateDebut(String dateDebut){
        this.dateDebut = dateDebut;
        }
        public String getDateFin(){
        return this.dateFin;
        }

        public void setDateFin(String dateFin){
        this.dateFin = dateFin;
        }
        public String getTarif(){
        return this.tarif;
        }

        public void setTarif(String tarif){
        this.tarif = tarif;
        }
        public String getReduction(){
        return this.reduction;
        }

        public void setReduction(String reduction){
        this.reduction = reduction;
        }


            public String getDateDebutMax(){
            return this.dateDebutMax;
            }

            public String getDateDebutMin(){
            return this.dateDebutMin;
            }

            public void setDateDebutMax(String dateDebutMax){
            this.dateDebutMax = dateDebutMax;
            }

            public void setDateDebutMin(String dateDebutMin){
            this.dateDebutMin = dateDebutMin;
            }

            public String getDateFinMax(){
            return this.dateFinMax;
            }

            public String getDateFinMin(){
            return this.dateFinMin;
            }

            public void setDateFinMax(String dateFinMax){
            this.dateFinMax = dateFinMax;
            }

            public void setDateFinMin(String dateFinMin){
            this.dateFinMin = dateFinMin;
            }

            public String getTarifMax(){
            return this.tarifMax;
            }

            public String getTarifMin(){
            return this.tarifMin;
            }

            public void setTarifMax(String tarifMax){
            this.tarifMax = tarifMax;
            }

            public void setTarifMin(String tarifMin){
            this.tarifMin = tarifMin;
            }

            public String getReductionMax(){
            return this.reductionMax;
            }

            public String getReductionMin(){
            return this.reductionMin;
            }

            public void setReductionMax(String reductionMax){
            this.reductionMax = reductionMax;
            }

            public void setReductionMin(String reductionMin){
            this.reductionMin = reductionMin;
            }


        public EtatAbonnementVo getEtatAbonnementVo(){
        return this.etatAbonnementVo;
        }

        public void setEtatAbonnementVo(EtatAbonnementVo etatAbonnementVo){
        this.etatAbonnementVo = etatAbonnementVo;
        }
        public ClientVo getClientVo(){
        return this.clientVo;
        }

        public void setClientVo(ClientVo clientVo){
        this.clientVo = clientVo;
        }
        public PackAbonnementVo getPackAbonnementVo(){
        return this.packAbonnementVo;
        }

        public void setPackAbonnementVo(PackAbonnementVo packAbonnementVo){
        this.packAbonnementVo = packAbonnementVo;
        }


            }
