package org.yup;

import org.w3c.dom.ls.LSOutput;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StoreApp {
    public static void main(String[] args) {
        ArrayList<Product> inventory = loadInventory();
        Scanner scanner = new Scanner(System.in);

        Collections.sort(inventory, Comparator.comparing(Product::getName));

        System.out.println("We carry the following inventory: ");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.printf("id: %d %s - Price: $%.2f\n", p.getId(), p.getName(), p.getPrice());
        }
    }

    public static ArrayList<Product> loadInventory() {

        try {
            FileReader finder = new FileReader("inventory.csv");
            BufferedReader reader = new BufferedReader(finder);

            ArrayList<String> inventory = new ArrayList<>();

            System.out.println(inventory);
            System.out.println(inventory.size());
            String theLine;
            while ((theLine = reader.readLine()) != null) {

                String[] item = theLine.split("\\|");

                inventory.add(item[1]);

            }
        } catch (IOException e) {
            System.out.println("No <3");
        }
/*
        ArrayList<Product> loadInventory; {
            ArrayList<Product> inventory = new ArrayList<Product>();


            inventory.add(new Product(0, "rice cakes", 2));
            inventory.add(new Product(1, "bagged baby spinach", 4));
            inventory.add(new Product(2, "cocoa almond spread", 3));
            inventory.add(new Product(3, "dozen eggs", 9));
            inventory.add(new Product(4, "lb. tomatoes", 2));
            inventory.add(new Product(5, "gallon orange juice", 3));

            return inventory;


        }*/
    }
}