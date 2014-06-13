/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.rkk.marktplaats.validation;

/**
 *
 * @author Kaj
 */
public interface IValidation {
    
    public boolean validate();
    
    public void addError(String error);
    
    public String getError();
    
}
