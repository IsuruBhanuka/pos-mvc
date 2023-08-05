/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.mvc.controller;

import pos.mvc.model.CustomerModel;
import java.sql.Connection;
import pos.mvc.db.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author BHANUKA
 */
public class CustomerController {
    
    public String saveCustomer(CustomerModel customer) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        
        String query = "INSERT INTO Customer VALUES(?,?,?,?,?,?,?,?,?)";
        
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, customer.getCustID());
        preparedStatement.setString(2, customer.getCustTitle());
        preparedStatement.setString(3, customer.getCustName());
        preparedStatement.setString(4, customer.getCustDOB());
        preparedStatement.setDouble(5, customer.getCustSalary());
        preparedStatement.setString(6, customer.getCustAddress());
        preparedStatement.setString(7, customer.getCustCity());
        preparedStatement.setString(8, customer.getCustProvince());
        preparedStatement.setString(9, customer.getCustZip());
        
        if(preparedStatement.executeUpdate() > 0) {
            return "Success";
        } else {
            return "Fail";
        }
    
    }
}
