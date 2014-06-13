/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.rkk.marktplaats.serviceproviders;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import nl.rkk.marktplaats.facades.MyUserFacadeLocal;
import nl.rkk.marktplaats.models.MyUser;

/**
 *
 * @author Kaj
 */
public class UserProvider {
    
    /*@EJB
    private MyUserFacadeLocal users;
    
    public MyUser getUser(HttpServletRequest request, String email, String password) {
        MyUser user = new MyUser();
        user.setEmail(request.getParameter("email"));
        user.setPassword(BCrypt.hashpw(request.getParameter("password"), BCrypt.gensalt()));
        //user.setType(UserRole.User);
        users.create(user);
    }*/
    
}
