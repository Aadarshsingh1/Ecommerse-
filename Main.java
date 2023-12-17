/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
   
}

class ShoppingCart {
    private List<Product> items;
    public List<Product> getItems() {
        return items;
    }

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addToCart(Product product) {
        items.add(product);
    }

    public void removeFromCart(Product product) {
        items.remove(product);
    }
    

    
}

class User {
    private String username;
    private String password;
    private ShoppingCart cart;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.cart = new ShoppingCart();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ShoppingCart getCart() {
        return cart;
    }
}

class ECommercePlatform {
    private List<Product> products;
    private List<User> users;

    public ECommercePlatform() {
        this.products = new ArrayList<>();
        this.users = new ArrayList<>();
    }
    public List<Product> getProducts() {
        return products;
    }


    public void addProduct(Product product) {
        products.add(product);
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public User authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void displayProducts() {
        for (Product product : products) {
            System.out.println(product.getId() + ": " + product.getName() + " - $" + product.getPrice());
        }
    }
    
    
}

public class Main {
    public static void main(String[] args) {
        ECommercePlatform platform = new ECommercePlatform();

        // Adding products
        platform.addProduct(new Product(1, "Product A", 19.99));
        platform.addProduct(new Product(2, "Product B", 29.99));
        // Add more products as needed

        // User registration
        User user1 = new User("Aadarsh", "Aadarsh@123");
        User user2 = new User("Sourabh", "Sourabh@123");
        platform.registerUser(user1);
        platform.registerUser(user2);

        // Simulating user authentication
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String usernameInput = scanner.nextLine();
        System.out.println("Enter password:");
        String passwordInput = scanner.nextLine();

        User loggedInUser = platform.authenticateUser(usernameInput, passwordInput);

        if (loggedInUser != null) {
            System.out.println("Welcome, " + loggedInUser.getUsername() + "! Here are the available products:");
            platform.displayProducts();

            // Simulating adding product to cart
            System.out.println("Enter the product ID to add to cart:");
int productId = scanner.nextInt();
scanner.nextLine(); // Consume newline character

Product selectedProduct = platform.getProducts().stream()
        .filter(p -> p.getId() == productId)
        .findFirst()
        .orElse(null);

if (selectedProduct != null) {
    loggedInUser.getCart().addToCart(selectedProduct);
    System.out.println(selectedProduct.getName() + " added to cart.");
        System.out.println( "Now go to payment method");

} else {
    System.out.println("Invalid product ID.");
}

            // Displaying items in the cart
            System.out.println("Items in your cart:");
            List<Product> cartItems = loggedInUser.getCart().getItems();
            for (Product item : cartItems) {
                System.out.println(item.getName() + " - $" + item.getPrice());
            }
        } else {
            System.out.println("Invalid credentials. Access denied.");
        }
    }
}
