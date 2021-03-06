/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character_creation;

import java.util.Random;
import java.util.stream.*;
import java.util.Scanner;
/**
 *
 * @author Eisma
 */
public class Character {
    private String name;
    private String alignment;
    
    // 1 = human, 2 = elf, 3 = dwarf, 4 = gnome, 5 = halfling
    private int race;
    
    // 0 = female, 1 = male
    private int gender;
    private int age;
    private int height;
    private int weight;
    
    // Strength, Dexterity, Constitution, Intelligence, Wisdom, Charisma 
    private int[] abilityScores = new int[] {0, 0, 0, 0, 0, 0};
    
    public Character(){
        name = null;
        alignment = null;
        race = 0;
        gender = 0;
        age = 0;
        height = 0;
        weight = 0;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getAlignment(){
        return alignment;
    }
    
    public void setAlignment(String alignment){
        this.alignment = alignment;
    }
    
    public int getRace(){
        return race;
    }
    
    public void setRace(int race){
        this.race = race;
        raceUtil();
    }
    
    public int getGender(){
        return gender;
    }
    
    public void setGender(int gender){
        this.gender = gender;
    }
    
    public int getAge(){
        return age;
    }
    
    public void setAge(){
        Random rand = new Random();
        switch (race) {
            case 1:
                age = rand.nextInt(16) + 15;
                break;
            case 2:
                age = rand.nextInt(101) + 80;
                break;
            case 3:
                age = rand.nextInt(41) + 30;
                break;
            case 4:
                age = rand.nextInt(31) + 30;
                break;
            case 5:
                age = rand.nextInt(21) + 30;
                break;
        }
    }
    
    public int getHeight(){
        return height;
    }
    
    public void setHeight(int height){
        this.height = height;
    }
    
    public int getWeight(){
        return weight;
    }
    
    public void setWeight(){
        Random rand = new Random();
        if (gender == 0){
            switch (race) {
            case 1:
                weight = rand.nextInt(126) + 75;
                break;
            case 2:
                weight = rand.nextInt(36) + 65;
                break;
            case 3:
                weight = rand.nextInt(56) + 125;
                break;
            case 4:
                weight = rand.nextInt(21) + 35;
                break;
            case 5:
                weight = rand.nextInt(26) + 45;
                break;
            }
        }
        else {
            switch (race) {
            case 1:
                weight = rand.nextInt(171) + 91;
                break;
            case 2:
                weight = rand.nextInt(61) + 70;
                break;
            case 3:
                weight = rand.nextInt(81) + 150;
                break;
            case 4:
                weight = rand.nextInt(21) + 40;
                break;
            case 5:
                weight = rand.nextInt(26) + 55;
                break;
            }
        }
    }
    
    
    
    private void raceUtil() {
        switch (race) {
            case 2:
                abilityScores[1] += 2;
                abilityScores[3] += 2;
                abilityScores[2] -= 2;
                break;
            case 3:
                abilityScores[0] += 2;
                abilityScores[2] += 2;
                abilityScores[5] -= 2;
                break;
            case 4:
                abilityScores[1] += 2;
                abilityScores[2] += 2;
                abilityScores[0] -= 2;
                break;
            case 5:
                abilityScores[1] += 2;
                abilityScores[4] += 2;
                abilityScores[0] -= 2;
                break;
        }
    }
}
