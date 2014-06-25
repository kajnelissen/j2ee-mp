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
    public void create(String email, String password) {
        MyUser user = new MyUser(email, password);
        this.create(user);
    }
    
    @Override
    public void create(String email, String password, UserRole type) {
        MyUser user = new MyUser(email, password, type);
        this.create(user);
    }
    
    @Override
    public void create(String email, String password, UserRole type, String firstName, String lastName) {
        MyUser user = new MyUser(email, password, type, firstName, lastName);
        this.create(user);
    }
    
    @Override
    public MyUser findUserByCredentials(String email, String password) {
        TypedQuery<MyUser> query = this.em.createNamedQuery("User.findByCredentials", MyUser.class);
        query.setParameter("email", email);
        query.setParameter("password", password);
        return query.getSingleResult();
    }
    
    @Override
    public boolean exists(String email) {
        TypedQuery<MyUser> query = this.em.createNamedQuery("User.findByEmail", MyUser.class);
        query.setParameter("email", email);
        List<MyUser> users = query.getResultList();
        return users.size() > 0;
    }
    
}
