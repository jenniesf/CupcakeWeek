import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Order {

    // create a constructor with parameters
        // cupcakeMenu and drinkMenu Arraylist created in the main.java -- taken as parament to order object
    public Order(ArrayList<Cupcake> cupcakeMenu, ArrayList<Drink> drinkMenu) {

        System.out.println("Hello customer. Would you like to place an order? (Y or N)");

        // get user input
        Scanner input = new Scanner(System.in);
        String placeOrder = input.nextLine();

        // create arraylist of objects so any objects can be
            // added to the ArrayList - they do not have to all be the same type.
        ArrayList<Object> order = new ArrayList<>();  // order array that holds all items ordered by customer

        if( placeOrder.equalsIgnoreCase("y")) {
            // add date and time
            order.add(LocalDate.now());
            order.add(LocalTime.now());
            System.out.println("Here is the menu");
            System.out.println("CUPCAKES:");

            int itemNumber = 0;
            // print cupcake menu
            for (int i = 0; i < cupcakeMenu.size(); i++) {
                itemNumber++;
                System.out.println( itemNumber + ". " );
                cupcakeMenu.get(i).type(); // show cupcake type (description)
                System.out.println( "Price: $"  + cupcakeMenu.get(i).getPrice());
                System.out.println( );
            }
            // print drinks menu
            System.out.println( "DRINKS: " );
            for (int i = 0; i < drinkMenu.size(); i++) {
                itemNumber++;
                System.out.println( itemNumber  + ". " );
                drinkMenu.get(i).type(); // show drink type (description)
                System.out.println( "Price: $" + drinkMenu.get(i).getPrice() );
                System.out.println( );
            }

            boolean ordering = true;

            while (ordering) {
                System.out.println("What would you like to order? Please use the number associated with each item to order.");
                int orderChoice = input.nextInt();
                input.nextLine(); // fix reference trap

                if(orderChoice == 1 ) {
                    order.add( cupcakeMenu.get(0) );
                    System.out.println("Item added to order");
                } else if (orderChoice == 2 ) {
                    order.add( cupcakeMenu.get(1) );
                    System.out.println("Item added to order");
                } else if (orderChoice == 3 ) {
                    order.add( cupcakeMenu.get(2) );
                    System.out.println("Item added to order");
                } else if ( orderChoice == 4) {
                    order.add( drinkMenu.get(0) );
                    System.out.println("Item added to order");
                } else if (orderChoice == 5 ) {
                    order.add( drinkMenu.get(1) );
                    System.out.println("Item added to order");
                } else if (orderChoice == 6 ) {
                    order.add( drinkMenu.get(2) );
                    System.out.println("Item added to order");
                } else {
                    System.out.println("Sorry, we don't seem to have that on the menu");
                }

                System.out.println("Would you like to continue ordering? (Y/N)");
                placeOrder = input.nextLine();  // reference trap fixed above

                if(!placeOrder.equalsIgnoreCase("y")) {
                    ordering = false;
                }
            }

            // generate a receipt
            System.out.println(order.get(0));
            System.out.println(order.get(1));
            double subtotal = 0.0;

            for (int i = 2; i < order.size() ; i++) {

                if( order.get(i).equals( cupcakeMenu.get(0) ) ) {
                    cupcakeMenu.get(0).type();
                    double price = cupcakeMenu.get(0).getPrice();
                    System.out.println("Item is $" + price);
                    subtotal += price;
                } else if (  order.get(i).equals( cupcakeMenu.get(1) )  ) {
                    cupcakeMenu.get(1).type();
                    double price = cupcakeMenu.get(1).getPrice();
                    System.out.println("Item is $" + price);
                    subtotal += price;
                } else if (  order.get(i).equals( cupcakeMenu.get(2) )  ) {
                    cupcakeMenu.get(2).type();
                    double price = cupcakeMenu.get(2).getPrice();
                    System.out.println("Item is $" + price);
                    subtotal += price;
                } else if (  order.get(i).equals( drinkMenu.get(0) )  ) {
                    drinkMenu.get(0).type();
                    double price = drinkMenu.get(0).getPrice();
                    System.out.println("Item is $" + price);
                    subtotal += price;
                } else if (  order.get(i).equals( drinkMenu.get(1) )  ) {
                    drinkMenu.get(1).type();
                    double price = drinkMenu.get(1).getPrice();
                    System.out.println("Item is $" + price);
                    subtotal += price;
                } else if (  order.get(i).equals( drinkMenu.get(2) )  ) {
                    drinkMenu.get(2).type();
                    double price = drinkMenu.get(2).getPrice();
                    System.out.println("Item is $" + price);
                    subtotal += price;
                }

            }
            // print subtotal
            System.out.println( "Subtotal is $" + subtotal + "\n");

            // call CreateFile class
            new CreateFile();   // create a new file
            new WriteToFile(order); // call writer and pass in the customer order

        } else {
            System.out.println("Have a nice day.");
        }
    }
}

class CreateFile {

    // create constructor
    public CreateFile() {
        // try catch block
        try
        {
            File salesData = new File ("salesData.txt");  // call txt file object

            // create new file - if truthy ; other return already exists
                // .createNewFile will return true if a new file is created
            if( salesData.createNewFile() ) {
                System.out.println("File created: " + salesData.getName() );
            } else {
                System.out.println("File already exists");
            }
        }
        catch(IOException e)
        {
            System.out.println("An error occurred");
        }
    }
}

class WriteToFile {

    // create constructor
    public WriteToFile( ArrayList<Object> order ) {

        try {

            // create FileWriter object -- determine file name
            FileWriter fw = new FileWriter("salesData.txt" , true );  // true append allows appending to the file

            // create PrintWriter object -- to write to file
            PrintWriter salesWriter = new PrintWriter(fw);

            // iterate through each element in the Order to print values from Order array
            for (int i = 0; i < order.size(); i++) {
                // write/print to the txt file
                salesWriter.println( order.get(i) );
            }

            // close writer cannot continue to run
            salesWriter.close();

            System.out.println("Successfully wrote to the file");
        }
        catch (IOException e) {
            System.out.println("An error occurred");
        }
    }
}
