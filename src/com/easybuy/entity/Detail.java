package com.easybuy.entity;

import java.util.List;

/**
 * 订单的实体类
 *
 * */
public class Detail {
    private List<Product> product;//订单中的商品列表
    private Integer id;//订单id
    private  Integer orderId;//顾客id
    private Integer productId;//商品id
    private  Integer quantity;//商品数量
    private  Integer cost;//总共消费额

    public Detail(List<Product> product, int id, int orderId, List<Integer> productId, String quantity, String cost) {
    }
    public Detail(Product product, int id, int orderId, int productId, String quantity, String cost) {
    }
    public Detail() {
    }

    public Detail(List<Product> product, Integer id, Integer orderId, Integer productId, Integer quantity, Integer cost) {
        this.product = product;
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.cost = cost;
    }


    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
