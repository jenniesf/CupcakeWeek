import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        // create ArrayLists - menu lists
        ArrayList<Cupcake> cupcakesMenu = new ArrayList<>();  // create arrayList with Cupcake obj
        ArrayList<Drink> drinkMenu = new ArrayList<Drink>();

        // create objects - cupcakes and drinks
        Cupcake cupcake = new Cupcake();
        RedVelvet redVelvet = new RedVelvet();
        Chocolate chocolate = new Chocolate();
        Drink water = new Drink();
        Soda soda = new Soda();
        Milk milk = new Milk();

        // Add Cupcakes to the menu
        System.out.println("We are in the middle of creating the cupcake menu. We currently have three cupcakes on the menu but we need to decide on pricing.");
        Scanner input = new Scanner(System.in);

        // reg. cupcake
        System.out.println("We are deciding on the price for our standard cupcake. Here is the description:");
        cupcake.type();  // call fn type
        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
        String priceText = input.nextLine();  // get user input
        double price = Double.parseDouble(priceText); // convert string to double
        cupcake.setPrice(price);  // set price fn
        // red velvet
        System.out.println("We are deciding on the price for our red velvet cupcake. Here is the description:");
        redVelvet.type();
        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        redVelvet.setPrice(price);
        // chocolate
        System.out.println("We are deciding on the price for our chocolate cupcake. Here is the description:");
        chocolate.type();
        System.out.println("How much would you like to charge for the cupcake? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        chocolate.setPrice(price);

        // add objects to arrayList
        cupcakesMenu.add(cupcake);
        cupcakesMenu.add(redVelvet);
        cupcakesMenu.add(chocolate);

        // Add Drinks to the menu
        System.out.println("We are in the middle of creating the drink menu. We currently have three drinks on the menu but we need to decide on pricing.");

        // water bottle
        System.out.println("We are deciding on the price for our water bottle. Here is the description:");
        water.type();  // call fn type
        System.out.println("How much would you like to charge for the drink? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();  // get user input
        price = Double.parseDouble(priceText); // convert string to double
        water.setPrice(price);  // setprice fn
        // soda
        System.out.println("We are deciding on the price for our soda. Here is the description:");
        soda.type();
        System.out.println("How much would you like to charge for the drink? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        soda.setPrice(price);
        // milk
        System.out.println("We are deciding on the price for our milk. Here is the description:");
        milk.type();
        System.out.println("How much would you like to charge for the drink? (Input a numerical number taken to 2 decimal places)");
        priceText = input.nextLine();
        price = Double.parseDouble(priceText);
        milk.setPrice(price);

        // add objects to arrayList
        drinkMenu.add(water);
        drinkMenu.add(soda);
        drinkMenu.add(milk);

        // call Order constructor
        Order order = new Order(cupcakesMenu, drinkMenu );

    }
}

class Cupcake {
    public double price;

    // getter
    public double getPrice() {
        return price;
    }
    // setter
    public void setPrice(double price) {
        this.price = price;
    }

    public void type(){
        System.out.println("A basic, generic cupcake, with vanilla frosting");
    }
}

class RedVelvet extends Cupcake {  //inherits from Cupcake
    @Override  // to override type method from Cupcake
    public void type() {
        System.out.println("A red velvet based cupcake, with cream cheese frosting.");
    }
}

class Chocolate extends Cupcake {  //inherits from Cupcake
    @Override  // to override type method from Cupcake
    public void type() {
        System.out.println("A chocolate based cupcake, with chocolate frosting.");
    }
}

class Drink {
    public double price;

    // getters
    public double getPrice() {
        return price;
    }
    // setters
    public void setPrice(double price) {
        this.price = price;
    }
    public void type(){
        System.out.println("A bottle of water.");
    }
}

class Soda extends Drink {
    @Override
    public void type() {
        System.out.println("A bottle of soda.");
    }
}

class Milk extends Drink {
    @Override
    public void type() {
        System.out.println("A bottle of milk.");
    }
}

