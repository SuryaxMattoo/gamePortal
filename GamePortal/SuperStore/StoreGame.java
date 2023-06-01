//TODO LIST:
    //

import java.io.File;
import java.util.Scanner;

public class StoreGame implements Game{

    public String getGameName() {
        return null;
    }
    @Override
    public void play() {
        {

            Store store = new Store(); //create the store
            Player player = new Player(1000000); //create the player
    
            Scanner scanner = new Scanner(System.in);
            String input;
    
            boolean keepPlaying = true;
    
            while (keepPlaying) {
                System.out.println("Your balance: $" + Player.balance);
                store.displayInventory();
                System.out.print("Enter the name of an item you would like to buy, or 'quit' to exit: ");
                input = scanner.nextLine();
    
                if (input.equals("quit")) { // if the input is anything other than "quit" continue the game
                    keepPlaying = false;
                    break;
                }
    
                boolean foundItem = false;
                for (Item item : Store.inventory) {
                    if (item.name.equals(input)) { //if input provided matches with an item name
                        foundItem = true; //set the found item bool to true 
                        store.buyItem(item, player); //buy the item using the store buy item method
                        break; // break out of the for loop 
                    }
                }
                if (!foundItem) {
                    System.out.println("Item not found in store inventory."); //if the item is not found
                }
            }
    
            System.out.println("Thanks for playing! Here is your final inventory:");
            player.displayInventory(); //display the players final inventory
    
            scanner.close();
        }
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'play'");
    }

    @Override
    public String getScore() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getScore'");
    }

    @Override
    public void writeHighScore(File f) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'writeHighScore'");
    }
}