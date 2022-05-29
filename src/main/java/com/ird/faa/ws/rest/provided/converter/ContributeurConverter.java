package  com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Contributeur;
import com.ird.faa.ws.rest.provided.vo.ContributeurVo;

@Component
public class ContributeurConverter extends AbstractConverter<Contributeur,ContributeurVo>{

        @Autowired
        private BucketConverter bucketConverter ;
        private Boolean buckets;

public  ContributeurConverter(){
init(true);
}

@Override
public Contributeur toItem(ContributeurVo vo) {
if (vo == null) {
return null;
} else {
Contributeur item = new Contributeur();
        if(StringUtil.isNotEmpty(vo.getId()))
        item.setId(NumberUtil.toLong(vo.getId()));
        if(StringUtil.isNotEmpty(vo.getNumeroMatricule()))
        item.setNumeroMatricule(vo.getNumeroMatricule());
        if(StringUtil.isNotEmpty(vo.getEmailPrincipale()))
        item.setEmailPrincipale(vo.getEmailPrincipale());
        if(StringUtil.isNotEmpty(vo.getResume()))
        item.setResume(vo.getResume());
            item.setCredentialsNonExpired(vo.getCredentialsNonExpired());
            item.setEnabled(vo.getEnabled());
            item.setAccountNonExpired(vo.getAccountNonExpired());
            item.setAccountNonLocked(vo.getAccountNonLocked());
            item.setPasswordChanged(vo.getPasswordChanged());
        if(StringUtil.isNotEmpty(vo.getCreatedAt()))
        item.setCreatedAt(DateUtil.parse(vo.getCreatedAt()));
        if(StringUtil.isNotEmpty(vo.getUpdatedAt()))
        item.setUpdatedAt(DateUtil.parse(vo.getUpdatedAt()));
        if(StringUtil.isNotEmpty(vo.getUsername()))
        item.setUsername(vo.getUsername());
        if(StringUtil.isNotEmpty(vo.getPassword()))
        item.setPassword(vo.getPassword());
        if(StringUtil.isNotEmpty(vo.getPrenom()))
        item.setPrenom(vo.getPrenom());
        if(StringUtil.isNotEmpty(vo.getNom()))
        item.setNom(vo.getNom());
        if(StringUtil.isNotEmpty(vo.getCin()))
        item.setCin(vo.getCin());
        if(StringUtil.isNotEmpty(vo.getNumeroTelephone()))
        item.setNumeroTelephone(vo.getNumeroTelephone());
        if(StringUtil.isNotEmpty(vo.getAdresse()))
        item.setAdresse(vo.getAdresse());
        if(StringUtil.isNotEmpty(vo.getCodePostale()))
        item.setCodePostale(vo.getCodePostale());

    if(ListUtil.isNotEmpty(vo.getBucketsVo()) && this.buckets)
        item.setBuckets(bucketConverter.toItem(vo.getBucketsVo()));

return item;
}
}

@Override
public ContributeurVo toVo(Contributeur item) {
if (item == null) {
return null;
} else {
ContributeurVo vo = new ContributeurVo();
        if(item.getId()!=null)
        vo.setId(NumberUtil.toString(item.getId()));

        if(StringUtil.isNotEmpty(item.getNumeroMatricule()))
        vo.setNumeroMatricule(item.getNumeroMatricule());

        if(StringUtil.isNotEmpty(item.getEmailPrincipale()))
        vo.setEmailPrincipale(item.getEmailPrincipale());

        if(StringUtil.isNotEmpty(item.getResume()))
        vo.setResume(item.getResume());

        vo.setCredentialsNonExpired(item.getCredentialsNonExpired());
        vo.setEnabled(item.getEnabled());
        vo.setAccountNonExpired(item.getAccountNonExpired());
        vo.setAccountNonLocked(item.getAccountNonLocked());
        vo.setPasswordChanged(item.getPasswordChanged());
        if(item.getCreatedAt()!=null)
        vo.setCreatedAt(DateUtil.formateDate(item.getCreatedAt()));
        if(item.getUpdatedAt()!=null)
        vo.setUpdatedAt(DateUtil.formateDate(item.getUpdatedAt()));
        if(StringUtil.isNotEmpty(item.getUsername()))
        vo.setUsername(item.getUsername());

        if(StringUtil.isNotEmpty(item.getPassword()))
        vo.setPassword(item.getPassword());

        if(StringUtil.isNotEmpty(item.getPrenom()))
        vo.setPrenom(item.getPrenom());

        if(StringUtil.isNotEmpty(item.getNom()))
        vo.setNom(item.getNom());

        if(StringUtil.isNotEmpty(item.getCin()))
        vo.setCin(item.getCin());

        if(StringUtil.isNotEmpty(item.getNumeroTelephone()))
        vo.setNumeroTelephone(item.getNumeroTelephone());

        if(StringUtil.isNotEmpty(item.getAdresse()))
        vo.setAdresse(item.getAdresse());

        if(StringUtil.isNotEmpty(item.getCodePostale()))
        vo.setCodePostale(item.getCodePostale());

        if(ListUtil.isNotEmpty(item.getBuckets()) && this.buckets){
        bucketConverter.init(true);
        bucketConverter.setContributeur(false);
        vo.setBucketsVo(bucketConverter.toVo(item.getBuckets()));
        bucketConverter.setContributeur(true);
        }

return vo;
}
}

public void init(Boolean value) {
        buckets = value;
}


        public BucketConverter getBucketConverter(){
        return this.bucketConverter;
        }
        public void setBucketConverter(BucketConverter bucketConverter ){
        this.bucketConverter = bucketConverter;
        }








































        public Boolean  isBuckets(){
        return this.buckets ;
        }
        public void  setBuckets(Boolean buckets ){
        this.buckets  = buckets ;
        }


}
