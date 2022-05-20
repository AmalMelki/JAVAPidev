/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidevuser.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author DEll
 */
public class AnnonceController implements Initializable {

    @FXML
    private ImageView imgProg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Frontannonce(ActionEvent event) throws IOException {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("FrontV.fxml"));
        Parent root = loader.load();
        imgProg.getScene().setRoot(root);
        FrontVController apc = loader.getController();
    }
    
}
