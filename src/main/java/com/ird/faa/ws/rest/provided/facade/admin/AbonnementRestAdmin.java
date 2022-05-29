package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.AbonnementAdminService;

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
import com.ird.faa.bean.Abonnement;
import com.ird.faa.ws.rest.provided.converter.AbonnementConverter;
import com.ird.faa.ws.rest.provided.vo.AbonnementVo;

@Api("Manages abonnement services")
@RestController
@RequestMapping("api/admin/abonnement")
public class AbonnementRestAdmin {

@Autowired
private AbonnementAdminService abonnementService;

@Autowired
private AbonnementConverter abonnementConverter;


            @ApiOperation("Updates the specified  abonnement")
            @PutMapping("/")
            public  AbonnementVo update(@RequestBody  AbonnementVo  abonnementVo){
            Abonnement abonnement = abonnementConverter.toItem(abonnementVo);
            abonnement = abonnementService.update(abonnement);
            return abonnementConverter.toVo(abonnement);
            }

    @ApiOperation("Finds a list of all abonnements")
    @GetMapping("/")
    public List<AbonnementVo> findAll(){
        return abonnementConverter.toVo(abonnementService.findAll());
    }

    @ApiOperation("Finds a abonnement with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public AbonnementVo findByIdWithAssociatedList(@PathVariable Long id){
    return abonnementConverter.toVo(abonnementService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search abonnement by a specific criteria")
    @PostMapping("/search")
    public List<AbonnementVo> findByCriteria(@RequestBody AbonnementVo abonnementVo){
        return abonnementConverter.toVo(abonnementService.findByCriteria(abonnementVo));
        }

            @ApiOperation("Finds a abonnement by id")
            @GetMapping("/id/{id}")
            public AbonnementVo findById(@PathVariable Long id){
            return abonnementConverter.toVo(abonnementService.findById(id));
            }

            @ApiOperation("Saves the specified  abonnement")
            @PostMapping("/")
            public AbonnementVo save(@RequestBody AbonnementVo abonnementVo){
            Abonnement abonnement = abonnementConverter.toItem(abonnementVo);
            abonnement = abonnementService.save(abonnement);
            return abonnementConverter.toVo(abonnement);
            }

            @ApiOperation("Delete the specified abonnement")
            @DeleteMapping("/")
            public int delete(@RequestBody AbonnementVo abonnementVo){
            Abonnement abonnement = abonnementConverter.toItem(abonnementVo);
            return abonnementService.delete(abonnement);
            }

            @ApiOperation("Deletes a abonnement by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return abonnementService.deleteById(id);
            }
        @ApiOperation("find by etatAbonnement code")
        @GetMapping("/etatAbonnement/code/{code}")
        public List<Abonnement> findByEtatAbonnementCode(@PathVariable String code){
        return abonnementService.findByEtatAbonnementCode(code);
        }

        @ApiOperation("delete by etatAbonnement code")
        @DeleteMapping("/etatAbonnement/code/{code}")
        public int deleteByEtatAbonnementCode(@PathVariable String code){
        return abonnementService.deleteByEtatAbonnementCode(code);
        }

        @ApiOperation("find by etatAbonnement id")
        @GetMapping("/etatAbonnement/id/{id}")
        public List<Abonnement> findByEtatAbonnementId(@PathVariable Long id){
        return abonnementService.findByEtatAbonnementId(id);
        }

        @ApiOperation("delete by etatAbonnement id")
        @DeleteMapping("/etatAbonnement/id/{id}")
        public int deleteByEtatAbonnementId(@PathVariable Long id){
        return abonnementService.deleteByEtatAbonnementId(id);
        }

        @ApiOperation("find by client numeroMatricule")
        @GetMapping("/client/numeroMatricule/{numeroMatricule}")
        public List<Abonnement> findByClientNumeroMatricule(@PathVariable String numeroMatricule){
        return abonnementService.findByClientNumeroMatricule(numeroMatricule);
        }

        @ApiOperation("delete by client numeroMatricule")
        @DeleteMapping("/client/numeroMatricule/{numeroMatricule}")
        public int deleteByClientNumeroMatricule(@PathVariable String numeroMatricule){
        return abonnementService.deleteByClientNumeroMatricule(numeroMatricule);
        }

        @ApiOperation("find by client id")
        @GetMapping("/client/id/{id}")
        public List<Abonnement> findByClientId(@PathVariable Long id){
        return abonnementService.findByClientId(id);
        }

        @ApiOperation("delete by client id")
        @DeleteMapping("/client/id/{id}")
        public int deleteByClientId(@PathVariable Long id){
        return abonnementService.deleteByClientId(id);
        }

        @ApiOperation("find by packAbonnement nombreImageMax")
        @GetMapping("/packAbonnement/nombreImageMax/{nombreImageMax}")
        public List<Abonnement> findByPackAbonnementNombreImageMax(@PathVariable Double nombreImageMax){
        return abonnementService.findByPackAbonnementNombreImageMax(nombreImageMax);
        }

        @ApiOperation("delete by packAbonnement nombreImageMax")
        @DeleteMapping("/packAbonnement/nombreImageMax/{nombreImageMax}")
        public int deleteByPackAbonnementNombreImageMax(@PathVariable Double nombreImageMax){
        return abonnementService.deleteByPackAbonnementNombreImageMax(nombreImageMax);
        }

        @ApiOperation("find by packAbonnement id")
        @GetMapping("/packAbonnement/id/{id}")
        public List<Abonnement> findByPackAbonnementId(@PathVariable Long id){
        return abonnementService.findByPackAbonnementId(id);
        }

        @ApiOperation("delete by packAbonnement id")
        @DeleteMapping("/packAbonnement/id/{id}")
        public int deleteByPackAbonnementId(@PathVariable Long id){
        return abonnementService.deleteByPackAbonnementId(id);
        }





            }
