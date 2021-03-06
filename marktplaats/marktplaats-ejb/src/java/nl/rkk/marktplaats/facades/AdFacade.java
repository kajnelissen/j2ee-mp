/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.rkk.marktplaats.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nl.rkk.marktplaats.models.Ad;
import nl.rkk.marktplaats.models.MyUser;

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
    public void create(String titel, String beschrijving, String categorie, Double prijs, MyUser user){
    
        Ad ad = new Ad();
        
        ad.setTitle(titel);
        ad.setDescription(beschrijving);
        ad.setCategory(categorie);
        ad.setPrice(prijs);
        ad.setUser(user);
        this.create(ad);
        
    }
    
}
