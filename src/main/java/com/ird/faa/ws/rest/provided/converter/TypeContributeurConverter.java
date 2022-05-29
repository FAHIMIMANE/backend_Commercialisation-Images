package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.TypeContributeur;
import com.ird.faa.ws.rest.provided.vo.TypeContributeurVo;

@Component
public class TypeContributeurConverter extends AbstractConverter<TypeContributeur,TypeContributeurVo>{


public  TypeContributeurConverter(){
init(true);
}

@Override
public TypeContributeur toItem(TypeContributeurVo vo) {
if (vo == null) {
return null;
} else {
TypeContributeur item = new TypeContributeur();
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
public TypeContributeurVo toVo(TypeContributeur item) {
if (item == null) {
return null;
} else {
TypeContributeurVo vo = new TypeContributeurVo();
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
