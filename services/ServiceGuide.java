/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidevuser.services;

import edu.pidevuser.entities.Category;

import edu.pidevuser.entities.OptionGuide;
import edu.pidevuser.entities.Programme;
import edu.pidevuser.entities.Region;
import edu.pidevuser.utils.DataSource;
import edu.pidevuser.utils.DataSource1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author abdelazizmezri
 */
public class ServiceGuide implements IService_1<OptionGuide> {

    Connection cnx = DataSource1.getinstance().getCnx();

    @Override
    public void ajouter(OptionGuide g) {
        try {
            String req = "INSERT INTO `option_guide` (`nom`, `prenom`, `tel`) VALUES ('" + g.getNom() + "', '" + g.getPrenom()+"', '" + g.getTel()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Option guide created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    


    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `option_guide` WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("guide deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier( OptionGuide g) {
        try {
            String req = "UPDATE `option_guide` SET `nom` = '" + g.getNom() + "', `prenom` = '" +g.getPrenom()+"', `tel` = '" + g.getTel()+"' WHERE `option_guide`.`id` = " + g.getId() ;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("guide updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
      public ObservableList<OptionGuide> getAll() {
        ObservableList<OptionGuide> list = FXCollections.observableArrayList();
        try {
            String req = "Select * from option_guide";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                OptionGuide g;
                g = new OptionGuide(rs.getInt(1),rs.getString(3),rs.getString(4),rs.getInt(5));
                list.add(g);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
       public ObservableList<String> getGuide() {
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            String req = "Select nom from option_guide";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
               
               String c = rs.getString("nom");
                list.add(c);
                System.out.println(list);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }


}
