package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.TypeClientChercheurService;

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
import com.ird.faa.bean.TypeClient;
import com.ird.faa.ws.rest.provided.converter.TypeClientConverter;
import com.ird.faa.ws.rest.provided.vo.TypeClientVo;

@Api("Manages typeClient services")
@RestController
@RequestMapping("api/chercheur/typeClient")
public class TypeClientRestChercheur {

@Autowired
private TypeClientChercheurService typeClientService;

@Autowired
private TypeClientConverter typeClientConverter;


            @ApiOperation("Updates the specified  typeClient")
            @PutMapping("/")
            public  TypeClientVo update(@RequestBody  TypeClientVo  typeClientVo){
            TypeClient typeClient = typeClientConverter.toItem(typeClientVo);
            typeClient = typeClientService.update(typeClient);
            return typeClientConverter.toVo(typeClient);
            }

    @ApiOperation("Finds a list of all typeClients")
    @GetMapping("/")
    public List<TypeClientVo> findAll(){
        return typeClientConverter.toVo(typeClientService.findAll());
    }

    @ApiOperation("Finds a typeClient with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TypeClientVo findByIdWithAssociatedList(@PathVariable Long id){
    return typeClientConverter.toVo(typeClientService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search typeClient by a specific criteria")
    @PostMapping("/search")
    public List<TypeClientVo> findByCriteria(@RequestBody TypeClientVo typeClientVo){
        return typeClientConverter.toVo(typeClientService.findByCriteria(typeClientVo));
        }

            @ApiOperation("Finds a typeClient by id")
            @GetMapping("/id/{id}")
            public TypeClientVo findById(@PathVariable Long id){
            return typeClientConverter.toVo(typeClientService.findById(id));
            }

            @ApiOperation("Saves the specified  typeClient")
            @PostMapping("/")
            public TypeClientVo save(@RequestBody TypeClientVo typeClientVo){
            TypeClient typeClient = typeClientConverter.toItem(typeClientVo);
            typeClient = typeClientService.save(typeClient);
            return typeClientConverter.toVo(typeClient);
            }

            @ApiOperation("Delete the specified typeClient")
            @DeleteMapping("/")
            public int delete(@RequestBody TypeClientVo typeClientVo){
            TypeClient typeClient = typeClientConverter.toItem(typeClientVo);
            return typeClientService.delete(typeClient);
            }

            @ApiOperation("Deletes a typeClient by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return typeClientService.deleteById(id);
            }




            }
