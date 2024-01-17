import java.text.*;

/**
 * The cash register stores cash.
 *
 * You can add cash to the cash register.
 */
public class CashRegister {
    private double cash;

    public CashRegister() {
        this.cash = cash;
    }

    // insert 1 method here

    public void order(double cash) {
        this.cash += cash;
        system.out.print(cash);
    }

    /**
     * Return a string in the form:
     *
     * Cash register: $[cash]
     *
     * e.g. "Cash register: $29.90"
     *
     * If there is no cash, instead return:
     *
     * "Cash register: empty"
     */
    @Override
    public String toString() {
        return "";
    }
}
