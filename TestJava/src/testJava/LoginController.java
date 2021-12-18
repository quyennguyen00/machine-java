package testJava;

import Service.UserService;
import Service.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class LoginController implements Initializable {
    @FXML private TextField txtUsername;
    @FXML private PasswordField pfPass;
    @FXML private Label lbError;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void loginHandler(ActionEvent event) throws SQLException, IOException {
        String username = this.txtUsername.getText().trim();
        String password = this.pfPass.getText().trim();
        if(username.isBlank() == true && password.isBlank() ==true )
            lbError.setText("Please enter username and password");
        else
        {
            if(UserService.login(username,password)) {
                Utils.getAlert(" Successfully!", Alert.AlertType.CONFIRMATION);

                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setMaximized(false);
                stage.close();
                Scene scence = new Scene(FXMLLoader.load(getClass().getResource(
                        "/fxml/sample.fxml")));
                stage.setScene(scence);
                stage.show();
            }
            else{
                Utils.getAlert(" Invalid! Please try again!!", Alert.AlertType.ERROR);
                txtUsername.setText("");
                pfPass.setText("");

            }

        }
    }

}
