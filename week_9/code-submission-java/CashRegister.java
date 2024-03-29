public class CashRegister implements ProductObserver {

    private double cash;

    public CashRegister() {
        cash = 0.0;
    }

    public void add(double money) {
        cash = cash + money;
    }
    
    @Override
    public void handleSale(double amount) {
        add(amount);
    }
}
