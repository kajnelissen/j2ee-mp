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
public class ValidationFactory {
    
    public IValidation create(String attribute, String validator, Object param) {
        
        switch ( validator ) {
            
            case "required":
                return new RequiredValidation(attribute, param.toString());
            
        }
        
        return null;
    }
    
}
