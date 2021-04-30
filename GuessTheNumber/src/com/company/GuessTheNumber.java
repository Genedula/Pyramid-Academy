package com.company;
import java.util.Scanner;

public class GuessTheNumber {

    public static void guessTheNumberGame(){

        Scanner sc = new Scanner(System.in);
        int number = 1 + (int)(20 * Math.random());

        int b = 5;

        int a, guess;

        System.out.println("Guess a number");

        for(a=0 ; a < b; a++){
            System.out.println("guess the number:");

            guess = sc.nextInt();
            if (number == guess){
                System.out.println("Congratulations!" + "You got it!");
                break;

            }else if (number > guess && a != b-1){
                System.out.println("number is less than" + " " + guess);
            }
        }
        if(a == b){
            System.out.println("Trials exhausted!");

            System.out.println("The number was" + number);

        }
    }
    public static void main(String arg[]){
        guessTheNumberGame();
    }
}
