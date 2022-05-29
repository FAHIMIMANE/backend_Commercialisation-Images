package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.EtatAbonnementAdminService;

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
import com.ird.faa.bean.EtatAbonnement;
import com.ird.faa.ws.rest.provided.converter.EtatAbonnementConverter;
import com.ird.faa.ws.rest.provided.vo.EtatAbonnementVo;

@Api("Manages etatAbonnement services")
@RestController
@RequestMapping("api/admin/etatAbonnement")
public class EtatAbonnementRestAdmin {

@Autowired
private EtatAbonnementAdminService etatAbonnementService;

@Autowired
private EtatAbonnementConverter etatAbonnementConverter;


            @ApiOperation("Updates the specified  etatAbonnement")
            @PutMapping("/")
            public  EtatAbonnementVo update(@RequestBody  EtatAbonnementVo  etatAbonnementVo){
            EtatAbonnement etatAbonnement = etatAbonnementConverter.toItem(etatAbonnementVo);
            etatAbonnement = etatAbonnementService.update(etatAbonnement);
            return etatAbonnementConverter.toVo(etatAbonnement);
            }

    @ApiOperation("Finds a list of all etatAbonnements")
    @GetMapping("/")
    public List<EtatAbonnementVo> findAll(){
        return etatAbonnementConverter.toVo(etatAbonnementService.findAll());
    }

    @ApiOperation("Finds a etatAbonnement with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EtatAbonnementVo findByIdWithAssociatedList(@PathVariable Long id){
    return etatAbonnementConverter.toVo(etatAbonnementService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search etatAbonnement by a specific criteria")
    @PostMapping("/search")
    public List<EtatAbonnementVo> findByCriteria(@RequestBody EtatAbonnementVo etatAbonnementVo){
        return etatAbonnementConverter.toVo(etatAbonnementService.findByCriteria(etatAbonnementVo));
        }

            @ApiOperation("Finds a etatAbonnement by id")
            @GetMapping("/id/{id}")
            public EtatAbonnementVo findById(@PathVariable Long id){
            return etatAbonnementConverter.toVo(etatAbonnementService.findById(id));
            }

            @ApiOperation("Saves the specified  etatAbonnement")
            @PostMapping("/")
            public EtatAbonnementVo save(@RequestBody EtatAbonnementVo etatAbonnementVo){
            EtatAbonnement etatAbonnement = etatAbonnementConverter.toItem(etatAbonnementVo);
            etatAbonnement = etatAbonnementService.save(etatAbonnement);
            return etatAbonnementConverter.toVo(etatAbonnement);
            }

            @ApiOperation("Delete the specified etatAbonnement")
            @DeleteMapping("/")
            public int delete(@RequestBody EtatAbonnementVo etatAbonnementVo){
            EtatAbonnement etatAbonnement = etatAbonnementConverter.toItem(etatAbonnementVo);
            return etatAbonnementService.delete(etatAbonnement);
            }

            @ApiOperation("Deletes a etatAbonnement by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return etatAbonnementService.deleteById(id);
            }




            }
