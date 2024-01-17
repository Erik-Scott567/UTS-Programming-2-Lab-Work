import java.text.*;

public class Product {
    private String name;
    private int stock;
    private double price;

    public Product(String name, int stock, double price) {
        // insert 3 lines of code to initialise the fields.
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }

    public boolean isEmpty() {
        return false;
    }

    /**
     * Return true iff this product has at least n stock
     */
    public boolean has() {
        if (stock <=0) {
                return false;
        }
        return true;
    }

    /**
     * Sell n stock of this product (decrease stock by n)
     * and return the amount of money earned (price * n)
     */
    public double seller(double sold) {
        double trueCost = 0;
        if (stock >= 0) {
            if (stock - sold >= 0) {
                trueCost = price*sold;
                this.stock -= sold;
            }
            else {
                System.out.println("Not enough stock");
            }
        }
        return trueCost;
    }



    /**
     * Increase stock by n.
     */
    public void restock(int supply) {
        stock += supply;
    }

    @Override
    public String toString() {
        return this.name + " - " + this.stock + " at $" + formatted(this.price); 
    }

    private String formatted(double money) {
        return new DecimalFormat("###,##0.00").format(money);
    }
}
