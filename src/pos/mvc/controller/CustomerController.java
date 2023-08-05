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
import java.util.ArrayList;
import java.sql.ResultSet;


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
    
    public ArrayList<CustomerModel> getAllCustomers() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
            
        String query = "SELECT * FROM customer";
            
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        
        ResultSet rSet = preparedStatement.executeQuery();
        
        ArrayList<CustomerModel> customerModels = new ArrayList<>();
        
        while (rSet.next()) {
            CustomerModel cm = new CustomerModel(
                    rSet.getString(1), 
                    rSet.getString(2), 
                    rSet.getString(3), 
                    rSet.getString(4), 
                    rSet.getDouble(5), 
                    rSet.getString(6), 
                    rSet.getString(7), 
                    rSet.getString(8), 
                    rSet.getString(9));
            customerModels.add(cm);
        }
        return customerModels;
    }
    
    public CustomerModel getCustomer(String custID) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
            
        String query = "SELECT * FROM customer WHERE CustID = ?"; 
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, custID);
         
        ResultSet rSet = preparedStatement.executeQuery();
        while (rSet.next()) {
            CustomerModel cm = new CustomerModel(
                    rSet.getString(1), 
                    rSet.getString(2), 
                    rSet.getString(3), 
                    rSet.getString(4), 
                    rSet.getDouble(5), 
                    rSet.getString(6), 
                    rSet.getString(7), 
                    rSet.getString(8), 
                    rSet.getString(9));
            return cm;
        }
        
        return null;
    }
    
    public String updateCustomer(CustomerModel customer) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        
        String query = "UPDATE Customer SET CustTitle = ?, CustName = ?, DOB = ?, salary = ?, CustAddress = ?, City = ?, Province = ?, PostalCode = ? WHERE CustID = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        
        preparedStatement.setString(1, customer.getCustTitle());
        preparedStatement.setString(2, customer.getCustName());
        preparedStatement.setString(3, customer.getCustDOB());
        preparedStatement.setDouble(4, customer.getCustSalary());
        preparedStatement.setString(5, customer.getCustAddress());
        preparedStatement.setString(6, customer.getCustCity());
        preparedStatement.setString(7, customer.getCustProvince());
        preparedStatement.setString(8, customer.getCustZip());
        preparedStatement.setString(9, customer.getCustID());
        // System.out.println("Pass");
        
        if(preparedStatement.executeUpdate() > 0) {
            return "Success";
        } else {
            return "Fail";
        }
    }
}
