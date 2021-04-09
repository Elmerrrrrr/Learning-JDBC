package com.elmerrr.lil.jdbc;

import com.elmerrr.lil.jdbc.util.DataAccessObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDAO extends DataAccessObject<Order> {
    
    public static final String GET_ONE_ORDER = "SELECT " +
            "c.first_name, c.last_name, c.email, c.customer_id, " +
            "o.order_id, o.creation_date, o.total_due, o.status," +
            "s.first_name, s.last_name, s.email, s.salesperson_id, " +
            "oi.quantity, " +
            "p.code, p.name, p.size, p.variety, p.price " +
            "FROM orders o " +
            "JOIN customer c ON o.customer_id = c.customer_id " +
            "JOIN salesperson s ON o.salesperson_id = s.salesperson_id " +
            "JOIN order_item oi ON oi.order_id = o.order_id " +
            "JOIN product p ON oi.product_id = p.product_id " +
            "WHERE o.order_id = ?";
    
    public static final String GET_FOR_CUST = "SELECT * FROM get_orders_by_customer(?)";
    
    public OrderDAO(Connection connection) {
        super(connection);
    }
    
    
    @Override
    public Order findById(long id) {
        Order order = new Order();
        try(PreparedStatement statement = connection.prepareStatement(GET_ONE_ORDER)){
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            
            //don't overwrite the order item for each orderItem
            long orderId= 0;
            List<OrderItem> orderItemList = new ArrayList<>();
    
            
            while (rs.next()) {
                if(orderId==0) {
                    order.setCustomerFirstName(rs.getString(1));
                    order.setCustomerLastName(rs.getString(2));
                    order.setCustomerEmail(rs.getString(3));
                    order.setCustomer_id(rs.getLong(4));
                    order.setOrder_Id(rs.getLong(5));
                    orderId = order.getId();// set id
                    order.setCreation_date(rs.getDate(6));
                    order.setTotal_due(rs.getBigDecimal(7));
                    order.setStatus(rs.getString(8));

                    order.setSalespersonFirstName(rs.getString(9));
                    order.setSalespersonLastName(rs.getString(10));
                    order.setSalespersonEmail(rs.getString(11));
                    order.setSalesperson_id(rs.getLong(12));
                }
                OrderItem orderItem = new OrderItem();
                orderItem.setQuantity(rs.getInt(13));
                orderItem.setProductCode(rs.getString(14));
                orderItem.setProductName(rs.getString(15));
                orderItem.setProductSize(rs.getString(16));
                orderItem.setProductVariety(rs.getString(17));
                orderItem.setProductPrice(rs.getString(18));
                orderItemList.add(orderItem);
            }
            order.setOrderItemList(orderItemList);
            order.setTotalItems(orderItemList.size());
            

            
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return order;
    }
    
    @Override
    public List<Order> findAll() {
        return null;
    }
    
    @Override
    public Order update(Order dto) {
        return null;
    }
    
    @Override
    public Order create(Order dto) {
        return null;
    }
    
    @Override
    public void delete(long id) {
    
    }
    
    public List<Order>  getOrderForCustomer(long customerId){
        List<Order> orderList = new ArrayList<>();
        
        try(PreparedStatement statement = this.connection.prepareStatement(GET_FOR_CUST)){
            statement.setLong(1, customerId);
            ResultSet rs = statement.executeQuery();
            long orderId = 0;
            Order order = null;
            while(rs.next()){
                
                long localOrderId = rs.getLong(4);
                
                if (orderId!=localOrderId){
                    order = new Order();
                    orderList.add(order);
                    order.setOrder_Id(localOrderId);
                    orderId = localOrderId;
                    order.setCustomerFirstName(rs.getString(1));
                    order.setCustomerLastName(rs.getString(2));
                    order.setCustomerEmail(rs.getString(3));
                    order.setCreation_date(new Date(rs.getDate(5).getTime()));
                    order.setTotal_due(rs.getBigDecimal(6));
                    order.setStatus(rs.getString(7));
                    order.setSalespersonFirstName(rs.getString(8));
                    order.setSalespersonLastName(rs.getString(9));
                    order.setSalespersonEmail(rs.getString(10));
                    List<OrderItem> orderItemList = new ArrayList<>();
                    order.setOrderItemList(orderItemList);
                }
                OrderItem orderItem = new OrderItem();
                orderItem.setQuantity(rs.getInt(11));
                orderItem.setProductCode(rs.getString(12));
                orderItem.setProductName(rs.getString(13));
                orderItem.setProductSize(rs.getString(14));
                orderItem.setProductVariety(rs.getString(15));
                orderItem.setProductPrice(rs.getString(16));
                order.getOrderItemList().add(orderItem);
            
            }
            
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    return orderList;
    }
    
    
}
