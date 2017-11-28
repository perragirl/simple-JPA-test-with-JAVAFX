/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import com.db.LoginQuery;
import com.entity.Login;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 *
 * @author perra
 */
public class LoginController implements Initializable {
    
     @FXML
    private JFXButton loginbutton;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private Label message;

    private List<Login> listLogin =  new ArrayList<>();
    
    private final LoginQuery query = new LoginQuery();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listLogin = query.listLogin();
        message.setVisible(false);
        username.setOnMousePressed((Event event) -> {
            message.setVisible(false);
        });
        password.setOnMousePressed((Event event) -> {
            message.setVisible(false);
        });
    }
    
    @FXML
    void LoginAction(ActionEvent event) {    
            
        listLogin.stream().forEach((Login l) -> {
            if( username.getText().equals(l.getUsername()) && password.getText().equals(l.getPassword())){
                
                    
                    TrayNotification notification = new TrayNotification("Log in", 
                            "The username: "+username.getText()
                                    +"\nThe password:"+password.getText()+"\tare valid"
                            , NotificationType.INFORMATION);
                    notification.showAndDismiss(Duration.seconds(3));
                    
                
            }else{
                message.setText("Username or Password is invalid");
                message.setVisible(true);
            }
         });
    }

   
}
