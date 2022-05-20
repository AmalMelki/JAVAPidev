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
public class ShowTransportController implements Initializable {

    @FXML
    private TextField tfMatricule;
    @FXML
    private TextField tfCapacite;
    private OptionTransport t;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void liste(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GuideIndex.fxml"));
        Parent root = loader.load();
        tfMatricule.getScene().setRoot(root);
      GuideIndexController apc = loader.getController();
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
        ServiceTransport st = new ServiceTransport();
       t.setMatricule(tfMatricule.getText());
       t.setCapacite(Integer.parseInt(tfCapacite.getText()));
       
       st.modifier(t);
       System.out.println(t);
      
         FXMLLoader loader = new FXMLLoader(getClass().getResource("TransportIndex.fxml"));
        Parent root = loader.load();
        tfMatricule.getScene().setRoot(root);
      TransportIndexController apc = loader.getController();
    }

    public TextField getTfMatricule() {
        return tfMatricule;
    }

    public TextField getTfCapacite() {
        return tfCapacite;
    }

    public OptionTransport getT() {
        return t;
    }

    public void setTfMatricule(TextField tfMatricule) {
        this.tfMatricule = tfMatricule;
    }

    public void setTfCapacite(TextField tfCapacite) {
        this.tfCapacite = tfCapacite;
    }

    public void setT(OptionTransport t) {
        this.t = t;
    }
    
    
}
