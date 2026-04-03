package com.example.passwordvalidator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.paint.Color;

public class PasswordValidatorController {
    @FXML
    private PasswordField passwordText;
    @FXML
    private Label status;
    @FXML
    public void initialize(){
        passwordText.textProperty().addListener((observable, oldValue, newValue) -> {
            validatePassword(newValue);
        });
    }
    private void validatePassword(String password){
        if(password.length() < 8){
            status.setText("Password must be 8 characters long!");
            status.setTextFill(Color.RED);
        } else if (!password.matches(".*\\d.*")){
            status.setText("Password must contain at least one digit");
            status.setTextFill(Color.RED);
        } else if (!password.matches(".*[!@#$%^&*()].*")){
            status.setText("Password must contain at least one special character");
            status.setTextFill(Color.RED);
        } else {
            status.setText("Password is valid");
            status.setTextFill(Color.GREEN);
        }
    }
}
