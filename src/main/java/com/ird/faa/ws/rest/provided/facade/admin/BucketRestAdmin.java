package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.BucketAdminService;

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
import com.ird.faa.bean.Bucket;
import com.ird.faa.ws.rest.provided.converter.BucketConverter;
import com.ird.faa.ws.rest.provided.vo.BucketVo;

@Api("Manages bucket services")
@RestController
@RequestMapping("api/admin/bucket")
public class BucketRestAdmin {

@Autowired
private BucketAdminService bucketService;

@Autowired
private BucketConverter bucketConverter;


            @ApiOperation("Updates the specified  bucket")
            @PutMapping("/")
            public  BucketVo update(@RequestBody  BucketVo  bucketVo){
            Bucket bucket = bucketConverter.toItem(bucketVo);
            bucket = bucketService.update(bucket);
            return bucketConverter.toVo(bucket);
            }

    @ApiOperation("Finds a list of all buckets")
    @GetMapping("/")
    public List<BucketVo> findAll(){
        return bucketConverter.toVo(bucketService.findAll());
    }

    @ApiOperation("Finds a bucket with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public BucketVo findByIdWithAssociatedList(@PathVariable Long id){
    return bucketConverter.toVo(bucketService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search bucket by a specific criteria")
    @PostMapping("/search")
    public List<BucketVo> findByCriteria(@RequestBody BucketVo bucketVo){
        return bucketConverter.toVo(bucketService.findByCriteria(bucketVo));
        }

            @ApiOperation("Finds a bucket by id")
            @GetMapping("/id/{id}")
            public BucketVo findById(@PathVariable Long id){
            return bucketConverter.toVo(bucketService.findById(id));
            }

            @ApiOperation("Saves the specified  bucket")
            @PostMapping("/")
            public BucketVo save(@RequestBody BucketVo bucketVo){
            Bucket bucket = bucketConverter.toItem(bucketVo);
            bucket = bucketService.save(bucket);
            return bucketConverter.toVo(bucket);
            }

            @ApiOperation("Delete the specified bucket")
            @DeleteMapping("/")
            public int delete(@RequestBody BucketVo bucketVo){
            Bucket bucket = bucketConverter.toItem(bucketVo);
            return bucketService.delete(bucket);
            }

            @ApiOperation("Deletes a bucket by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return bucketService.deleteById(id);
            }
        @ApiOperation("find by stateBucket code")
        @GetMapping("/stateBucket/code/{code}")
        public List<Bucket> findByStateBucketCode(@PathVariable String code){
        return bucketService.findByStateBucketCode(code);
        }

        @ApiOperation("delete by stateBucket code")
        @DeleteMapping("/stateBucket/code/{code}")
        public int deleteByStateBucketCode(@PathVariable String code){
        return bucketService.deleteByStateBucketCode(code);
        }

        @ApiOperation("find by stateBucket id")
        @GetMapping("/stateBucket/id/{id}")
        public List<Bucket> findByStateBucketId(@PathVariable Long id){
        return bucketService.findByStateBucketId(id);
        }

        @ApiOperation("delete by stateBucket id")
        @DeleteMapping("/stateBucket/id/{id}")
        public int deleteByStateBucketId(@PathVariable Long id){
        return bucketService.deleteByStateBucketId(id);
        }

        @ApiOperation("find by contributeur numeroMatricule")
        @GetMapping("/contributeur/numeroMatricule/{numeroMatricule}")
        public List<Bucket> findByContributeurNumeroMatricule(@PathVariable String numeroMatricule){
        return bucketService.findByContributeurNumeroMatricule(numeroMatricule);
        }

        @ApiOperation("delete by contributeur numeroMatricule")
        @DeleteMapping("/contributeur/numeroMatricule/{numeroMatricule}")
        public int deleteByContributeurNumeroMatricule(@PathVariable String numeroMatricule){
        return bucketService.deleteByContributeurNumeroMatricule(numeroMatricule);
        }

        @ApiOperation("find by contributeur id")
        @GetMapping("/contributeur/id/{id}")
        public List<Bucket> findByContributeurId(@PathVariable Long id){
        return bucketService.findByContributeurId(id);
        }

        @ApiOperation("delete by contributeur id")
        @DeleteMapping("/contributeur/id/{id}")
        public int deleteByContributeurId(@PathVariable Long id){
        return bucketService.deleteByContributeurId(id);
        }





            }
