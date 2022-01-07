package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Part;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static controller.MainController.getPartToModify;


public class ModifyPartController implements Initializable {
    public RadioButton in_house_radio_button;
    public Label name_label;
    public Label machine_id_company_name_label;
    public RadioButton outsourced_radio_button;
    public Button modify_part_save_button;
    public Button modify_part_cancel_button;
    public TextField minTextField;
    public TextField machineIdTextField;
    public TextField maxTextField;
    public TextField priceTextField;
    public TextField invTextField;
    public TextField nameTextField;
    public TextField idTextBox;
    private Part partSelected;

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

        partSelected = getPartToModify();
        minTextField.setText(String.valueOf(partSelected.getMin()));
        invTextField.setText(String.valueOf(partSelected.getStock()));
        nameTextField.setText(String.valueOf(partSelected.getName()));
        maxTextField.setText(String.valueOf(partSelected.getMax()));
        priceTextField.setText(String.valueOf(partSelected.getPrice()));
        idTextBox.setText(String.valueOf(partSelected.getId()));


    }

    public void onInHouse(ActionEvent actionEvent) {
    }

    public void onOutsourced(ActionEvent actionEvent) {
    }

    public void onSave(ActionEvent actionEvent) {

    }

    public void onCancel(ActionEvent actionEvent) throws IOException {
        toMainScreen(actionEvent);
    }
}
