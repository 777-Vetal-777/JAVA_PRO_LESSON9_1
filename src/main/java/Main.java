import dao.MenuDao;
import dao.MenuDaoImpl;
import entities.Dish;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Scanner scanner = new Scanner(System.in);
        MenuDaoImpl menuDao = new MenuDaoImpl();
        menuDao.initial(entityManager);
        System.out.println("Please choose some option.\n " +
                "1- if you want to add new dish\n " +
                "2- if you want to get random dishes up to 1 kg\n " +
                "3- if you want to get some dishes with parameters\n " +
                "4- if you want to get dishes with discount(%)\n " +
                "5 - if you want to get All menu");
        System.out.print("Enter number: ");
        int num = scanner.nextInt();
        do {
            scanner.nextLine();
            choose(num, scanner, menuDao,entityManager);
            System.out.println("Please choose some option.\n " +
                    "1- if you want to add new dish\n " +
                    "2- if you want to get random dishes up to 1 kg\n " +
                    "3- if you want to get some dishes with parameters\n " +
                    "4- if you want to get dishes with discount(%)\n " +
                    "5 - if you want to get All menu\n " +
                    "0 - if you want to exit");
            System.out.print("Enter number: ");
            num = scanner.nextInt();
        } while (num != 0);
        entityManager.close();
        entityManagerFactory.close();


    }

    public static void choose(int num, Scanner scanner, MenuDaoImpl menuDao,EntityManager entityManager) {
        switch (num) {
            case 1:
                System.out.println("Enter name of Dish , please");
                String name = scanner.nextLine();
                System.out.println("Enter price of Dish, please");
                int price = scanner.nextInt();
                System.out.println("Enter weight of Dish, please");
                int weight = scanner.nextInt();
                System.out.println("Enter discount of Dish, please");
                int discount = scanner.nextInt();
                Dish dish = new Dish(name, weight, price, discount);
                menuDao.addDish(dish,entityManager);
                break;
            case 2:
                menuDao.getDishRandom(entityManager);

                break;
            case 3:
                System.out.println("Enter from price");
                double fromPrice = scanner.nextInt();
                System.out.println("Enter to price");
                double toPrice = scanner.nextInt();
                menuDao.getDishWithParam(fromPrice, toPrice, entityManager);
                break;
            case 4:
                menuDao.getDishOnlyDisc(entityManager);
                break;
            case 5:
                menuDao.selectDish(entityManager);
                break;
            case 0:
                break;
            default:
                System.out.println("You enter wrong number.");

        }
    }
}
