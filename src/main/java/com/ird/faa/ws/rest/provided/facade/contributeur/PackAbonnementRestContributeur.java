package  com.ird.faa.ws.rest.provided.facade.contributeur;

import com.ird.faa.service.contributeur.facade.PackAbonnementContributeurService;

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
import com.ird.faa.bean.PackAbonnement;
import com.ird.faa.ws.rest.provided.converter.PackAbonnementConverter;
import com.ird.faa.ws.rest.provided.vo.PackAbonnementVo;

@Api("Manages packAbonnement services")
@RestController
@RequestMapping("api/contributeur/packAbonnement")
public class PackAbonnementRestContributeur {

@Autowired
private PackAbonnementContributeurService packAbonnementService;

@Autowired
private PackAbonnementConverter packAbonnementConverter;


            @ApiOperation("Updates the specified  packAbonnement")
            @PutMapping("/")
            public  PackAbonnementVo update(@RequestBody  PackAbonnementVo  packAbonnementVo){
            PackAbonnement packAbonnement = packAbonnementConverter.toItem(packAbonnementVo);
            packAbonnement = packAbonnementService.update(packAbonnement);
            return packAbonnementConverter.toVo(packAbonnement);
            }

    @ApiOperation("Finds a list of all packAbonnements")
    @GetMapping("/")
    public List<PackAbonnementVo> findAll(){
        return packAbonnementConverter.toVo(packAbonnementService.findAll());
    }

    @ApiOperation("Finds a packAbonnement with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PackAbonnementVo findByIdWithAssociatedList(@PathVariable Long id){
    return packAbonnementConverter.toVo(packAbonnementService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search packAbonnement by a specific criteria")
    @PostMapping("/search")
    public List<PackAbonnementVo> findByCriteria(@RequestBody PackAbonnementVo packAbonnementVo){
        return packAbonnementConverter.toVo(packAbonnementService.findByCriteria(packAbonnementVo));
        }

            @ApiOperation("Finds a packAbonnement by id")
            @GetMapping("/id/{id}")
            public PackAbonnementVo findById(@PathVariable Long id){
            return packAbonnementConverter.toVo(packAbonnementService.findById(id));
            }

            @ApiOperation("Saves the specified  packAbonnement")
            @PostMapping("/")
            public PackAbonnementVo save(@RequestBody PackAbonnementVo packAbonnementVo){
            PackAbonnement packAbonnement = packAbonnementConverter.toItem(packAbonnementVo);
            packAbonnement = packAbonnementService.save(packAbonnement);
            return packAbonnementConverter.toVo(packAbonnement);
            }

            @ApiOperation("Delete the specified packAbonnement")
            @DeleteMapping("/")
            public int delete(@RequestBody PackAbonnementVo packAbonnementVo){
            PackAbonnement packAbonnement = packAbonnementConverter.toItem(packAbonnementVo);
            return packAbonnementService.delete(packAbonnement);
            }

            @ApiOperation("Deletes a packAbonnement by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return packAbonnementService.deleteById(id);
            }




            }
