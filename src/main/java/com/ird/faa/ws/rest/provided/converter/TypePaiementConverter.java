package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.TypePaiement;
import com.ird.faa.ws.rest.provided.vo.TypePaiementVo;

@Component
public class TypePaiementConverter extends AbstractConverter<TypePaiement,TypePaiementVo>{


public  TypePaiementConverter(){
init(true);
}

@Override
public TypePaiement toItem(TypePaiementVo vo) {
if (vo == null) {
return null;
} else {
TypePaiement item = new TypePaiement();
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
public TypePaiementVo toVo(TypePaiement item) {
if (item == null) {
return null;
} else {
TypePaiementVo vo = new TypePaiementVo();
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
