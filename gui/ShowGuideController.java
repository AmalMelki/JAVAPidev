/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidevuser.gui;

import edu.pidevuser.entities.OptionGuide;
import edu.pidevuser.services.ServiceGuide;
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
public class ShowGuideController implements Initializable {

    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfTel;
    private OptionGuide g;

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
        tfNom.getScene().setRoot(root);
      GuideIndexController apc = loader.getController();
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
         ServiceGuide sg = new ServiceGuide();
       g.setNom(tfNom.getText());
       g.setPrenom(tfPrenom.getText());
       g.setTel(Integer.parseInt(tfTel.getText()));
        
       sg.modifier(g);
      
      
         FXMLLoader loader = new FXMLLoader(getClass().getResource("GuideIndex.fxml"));
        Parent root = loader.load();
        tfNom.getScene().setRoot(root);
      GuideIndexController apc = loader.getController();
    }

    public TextField getTfPrenom() {
        return tfPrenom;
    }

    public TextField getTfNom() {
        return tfNom;
    }

    public TextField getTfTel() {
        return tfTel;
    }

    public OptionGuide getG() {
        return g;
    }

    public void setTfPrenom(TextField tfPrenom) {
        this.tfPrenom = tfPrenom;
    }

    public void setTfNom(TextField tfNom) {
        this.tfNom = tfNom;
    }

    public void setTfTel(TextField tfTel) {
        this.tfTel = tfTel;
    }

    public void setG(OptionGuide g) {
        this.g = g;
    }
    
    
}
