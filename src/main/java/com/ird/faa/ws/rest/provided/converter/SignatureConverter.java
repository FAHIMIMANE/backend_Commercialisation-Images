package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Signature;
import com.ird.faa.ws.rest.provided.vo.SignatureVo;

@Component
public class SignatureConverter extends AbstractConverter<Signature,SignatureVo>{

        @Autowired
        private ContributeurConverter contributeurConverter ;
        @Autowired
        private ContractConverter contractConverter ;
    private Boolean contributeur;
    private Boolean contract;

public  SignatureConverter(){
init(true);
}

@Override
public Signature toItem(SignatureVo vo) {
if (vo == null) {
return null;
} else {
Signature item = new Signature();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getDateSignature()))
        item.setDateSignature(DateUtil.parse(vo.getDateSignature()));
    if(vo.getContributeurVo()!=null && this.contributeur)
        item.setContributeur(contributeurConverter.toItem(vo.getContributeurVo())) ;
    if(vo.getContractVo()!=null && this.contract)
        item.setContract(contractConverter.toItem(vo.getContractVo())) ;


return item;
}
}

@Override
public SignatureVo toVo(Signature item) {
if (item == null) {
return null;
} else {
SignatureVo vo = new SignatureVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(item.getDateSignature()!=null)
        vo.setDateSignature(DateUtil.formateDate(item.getDateSignature()));
    if(item.getContributeur()!=null && this.contributeur) {
        vo.setContributeurVo(contributeurConverter.toVo(item.getContributeur())) ;
    }
    if(item.getContract()!=null && this.contract) {
        vo.setContractVo(contractConverter.toVo(item.getContract())) ;
    }

return vo;
}
}

public void init(Boolean value) {
    contributeur = value;
    contract = value;
}


        public ContributeurConverter getContributeurConverter(){
        return this.contributeurConverter;
        }
        public void setContributeurConverter(ContributeurConverter contributeurConverter ){
        this.contributeurConverter = contributeurConverter;
        }
        public ContractConverter getContractConverter(){
        return this.contractConverter;
        }
        public void setContractConverter(ContractConverter contractConverter ){
        this.contractConverter = contractConverter;
        }

    public boolean  isContributeur(){
    return this.contributeur;
    }
    public void  setContributeur(boolean contributeur){
    this.contributeur = contributeur;
    }
    public boolean  isContract(){
    return this.contract;
    }
    public void  setContract(boolean contract){
    this.contract = contract;
    }








}
