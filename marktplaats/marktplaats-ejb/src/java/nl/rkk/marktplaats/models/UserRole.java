/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.rkk.marktplaats.models;

/**
 *
 * @author Kaj
 */
public enum UserRole {
    
    Admin ("admin"), User ("user");
    
    private final String role;
    
    UserRole(String role) {
        this.role = role;
    }
    
    public String getRole() {
        return this.role;
    }
    
}
