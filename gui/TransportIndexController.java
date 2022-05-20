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
public class TransportIndexController implements Initializable {

    @FXML
    private Button Btprog;
    @FXML
    private Button BTcategorie;
    @FXML
    private Button Bttransport;
    @FXML
    private Button Btguide;
    @FXML
    private TableView<OptionTransport> table;
    @FXML
    private TableColumn<OptionTransport, String> matriculeC;
    @FXML
    private TableColumn<OptionTransport,Integer> CapaciteC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       table();
    }  
           public void table(){
               ServiceTransport s = new ServiceTransport();
    

        
        ObservableList<OptionTransport> all;
        all =s.getAll();
       table.setItems(all);
       matriculeC.setCellValueFactory(new PropertyValueFactory<OptionTransport,String>("matricule"));
      CapaciteC.setCellValueFactory(new PropertyValueFactory<OptionTransport,Integer>("capacite"));
      
 
          
        
        
       
        
    
    
    
    }

    @FXML
    private void listeprog(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProgIndex.fxml"));
        Parent root = loader.load();
        table.getScene().setRoot(root);
        
      
    }

    @FXML
    private void listecategorie(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("listeCategory.fxml"));
        Parent root = loader.load();
        table.getScene().setRoot(root);
        
       AddProgController apc = loader.getController();
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
          FXMLLoader loader = new FXMLLoader(getClass().getResource("AddTransport.fxml"));
        Parent root = loader.load();
        table.getScene().setRoot(root);
        
       AddTransportController apc = loader.getController();
       
    }

    @FXML
    private void modifier(ActionEvent event) throws IOException {
                 OptionTransport T = table.getSelectionModel().getSelectedItem();
           FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowTransport.fxml"));
        Parent root = loader.load();
        table.getScene().setRoot(root);
        
       ShowTransportController apc = loader.getController();
       apc.getTfMatricule().setText(T.getMatricule());
      
       apc.getTfCapacite().setText(String.valueOf(T.getCapacite()));
       apc.setT(T);
    }

    @FXML
    private void supprimer(ActionEvent event) throws IOException {
         OptionTransport t = table.getSelectionModel().getSelectedItem();
        ServiceTransport s= new ServiceTransport();
           s.supprimer(t.getId());
        
       
        
         FXMLLoader loader = new FXMLLoader(getClass().getResource("TransportIndex.fxml"));
       
          
        Parent root = loader.load();
        table.getScene().setRoot(root);
    }
    
}
