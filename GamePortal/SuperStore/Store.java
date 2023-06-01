import java.util.ArrayList;
import java.util.Random;

public class Store {
    static ArrayList<Item> inventory; // list of items in the store's inventory

      // constructor for the Store class (default constructor since no field vars)
    public Store() {
        inventory = new ArrayList<Item>();
        inventory.add(new Music("Guitar", randomPrice(10000, 25000)));
        inventory.add(new Music("Drum Set", randomPrice(10000, 25000)));
        inventory.add(new Music("Piano", randomPrice(10000, 25000)));

        inventory.add(new Cars("Electric Car", randomPrice(60000, 100000)));
        inventory.add(new Cars("Sports Car", randomPrice(60000, 100000)));
        inventory.add(new Cars("Luxury Car", randomPrice(60000, 100000)));
        
        inventory.add(new Merchandise("T-Shirt", randomPrice(1000, 10000)));
        inventory.add(new Merchandise("Cap", randomPrice(1000, 10000)));
        inventory.add(new Merchandise("Poster", randomPrice(1000, 10000)));


    }

    //method to get a random price within a range for an item
    public int randomPrice(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min; //find a random number between teh specified min and max
    }

    //method that loops through the stores inventory and displays each item's name category and price
    public void displayInventory() {
        System.out.println("---- Store Inventory ----");
        for (Item item : inventory) {
            System.out.println("Item Name: " + item.name + ", Category: " + item.category + ", Price: $" + item.price);
        }
        System.out.println("-------------------------");
    }

    //method to buy an item
    public void buyItem(Item item, Player player) {
        if (Player.balance >= item.price) { //check to make sure player can afford item
            player.addItem(item); //add the item to player's inventory
            player.deductBalance(item.price); //deduct the item price from the player's balance
            System.out.println("You bought " + item.name + " for $" + item.price);
            item.effectswhenbuying();
        } else {
            System.out.println("You do not have enough money to buy " + item.name + "."); //if player does not have enough money
        }
    }
}




