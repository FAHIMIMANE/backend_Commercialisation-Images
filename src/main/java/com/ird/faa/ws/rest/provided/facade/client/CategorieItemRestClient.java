package  com.ird.faa.ws.rest.provided.facade.client;

import com.ird.faa.service.client.facade.CategorieItemClientService;

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
import com.ird.faa.bean.CategorieItem;
import com.ird.faa.ws.rest.provided.converter.CategorieItemConverter;
import com.ird.faa.ws.rest.provided.vo.CategorieItemVo;

@Api("Manages categorieItem services")
@RestController
@RequestMapping("api/client/categorieItem")
public class CategorieItemRestClient {

@Autowired
private CategorieItemClientService categorieItemService;

@Autowired
private CategorieItemConverter categorieItemConverter;


            @ApiOperation("Updates the specified  categorieItem")
            @PutMapping("/")
            public  CategorieItemVo update(@RequestBody  CategorieItemVo  categorieItemVo){
            CategorieItem categorieItem = categorieItemConverter.toItem(categorieItemVo);
            categorieItem = categorieItemService.update(categorieItem);
            return categorieItemConverter.toVo(categorieItem);
            }

    @ApiOperation("Finds a list of all categorieItems")
    @GetMapping("/")
    public List<CategorieItemVo> findAll(){
        return categorieItemConverter.toVo(categorieItemService.findAll());
    }

    @ApiOperation("Finds a categorieItem with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public CategorieItemVo findByIdWithAssociatedList(@PathVariable Long id){
    return categorieItemConverter.toVo(categorieItemService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search categorieItem by a specific criteria")
    @PostMapping("/search")
    public List<CategorieItemVo> findByCriteria(@RequestBody CategorieItemVo categorieItemVo){
        return categorieItemConverter.toVo(categorieItemService.findByCriteria(categorieItemVo));
        }

            @ApiOperation("Finds a categorieItem by id")
            @GetMapping("/id/{id}")
            public CategorieItemVo findById(@PathVariable Long id){
            return categorieItemConverter.toVo(categorieItemService.findById(id));
            }

            @ApiOperation("Saves the specified  categorieItem")
            @PostMapping("/")
            public CategorieItemVo save(@RequestBody CategorieItemVo categorieItemVo){
            CategorieItem categorieItem = categorieItemConverter.toItem(categorieItemVo);
            categorieItem = categorieItemService.save(categorieItem);
            return categorieItemConverter.toVo(categorieItem);
            }

            @ApiOperation("Delete the specified categorieItem")
            @DeleteMapping("/")
            public int delete(@RequestBody CategorieItemVo categorieItemVo){
            CategorieItem categorieItem = categorieItemConverter.toItem(categorieItemVo);
            return categorieItemService.delete(categorieItem);
            }

            @ApiOperation("Deletes a categorieItem by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return categorieItemService.deleteById(id);
            }
        @ApiOperation("find by image reference")
        @GetMapping("/image/reference/{reference}")
        public List<CategorieItem> findByImageReference(@PathVariable String reference){
        return categorieItemService.findByImageReference(reference);
        }

        @ApiOperation("delete by image reference")
        @DeleteMapping("/image/reference/{reference}")
        public int deleteByImageReference(@PathVariable String reference){
        return categorieItemService.deleteByImageReference(reference);
        }

        @ApiOperation("find by image id")
        @GetMapping("/image/id/{id}")
        public List<CategorieItem> findByImageId(@PathVariable Long id){
        return categorieItemService.findByImageId(id);
        }

        @ApiOperation("delete by image id")
        @DeleteMapping("/image/id/{id}")
        public int deleteByImageId(@PathVariable Long id){
        return categorieItemService.deleteByImageId(id);
        }

        @ApiOperation("find by categorieImage id")
        @GetMapping("/categorieImage/id/{id}")
        public List<CategorieItem> findByCategorieImageId(@PathVariable Long id){
        return categorieItemService.findByCategorieImageId(id);
        }

        @ApiOperation("delete by categorieImage id")
        @DeleteMapping("/categorieImage/id/{id}")
        public int deleteByCategorieImageId(@PathVariable Long id){
        return categorieItemService.deleteByCategorieImageId(id);
        }





            }
