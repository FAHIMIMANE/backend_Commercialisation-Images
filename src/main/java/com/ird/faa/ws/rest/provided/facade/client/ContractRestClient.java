package  com.ird.faa.ws.rest.provided.facade.client;

import com.ird.faa.service.client.facade.ContractClientService;

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
import com.ird.faa.bean.Contract;
import com.ird.faa.ws.rest.provided.converter.ContractConverter;
import com.ird.faa.ws.rest.provided.vo.ContractVo;

@Api("Manages contract services")
@RestController
@RequestMapping("api/client/contract")
public class ContractRestClient {

@Autowired
private ContractClientService contractService;

@Autowired
private ContractConverter contractConverter;


            @ApiOperation("Updates the specified  contract")
            @PutMapping("/")
            public  ContractVo update(@RequestBody  ContractVo  contractVo){
            Contract contract = contractConverter.toItem(contractVo);
            contract = contractService.update(contract);
            return contractConverter.toVo(contract);
            }

    @ApiOperation("Finds a list of all contracts")
    @GetMapping("/")
    public List<ContractVo> findAll(){
        return contractConverter.toVo(contractService.findAll());
    }

    @ApiOperation("Finds a contract with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ContractVo findByIdWithAssociatedList(@PathVariable Long id){
    return contractConverter.toVo(contractService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search contract by a specific criteria")
    @PostMapping("/search")
    public List<ContractVo> findByCriteria(@RequestBody ContractVo contractVo){
        return contractConverter.toVo(contractService.findByCriteria(contractVo));
        }

            @ApiOperation("Finds a contract by id")
            @GetMapping("/id/{id}")
            public ContractVo findById(@PathVariable Long id){
            return contractConverter.toVo(contractService.findById(id));
            }

            @ApiOperation("Saves the specified  contract")
            @PostMapping("/")
            public ContractVo save(@RequestBody ContractVo contractVo){
            Contract contract = contractConverter.toItem(contractVo);
            contract = contractService.save(contract);
            return contractConverter.toVo(contract);
            }

            @ApiOperation("Delete the specified contract")
            @DeleteMapping("/")
            public int delete(@RequestBody ContractVo contractVo){
            Contract contract = contractConverter.toItem(contractVo);
            return contractService.delete(contract);
            }

            @ApiOperation("Deletes a contract by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return contractService.deleteById(id);
            }
        @ApiOperation("find by typeContrat id")
        @GetMapping("/typeContrat/id/{id}")
        public List<Contract> findByTypeContratId(@PathVariable Long id){
        return contractService.findByTypeContratId(id);
        }

        @ApiOperation("delete by typeContrat id")
        @DeleteMapping("/typeContrat/id/{id}")
        public int deleteByTypeContratId(@PathVariable Long id){
        return contractService.deleteByTypeContratId(id);
        }





            @PutMapping("/archiver/")
            public ContractVo archiver(@RequestBody ContractVo contractVo){
                Contract contract = contractService.archiver(contractConverter.toItem(contractVo));
                return contractConverter.toVo(contract);
                }

            @PutMapping("/desarchiver/")
            public ContractVo desarchiver(@RequestBody ContractVo contractVo){
                Contract contract = contractService.desarchiver(contractConverter.toItem(contractVo));
                return contractConverter.toVo(contract);}
            }
