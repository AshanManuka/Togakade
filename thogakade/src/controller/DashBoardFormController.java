package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBoardFormController {


    public void deleteCustomerOnAction(ActionEvent event) throws IOException {
        setUi("DeleteCustomerForm");
    }


    public void loadAllCustomersOnAction(ActionEvent event) throws IOException {
        setUi("LoadAllCustomersForm");
    }


    public void saveCustomerOnAction(ActionEvent event) throws IOException {
        setUi("SaveCustomerForm");
    }


    public void searchCustomerOnAction(ActionEvent event) throws IOException {
        setUi("SearchCustomerForm");
    }


    public void updateCustomerOnAction(ActionEvent event) throws IOException {
        setUi("UpdateCustomerForm");
    }

    private void setUi(String URI) throws IOException {
        Parent parent  =FXMLLoader.load(getClass().getResource("../views/"+URI+".fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle(URI);
        stage.show();
    }

    public void placeOrderOnAction(ActionEvent actionEvent) throws IOException {
        setUi("PlaceOrderForm");
    }
}
