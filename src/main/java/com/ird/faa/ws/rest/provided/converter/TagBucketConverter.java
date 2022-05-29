package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.TagBucket;
import com.ird.faa.ws.rest.provided.vo.TagBucketVo;

@Component
public class TagBucketConverter extends AbstractConverter<TagBucket,TagBucketVo>{

        @Autowired
        private BucketConverter bucketConverter ;
        @Autowired
        private TagConverter tagConverter ;
    private Boolean bucket;
    private Boolean tag;

public  TagBucketConverter(){
init(true);
}

@Override
public TagBucket toItem(TagBucketVo vo) {
if (vo == null) {
return null;
} else {
TagBucket item = new TagBucket();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
    if(vo.getBucketVo()!=null && this.bucket)
        item.setBucket(bucketConverter.toItem(vo.getBucketVo())) ;
    if(vo.getTagVo()!=null && this.tag)
        item.setTag(tagConverter.toItem(vo.getTagVo())) ;


return item;
}
}

@Override
public TagBucketVo toVo(TagBucket item) {
if (item == null) {
return null;
} else {
TagBucketVo vo = new TagBucketVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

    if(item.getBucket()!=null && this.bucket) {
        vo.setBucketVo(bucketConverter.toVo(item.getBucket())) ;
    }
    if(item.getTag()!=null && this.tag) {
        vo.setTagVo(tagConverter.toVo(item.getTag())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    bucket = value;
    tag = value;
}


        public BucketConverter getBucketConverter(){
        return this.bucketConverter;
        }
        public void setBucketConverter(BucketConverter bucketConverter ){
        this.bucketConverter = bucketConverter;
        }
        public TagConverter getTagConverter(){
        return this.tagConverter;
        }
        public void setTagConverter(TagConverter tagConverter ){
        this.tagConverter = tagConverter;
        }

    public boolean  isBucket(){
    return this.bucket;
    }
    public void  setBucket(boolean bucket){
    this.bucket = bucket;
    }
    public boolean  isTag(){
    return this.tag;
    }
    public void  setTag(boolean tag){
    this.tag = tag;
    }






}
