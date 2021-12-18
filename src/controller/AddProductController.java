package controller;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){}
}
