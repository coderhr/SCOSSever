package esd.scos.servlet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataList {
   List<Data> coldFoodData = null;
   List<Data>hotFoodData = null;
   List<Data>seaFoodData = null;
   List<Data>drinkFoodData = null;
    int lenOfCold = 0;
    int lenOfHot = 0;
    int lenOfSea = 0;
    int lenOfDrink = 0;

    public void update(int update) {
        if (update == 1) {
            lenOfCold = 0;
            lenOfHot = 0;
            lenOfSea = 0;
            lenOfDrink = 0;

        }
    }

    public List<Data> getData(String type) {
        switch (type) {
            case "coldFood":
                coldFoodData = new ArrayList<>();
                coldFoodData.addAll(addData(type));
                if (lenOfCold < coldFoodData.size()) {
                    lenOfCold = coldFoodData.size();
                }
                return coldFoodData;
            case "hotFood":
                hotFoodData = new ArrayList<>();
                hotFoodData.addAll(addData(type));
                if (lenOfHot < hotFoodData.size()) {
                    lenOfHot = hotFoodData.size();
                }
                return hotFoodData;
            case "seaFood":
                seaFoodData = new ArrayList<>();
                seaFoodData.addAll(addData(type));
                if (lenOfSea < seaFoodData.size()) {
                    lenOfSea = seaFoodData.size();
                }
                return seaFoodData;
            case "drinkFood":
                drinkFoodData = new ArrayList<>();
                drinkFoodData.addAll(addData(type));
                if (lenOfDrink < drinkFoodData.size()) {
                    lenOfDrink = drinkFoodData.size();
                }
                return drinkFoodData;
                default:
                    return new ArrayList<>();
        }
    }

    public List<Data> addData(String Type) {
        if (Type.equals("coldFood")) {
            List<Data> coldFood = new ArrayList<>();
            for (int i = 1; i < 11; i++) {
                coldFood.add(new Data("菜名" + i, 8 * i, 1));
            }
            if (lenOfCold < coldFood.size()) {
                lenOfCold = coldFood.size();
                return coldFood;
            }
        } else if (Type.equals("hotFood")) {
            List<Data> hotFood = new ArrayList<>();
            for (int i = 11; i < 21; i++) {
                hotFood.add(new Data("菜名" + i, 8 * i, 1));
            }
            if (lenOfHot < hotFood.size()) {
                lenOfHot = hotFood.size();
                return hotFood;
            }
        } else if (Type.equals("seaFood")) {
            List<Data> seaFood = new ArrayList<>();
            for (int i = 21; i < 31; i++) {
                seaFood.add(new Data("菜名" + i, 8 * i, 1));
            }
            if (lenOfSea < seaFood.size()) {
                lenOfSea = seaFood.size();
                return seaFood;
            }
        } else {
            List<Data> drinkFood = new ArrayList<>();
            for (int i = 31; i < 41; i++) {
                drinkFood.add(new Data("菜名" + i, 8 * i, 1));
            }
            if (lenOfDrink < drinkFood.size()) {
                lenOfDrink = drinkFood.size();
                return drinkFood;
            }
        }
        return null;
    }
}