/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.rkk.marktplaats.validation.rules;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author Kaj
 */
public final class BidRules {
    
    public static final Dictionary<String, List<String>> rules;
    
    static {
        rules = new Hashtable<>();
        rules.put("amount", Arrays.asList("required|money"));
    }
    
}
