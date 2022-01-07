package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;


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
        availableParts wheel = new availableParts(uniqueId(), "Bike Wheel", 21.99, 4, 2, 8);
        availableParts tube = new availableParts(uniqueId(), "Bike Tube", 10.99, 2,1, 5);
        availableParts handlebar = new availableParts(uniqueId(), "Handlebars", 35.00, 1,1, 2);
        availableParts seat = new availableParts(uniqueId(), "Seat", 13.99, 2,1, 4);
        Inventory.addParts(wheel);
        Inventory.addParts(tube);
        Inventory.addParts(handlebar);
        Inventory.addParts(seat);

        AvailableProducts car = new AvailableProducts(uniqueId(), "Car", 20000, 6, 4, 10);
        AvailableProducts bike = new AvailableProducts(uniqueId(), "Bike", 200, 20, 5, 40);
        AvailableProducts helicopter = new AvailableProducts(uniqueId(), "Helicopter", 2000000, 2, 2, 3);
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
