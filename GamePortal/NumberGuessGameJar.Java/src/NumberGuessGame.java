import java.util.Scanner;
import java.io.File;
import java.util.Random;
//Match the expected package
// 
// Decompiled by Procyon v0.5.36
// 



public class NumberGuessGame implements Game {
    int numTries = 0;
    public static void main(final String[] args) throws Exception {
        System.out.println("args length are " + args.length);
       

    }
    
    public static int errorCheck(final Scanner sc, final int min, final int max) {
        if (!sc.hasNextInt()) {
            System.out.println("This is not a number. Discarding this input");
            sc.next();
            return errorCheck(sc, min, max);
        }
        final int input = sc.nextInt();
        System.out.println("This is a number");
        if (input > max || input < min) {
            System.out.println("Hey! this number is out of the range. Try again.");
            return errorCheck(sc, min, max);
        }
        return input;
    }
    
    public String getGameName() {
        return "NumberGuessGame";
    }


    @Override
    public void writeHighScore(File f) {

    }

    @Override
    public void play() {
        int min = 1;
        int max = 100;
        int guess = 0;
        final Random rand = new Random();
        final Scanner sc = new Scanner(System.in);
        final int randNumber = rand.nextInt(min, max + 1);
        System.out.println("I am thinking of a number from " + min + " to " + max + ". Can you guess it?");
        while (guess != randNumber) {
            guess = errorCheck(sc, min, max);
            ++numTries;
            if (guess > randNumber) {
                System.out.println("Nope! Go lower.");
            }
            else {
                if (guess >= randNumber) {
                    continue;
                }
                System.out.println("Nope! Go higher.");
            }
        }
        System.out.println("You got it! It took you " + numTries + " tries to guess " + randNumber);
    }
    @Override
    public String getScore() {
        return Integer.toString(numTries);
//Return everything 


}
} 