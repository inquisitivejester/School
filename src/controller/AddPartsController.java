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
import model.Inventory;
import model.InHouse;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static model.Inventory.getParts;
import static model.Inventory.uniqueId;

public class AddPartsController implements Initializable {
    public RadioButton in_house_radio_button;
    public Label name_label;
    public RadioButton outsourced_radio_button;
    public Label machine_id_company_name_label;
    public Button add_part_save_button;
    public Button add_part_cancel_button;
    public TextField priceTextBox;
    public TextField invTextBox;
    public TextField maxTextBox;
    public TextField machineIdTextBox;
    public TextField minTextBox;
    public TextField idTextBox;
    public TextField nameTextbox;

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


    }

    public void onInHouse(ActionEvent actionEvent) {
        machine_id_company_name_label.setText("Machine ID");
    }

    public void onOutSourced(ActionEvent actionEvent) {
        machine_id_company_name_label.setText("Company Name");
    }

    public void onSave(ActionEvent actionEvent) {
        try {
            String priceString = priceTextBox.getText();
            double price = 0;
            try {
                price = Double.parseDouble(priceString);

            } catch (NumberFormatException d) {
                System.out.println("Not a double jackass");
            }
            String invString = invTextBox.getText();
            int stock = 0;
            try {
                stock = Integer.parseInt(invString);
            } catch (NumberFormatException e) {
                System.out.println("Not an Integer");
            }
            String maxString = maxTextBox.getText();
            int max = 0;
            try {
                max = Integer.parseInt(maxString);
            } catch (NumberFormatException f) {
                System.out.println("Not an Integer");
            }
            String minString = minTextBox.getText();
            int min = 0;
            try {
                min = Integer.parseInt(minString);
            } catch (NumberFormatException g) {
                System.out.println("Not an Integer");
            }
            String idString = machineIdTextBox.getText();
            try {
                int id = Integer.parseInt(idString);
            } catch (NumberFormatException h) {
                System.out.println("Not an Integer");
            }
            String name = null;
            if (nameTextbox.getText().length() > 0) {
                name = nameTextbox.getText();
            } else {
                System.out.println("You didn't add a name.");
            }


            InHouse newAvailablePart = new InHouse(uniqueId(), name, price, stock, min, max);
            Inventory.addParts(newAvailablePart);
        }
        catch(Exception a){
            System.out.println("Nothing Worked");

            }
        }


    public void onCancel(ActionEvent actionEvent) throws IOException {
        toMainScreen(actionEvent);
    }


}
