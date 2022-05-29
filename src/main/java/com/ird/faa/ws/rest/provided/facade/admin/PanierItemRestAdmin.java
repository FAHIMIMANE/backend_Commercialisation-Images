package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.PanierItemAdminService;

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
import com.ird.faa.bean.PanierItem;
import com.ird.faa.ws.rest.provided.converter.PanierItemConverter;
import com.ird.faa.ws.rest.provided.vo.PanierItemVo;

@Api("Manages panierItem services")
@RestController
@RequestMapping("api/admin/panierItem")
public class PanierItemRestAdmin {

@Autowired
private PanierItemAdminService panierItemService;

@Autowired
private PanierItemConverter panierItemConverter;


            @ApiOperation("Updates the specified  panierItem")
            @PutMapping("/")
            public  PanierItemVo update(@RequestBody  PanierItemVo  panierItemVo){
            PanierItem panierItem = panierItemConverter.toItem(panierItemVo);
            panierItem = panierItemService.update(panierItem);
            return panierItemConverter.toVo(panierItem);
            }

    @ApiOperation("Finds a list of all panierItems")
    @GetMapping("/")
    public List<PanierItemVo> findAll(){
        return panierItemConverter.toVo(panierItemService.findAll());
    }

    @ApiOperation("Finds a panierItem with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PanierItemVo findByIdWithAssociatedList(@PathVariable Long id){
    return panierItemConverter.toVo(panierItemService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search panierItem by a specific criteria")
    @PostMapping("/search")
    public List<PanierItemVo> findByCriteria(@RequestBody PanierItemVo panierItemVo){
        return panierItemConverter.toVo(panierItemService.findByCriteria(panierItemVo));
        }

            @ApiOperation("Finds a panierItem by id")
            @GetMapping("/id/{id}")
            public PanierItemVo findById(@PathVariable Long id){
            return panierItemConverter.toVo(panierItemService.findById(id));
            }

            @ApiOperation("Saves the specified  panierItem")
            @PostMapping("/")
            public PanierItemVo save(@RequestBody PanierItemVo panierItemVo){
            PanierItem panierItem = panierItemConverter.toItem(panierItemVo);
            panierItem = panierItemService.save(panierItem);
            return panierItemConverter.toVo(panierItem);
            }

            @ApiOperation("Delete the specified panierItem")
            @DeleteMapping("/")
            public int delete(@RequestBody PanierItemVo panierItemVo){
            PanierItem panierItem = panierItemConverter.toItem(panierItemVo);
            return panierItemService.delete(panierItem);
            }

            @ApiOperation("Deletes a panierItem by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return panierItemService.deleteById(id);
            }
        @ApiOperation("find by image reference")
        @GetMapping("/image/reference/{reference}")
        public List<PanierItem> findByImageReference(@PathVariable String reference){
        return panierItemService.findByImageReference(reference);
        }

        @ApiOperation("delete by image reference")
        @DeleteMapping("/image/reference/{reference}")
        public int deleteByImageReference(@PathVariable String reference){
        return panierItemService.deleteByImageReference(reference);
        }

        @ApiOperation("find by image id")
        @GetMapping("/image/id/{id}")
        public List<PanierItem> findByImageId(@PathVariable Long id){
        return panierItemService.findByImageId(id);
        }

        @ApiOperation("delete by image id")
        @DeleteMapping("/image/id/{id}")
        public int deleteByImageId(@PathVariable Long id){
        return panierItemService.deleteByImageId(id);
        }

        @ApiOperation("find by panier id")
        @GetMapping("/panier/id/{id}")
        public List<PanierItem> findByPanierId(@PathVariable Long id){
        return panierItemService.findByPanierId(id);
        }

        @ApiOperation("delete by panier id")
        @DeleteMapping("/panier/id/{id}")
        public int deleteByPanierId(@PathVariable Long id){
        return panierItemService.deleteByPanierId(id);
        }





            }
