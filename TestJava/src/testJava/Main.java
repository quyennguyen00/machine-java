package testJava;

import Service.Utils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 500, 475));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        Utils.getConnection().close();
        super.stop(); //To change body of generated methods, choose Tools | Templates.\
    }

    public static void main(String[] args) {
        launch(args);
    }
}
