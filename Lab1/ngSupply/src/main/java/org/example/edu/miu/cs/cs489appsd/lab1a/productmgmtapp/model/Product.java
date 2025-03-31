package org.example.edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Product {
    private long id;
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;
    private int quantity;
    private double unitPrice;

    public Product() {}

    public Product(long id, String name, Date date, int quantity, double unitPrice) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    // Getters and Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }
}
