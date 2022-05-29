package com.ird.faa.service.chercheur.impl;

import java.util.List;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Panier;
        import com.ird.faa.bean.EtatPanier;
        import com.ird.faa.bean.PanierItem;
import com.ird.faa.dao.PanierDao;
import com.ird.faa.service.chercheur.facade.PanierChercheurService;
        import com.ird.faa.service.chercheur.facade.PanierItemChercheurService;
        import com.ird.faa.service.chercheur.facade.EtatPanierChercheurService;

import com.ird.faa.ws.rest.provided.vo.PanierVo;
import com.ird.faa.service.util.*;
        import com.ird.faa.bean.PanierItem;
        import com.ird.faa.service.chercheur.facade.PanierItemChercheurService;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class PanierChercheurServiceImpl extends AbstractServiceImpl<Panier> implements PanierChercheurService {

@Autowired
private PanierDao panierDao;

        @Autowired
        private PanierItemChercheurService panierItemService ;
        @Autowired
        private EtatPanierChercheurService etatPanierService ;


@Autowired
private EntityManager entityManager;


@Override
public List<Panier> findAll(){
        return panierDao.findAll();
}

        @Override
        public List<Panier> findByEtatPanierCode(String code){
        return panierDao.findByEtatPanierCode(code);
        }

        @Override
        @Transactional
        public int deleteByEtatPanierCode(String code){
        return panierDao.deleteByEtatPanierCode(code);
        }

        @Override
        public List<Panier> findByEtatPanierId(Long id){
        return panierDao.findByEtatPanierId(id);
        }

        @Override
        @Transactional
        public int deleteByEtatPanierId(Long id){
        return panierDao.deleteByEtatPanierId(id);
        }


@Override
public Panier findById(Long id){
if(id==null) return null;
return panierDao.getOne(id);
}

@Override
public Panier findByIdWithAssociatedList(Long id){
    Panier panier  = findById(id);
    findAssociatedLists(panier);
    return panier;
}

    private void findAssociatedLists(Panier panier){
    if(panier!=null && panier.getId() != null) {
            List<PanierItem> panierItems = panierItemService.findByPanierId(panier.getId());
            panier.setPanierItems(panierItems);
    }
    }
    private void deleteAssociatedLists(Long id){
    if(id != null ) {
            panierItemService.deleteByPanierId(id);
    }
    }

    private void updateAssociatedLists(Panier panier){
    if(panier !=null && panier.getId() != null){
            List
            <List<PanierItem>> resultPanierItems= panierItemService.getToBeSavedAndToBeDeleted(panierItemService.findByPanierId(panier.getId()),panier.getPanierItems());
            panierItemService.delete(resultPanierItems.get(1));
            associatePanierItem(panier,resultPanierItems.get(0));
            panierItemService.update(resultPanierItems.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
int res=0;
if(panierDao.findById(id).isPresent())  {
    deleteAssociatedLists(id);
panierDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Panier update(Panier panier){
Panier foundedPanier = findById(panier.getId());
if(foundedPanier==null) return null;
else{
    updateAssociatedLists(panier);
return  panierDao.save(panier);
}
}

@Override
public Panier save (Panier panier){

    Panier result =null;


    findEtatPanier(panier);

    Panier savedPanier = panierDao.save(panier);

        savePanierItems(savedPanier,panier.getPanierItems());
    result = savedPanier;

    return result;
}

@Override
public List<Panier> save(List<Panier> paniers){
List<Panier> list = new ArrayList<>();
for(Panier panier: paniers){
list.add(save(panier));
}
return list;
}

        private List<PanierItem> preparePanierItems(Panier panier,List<PanierItem> panierItems){
        for(PanierItem panierItem:panierItems ){
        panierItem.setPanier(panier);
        }
        return panierItems;
        }


@Override
@Transactional
public int delete(Panier panier){
    if(panier.getId()==null) return -1;
    Panier foundedPanier = findById(panier.getId());
    if(foundedPanier==null) return -1;
panierDao.delete(foundedPanier);
return 1;
}


public List<Panier> findByCriteria(PanierVo panierVo){

String query = "SELECT o FROM Panier o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",panierVo.getId());
            query += SearchUtil.addConstraint( "o", "reference","LIKE",panierVo.getReference());
            query += SearchUtil.addConstraint( "o", "prixTotal","=",panierVo.getPrixTotal());
            query += SearchUtil.addConstraintMinMax("o","prixTotal",panierVo.getPrixTotalMin(),panierVo.getPrixTotalMax());
    if(panierVo.getEtatPanierVo()!=null){
        query += SearchUtil.addConstraint( "o", "etatPanier.id","=",panierVo.getEtatPanierVo().getId());
            query += SearchUtil.addConstraint( "o", "etatPanier.code","LIKE",panierVo.getEtatPanierVo().getCode());
    }

return entityManager.createQuery(query).getResultList();
}
        private  void savePanierItems(Panier panier,List<PanierItem> panierItems){

        if (ListUtil.isNotEmpty(panier.getPanierItems())) {
        List<PanierItem> savedPanierItems = new ArrayList<>();
        panierItems.forEach(element -> {
        element.setPanier(panier);
         panierItemService.save(element);
        });
        panier.setPanierItems(savedPanierItems);
        }
        }

    private void findEtatPanier(Panier panier){
        EtatPanier loadedEtatPanier =etatPanierService.findByIdOrCode(panier.getEtatPanier());

    if(loadedEtatPanier==null ) {
    return;
    }
    panier.setEtatPanier(loadedEtatPanier);
    }

@Override
@Transactional
public void delete(List<Panier> paniers){
if(ListUtil.isNotEmpty(paniers)){
paniers.forEach(e->panierDao.delete(e));
}
}
@Override
public void update(List<Panier> paniers){
if(ListUtil.isNotEmpty(paniers)){
paniers.forEach(e->panierDao.save(e));
}
}

        private void associatePanierItem(Panier panier, List<PanierItem> panierItem) {
        if (ListUtil.isNotEmpty(panierItem)) {
        panierItem.forEach(e -> e.setPanier(panier));
        }
        }




    }
