/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidevuser.gui;

import edu.pidevuser.entities.Programme;
import edu.pidevuser.entities.rating;
import edu.pidevuser.services.ServiceProgramme;
import edu.pidevuser.services.ServiceRating;
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
public class ItemsController implements Initializable {

    @FXML
    private Label lbtitre;
    @FXML
    private Label lbPrix;
    @FXML
    private ImageView imgProg;
    @FXML
    private Label lbPrix1;
    @FXML
    private Rating Rating;
    @FXML
    private void click(javafx.scene.input.MouseEvent mouseEvent) {
        myListener.onClickListener(programme);
        
     
       
    }
private Programme programme;
private MyListener myListener;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setData(Programme programme, MyListener myListener) throws FileNotFoundException, IOException{
    
    this.programme= programme;
    this.myListener= myListener;
    lbtitre.setText(programme.getTitre());
    lbPrix.setText(String.valueOf(programme.getPrix()));
   String Image = programme.getImage();
 File f =  new File("C:\\Users\\DEll\\Pictures\\images\\"+Image);
       BufferedImage bi= ImageIO.read(f);
  Image image = SwingFXUtils.toFXImage(bi,null);
  
    imgProg.setImage(image);
    
    
    
    }

    @FXML
    private Alert HandleButtonAction(ActionEvent event) {
        ServiceRating sr = new ServiceRating();
        ServiceProgramme sp = new ServiceProgramme();
       
        rating r = new rating(1, lbtitre.getText(),Rating.getRating());
        sr.ajouter(r);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Remerciment");
        alert.setHeaderText("Note "+Rating.getRating()+" Attribuée au programme " +lbtitre.getText());
        alert.setContentText(" Votre Evatiation Compte !");
     
        alert.showAndWait();
       
        return alert;
    }
}
