/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character_creation;

import java.util.ArrayList;
/**
 *
 * @author Eisma
 */
public class PlayerAccount {
    private String userName;
    private String password;
    private String email;
    private ArrayList<Character> characters = new ArrayList<>();
    
    public PlayerAccount(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public boolean login(String username, String password) {
        if (password.equals(this.password) && username.equals(this.userName))
            return true;
        else
            return false;
    }
    
    public void addCharacter(Character character) {
        characters.add(character);
    }
}
