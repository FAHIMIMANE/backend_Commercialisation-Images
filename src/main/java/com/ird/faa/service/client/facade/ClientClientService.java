package com.ird.faa.service.client.facade;

import java.util.List;
import com.ird.faa.bean.Client;
import com.ird.faa.ws.rest.provided.vo.ClientVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface ClientClientService extends AbstractService<Client,Long,ClientVo>{

    Client findByUsername(String username);


    /**
    * find Client from database by numeroMatricule (reference)
    * @param numeroMatricule - reference of Client
    * @return the founded Client , If no Client were
    *         found in database return  null.
    */
    Client findByNumeroMatricule(String numeroMatricule);

    /**
    * find Client from database by id (PK) or numeroMatricule (reference)
    * @param id - id of Client
    * @param numeroMatricule - reference of Client
    * @return the founded Client , If no Client were
    *         found in database return  null.
    */
    Client findByIdOrNumeroMatricule(Client client);


/**
    * delete Client from database
    * @param id - id of Client to be deleted
    *
    */
    int deleteById(Long id);




    /**
    * delete Client from database by numeroMatricule (reference)
    *
    * @param numeroMatricule - reference of Client to be deleted
    * @return 1 if Client deleted successfully
    */
    int deleteByNumeroMatricule(String numeroMatricule);


    Client saveWithImage(Client client);
}
