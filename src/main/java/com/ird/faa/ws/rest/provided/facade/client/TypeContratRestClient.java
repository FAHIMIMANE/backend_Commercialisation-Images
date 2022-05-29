package  com.ird.faa.ws.rest.provided.facade.client;

import com.ird.faa.service.client.facade.TypeContratClientService;

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
import com.ird.faa.bean.TypeContrat;
import com.ird.faa.ws.rest.provided.converter.TypeContratConverter;
import com.ird.faa.ws.rest.provided.vo.TypeContratVo;

@Api("Manages typeContrat services")
@RestController
@RequestMapping("api/client/typeContrat")
public class TypeContratRestClient {

@Autowired
private TypeContratClientService typeContratService;

@Autowired
private TypeContratConverter typeContratConverter;


            @ApiOperation("Updates the specified  typeContrat")
            @PutMapping("/")
            public  TypeContratVo update(@RequestBody  TypeContratVo  typeContratVo){
            TypeContrat typeContrat = typeContratConverter.toItem(typeContratVo);
            typeContrat = typeContratService.update(typeContrat);
            return typeContratConverter.toVo(typeContrat);
            }

    @ApiOperation("Finds a list of all typeContrats")
    @GetMapping("/")
    public List<TypeContratVo> findAll(){
        return typeContratConverter.toVo(typeContratService.findAll());
    }

    @ApiOperation("Finds a typeContrat with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TypeContratVo findByIdWithAssociatedList(@PathVariable Long id){
    return typeContratConverter.toVo(typeContratService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search typeContrat by a specific criteria")
    @PostMapping("/search")
    public List<TypeContratVo> findByCriteria(@RequestBody TypeContratVo typeContratVo){
        return typeContratConverter.toVo(typeContratService.findByCriteria(typeContratVo));
        }

            @ApiOperation("Finds a typeContrat by id")
            @GetMapping("/id/{id}")
            public TypeContratVo findById(@PathVariable Long id){
            return typeContratConverter.toVo(typeContratService.findById(id));
            }

            @ApiOperation("Saves the specified  typeContrat")
            @PostMapping("/")
            public TypeContratVo save(@RequestBody TypeContratVo typeContratVo){
            TypeContrat typeContrat = typeContratConverter.toItem(typeContratVo);
            typeContrat = typeContratService.save(typeContrat);
            return typeContratConverter.toVo(typeContrat);
            }

            @ApiOperation("Delete the specified typeContrat")
            @DeleteMapping("/")
            public int delete(@RequestBody TypeContratVo typeContratVo){
            TypeContrat typeContrat = typeContratConverter.toItem(typeContratVo);
            return typeContratService.delete(typeContrat);
            }

            @ApiOperation("Deletes a typeContrat by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return typeContratService.deleteById(id);
            }




            }
