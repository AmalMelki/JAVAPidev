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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author DEll
 */
public class GuideIndexController implements Initializable {

    @FXML
    private Button Btprog;
    @FXML
    private Button BTcategorie;
    @FXML
    private Button Bttransport;
    @FXML
    private Button Btguide;
    @FXML
    private TableView<OptionGuide> table;
    @FXML
    private TableColumn<OptionGuide,String> NomC;
    @FXML
    private TableColumn<OptionGuide,String> PrenomC;
    @FXML
    private TableColumn<OptionGuide,String> TelC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        table();
    } 
       public void table(){
           ServiceGuide s = new ServiceGuide();
    

        
        ObservableList<OptionGuide> all;
        all =s.getAll();
       table.setItems(all);
      NomC.setCellValueFactory(new PropertyValueFactory<OptionGuide,String>("nom"));
      PrenomC.setCellValueFactory(new PropertyValueFactory<OptionGuide,String>("prenom"));
       TelC.setCellValueFactory(new PropertyValueFactory<OptionGuide,String>("tel"));
     
     
          
        
        
       
        
    
    
    
    }


     @FXML
    private void listeprog(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProgIndex.fxml"));
        Parent root = loader.load();
        table.getScene().setRoot(root);
        
       AddProgController apc = loader.getController();
    }

    @FXML
    private void listecategorie(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("listeCategory.fxml"));
        Parent root = loader.load();
        table.getScene().setRoot(root);
        
       ListeCategoryController apc = loader.getController();
    }

    @FXML
    private void listetransport(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("TransportIndex.fxml"));
        Parent root = loader.load();
        table.getScene().setRoot(root);
        
       TransportIndexController apc = loader.getController();
        
    }

    @FXML
    private void listeguide(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("GuideIndex.fxml"));
        Parent root = loader.load();
        table.getScene().setRoot(root);
        
       GuideIndexController apc = loader.getController();
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("addGuide.fxml"));
        Parent root = loader.load();
        table.getScene().setRoot(root);
        
       AddGuideController apc = loader.getController();
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
         OptionGuide g = table.getSelectionModel().getSelectedItem();
           FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowGuide.fxml"));
        Parent root = loader.load();
        table.getScene().setRoot(root);
        
       ShowGuideController apc = loader.getController();
       apc.getTfNom().setText(g.getNom());
       apc.getTfPrenom().setText(g.getPrenom());
       apc.getTfTel().setText(String.valueOf(g.getTel()));
       apc.setG(g);
           
    }

    @FXML
    private void supprimer(ActionEvent event) throws IOException {
         OptionGuide g = table.getSelectionModel().getSelectedItem();
        ServiceGuide s= new ServiceGuide();
        s.supprimer(g.getId());
        
       
        
         FXMLLoader loader = new FXMLLoader(getClass().getResource("GuideIndex.fxml"));
       
          
        Parent root = loader.load();
        table.getScene().setRoot(root);
    }
    
}
