package com.easybuy.entity;

import java.util.List;

public class Cart {
    private Product product;
    private int quantity;
    private double cost;


    public Cart() {
    }

    public Cart(Product product, int quantity, double cost) {
        this.product = product;
        this.quantity = quantity;
        this.cost = cost;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
