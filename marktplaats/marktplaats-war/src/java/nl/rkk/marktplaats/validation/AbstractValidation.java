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
public abstract class AbstractValidation implements IValidation {
    
    protected String error;
    
    public abstract boolean validate();
    
    public void addError(String error) {
        this.error = error;
    }
    
    public String getError() {
        return this.error;
    }
    
}
