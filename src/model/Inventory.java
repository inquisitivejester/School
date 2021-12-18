package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class Inventory {
    private static ObservableList<Part> inventory = FXCollections.observableArrayList();

    public static void addParts(Part part){
        inventory.add(part);

    }

    public static ObservableList<Part> getparts(){
        return inventory;
    }

    public static void addTestData(){
        Wheel w = new Wheel(21, "Bike Wheel", 21.99, 4, 2, 8);
        Inventory.addParts(w);


    }
}
