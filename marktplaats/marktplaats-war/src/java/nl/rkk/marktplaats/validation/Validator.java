/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.rkk.marktplaats.validation;

import java.util.List;

/**
 *
 * @author Kaj
 */
public class Validator {
    
    private List<IValidation> validators;
    
    public Validator() {
        
    }
    
    public void addValidator(IValidation val) {
        this.validators.add(val);
    }
    
}
