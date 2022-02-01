package com.mycompany.drontaxi;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PrimaryController {
    
    @FXML
    private TextField userLogin;
    @FXML
    private PasswordField userPassword;
    

    @FXML
    private void switchToSecondary() throws IOException {
        String username = userLogin.getText();
        String password = userPassword.getText();
        
        if(username.equals("Sany") && password.equals("123")){
          App.setRoot("secondary");  
        }else{
            System.out.println("Неправильный логин или пароль!");
        }
        
    }
}
