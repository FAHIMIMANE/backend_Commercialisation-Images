package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.TypeContrat;
import com.ird.faa.ws.rest.provided.vo.TypeContratVo;

@Component
public class TypeContratConverter extends AbstractConverter<TypeContrat,TypeContratVo>{


public  TypeContratConverter(){
init(true);
}

@Override
public TypeContrat toItem(TypeContratVo vo) {
if (vo == null) {
return null;
} else {
TypeContrat item = new TypeContrat();
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
public TypeContratVo toVo(TypeContrat item) {
if (item == null) {
return null;
} else {
TypeContratVo vo = new TypeContratVo();
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
