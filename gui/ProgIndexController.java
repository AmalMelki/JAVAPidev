/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidevuser.gui;

import edu.pidevuser.entities.Programme;
import edu.pidevuser.services.ServiceProgramme;
import edu.pidevuser.utils.DataSource;
import edu.pidevuser.utils.DataSource1;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author DEll
 */
public class ProgIndexController implements Initializable {
 Connection cnx = DataSource1.getinstance().getCnx();
    private TableView<Programme> table;
    private TableColumn<Programme, String> titreC;
    private TableColumn <Programme, String> descC;
    private TableColumn <Programme, String> adrC;
    private TableColumn <Programme, String> regionC;
    private TableColumn <Programme, String> dateC;
    private TableColumn <Programme, Float> prixC;
    private TableColumn <Programme, String> categorieC;
    private TableColumn <Programme, String> guideC;
    private TableColumn <Programme, String> transportC;
    private TableColumn<Programme,String> imgC;
    @FXML
    private Button Btprog;
    @FXML
    private Button BTcategorie;
    @FXML
    private Button Bttransport;
    @FXML
    private Button Btguide;
    private TextField tfTitre;
     private DatePicker Dpiker;
    private FileChooser fileChooser;
    private Button browse;
    private File file; 
    private Desktop desktop = Desktop.getDesktop();
    @FXML
    private VBox vItems;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ServiceProgramme s = new ServiceProgramme();
          ObservableList<Programme> all = s.getAll();
        final Node[] nodes= new Node[all.size()];
        for (int i = 0; i < nodes.length; i++) {
            try {
               int j=i;
                //nodes[i]= FXMLLoader.load(getClass().getResource("FXML1.fxml"));
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML1.fxml"));
                 AnchorPane anchorPane = loader.load();
                 
                FXML1Controller fXML1Controller = loader.getController();
                System.out.println(all.get(i));
                System.out.println(all.get(i));
               fXML1Controller.setData(all.get(i));
                vItems.getChildren().add(anchorPane);
                
            } catch (Exception e) {
            }
         
            
        }
        
      //table();

          
    }   
        /* public void table(){
      ServiceProgramme s = new ServiceProgramme();
    

        
        ObservableList<Programme> all;
        all =s.getAll();
        System.out.println(all);
       table.setItems(all);
       titreC.setCellValueFactory(new PropertyValueFactory<Programme,String>("titre"));
      descC.setCellValueFactory(new PropertyValueFactory<Programme,String>("description"));
      regionC.setCellValueFactory(new PropertyValueFactory<Programme,String>("region"));
       prixC.setCellValueFactory(new PropertyValueFactory<Programme,Float>("prix"));
       adrC.setCellValueFactory(new PropertyValueFactory<Programme,String>("adresse"));
      dateC.setCellValueFactory(new PropertyValueFactory<Programme,String>("date"));
      categorieC.setCellValueFactory(new PropertyValueFactory<Programme,String>("categorie"));
       guideC.setCellValueFactory(new PropertyValueFactory<Programme,String>("guide"));
       transportC.setCellValueFactory(new PropertyValueFactory<Programme,String>("transport"));
      imgC.setCellValueFactory(new PropertyValueFactory<Programme,String>("image"));
       
 
    
         }*/ 
  

    @FXML
     private void ajouter(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("addProg.fxml"));
        Parent root = loader.load();
       Btprog.getScene().setRoot(root);
        
       AddProgController apc = loader.getController();
       
    }

    @FXML
    private void listeprog(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ProgIndex.fxml"));
        Parent root = loader.load();
        Btprog.getScene().setRoot(root);
        
       ProgIndexController apc = loader.getController();
    }

    @FXML
    private void listecategorie(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("listeCategory.fxml"));
        Parent root = loader.load();
        BTcategorie.getScene().setRoot(root);
        
       ListeCategoryController apc = loader.getController();
    }

    @FXML
    private void listetransport(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("TransportIndex.fxml"));
        Parent root = loader.load();
        Btprog.getScene().setRoot(root);
        
      TransportIndexController apc = loader.getController();
        
    }

    @FXML
    private void listeguide(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("GuideIndex.fxml"));
        Parent root = loader.load();
        BTcategorie.getScene().setRoot(root);
        
       GuideIndexController apc = loader.getController();
    }

   
    
    
    

  

    @FXML
    private void Front(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("ProgFront.fxml"));
        Parent root = loader.load();
        BTcategorie.getScene().setRoot(root);
        ProgFrontController apc = loader.getController();
    }

    @FXML
    private void dashbord(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("DashBord.fxml"));
        Parent root = loader.load();
        BTcategorie.getScene().setRoot(root);
        DashBordController apc = loader.getController();
        
    }

    @FXML
    private void Logout(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/LoginUserFXML.fxml"));
       
        Parent root = loader.load();
        
        BTcategorie.getScene().setRoot(root);
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("AcceuilBack.fxml"));
        Parent root = loader.load();
        BTcategorie.getScene().setRoot(root);
    }

 
   

   
        
    }
    

