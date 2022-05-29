package  com.ird.faa.ws.rest.provided.vo;

    import java.util.List;

public class ImageVo {

    private String id ;
    private String reference ;
    private String prix ;
    private String description ;
    private String extension ;
    private String taille ;
    private String resolution ;


            private String prixMax ;
            private String prixMin ;
            private String tailleMax ;
            private String tailleMin ;
            private String resolutionMax ;
            private String resolutionMin ;

        private ClientVo clientVo ;
        private BucketVo bucketVo ;
        private TypeImageVo typeImageVo ;

    private List<CategorieItemVo> categorieItemsVo ;

    public ImageVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getReference(){
        return this.reference;
        }

        public void setReference(String reference){
        this.reference = reference;
        }
        public String getPrix(){
        return this.prix;
        }

        public void setPrix(String prix){
        this.prix = prix;
        }
        public String getDescription(){
        return this.description;
        }

        public void setDescription(String description){
        this.description = description;
        }
        public String getExtension(){
        return this.extension;
        }

        public void setExtension(String extension){
        this.extension = extension;
        }
        public String getTaille(){
        return this.taille;
        }

        public void setTaille(String taille){
        this.taille = taille;
        }
        public String getResolution(){
        return this.resolution;
        }

        public void setResolution(String resolution){
        this.resolution = resolution;
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

            public String getTailleMax(){
            return this.tailleMax;
            }

            public String getTailleMin(){
            return this.tailleMin;
            }

            public void setTailleMax(String tailleMax){
            this.tailleMax = tailleMax;
            }

            public void setTailleMin(String tailleMin){
            this.tailleMin = tailleMin;
            }

            public String getResolutionMax(){
            return this.resolutionMax;
            }

            public String getResolutionMin(){
            return this.resolutionMin;
            }

            public void setResolutionMax(String resolutionMax){
            this.resolutionMax = resolutionMax;
            }

            public void setResolutionMin(String resolutionMin){
            this.resolutionMin = resolutionMin;
            }


        public ClientVo getClientVo(){
        return this.clientVo;
        }

        public void setClientVo(ClientVo clientVo){
        this.clientVo = clientVo;
        }
        public BucketVo getBucketVo(){
        return this.bucketVo;
        }

        public void setBucketVo(BucketVo bucketVo){
        this.bucketVo = bucketVo;
        }
        public TypeImageVo getTypeImageVo(){
        return this.typeImageVo;
        }

        public void setTypeImageVo(TypeImageVo typeImageVo){
        this.typeImageVo = typeImageVo;
        }


        public List<CategorieItemVo> getCategorieItemsVo(){
        return this.categorieItemsVo;
        }

        public void setCategorieItemsVo(List<CategorieItemVo> categorieItemsVo){
            this.categorieItemsVo = categorieItemsVo;
            }

            }
