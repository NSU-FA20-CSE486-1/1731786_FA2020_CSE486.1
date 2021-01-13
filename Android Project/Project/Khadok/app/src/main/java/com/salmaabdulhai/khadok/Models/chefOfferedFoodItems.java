package com.salmaabdulhai.khadok.Models;

public class chefOfferedFoodItems {


    // took image as int since image will be taken from the drawable folder
    int offeredFoodImage;
    String offeredFoodName, offeredFoodPrice, offeredFoodDescription;

    public chefOfferedFoodItems(int offeredFoodImage, String offeredFoodName, String offeredFoodPrice, String offeredFoodDescription) {
        this.offeredFoodImage = offeredFoodImage;
        this.offeredFoodName = offeredFoodName;
        this.offeredFoodPrice = offeredFoodPrice;
        this.offeredFoodDescription = offeredFoodDescription;
    }

    public int getOfferedFoodImage() {
        return offeredFoodImage;
    }

    public void setOfferedFoodImage(int offeredFoodImage) {
        this.offeredFoodImage = offeredFoodImage;
    }

    public String getOfferedFoodName() {
        return offeredFoodName;
    }

    public void setOfferedFoodName(String offeredFoodName) {
        this.offeredFoodName = offeredFoodName;
    }

    public String getOfferedFoodPrice() {
        return offeredFoodPrice;
    }

    public void setOfferedFoodPrice(String offeredFoodPrice) {
        this.offeredFoodPrice = offeredFoodPrice;
    }

    public String getOfferedFoodDescription() {
        return offeredFoodDescription;
    }

    public void setOfferedFoodDescription(String offeredFoodDescription) {
        this.offeredFoodDescription = offeredFoodDescription;
    }
}

