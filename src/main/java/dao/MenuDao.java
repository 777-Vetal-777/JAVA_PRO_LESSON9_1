package dao;

import entities.Dish;

public interface MenuDao {
    void addDish(Dish dish);
    void getDishWithParam(int fromPrice, int toPrice);
    void selectDish();
    void getDishOnlyDisc();
    void getDishRandom();

}
