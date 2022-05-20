/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidevuser.gui;

import edu.pidevuser.entities.Category;
import edu.pidevuser.entities.Programme;
import edu.pidevuser.services.ServiceCategory;
import edu.pidevuser.services.ServiceProgramme;
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
public class ListeCategoryController implements Initializable {

    @FXML
    private Button Btprog;
    @FXML
    private Button Btcategorie;
    @FXML
    private Button Bttransport;
    @FXML
    private Button Btguide;
    @FXML
    private TableView<Category> table1;
    @FXML
    private TableColumn<Category, String> titreC1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       table();
    }    

    @FXML
    private void listeprog(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProgIndex.fxml"));
        Parent root = loader.load();
        Btcategorie.getScene().setRoot(root);
        
       ProgIndexController apc = loader.getController();
    }

    @FXML
    private void listecategorie(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("listeCtegory.fxml"));
        Parent root = loader.load();
        Btcategorie.getScene().setRoot(root);
        
       ListeCategoryController apc = loader.getController();
    }

     @FXML
    private void listetransport(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("TransportIndex.fxml"));
        Parent root = loader.load();
        table1.getScene().setRoot(root);
        
       TransportIndexController apc = loader.getController();
        
    }

    @FXML
    private void listeguide(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("GuideIndex.fxml"));
        Parent root = loader.load();
        table1.getScene().setRoot(root);
        
       GuideIndexController apc = loader.getController();
    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("addCategory.fxml"));
        Parent root = loader.load();
        table1.getScene().setRoot(root);
        
       AddCategoryController apc = loader.getController();
    }
      public void table(){
          ServiceCategory s = new ServiceCategory();
    

        
        ObservableList<Category> all;
        all =s.getAll();
       table1.setItems(all);
       titreC1.setCellValueFactory(new PropertyValueFactory<Category,String>("titre"));
      
    
    }

    @FXML
    private void delete(ActionEvent event) throws IOException {
         Category c = table1.getSelectionModel().getSelectedItem();
        ServiceCategory s= new ServiceCategory();
         System.out.println(c);
       
        
         FXMLLoader loader = new FXMLLoader(getClass().getResource("listeCategory.fxml"));
         ProgIndexController apc = loader.getController();
          s.supprimer(c.getId());
        Parent root = loader.load();
        table1.getScene().setRoot(root);
        
    }

    @FXML
    private void update(ActionEvent event) throws IOException {
         Category cat = table1.getSelectionModel().getSelectedItem();
           FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowCategory.fxml"));
        Parent root = loader.load();
        table1.getScene().setRoot(root);
        
       ShowCategoryController apc = loader.getController();
       apc.getTfTitre().setText(cat.getTitre());
       apc.setCat(cat);
    }
}
