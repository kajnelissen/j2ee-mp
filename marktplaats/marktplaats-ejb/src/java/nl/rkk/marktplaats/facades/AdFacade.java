/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.rkk.marktplaats.facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nl.rkk.marktplaats.models.Ad;

/**
 *
 * @author Kaj
 */
@Stateless
public class AdFacade extends AbstractFacade<Ad> implements AdFacadeLocal {
    @PersistenceContext(unitName = "marktplaats-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AdFacade() {
        super(Ad.class);
    }
    
    @Override
    public void create(String titel, String beschrijving, String categorie, Double prijs){
    
        Ad ad = new Ad();
        
        ad.setTitle(titel);
        ad.setDescription(beschrijving);
        ad.setCategory(categorie);
        ad.setPrice(prijs);
        this.create(ad);
        
    }

    @Override
    public List<Ad> findAdvertisment(Integer id) {
        
        return em.createQuery("SELECT * FROM Ad a WHERE a.id LIKE :id")
                .setParameter("id",id)
                .getResultList();
                   
    }

        
}
