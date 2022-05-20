/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidevuser.services;

import edu.pidevuser.utils.DataSource;
import edu.pidevuser.entities.Promotion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author cyrine
 */
public class ServicePromotion implements IServices<Promotion>{
   Connection cnx = DataSource.getInstance().getCnx();
      private List<Promotion> list;
                       /* AJOUT PROMOTION*/   
    @Override
   public void ajouter(Promotion g) {
        try {
            String req = "INSERT INTO `promotion` (`date_debut`, `date_fin`, `taux`) VALUES ('" + g.getDate_debut() + "', '" + g.getDate_fin()+"', '" + g.getTaux()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println(" created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
                        /* Supprimer promotion */
    @Override
    public void supprimer(int id) {
            try {
            String req = "DELETE FROM `promotion` WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Promotion Supprimer avec succées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
                          /* MODIFIER PROMOTION*/
    @Override
    public void modifier(Promotion a) {
         try {
            String req = "UPDATE `promotion` SET `date_debut` = '" + a.getDate_debut()+ "', `taux` = '" + a.getTaux() + "', `date_fin` = '" + a.getDate_fin()+"' WHERE `promotion`.`id` = " + a.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("L'annonce a été mis a jours !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ObservableList<Promotion> getAll() {
        ObservableList<Promotion> list = FXCollections.observableArrayList();
        try {
            String req = "Select * from promotion";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
             Promotion p = new Promotion(rs.getInt(1),rs.getInt(5),rs.getString(3),rs.getString(4));
            list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(list);
        return list;
    }
    
    
    /* Avec l’api Stream */
    public boolean rechercherByDate(String date_debut) {
        return list.stream().anyMatch(e->e.getDate_debut()==date_debut);
    }     
    
    
}
