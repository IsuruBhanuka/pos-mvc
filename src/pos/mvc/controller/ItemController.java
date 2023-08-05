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
            ItemModel im = new ItemModel(
                    rSet.getString(1), 
                    rSet.getString(2), 
                    rSet.getString(3), 
                    rSet.getDouble(4), 
                    rSet.getInt(5));
            itemModels.add(im);  
        }
        return itemModels;
    }
}
