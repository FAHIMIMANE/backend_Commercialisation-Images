package com.ird.faa.ws.rest.provided.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ird.faa.service.util.*;


import com.ird.faa.bean.Client;
import com.ird.faa.ws.rest.provided.vo.ClientVo;

@Component
public class ClientConverter extends AbstractConverter<Client, ClientVo> {

    @Autowired
    private ImageConverter imageConverter;
    private Boolean images;

    public ClientConverter() {
        init(true);
    }


    @Override
    public Client toItem(ClientVo vo) {
        if (vo == null) {
            return null;
        } else {
            Client item = new Client();
            if (StringUtil.isNotEmpty(vo.getId()))
                item.setId(NumberUtil.toLong(vo.getId()));
            if (StringUtil.isNotEmpty(vo.getNumeroMatricule()))
                item.setNumeroMatricule(vo.getNumeroMatricule());
            if (StringUtil.isNotEmpty(vo.getEmailPrincipale()))
                item.setEmailPrincipale(vo.getEmailPrincipale());
            if (StringUtil.isNotEmpty(vo.getResume()))
                item.setResume(vo.getResume());
            /* for all boolean except enabled with true default value
            if(vo.getCredentialsNonExpired()== null)
                item.setCredentialsNonExpired(false);
            else
            item.setCredentialsNonExpired(vo.getCredentialsNonExpired());
            */
            item.setCredentialsNonExpired(true);

            item.setEnabled(true);
            item.setAccountNonExpired(true);
            item.setAccountNonLocked(true);
            item.setPasswordChanged(true);

            if (StringUtil.isNotEmpty(vo.getCreatedAt()))
                item.setCreatedAt(DateUtil.parse(vo.getCreatedAt()));
            if (StringUtil.isNotEmpty(vo.getUpdatedAt()))
                item.setUpdatedAt(DateUtil.parse(vo.getUpdatedAt()));
            if (StringUtil.isNotEmpty(vo.getUsername()))
                item.setUsername(vo.getUsername());
            if (StringUtil.isNotEmpty(vo.getPassword()))
                item.setPassword(vo.getPassword());
            if (StringUtil.isNotEmpty(vo.getPrenom()))
                item.setPrenom(vo.getPrenom());
            if (StringUtil.isNotEmpty(vo.getNom()))
                item.setNom(vo.getNom());
            if (StringUtil.isNotEmpty(vo.getEquivalenceAvecPanelErc()))
                item.setEquivalenceAvecPanelErc(vo.getEquivalenceAvecPanelErc());
            if (StringUtil.isNotEmpty(vo.getBaseHorizon()))
                item.setBaseHorizon(vo.getBaseHorizon());
            if (StringUtil.isNotEmpty(vo.getRole()))
                item.setRole(vo.getRole());
            if (StringUtil.isNotEmpty(vo.getNumeroDeTel()))
                item.setNumeroDeTel(vo.getNumeroDeTel());
            if (StringUtil.isNotEmpty(vo.getCodePostal()))
                item.setCodePostal(vo.getCodePostal());
            if (StringUtil.isNotEmpty(vo.getRib()))
                item.setRib(vo.getRib());

            if (ListUtil.isNotEmpty(vo.getImagesVo()) && this.images)
                item.setImages(imageConverter.toItem(vo.getImagesVo()));

            return item;
        }
    }

    @Override
    public ClientVo toVo(Client item) {
        if (item == null) {
            return null;
        } else {
            ClientVo vo = new ClientVo();
            if (item.getId() != null)
                vo.setId(NumberUtil.toString(item.getId()));

            if (StringUtil.isNotEmpty(item.getNumeroMatricule()))
                vo.setNumeroMatricule(item.getNumeroMatricule());

            if (StringUtil.isNotEmpty(item.getEmailPrincipale()))
                vo.setEmailPrincipale(item.getEmailPrincipale());

            if (StringUtil.isNotEmpty(item.getResume()))
                vo.setResume(item.getResume());

            vo.setCredentialsNonExpired(item.getCredentialsNonExpired());
            vo.setEnabled(item.getEnabled());
            vo.setAccountNonExpired(item.getAccountNonExpired());
            vo.setAccountNonLocked(item.getAccountNonLocked());
            vo.setPasswordChanged(item.getPasswordChanged());
            if (item.getCreatedAt() != null)
                vo.setCreatedAt(DateUtil.formateDate(item.getCreatedAt()));
            if (item.getUpdatedAt() != null)
                vo.setUpdatedAt(DateUtil.formateDate(item.getUpdatedAt()));
            if (StringUtil.isNotEmpty(item.getUsername()))
                vo.setUsername(item.getUsername());

            if (StringUtil.isNotEmpty(item.getPassword()))
                vo.setPassword(item.getPassword());

            if (StringUtil.isNotEmpty(item.getPrenom()))
                vo.setPrenom(item.getPrenom());

            if (StringUtil.isNotEmpty(item.getNom()))
                vo.setNom(item.getNom());

            if (StringUtil.isNotEmpty(item.getEquivalenceAvecPanelErc()))
                vo.setEquivalenceAvecPanelErc(item.getEquivalenceAvecPanelErc());

            if (StringUtil.isNotEmpty(item.getBaseHorizon()))
                vo.setBaseHorizon(item.getBaseHorizon());

            if (StringUtil.isNotEmpty(item.getRole()))
                vo.setRole(item.getRole());

            if (StringUtil.isNotEmpty(item.getNumeroDeTel()))
                vo.setNumeroDeTel(item.getNumeroDeTel());

            if (StringUtil.isNotEmpty(item.getCodePostal()))
                vo.setCodePostal(item.getCodePostal());

            if (StringUtil.isNotEmpty(item.getRib()))
                vo.setRib(item.getRib());

            if (ListUtil.isNotEmpty(item.getImages()) && this.images) {
                imageConverter.init(true);
                imageConverter.setClient(false);
                vo.setImagesVo(imageConverter.toVo(item.getImages()));
                imageConverter.setClient(true);
            }

            return vo;
        }
    }

    public void init(Boolean value) {
        images = value;
    }


    public ImageConverter getImageConverter() {
        return this.imageConverter;
    }

    public void setImageConverter(ImageConverter imageConverter) {
        this.imageConverter = imageConverter;
    }


    public Boolean isImages() {
        return this.images;
    }

    public void setImages(Boolean images) {
        this.images = images;
    }


}
