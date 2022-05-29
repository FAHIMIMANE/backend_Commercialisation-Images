package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.OffreReductionAdminService;

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
import com.ird.faa.bean.OffreReduction;
import com.ird.faa.ws.rest.provided.converter.OffreReductionConverter;
import com.ird.faa.ws.rest.provided.vo.OffreReductionVo;

@Api("Manages offreReduction services")
@RestController
@RequestMapping("api/admin/offreReduction")
public class OffreReductionRestAdmin {

@Autowired
private OffreReductionAdminService offreReductionService;

@Autowired
private OffreReductionConverter offreReductionConverter;


            @ApiOperation("Updates the specified  offreReduction")
            @PutMapping("/")
            public  OffreReductionVo update(@RequestBody  OffreReductionVo  offreReductionVo){
            OffreReduction offreReduction = offreReductionConverter.toItem(offreReductionVo);
            offreReduction = offreReductionService.update(offreReduction);
            return offreReductionConverter.toVo(offreReduction);
            }

    @ApiOperation("Finds a list of all offreReductions")
    @GetMapping("/")
    public List<OffreReductionVo> findAll(){
        return offreReductionConverter.toVo(offreReductionService.findAll());
    }

    @ApiOperation("Finds a offreReduction with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public OffreReductionVo findByIdWithAssociatedList(@PathVariable Long id){
    return offreReductionConverter.toVo(offreReductionService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search offreReduction by a specific criteria")
    @PostMapping("/search")
    public List<OffreReductionVo> findByCriteria(@RequestBody OffreReductionVo offreReductionVo){
        return offreReductionConverter.toVo(offreReductionService.findByCriteria(offreReductionVo));
        }

            @ApiOperation("Finds a offreReduction by id")
            @GetMapping("/id/{id}")
            public OffreReductionVo findById(@PathVariable Long id){
            return offreReductionConverter.toVo(offreReductionService.findById(id));
            }

            @ApiOperation("Saves the specified  offreReduction")
            @PostMapping("/")
            public OffreReductionVo save(@RequestBody OffreReductionVo offreReductionVo){
            OffreReduction offreReduction = offreReductionConverter.toItem(offreReductionVo);
            offreReduction = offreReductionService.save(offreReduction);
            return offreReductionConverter.toVo(offreReduction);
            }

            @ApiOperation("Delete the specified offreReduction")
            @DeleteMapping("/")
            public int delete(@RequestBody OffreReductionVo offreReductionVo){
            OffreReduction offreReduction = offreReductionConverter.toItem(offreReductionVo);
            return offreReductionService.delete(offreReduction);
            }

            @ApiOperation("Deletes a offreReduction by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return offreReductionService.deleteById(id);
            }




            }
