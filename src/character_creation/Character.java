/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character_creation;

import java.util.Random;
import java.util.stream.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author Eisma
 */
public class Character {
    
    private String name;
    private String alignment;
    private String[] alignments = new String[] { "Lawful Good", "Lawful Evil",
        "Neutral Good", "Neutral Evil", "Chaotic Good", "Chaotic Evil" };
    
    // 1 = human, 2 = elf, 3 = dwarf, 4 = gnome, 5 = halfling
    private int race;
    private final String[] races = new String[]{ "human", "elf", "dwarf", "gnome", "halfling" };
    
    // 0 = female, 1 = male
    private int gender;
    private final String[] genders = new String[] { "female", "male" };
    
    private int age;
    private int height;
    private int weight;
    private AbilityScores abilityScores;
    
    public Character(){
        name = null;
        alignment = null;
        race = 0;
        gender = 0;
        age = 0;
        height = 0;
        weight = 0;
        abilityScores = new AbilityScores();
    }
    
    public void buildCharacter() {
        System.out.println("*Please read in epic voice*");
        System.out.println("The moon is new and the stars are bright (maybe).");
        System.out.println("It is a strange time to be on the road weary traveler.");
        System.out.print("What is your name: ");
        name = userInputString();
        System.out.println("What an unusual name.");
        
        System.out.println("How do you align yourself: ");
        System.out.println(Arrays.toString(alignments));
        setAlignment(userInputString());
        
        System.out.println("I am but an old blind man. Tell me more about yourself.");
        System.out.println("Your gender: ");
        setGender(userInputString()); 
        
        System.out.println("How are your skills: ");
        abilityScores.abilityScorePrompt();
        
        System.out.println(Arrays.toString(races));
        System.out.println("What is your race: ");
        setRace(userInputString());
        

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
        if (UserInput.isValid(alignment, alignments)) {
            this.alignment = alignment;
        }
    }
    
    public int getRace(){
        return race;
    }
    
    public void setRace(String race){
        if (UserInput.isValid(race, races)) {
            this.race = race.indexOf(race) + 1;
        }
        raceUtil();
        setAge();
        setWeight();
        setHeight();
    }
    
    public int getGender(){
        return gender;
    }
    
    public void setGender(int gender){
        this.gender = gender;
    }
    
    public void setGender(String gender) {
        if (UserInput.isValid(gender, genders)) {
            this.gender = gender.equals("female") ? 0 : 1;
        }
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
    
    // to do - finish implement
    public void setHeight(){
        Random rand = new Random();
        height = rand.nextInt(99) + 1;
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
                abilityScores.setDexterity(abilityScores.getDexterity() + 2);
                abilityScores.setIntelligence(abilityScores.getIntelligence() + 2);
                abilityScores.setConstitution(abilityScores.getIntelligence() - 2);
                break;
            case 3:
                abilityScores.setStrength(abilityScores.getStrength() + 2);
                abilityScores.setConstitution(abilityScores.getIntelligence() + 2);
                abilityScores.setCharisma(abilityScores.getCharisma() - 2);
                break;
            case 4:
                abilityScores.setDexterity(abilityScores.getDexterity() + 2);
                abilityScores.setConstitution(abilityScores.getConstitution() + 2);
                abilityScores.setStrength(abilityScores.getStrength() - 2);
                break;
            case 5:
                abilityScores.setDexterity(abilityScores.getDexterity() + 2);
                abilityScores.setWisdom(abilityScores.getWisdom() + 2);
                abilityScores.setStrength(abilityScores.getStrength() - 2);
                break;
        }
    }
    
    private String userInputString() {
        Scanner scan = new Scanner(System.in);
        boolean isString = false;
        while (!isString) {
            if (scan.hasNext()) {
                return scan.next();
            }
            else {
                System.out.println("Do you think me a fool? Choose again.");
            }
        }
        scan.close();
        return "An Unnamed Traveler";
    }
}
