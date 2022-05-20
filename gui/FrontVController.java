/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidevuser.gui;

import edu.pidevuser.entities.Programme;
import edu.pidevuser.entities.Annonce;

import edu.pidevuser.services.ServiceProgramme;
import edu.pidevuser.gui.MyListener;
import edu.pidevuser.services.ServiceAnnonce;
import edu.pidevuser.services.ServiceCategory;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author DEll
 */
public class FrontVController implements Initializable {
    

    @FXML
    private Label lbtitre;
    @FXML
    private ImageView imgProg;
    private Label lbAdresse;
    @FXML
    private GridPane grid;
     private MyListener1 myListener;
    @FXML
    private VBox chosenFruitCard;
    @FXML
    private Label lbprice;
    @FXML
    private Label fruitPriceLabel1;
    @FXML
    private Label lbadress;
    @FXML
    private Label lbddesc;
    @FXML
    private ScrollPane scroll;
    @FXML
    private Label lbdate;
  
   
  
    
    ServiceAnnonce sp = new ServiceAnnonce();
       ObservableList<Annonce> all = sp.getAll();
    @FXML
    private Label lbdispo;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     
   
      
        
   if (all.size() > 0) {
            try {
                setChosenA(all.get(0));
            } catch (IOException ex) {
                Logger.getLogger(ProgFrontController.class.getName()).log(Level.SEVERE, null, ex);
            }
            myListener = new MyListener1() {
                @Override
                public void onClickListener(Annonce a) {
                   
                  try {
                        setChosenA(a);
                    } catch (IOException ex) {
                        Logger.getLogger(ProgFrontController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
           

            };
        }  
        
        int column=0;
        int row=1;
            try {
        for(int i=0;i<all.size();i++){
        
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FrontDetail.fxml"));
                 AnchorPane anchorPane = loader.load();
                 
                FrontDetailController frontDetailController = loader.getController();
               System.out.println(all.get(i));
                frontDetailController.setData(all.get(i), myListener);
                if (column == 2 ) {
                    column=0;
                    row ++;
                    
                
            }
                
                grid.add(anchorPane,column++,row);
              
                
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_COMPUTED_SIZE);
                
                 grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                 grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                 grid.setMaxHeight(Region.USE_COMPUTED_SIZE);
                
                GridPane.setMargin(anchorPane, new Insets(30));
               
            }
            
            } catch (IOException ex) {
                Logger.getLogger(ProgFrontController.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        private void setChosenA(Annonce a) throws IOException {
       lbtitre.setText(a.getTitre());
       lbadress.setText(a.getDate());
       lbprice.setText(String.valueOf(a.getPrix()));
       lbddesc.setText(a.getDescription());
      
   
       String Image = "about.jpg";
 File f =  new File(Image);
       BufferedImage bi= ImageIO.read(f);
  Image image = SwingFXUtils.toFXImage(bi,null);
  
    imgProg.setImage(image);
         chosenFruitCard.setStyle("-fx-background-color: #E7C00F ;\n" +
                "    -fx-background-radius: 30;");
   
    }

   
         
          
        }
      
    

  

   
    

    


    
    
    
      
    

