/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character_creation;
 
import java.util.Scanner;
/**
 *
 * @author Eisma
 */
public class menu {
    public static PlayerAccount createPlayerAccount() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Accounting.");
        System.out.println("Let us help you create your player account.");
        System.out.print("Please enter your user name: ");
        String name = scan.next();
        System.out.print("Please enter your password: ");
        String password = scan.next();
        System.out.print("Please enter your email: ");
        String email = scan.next();
        PlayerAccount player = new PlayerAccount(name, password, email);
        return player;
    }
}
