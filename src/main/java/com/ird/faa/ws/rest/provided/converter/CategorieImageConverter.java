package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.CategorieImage;
import com.ird.faa.ws.rest.provided.vo.CategorieImageVo;

@Component
public class CategorieImageConverter extends AbstractConverter<CategorieImage,CategorieImageVo>{


public  CategorieImageConverter(){
init(true);
}

@Override
public CategorieImage toItem(CategorieImageVo vo) {
if (vo == null) {
return null;
} else {
CategorieImage item = new CategorieImage();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getDescription()))
        item.setDescription(vo.getDescription());


return item;
}
}

@Override
public CategorieImageVo toVo(CategorieImage item) {
if (item == null) {
return null;
} else {
CategorieImageVo vo = new CategorieImageVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(StringUtil.isNotEmpty(item.getDescription()))
        vo.setDescription(item.getDescription());


return vo;
}
}

public void init(Boolean value) {
}









}
