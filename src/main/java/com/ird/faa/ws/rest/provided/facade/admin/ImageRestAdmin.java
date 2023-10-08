package com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.ImageAdminService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.Deflater;

import com.ird.faa.ws.rest.provided.converter.BucketConverter;
import com.ird.faa.ws.rest.provided.converter.ClientConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.ird.faa.bean.Image;
import com.ird.faa.ws.rest.provided.converter.ImageConverter;
import com.ird.faa.ws.rest.provided.vo.ImageVo;
import org.springframework.web.multipart.MultipartFile;

@Api("Manages image services")
@RestController
@RequestMapping("api/admin/image")
public class ImageRestAdmin<clientConvert, bucketConvert> {

    @Autowired
    private ImageAdminService imageService;

    @Autowired
    private ImageConverter imageConverter;

    @Autowired
    private BucketConverter bucketConverter;
    @Autowired
    private ClientConverter clientConverter;


    @ApiOperation("Updates the specified  image")
    @PutMapping("/")
    public ImageVo update(@RequestBody ImageVo imageVo) {
        Image image = imageConverter.toItem(imageVo);
        image = imageService.update(image);
        return imageConverter.toVo(image);
    }

    @ApiOperation("Finds a list of all images")
    @GetMapping("/")
    public List<ImageVo> findAll() {

        bucketConverter.setImages(false);
        clientConverter.setImages(false);
        List<ImageVo> imageVos = imageConverter.toVo(imageService.findAll());
        bucketConverter.setImages(true);
        clientConverter.setImages(true);
        return imageVos;
    }

    @ApiOperation("Finds a image with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public ImageVo findByIdWithAssociatedList(@PathVariable Long id) {
        return imageConverter.toVo(imageService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search image by a specific criteria")
    @PostMapping("/search")
    public List<ImageVo> findByCriteria(@RequestBody ImageVo imageVo) {
        return imageConverter.toVo(imageService.findByCriteria(imageVo));
    }

    @ApiOperation("Finds a image by id")
    @GetMapping("/id/{id}")
    public ImageVo findById(@PathVariable Long id) {
        return imageConverter.toVo(imageService.findById(id));
    }

    @ApiOperation("Saves the specified  image")
    @PostMapping("/")
    public ImageVo save(@RequestBody ImageVo imageVo) {
        Image image = imageConverter.toItem(imageVo);
        image = imageService.save(image);
        return imageConverter.toVo(image);
    }

    @ApiOperation("Saves the specified  image")
    @PostMapping("/all")
    public List<ImageVo> save(@RequestBody List<ImageVo> imagesVo) {
        List<Image> images = imageConverter.toItem(imagesVo);
        images = imageService.save(images);
        return imageConverter.toVo(images);
    }

    @ApiOperation("Delete the specified image")
    @DeleteMapping("/")
    public int delete(@RequestBody ImageVo imageVo) {
        Image image = imageConverter.toItem(imageVo);
        return imageService.delete(image);
    }

    @ApiOperation("Deletes a image by id")
    @DeleteMapping("/id/{id}")
    public int deleteById(@PathVariable Long id) {
        return imageService.deleteById(id);
    }

    @ApiOperation("find by client numeroMatricule")
    @GetMapping("/client/numeroMatricule/{numeroMatricule}")
    public List<Image> findByClientNumeroMatricule(@PathVariable String numeroMatricule) {
        return imageService.findByClientNumeroMatricule(numeroMatricule);
    }

    @ApiOperation("delete by client numeroMatricule")
    @DeleteMapping("/client/numeroMatricule/{numeroMatricule}")
    public int deleteByClientNumeroMatricule(@PathVariable String numeroMatricule) {
        return imageService.deleteByClientNumeroMatricule(numeroMatricule);
    }

    @ApiOperation("find by client id")
    @GetMapping("/client/id/{id}")
    public List<Image> findByClientId(@PathVariable Long id) {
        return imageService.findByClientId(id);
    }

    @ApiOperation("delete by client id")
    @DeleteMapping("/client/id/{id}")
    public int deleteByClientId(@PathVariable Long id) {
        return imageService.deleteByClientId(id);
    }

    @ApiOperation("find by bucket id")
    @GetMapping("/bucket/id/{id}")
    public List<Image> findByBucketId(@PathVariable Long id) {
        return imageService.findByBucketId(id);
    }

    @ApiOperation("delete by bucket id")
    @DeleteMapping("/bucket/id/{id}")
    public int deleteByBucketId(@PathVariable Long id) {
        return imageService.deleteByBucketId(id);
    }

    @ApiOperation("find by typeImage code")
    @GetMapping("/typeImage/code/{code}")
    public List<Image> findByTypeImageCode(@PathVariable String code) {
        return imageService.findByTypeImageCode(code);
    }

    @ApiOperation("delete by typeImage code")
    @DeleteMapping("/typeImage/code/{code}")
    public int deleteByTypeImageCode(@PathVariable String code) {
        return imageService.deleteByTypeImageCode(code);
    }

    @ApiOperation("find by typeImage id")
    @GetMapping("/typeImage/id/{id}")
    public List<Image> findByTypeImageId(@PathVariable Long id) {
        return imageService.findByTypeImageId(id);
    }

    @ApiOperation("delete by typeImage id")
    @DeleteMapping("/typeImage/id/{id}")
    public int deleteByTypeImageId(@PathVariable Long id) {
        return imageService.deleteByTypeImageId(id);
    }
    @GetMapping("/countImageByType/typeImage/code/{code}")
    public Long countImageByType(@PathVariable String code) {
        return imageService.countImageByType(code);
    }


















}

