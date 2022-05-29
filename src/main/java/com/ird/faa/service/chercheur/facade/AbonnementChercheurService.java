package com.ird.faa.service.chercheur.facade;

import java.util.List;
import com.ird.faa.bean.Abonnement;
import com.ird.faa.ws.rest.provided.vo.AbonnementVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface AbonnementChercheurService extends AbstractService<Abonnement,Long,AbonnementVo>{





/**
    * delete Abonnement from database
    * @param id - id of Abonnement to be deleted
    *
    */
    int deleteById(Long id);


    List<Abonnement> findByEtatAbonnementCode(String code);

    int deleteByEtatAbonnementCode(String code);

    List<Abonnement> findByEtatAbonnementId(Long id);

    int deleteByEtatAbonnementId(Long id);
    List<Abonnement> findByClientNumeroMatricule(String numeroMatricule);

    int deleteByClientNumeroMatricule(String numeroMatricule);

    List<Abonnement> findByClientId(Long id);

    int deleteByClientId(Long id);
    List<Abonnement> findByPackAbonnementNombreImageMax(Double nombreImageMax);

    int deleteByPackAbonnementNombreImageMax(Double nombreImageMax);

    List<Abonnement> findByPackAbonnementId(Long id);

    int deleteByPackAbonnementId(Long id);







}
