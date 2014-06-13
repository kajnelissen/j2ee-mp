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
public class RequiredValidation extends AbstractValidation {
    
    private String param;
    
    public RequiredValidation(String param) {
        this.param = param;
    }
    
    @Override
    public boolean validate() {
        return this.param.length() > 0;
    }
    
}
