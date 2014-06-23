/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.rkk.marktplaats.validation;

import org.apache.commons.validator.routines.EmailValidator;

/**
 *
 * @author Kaj
 */
public class EmailValidation extends AbstractValidation {
    
    private String param;
    
    public EmailValidation(String attribute, String param) {
        super(attribute);
        this.param = param;
    }
    
    @Override
    public boolean validate() {
        EmailValidator val = EmailValidator.getInstance();
        if ( val.isValid(this.param) ) {
            return true;
        } else {
            this.addError("E-mail address is invalid.");
            return false;
        }
    }
    
}
