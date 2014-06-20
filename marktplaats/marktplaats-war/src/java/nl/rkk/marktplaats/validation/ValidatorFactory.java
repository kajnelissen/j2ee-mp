/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.rkk.marktplaats.validation;

import java.util.Collections;
import java.util.Dictionary;
import java.util.List;

/**
 *
 * @author Kaj
 */
public class ValidatorFactory {
    
    public static Validator make(Dictionary<String, List<String>> rules, Dictionary<String, String> input) {
        
        //for ( Map.Entry<String, List<String>> entry : input.entrySet() ) {
        List<String> keys = Collections.list(input.keys());
            //List<String> value = entry.getValue();
        //}
        
        Validator validator = new Validator();
        
        for ( String key : keys ) {
            for ( String rule : rules.get(key) ) {
                validator.addValidator(createValidator(rule, input.get(key)));
            }
        }
        
        return validator;
    }
    
    public static IValidation createValidator(String rule, String param) {
        switch ( rule ) {
            case "required":
                return new RequiredValidation(param);
        }
        return null;
    }
    
}
