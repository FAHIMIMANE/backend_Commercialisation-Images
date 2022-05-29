package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.PanierChercheurService;

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
import com.ird.faa.bean.Panier;
import com.ird.faa.ws.rest.provided.converter.PanierConverter;
import com.ird.faa.ws.rest.provided.vo.PanierVo;

@Api("Manages panier services")
@RestController
@RequestMapping("api/chercheur/panier")
public class PanierRestChercheur {

@Autowired
private PanierChercheurService panierService;

@Autowired
private PanierConverter panierConverter;


            @ApiOperation("Updates the specified  panier")
            @PutMapping("/")
            public  PanierVo update(@RequestBody  PanierVo  panierVo){
            Panier panier = panierConverter.toItem(panierVo);
            panier = panierService.update(panier);
            return panierConverter.toVo(panier);
            }

    @ApiOperation("Finds a list of all paniers")
    @GetMapping("/")
    public List<PanierVo> findAll(){
        return panierConverter.toVo(panierService.findAll());
    }

    @ApiOperation("Finds a panier with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PanierVo findByIdWithAssociatedList(@PathVariable Long id){
    return panierConverter.toVo(panierService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search panier by a specific criteria")
    @PostMapping("/search")
    public List<PanierVo> findByCriteria(@RequestBody PanierVo panierVo){
        return panierConverter.toVo(panierService.findByCriteria(panierVo));
        }

            @ApiOperation("Finds a panier by id")
            @GetMapping("/id/{id}")
            public PanierVo findById(@PathVariable Long id){
            return panierConverter.toVo(panierService.findById(id));
            }

            @ApiOperation("Saves the specified  panier")
            @PostMapping("/")
            public PanierVo save(@RequestBody PanierVo panierVo){
            Panier panier = panierConverter.toItem(panierVo);
            panier = panierService.save(panier);
            return panierConverter.toVo(panier);
            }

            @ApiOperation("Delete the specified panier")
            @DeleteMapping("/")
            public int delete(@RequestBody PanierVo panierVo){
            Panier panier = panierConverter.toItem(panierVo);
            return panierService.delete(panier);
            }

            @ApiOperation("Deletes a panier by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return panierService.deleteById(id);
            }
        @ApiOperation("find by etatPanier code")
        @GetMapping("/etatPanier/code/{code}")
        public List<Panier> findByEtatPanierCode(@PathVariable String code){
        return panierService.findByEtatPanierCode(code);
        }

        @ApiOperation("delete by etatPanier code")
        @DeleteMapping("/etatPanier/code/{code}")
        public int deleteByEtatPanierCode(@PathVariable String code){
        return panierService.deleteByEtatPanierCode(code);
        }

        @ApiOperation("find by etatPanier id")
        @GetMapping("/etatPanier/id/{id}")
        public List<Panier> findByEtatPanierId(@PathVariable Long id){
        return panierService.findByEtatPanierId(id);
        }

        @ApiOperation("delete by etatPanier id")
        @DeleteMapping("/etatPanier/id/{id}")
        public int deleteByEtatPanierId(@PathVariable Long id){
        return panierService.deleteByEtatPanierId(id);
        }





            }
