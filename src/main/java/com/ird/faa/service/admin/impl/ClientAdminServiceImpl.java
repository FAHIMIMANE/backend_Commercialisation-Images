package com.ird.faa.service.admin.impl;

import java.util.List;
    import java.util.Date;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import com.ird.faa.bean.Client;
        import com.ird.faa.bean.Image;
import com.ird.faa.dao.ClientDao;
import com.ird.faa.service.admin.facade.ClientAdminService;
        import com.ird.faa.service.admin.facade.ImageAdminService;

import com.ird.faa.ws.rest.provided.vo.ClientVo;
import com.ird.faa.service.util.*;
        import com.ird.faa.bean.Image;
        import com.ird.faa.service.admin.facade.ImageAdminService;

import com.ird.faa.service.core.impl.AbstractServiceImpl;

@Service
public class ClientAdminServiceImpl extends AbstractServiceImpl<Client> implements ClientAdminService {

@Autowired
private ClientDao clientDao;

        @Autowired
        private ImageAdminService imageService ;


@Autowired
private EntityManager entityManager;

    @Override
    public Client findByUsername(String username){
    return clientDao.findByUsername(username);
    }

@Override
public List<Client> findAll(){
        return clientDao.findAll();
}
    @Override
    public Client findByNumeroMatricule(String numeroMatricule){
    if( numeroMatricule==null) return null;
    return clientDao.findByNumeroMatricule(numeroMatricule);
    }

    @Override
    @Transactional
    public int deleteByNumeroMatricule(String  numeroMatricule) {
    return clientDao.deleteByNumeroMatricule(numeroMatricule);
    }
    @Override
    public Client findByIdOrNumeroMatricule(Client client){
    Client resultat=null;
    if(client != null){
    if(StringUtil.isNotEmpty(client.getId())){
    resultat= clientDao.getOne(client.getId());
    }else if(StringUtil.isNotEmpty(client.getNumeroMatricule())) {
    resultat= clientDao.findByNumeroMatricule(client.getNumeroMatricule());
    }else if(StringUtil.isNotEmpty(client.getUsername())) {
    resultat = clientDao.findByUsername(client.getUsername());
    }
    }
    return resultat;
    }

@Override
public Client findById(Long id){
if(id==null) return null;
return clientDao.getOne(id);
}

@Override
public Client findByIdWithAssociatedList(Long id){
    Client client  = findById(id);
    findAssociatedLists(client);
    return client;
}

    private void findAssociatedLists(Client client){
    if(client!=null && client.getId() != null) {
            List<Image> images = imageService.findByClientId(client.getId());
            client.setImages(images);
    }
    }
    private void deleteAssociatedLists(Long id){
    if(id != null ) {
            imageService.deleteByClientId(id);
    }
    }

    private void updateAssociatedLists(Client client){
    if(client !=null && client.getId() != null){
            List
            <List<Image>> resultImages= imageService.getToBeSavedAndToBeDeleted(imageService.findByClientId(client.getId()),client.getImages());
            imageService.delete(resultImages.get(1));
            associateImage(client,resultImages.get(0));
            imageService.update(resultImages.get(0));

    }
    }

@Transactional
public int deleteById(Long id){
int res=0;
if(clientDao.findById(id).isPresent())  {
    deleteAssociatedLists(id);
clientDao.deleteById(id);
res = 1;
}
return res;
}


@Override
public Client update(Client client){
Client foundedClient = findById(client.getId());
if(foundedClient==null) return null;
else{
    updateAssociatedLists(client);
return  clientDao.save(client);
}
}
    private void prepareSave(Client client){
                client.setCredentialsNonExpired(false);
                client.setEnabled(false);
                client.setAccountNonExpired(false);
                client.setAccountNonLocked(false);
                client.setPasswordChanged(false);




    }

@Override
public Client save (Client client){
    prepareSave(client);

    Client result =null;
        Client foundedClient = findByNumeroMatricule(client.getNumeroMatricule());
        Client foundedClientByUsername = findByNumeroMatricule(client.getNumeroMatricule());
        if(foundedClient == null && foundedClientByUsername == null){




    Client savedClient = clientDao.save(client);

        saveImages(savedClient,client.getImages());
    result = savedClient;
    }

    return result;
}

@Override
public List<Client> save(List<Client> clients){
List<Client> list = new ArrayList<>();
for(Client client: clients){
list.add(save(client));
}
return list;
}

        private List<Image> prepareImages(Client client,List<Image> images){
        for(Image image:images ){
        image.setClient(client);
        }
        return images;
        }


@Override
@Transactional
public int delete(Client client){
    if(client.getNumeroMatricule()==null) return -1;

    Client foundedClient = findByNumeroMatricule(client.getNumeroMatricule());
    if(foundedClient==null) return -1;
clientDao.delete(foundedClient);
return 1;
}


public List<Client> findByCriteria(ClientVo clientVo){

String query = "SELECT o FROM Client o where 1=1 ";

            query += SearchUtil.addConstraint( "o", "id","=",clientVo.getId());
            query += SearchUtil.addConstraint( "o", "numeroMatricule","LIKE",clientVo.getNumeroMatricule());
            query += SearchUtil.addConstraint( "o", "emailPrincipale","LIKE",clientVo.getEmailPrincipale());
            query += SearchUtil.addConstraint( "o", "resume","LIKE",clientVo.getResume());
            query += SearchUtil.addConstraint( "o", "credentialsNonExpired","=",clientVo.getCredentialsNonExpired());
            query += SearchUtil.addConstraint( "o", "enabled","=",clientVo.getEnabled());
            query += SearchUtil.addConstraint( "o", "accountNonExpired","=",clientVo.getAccountNonExpired());
            query += SearchUtil.addConstraint( "o", "accountNonLocked","=",clientVo.getAccountNonLocked());
            query += SearchUtil.addConstraint( "o", "passwordChanged","=",clientVo.getPasswordChanged());
        query += SearchUtil.addConstraintDate( "o", "createdAt","=",clientVo.getCreatedAt());
        query += SearchUtil.addConstraintDate( "o", "updatedAt","=",clientVo.getUpdatedAt());
            query += SearchUtil.addConstraint( "o", "username","LIKE",clientVo.getUsername());
            query += SearchUtil.addConstraint( "o", "password","LIKE",clientVo.getPassword());
            query += SearchUtil.addConstraint( "o", "prenom","LIKE",clientVo.getPrenom());
            query += SearchUtil.addConstraint( "o", "nom","LIKE",clientVo.getNom());
            query += SearchUtil.addConstraint( "o", "equivalenceAvecPanelErc","LIKE",clientVo.getEquivalenceAvecPanelErc());
            query += SearchUtil.addConstraint( "o", "baseHorizon","LIKE",clientVo.getBaseHorizon());
            query += SearchUtil.addConstraint( "o", "role","LIKE",clientVo.getRole());
            query += SearchUtil.addConstraint( "o", "numeroDeTel","LIKE",clientVo.getNumeroDeTel());
            query += SearchUtil.addConstraint( "o", "codePostal","LIKE",clientVo.getCodePostal());
            query += SearchUtil.addConstraint( "o", "rib","LIKE",clientVo.getRib());
            query += SearchUtil.addConstraintMinMaxDate("o","createdAt",clientVo.getCreatedAtMin(),clientVo.getCreatedAtMax());
            query += SearchUtil.addConstraintMinMaxDate("o","updatedAt",clientVo.getUpdatedAtMin(),clientVo.getUpdatedAtMax());
return entityManager.createQuery(query).getResultList();
}
        private  void saveImages(Client client,List<Image> images){

        if (ListUtil.isNotEmpty(client.getImages())) {
        List<Image> savedImages = new ArrayList<>();
        images.forEach(element -> {
        element.setClient(client);
         imageService.save(element);
        });
        client.setImages(savedImages);
        }
        }


@Override
@Transactional
public void delete(List<Client> clients){
if(ListUtil.isNotEmpty(clients)){
clients.forEach(e->clientDao.delete(e));
}
}
@Override
public void update(List<Client> clients){
if(ListUtil.isNotEmpty(clients)){
clients.forEach(e->clientDao.save(e));
}
}

        private void associateImage(Client client, List<Image> image) {
        if (ListUtil.isNotEmpty(image)) {
        image.forEach(e -> e.setClient(client));
        }
        }




    }
