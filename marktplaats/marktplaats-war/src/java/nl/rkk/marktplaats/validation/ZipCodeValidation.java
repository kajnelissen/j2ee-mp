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
public class ZipCodeValidation extends AbstractValidation {
    
    private String param;
    
    public ZipCodeValidation(String attribute, String param) {
        super(attribute);
        this.param = param;
    }
    
    @Override
    public boolean validate() {
        return (this.param.matches("[0-9]{4}[a-zA-Z]{2}") || this.param.matches("[0-9]{4} [a-zA-Z]{2}"));
    }
    
}
