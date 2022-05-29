package  com.ird.faa.ws.rest.provided.facade.client;

import com.ird.faa.service.client.facade.TagBucketClientService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.ird.faa.bean.TagBucket;
import com.ird.faa.ws.rest.provided.converter.TagBucketConverter;
import com.ird.faa.ws.rest.provided.vo.TagBucketVo;

@Api("Manages tagBucket services")
@RestController
@RequestMapping("api/client/tagBucket")
public class TagBucketRestClient {

@Autowired
private TagBucketClientService tagBucketService;

@Autowired
private TagBucketConverter tagBucketConverter;


            @ApiOperation("Updates the specified  tagBucket")
            @PutMapping("/")
            public  TagBucketVo update(@RequestBody  TagBucketVo  tagBucketVo){
            TagBucket tagBucket = tagBucketConverter.toItem(tagBucketVo);
            tagBucket = tagBucketService.update(tagBucket);
            return tagBucketConverter.toVo(tagBucket);
            }

    @ApiOperation("Finds a list of all tagBuckets")
    @GetMapping("/")
    public List<TagBucketVo> findAll(){
        return tagBucketConverter.toVo(tagBucketService.findAll());
    }

    @ApiOperation("Finds a tagBucket with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TagBucketVo findByIdWithAssociatedList(@PathVariable Long id){
    return tagBucketConverter.toVo(tagBucketService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search tagBucket by a specific criteria")
    @PostMapping("/search")
    public List<TagBucketVo> findByCriteria(@RequestBody TagBucketVo tagBucketVo){
        return tagBucketConverter.toVo(tagBucketService.findByCriteria(tagBucketVo));
        }

            @ApiOperation("Finds a tagBucket by id")
            @GetMapping("/id/{id}")
            public TagBucketVo findById(@PathVariable Long id){
            return tagBucketConverter.toVo(tagBucketService.findById(id));
            }

            @ApiOperation("Saves the specified  tagBucket")
            @PostMapping("/")
            public TagBucketVo save(@RequestBody TagBucketVo tagBucketVo){
            TagBucket tagBucket = tagBucketConverter.toItem(tagBucketVo);
            tagBucket = tagBucketService.save(tagBucket);
            return tagBucketConverter.toVo(tagBucket);
            }

            @ApiOperation("Delete the specified tagBucket")
            @DeleteMapping("/")
            public int delete(@RequestBody TagBucketVo tagBucketVo){
            TagBucket tagBucket = tagBucketConverter.toItem(tagBucketVo);
            return tagBucketService.delete(tagBucket);
            }

            @ApiOperation("Deletes a tagBucket by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return tagBucketService.deleteById(id);
            }
        @ApiOperation("find by bucket id")
        @GetMapping("/bucket/id/{id}")
        public List<TagBucket> findByBucketId(@PathVariable Long id){
        return tagBucketService.findByBucketId(id);
        }

        @ApiOperation("delete by bucket id")
        @DeleteMapping("/bucket/id/{id}")
        public int deleteByBucketId(@PathVariable Long id){
        return tagBucketService.deleteByBucketId(id);
        }

        @ApiOperation("find by tag code")
        @GetMapping("/tag/code/{code}")
        public List<TagBucket> findByTagCode(@PathVariable String code){
        return tagBucketService.findByTagCode(code);
        }

        @ApiOperation("delete by tag code")
        @DeleteMapping("/tag/code/{code}")
        public int deleteByTagCode(@PathVariable String code){
        return tagBucketService.deleteByTagCode(code);
        }

        @ApiOperation("find by tag id")
        @GetMapping("/tag/id/{id}")
        public List<TagBucket> findByTagId(@PathVariable Long id){
        return tagBucketService.findByTagId(id);
        }

        @ApiOperation("delete by tag id")
        @DeleteMapping("/tag/id/{id}")
        public int deleteByTagId(@PathVariable Long id){
        return tagBucketService.deleteByTagId(id);
        }





            }
