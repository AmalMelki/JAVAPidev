/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidevuser.gui;

import edu.pidevuser.entities.Programme;
import edu.pidevuser.services.ServiceProgramme;
import edu.pidevuser.gui.MyListener;
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
public class ProgFrontController implements Initializable {
    

    @FXML
    private Label lbtitre;
    @FXML
    private ImageView imgProg;
    private Label lbAdresse;
    @FXML
    private GridPane grid;
     private MyListener myListener;
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
    @FXML
    private ComboBox<String> ComC;
    @FXML
    private ComboBox<String> ComP;
    
    @FXML
    private Button btguide;
    @FXML
    private TextField tfChercher;
    
 ServiceProgramme sp = new ServiceProgramme();
       ObservableList<Programme> all = sp.getAll();
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     
   
        System.out.println(all);
         
         ServiceCategory c = new ServiceCategory();
       ComC.setItems(c.getCat());
        ObservableList<String> Prix=FXCollections.observableArrayList();
        Prix.add("Prix Descendant");
        Prix.add("Prix Ascendant");
       ComP.setItems(Prix);
        
   if (all.size() > 0) {
            try {
                setChosenProg(all.get(0));
            } catch (IOException ex) {
                Logger.getLogger(ProgFrontController.class.getName()).log(Level.SEVERE, null, ex);
            }
            myListener = new MyListener() {
                @Override
                public void onClickListener(Programme prog) {
                    try {
                        setChosenProg(prog);
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
        
                FXMLLoader loader = new FXMLLoader(getClass().getResource("items.fxml"));
                 AnchorPane anchorPane = loader.load();
                 
                ItemsController itemsController = loader.getController();
               System.out.println(all.get(i));
                itemsController.setData(all.get(i), myListener);
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
        private void setChosenProg(Programme programme) throws IOException {
       lbtitre.setText(programme.getTitre());
       lbadress.setText(programme.getAdresse());
       lbprice.setText(String.valueOf(programme.getPrix()));
       lbddesc.setText(programme.getDescription());
       lbdate.setText(programme.getDate());
   
       String Image = programme.getImage();
 File f =  new File("C:\\Users\\DEll\\Pictures\\images\\"+Image);
       BufferedImage bi= ImageIO.read(f);
  Image image = SwingFXUtils.toFXImage(bi,null);
  
    imgProg.setImage(image);
         chosenFruitCard.setStyle("-fx-background-color: #E7C00F ;\n" +
                "    -fx-background-radius: 30;");
   
    }

    @FXML
    private void ProgGuide(ActionEvent event) throws IOException {
         System.out.println(all);
         
      
        ServiceProgramme p=new ServiceProgramme();
        ObservableList<Programme> list= p.getNbrProgrammeParguide();
   if (list.size() > 0) {
            setChosenProg(all.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Programme prog) {
                    try {
                        setChosenProg(prog);
                    } catch (IOException ex) {
                        Logger.getLogger(ProgFrontController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
        }  
        
        int column=0;
        int row=1;
        int i=0;
        
            try {
        for(i=0;i<list.size();i++){
        
                FXMLLoader loader = new FXMLLoader(getClass().getResource("items.fxml"));
                 AnchorPane anchorPane = loader.load();
                 
                ItemsController itemsController = loader.getController();
               
                itemsController.setData(list.get(i), myListener);
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
            for(int j=i;j<all.size();j++){
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
                 AnchorPane anchorPane = loader.load();
                 
               
              
             
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
       
          
        }
      
   
       
    
       
       
    

    @FXML
    private void Transport(ActionEvent event) throws IOException {
       System.out.println(all);
         
      
        ServiceProgramme p=new ServiceProgramme();
        ObservableList<Programme> list= p.getNbrProgrammeParTransport();
   if (list.size() > 0) {
            setChosenProg(all.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Programme prog) {
                    try {
                        setChosenProg(prog);
                    } catch (IOException ex) {
                        Logger.getLogger(ProgFrontController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
        }  
        
        int column=0;
        int row=1;
        int i=0;
        
            try {
        for(i=0;i<list.size();i++){
        
                FXMLLoader loader = new FXMLLoader(getClass().getResource("items.fxml"));
                 AnchorPane anchorPane = loader.load();
                 
                ItemsController itemsController = loader.getController();
                System.out.println(all.get(i));
                itemsController.setData(list.get(i), myListener);
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
            for(int j=i;j<all.size();j++){
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
                 AnchorPane anchorPane = loader.load();
                 
               
              
             
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
       
          
        }
      
    

  

    @FXML
    private void chercher(ActionEvent event) throws IOException {
        System.out.println(all);
         
      
        ServiceProgramme p=new ServiceProgramme();
        ObservableList<Programme> list= p.chercherProgramme(tfChercher.getText());
   if (list.size() > 0) {
            setChosenProg(all.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Programme prog) {
                    try {
                        setChosenProg(prog);
                    } catch (IOException ex) {
                        Logger.getLogger(ProgFrontController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
        }  
        
        int column=0;
        int row=1;
        int i=0;
        
            try {
        for(i=0;i<list.size();i++){
        
                FXMLLoader loader = new FXMLLoader(getClass().getResource("items.fxml"));
                 AnchorPane anchorPane = loader.load();
                 
                ItemsController itemsController = loader.getController();
                System.out.println(all.get(i));
                itemsController.setData(list.get(i), myListener);
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
            for(int j=i;j<all.size();j++){
                 FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
                 AnchorPane anchorPane = loader.load();
                 
               
              
             
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
       
          
        }

    @FXML
    private void FiltrePrix(ActionEvent event) throws IOException {
        if (ComP.getValue()=="Prix Descendant") {
             ServiceProgramme p=new ServiceProgramme();
        List<Programme> list= p.Programmes_tri_PrixDesc();
   if (list.size() > 0) {
            setChosenProg(all.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Programme prog) {
                    try {
                        setChosenProg(prog);
                    } catch (IOException ex) {
                        Logger.getLogger(ProgFrontController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
        }  
        
        int column=0;
        int row=1;
        int i=0;
        
            try {
        for(i=0;i<list.size();i++){
        
                FXMLLoader loader = new FXMLLoader(getClass().getResource("items.fxml"));
                 AnchorPane anchorPane = loader.load();
                 
                ItemsController itemsController = loader.getController();
                System.out.println(all.get(i));
                itemsController.setData(list.get(i), myListener);
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
         

            
        } else if(ComP.getValue()=="Prix Ascendant") {
            
             ServiceProgramme p=new ServiceProgramme();
        List<Programme> list= p.Programmes_tri_PrixAsc();
   if (list.size() > 0) {
            setChosenProg(all.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Programme prog) {
                    try {
                        setChosenProg(prog);
                    } catch (IOException ex) {
                        Logger.getLogger(ProgFrontController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
        }  
        
        int column=0;
        int row=1;
        int i=0;
        
            try {
        for(i=0;i<list.size();i++){
        
                FXMLLoader loader = new FXMLLoader(getClass().getResource("items.fxml"));
                 AnchorPane anchorPane = loader.load();
                 
                ItemsController itemsController = loader.getController();
                System.out.println(all.get(i));
                itemsController.setData(list.get(i), myListener);
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
    }

    @FXML
    private void FiltreCategorie(ActionEvent event) {
        Map<String,List<Programme>> map = sp.Programmes_category();
         List<String> keys = new ArrayList<>();
       for(String et:map.keySet()){
       keys.add(et);
       
     }
        for(int i=0;i<keys.size();i++){
        if (keys.get(i)==ComC.getValue()){
            
        
        
        
        }
        
        }
    }

    
}

    
    
    
      
    

