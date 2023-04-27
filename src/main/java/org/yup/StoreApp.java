package org.yup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StoreApp {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();
        Scanner scanner = new Scanner(System.in);

        Collections.sort(inventory, Comparator.comparing(Product::getName));

        System.out.println("We carry the following inventory: ");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("id: %d %s - Price: $%.2f\n", p.getId(), p.getName(), p.getPrice());
        }
    }
    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory =
                new ArrayList<Product>();

        inventory.add(new Product(0,"rice cakes",2));
        inventory.add(new Product(1,"bagged baby spinach",4));
        inventory.add(new Product(2,"cocoa almond spread",3));
        inventory.add(new Product(3,"dozen eggs",9));
        inventory.add(new Product(4,"lb. tomatoes",2));
        inventory.add(new Product(5,"gallon orange juice",3));

        return inventory;
    }
}