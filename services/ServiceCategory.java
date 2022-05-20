/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidevuser.services;

import edu.pidevuser.entities.Category;

import edu.pidevuser.utils.DataSource;
import edu.pidevuser.utils.DataSource1;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author abdelazizmezri
 */
public class ServiceCategory implements IService_1<Category> {

    Connection cnx = DataSource1.getinstance().getCnx();

    @Override
    public void ajouter(Category p) {
        try {
            String req = "INSERT INTO `category` (`titre`) VALUES ('" + p.getTitre() + "')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Category created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    


    @Override
    public void supprimer(int t) {
        try {
            String req = "DELETE FROM `category` WHERE id = " + t;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Category deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Category a) {
        try {
            String req =  "UPDATE `category` SET `titre` = '" + a.getTitre() + "' WHERE `category`.`id` = " + a.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Category updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ObservableList<Category> getAll() {
        ObservableList<Category> list = FXCollections.observableArrayList();
        try {
            String req = "Select * from category";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Category c;
                c = new Category(rs.getInt(1),rs.getString(3));
                list.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
     public ObservableList<String> getCat() {
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            String req = "Select titre from category";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
               
               String c = rs.getString("titre");
                list.add(c);
                System.out.println(list);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

   


}
