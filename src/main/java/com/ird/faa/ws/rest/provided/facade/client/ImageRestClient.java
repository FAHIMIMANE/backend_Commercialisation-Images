package  com.ird.faa.ws.rest.provided.facade.client;

import com.ird.faa.service.client.facade.ImageClientService;

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
import com.ird.faa.bean.Image;
import com.ird.faa.ws.rest.provided.converter.ImageConverter;
import com.ird.faa.ws.rest.provided.vo.ImageVo;

@Api("Manages image services")
@RestController
@RequestMapping("api/client/image")
public class ImageRestClient {

@Autowired
private ImageClientService imageService;

@Autowired
private ImageConverter imageConverter;


            @ApiOperation("Updates the specified  image")
            @PutMapping("/")
            public  ImageVo update(@RequestBody  ImageVo  imageVo){
            Image image = imageConverter.toItem(imageVo);
            image = imageService.update(image);
            return imageConverter.toVo(image);
            }

    @ApiOperation("Finds a list of all images")
    @GetMapping("/")
    public List<ImageVo> findAll(){
        return imageConverter.toVo(imageService.findAll());
    }

    @ApiOperation("Finds a image with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ImageVo findByIdWithAssociatedList(@PathVariable Long id){
    return imageConverter.toVo(imageService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search image by a specific criteria")
    @PostMapping("/search")
    public List<ImageVo> findByCriteria(@RequestBody ImageVo imageVo){
        return imageConverter.toVo(imageService.findByCriteria(imageVo));
        }

            @ApiOperation("Finds a image by id")
            @GetMapping("/id/{id}")
            public ImageVo findById(@PathVariable Long id){
            return imageConverter.toVo(imageService.findById(id));
            }

            @ApiOperation("Saves the specified  image")
            @PostMapping("/")
            public ImageVo save(@RequestBody ImageVo imageVo){
            Image image = imageConverter.toItem(imageVo);
            image = imageService.save(image);
            return imageConverter.toVo(image);
            }

            @ApiOperation("Delete the specified image")
            @DeleteMapping("/")
            public int delete(@RequestBody ImageVo imageVo){
            Image image = imageConverter.toItem(imageVo);
            return imageService.delete(image);
            }

            @ApiOperation("Deletes a image by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return imageService.deleteById(id);
            }
        @ApiOperation("find by client numeroMatricule")
        @GetMapping("/client/numeroMatricule/{numeroMatricule}")
        public List<Image> findByClientNumeroMatricule(@PathVariable String numeroMatricule){
        return imageService.findByClientNumeroMatricule(numeroMatricule);
        }

        @ApiOperation("delete by client numeroMatricule")
        @DeleteMapping("/client/numeroMatricule/{numeroMatricule}")
        public int deleteByClientNumeroMatricule(@PathVariable String numeroMatricule){
        return imageService.deleteByClientNumeroMatricule(numeroMatricule);
        }

        @ApiOperation("find by client id")
        @GetMapping("/client/id/{id}")
        public List<Image> findByClientId(@PathVariable Long id){
        return imageService.findByClientId(id);
        }

        @ApiOperation("delete by client id")
        @DeleteMapping("/client/id/{id}")
        public int deleteByClientId(@PathVariable Long id){
        return imageService.deleteByClientId(id);
        }

        @ApiOperation("find by bucket id")
        @GetMapping("/bucket/id/{id}")
        public List<Image> findByBucketId(@PathVariable Long id){
        return imageService.findByBucketId(id);
        }

        @ApiOperation("delete by bucket id")
        @DeleteMapping("/bucket/id/{id}")
        public int deleteByBucketId(@PathVariable Long id){
        return imageService.deleteByBucketId(id);
        }

        @ApiOperation("find by typeImage code")
        @GetMapping("/typeImage/code/{code}")
        public List<Image> findByTypeImageCode(@PathVariable String code){
        return imageService.findByTypeImageCode(code);
        }

        @ApiOperation("delete by typeImage code")
        @DeleteMapping("/typeImage/code/{code}")
        public int deleteByTypeImageCode(@PathVariable String code){
        return imageService.deleteByTypeImageCode(code);
        }

        @ApiOperation("find by typeImage id")
        @GetMapping("/typeImage/id/{id}")
        public List<Image> findByTypeImageId(@PathVariable Long id){
        return imageService.findByTypeImageId(id);
        }

        @ApiOperation("delete by typeImage id")
        @DeleteMapping("/typeImage/id/{id}")
        public int deleteByTypeImageId(@PathVariable Long id){
        return imageService.deleteByTypeImageId(id);
        }





            }
