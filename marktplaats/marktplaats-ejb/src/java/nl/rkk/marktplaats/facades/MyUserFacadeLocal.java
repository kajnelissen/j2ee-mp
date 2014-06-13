/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.rkk.marktplaats.facades;

import java.util.List;
import javax.ejb.Local;
import nl.rkk.marktplaats.models.MyUser;

/**
 *
 * @author Kaj
 */
@Local
public interface MyUserFacadeLocal {

    void create(MyUser myUser);

    void edit(MyUser myUser);

    void remove(MyUser myUser);

    MyUser find(Object id);

    List<MyUser> findAll();

    List<MyUser> findRange(int[] range);

    int count();
    
    boolean create(String email, String password);
    
}
