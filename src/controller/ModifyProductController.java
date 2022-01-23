package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Part;
import model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static controller.MainController.getPartToModify;
import static controller.MainController.getProductToModify;
import static model.Inventory.getParts;


public class ModifyProductController implements Initializable {


    public Button addButton;
    public Button removeAssociatedButton;
    public Button cancelButton;
    public Button saveButton;
    public TextField IDTextBox;
    public TextField nameTextBox;
    public TextField invTextBox;
    public TextField priceTextBox;
    public TextField maxTextBox;
    public TextField minTextBox;
    public TextField searchBar;
    public TableView topTable;
    public TableColumn topPartIdColumn;
    public TableColumn topPartNameColumn;
    public TableColumn topInventoryLevelColumn;
    public TableColumn topPriceColumn;
    public TableView bottomTable;
    public TableColumn bottomPartIdColumn;
    public TableColumn bottomPartNameColumn;
    public TableColumn bottomInventoryLevelColumn;
    public TableColumn bottomPriceColumn;
    private Product productSelected;

    private void toMainScreen(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/MainScene.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1200, 600);
        stage.setTitle("Main Screen");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        getParts();


        productSelected = getProductToModify();
        minTextBox.setText(String.valueOf(productSelected.getMin()));
        invTextBox.setText(String.valueOf(productSelected.getStock()));
        nameTextBox.setText(String.valueOf(productSelected.getName()));
        maxTextBox.setText(String.valueOf(productSelected.getMax()));
        priceTextBox.setText(String.valueOf(productSelected.getPrice()));
        IDTextBox.setText(String.valueOf(productSelected.getId()));

        topTable.setItems(getParts());

        topPartIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        topPartNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        topInventoryLevelColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        topPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        ObservableList<Part> associatedParts = getProductToModify().getAssociatedPartsInventory();

        bottomTable.setItems(associatedParts);

        bottomPartIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        bottomPartNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        bottomInventoryLevelColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
        bottomPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));


    }

    public void onAddButton(ActionEvent actionEvent) {

    }

    public void onRemoveAssociatedButton(ActionEvent actionEvent) {
    }

    public void onCancelButton(ActionEvent actionEvent) throws IOException {
        toMainScreen(actionEvent);
    }

    public void onSaveButton(ActionEvent actionEvent) {
    }
}
