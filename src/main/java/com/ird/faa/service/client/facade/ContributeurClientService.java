package com.ird.faa.service.client.facade;

import java.util.List;
import com.ird.faa.bean.Contributeur;
import com.ird.faa.ws.rest.provided.vo.ContributeurVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface ContributeurClientService extends AbstractService<Contributeur,Long,ContributeurVo>{

    Contributeur findByUsername(String username);


    /**
    * find Contributeur from database by numeroMatricule (reference)
    * @param numeroMatricule - reference of Contributeur
    * @return the founded Contributeur , If no Contributeur were
    *         found in database return  null.
    */
    Contributeur findByNumeroMatricule(String numeroMatricule);

    /**
    * find Contributeur from database by id (PK) or numeroMatricule (reference)
    * @param id - id of Contributeur
    * @param numeroMatricule - reference of Contributeur
    * @return the founded Contributeur , If no Contributeur were
    *         found in database return  null.
    */
    Contributeur findByIdOrNumeroMatricule(Contributeur contributeur);


/**
    * delete Contributeur from database
    * @param id - id of Contributeur to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete Contributeur from database by numeroMatricule (reference)
    *
    * @param numeroMatricule - reference of Contributeur to be deleted
    * @return 1 if Contributeur deleted successfully
    */
    int deleteByNumeroMatricule(String numeroMatricule);





}
