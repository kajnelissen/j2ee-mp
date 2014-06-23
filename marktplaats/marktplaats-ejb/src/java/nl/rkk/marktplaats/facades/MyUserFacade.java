/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.rkk.marktplaats.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nl.rkk.marktplaats.models.MyUser;
import nl.rkk.marktplaats.models.UserRole;

/**
 *
 * @author Kaj
 */
@Stateless
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
    
    @Override
    public boolean create(String email, String password) {
        MyUser user = new MyUser(email, password);
        this.create(user);
        return true;
    }
    
    @Override
    public boolean create(String email, String password, UserRole type) {
        MyUser user = new MyUser(email, password, type);
        this.create(user);
        return true;
    }
    
    @Override
    public MyUser findUserByCredentials(String email, String password) {
        
        return null;
    }
    
}
