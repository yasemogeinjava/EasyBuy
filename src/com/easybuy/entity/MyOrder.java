package com.easybuy.entity;

public class MyOrder {
   private Product product ;
   private int quantity;
   private int cost;

    public MyOrder() {
    }

    public MyOrder(Product product, int quantity, int cost) {
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
