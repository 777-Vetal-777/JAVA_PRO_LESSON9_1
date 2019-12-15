package dao;

import entities.Dish;

public interface MenuDao {
    void addDish(Dish dish);
    void getDishWithParam(double fromPrice, double toPrice);
    void selectDish();
    void getDishOnlyDisc();
    void getDishRandom();

}
