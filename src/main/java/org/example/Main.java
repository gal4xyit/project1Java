package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Category> categories = Arrays.asList(
                new Category(1, "Електроніка"),
                new Category(2, "Смартфони"),
                new Category(3, "Аксесуари")
        );

        List<Product> products = Arrays.asList(
                new Product(1, "Ноутбук", 19999.99, "Високопродуктивний ноутбук для роботи та ігор", categories.get(0)),
                new Product(2, "Смартфон", 12999.50, "Смартфон з великим екраном та високою автономністю", categories.get(1)),
                new Product(3, "Навушники", 2499.00, "Бездротові навушники з шумозаглушенням", categories.get(2))
        );

        Cart cart = new Cart();
        Story story = new Story();

        while(true) {
            System.out.println("\nВиберіть опцію:");
            System.out.println("1 - Переглянути список товарів");
            System.out.println("2 - Додати товар до кошика");
            System.out.println("3 - Переглянути кошик");
            System.out.println("4 - Зробити замовлення");
            System.out.println("5 - Переглянути історію замовлень");
            System.out.println("6 - Видалити з кошику");
            System.out.println("7 - Пошук");
            System.out.println("0 - Вийти");

            int choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    for (Product product : products) {
                        System.out.println(product);
                    }
                    break;
                case 2:
                    System.out.println("Введіть ID товару для додавання до кошика:");
                    int id = scanner.nextInt();
                    if (id <= products.size()) {
                        if (id == 0){
                            break;
                        }
                        for (Product product : products) {
                            if (product.getId() == id) {
                                cart.addProduct(product);
                            }
                        }
                    }
                    else System.out.println("Товар з таким ID не знайдено");
                    break;
                case 3:
                    System.out.println(cart);
                    break;
                case 4:
                    if (cart.getProducts().isEmpty()){
                        System.out.println("Кошик порожній. Додайте товари перед оформленням замовлення.");
                    }else {
                        Order order = new Order(cart);
                        System.out.println("Замовлення оформлено!");
                        System.out.println(order);
                        story.addOrder(order);
                        cart.Clear();
                    }
                    break;
                case 5:
                    System.out.println(story);
                    break;
                case 6:
                    if (cart.getProducts().isEmpty()){
                        System.out.println("Кошик порожній. Додайте товари перед оформленням замовлення.");
                    }else {
                        System.out.println(cart);
                        System.out.println("Введіть ID товару для видалення з кошика:");
                        int idDel = scanner.nextInt();
                        if (idDel <= products.size()) {
                            if (idDel == 0){
                                break;
                            }
                            for (Product product : cart.getProducts()) {
                                if (product.getId() == idDel) {
                                    cart.removeProduct(product);
                                    break;
                                }
                            }
                        } else System.out.println("Товар з таким ID не знайдено");
                    }
                    break;
                case 7:
                    System.out.println("Введіть назву товару або його категорію:");
                    String item = scanner.next();
                    System.out.println("Товари за запитом: ");
                    for (Product product : products) {
                        if ((product.getName()).equalsIgnoreCase(item) || (product.getCategory().getName()).equalsIgnoreCase(item)) {
                            System.out.println(product);
                        }
                    }
                    break;
                case 0:
                    System.out.println("Дякуємо, що використовували наш магазин!");
                    return;
                default:
                    System.out.println("Невідома опція. Спробуйте ще раз.");
                    break;

            }

        }

    }
}