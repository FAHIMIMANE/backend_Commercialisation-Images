package  com.ird.faa.ws.rest.provided.facade.contributeur;

import com.ird.faa.service.contributeur.facade.PaiementContributeurService;

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
import com.ird.faa.bean.Paiement;
import com.ird.faa.ws.rest.provided.converter.PaiementConverter;
import com.ird.faa.ws.rest.provided.vo.PaiementVo;

@Api("Manages paiement services")
@RestController
@RequestMapping("api/contributeur/paiement")
public class PaiementRestContributeur {

@Autowired
private PaiementContributeurService paiementService;

@Autowired
private PaiementConverter paiementConverter;


            @ApiOperation("Updates the specified  paiement")
            @PutMapping("/")
            public  PaiementVo update(@RequestBody  PaiementVo  paiementVo){
            Paiement paiement = paiementConverter.toItem(paiementVo);
            paiement = paiementService.update(paiement);
            return paiementConverter.toVo(paiement);
            }

    @ApiOperation("Finds a list of all paiements")
    @GetMapping("/")
    public List<PaiementVo> findAll(){
        return paiementConverter.toVo(paiementService.findAll());
    }

    @ApiOperation("Finds a paiement with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PaiementVo findByIdWithAssociatedList(@PathVariable Long id){
    return paiementConverter.toVo(paiementService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search paiement by a specific criteria")
    @PostMapping("/search")
    public List<PaiementVo> findByCriteria(@RequestBody PaiementVo paiementVo){
        return paiementConverter.toVo(paiementService.findByCriteria(paiementVo));
        }

            @ApiOperation("Finds a paiement by id")
            @GetMapping("/id/{id}")
            public PaiementVo findById(@PathVariable Long id){
            return paiementConverter.toVo(paiementService.findById(id));
            }

            @ApiOperation("Saves the specified  paiement")
            @PostMapping("/")
            public PaiementVo save(@RequestBody PaiementVo paiementVo){
            Paiement paiement = paiementConverter.toItem(paiementVo);
            paiement = paiementService.save(paiement);
            return paiementConverter.toVo(paiement);
            }

            @ApiOperation("Delete the specified paiement")
            @DeleteMapping("/")
            public int delete(@RequestBody PaiementVo paiementVo){
            Paiement paiement = paiementConverter.toItem(paiementVo);
            return paiementService.delete(paiement);
            }

            @ApiOperation("Deletes a paiement by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return paiementService.deleteById(id);
            }
        @ApiOperation("find by offreReduction qteMin")
        @GetMapping("/offreReduction/qteMin/{qteMin}")
        public List<Paiement> findByOffreReductionQteMin(@PathVariable Double qteMin){
        return paiementService.findByOffreReductionQteMin(qteMin);
        }

        @ApiOperation("delete by offreReduction qteMin")
        @DeleteMapping("/offreReduction/qteMin/{qteMin}")
        public int deleteByOffreReductionQteMin(@PathVariable Double qteMin){
        return paiementService.deleteByOffreReductionQteMin(qteMin);
        }

        @ApiOperation("find by offreReduction id")
        @GetMapping("/offreReduction/id/{id}")
        public List<Paiement> findByOffreReductionId(@PathVariable Long id){
        return paiementService.findByOffreReductionId(id);
        }

        @ApiOperation("delete by offreReduction id")
        @DeleteMapping("/offreReduction/id/{id}")
        public int deleteByOffreReductionId(@PathVariable Long id){
        return paiementService.deleteByOffreReductionId(id);
        }





            }
