package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.EtatImage;
import com.ird.faa.ws.rest.provided.vo.EtatImageVo;

@Component
public class EtatImageConverter extends AbstractConverter<EtatImage,EtatImageVo>{


public  EtatImageConverter(){
init(true);
}

@Override
public EtatImage toItem(EtatImageVo vo) {
if (vo == null) {
return null;
} else {
EtatImage item = new EtatImage();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getLibelle()))
        item.setLibelle(vo.getLibelle());
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(vo.getCode());


return item;
}
}

@Override
public EtatImageVo toVo(EtatImage item) {
if (item == null) {
return null;
} else {
EtatImageVo vo = new EtatImageVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getLibelle()))
        vo.setLibelle(item.getLibelle());

        if(StringUtil.isNotEmpty(item.getCode()))
        vo.setCode(item.getCode());


return vo;
}
}

public void init(Boolean value) {
}









}
