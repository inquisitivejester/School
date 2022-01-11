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
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.Inventory;
import model.Part;
import model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static model.Inventory.getParts;
import static model.Inventory.getProducts;

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
    public TableView<Part> parts_table;
    public TableView products_table;
    private static Part partToModify;
    private static Product productToModify;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        getParts();
        getProducts();


        parts_table.setItems(getParts());

        part_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        part_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        parts_inventory_level.setCellValueFactory(new PropertyValueFactory<>("stock"));
        parts_cost_per_unit.setCellValueFactory(new PropertyValueFactory<>("price"));

        products_table.setItems(getProducts());

        product_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        product_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        products_inventory_level.setCellValueFactory(new PropertyValueFactory<>("stock"));
        product_cost_per_unit.setCellValueFactory(new PropertyValueFactory<>("price"));


    }
        public static Part getPartToModify() {
            return partToModify;
        }
        public static Product getProductToModify(){return productToModify;}

        private void toMainScreen(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/view/MainScene.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 1200, 600);
            stage.setTitle("Main Screen");
            stage.setScene(scene);
            stage.show();
        }


        public void onModifyProducts(ActionEvent actionEvent) throws IOException {
            productToModify = (Product) products_table.getSelectionModel().getSelectedItem();
            if (productToModify == null) {
                System.out.println("Need an alert for productToModify");
            } else {

                Parent root = FXMLLoader.load(getClass().getResource("/view/ModifyPoduct.fxml"));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setTitle("Modify Products");
                stage.setScene(scene);
                stage.show();
            }
        }

        public void onAddProducts(ActionEvent actionEvent) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("/view/AddProduct.fxml"));
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setTitle("Add Products");
            stage.setScene(scene);
            stage.show();
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

            partToModify = parts_table.getSelectionModel().getSelectedItem();
            if (partToModify == null) {
                System.out.println("Need an alert for partToModify");
            } else {


                Parent root = FXMLLoader.load(getClass().getResource("/view/ModifyPart.fxml"));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setTitle("Modify Parts");
                stage.setScene(scene);
                stage.show();
            }
        }

        public void onDeleteProducts(ActionEvent actionEvent){
            System.out.println("Pushed delete Products");
        }

        public void onDeleteParts(ActionEvent actionEvent){
            System.out.println("Pushed delete parts");
        }

        public void onExit(ActionEvent actionEvent){
            System.out.println("Pushed exit");
        }

        public void onKeyProductsSearch(KeyEvent keyEvent) {

        }




        public void onKeyPartsSearch(KeyEvent keyEvent) {
            String searchString = parts_text_box.getText();

            ObservableList<Part> theseParts = searchPartName(searchString);

            if(theseParts.size() == 0){
                try{
                    int partId = Integer.parseInt(searchString);
                    Part fp = getPartId(partId);
                    if(fp != null)
                        theseParts.add(fp);
                }
                catch(NumberFormatException n){
                    //ignore
                }
            }

            parts_table.setItems(theseParts);
        }

        private ObservableList<Part> searchPartName(String partName){
            ObservableList<Part> foundParts = FXCollections.observableArrayList();

            ObservableList<Part> allParts = getParts();

            for(Part fp : allParts){
                if(fp.getName().contains(partName)){
                    foundParts.add(fp);
                }
            }
            return foundParts;
        }

        private Part getPartId(int partId){
            ObservableList<Part> allParts = getParts();

            for(Part fp : allParts){
                if(fp.getId() == partId){
                    return fp;
                }
            }
        return null;
        }
}
