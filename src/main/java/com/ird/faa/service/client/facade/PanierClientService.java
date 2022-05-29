package com.ird.faa.service.client.facade;

import java.util.List;
import com.ird.faa.bean.Panier;
import com.ird.faa.ws.rest.provided.vo.PanierVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface PanierClientService extends AbstractService<Panier,Long,PanierVo>{





/**
    * delete Panier from database
    * @param id - id of Panier to be deleted
    *
    */
    int deleteById(Long id);


    List<Panier> findByEtatPanierCode(String code);

    int deleteByEtatPanierCode(String code);

    List<Panier> findByEtatPanierId(Long id);

    int deleteByEtatPanierId(Long id);







}
