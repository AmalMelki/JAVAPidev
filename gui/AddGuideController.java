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
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author DEll
 */
public class AddGuideController implements Initializable {

    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfTel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void nouveau(ActionEvent event) throws IOException {
       
         OptionGuide g=new OptionGuide(tfNom.getText(),tfPrenom.getText(),Integer.parseInt(tfTel.getText()));
         ServiceGuide sp= new ServiceGuide();
         System.out.println(g);
        sp.ajouter(g);
        JOptionPane.showMessageDialog(null,"Guide Ajouté!");
          FXMLLoader loader = new FXMLLoader(getClass().getResource("GuideIndex.fxml"));
        Parent root = loader.load();
        tfNom.getScene().setRoot(root);
        
    
      
    }
    

    @FXML
    private void liste(ActionEvent event) throws IOException {
        
         FXMLLoader loader = new FXMLLoader(getClass().getResource("GuideIndex.fxml"));
        Parent root = loader.load();
        tfNom.getScene().setRoot(root);
        
       GuideIndexController apc = loader.getController();}

    @FXML
    private Alert addguide(ActionEvent event) throws IOException {
         if(tfNom.getText().isEmpty() || tfPrenom.getText().isEmpty() || tfTel.getText().isEmpty())
        {
             Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Erreur lors de l'ajout du Guide.");
        alert.setContentText("Vous devez replir tous les champs !");
     
        alert.showAndWait();
       
        return alert;
        }
         if(!(tfNom.getText().matches("[a-z]+") || tfNom.getText().matches("[A-Z]+"))){
       
         Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Erreur lors de l'ajout du Guide.");
        alert.setContentText("Le Champ Nom ne doit avoir que des lettres!");
     
        alert.showAndWait();
       
        return alert;
        
        }
        if(!(tfPrenom.getText().matches("[a-z]+") || tfPrenom.getText().matches("[A-Z]+"))){
       
         Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Erreur lors de l'ajout du Guide.");
        alert.setContentText("Le Champ prnenom ne doit avoir que des lettres!");
     
        alert.showAndWait();
       
        return alert;
        
        }
        if(!((tfTel.getText().matches("[0-9]+")))){
       
         Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Erreur lors de l'ajout du Guide.");
        alert.setContentText("Le Champ Numéro de téléphone ne doit avoir que des chiffres !");
     
        alert.showAndWait();
       
        return alert;
        
        }
 
        if(!((tfTel.getText().length()==8))){
       
         Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Erreur lors de l'ajout du Guide.");
        alert.setContentText("Le Champ Numéro de téléphone doit obligatoirement 8 chiffres !");
     
        alert.showAndWait();
       
        return alert;
        
        }
       else{
         OptionGuide g=new OptionGuide(tfNom.getText(),tfPrenom.getText(),Integer.parseInt(tfTel.getText()));
         ServiceGuide sp= new ServiceGuide();
         System.out.println(g);
        sp.ajouter(g);
         FXMLLoader loader = new FXMLLoader(getClass().getResource("GuideIndex.fxml"));
        Parent root = loader.load();
        tfNom.getScene().setRoot(root);
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Erreur");
        alert.setHeaderText("Guide "+tfNom.getText()+" Ajoutée avec Succée");
        alert.setContentText("Consulter la liste des guides pour verifier");
     
        alert.showAndWait();
       
        return alert;
        
    }


    
}
}