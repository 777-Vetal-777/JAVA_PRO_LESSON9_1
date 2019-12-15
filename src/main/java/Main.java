import dao.MenuDao;
import dao.MenuDaoImpl;
import entities.Dish;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MenuDaoImpl menuDao = new MenuDaoImpl();
        menuDao.initial();
        System.out.println("Please choose some option.\n " +
                "1- if you want to add new dish\n " +
                "2- if you want to get random dishes up to 1 kg\n " +
                "3- if you want to get some dishes from parameters\n " +
                "4- if you want to get dishes with discount\n " +
                "5 - if you want to get All menu");
        System.out.print("Enter number: ");
        int num = scanner.nextInt();
        do{
            scanner.nextLine();
            choose(num,scanner,menuDao);
            System.out.println("Please choose some option.\n " +
                    "1- if you want to add new dish\n " +
                    "2- if you want to get random dishes up to 1 kg\n " +
                    "3- if you want to get some dishes from parameters\n " +
                    "4- if you want to get dishes with discount\n " +
                    "5 - if you want to get All menu\n " +
                    "0 - if you want to exit");
            System.out.print("Enter number: ");
            num = scanner.nextInt();
        }while (num!=0);


    }
    public static void choose(int num,Scanner scanner,MenuDaoImpl menuDao){
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
                menuDao.addDish(dish);
                break;
            case 2:
                menuDao.getDishRandom();

                break;
            case 3:
                System.out.println("Enter from price");
                int fromPrice = scanner.nextInt();
                System.out.println("Enter to price");
                int toPrice = scanner.nextInt();
                menuDao.getDishWithParam(fromPrice, toPrice);
                break;
            case 4:
                menuDao.getDishOnlyDisc();
                break;
            case 5:
                menuDao.selectDish();
                break;
            case 0:
                break;
            default:
                System.out.println("You enter wrong number.");

        }
    }
}
