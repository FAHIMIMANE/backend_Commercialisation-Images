package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.TagBucket;
        import com.ird.faa.bean.Bucket;
        import com.ird.faa.bean.Tag;
import com.ird.faa.dao.TagBucketDao;
import com.ird.faa.service.admin.facade.TagBucketAdminService;
        import com.ird.faa.service.admin.facade.BucketAdminService;
        import com.ird.faa.service.admin.facade.TagAdminService;

import com.ird.faa.ws.rest.provided.vo.TagBucketVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class TagBucketAdminServiceImpl extends AbstractServiceImpl<TagBucket> implements TagBucketAdminService {

@Autowired
private TagBucketDao tagBucketDao;

        @Autowired
        private BucketAdminService bucketService ;
        @Autowired
        private TagAdminService tagService ;


@Autowired
private EntityManager entityManager;


@Override
public List<TagBucket> findAll(){
        return tagBucketDao.findAll();
}
        @Override
        public List<TagBucket> findByBucketId(Long id){
        return tagBucketDao.findByBucketId(id);
        }

        @Override
        @Transactional
        public int deleteByBucketId(Long id){
        return tagBucketDao.deleteByBucketId(id);
        }


        @Override
        public List<TagBucket> findByTagCode(String code){
        return tagBucketDao.findByTagCode(code);
        }

        @Override
        @Transactional
        public int deleteByTagCode(String code){
        return tagBucketDao.deleteByTagCode(code);
        }

        @Override
        public List<TagBucket> findByTagId(Long id){
        return tagBucketDao.findByTagId(id);
        }

        @Override
        @Transactional
        public int deleteByTagId(Long id){
        return tagBucketDao.deleteByTagId(id);
        }


@Override
public TagBucket findById(Long id){
if(id==null) return null;
return tagBucketDao.getOne(id);
}

@Override
public TagBucket findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(tagBucketDao.findById(id).isPresent())  {
tagBucketDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public TagBucket update(TagBucket tagBucket){
TagBucket foundedTagBucket = findById(tagBucket.getId());
if(foundedTagBucket==null) return null;
else{
return  tagBucketDao.save(tagBucket);
}
}

@Override
public TagBucket save (TagBucket tagBucket){



    findBucket(tagBucket);
    findTag(tagBucket);

    return tagBucketDao.save(tagBucket);


}

@Override
public List<TagBucket> save(List<TagBucket> tagBuckets){
List<TagBucket> list = new ArrayList<>();
for(TagBucket tagBucket: tagBuckets){
list.add(save(tagBucket));
}
return list;
}



@Override
@Transactional
public int delete(TagBucket tagBucket){
    if(tagBucket.getId()==null) return -1;
    TagBucket foundedTagBucket = findById(tagBucket.getId());
    if(foundedTagBucket==null) return -1;
tagBucketDao.delete(foundedTagBucket);
return 1;
}


public List<TagBucket> findByCriteria(TagBucketVo tagBucketVo){

String query = "SELECT o FROM TagBucket o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",tagBucketVo.getId());
    if(tagBucketVo.getBucketVo()!=null){
        query += SearchUtil.addConstraint( "o", "bucket.id","=",tagBucketVo.getBucketVo().getId());
    }

    if(tagBucketVo.getTagVo()!=null){
        query += SearchUtil.addConstraint( "o", "tag.id","=",tagBucketVo.getTagVo().getId());
            query += SearchUtil.addConstraint( "o", "tag.code","LIKE",tagBucketVo.getTagVo().getCode());
    }

return entityManager.createQuery(query).getResultList();
}

    private void findBucket(TagBucket tagBucket){
        Bucket loadedBucket = null;
        if(tagBucket.getBucket() != null && tagBucket.getBucket().getId() !=null)
        loadedBucket =bucketService.findById(tagBucket.getBucket().getId());

    if(loadedBucket==null ) {
    return;
    }
    tagBucket.setBucket(loadedBucket);
    }
    private void findTag(TagBucket tagBucket){
        Tag loadedTag =tagService.findByIdOrCode(tagBucket.getTag());

    if(loadedTag==null ) {
    return;
    }
    tagBucket.setTag(loadedTag);
    }

@Override
@Transactional
public void delete(List<TagBucket> tagBuckets){
if(ListUtil.isNotEmpty(tagBuckets)){
tagBuckets.forEach(e->tagBucketDao.delete(e));
}
}
@Override
public void update(List<TagBucket> tagBuckets){
if(ListUtil.isNotEmpty(tagBuckets)){
tagBuckets.forEach(e->tagBucketDao.save(e));
}
}





    }
