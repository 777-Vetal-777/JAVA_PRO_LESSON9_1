package dao;

import entities.Dish;

import javax.persistence.EntityManager;

public interface MenuDao {
    void addDish(Dish dish, EntityManager entityManager);
    void getDishWithParam(double fromPrice, double toPrice,EntityManager entityManager);
    void selectDish(EntityManager entityManager);
    void getDishOnlyDisc(EntityManager entityManager);
    void getDishRandom(EntityManager entityManager);

}
