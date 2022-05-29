package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.TypePaiementChercheurService;

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
import com.ird.faa.bean.TypePaiement;
import com.ird.faa.ws.rest.provided.converter.TypePaiementConverter;
import com.ird.faa.ws.rest.provided.vo.TypePaiementVo;

@Api("Manages typePaiement services")
@RestController
@RequestMapping("api/chercheur/typePaiement")
public class TypePaiementRestChercheur {

@Autowired
private TypePaiementChercheurService typePaiementService;

@Autowired
private TypePaiementConverter typePaiementConverter;


            @ApiOperation("Updates the specified  typePaiement")
            @PutMapping("/")
            public  TypePaiementVo update(@RequestBody  TypePaiementVo  typePaiementVo){
            TypePaiement typePaiement = typePaiementConverter.toItem(typePaiementVo);
            typePaiement = typePaiementService.update(typePaiement);
            return typePaiementConverter.toVo(typePaiement);
            }

    @ApiOperation("Finds a list of all typePaiements")
    @GetMapping("/")
    public List<TypePaiementVo> findAll(){
        return typePaiementConverter.toVo(typePaiementService.findAll());
    }

    @ApiOperation("Finds a typePaiement with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TypePaiementVo findByIdWithAssociatedList(@PathVariable Long id){
    return typePaiementConverter.toVo(typePaiementService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search typePaiement by a specific criteria")
    @PostMapping("/search")
    public List<TypePaiementVo> findByCriteria(@RequestBody TypePaiementVo typePaiementVo){
        return typePaiementConverter.toVo(typePaiementService.findByCriteria(typePaiementVo));
        }

            @ApiOperation("Finds a typePaiement by id")
            @GetMapping("/id/{id}")
            public TypePaiementVo findById(@PathVariable Long id){
            return typePaiementConverter.toVo(typePaiementService.findById(id));
            }

            @ApiOperation("Saves the specified  typePaiement")
            @PostMapping("/")
            public TypePaiementVo save(@RequestBody TypePaiementVo typePaiementVo){
            TypePaiement typePaiement = typePaiementConverter.toItem(typePaiementVo);
            typePaiement = typePaiementService.save(typePaiement);
            return typePaiementConverter.toVo(typePaiement);
            }

            @ApiOperation("Delete the specified typePaiement")
            @DeleteMapping("/")
            public int delete(@RequestBody TypePaiementVo typePaiementVo){
            TypePaiement typePaiement = typePaiementConverter.toItem(typePaiementVo);
            return typePaiementService.delete(typePaiement);
            }

            @ApiOperation("Deletes a typePaiement by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return typePaiementService.deleteById(id);
            }




            }
