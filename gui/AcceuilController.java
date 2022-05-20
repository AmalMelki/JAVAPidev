/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidevuser.gui;

import edu.pidevuser.entities.Programme;
import edu.pidevuser.entities.User;
import edu.pidevuser.services.ProfileUser;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author DEll
 */
public class AcceuilController implements Initializable {

    @FXML
    private VBox chosenFruitCard;
    @FXML
    private Label lbdate;
    @FXML
    private Label lbadress;
    @FXML
    private GridPane grid;
    private User u;
    @FXML
    private Label firstname;
    @FXML
    private Label lastname;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         int column=0;
        int row=1;
            try {
       
        
                FXMLLoader loader = new FXMLLoader(getClass().getResource("annonce.fxml"));
                 AnchorPane anchorPane = loader.load();
                 
              
                grid.add(anchorPane,column,row++);
                
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_COMPUTED_SIZE);
                
                 grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                 grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                 grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
     
                
                GridPane.setMargin(anchorPane, new Insets(30));
                
               FXMLLoader loader2 = new FXMLLoader(getClass().getResource("Programme.fxml"));
                 AnchorPane anchorPane2 = loader2.load();
                 
           
                grid.add(anchorPane2,column,row);
                
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_COMPUTED_SIZE);
                
                 grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                 grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                 grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
                
                GridPane.setMargin(anchorPane2, new Insets(30));
                      
               
            
            
            } catch (IOException ex) {
                Logger.getLogger(ProgFrontController.class.getName()).log(Level.SEVERE, null, ex);
            }
        // TODO
    }  

    public User getU() {
        return u;
    }

    public Label getFirstname() {
        return firstname;
    }

    public Label getLastname() {
        return lastname;
    }

    public void setU(User u) {
        this.u = u;
    }

    public void setFirstname(Label firstname) {
        this.firstname = firstname;
    }

    public void setLastname(Label lastname) {
        this.lastname = lastname;
    }
    

    @FXML
    private void Logout(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/LoginUserFXML.fxml"));
       
        Parent root = loader.load();
        
        firstname.getScene().setRoot(root);
    }

    @FXML
    private void Profile(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/ProfileUser.fxml"));
       
        Parent root = loader.load();
        
        firstname.getScene().setRoot(root);
        ProfileUserController profileUserController =loader.getController();
        ProfileUser profileUser = new ProfileUser();
        profileUserController.AfficherUser(String.valueOf(u.getId()));
        profileUserController.setUser(u);
        
        
    }
    
}
