package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.EtatPanierChercheurService;

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
import com.ird.faa.bean.EtatPanier;
import com.ird.faa.ws.rest.provided.converter.EtatPanierConverter;
import com.ird.faa.ws.rest.provided.vo.EtatPanierVo;

@Api("Manages etatPanier services")
@RestController
@RequestMapping("api/chercheur/etatPanier")
public class EtatPanierRestChercheur {

@Autowired
private EtatPanierChercheurService etatPanierService;

@Autowired
private EtatPanierConverter etatPanierConverter;


            @ApiOperation("Updates the specified  etatPanier")
            @PutMapping("/")
            public  EtatPanierVo update(@RequestBody  EtatPanierVo  etatPanierVo){
            EtatPanier etatPanier = etatPanierConverter.toItem(etatPanierVo);
            etatPanier = etatPanierService.update(etatPanier);
            return etatPanierConverter.toVo(etatPanier);
            }

    @ApiOperation("Finds a list of all etatPaniers")
    @GetMapping("/")
    public List<EtatPanierVo> findAll(){
        return etatPanierConverter.toVo(etatPanierService.findAll());
    }

    @ApiOperation("Finds a etatPanier with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EtatPanierVo findByIdWithAssociatedList(@PathVariable Long id){
    return etatPanierConverter.toVo(etatPanierService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search etatPanier by a specific criteria")
    @PostMapping("/search")
    public List<EtatPanierVo> findByCriteria(@RequestBody EtatPanierVo etatPanierVo){
        return etatPanierConverter.toVo(etatPanierService.findByCriteria(etatPanierVo));
        }

            @ApiOperation("Finds a etatPanier by id")
            @GetMapping("/id/{id}")
            public EtatPanierVo findById(@PathVariable Long id){
            return etatPanierConverter.toVo(etatPanierService.findById(id));
            }

            @ApiOperation("Saves the specified  etatPanier")
            @PostMapping("/")
            public EtatPanierVo save(@RequestBody EtatPanierVo etatPanierVo){
            EtatPanier etatPanier = etatPanierConverter.toItem(etatPanierVo);
            etatPanier = etatPanierService.save(etatPanier);
            return etatPanierConverter.toVo(etatPanier);
            }

            @ApiOperation("Delete the specified etatPanier")
            @DeleteMapping("/")
            public int delete(@RequestBody EtatPanierVo etatPanierVo){
            EtatPanier etatPanier = etatPanierConverter.toItem(etatPanierVo);
            return etatPanierService.delete(etatPanier);
            }

            @ApiOperation("Deletes a etatPanier by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return etatPanierService.deleteById(id);
            }




            }
