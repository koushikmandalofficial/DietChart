package com.app.dietchartfinal.model;

import java.io.Serializable;
import java.util.ArrayList;

public class FoodInformationModel  implements Serializable {
    int id,foodImg;
    String name,protein,fat,cal,carbo,details;

    ArrayList<FoodInformationModel> SuggestionList;

    public FoodInformationModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getCal() {
        return cal;
    }

    public void setCal(String cal) {
        this.cal = cal;
    }

    public String getCarbo() {
        return carbo;
    }

    public void setCarbo(String carbo) {
        this.carbo = carbo;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public ArrayList<FoodInformationModel> getSuggestionList() {
        return SuggestionList;
    }

    public void setSuggestionList(ArrayList<FoodInformationModel> suggestionList) {
        SuggestionList = suggestionList;
    }

    public int getFoodImg() {
        return foodImg;
    }

    public void setFoodImg(int foodImg) {
        this.foodImg = foodImg;
    }

    public FoodInformationModel(int id, int foodImg, String name, String protein, String fat, String cal, String carbo, String details, ArrayList<FoodInformationModel> suggestionList) {
        this.id = id;
        this.foodImg = foodImg;
        this.name = name;
        this.protein = protein;
        this.fat = fat;
        this.cal = cal;
        this.carbo = carbo;
        this.details = details;
        SuggestionList = suggestionList;
    }

    public static class Suggestion implements  Serializable{
        int suggestionImg;
        String suggestionName;

        public int getSuggestionImg() {
            return suggestionImg;
        }

        public void setSuggestionImg(int suggestionImg) {
            this.suggestionImg = suggestionImg;
        }

        public String getSuggestionName() {
            return suggestionName;
        }

        public void setSuggestionName(String suggestionName) {
            this.suggestionName = suggestionName;
        }

        public Suggestion(int suggestionImg, String suggestionName) {
            this.suggestionImg = suggestionImg;
            this.suggestionName = suggestionName;
        }
    }

}
