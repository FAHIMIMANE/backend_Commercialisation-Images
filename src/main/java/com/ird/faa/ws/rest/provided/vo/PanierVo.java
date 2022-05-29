package  com.ird.faa.ws.rest.provided.vo;

    import java.util.List;

public class PanierVo {

    private String id ;
    private String reference ;
    private String prixTotal ;


            private String prixTotalMax ;
            private String prixTotalMin ;

        private EtatPanierVo etatPanierVo ;

    private List<PanierItemVo> panierItemsVo ;

    public PanierVo(){
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
        public String getPrixTotal(){
        return this.prixTotal;
        }

        public void setPrixTotal(String prixTotal){
        this.prixTotal = prixTotal;
        }


            public String getPrixTotalMax(){
            return this.prixTotalMax;
            }

            public String getPrixTotalMin(){
            return this.prixTotalMin;
            }

            public void setPrixTotalMax(String prixTotalMax){
            this.prixTotalMax = prixTotalMax;
            }

            public void setPrixTotalMin(String prixTotalMin){
            this.prixTotalMin = prixTotalMin;
            }


        public EtatPanierVo getEtatPanierVo(){
        return this.etatPanierVo;
        }

        public void setEtatPanierVo(EtatPanierVo etatPanierVo){
        this.etatPanierVo = etatPanierVo;
        }


        public List<PanierItemVo> getPanierItemsVo(){
        return this.panierItemsVo;
        }

        public void setPanierItemsVo(List<PanierItemVo> panierItemsVo){
            this.panierItemsVo = panierItemsVo;
            }

            }
