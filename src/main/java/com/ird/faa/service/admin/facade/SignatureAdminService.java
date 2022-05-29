package com.ird.faa.service.admin.facade;

import java.util.List;
import com.ird.faa.bean.Signature;
import com.ird.faa.ws.rest.provided.vo.SignatureVo;
import com.ird.faa.service.core.facade.AbstractService;

public interface SignatureAdminService extends AbstractService<Signature,Long,SignatureVo>{





/**
    * delete Signature from database
    * @param id - id of Signature to be deleted
    *
    */
    int deleteById(Long id);


    List<Signature> findByContributeurNumeroMatricule(String numeroMatricule);

    int deleteByContributeurNumeroMatricule(String numeroMatricule);

    List<Signature> findByContributeurId(Long id);

    int deleteByContributeurId(Long id);
    List<Signature> findByContractReference(String reference);

    int deleteByContractReference(String reference);

    List<Signature> findByContractId(Long id);

    int deleteByContractId(Long id);







}
