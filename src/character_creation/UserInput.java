/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character_creation;

import java.util.Arrays;
import java.util.ArrayList;
/**
 *
 * @author Eisma
 */
public class UserInput {
    
    public static boolean isValid(int value, int[] possibleValues) {
        for (int i : possibleValues) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean isValid(String string, String[] possibleStrings) {
        for (String i : possibleStrings) {
            if (i == string) {
                return true;
            }
        }
        return false;
    }
}
