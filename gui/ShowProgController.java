/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidevuser.gui;

import edu.pidevuser.entities.Programme;
import edu.pidevuser.services.ServiceCategory;
import edu.pidevuser.services.ServiceGuide;
import edu.pidevuser.services.ServiceProgramme;
import edu.pidevuser.services.ServiceRegion;
import edu.pidevuser.services.ServiceTransport;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author DEll
 */
public class ShowProgController implements Initializable {

    @FXML
    private TextField tfAdresse;
    @FXML
    private TextField tfTitre;
    @FXML
    private TextField tfDescription;
    int id;
    private Programme p;
    @FXML
    private DatePicker Dpiker;
    @FXML
    private ComboBox<String> ComR;
    @FXML
    private TextField tfPrix;
    @FXML
    private ComboBox<String> ComC;
    @FXML
    private ComboBox<String> comG;
    @FXML
    private ComboBox<String> ComT;
    @FXML
    private TextField tafile;
    @FXML
    private ImageView ivFile;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            ServiceRegion s = new ServiceRegion();
      ComR.setItems(s.getRegion());
         ServiceGuide g = new ServiceGuide();
      comG.setItems(g.getGuide());
       ServiceCategory c = new ServiceCategory();
      ComC.setItems(c.getCat());
        ServiceTransport T = new ServiceTransport();
      ComT.setItems(T.getTransport());
       
    }    

    

    @FXML
    private void update(ActionEvent event) throws IOException {
        ServiceProgramme s = new ServiceProgramme();
        p.setTitre(tfTitre.getText());
        p.setDescription(tfDescription.getText());
        p.setAdresse(tfAdresse.getText());
        p.setPrix(Integer.parseInt(tfPrix.getText()));
        p.setCategorie(String.valueOf( ComC.getValue()));
        p.setRegion(String.valueOf( ComR.getValue()));
        p.setGuide(String.valueOf( comG.getValue()));
        p.setTransport(String.valueOf( ComT.getValue()));
        p.setDate(String.valueOf(Dpiker.getValue()));
        System.out.println(p);
       
        s.modifier(p);
        System.out.println(p);
         FXMLLoader loader = new FXMLLoader(getClass().getResource("ProgIndex.fxml"));
        Parent root = loader.load();
        tfAdresse.getScene().setRoot(root);
       ProgIndexController apc = loader.getController();
    }

    public void setTfAdresse(TextField tfAdresse) {
        this.tfAdresse = tfAdresse;
    }

    public void setTfTitre(TextField tfTitre) {
        this.tfTitre = tfTitre;
    }

    public void setTfDescription(TextField tfDescription) {
        this.tfDescription = tfDescription;
    }

    public TextField getTfAdresse() {
        return tfAdresse;
    }

    public TextField getTfTitre() {
        return tfTitre;
    }

    public TextField getTfDescription() {
        return tfDescription;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Programme getP() {
        return p;
    }

    public void setP(Programme p) {
        this.p = p;
    }

    public DatePicker getDpiker() {
        return Dpiker;
    }

    public ComboBox<String> getComR() {
        return ComR;
    }

    public TextField getTfPrix() {
        return tfPrix;
    }

    public ComboBox<String> getComC() {
        return ComC;
    }

    public ComboBox<String> getComG() {
        return comG;
    }

     public ComboBox<String> getComT() {
        return ComT;
    }

    public void setDpiker(DatePicker Dpiker) {
        this.Dpiker = Dpiker;
    }

    public void setComR(ComboBox<String> ComR) {
        this.ComR = (ComboBox<String>) ComR;
    }

    public void setTfPrix(TextField tfPrix) {
        this.tfPrix = tfPrix;
    }

    public void setComC(ComboBox<String> ComC) {
        this.ComC = (ComboBox<String>) ComC;
    }

    public void setComG(ComboBox<String> comG) {
        this.comG = (ComboBox<String>) comG;
    }

     public void setComT(ComboBox<String> comG) {
        this.comG = (ComboBox<String>) comG;
    }

    @FXML
    private void liste(ActionEvent event) throws IOException {
             ServiceProgramme s = new ServiceProgramme();
        //s.supprimer(tfTitre.getText());
         FXMLLoader loader = new FXMLLoader(getClass().getResource("ProgIndex.fxml"));
        Parent root = loader.load();
        tfAdresse.getScene().setRoot(root);
    }

    @FXML
    private void HandleOpenImgFile(ActionEvent event) {
    }

    
    
}
