/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidevuser.gui;

import edu.pidevuser.entities.Category;
import edu.pidevuser.services.ServiceCategory;
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
public class ShowCategoryController implements Initializable {

    @FXML
    private TextField tfTitre;
    private Category cat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void liste(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("listeCategory.fxml"));
         ProgIndexController apc = loader.getController();
         
        Parent root = loader.load();
        tfTitre.getScene().setRoot(root);
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
         ServiceCategory c = new ServiceCategory();
        cat.setTitre(tfTitre.getText());
        
        c.modifier(cat);
        System.out.println(cat);
      
         FXMLLoader loader = new FXMLLoader(getClass().getResource("listeCategory.fxml"));
        Parent root = loader.load();
        tfTitre.getScene().setRoot(root);
       ListeCategoryController apc = loader.getController();
    }

    public TextField getTfTitre() {
        return tfTitre;
    }

    public Category getCat() {
        return cat;
    }

    public void setTfTitre(TextField tfTitre) {
        this.tfTitre = tfTitre;
    }

    public void setCat(Category cat) {
        this.cat = cat;
    }
    
}
