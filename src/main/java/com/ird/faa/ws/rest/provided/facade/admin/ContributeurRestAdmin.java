package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.ContributeurAdminService;

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
import com.ird.faa.bean.Contributeur;
import com.ird.faa.ws.rest.provided.converter.ContributeurConverter;
import com.ird.faa.ws.rest.provided.vo.ContributeurVo;

@Api("Manages contributeur services")
@RestController
@RequestMapping("api/admin/contributeur")
public class ContributeurRestAdmin {

@Autowired
private ContributeurAdminService contributeurService;

@Autowired
private ContributeurConverter contributeurConverter;


            @ApiOperation("Updates the specified  contributeur")
            @PutMapping("/")
            public  ContributeurVo update(@RequestBody  ContributeurVo  contributeurVo){
            Contributeur contributeur = contributeurConverter.toItem(contributeurVo);
            contributeur = contributeurService.update(contributeur);
            return contributeurConverter.toVo(contributeur);
            }

    @ApiOperation("Finds a list of all contributeurs")
    @GetMapping("/")
    public List<ContributeurVo> findAll(){
        return contributeurConverter.toVo(contributeurService.findAll());
    }

    @ApiOperation("Finds a contributeur with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ContributeurVo findByIdWithAssociatedList(@PathVariable Long id){
    return contributeurConverter.toVo(contributeurService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search contributeur by a specific criteria")
    @PostMapping("/search")
    public List<ContributeurVo> findByCriteria(@RequestBody ContributeurVo contributeurVo){
        return contributeurConverter.toVo(contributeurService.findByCriteria(contributeurVo));
        }

            @ApiOperation("Finds a contributeur by id")
            @GetMapping("/id/{id}")
            public ContributeurVo findById(@PathVariable Long id){
            return contributeurConverter.toVo(contributeurService.findById(id));
            }

            @ApiOperation("Saves the specified  contributeur")
            @PostMapping("/")
            public ContributeurVo save(@RequestBody ContributeurVo contributeurVo){
            Contributeur contributeur = contributeurConverter.toItem(contributeurVo);
            contributeur = contributeurService.save(contributeur);
            return contributeurConverter.toVo(contributeur);
            }

            @ApiOperation("Delete the specified contributeur")
            @DeleteMapping("/")
            public int delete(@RequestBody ContributeurVo contributeurVo){
            Contributeur contributeur = contributeurConverter.toItem(contributeurVo);
            return contributeurService.delete(contributeur);
            }

            @ApiOperation("Deletes a contributeur by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return contributeurService.deleteById(id);
            }




            }
