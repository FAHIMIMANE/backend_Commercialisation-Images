package  com.ird.faa.ws.rest.provided.vo;

    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;

public class PackAbonnementVo {

    private String id ;
    private String nombreImageMax ;
    private String reduction ;
    private String dateMin ;
    private String dateMax ;


            private String nombreImageMaxMax ;
            private String nombreImageMaxMin ;
            private String reductionMax ;
            private String reductionMin ;
            private String dateMinMax ;
            private String dateMinMin ;
            private String dateMaxMax ;
            private String dateMaxMin ;



    public PackAbonnementVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getNombreImageMax(){
        return this.nombreImageMax;
        }

        public void setNombreImageMax(String nombreImageMax){
        this.nombreImageMax = nombreImageMax;
        }
        public String getReduction(){
        return this.reduction;
        }

        public void setReduction(String reduction){
        this.reduction = reduction;
        }
        public String getDateMin(){
        return this.dateMin;
        }

        public void setDateMin(String dateMin){
        this.dateMin = dateMin;
        }
        public String getDateMax(){
        return this.dateMax;
        }

        public void setDateMax(String dateMax){
        this.dateMax = dateMax;
        }


            public String getNombreImageMaxMax(){
            return this.nombreImageMaxMax;
            }

            public String getNombreImageMaxMin(){
            return this.nombreImageMaxMin;
            }

            public void setNombreImageMaxMax(String nombreImageMaxMax){
            this.nombreImageMaxMax = nombreImageMaxMax;
            }

            public void setNombreImageMaxMin(String nombreImageMaxMin){
            this.nombreImageMaxMin = nombreImageMaxMin;
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

            public String getDateMinMax(){
            return this.dateMinMax;
            }

            public String getDateMinMin(){
            return this.dateMinMin;
            }

            public void setDateMinMax(String dateMinMax){
            this.dateMinMax = dateMinMax;
            }

            public void setDateMinMin(String dateMinMin){
            this.dateMinMin = dateMinMin;
            }

            public String getDateMaxMax(){
            return this.dateMaxMax;
            }

            public String getDateMaxMin(){
            return this.dateMaxMin;
            }

            public void setDateMaxMax(String dateMaxMax){
            this.dateMaxMax = dateMaxMax;
            }

            public void setDateMaxMin(String dateMaxMin){
            this.dateMaxMin = dateMaxMin;
            }




            }
