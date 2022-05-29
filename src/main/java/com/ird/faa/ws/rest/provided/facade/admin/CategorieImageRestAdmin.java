package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.CategorieImageAdminService;

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
import com.ird.faa.bean.CategorieImage;
import com.ird.faa.ws.rest.provided.converter.CategorieImageConverter;
import com.ird.faa.ws.rest.provided.vo.CategorieImageVo;

@Api("Manages categorieImage services")
@RestController
@RequestMapping("api/admin/categorieImage")
public class CategorieImageRestAdmin {

@Autowired
private CategorieImageAdminService categorieImageService;

@Autowired
private CategorieImageConverter categorieImageConverter;


            @ApiOperation("Updates the specified  categorieImage")
            @PutMapping("/")
            public  CategorieImageVo update(@RequestBody  CategorieImageVo  categorieImageVo){
            CategorieImage categorieImage = categorieImageConverter.toItem(categorieImageVo);
            categorieImage = categorieImageService.update(categorieImage);
            return categorieImageConverter.toVo(categorieImage);
            }

    @ApiOperation("Finds a list of all categorieImages")
    @GetMapping("/")
    public List<CategorieImageVo> findAll(){
        return categorieImageConverter.toVo(categorieImageService.findAll());
    }

    @ApiOperation("Finds a categorieImage with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public CategorieImageVo findByIdWithAssociatedList(@PathVariable Long id){
    return categorieImageConverter.toVo(categorieImageService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search categorieImage by a specific criteria")
    @PostMapping("/search")
    public List<CategorieImageVo> findByCriteria(@RequestBody CategorieImageVo categorieImageVo){
        return categorieImageConverter.toVo(categorieImageService.findByCriteria(categorieImageVo));
        }

            @ApiOperation("Finds a categorieImage by id")
            @GetMapping("/id/{id}")
            public CategorieImageVo findById(@PathVariable Long id){
            return categorieImageConverter.toVo(categorieImageService.findById(id));
            }

            @ApiOperation("Saves the specified  categorieImage")
            @PostMapping("/")
            public CategorieImageVo save(@RequestBody CategorieImageVo categorieImageVo){
            CategorieImage categorieImage = categorieImageConverter.toItem(categorieImageVo);
            categorieImage = categorieImageService.save(categorieImage);
            return categorieImageConverter.toVo(categorieImage);
            }

            @ApiOperation("Delete the specified categorieImage")
            @DeleteMapping("/")
            public int delete(@RequestBody CategorieImageVo categorieImageVo){
            CategorieImage categorieImage = categorieImageConverter.toItem(categorieImageVo);
            return categorieImageService.delete(categorieImage);
            }

            @ApiOperation("Deletes a categorieImage by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return categorieImageService.deleteById(id);
            }




            }
