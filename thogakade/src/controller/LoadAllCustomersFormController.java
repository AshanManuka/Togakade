package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;
import util.CrudUtil;

import java.sql.*;

public class LoadAllCustomersFormController {
    public TableView<Customer> tblCustomers;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colSalary;
    public void initialize(){

        colId.setCellValueFactory(new PropertyValueFactory("id"));
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory("salary"));

        try {
            loadAllCustomers();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadAllCustomers() throws ClassNotFoundException, SQLException {
        ResultSet result = CrudUtil.execute("SELECT * FROM Customer");
        ObservableList<Customer> obList = FXCollections.observableArrayList();

        while (result.next()){
            obList.add(
                    new Customer(
                            result.getString("id"),
                            result.getString("name"),
                            result.getString("address"),
                            result.getDouble("salary")
                    )
            );
        }
        tblCustomers.setItems(obList);

    }
}
