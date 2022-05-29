package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Abonnement;
        import com.ird.faa.bean.EtatAbonnement;
        import com.ird.faa.bean.Client;
        import com.ird.faa.bean.PackAbonnement;
import com.ird.faa.dao.AbonnementDao;
import com.ird.faa.service.admin.facade.AbonnementAdminService;
        import com.ird.faa.service.admin.facade.EtatAbonnementAdminService;
        import com.ird.faa.service.admin.facade.PackAbonnementAdminService;
        import com.ird.faa.service.admin.facade.ClientAdminService;

import com.ird.faa.ws.rest.provided.vo.AbonnementVo;
import com.ird.faa.service.util.*;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class AbonnementAdminServiceImpl extends AbstractServiceImpl<Abonnement> implements AbonnementAdminService {

@Autowired
private AbonnementDao abonnementDao;

        @Autowired
        private EtatAbonnementAdminService etatAbonnementService ;
        @Autowired
        private PackAbonnementAdminService packAbonnementService ;
        @Autowired
        private ClientAdminService clientService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Abonnement> findAll(){
        String query = "SELECT o FROM Abonnement o where 1=1 ";
        query+= " ORDER BY o.dateDebut";
        return entityManager.createQuery(query).getResultList();
}

        @Override
        public List<Abonnement> findByEtatAbonnementCode(String code){
        return abonnementDao.findByEtatAbonnementCode(code);
        }

        @Override
        @Transactional
        public int deleteByEtatAbonnementCode(String code){
        return abonnementDao.deleteByEtatAbonnementCode(code);
        }

        @Override
        public List<Abonnement> findByEtatAbonnementId(Long id){
        return abonnementDao.findByEtatAbonnementId(id);
        }

        @Override
        @Transactional
        public int deleteByEtatAbonnementId(Long id){
        return abonnementDao.deleteByEtatAbonnementId(id);
        }


        @Override
        public List<Abonnement> findByClientNumeroMatricule(String numeroMatricule){
        return abonnementDao.findByClientNumeroMatricule(numeroMatricule);
        }

        @Override
        @Transactional
        public int deleteByClientNumeroMatricule(String numeroMatricule){
        return abonnementDao.deleteByClientNumeroMatricule(numeroMatricule);
        }

        @Override
        public List<Abonnement> findByClientId(Long id){
        return abonnementDao.findByClientId(id);
        }

        @Override
        @Transactional
        public int deleteByClientId(Long id){
        return abonnementDao.deleteByClientId(id);
        }


        @Override
        public List<Abonnement> findByPackAbonnementNombreImageMax(Double nombreImageMax){
        return abonnementDao.findByPackAbonnementNombreImageMax(nombreImageMax);
        }

        @Override
        @Transactional
        public int deleteByPackAbonnementNombreImageMax(Double nombreImageMax){
        return abonnementDao.deleteByPackAbonnementNombreImageMax(nombreImageMax);
        }

        @Override
        public List<Abonnement> findByPackAbonnementId(Long id){
        return abonnementDao.findByPackAbonnementId(id);
        }

        @Override
        @Transactional
        public int deleteByPackAbonnementId(Long id){
        return abonnementDao.deleteByPackAbonnementId(id);
        }


@Override
public Abonnement findById(Long id){
if(id==null) return null;
return abonnementDao.getOne(id);
}

@Override
public Abonnement findByIdWithAssociatedList(Long id){
    return findById(id);
}



@Transactional
public int deleteById(Long id){
int res=0;
if(abonnementDao.findById(id).isPresent())  {
abonnementDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Abonnement update(Abonnement abonnement){
Abonnement foundedAbonnement = findById(abonnement.getId());
if(foundedAbonnement==null) return null;
else{
return  abonnementDao.save(abonnement);
}
}

@Override
public Abonnement save (Abonnement abonnement){



    findEtatAbonnement(abonnement);
    findClient(abonnement);
    findPackAbonnement(abonnement);

    return abonnementDao.save(abonnement);


}

@Override
public List<Abonnement> save(List<Abonnement> abonnements){
List<Abonnement> list = new ArrayList<>();
for(Abonnement abonnement: abonnements){
list.add(save(abonnement));
}
return list;
}



@Override
@Transactional
public int delete(Abonnement abonnement){
    if(abonnement.getId()==null) return -1;
    Abonnement foundedAbonnement = findById(abonnement.getId());
    if(foundedAbonnement==null) return -1;
abonnementDao.delete(foundedAbonnement);
return 1;
}


public List<Abonnement> findByCriteria(AbonnementVo abonnementVo){

String query = "SELECT o FROM Abonnement o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",abonnementVo.getId());
        query += SearchUtil.addConstraintDate( "o", "dateDebut","=",abonnementVo.getDateDebut());
        query += SearchUtil.addConstraintDate( "o", "dateFin","=",abonnementVo.getDateFin());
            query += SearchUtil.addConstraint( "o", "tarif","=",abonnementVo.getTarif());
            query += SearchUtil.addConstraint( "o", "reduction","=",abonnementVo.getReduction());
            query += SearchUtil.addConstraintMinMaxDate("o","dateDebut",abonnementVo.getDateDebutMin(),abonnementVo.getDateDebutMax());
            query += SearchUtil.addConstraintMinMaxDate("o","dateFin",abonnementVo.getDateFinMin(),abonnementVo.getDateFinMax());
            query += SearchUtil.addConstraintMinMax("o","tarif",abonnementVo.getTarifMin(),abonnementVo.getTarifMax());
            query += SearchUtil.addConstraintMinMax("o","reduction",abonnementVo.getReductionMin(),abonnementVo.getReductionMax());
    if(abonnementVo.getEtatAbonnementVo()!=null){
        query += SearchUtil.addConstraint( "o", "etatAbonnement.id","=",abonnementVo.getEtatAbonnementVo().getId());
            query += SearchUtil.addConstraint( "o", "etatAbonnement.code","LIKE",abonnementVo.getEtatAbonnementVo().getCode());
    }

    if(abonnementVo.getClientVo()!=null){
        query += SearchUtil.addConstraint( "o", "client.id","=",abonnementVo.getClientVo().getId());
            query += SearchUtil.addConstraint( "o", "client.numeroMatricule","LIKE",abonnementVo.getClientVo().getNumeroMatricule());
    }

    if(abonnementVo.getPackAbonnementVo()!=null){
        query += SearchUtil.addConstraint( "o", "packAbonnement.id","=",abonnementVo.getPackAbonnementVo().getId());
            query += SearchUtil.addConstraint( "o", "packAbonnement.nombreImageMax","=",abonnementVo.getPackAbonnementVo().getNombreImageMax());
    }

    query+= " ORDER BY o.dateDebut";
return entityManager.createQuery(query).getResultList();
}

    private void findEtatAbonnement(Abonnement abonnement){
        EtatAbonnement loadedEtatAbonnement =etatAbonnementService.findByIdOrCode(abonnement.getEtatAbonnement());

    if(loadedEtatAbonnement==null ) {
    return;
    }
    abonnement.setEtatAbonnement(loadedEtatAbonnement);
    }
    private void findClient(Abonnement abonnement){
        Client loadedClient =clientService.findByIdOrNumeroMatricule(abonnement.getClient());

    if(loadedClient==null ) {
    return;
    }
    abonnement.setClient(loadedClient);
    }
    private void findPackAbonnement(Abonnement abonnement){
        PackAbonnement loadedPackAbonnement =packAbonnementService.findByIdOrNombreImageMax(abonnement.getPackAbonnement());

    if(loadedPackAbonnement==null ) {
    return;
    }
    abonnement.setPackAbonnement(loadedPackAbonnement);
    }

@Override
@Transactional
public void delete(List<Abonnement> abonnements){
if(ListUtil.isNotEmpty(abonnements)){
abonnements.forEach(e->abonnementDao.delete(e));
}
}
@Override
public void update(List<Abonnement> abonnements){
if(ListUtil.isNotEmpty(abonnements)){
abonnements.forEach(e->abonnementDao.save(e));
}
}





    }
