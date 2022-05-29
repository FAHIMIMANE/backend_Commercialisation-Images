package  com.ird.faa.ws.rest.provided.vo;

    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;

public class OffreReductionVo {

    private String id ;
    private String qteMin ;
    private String qteMax ;
    private String pourcentage ;
    private String dateMin ;
    private String dateMax ;


            private String qteMinMax ;
            private String qteMinMin ;
            private String qteMaxMax ;
            private String qteMaxMin ;
            private String pourcentageMax ;
            private String pourcentageMin ;
            private String dateMinMax ;
            private String dateMinMin ;
            private String dateMaxMax ;
            private String dateMaxMin ;



    public OffreReductionVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getQteMin(){
        return this.qteMin;
        }

        public void setQteMin(String qteMin){
        this.qteMin = qteMin;
        }
        public String getQteMax(){
        return this.qteMax;
        }

        public void setQteMax(String qteMax){
        this.qteMax = qteMax;
        }
        public String getPourcentage(){
        return this.pourcentage;
        }

        public void setPourcentage(String pourcentage){
        this.pourcentage = pourcentage;
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


            public String getQteMinMax(){
            return this.qteMinMax;
            }

            public String getQteMinMin(){
            return this.qteMinMin;
            }

            public void setQteMinMax(String qteMinMax){
            this.qteMinMax = qteMinMax;
            }

            public void setQteMinMin(String qteMinMin){
            this.qteMinMin = qteMinMin;
            }

            public String getQteMaxMax(){
            return this.qteMaxMax;
            }

            public String getQteMaxMin(){
            return this.qteMaxMin;
            }

            public void setQteMaxMax(String qteMaxMax){
            this.qteMaxMax = qteMaxMax;
            }

            public void setQteMaxMin(String qteMaxMin){
            this.qteMaxMin = qteMaxMin;
            }

            public String getPourcentageMax(){
            return this.pourcentageMax;
            }

            public String getPourcentageMin(){
            return this.pourcentageMin;
            }

            public void setPourcentageMax(String pourcentageMax){
            this.pourcentageMax = pourcentageMax;
            }

            public void setPourcentageMin(String pourcentageMin){
            this.pourcentageMin = pourcentageMin;
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
