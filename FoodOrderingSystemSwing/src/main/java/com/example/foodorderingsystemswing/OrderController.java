package com.example.foodorderingsystemswing;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import javax.swing.JOptionPane;

public class OrderController {
    private final double PIZZA = 100;
    private final double BURGER = 90;
    private final double FRIES = 65;
    private final double SOFTDRINKS = 55;
    private final double TEA = 50;
    private final double SUNDAE = 40;

    @FXML
    private CheckBox Pizza;
    @FXML
    private CheckBox Burger;
    @FXML
    private CheckBox Fries;
    @FXML
    private CheckBox Softdrinks;
    @FXML
    private CheckBox Tea;
    @FXML
    private CheckBox Sundae;
    @FXML
    private RadioButton rbNone;
    @FXML
    private RadioButton rb5;
    @FXML
    private RadioButton rb10;
    @FXML
    private RadioButton rb15;
    @FXML
    private ToggleGroup discountGroup;
    @FXML
    private void handleOrder(ActionEvent event){
      double total = 0;

      if(Pizza.isSelected()){
          total += PIZZA;
      }
      if(Burger.isSelected()){
            total += BURGER;
      }
      if(Fries.isSelected()){
            total += FRIES;
      }
      if(Softdrinks.isSelected()){
            total += SOFTDRINKS;
      }
      if(Tea.isSelected()){
            total += TEA;
      }
      if(Sundae.isSelected()){
            total += SUNDAE;
      }
      double discount = 0;

      if (rb5.isSelected()){
          discount = 0.05;
      } else if (rb10.isSelected()){
          discount = 0.1;
      } else if (rb15.isSelected()){
          discount = 0.15;
      }
      double finalTotal = total - (total * discount);

      JOptionPane.showMessageDialog(null, String.format("The total price is Php %.2f", finalTotal),
              "Total Price", JOptionPane.INFORMATION_MESSAGE);
    }
}
