package com.mycompany.drontaxi;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SecondaryController {
   
   @FXML
    private Text logintext;

    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_DronTaxi_jar_1.0-SNAPSHOTPU");
    public static EntityManager em = emf.createEntityManager();
  
  @FXML
    public void initialize(String loginText){
        System.out.println(loginText);
        logintext.setText(loginText);
        System.out.println(logintext.getText());
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void switchProfile() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void profileEdit() throws IOException {
        App.setRoot("editUser");
    }

    @FXML
    private void userContr() throws IOException {
        App.setRoot("secondary2");
    }
}
