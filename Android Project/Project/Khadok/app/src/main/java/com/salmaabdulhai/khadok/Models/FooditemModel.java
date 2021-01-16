package com.salmaabdulhai.khadok.Models;

public class FooditemModel {


    int addimage;
    String addname, addprice, foodcategory, adddescription;

    public FooditemModel(String addname, String addprice, String foodcategory, String adddescription) {
        //this.addimage = addimage;
        this.addname = addname;
        this.addprice = addprice;
        this.adddescription = adddescription;
        this.foodcategory = foodcategory;
    }


    /*public int getAddimage() {
        return addimage;
    }

    public void setAddimage(int addimage) {
        this.addimage = addimage;
    }*/

    public String getAddname() {
        return addname;
    }

    public void setAddname(String addname) {
        this.addname = addname;
    }

    public String getAddprice() {
        return addprice;
    }

    public void setAddprice(String addprice) {
        this.addprice = addprice;
    }

    public String getAdddescription() {
        return adddescription;
    }

    public void setAdddescription(String adddescription) {
        this.adddescription = adddescription;
    }


    public String getFoodcategory() {
        return foodcategory;
    }

    public void setFoodcategory(String foodcategory) {
        this.foodcategory = foodcategory;
    }
}
