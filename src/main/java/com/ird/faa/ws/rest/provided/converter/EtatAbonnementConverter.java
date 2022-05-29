package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.EtatAbonnement;
import com.ird.faa.ws.rest.provided.vo.EtatAbonnementVo;

@Component
public class EtatAbonnementConverter extends AbstractConverter<EtatAbonnement,EtatAbonnementVo>{


public  EtatAbonnementConverter(){
init(true);
}

@Override
public EtatAbonnement toItem(EtatAbonnementVo vo) {
if (vo == null) {
return null;
} else {
EtatAbonnement item = new EtatAbonnement();
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
public EtatAbonnementVo toVo(EtatAbonnement item) {
if (item == null) {
return null;
} else {
EtatAbonnementVo vo = new EtatAbonnementVo();
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
