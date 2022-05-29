package  com.ird.faa.ws.rest.provided.vo;


public class PanierItemVo {

    private String id ;
    private String prix ;
    private String reduction ;
    private String prixApresReduction ;


            private String prixMax ;
            private String prixMin ;
            private String reductionMax ;
            private String reductionMin ;
            private String prixApresReductionMax ;
            private String prixApresReductionMin ;

        private ImageVo imageVo ;
        private PanierVo panierVo ;


    public PanierItemVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getPrix(){
        return this.prix;
        }

        public void setPrix(String prix){
        this.prix = prix;
        }
        public String getReduction(){
        return this.reduction;
        }

        public void setReduction(String reduction){
        this.reduction = reduction;
        }
        public String getPrixApresReduction(){
        return this.prixApresReduction;
        }

        public void setPrixApresReduction(String prixApresReduction){
        this.prixApresReduction = prixApresReduction;
        }


            public String getPrixMax(){
            return this.prixMax;
            }

            public String getPrixMin(){
            return this.prixMin;
            }

            public void setPrixMax(String prixMax){
            this.prixMax = prixMax;
            }

            public void setPrixMin(String prixMin){
            this.prixMin = prixMin;
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

            public String getPrixApresReductionMax(){
            return this.prixApresReductionMax;
            }

            public String getPrixApresReductionMin(){
            return this.prixApresReductionMin;
            }

            public void setPrixApresReductionMax(String prixApresReductionMax){
            this.prixApresReductionMax = prixApresReductionMax;
            }

            public void setPrixApresReductionMin(String prixApresReductionMin){
            this.prixApresReductionMin = prixApresReductionMin;
            }


        public ImageVo getImageVo(){
        return this.imageVo;
        }

        public void setImageVo(ImageVo imageVo){
        this.imageVo = imageVo;
        }
        public PanierVo getPanierVo(){
        return this.panierVo;
        }

        public void setPanierVo(PanierVo panierVo){
        this.panierVo = panierVo;
        }


            }
