package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Abonnement;
import com.ird.faa.ws.rest.provided.vo.AbonnementVo;

@Component
public class AbonnementConverter extends AbstractConverter<Abonnement,AbonnementVo>{

        @Autowired
        private EtatAbonnementConverter etatAbonnementConverter ;
        @Autowired
        private PackAbonnementConverter packAbonnementConverter ;
        @Autowired
        private ClientConverter clientConverter ;
    private Boolean etatAbonnement;
    private Boolean client;
    private Boolean packAbonnement;

public  AbonnementConverter(){
init(true);
}

@Override
public Abonnement toItem(AbonnementVo vo) {
if (vo == null) {
return null;
} else {
Abonnement item = new Abonnement();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getDateDebut()))
        item.setDateDebut(DateUtil.parse(vo.getDateDebut()));
        if(StringUtil.isNotEmpty(vo.getDateFin()))
        item.setDateFin(DateUtil.parse(vo.getDateFin()));
        if(StringUtil.isNotEmpty(vo.getTarif()))
        item.setTarif(NumberUtil.toDouble(vo.getTarif()));
        if(StringUtil.isNotEmpty(vo.getReduction()))
        item.setReduction(NumberUtil.toDouble(vo.getReduction()));
    if(vo.getEtatAbonnementVo()!=null && this.etatAbonnement)
        item.setEtatAbonnement(etatAbonnementConverter.toItem(vo.getEtatAbonnementVo())) ;
    if(vo.getClientVo()!=null && this.client)
        item.setClient(clientConverter.toItem(vo.getClientVo())) ;
    if(vo.getPackAbonnementVo()!=null && this.packAbonnement)
        item.setPackAbonnement(packAbonnementConverter.toItem(vo.getPackAbonnementVo())) ;


return item;
}
}

@Override
public AbonnementVo toVo(Abonnement item) {
if (item == null) {
return null;
} else {
AbonnementVo vo = new AbonnementVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(item.getDateDebut()!=null)
        vo.setDateDebut(DateUtil.formateDate(item.getDateDebut()));
        if(item.getDateFin()!=null)
        vo.setDateFin(DateUtil.formateDate(item.getDateFin()));
        if(item.getTarif()!=null)
        vo.setTarif(NumberUtil.toString(item.getTarif()));

        if(item.getReduction()!=null)
        vo.setReduction(NumberUtil.toString(item.getReduction()));

    if(item.getEtatAbonnement()!=null && this.etatAbonnement) {
        vo.setEtatAbonnementVo(etatAbonnementConverter.toVo(item.getEtatAbonnement())) ;
    }
    if(item.getClient()!=null && this.client) {
        vo.setClientVo(clientConverter.toVo(item.getClient())) ;
    }
    if(item.getPackAbonnement()!=null && this.packAbonnement) {
        vo.setPackAbonnementVo(packAbonnementConverter.toVo(item.getPackAbonnement())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    etatAbonnement = value;
    client = value;
    packAbonnement = value;
}


        public EtatAbonnementConverter getEtatAbonnementConverter(){
        return this.etatAbonnementConverter;
        }
        public void setEtatAbonnementConverter(EtatAbonnementConverter etatAbonnementConverter ){
        this.etatAbonnementConverter = etatAbonnementConverter;
        }
        public PackAbonnementConverter getPackAbonnementConverter(){
        return this.packAbonnementConverter;
        }
        public void setPackAbonnementConverter(PackAbonnementConverter packAbonnementConverter ){
        this.packAbonnementConverter = packAbonnementConverter;
        }
        public ClientConverter getClientConverter(){
        return this.clientConverter;
        }
        public void setClientConverter(ClientConverter clientConverter ){
        this.clientConverter = clientConverter;
        }

    public boolean  isEtatAbonnement(){
    return this.etatAbonnement;
    }
    public void  setEtatAbonnement(boolean etatAbonnement){
    this.etatAbonnement = etatAbonnement;
    }
    public boolean  isClient(){
    return this.client;
    }
    public void  setClient(boolean client){
    this.client = client;
    }
    public boolean  isPackAbonnement(){
    return this.packAbonnement;
    }
    public void  setPackAbonnement(boolean packAbonnement){
    this.packAbonnement = packAbonnement;
    }
















}
