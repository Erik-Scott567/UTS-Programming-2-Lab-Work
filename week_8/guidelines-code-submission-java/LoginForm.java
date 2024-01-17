import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginForm extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private Label usernameLbl;
    private TextField usernameTf;
    private Label passwordLbl;
    private TextField passwordTf; 
	private Label spacing1;
    private Button loginBtn;
	private Label spacing2;
    private Label resultLbl;

    @Override
    public void start(Stage stage) throws Exception {

        usernameLbl = new Label("Username:");
        usernameTf = new TextField("");
        passwordLbl = new Label("Password:");
        passwordTf = new TextField(); 
        loginBtn = new Button("Login");
		spacing1 = new Label("");
		spacing2 = new Label("");
        resultLbl = new Label("");

        VBox vBox = new VBox(10, new HBox(5, usernameLbl, usernameTf),
                new HBox(7, passwordLbl, passwordTf), new HBox(64,spacing1, loginBtn), new HBox(64,spacing2,resultLbl));
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10));

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.setTitle("LoginForm");
        stage.show();

		loginBtn.setOnAction(new LoginBtnHandler());
    }

	private String getUsername() {
		return usernameTf.getText();
	}

	private String getPassword() {
		return passwordTf.getText();
	}

	private boolean checkUsername(String newUsername) {
		String currentUsername = "sam";
		return currentUsername.equals(newUsername);
	}

	private boolean checkPassword(String newPassword) {
		String currentPassword = "mypassword";
		return currentPassword.equals(newPassword);
	}

	private class LoginBtnHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			String username = getUsername();
			String password = getPassword();
			if (checkUsername(username) && checkPassword(password)) {
				resultLbl.setText("Passsword correct!");
			}
			else {
				resultLbl.setText("Password incorrect!");
			}
		}
	}
}

