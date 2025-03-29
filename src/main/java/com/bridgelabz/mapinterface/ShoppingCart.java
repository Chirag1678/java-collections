package com.bridgelabz.mapinterface;

import java.util.*;

// Class to maintain a shopping cart
public class ShoppingCart {
    public static void main(String[] args) {
        // Create a Scanner object ans ShoppingCart object
        Scanner input = new Scanner(System.in);

        ShoppingCart cart =new ShoppingCart();

        // Adding some products to the system
        cart.addProduct("Laptop", 50000);
        cart.addProduct("Smartphone", 30000);
        cart.addProduct("Headphones", 2000);
        cart.addProduct("Keyboard", 1500);

        // loop to take user input
        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add to Cart");
            System.out.println("2. Display Cart (Order Added)");
            System.out.println("3. Display Cart (Sorted by Price)");
            System.out.println("4. Calculate Total");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = input.nextInt();
            input.nextLine(); // Consume newline

            switch(choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String product = input.nextLine().trim();
                    System.out.print("Enter quantity: ");
                    int quantity = input.nextInt();
                    cart.addToCart(product, quantity);
                    break;

                case 2:
                    cart.displayCartOrder();
                    break;

                case 3:
                    cart.displayCartSortedByPrice();
                    break;

                case 4:
                    cart.calculateTotal();
                    break;

                case 5:
                    System.out.println("Exiting... Thank you for shopping!");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    // Attributes
    private final HashMap<String, Double> productPrices;  // Stores product prices
    private final LinkedHashMap<String, Integer> cart;   // Maintains order of added items

    public ShoppingCart() {
        this.productPrices = new HashMap<>();
        this.cart = new LinkedHashMap<>();
    }

    // Add product and its price to the system
    public void addProduct(String product, double price) {
        productPrices.put(product, price);
    }

    // Add item to the cart
    public void addToCart(String product, int quantity) {
        if (!productPrices.containsKey(product)) {
            System.out.println("Product not found!");
            return;
        }
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
        System.out.println(quantity + "x " + product + " added to the cart.");
    }

    // Display cart in the order items were added
    public void displayCartOrder() {
        System.out.println("\nCart Items (Added Order):");
        if (cart.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " pcs");
        }
    }

    // Display cart sorted by product price
    public void displayCartSortedByPrice() {
        System.out.println("\nCart Items (Sorted by Price):");
        if (cart.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }

        TreeMap<Double, String> sortedCart = new TreeMap<>();
        for (String product : cart.keySet()) {
            sortedCart.put(productPrices.get(product), product);
        }

        for (Map.Entry<Double, String> entry : sortedCart.entrySet()) {
            System.out.println(entry.getValue() + " -> ₹" + entry.getKey());
        }
    }

    // Calculate total price
    public void calculateTotal() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            total += productPrices.get(entry.getKey()) * entry.getValue();
        }
        System.out.println("\nTotal Cart Value: ₹" + total);
    }
}
// Sample Output ->
// Options:
// 1. Add to Cart
// 2. Display Cart (Order Added)
// 3. Display Cart (Sorted by Price)
// 4. Calculate Total
// 5. Exit
// Choose an option: 1
// Enter product name: Laptop
// Enter quantity: 1
// 1x Laptop added to the cart.

// Options:
// 1. Add to Cart
// 2. Display Cart (Order Added)
// 3. Display Cart (Sorted by Price)
// 4. Calculate Total
// 5. Exit
// Choose an option: 1
// Enter product name: Keyboard
// Enter quantity: 2
// 2x Keyboard added to the cart.

// Options:
// 1. Add to Cart
// 2. Display Cart (Order Added)
// 3. Display Cart (Sorted by Price)
// 4. Calculate Total
// 5. Exit
// Choose an option: 2

// Cart Items (Added Order):
// Laptop -> 1 pcs
// Keyboard -> 2 pcs

// Options:
// 1. Add to Cart
// 2. Display Cart (Order Added)
// 3. Display Cart (Sorted by Price)
// 4. Calculate Total
// 5. Exit
// Choose an option: 3

// Cart Items (Sorted by Price):
// Keyboard -> ₹1500.0
// Laptop -> ₹50000.0

// Options:
// 1. Add to Cart
// 2. Display Cart (Order Added)
// 3. Display Cart (Sorted by Price)
// 4. Calculate Total
// 5. Exit
// Choose an option: 4

// Total Cart Value: ₹53000.0

// Options:
// 1. Add to Cart
// 2. Display Cart (Order Added)
// 3. Display Cart (Sorted by Price)
// 4. Calculate Total
// 5. Exit
// Choose an option: 5
// Exiting... Thank you for shopping!