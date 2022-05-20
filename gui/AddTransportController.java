/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidevuser.gui;

import edu.pidevuser.entities.OptionTransport;
import edu.pidevuser.services.ServiceTransport;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author DEll
 */
public class AddTransportController implements Initializable {

    @FXML
    private TextField tfMatricule;
    @FXML
    private TextField tfCapacite;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   

    @FXML
    private void liste(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("TransportIndex.fxml"));
        Parent root = loader.load();
        tfCapacite.getScene().setRoot(root);
        
        TransportIndexController apc = loader.getController();}

    @FXML
    private void addTransport(ActionEvent event) throws IOException {
        
        OptionTransport t=new OptionTransport(tfMatricule.getText(),Integer.parseInt(tfCapacite.getText()));
          ServiceTransport sp= new ServiceTransport();
        sp.ajouter(t);
          FXMLLoader loader = new FXMLLoader(getClass().getResource("TransportIndex.fxml"));
        Parent root = loader.load();
        tfCapacite.getScene().setRoot(root);
        
        TransportIndexController apc = loader.getController();
    }
    
    
}
