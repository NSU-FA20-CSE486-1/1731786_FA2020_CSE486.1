package com.salmaabdulhai.khadok.Models;

public class CustomerOrderModel {

    int orderedImage;
    String price, orderedFood, orderNumber;
    public CustomerOrderModel(){

    }

    public CustomerOrderModel(int orderedImage, String price, String orderedFood, String orderNumber) {
        this.orderedImage = orderedImage;
        this.price = price;
        this.orderedFood = orderedFood;
        this.orderNumber = orderNumber;

    }

    public int getOrderedImage() {
        return orderedImage;
    }

    public void setOrderedImage(int orderedImage) {
        this.orderedImage = orderedImage;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrderedFood() {
        return orderedFood;
    }

    public void setOrderedFood(String orderedFood) {
        this.orderedFood = orderedFood;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
