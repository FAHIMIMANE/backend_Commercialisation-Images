package  com.ird.faa.ws.rest.provided.facade.contributeur;

import com.ird.faa.service.contributeur.facade.StateBucketContributeurService;

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
import com.ird.faa.bean.StateBucket;
import com.ird.faa.ws.rest.provided.converter.StateBucketConverter;
import com.ird.faa.ws.rest.provided.vo.StateBucketVo;

@Api("Manages stateBucket services")
@RestController
@RequestMapping("api/contributeur/stateBucket")
public class StateBucketRestContributeur {

@Autowired
private StateBucketContributeurService stateBucketService;

@Autowired
private StateBucketConverter stateBucketConverter;


            @ApiOperation("Updates the specified  stateBucket")
            @PutMapping("/")
            public  StateBucketVo update(@RequestBody  StateBucketVo  stateBucketVo){
            StateBucket stateBucket = stateBucketConverter.toItem(stateBucketVo);
            stateBucket = stateBucketService.update(stateBucket);
            return stateBucketConverter.toVo(stateBucket);
            }

    @ApiOperation("Finds a list of all stateBuckets")
    @GetMapping("/")
    public List<StateBucketVo> findAll(){
        return stateBucketConverter.toVo(stateBucketService.findAll());
    }

    @ApiOperation("Finds a stateBucket with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public StateBucketVo findByIdWithAssociatedList(@PathVariable Long id){
    return stateBucketConverter.toVo(stateBucketService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search stateBucket by a specific criteria")
    @PostMapping("/search")
    public List<StateBucketVo> findByCriteria(@RequestBody StateBucketVo stateBucketVo){
        return stateBucketConverter.toVo(stateBucketService.findByCriteria(stateBucketVo));
        }

            @ApiOperation("Finds a stateBucket by id")
            @GetMapping("/id/{id}")
            public StateBucketVo findById(@PathVariable Long id){
            return stateBucketConverter.toVo(stateBucketService.findById(id));
            }

            @ApiOperation("Saves the specified  stateBucket")
            @PostMapping("/")
            public StateBucketVo save(@RequestBody StateBucketVo stateBucketVo){
            StateBucket stateBucket = stateBucketConverter.toItem(stateBucketVo);
            stateBucket = stateBucketService.save(stateBucket);
            return stateBucketConverter.toVo(stateBucket);
            }

            @ApiOperation("Delete the specified stateBucket")
            @DeleteMapping("/")
            public int delete(@RequestBody StateBucketVo stateBucketVo){
            StateBucket stateBucket = stateBucketConverter.toItem(stateBucketVo);
            return stateBucketService.delete(stateBucket);
            }

            @ApiOperation("Deletes a stateBucket by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return stateBucketService.deleteById(id);
            }




            }
