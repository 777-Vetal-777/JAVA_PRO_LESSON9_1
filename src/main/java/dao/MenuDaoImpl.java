package dao;

import entities.Dish;

import javax.persistence.*;

import java.util.List;


public class MenuDaoImpl implements MenuDao {


    @Override
    public void addDish(Dish dish,EntityManager entityManager) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(dish);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void getDishWithParam(double fromPrice, double toPrice,EntityManager entityManager) {
        TypedQuery<Dish> typedQuery = entityManager.createQuery("select c from Dish c where c.price between ?1 and ?2", Dish.class);
        typedQuery.setParameter(1, fromPrice);
        typedQuery.setParameter(2, toPrice);
        List<Dish> dishList = typedQuery.getResultList();
        for(Dish dish: dishList){
            System.out.println(dish);
        }

    }

    @Override
    public void selectDish(EntityManager entityManager) {
        TypedQuery<Dish> dishTypedQuery = entityManager.createNamedQuery("getAll", Dish.class);
        List<Dish> list = dishTypedQuery.getResultList();
        for (Dish dish : list) {
            System.out.println(dish);
        }

    }

    @Override
    public void getDishOnlyDisc(EntityManager entityManager) {
        TypedQuery<Dish> typedQuery = entityManager.createQuery("select c from Dish c where c.discount <>0", Dish.class);
        List<Dish> dishList = typedQuery.getResultList();
        for (Dish dish : dishList) {
            System.out.println(dish);
            double disc = dish.getPrice() / 100 * dish.getDiscount();
            System.out.println(dish.getName() + " price without discount is " + (dish.getPrice() - disc));

        }


    }

    @Override
    public void getDishRandom(EntityManager entityManager) {
        TypedQuery<Dish> dishTypedQuery = entityManager.createQuery("select c from Dish c ", Dish.class);
        List<Dish> dishList = dishTypedQuery.getResultList();
        int dishOne = (int) (Math.random() * dishList.size());
        int dishTwo = (int) (Math.random() * dishList.size());
        int dishThree = (int) (Math.random() * dishList.size());
        int dishFour = (int) (Math.random() * dishList.size());
        int dishFive = (int) (Math.random() * dishList.size());
        double weight = dishList.get(dishOne).getWeight() + dishList.get(dishTwo).getWeight() + dishList.get(dishThree).getWeight() +
                dishList.get(dishFour).getWeight() + dishList.get(dishFive).getWeight();
        if (weight > 1000) {
            this.getDishRandom(entityManager);
            return;
        }


        System.out.println(dishList.get(dishOne));
        System.out.println(dishList.get(dishTwo));
        System.out.println(dishList.get(dishThree));
        System.out.println(dishList.get(dishFour));
        System.out.println(dishList.get(dishFive));

    }

    public void initial(EntityManager entityManager) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(new Dish("pasta", 200, 150, 15));
            entityManager.persist(new Dish("chicken", 200, 120, 0));
            entityManager.persist(new Dish("soup", 200, 80, 10));
            entityManager.persist(new Dish("tea", 1000, 40, 0));
            entityManager.persist(new Dish("beef", 200, 150, 0));
            entityManager.persist(new Dish("pork", 200, 135, 10));
            entityManager.persist(new Dish("juice", 1000, 50, 0));
            entityManager.persist(new Dish("wine", 200, 100, 0));
            entityManager.persist(new Dish("sushi", 200, 200, 0));
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }

    }
}
