/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos.mvc.controller;

import java.sql.PreparedStatement;
import pos.mvc.model.OrderModel;
import pos.mvc.model.OrderDetailModel;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pos.mvc.db.DBConnection;

/**
 *
 * @author BHANUKA
 */
public class OrderController {
    
    public String placeOrder(OrderModel orderModel, ArrayList<OrderDetailModel> orderDetailModels) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
   
        try {
            connection.setAutoCommit(false);
            String orderQuery = "INSERT INTO orders VALUES (?, ?, ?)"; 
            
            PreparedStatement statementForOrder = connection.prepareStatement(orderQuery);
            statementForOrder.setString(1, orderModel.getOrderID());
            statementForOrder.setString(2, orderModel.getOrderDate());
            statementForOrder.setString(3, orderModel.getCustID());
            
            if (statementForOrder.executeUpdate() > 0) {
                boolean isOrderDetailSaved = true;
                String orderDetailQuery = "INSERT INTO orderDetail VALUES (?, ?, ?, ?)";
                
                for(OrderDetailModel orderDetail: orderDetailModels) {
                    PreparedStatement statementForOrderDetail = connection.prepareStatement(orderDetailQuery);
                    statementForOrderDetail.setString(1, orderModel.getOrderID());
                    statementForOrderDetail.setString(2, orderDetail.getItemCode());
                    statementForOrderDetail.setInt(3, orderDetail.getOrderQty());
                    statementForOrderDetail.setDouble(4, orderDetail.getDiscount());
                    
                    if (!(statementForOrderDetail.executeUpdate() > 0)) {
                        isOrderDetailSaved = false;
                    }
                }
                if (isOrderDetailSaved) {
                    boolean isItemSaved = true;
                    String itemQuery = "UPDATE item SET QtyOnHand = QtyOnHand - ? WHERE itemCode = ?";
                    
                    for(OrderDetailModel orderDetail: orderDetailModels) {
                        PreparedStatement statementForItem = connection.prepareStatement(itemQuery);
                        statementForItem.setInt(1, orderDetail.getOrderQty());
                        statementForItem.setString(2, orderDetail.getItemCode());
                        
                        if (!(statementForItem.executeUpdate() > 0)) {
                            isItemSaved = false;
                        }
                    }
                    if (statementForOrder.executeUpdate() > 0) {
                        connection.commit();
                        return "Success";
                    } else {
                        connection.rollback();
                        return "Item Update Error";
                    }
                } else {
                    connection.rollback();
                    return "Order Detail Save Error";
                }
                
            } else {
                connection.rollback();
                return "Order Save Error";
            }           
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
            return e.getMessage();
        } finally {
            connection.setAutoCommit(true);
        }
    }
}
