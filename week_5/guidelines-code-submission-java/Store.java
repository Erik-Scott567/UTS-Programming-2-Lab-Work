/**
 * The store has and sells one product: Sticky tape.
 *
 * You can sell and restock a product, view stock and view cash.
 */
public class Store {
    // insert main method here
    // insert 2 fields here
    // insert 1 constructor here

    private int stock;
    private double cash;
    private double total_cash;

    public Store(int stock, double cash, double total_cash) {
        this.stock = stock;
        this.cash = cash;
        this.total_cash = total_cash;
    }

    public static void main(String[] args) {
        Store store = new Store(200, 0, 0);
        while (true) {
            System.out.print("Choice (s/r/v/c/x): ");
            char Input = In.nextChar();
            double total_cash = 0;
            if (Input == 's'){
                System.out.print("Number: ");
                double sold = In.nextDouble();
                store.sell(sold, total_cash);
                
            }
            if (Input == 'r') {
                System.out.print("Number: ");
                int supply = In.nextInt();
                store.restock(supply);
            }
            if (Input == 'v') {
                store.viewStock();
                System.out.println(" Sticky tape at $2.99");
            }
            if (Input == 'c') {
                store.viewCash(total_cash);
            }
            if (Input == 'x') {
                break;
            }

            if (Input == '?') {
                help();
            } 
        }
    }

    public void use() {
    }

    private void sell(double cash, double total_cash) {
        if (stock >= 0) {
            if (stock - cash >= 0) {
                this.cash = 2.99*cash;
                this.stock -= cash;
                this.total_cash += this.cash;
            }
            else {
                System.out.println("Not enough stock");
            }
        }
    }

    private void restock(int supply) {
        if (supply > 0) {
            this.stock += supply;
        }
    }

    private void viewStock() {
        System.out.print(this.stock);
    }

    private void viewCash(double total_cash) {
        String formatted_cash = String.format("%.2f", this.total_cash);
        if (this.cash == 0) {
            System.out.println("Cash register: empty");
        }
        else {
            System.out.println("Cash register: $"+formatted_cash);
        }
    }

    private static void help() {
        System.out.println("Menu options");
        System.out.println("s = sell");
        System.out.println("r = restock");
        System.out.println("v = view stock");
        System.out.println("c = view cash");
        System.out.println("x = exit");
    }
}
