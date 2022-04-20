package controller;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Customer;
import util.CrudUtil;

import java.sql.*;

public class UpdateCustomerFormController {
    public TextField txtName;
    public TextField txtId;
    public TextField txtAddress;
    public TextField txtSalary;

    public void txtSearchOnAction(ActionEvent actionEvent) {
        try {
            ResultSet result =  CrudUtil.execute("SELECT * FROM Customer WHERE id=?",txtId.getText());
            if (result.next()) {
                txtName.setText(result.getString(2));
                txtAddress.setText(result.getString(3));
                txtSalary.setText(String.valueOf(result.getDouble(4)));
            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {

        Customer c = new Customer(
                txtId.getText(),txtName.getText(), txtAddress.getText(),
                Double.parseDouble(txtSalary.getText())
        );

        try{
            boolean isUpdated = CrudUtil.execute("UPDATE Customer SET name=? , address=? , salary=? WHERE id=?",c.getName(),c.getAddress(),c.getSalary(),c.getId());
            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION, "Updated!").show();
            }else{
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }


        }catch (SQLException | ClassNotFoundException e){

        }
    }
}
