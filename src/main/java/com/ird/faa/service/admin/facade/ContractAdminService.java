package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.Contract;
import com.ird.faa.ws.rest.provided.vo.ContractVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface ContractAdminService extends AbstractService<Contract,Long,ContractVo>{



    /**
    * find Contract from database by reference (reference)
    * @param reference - reference of Contract
    * @return the founded Contract , If no Contract were
    *         found in database return  null.
    */
    Contract findByReference(String reference);

    /**
    * find Contract from database by id (PK) or reference (reference)
    * @param id - id of Contract
    * @param reference - reference of Contract
    * @return the founded Contract , If no Contract were
    *         found in database return  null.
    */
    Contract findByIdOrReference(Contract contract);


/**
    * delete Contract from database
    * @param id - id of Contract to be deleted
    *
    */
    int deleteById(Long id);



    List<Contract> findByTypeContratId(Long id);

    int deleteByTypeContratId(Long id);


    /**
    * delete Contract from database by reference (reference)
    *
    * @param reference - reference of Contract to be deleted
    * @return 1 if Contract deleted successfully
    */
    int deleteByReference(String reference);




    Contract archiver(Contract contract) ;
    Contract desarchiver(Contract contract);

}
