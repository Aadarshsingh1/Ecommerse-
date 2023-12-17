//Online ecommerse system using java

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// Day-1
class Product {
    // declare id name and price
    private int id;
    private String name;
    private double price;
 // set id name and price from user
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
  // for return id
    public int getId() {
        return id;
    }
// for return name
    public String getName() {
        return name;
    }
 for return price
    public double getPrice() {
        return price;
    }
   
}
// cart class start and go to new class 
class ShoppingCart {
    // by using mapping doing some work 
    private List<Product> items;
    public List<Product> getItems() {
        return items;
    }
    // mapped to items and declre a function get item

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }
    // return shooping cart

    public void addToCart(Product product) {
        items.add(product);
    }
    // to add into your cart

    public void removeFromCart(Product product) {
        items.remove(product);
    }
    // to remove your cart this will do it some work
    

    
}
// Day-2
class User {
    // declare some variable like username password and cart
    private String username;
    private String password;
    private ShoppingCart cart;
 // creat a constructor and set name
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.cart = new ShoppingCart();
    }
    // return username

    public String getUsername() {
        return username;
    }
    // return password

    public String getPassword() {
        return password;
    }
// return shooping cart items
    public ShoppingCart getCart() {
        return cart;
    }
}
// Day-3
// new class start hare 
class ECommercePlatform {
    private List<Product> products;
    private List<User> users;
// again using mapping and do it osme work again
    public ECommercePlatform() {
        this.products = new ArrayList<>();
        this.users = new ArrayList<>();
    }
    public List<Product> getProducts() {
        return products;
    }

// add product into some other functon
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
//Day-4

public class Main {
    public static void main(String[] args) {
        ECommercePlatform platform = new ECommercePlatform();

        // Adding products
        platform.addProduct(new Product(1, "computer", 19.99));
        platform.addProduct(new Product(2, " mouse", 29.99));
        // Add more products as needed

        // User registration
        User user1 = new User("user1", "password1");
        User user2 = new User("user2", "password2");
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
