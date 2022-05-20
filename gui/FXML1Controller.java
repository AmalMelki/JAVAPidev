/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidevuser.gui;

import edu.pidevuser.entities.Programme;
import edu.pidevuser.services.ServiceProgramme;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author DEll
 */
public class FXML1Controller implements Initializable {

    @FXML
    private Label lbtitre;
    @FXML
    private Label lbdescription;
    @FXML
    private Label lbadresse;
    @FXML
    private Label lbregion;
    @FXML
    private Label lbdate;
    @FXML
    private Label lbprix;
    @FXML
    private Label lbguide;
    @FXML
    private Label lbcategorie;
    @FXML
    private Label lbtransport;
    @FXML
    private ImageView imgProg;
    private Programme programme ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
  
    public void setData(Programme programme) throws FileNotFoundException, IOException{
    
    this.programme= programme;
        System.out.println(programme);
    lbtitre.setText(programme.getTitre());
    lbdescription.setText(programme.getDescription());
    lbcategorie.setText(programme.getCategorie());
    lbdate.setText(programme.getDate());
    lbguide.setText(programme.getGuide());
    lbtransport.setText(programme.getTransport());
    lbregion.setText(programme.getRegion());
 
    lbadresse.setText(programme.getAdresse());
    lbprix.setText(String.valueOf(programme.getPrix()));
    
   String Image = programme.getImage();
 File f =  new File("C:\\Users\\DEll\\Pictures\\images\\"+Image);
       BufferedImage bi= ImageIO.read(f);
  Image image = SwingFXUtils.toFXImage(bi,null);
  
    imgProg.setImage(image);
    
    
    
    }
    @FXML
    private void Afficher(ActionEvent event) throws IOException {
        // Programme p = table.getSelectionModel().getSelectedItem();
           FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowProg.fxml"));
        Parent root = loader.load();
       lbadresse.getScene().setRoot(root);
        
       ShowProgController apc = loader.getController();
       apc.getTfTitre().setText(lbtitre.getText());
      apc.getTfDescription().setText(lbdescription.getText());
       apc.getTfAdresse().setText(lbadresse.getText());
        ServiceProgramme s = new ServiceProgramme();
       int id =s.getidP(lbtitre.getText(), lbdescription.getText(), Integer.parseInt(lbprix.getText()), lbadresse.getText());
       System.out.println(id);
       apc.setId(id);
       apc.setP(s.getprogramme(id));
       apc.getTfPrix().setText(lbprix.getText());
       apc.getComG().setValue(lbguide.getText());
       apc.getComR().setValue(lbregion.getText());
       apc.getComT().setValue(lbtransport.getText());
       apc.getComC().setValue(lbcategorie.getText());
       apc.getDpiker().setValue(LocalDate.parse(lbdate.getText()));
       
       
    }

    @FXML
    private void supprimer(ActionEvent event) throws IOException {
        
        ServiceProgramme s= new ServiceProgramme();
          int id =s.getidP(lbtitre.getText(), lbdescription.getText(), Integer.parseInt(lbprix.getText()), lbadresse.getText());
       
        
         FXMLLoader loader = new FXMLLoader(getClass().getResource("ProgIndex.fxml"));
         ProgIndexController apc = loader.getController();
          s.supprimer(id);
        Parent root = loader.load();
       lbadresse.getScene().setRoot(root);
    }

 
    
}
