/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidevuser.gui;

import edu.pidevuser.entities.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author DEll
 */
public class EspaceProgController implements Initializable {

    @FXML
    private Button P;
private User u;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    @FXML
    private void EspaceProg(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("ProgIndex.fxml"));
        Parent root = loader.load();
       P.getScene().setRoot(root);
        
       ProgIndexController apc = loader.getController();
      
    }
    
}
