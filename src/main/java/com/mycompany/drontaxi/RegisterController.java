package com.mycompany.drontaxi;

import com.mycompany.drontaxi.db.User;
import com.mycompany.drontaxi.db.Userrole;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class RegisterController{
    
    @FXML
    private TextField userLogin;
    @FXML
    private PasswordField userPassword;

    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_DronTaxi_jar_1.0-SNAPSHOTPU");
    public static EntityManager em = emf.createEntityManager();
    
    @FXML
    private void switchBack() throws IOException{
         App.setRoot("primary");
    }
    
    @FXML
    private void registration() throws IOException {
        
        String userlogin = userLogin.getText();
        String userpassword = userPassword.getText();

        Query q = em.createNamedQuery("Userrole.findByRoleName");
        q.setParameter("roleName", "user");
        Userrole rol = (Userrole) q.getSingleResult();
        
        if (userlogin.isEmpty() || userpassword.isEmpty()) {
            System.out.println("Пустые поля");
        }else if (userpassword.length() < 6){
            System.out.println("Пароль должен быт больше 6 символов");
        }else {
            em.getTransaction().begin();

            User user = new User();
            user.setLogin(userlogin);
            user.setPassword(userpassword);
            user.setRoleId(rol);

            em.persist(user);
            em.getTransaction().commit();

            System.out.println("user login: " + userlogin);
            System.out.println("user pass: " + userpassword);

            App.setRoot("primary");
        }
    }  
}
