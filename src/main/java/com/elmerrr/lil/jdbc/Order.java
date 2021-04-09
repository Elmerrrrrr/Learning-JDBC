package com.elmerrr.lil.jdbc;

import com.elmerrr.lil.jdbc.util.DataTransferObject;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Order implements DataTransferObject {
    
    
    private long order_Id;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private long customer_id;
    private Date creation_date;
    private int totalItems;
    private BigDecimal total_due;
    private String status;
    private String salespersonFirstName;
    private String salespersonLastName;
    private String salespersonEmail;
    private long salesperson_id;
    private List<OrderItem> orderItemList;
    
    
    @Override
    public long getId() {
        return 0;
    }
    
    
    public long getOrder_Id() {
        return order_Id;
    }
    
    public void setOrder_Id(long order_Id) {
        this.order_Id = order_Id;
    }
    
    public String getCustomerFirstName() {
        return customerFirstName;
    }
    
    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }
    
    public String getCustomerLastName() {
        return customerLastName;
    }
    
    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }
    
    public String getCustomerEmail() {
        return customerEmail;
    }
    
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
    
    public long getCustomer_id() {
        return customer_id;
    }
    
    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }
    
    public Date getCreation_date() {
        return creation_date;
    }
    
    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }
    
    public int getTotalItems() {
        return totalItems;
    }
    
    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }
    
    public BigDecimal getTotal_due() {
        return total_due;
    }
    
    public void setTotal_due(BigDecimal total_due) {
        this.total_due = total_due;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getSalespersonFirstName() {
        return salespersonFirstName;
    }
    
    public void setSalespersonFirstName(String salespersonFirstName) {
        this.salespersonFirstName = salespersonFirstName;
    }
    
    public String getSalespersonLastName() {
        return salespersonLastName;
    }
    
    public void setSalespersonLastName(String salespersonLastName) {
        this.salespersonLastName = salespersonLastName;
    }
    
    public String getSalespersonEmail() {
        return salespersonEmail;
    }
    
    public void setSalespersonEmail(String salespersonEmail) {
        this.salespersonEmail = salespersonEmail;
    }
    
    public long getSalesperson_id() {
        return salesperson_id;
    }
    
    public void setSalesperson_id(long salesperson_id) {
        this.salesperson_id = salesperson_id;
    }
    
    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }
    
    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
    
    @Override
    public String toString() {
        return "Order{" +
                "order_Id=" + order_Id +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", customerLastName='" + customerLastName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customer_id=" + customer_id +
                ", creation_date=" + creation_date +
                ", totalItems=" + totalItems +
                ", total_due=" + total_due +
                ", status='" + status + '\'' +
                ", salespersonFirstName='" + salespersonFirstName + '\'' +
                ", salespersonLastName='" + salespersonLastName + '\'' +
                ", salespersonEmail='" + salespersonEmail + '\'' +
                ", salesperson_id=" + salesperson_id +
                ", orderItemList=" + orderItemList +
                '}';
    }
}
