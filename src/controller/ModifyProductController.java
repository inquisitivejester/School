package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){}

    public void onAddButton(ActionEvent actionEvent) {
    }

    public void onRemoveAssociatedButton(ActionEvent actionEvent) {
    }

    public void onCancelButton(ActionEvent actionEvent) {
    }

    public void onSaveButton(ActionEvent actionEvent) {
    }
}
