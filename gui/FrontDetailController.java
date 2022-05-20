/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidevuser.gui;

import edu.pidevuser.entities.Annonce;
import edu.pidevuser.entities.rating;
import edu.pidevuser.services.ServiceAnnonce;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.controlsfx.control.Rating;
import javax.imageio.ImageIO;



/**
 * FXML Controller class
 *
 * @author DEll
 */
public class FrontDetailController implements Initializable {

    @FXML
    private Label lbtitre;
    @FXML
    private Label lbPrix;
    @FXML
    private ImageView imgProg;
    @FXML
    private Label lbPrix1;
   
    private void click(javafx.scene.input.MouseEvent mouseEvent) {
        myListener.onClickListener(annonce);
        
     
       
    }
private Annonce annonce ;
private MyListener1 myListener;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setData(Annonce a, MyListener1 myListener) throws FileNotFoundException, IOException{
    
    this.annonce= a;
    this.myListener= myListener;
    lbtitre.setText(annonce.getTitre());
    lbPrix.setText(String.valueOf(annonce.getPrix()));
   String Image = "about.jpg";
 File f =  new File("C:\\Users\\DEll\\Pictures\\images\\"+Image);
       BufferedImage bi= ImageIO.read(f);
  Image image = SwingFXUtils.toFXImage(bi,null);
  
    imgProg.setImage(image);
    
    
    
    }

   
}
