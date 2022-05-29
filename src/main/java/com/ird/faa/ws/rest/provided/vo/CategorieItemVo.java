package  com.ird.faa.ws.rest.provided.vo;


public class CategorieItemVo {

    private String id ;



        private ImageVo imageVo ;
        private CategorieImageVo categorieImageVo ;


    public CategorieItemVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }



        public ImageVo getImageVo(){
        return this.imageVo;
        }

        public void setImageVo(ImageVo imageVo){
        this.imageVo = imageVo;
        }
        public CategorieImageVo getCategorieImageVo(){
        return this.categorieImageVo;
        }

        public void setCategorieImageVo(CategorieImageVo categorieImageVo){
        this.categorieImageVo = categorieImageVo;
        }


            }
