package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.PackAbonnement;
import com.ird.faa.ws.rest.provided.vo.PackAbonnementVo;

@Component
public class PackAbonnementConverter extends AbstractConverter<PackAbonnement,PackAbonnementVo>{


public  PackAbonnementConverter(){
init(true);
}

@Override
public PackAbonnement toItem(PackAbonnementVo vo) {
if (vo == null) {
return null;
} else {
PackAbonnement item = new PackAbonnement();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getNombreImageMax()))
        item.setNombreImageMax(NumberUtil.toDouble(vo.getNombreImageMax()));
        if(StringUtil.isNotEmpty(vo.getReduction()))
        item.setReduction(NumberUtil.toDouble(vo.getReduction()));
        if(StringUtil.isNotEmpty(vo.getDateMin()))
        item.setDateMin(DateUtil.parse(vo.getDateMin()));
        if(StringUtil.isNotEmpty(vo.getDateMax()))
        item.setDateMax(DateUtil.parse(vo.getDateMax()));


return item;
}
}

@Override
public PackAbonnementVo toVo(PackAbonnement item) {
if (item == null) {
return null;
} else {
PackAbonnementVo vo = new PackAbonnementVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(item.getNombreImageMax()!=null)
        vo.setNombreImageMax(NumberUtil.toString(item.getNombreImageMax()));

        if(item.getReduction()!=null)
        vo.setReduction(NumberUtil.toString(item.getReduction()));

        if(item.getDateMin()!=null)
        vo.setDateMin(DateUtil.formateDate(item.getDateMin()));
        if(item.getDateMax()!=null)
        vo.setDateMax(DateUtil.formateDate(item.getDateMax()));

return vo;
}
}

public void init(Boolean value) {
}













}
