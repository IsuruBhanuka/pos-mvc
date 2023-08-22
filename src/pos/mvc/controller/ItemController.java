/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.mvc.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pos.mvc.db.DBConnection;
import pos.mvc.model.ItemModel;

/**
 *
 * @author BHANUKA
 */
public class ItemController {
    
    public ArrayList<ItemModel> getAllItems() throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
            
        String query = "SELECT * FROM Item";
            
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        
        ResultSet rSet = preparedStatement.executeQuery();
        ArrayList<ItemModel> itemModels = new ArrayList<>();
        
        while (rSet.next()) {
            ItemModel item = new ItemModel(
                    rSet.getString(1), 
                    rSet.getString(2), 
                    rSet.getString(3), 
                    rSet.getDouble(4), 
                    rSet.getInt(5));
            itemModels.add(item);  
        }
        return itemModels;
    }
    
    public String saveItem(ItemModel item) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        
        String query = "INSERT INTO item VALUES (?, ?, ?, ?, ?)";
        
        PreparedStatement preparedStatement = connection.prepareCall(query);
        
        preparedStatement.setString(1, item.getItemCode());
        preparedStatement.setString(2, item.getDescription());
        preparedStatement.setString(3, item.getPackSize());
        preparedStatement.setDouble(4, item.getUnitPrice());
        preparedStatement.setInt(5, item.getQtyOnHand());
        
        if(preparedStatement.executeUpdate() > 0) {
            return "Success";
        } else {
            return "Fail";
        }
    }
    
    public ItemModel getItem(String itemCode) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        
        String query = "SELECT * FROM item WHERE ItemCode = ?";
        
        PreparedStatement preparedStatement = connection.prepareCall(query);
        
        preparedStatement.setString(1, itemCode);
        
        ResultSet rst = preparedStatement.executeQuery();
        
        while (rst.next()) {
            ItemModel item = new ItemModel(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getDouble(4),
                    rst.getInt(5));
            return item;
        }
        return null;
    }
}
