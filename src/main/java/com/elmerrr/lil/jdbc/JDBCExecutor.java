package com.elmerrr.lil.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JDBCExecutor {
    
    public static void main(String[] args) {
    
    
       
    
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "hplussport",
                                                                      "postgres", "password");
        
        try {
            Connection connection = dcm.getConnection();
            CustomerDAO customerDAO = new CustomerDAO(connection);
    
            for (int i = 1; i < 4 ; i++) {
                System.out.println("Page number: " + i);
                List<Customer> customerList = customerDAO.findAllPaged(10, i);
                customerList.forEach(System.out::println);
            }
            
            
            
            
//            CustomerDAO customerDAO = new CustomerDAO(connection);
//            List<Customer> customerList = customerDAO.findAllSorted(20);
//            customerList.forEach(System.out::println);
            
            
//            OrderDAO orderDAO = new OrderDAO(connection);
//            List<Order> orderList = orderDAO.getOrderForCustomer(789);
//            orderList.forEach(System.out::println);
            
//            OrderDAO orderDAO = new OrderDAO(connection);
//            Order order = new Order();
//
//            order = orderDAO.findById(1000);
//            System.out.println(order);


//            CustomerDAO customerDAO = new CustomerDAO(connection);
//            Customer customer = new Customer();
//            customer.setFirstName("John");
//            customer.setLastName("Adams");
//            customer.setEmail("jadams@hw.gov");
//            customer.setPhone("(555) 555-66544");
//            customer.setAddress("1234 Main St");
//            customer.setCity("Mount Vernon");
//            customer.setState("VA");
//            customer.setZipCode("22121");
//

//            Customer dbCustomer = customerDAO.create(customer);
//            System.out.println(dbCustomer);
//            dbCustomer = customerDAO.findById(dbCustomer.getId());
//            System.out.println(dbCustomer);
//            dbCustomer.setEmail("john.adams@wh.gov");
//            dbCustomer = customerDAO.update(dbCustomer);
//            System.out.println(dbCustomer);
//            customerDAO.delete(dbCustomer.getId());

            
//            Customer customer = customerDAO.findById(10000);
//            System.out.println(customer.getFirstName() + " " + customer.getLastName() + " "
//                               + customer.getEmail());
//            customer.setEmail("gwashington@wh.gov");
//            customer = customerDAO.update(customer);
//            System.out.println(customer.getFirstName() + " " + customer.getLastName() + " "
//                    + customer.getEmail());
            
//            Customer customer = customerDAO.findById(1000);
//            System.out.println(customer.getFirstName() + " " + customer.getLastName());
            
            
//            Customer customer = new Customer();
//            customer.setFirstName("George");
//            customer.setLastName("Washington");
//            customer.setEmail("george.washington@wh.gov");
//            customer.setPhone("(555) 555-66543");
//            customer.setAddress("1234 Main St");
//            customer.setCity("Mount Vernon");
//            customer.setState("VA");
//            customer.setZipCode("22121");
//
//            customerDAO.create(customer);
//
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM customer");
//            while(resultSet.next()){
//                System.out.println(resultSet.getInt(1));
//            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        
    }
    
}
