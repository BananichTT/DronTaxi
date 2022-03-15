package com.mycompany.drontaxi;

import com.mycompany.drontaxi.db.User;
import com.mycompany.drontaxi.db.Userrole;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PrimaryController {

    @FXML
    public TextField userLogin;
    @FXML
    private PasswordField userPassword;

    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_DronTaxi_jar_1.0-SNAPSHOTPU");
    public static EntityManager em = emf.createEntityManager();

    @FXML
    private void switchToSecondary() throws IOException {

        Query q = em.createNamedQuery("User.findByLogin");
        String userlogin = userLogin.getText();
        String userpassword = userPassword.getText();
        
//         FXMLLoader loader = new FXMLLoader();
//         loader.setLocation(getClass().getResource("secondary.fxml"));
//         Parent root = loader.load();
//         SecondaryController sc = loader.getController();
//         sc.initialize(userlogin);
        q.setParameter("login", userlogin);

        try {
            User user = (User) q.getSingleResult();

            if (user.getPassword().equals(userpassword)) {
                Userrole role = user.getRoleId();
                if (role.getRoleName().equals("admin") || role.getRoleName().equals("user")) {
                    App.setRoot("secondary");
                }
            } else {
                System.out.println("Неверный логин или пароль!");
            }
        } catch (NoResultException e) {
            System.out.println("Неверный логин или пароль!");
        }
    }
    
    @FXML
    private void switchToRegister() throws IOException {
        App.setRoot("register");
    }
}
