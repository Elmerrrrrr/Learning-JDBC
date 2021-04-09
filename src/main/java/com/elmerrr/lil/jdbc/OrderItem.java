package com.elmerrr.lil.jdbc;

import java.math.BigInteger;

public class OrderItem {
    
    private String productName;
    private String productCode;
    private String productSize;
    private String productVariety;
    private String productPrice;
    private int quantity;
    
    
    public String getProductName() {
        return productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public String getProductCode() {
        return productCode;
    }
    
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    
    public String getProductSize() {
        return productSize;
    }
    
    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }
    
    public String getProductVariety() {
        return productVariety;
    }
    
    public void setProductVariety(String productVariety) {
        this.productVariety = productVariety;
    }
    
    public String getProductPrice() {
        return productPrice;
    }
    
    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    @Override
    public String toString() {
        return "OrderItem{" +
                "productName='" + productName + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productSize='" + productSize + '\'' +
                ", productVariety='" + productVariety + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

