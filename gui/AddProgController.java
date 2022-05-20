/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidevuser.gui;

import edu.pidevuser.entities.Category;

import edu.pidevuser.entities.Programme;
import edu.pidevuser.services.ServiceCategory;
import edu.pidevuser.services.ServiceGuide;
import edu.pidevuser.services.ServiceProgramme;
import edu.pidevuser.services.ServiceRegion;
import edu.pidevuser.services.ServiceTransport;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author DEll
 */
public class AddProgController implements Initializable {

    @FXML
    private ComboBox<String> ComR;
    @FXML
    private TextField tfTitre;
    @FXML
    private TextField tfDescription;
    @FXML
    private TextField tfAdresse;
    @FXML
    private TextField tfPrix;
    @FXML
    private ComboBox<String> comG;
    @FXML
    private ComboBox<String> ComC;
    @FXML
    private ComboBox<String> ComT;
    @FXML
       private DatePicker Dpiker;
  final FileChooser fc = new FileChooser();
    @FXML
    private TextField tafile;
    @FXML
    private ImageView ivFile;
    private JFileChooser jFileChooser;
   

   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceRegion s = new ServiceRegion();
      ComR.setItems(s.getRegion());
         ServiceGuide g = new ServiceGuide();
      comG.setItems(g.getGuide());
       ServiceCategory c = new ServiceCategory();
      ComC.setItems(c.getCat());
        ServiceTransport T = new ServiceTransport();
      ComT.setItems(T.getTransport());
    
      
    }
    

    @FXML
    private Alert update(ActionEvent event) throws IOException {
        
       
        if(tfTitre.getText().isEmpty() || tfDescription.getText().isEmpty() 
                || tfPrix.getText().isEmpty() || tfAdresse.getText().isEmpty() 
                || tafile.getText().isEmpty() || String.valueOf(Dpiker.getValue()).isEmpty()
                ||ComC.getValue().isEmpty() || ComR.getValue().isEmpty() || comG.getValue().isEmpty() || ComT.getValue().isEmpty() )
        {
             Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Erreur lors de l'ajout du programme.");
        alert.setContentText("Vous devez replir tous les champs !");
     
        alert.showAndWait();
       
        return alert;
        }
        if(!(tfTitre.getText().matches("[a-z]+") || tfTitre.getText().matches("[A-Z]+"))){
       
         Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Erreur lors de l'ajout du programme.");
        alert.setContentText("Le Champ titre ne doit avoir que des lettres!");
     
        alert.showAndWait();
       
        return alert;
        
        }
        if(!((tfTitre.getText().length()>5))){
       
         Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Erreur lors de l'ajout du programme.");
        alert.setContentText("Le Champ titre doit contenir au minimum 5 lettres !");
     
        alert.showAndWait();
       
        return alert;
        
        }
        if(!((tfDescription.getText().length()>8))){
       
         Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Erreur lors de l'ajout du programme.");
        alert.setContentText("Le Champ description doit contenir au minimum 8 lettres !");
     
        alert.showAndWait();
       
        return alert;
        
        }
         if(!((tfPrix.getText().matches("[0-9]+")))){
       
         Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Erreur lors de l'ajout du programme.");
        alert.setContentText("Le Champ prix ne doit avoir que des chiffres !");
     
        alert.showAndWait();
       
        return alert;
        
        }
         if(!((tfPrix.getText().length()<3))){
       
         Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Erreur lors de l'ajout du programme.");
        alert.setContentText("Le prix du programme ne doit pas dépasser le 100dt !");
     
        alert.showAndWait();
       
        return alert;
        
        }
        else {Programme p=new Programme(tfTitre.getText(),tfDescription.getText(),Integer.parseInt(tfPrix.getText()),tfAdresse.getText(),
                 ComR.getValue(),comG.getValue(),ComT.getValue(),ComC.getValue(), String.valueOf(Dpiker.getValue()), tafile.getText());
        
        ServiceProgramme sp= new ServiceProgramme();
         p.setGuide(comG.getValue());
         System.out.println(p);
        sp.ajouter(p);
       
         FXMLLoader loader = new FXMLLoader(getClass().getResource("ProgIndex.fxml"));
        Parent root = loader.load();
        tfAdresse.getScene().setRoot(root);
        
      ProgIndexController apc = loader.getController();
        
        
        
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Erreur");
        alert.setHeaderText("Programme "+tfTitre.getText()+" Ajoutée avec Succée");
        alert.setContentText("Consulter la liste des programmes pour verifier");
     
        alert.showAndWait();
       
        return alert;}
     
    }    

    @FXML
    private void liste(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("ProgIndex.fxml"));
        Parent root = loader.load();
        tfAdresse.getScene().setRoot(root);
        
      ProgIndexController apc = loader.getController();
    }

   
    public TextField getTfTitre() {
        return tfTitre;
    }

    public TextField getTfDescription() {
        return tfDescription;
    }

    public TextField getTfAdresse() {
        return tfAdresse;
    }

    public TextField getTfPrix() {
        return tfPrix;
    }

    public void setTfTitre(TextField tfTitre) {
        this.tfTitre = tfTitre;
    }

    public void setTfDescription(TextField tfDescription) {
        this.tfDescription = tfDescription;
    }

    public void setTfAdresse(TextField tfAdresse) {
        this.tfAdresse = tfAdresse;
    }

    public void setTfPrix(TextField tfPrix) {
        this.tfPrix = tfPrix;
    }

    @FXML
  private void HandleOpenImgFile(ActionEvent event) {
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
        fc.getExtensionFilters().clear();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("img files", "*.png","*.jpg"));
        File file = fc.showOpenDialog(null);
        if(file != null){
        
       tafile.setText(file.getName());
       ivFile.setImage(new javafx.scene.image.Image(file.toURI().toString())); }
        
    
        
    }

   

    
      
    
    
    
    
    
    
}
    

