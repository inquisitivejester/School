package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import controller.MainController;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import main.Main;
import model.Part;


import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static model.Inventory.getParts;

public class AddProductController implements Initializable {
    public Button AddProductPageAdd;
    public Button addProductCancel;
    public Button addProductSaveButton;
    public Button addProductRemoveAssociatedPart;
    public TextField addProductIDTextBox;
    public TextField addProductINVTextBox;
    public TextField addProductNameTextBox;
    public TextField addProductPriceTextBox;
    public TextField maxTextBox;
    public TextField minTextBox;
    public TableView bottomTable;
    public TableColumn bottomTablePartId;
    public TableColumn bottomTablePartName;
    public TableColumn bottomTableInventoryLevel;
    public TableColumn bottomTablePrice;
    public TableView topTable;
    public TableColumn topTablePartId;
    public TableColumn topTablePartName;
    public TableColumn topTableInventoryLevel;
    public TableColumn topTablePrice;


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

        topTable.setItems(getParts());

        topTablePartId.setCellValueFactory(new PropertyValueFactory<>("id"));
        topTablePartName.setCellValueFactory(new PropertyValueFactory<>("name"));
        topTableInventoryLevel.setCellValueFactory(new PropertyValueFactory<>("stock"));
        topTablePrice.setCellValueFactory(new PropertyValueFactory<>("price"));

    }

    public void onAdd(ActionEvent actionEvent) {
    }

    public void onRemoveAssociation(ActionEvent actionEvent) {
    }

    public void onCancel(ActionEvent actionEvent) throws IOException {


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Cancel");
        alert.setHeaderText("Canceling ");
        alert.setContentText("Select OK to ignore your changes and return to the main screen.");
        Optional<ButtonType> result = alert.showAndWait();

        

    toMainScreen(actionEvent);

    }

    public void onSave(ActionEvent actionEvent) {
    }


}
