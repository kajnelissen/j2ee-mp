/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.rkk.marktplaats.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import nl.rkk.marktplaats.models.MyUser;

/**
 *
 * @author Kaj
 */
@Stateless
/*@NamedQueries({
    @NamedQuery(name = "findByEmailPassword", query = "SELECT * FROM users WHERE email = :email AND password = :password")
})*/
public class MyUserFacade extends AbstractFacade<MyUser> implements MyUserFacadeLocal {
    @PersistenceContext(unitName = "marktplaats-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MyUserFacade() {
        super(MyUser.class);
    }
    
    public MyUser find(String email, String password) {
        MyUser user = (MyUser) em.createQuery("SELECT * FROM users WHERE email = '" + email + "' AND password = '" + password + "'").getSingleResult();
        return ( user == null ) ? null : user;
    }
    
}
