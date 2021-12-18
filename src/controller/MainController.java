package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Inventory;
import model.Part;
import model.Wheel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    public TableColumn part_id;
    public TableColumn parts_inventory_level;
    public TableColumn part_name;
    public TableColumn parts_cost_per_unit;
    public Button add_parts_button;
    public Button modify_parts_button;
    public Button delete_parts_button;
    public Label parts_label;
    public TextField parts_text_box;
    public TableColumn product_id;
    public TableColumn product_name;
    public TableColumn products_inventory_level;
    public TableColumn product_cost_per_unit;
    public Button add_products_button;
    public Button modify_products_button;
    public Button delete_products_button;
    public Label products_label;
    public TextField products_text_box;
    public Button exit_button;
    public TableView parts_table;
    public TableView products_table;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        parts_table.setItems(Inventory.getparts());

        part_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        part_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        parts_inventory_level.setCellValueFactory(new PropertyValueFactory<>("stock"));
        parts_cost_per_unit.setCellValueFactory(new PropertyValueFactory<>("price"));

    }





        public void onModifyProducts(ActionEvent actionEvent) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/view/ModifyPoduct.fxml"));
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Modify Products");
            stage.setScene(scene);
            stage.show();
        }

        public void onAddProducts(ActionEvent actionEvent) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/view/AddProduct.fxml"));
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Add Products");
            stage.setScene(scene);
            stage.show();
        }

        public void onDeleteProducts(ActionEvent actionEvent){
            System.out.println("Pushed delete Products");
        }

        public void toAddParts(ActionEvent actionEvent) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/view/AddPart.fxml"));
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Add Parts");
            stage.setScene(scene);
            stage.show();

        }

        public void onModifyParts(ActionEvent actionEvent) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/view/ModifyPart.fxml"));
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Modify Parts");
            stage.setScene(scene);
            stage.show();
        }

        public void onDeleteParts(ActionEvent actionEvent){
            System.out.println("Pushed delete parts");
        }

        public void onExit(ActionEvent actionEvent){
            System.out.println("Pushed exit");
        }
    }
