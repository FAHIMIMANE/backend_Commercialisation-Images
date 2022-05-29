package  com.ird.faa.ws.rest.provided.facade.client;

import com.ird.faa.service.client.facade.SignatureClientService;

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
import com.ird.faa.bean.Signature;
import com.ird.faa.ws.rest.provided.converter.SignatureConverter;
import com.ird.faa.ws.rest.provided.vo.SignatureVo;

@Api("Manages signature services")
@RestController
@RequestMapping("api/client/signature")
public class SignatureRestClient {

@Autowired
private SignatureClientService signatureService;

@Autowired
private SignatureConverter signatureConverter;


            @ApiOperation("Updates the specified  signature")
            @PutMapping("/")
            public  SignatureVo update(@RequestBody  SignatureVo  signatureVo){
            Signature signature = signatureConverter.toItem(signatureVo);
            signature = signatureService.update(signature);
            return signatureConverter.toVo(signature);
            }

    @ApiOperation("Finds a list of all signatures")
    @GetMapping("/")
    public List<SignatureVo> findAll(){
        return signatureConverter.toVo(signatureService.findAll());
    }

    @ApiOperation("Finds a signature with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public SignatureVo findByIdWithAssociatedList(@PathVariable Long id){
    return signatureConverter.toVo(signatureService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search signature by a specific criteria")
    @PostMapping("/search")
    public List<SignatureVo> findByCriteria(@RequestBody SignatureVo signatureVo){
        return signatureConverter.toVo(signatureService.findByCriteria(signatureVo));
        }

            @ApiOperation("Finds a signature by id")
            @GetMapping("/id/{id}")
            public SignatureVo findById(@PathVariable Long id){
            return signatureConverter.toVo(signatureService.findById(id));
            }

            @ApiOperation("Saves the specified  signature")
            @PostMapping("/")
            public SignatureVo save(@RequestBody SignatureVo signatureVo){
            Signature signature = signatureConverter.toItem(signatureVo);
            signature = signatureService.save(signature);
            return signatureConverter.toVo(signature);
            }

            @ApiOperation("Delete the specified signature")
            @DeleteMapping("/")
            public int delete(@RequestBody SignatureVo signatureVo){
            Signature signature = signatureConverter.toItem(signatureVo);
            return signatureService.delete(signature);
            }

            @ApiOperation("Deletes a signature by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return signatureService.deleteById(id);
            }
        @ApiOperation("find by contributeur numeroMatricule")
        @GetMapping("/contributeur/numeroMatricule/{numeroMatricule}")
        public List<Signature> findByContributeurNumeroMatricule(@PathVariable String numeroMatricule){
        return signatureService.findByContributeurNumeroMatricule(numeroMatricule);
        }

        @ApiOperation("delete by contributeur numeroMatricule")
        @DeleteMapping("/contributeur/numeroMatricule/{numeroMatricule}")
        public int deleteByContributeurNumeroMatricule(@PathVariable String numeroMatricule){
        return signatureService.deleteByContributeurNumeroMatricule(numeroMatricule);
        }

        @ApiOperation("find by contributeur id")
        @GetMapping("/contributeur/id/{id}")
        public List<Signature> findByContributeurId(@PathVariable Long id){
        return signatureService.findByContributeurId(id);
        }

        @ApiOperation("delete by contributeur id")
        @DeleteMapping("/contributeur/id/{id}")
        public int deleteByContributeurId(@PathVariable Long id){
        return signatureService.deleteByContributeurId(id);
        }

        @ApiOperation("find by contract reference")
        @GetMapping("/contract/reference/{reference}")
        public List<Signature> findByContractReference(@PathVariable String reference){
        return signatureService.findByContractReference(reference);
        }

        @ApiOperation("delete by contract reference")
        @DeleteMapping("/contract/reference/{reference}")
        public int deleteByContractReference(@PathVariable String reference){
        return signatureService.deleteByContractReference(reference);
        }

        @ApiOperation("find by contract id")
        @GetMapping("/contract/id/{id}")
        public List<Signature> findByContractId(@PathVariable Long id){
        return signatureService.findByContractId(id);
        }

        @ApiOperation("delete by contract id")
        @DeleteMapping("/contract/id/{id}")
        public int deleteByContractId(@PathVariable Long id){
        return signatureService.deleteByContractId(id);
        }





            }
