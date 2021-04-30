package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        boolean a = true;
        boolean b = false;
        Scanner input = new Scanner(System.in);

        if(a){
            System.out.println("You are in a land full of dragons. In front of you, you see two caves.In one cav, the dragon is friendly and will share his treasure with you. The other dragon is greedy and hungry and will eat you on sight. Which cave will you go into? (1 or 2)");
        }else if(b){
            System.out.println("You approach th cave......It is dark and spooky...A large dragon jumps out in front of you! He opens his jaws and ....Gobbles you down in one bite!");
        }

    }
}
