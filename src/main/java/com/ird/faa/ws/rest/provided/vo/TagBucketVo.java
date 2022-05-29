package  com.ird.faa.ws.rest.provided.vo;


public class TagBucketVo {

    private String id ;



        private BucketVo bucketVo ;
        private TagVo tagVo ;


    public TagBucketVo(){
    super();
    }

        public String getId(){
        return this.id;
        }

        public void setId(String id){
        this.id = id;
        }



        public BucketVo getBucketVo(){
        return this.bucketVo;
        }

        public void setBucketVo(BucketVo bucketVo){
        this.bucketVo = bucketVo;
        }
        public TagVo getTagVo(){
        return this.tagVo;
        }

        public void setTagVo(TagVo tagVo){
        this.tagVo = tagVo;
        }


            }
