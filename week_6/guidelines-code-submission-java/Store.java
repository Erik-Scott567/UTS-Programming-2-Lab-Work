import java.util.*;

public class Store {
    private CashRegister cashRegister;
    private LinkedList<Product> products = new LinkedList<Product>();
    private double total_cash = 0;

    public Store() {
        // Insert 6 lines of code to initialise the fields.
        cashRegister = new CashRegister();

        products.add(new Product("Whiteboard Marker", 85, 1.50));
        products.add(new Product("Whiteboard Eraser", 45, 5.00));
        products.add(new Product("Black Pen", 100, 1.50));
        products.add(new Product("Red Pen", 100, 1.50));
        products.add(new Product("Blue Pen", 100, 1.50));
    }

    public static void main(String[] args) {
        Store store = new Store();
        while (true) {
            System.out.print("Choice (s/r/v/c/p/x): ");
            String Input = In.nextLine();
            double total_cash = 0;
            if (Input.equals("s")) {
                System.out.print("Name: ");
                String productName = In.nextLine();
                List<Product> matchingProducts = store.findMatch(productName);
                if (!matchingProducts.isEmpty()) {
                    if (matchingProducts.size() == 1) {
                        Product product = matchingProducts.get(0);
                        System.out.println("Selling " + product.getName());
                        System.out.print("Number: ");
                        double sold = In.nextDouble();
                        if (sold > 0) {
                            store.sell(product, sold);
                        }
                    } else {
                        System.out.println("Multiple products match:");
                        for (Product product : matchingProducts) {
                            System.out.println(product.toString());
                        }
                    }
                } 
                else {
                    System.out.println("No such product");
                }
            }
                     
            if (Input.equals("r")) {
                System.out.print("Name: ");
                String productName = In.nextLine().toLowerCase();
                List<Product> existingProducts = store.findMatch(productName);
                
                if (existingProducts != null && !existingProducts.isEmpty()) {
                    for (Product existingProduct : existingProducts) {
                        System.out.println("Restocking " + existingProduct.getName());
                        System.out.print("Number: ");
                        int supply = In.nextInt();
                        
                        if (supply > 0) {
                            existingProduct.restock(supply);
                        }
                    }
                }
                else {
                    System.out.println("Adding new product");
                    System.out.print("Number: ");
                    int stock = In.nextInt();
                    System.out.print("Price: $");
                    double price = In.nextDouble();
                    store.addProduct(productName, stock, price);
                }
            }
            if (Input.equals("v")) {
                store.viewStock();
            }
            if (Input.equals("c")) {
                store.viewCash(total_cash);
            }
            if (Input.equals("p")) {
                store.pruneProducts();
            }
            if (Input.equals("x")) {
                System.out.println("Done");
                break;
            }

            if (Input.equals("?") | Input.equalsIgnoreCase("help me!")) {
                help();
            } 
        }
    }

    public void use() {
    }

    private List<Product> findMatch(String partialProductName) {
        List<Product> matchingProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(partialProductName.toLowerCase())) {
                matchingProducts.add(product);
            }
        }
        return matchingProducts;
    }

    private void sell(Product product, double sold) {
        double revenue = product.seller(sold);
        total_cash += revenue;
    }

    private void restock(int supply, Product product) {
        if (supply > 0) {
            if (product != null) {
                product.restock(supply);
            }
        }
    }

    public Product findProduct(String productName) {
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(productName.toLowerCase())) {
                return product;
            }
        }
        return null;
    }

    public void addProduct(String name, int stock, double price) {
        String formattedName = formatProductName(name);
        Product newProduct = new Product(formattedName, stock, price);
        products.add(newProduct);
    }

    private String formatProductName(String name) {
        String[] words = name.split(" ");
        StringBuilder formattedName = new StringBuilder();
    
        for (String word : words) {
            formattedName.append(word.substring(0, 1).toUpperCase() + word.substring(1)).append(" ");
        }
    
        return formattedName.toString().trim();
    }

    private void viewStock() {
        for (Product product : products){
            System.out.println(product.toString());
        }
    }

    private void viewCash(double total_cash) {
        String formatted_cash = String.format("%.2f", this.total_cash);
        if (this.total_cash == 0) {
            System.out.println("Cash: empty");
        }
        else {
            System.out.println("Cash: $"+formatted_cash);
        }
    }

    private void pruneProducts() {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getStock() <= 0) {
                iterator.remove();
            }
        }
    }
    

    private Product readName(String productName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    private double readPrice() {
        return 0.0;
    }

    private int readNumber() {
        return 0;
    }

    private static void help() {
        System.out.println("Menu options");
        System.out.println("s = sell");
        System.out.println("r = restock");
        System.out.println("v = view stock");
        System.out.println("c = view cash");
        System.out.println("p = prune products");
        System.out.println("x = exit");
    }
}
