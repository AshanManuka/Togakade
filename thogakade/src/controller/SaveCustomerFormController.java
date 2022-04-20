package controller;

import db.DBConnection;
import db.DataSet;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Customer;
import util.CrudUtil;

import java.sql.*;

public class SaveCustomerFormController {
    public TextField txtName;
    public TextField txtId;
    public TextField txtSalary;
    public TextField txtAddress;

    public void btnSaveOnAction(ActionEvent actionEvent) {
        Customer c = new Customer(
                txtId.getText(),txtName.getText(), txtAddress.getText(),
                Double.parseDouble(txtSalary.getText())
        );

        try {
            if (CrudUtil.execute("INSERT INTO Customer VALUES (?,?,?,?)",c.getId(),c.getName(),c.getAddress(),c.getSalary())){
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
}
