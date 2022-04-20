package controller;

import db.DBConnection;
import db.DataSet;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Customer;
import util.CrudUtil;

import java.sql.*;

public class DeleteCustomerFormController {
    public TextField txtName;
    public TextField txtId;
    public TextField txtAddress;
    public TextField txtSalary;

    public void txtSearchOnAction(ActionEvent actionEvent) {
        search();
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
      try{
          if (CrudUtil.execute("DELETE FROM Customer WHERE id=?",txtId.getText())){
              new Alert(Alert.AlertType.CONFIRMATION, "Deleted!").show();
          }else{
              new Alert(Alert.AlertType.WARNING, "Try Again!").show();
          }

      }catch (SQLException | ClassNotFoundException e){

      }
    }

    private void search() {
        try {
            ResultSet result = CrudUtil.execute("SELECT * FROM Customer WHERE id=?",txtId.getText());
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
}
