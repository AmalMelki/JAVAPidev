/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidevuser.services;

import edu.pidevuser.entities.Category;

import edu.pidevuser.entities.OptionTransport;
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
public class ServiceTransport implements IService_1<OptionTransport> {

    Connection cnx = DataSource1.getinstance().getCnx();

    @Override
    public void ajouter(OptionTransport g) {
        try {
            String req = "INSERT INTO `option_transport` (`capacite`, `matricule`) VALUES ('" + g.getCapacite() + "', '" + g.getMatricule()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Option Transport created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    


    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `option_transport` WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Transport deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(OptionTransport t) {
        try {
            String req = "UPDATE `option_transport` SET `matricule` = '" + t.getMatricule() + "', `capacite` = '" + t.getCapacite() + "' WHERE `option_transport`.`id` = " + t.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Transport updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
     public ObservableList<OptionTransport> getAll() {
        ObservableList<OptionTransport> list = FXCollections.observableArrayList();
        try {
            String req = "Select * from option_transport";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                OptionTransport g;
                g = new OptionTransport(rs.getInt(1),rs.getString(3),rs.getInt(4));
                list.add(g);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
       public ObservableList<String> getTransport() {
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            String req = "Select matricule from option_transport";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
               
               String c = rs.getString("matricule");
                list.add(c);
                System.out.println(list);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

}
