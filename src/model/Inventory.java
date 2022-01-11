package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Inventory {

    private static int partID = 10;

    public static int uniqueId(){
        return ++partID;
    }


    private static ObservableList<Part> inventory = FXCollections.observableArrayList();


    public static void addParts( Part part){
        inventory.add(part);

    }

    public static ObservableList<Part> getParts(){

        return inventory;
    }

    public static void addTestData(){
        InHouse wheel = new InHouse(uniqueId(), "Bike Wheel", 21.99, 4, 2, 8);
        InHouse tube = new InHouse(uniqueId(), "Bike Tube", 10.99, 2,1, 5);
        InHouse handlebar = new InHouse(uniqueId(), "Handlebars", 35.00, 1,1, 2);
        InHouse seat = new InHouse(uniqueId(), "Seat", 13.99, 2,1, 4);
        Outsourced chickenLiver = new Outsourced(uniqueId(), "Chicken Liver", 1.99, 2, 1, 5, "Chickn'lvers'r'us");
        Inventory.addParts(wheel);
        Inventory.addParts(tube);
        Inventory.addParts(handlebar);
        Inventory.addParts(seat);
        Inventory.addParts(chickenLiver);

        Product car = new Product(uniqueId(), "Car", 20000, 6, 4, 10);
        Product bike = new Product(uniqueId(), "Bike", 200, 20, 5, 40);
        Product helicopter = new Product(uniqueId(), "Helicopter", 2000000, 2, 2, 3);
        Inventory.addProducts(car);
        Inventory.addProducts(bike);
        Inventory.addProducts(helicopter);

    }

    private static ObservableList<Product> productInventory = FXCollections.observableArrayList();

    public static void addProducts (Product product) {

        productInventory.add(product);
    }

    public static ObservableList<Product> getProducts() {

        return productInventory;
    }


}
