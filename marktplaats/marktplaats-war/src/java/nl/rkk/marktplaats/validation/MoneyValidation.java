/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.rkk.marktplaats.validation;

import org.apache.commons.validator.routines.CurrencyValidator;
import org.apache.commons.validator.routines.DoubleValidator;

/**
 *
 * @author Roy
 */
public class MoneyValidation extends AbstractValidation {
    
    private String param;
    
    public MoneyValidation(String attribute, String param) {
        super(attribute);
        this.param = param;
    }
    
    @Override
    public boolean validate() {
        // de validator die in chrome openstaat, kun je hier gebruiken om
        // te controleren of param inderdaad een geldbedrag is
        // dat laat ik over aan jou
        
        //DoubleValidator val = new DoubleValidator(true, DoubleValidator.CURRENCY_FORMAT);
        String regex = "[0-9]+.[0-9][0-9]";
        this.param = this.param.replace(',','.');
      
        if(param.matches(regex)){
                return true;
        } else {
            this.addError("Price is not a valid currency");
            return false;
        }
    }
    
}