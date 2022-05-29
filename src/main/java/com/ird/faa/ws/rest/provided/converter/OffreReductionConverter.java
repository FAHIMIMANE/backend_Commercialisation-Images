package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.OffreReduction;
import com.ird.faa.ws.rest.provided.vo.OffreReductionVo;

@Component
public class OffreReductionConverter extends AbstractConverter<OffreReduction,OffreReductionVo>{


public  OffreReductionConverter(){
init(true);
}

@Override
public OffreReduction toItem(OffreReductionVo vo) {
if (vo == null) {
return null;
} else {
OffreReduction item = new OffreReduction();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getQteMin()))
        item.setQteMin(NumberUtil.toDouble(vo.getQteMin()));
        if(StringUtil.isNotEmpty(vo.getQteMax()))
        item.setQteMax(NumberUtil.toDouble(vo.getQteMax()));
        if(StringUtil.isNotEmpty(vo.getPourcentage()))
        item.setPourcentage(NumberUtil.toDouble(vo.getPourcentage()));
        if(StringUtil.isNotEmpty(vo.getDateMin()))
        item.setDateMin(DateUtil.parse(vo.getDateMin()));
        if(StringUtil.isNotEmpty(vo.getDateMax()))
        item.setDateMax(DateUtil.parse(vo.getDateMax()));


return item;
}
}

@Override
public OffreReductionVo toVo(OffreReduction item) {
if (item == null) {
return null;
} else {
OffreReductionVo vo = new OffreReductionVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(item.getQteMin()!=null)
        vo.setQteMin(NumberUtil.toString(item.getQteMin()));

        if(item.getQteMax()!=null)
        vo.setQteMax(NumberUtil.toString(item.getQteMax()));

        if(item.getPourcentage()!=null)
        vo.setPourcentage(NumberUtil.toString(item.getPourcentage()));

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
