/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.rkk.marktplaats.validation;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author Kaj
 */
public class Validator {
    
    private List<IValidation> validators;
    
    //private List<String> errors;
    
    private Dictionary<String, List<String>> errors;
    
    public Validator() {
        this.validators = new ArrayList<IValidation>();
        //this.errors = new ArrayList<String>();
        this.errors = new Hashtable<>();
    }
    
    public void addError(String attribute, String error) {
        //this.errors.add(error);
        if ( this.errors.get(attribute) == null ) {
            this.errors.put(attribute, new ArrayList<String>());
        }
        this.errors.get(attribute).add(error);
    }
    
    public Dictionary<String, List<String>> getErrors() {
        return this.errors;
    }
    
    public List<String> getErrors(String attribute) {
        //return this.errors;
        return this.errors.get(attribute);
    }
    
    public void addValidator(IValidation val) {
        this.validators.add(val);
    }
    
    public boolean passes() {
        boolean ret = true;
        for ( IValidation val : this.validators ) {
            if ( val.validate() == false ) {
                ret = false;
                this.addError(val.getAttribute(), val.getError());
            }
        }
        return ret;
    }
    
}
