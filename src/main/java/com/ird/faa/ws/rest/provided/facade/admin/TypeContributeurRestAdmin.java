package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.TypeContributeurAdminService;

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
import com.ird.faa.bean.TypeContributeur;
import com.ird.faa.ws.rest.provided.converter.TypeContributeurConverter;
import com.ird.faa.ws.rest.provided.vo.TypeContributeurVo;

@Api("Manages typeContributeur services")
@RestController
@RequestMapping("api/admin/typeContributeur")
public class TypeContributeurRestAdmin {

@Autowired
private TypeContributeurAdminService typeContributeurService;

@Autowired
private TypeContributeurConverter typeContributeurConverter;


            @ApiOperation("Updates the specified  typeContributeur")
            @PutMapping("/")
            public  TypeContributeurVo update(@RequestBody  TypeContributeurVo  typeContributeurVo){
            TypeContributeur typeContributeur = typeContributeurConverter.toItem(typeContributeurVo);
            typeContributeur = typeContributeurService.update(typeContributeur);
            return typeContributeurConverter.toVo(typeContributeur);
            }

    @ApiOperation("Finds a list of all typeContributeurs")
    @GetMapping("/")
    public List<TypeContributeurVo> findAll(){
        return typeContributeurConverter.toVo(typeContributeurService.findAll());
    }

    @ApiOperation("Finds a typeContributeur with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TypeContributeurVo findByIdWithAssociatedList(@PathVariable Long id){
    return typeContributeurConverter.toVo(typeContributeurService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search typeContributeur by a specific criteria")
    @PostMapping("/search")
    public List<TypeContributeurVo> findByCriteria(@RequestBody TypeContributeurVo typeContributeurVo){
        return typeContributeurConverter.toVo(typeContributeurService.findByCriteria(typeContributeurVo));
        }

            @ApiOperation("Finds a typeContributeur by id")
            @GetMapping("/id/{id}")
            public TypeContributeurVo findById(@PathVariable Long id){
            return typeContributeurConverter.toVo(typeContributeurService.findById(id));
            }

            @ApiOperation("Saves the specified  typeContributeur")
            @PostMapping("/")
            public TypeContributeurVo save(@RequestBody TypeContributeurVo typeContributeurVo){
            TypeContributeur typeContributeur = typeContributeurConverter.toItem(typeContributeurVo);
            typeContributeur = typeContributeurService.save(typeContributeur);
            return typeContributeurConverter.toVo(typeContributeur);
            }

            @ApiOperation("Delete the specified typeContributeur")
            @DeleteMapping("/")
            public int delete(@RequestBody TypeContributeurVo typeContributeurVo){
            TypeContributeur typeContributeur = typeContributeurConverter.toItem(typeContributeurVo);
            return typeContributeurService.delete(typeContributeur);
            }

            @ApiOperation("Deletes a typeContributeur by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return typeContributeurService.deleteById(id);
            }




            }
