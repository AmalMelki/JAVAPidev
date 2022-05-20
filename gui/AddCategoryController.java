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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author DEll
 */
public class AddCategoryController implements Initializable {

    static void SetFiedText() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private TextField tfTitre;

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
        Parent root = loader.load();
        tfTitre.getScene().setRoot(root);
        
       
    }
    

    @FXML
    private void nouveau(ActionEvent event) throws IOException {
          Category p=new Category(tfTitre.getText());
        ServiceCategory sp= new ServiceCategory();
        sp.ajouter(p);
           FXMLLoader loader = new FXMLLoader(getClass().getResource("listeCategory.fxml"));
        Parent root = loader.load();
        tfTitre.getScene().setRoot(root);
        
     
    }
    
    
}
