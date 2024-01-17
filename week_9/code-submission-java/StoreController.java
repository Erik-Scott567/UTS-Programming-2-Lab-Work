import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
public class StoreController {
    @FXML private Button sellBtn;
    @FXML private Text stockTxt;
    @FXML private Text priceTxt;
    @FXML private TextField amountTf;
    @FXML private Text cashTxt;

    private int getAmount() {
        return Integer.parseInt(amountTf.getText());
    }

    private double getCash() {
        return Double.parseDouble(cashTxt.getText());
    }

    public void handlesell(ActionEvent e) {
        double selling = (getAmount());
        double sold = 2.99*selling;
        double current_cash = (getCash());
        double new_cash = current_cash+sold;
        cashTxt.setText("$" + String.format("%.2f", new_cash));
    }
}
