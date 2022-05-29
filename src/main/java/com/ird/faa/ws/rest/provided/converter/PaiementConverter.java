package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Paiement;
import com.ird.faa.ws.rest.provided.vo.PaiementVo;

@Component
public class PaiementConverter extends AbstractConverter<Paiement,PaiementVo>{

        @Autowired
        private OffreReductionConverter offreReductionConverter ;
    private Boolean offreReduction;

public  PaiementConverter(){
init(true);
}

@Override
public Paiement toItem(PaiementVo vo) {
if (vo == null) {
return null;
} else {
Paiement item = new Paiement();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getCode()))
        item.setCode(vo.getCode());
        if(StringUtil.isNotEmpty(vo.getMontantHt()))
        item.setMontantHt(NumberUtil.toDouble(vo.getMontantHt()));
        if(StringUtil.isNotEmpty(vo.getMontantTtc()))
        item.setMontantTtc(NumberUtil.toDouble(vo.getMontantTtc()));
        if(StringUtil.isNotEmpty(vo.getMontantTva()))
        item.setMontantTva(NumberUtil.toDouble(vo.getMontantTva()));
        if(StringUtil.isNotEmpty(vo.getDatePaiement()))
        item.setDatePaiement(DateUtil.parse(vo.getDatePaiement()));
        if(StringUtil.isNotEmpty(vo.getPourcentageReduction()))
        item.setPourcentageReduction(NumberUtil.toDouble(vo.getPourcentageReduction()));
    if(vo.getOffreReductionVo()!=null && this.offreReduction)
        item.setOffreReduction(offreReductionConverter.toItem(vo.getOffreReductionVo())) ;


return item;
}
}

@Override
public PaiementVo toVo(Paiement item) {
if (item == null) {
return null;
} else {
PaiementVo vo = new PaiementVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getCode()))
        vo.setCode(item.getCode());

        if(item.getMontantHt()!=null)
        vo.setMontantHt(NumberUtil.toString(item.getMontantHt()));

        if(item.getMontantTtc()!=null)
        vo.setMontantTtc(NumberUtil.toString(item.getMontantTtc()));

        if(item.getMontantTva()!=null)
        vo.setMontantTva(NumberUtil.toString(item.getMontantTva()));

        if(item.getDatePaiement()!=null)
        vo.setDatePaiement(DateUtil.formateDate(item.getDatePaiement()));
        if(item.getPourcentageReduction()!=null)
        vo.setPourcentageReduction(NumberUtil.toString(item.getPourcentageReduction()));

    if(item.getOffreReduction()!=null && this.offreReduction) {
        vo.setOffreReductionVo(offreReductionConverter.toVo(item.getOffreReduction())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    offreReduction = value;
}


        public OffreReductionConverter getOffreReductionConverter(){
        return this.offreReductionConverter;
        }
        public void setOffreReductionConverter(OffreReductionConverter offreReductionConverter ){
        this.offreReductionConverter = offreReductionConverter;
        }

    public boolean  isOffreReduction(){
    return this.offreReduction;
    }
    public void  setOffreReduction(boolean offreReduction){
    this.offreReduction = offreReduction;
    }
















}
