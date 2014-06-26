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
import javax.persistence.TypedQuery;
import nl.rkk.marktplaats.models.Ad;
import nl.rkk.marktplaats.models.Bid;

/**
 *
 * @author Kaj
 */
@Stateless
public class BidFacade extends AbstractFacade<Bid> implements BidFacadeLocal {
    @PersistenceContext(unitName = "marktplaats-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BidFacade() {
        super(Bid.class);
    }
    
    @Override
    public List<Bid> findForAd(Ad ad) {
        //return this.em.createQuery("SELECT b FROM Bid b WHERE b.ad_id = :adId", Bid.class).setParameter("adId", ad.getId()).getResultList();
        //TypedQuery<Bid> query = this.em.createNamedQuery("Bid.findForAd", Bid.class);
        //query.setParameter("adId", ad.getId());
        return null;
        //return query.getResultList();
    }
    
    @Override
    public void create(Bid bid, Ad ad) {
        this.create(bid);
        this.em.persist(bid);
        this.em.persist(ad);
    }
    
}
