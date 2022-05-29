package  com.ird.faa.ws.rest.provided.vo;

    import java.util.List;
    import java.util.Date;
    import javax.persistence.Temporal;
    import javax.persistence.TemporalType;
    import com.fasterxml.jackson.annotation.JsonFormat;

public class BucketVo {

    private String id ;
    private String nom ;
    private String dateCreation ;
    private String libelle ;


            private String dateCreationMax ;
            private String dateCreationMin ;

        private StateBucketVo stateBucketVo ;
        private ContributeurVo contributeurVo ;

    private List<ImageVo> imagesVo ;

    public BucketVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }
        public String getNom(){
        return this.nom;
        }

        public void setNom(String nom){
        this.nom = nom;
        }
        public String getDateCreation(){
        return this.dateCreation;
        }

        public void setDateCreation(String dateCreation){
        this.dateCreation = dateCreation;
        }
        public String getLibelle(){
        return this.libelle;
        }

        public void setLibelle(String libelle){
        this.libelle = libelle;
        }


            public String getDateCreationMax(){
            return this.dateCreationMax;
            }

            public String getDateCreationMin(){
            return this.dateCreationMin;
            }

            public void setDateCreationMax(String dateCreationMax){
            this.dateCreationMax = dateCreationMax;
            }

            public void setDateCreationMin(String dateCreationMin){
            this.dateCreationMin = dateCreationMin;
            }


        public StateBucketVo getStateBucketVo(){
        return this.stateBucketVo;
        }

        public void setStateBucketVo(StateBucketVo stateBucketVo){
        this.stateBucketVo = stateBucketVo;
        }
        public ContributeurVo getContributeurVo(){
        return this.contributeurVo;
        }

        public void setContributeurVo(ContributeurVo contributeurVo){
        this.contributeurVo = contributeurVo;
        }


        public List<ImageVo> getImagesVo(){
        return this.imagesVo;
        }

        public void setImagesVo(List<ImageVo> imagesVo){
            this.imagesVo = imagesVo;
            }

            }
