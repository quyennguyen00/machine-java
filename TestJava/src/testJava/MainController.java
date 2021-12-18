package testJava;

import Service.OrderService;
import Service.ProductService;
import Service.UserService;
import Service.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import pojo.Order;
import pojo.Product;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Handler;

public class MainController implements Initializable {
     @FXML private RadioButton rbCoke;
     @FXML private RadioButton rbPepsi;
     @FXML private RadioButton rbSoda;
     @FXML private TextField txtReceiveMoney;
     @FXML private Label lbResult;
     @FXML private Label lbRefund;



     private static double sum =0;
     private double money;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.txtReceiveMoney.setText("");
        money = UserService.user.getMoney();


    }
    public void receiveMoney(ActionEvent event) throws SQLException {
        List<Integer> typeMoney = new ArrayList<>();
        typeMoney.add(10000);
        typeMoney.add(20000);
        typeMoney.add(50000);
        typeMoney.add(100000);
        typeMoney.add(200000);



        double receiveMoney = Double.parseDouble(txtReceiveMoney.getText().trim());

            for(int i =0; i < typeMoney.size(); i++) {
                if (typeMoney.get(i)== receiveMoney){
                    money += receiveMoney;
                    if(UserService.updateMoney(money) == true) {
                        lbResult.setText("Valid! Please select product!!\n" +
                                "You have " + money + " to buy!");
                        break;
                    }
                } else
                {
//                    lbResult.setText(String.valueOf(i));
                    lbResult.setText("Invalid! Please receive money!!");
                    lbRefund.setText(String.valueOf(receiveMoney));
                    txtReceiveMoney.setText("");
                }
            }
    }
    public void buy(ActionEvent event) throws SQLException {

        ToggleGroup toggleGroup = new ToggleGroup();
        rbSoda.setToggleGroup(toggleGroup);
        rbCoke.setToggleGroup(toggleGroup);
        rbPepsi.setToggleGroup(toggleGroup);

        Order order = new Order();
        RadioButton selected = (RadioButton) toggleGroup.getSelectedToggle();
        int productId = ProductService.getProductByName(selected.getText()).getId();
        double m = ProductService.getProductByName(selected.getText()).getPrice();
        int userId = UserService.user.getId();

        if((rbSoda.isSelected() || rbPepsi.isSelected() || rbCoke.isSelected())){
            if(rbSoda.isSelected() == false)
                sum += 10000;
            else sum+= 20000;

            if(OrderService.addOrder(order,userId,productId,sum)) {
                if (money >= sum) {
                    money -= sum;
                    if (UserService.updateMoney(money) == true)
                        lbResult.setText("Please give product!!" +
                                "You have " + money + " to buy!");
                }
            }
            else lbResult.setText("Opps!Error!");

        }

    }


}
