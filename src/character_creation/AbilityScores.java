/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character_creation;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author Eisma
 */
public class AbilityScores {
    
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    // Scores order: Strength, Dexterity, Constitution, Intelligence, Wisdom, Charisma 
    private int[] abilityScores = new int[6];
    private final String[] abilityScoreNames = new String[]{ "Strength", "Dexterity", "Constitution",
        "Intelligence", "Wisdome", "Charisma" };
    
    public AbilityScores() {}
    
    public void test() {
        for (int i : abilityScores){
            System.out.print(i + " ");
        }
    }
    
    /**
     * This method takes in generated score values and prompts user to
     * assign those values to each ability score.
     * @param scores 
     */
    public void assignAbilityScores(ArrayList<Integer> scores) {
        while (!scores.isEmpty()) {
            for (int i = 0; i < abilityScores.length; i++) {
                System.out.println("Generated ability score values: ");
                scores.forEach((n) -> System.out.print(n + " , "));
                System.out.println();
                boolean isValid = false;
                while (!isValid) {
                    System.out.printf("Choose value for %s:", abilityScoreNames[i]);
                    int val = userInputInt();
                    if (scores.contains(val)) {
                        abilityScores[i] = userInputInt();
                        scores.remove(val);
                    }
                }
            }
        }    
    }
    
    private ArrayList<Integer> generateAbilityScores(int method){
        Random rand = new Random();
        int sum = 0;
        ArrayList<Integer> values = new ArrayList<Integer>();
        switch (method){
            case 1:
                for (int i = 0; i < 6; i++) {
                    sum = IntStream.of(diceRoller(3, 6)).sum();
                    values.add(sum);
                }
                break;
            case 2:
                for (int i = 0; i < 6; i++) {
                    int[] rolls = diceRoller(5, 6);
                    int[] best = bestOf(rolls, 3);
                    values.add(IntStream.of(best).sum());                   
                }
                
            case 3:
                for (int i = 0; i < 6; i++) {
                    int[] rolls = diceRoller(5, 6);
                    int[] best = bestOf(rolls, 3);
                    values.add(IntStream.of(best).sum() + rand.nextInt(2) + 1);
                }
        }
        return values;
    }
    
    private int[] diceRoller(int numberOfRolls, int diceSides) {
        Random rand = new Random();
        int[] rolls = new int[numberOfRolls];
        for (int item : rolls) {
            item = rand.nextInt(diceSides - 1) + 1;
        }
        return rolls;
    }
    
    private int[] bestOf(int[] nums, int choose){
        int[] best = new int[choose];
        int max = 0;
        int maxLoc = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxLoc = i;
            }
        }
        best[0] = max;
        max = 0;
        int nextMaxLoc = 0;
        
        for (int i = 1; i < choose; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] > max && j != maxLoc) {
                    max = nums[j];
                    nextMaxLoc = j;
                }
            }
            best[i] = max;
            max = 0;
        }
        return best;
    }
    
    /**
     * A utility method to handle accepting CL user input. Accepts integers.
     * @return int Returns user input
     */
    private int userInputInt() {
        Scanner scan = new Scanner(System.in);
        boolean isInt = false;
        while (!isInt) {
            if (scan.hasNextInt()) {
                return scan.nextInt();
            }
            else {
                System.out.println("Do you think me a fool? Choose again.");
            }
        }
        scan.close();
        return 0;
    }
}
