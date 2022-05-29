package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Contract;
import com.ird.faa.ws.rest.provided.vo.ContractVo;

@Component
public class ContractConverter extends AbstractConverter<Contract,ContractVo>{

        @Autowired
        private TypeContratConverter typeContratConverter ;
        @Autowired
        private SignatureConverter signatureConverter ;
    private Boolean typeContrat;
        private Boolean signatures;

public  ContractConverter(){
init(true);
}

@Override
public Contract toItem(ContractVo vo) {
if (vo == null) {
return null;
} else {
Contract item = new Contract();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getDateDebut()))
        item.setDateDebut(DateUtil.parse(vo.getDateDebut()));
        if(StringUtil.isNotEmpty(vo.getDateFin()))
        item.setDateFin(DateUtil.parse(vo.getDateFin()));
        if(StringUtil.isNotEmpty(vo.getObjet()))
        item.setObjet(vo.getObjet());
        if(StringUtil.isNotEmpty(vo.getContenu()))
        item.setContenu(vo.getContenu());
        if(StringUtil.isNotEmpty(vo.getReference()))
        item.setReference(vo.getReference());
            if(vo.getArchive() != null)
            item.setArchive(vo.getArchive());
        if(StringUtil.isNotEmpty(vo.getDateArchivage()))
        item.setDateArchivage(DateUtil.parse(vo.getDateArchivage()));
        if(StringUtil.isNotEmpty(vo.getDateCreation()))
        item.setDateCreation(DateUtil.parse(vo.getDateCreation()));
    if(vo.getTypeContratVo()!=null && this.typeContrat)
        item.setTypeContrat(typeContratConverter.toItem(vo.getTypeContratVo())) ;

    if(ListUtil.isNotEmpty(vo.getSignaturesVo()) && this.signatures)
        item.setSignatures(signatureConverter.toItem(vo.getSignaturesVo()));

return item;
}
}

@Override
public ContractVo toVo(Contract item) {
if (item == null) {
return null;
} else {
ContractVo vo = new ContractVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(item.getDateDebut()!=null)
        vo.setDateDebut(DateUtil.formateDate(item.getDateDebut()));
        if(item.getDateFin()!=null)
        vo.setDateFin(DateUtil.formateDate(item.getDateFin()));
        if(StringUtil.isNotEmpty(item.getObjet()))
        vo.setObjet(item.getObjet());

        if(StringUtil.isNotEmpty(item.getContenu()))
        vo.setContenu(item.getContenu());

        if(StringUtil.isNotEmpty(item.getReference()))
        vo.setReference(item.getReference());

        if(item.getArchive()!=null)
        vo.setArchive(item.getArchive());
        if(item.getDateArchivage()!=null)
        vo.setDateArchivage(DateUtil.formateDate(item.getDateArchivage()));
        if(item.getDateCreation()!=null)
        vo.setDateCreation(DateUtil.formateDate(item.getDateCreation()));
    if(item.getTypeContrat()!=null && this.typeContrat) {
        vo.setTypeContratVo(typeContratConverter.toVo(item.getTypeContrat())) ;
    }
        if(ListUtil.isNotEmpty(item.getSignatures()) && this.signatures){
        signatureConverter.init(true);
        signatureConverter.setContract(false);
        vo.setSignaturesVo(signatureConverter.toVo(item.getSignatures()));
        signatureConverter.setContract(true);
        }

return vo;
}
}

public void init(Boolean value) {
    typeContrat = value;
        signatures = value;
}


        public TypeContratConverter getTypeContratConverter(){
        return this.typeContratConverter;
        }
        public void setTypeContratConverter(TypeContratConverter typeContratConverter ){
        this.typeContratConverter = typeContratConverter;
        }
        public SignatureConverter getSignatureConverter(){
        return this.signatureConverter;
        }
        public void setSignatureConverter(SignatureConverter signatureConverter ){
        this.signatureConverter = signatureConverter;
        }

    public boolean  isTypeContrat(){
    return this.typeContrat;
    }
    public void  setTypeContrat(boolean typeContrat){
    this.typeContrat = typeContrat;
    }















        public Boolean  isSignatures(){
        return this.signatures ;
        }
        public void  setSignatures(Boolean signatures ){
        this.signatures  = signatures ;
        }








}
