package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.EtatPanier;
import com.ird.faa.ws.rest.provided.vo.EtatPanierVo;

@Component
public class EtatPanierConverter extends AbstractConverter<EtatPanier,EtatPanierVo>{


public  EtatPanierConverter(){
init(true);
}

@Override
public EtatPanier toItem(EtatPanierVo vo) {
if (vo == null) {
return null;
} else {
EtatPanier item = new EtatPanier();
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
public EtatPanierVo toVo(EtatPanier item) {
if (item == null) {
return null;
} else {
EtatPanierVo vo = new EtatPanierVo();
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
