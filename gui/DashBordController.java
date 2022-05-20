/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidevuser.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

/**
 * FXML Controller class
 *
 * @author DEll
 */
public class DashBordController implements Initializable {

    @FXML
    private Button Btprog;
    @FXML
    private Button BTcategorie;
    @FXML
    private Button Bttransport;
    @FXML
    private Button Btguide;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        
        int column=0;
        int row=1;
            try {
       
        
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ChartPie.fxml"));
                 AnchorPane anchorPane = loader.load();
                 
               ChartPieController chartPieController = loader.getController();
                grid.add(anchorPane,column,row++);
                
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_COMPUTED_SIZE);
                
                 grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                 grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                 grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
                
                GridPane.setMargin(anchorPane, new Insets(30));
                
               FXMLLoader loader2 = new FXMLLoader(getClass().getResource("BarChart.fxml"));
                 AnchorPane anchorPane2 = loader2.load();
                 
               BarchartController barchartController = loader2.getController();
                grid.add(anchorPane2,column,row++);
                
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_COMPUTED_SIZE);
                
                 grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                 grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                 grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
                
                GridPane.setMargin(anchorPane2, new Insets(30));
                   FXMLLoader loader3 = new FXMLLoader(getClass().getResource("chart.fxml"));
                 AnchorPane anchorPane3 = loader3.load();
                 
               ChartController chartController = loader3.getController();
                grid.add(anchorPane3,column,row++);
                
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_COMPUTED_SIZE);
                
                 grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                 grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                 grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
                
                GridPane.setMargin(anchorPane2, new Insets(30));
               
            
               
            
            
            } catch (IOException ex) {
                Logger.getLogger(ProgFrontController.class.getName()).log(Level.SEVERE, null, ex);
            }
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
}
