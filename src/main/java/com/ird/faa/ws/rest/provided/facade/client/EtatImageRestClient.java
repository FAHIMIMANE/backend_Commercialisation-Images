package  com.ird.faa.ws.rest.provided.facade.client;

import com.ird.faa.service.client.facade.EtatImageClientService;

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
import com.ird.faa.bean.EtatImage;
import com.ird.faa.ws.rest.provided.converter.EtatImageConverter;
import com.ird.faa.ws.rest.provided.vo.EtatImageVo;

@Api("Manages etatImage services")
@RestController
@RequestMapping("api/client/etatImage")
public class EtatImageRestClient {

@Autowired
private EtatImageClientService etatImageService;

@Autowired
private EtatImageConverter etatImageConverter;


            @ApiOperation("Updates the specified  etatImage")
            @PutMapping("/")
            public  EtatImageVo update(@RequestBody  EtatImageVo  etatImageVo){
            EtatImage etatImage = etatImageConverter.toItem(etatImageVo);
            etatImage = etatImageService.update(etatImage);
            return etatImageConverter.toVo(etatImage);
            }

    @ApiOperation("Finds a list of all etatImages")
    @GetMapping("/")
    public List<EtatImageVo> findAll(){
        return etatImageConverter.toVo(etatImageService.findAll());
    }

    @ApiOperation("Finds a etatImage with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EtatImageVo findByIdWithAssociatedList(@PathVariable Long id){
    return etatImageConverter.toVo(etatImageService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search etatImage by a specific criteria")
    @PostMapping("/search")
    public List<EtatImageVo> findByCriteria(@RequestBody EtatImageVo etatImageVo){
        return etatImageConverter.toVo(etatImageService.findByCriteria(etatImageVo));
        }

            @ApiOperation("Finds a etatImage by id")
            @GetMapping("/id/{id}")
            public EtatImageVo findById(@PathVariable Long id){
            return etatImageConverter.toVo(etatImageService.findById(id));
            }

            @ApiOperation("Saves the specified  etatImage")
            @PostMapping("/")
            public EtatImageVo save(@RequestBody EtatImageVo etatImageVo){
            EtatImage etatImage = etatImageConverter.toItem(etatImageVo);
            etatImage = etatImageService.save(etatImage);
            return etatImageConverter.toVo(etatImage);
            }

            @ApiOperation("Delete the specified etatImage")
            @DeleteMapping("/")
            public int delete(@RequestBody EtatImageVo etatImageVo){
            EtatImage etatImage = etatImageConverter.toItem(etatImageVo);
            return etatImageService.delete(etatImage);
            }

            @ApiOperation("Deletes a etatImage by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return etatImageService.deleteById(id);
            }




            }
