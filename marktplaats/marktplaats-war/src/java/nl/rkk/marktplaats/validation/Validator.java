/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.rkk.marktplaats.validation;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kaj
 */
public class Validator {
    
    private List<IValidation> validators;
    
    private List<String> errors;
    
    public Validator() {
        this.validators = new ArrayList<IValidation>();
        this.errors = new ArrayList<String>();
    }
    
    public void addError(String error) {
        this.errors.add(error);
    }
    
    public List<String> getErrors() {
        return this.errors;
    }
    
    public void addValidator(IValidation val) {
        this.validators.add(val);
    }
    
    public boolean passes() {
        boolean ret = true;
        for ( IValidation val : this.validators ) {
            if ( val.validate() == false ) {
                ret = false;
                this.addError(val.getError());
            }
        }
        return ret;
    }
    
}
