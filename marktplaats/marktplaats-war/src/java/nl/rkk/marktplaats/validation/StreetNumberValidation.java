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
public class StreetNumberValidation extends AbstractValidation {
    
    private String param;
    
    public StreetNumberValidation(String attribute, String param) {
        super(attribute);
        this.param = param;
    }
    
    @Override
    public boolean validate() {
        return this.param.matches("[0-9][0-9]*[a-zA-Z]?");
    }
    
}
