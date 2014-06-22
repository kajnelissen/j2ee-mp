/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.rkk.marktplaats.facades;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    public List<Bid> findAll(Integer adid)
    {        
        List<Bid> b = new ArrayList<Bid>();
        b = em.createQuery("SELECT * FROM BID WHERE AD_ID :adid").setParameter("adid", adid).getResultList();
        return b;
    }
}
