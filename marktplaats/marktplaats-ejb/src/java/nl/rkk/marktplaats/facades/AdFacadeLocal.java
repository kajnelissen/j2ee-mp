/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.rkk.marktplaats.facades;

import java.util.List;
import javax.ejb.Local;
import nl.rkk.marktplaats.models.Ad;

/**
 *
 * @author Kaj
 */
@Local
public interface AdFacadeLocal {

    void create(Ad ad);

    void edit(Ad ad);

    void remove(Ad ad);

    Ad find(Object id);

    List<Ad> findAll();

    List<Ad> findRange(int[] range);

    int count();
    
}
