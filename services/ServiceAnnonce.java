/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidevuser.services;

import edu.pidevuser.utils.DataSource;
import edu.pidevuser.entities.Annonce;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author cyrine
 */
public class ServiceAnnonce implements IServices<Annonce> {

    Connection cnx = DataSource.getInstance().getCnx();
    private List<Annonce> list=getAll();

    @Override
 public void ajouter(Annonce a) {
        try {
         
            
          
   
             String req = "INSERT INTO annonce( `titre`, `prix`, `disponible`, `description`, `type`, `date`) "
                     + "VALUES ('" + a.getTitre()+ "','" +a.getPrix() + "','" + 1 + "','" + a.getDescription() + "','" + a.getType() + "','" + a.getDate()  + "')";
           
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println(" annonce created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `annonce` WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Annonce Supprimer avec succées !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Annonce p) {
        try {
            System.out.println(p);
            String req = "UPDATE `annonce` SET `titre` = '" + p.getTitre() + "', `prix` = '" + p.getPrix()+ "', `disponible` = '" +1+ "', `description` = '" + p.getDescription()+  "'"
                    + ", `type` = '" + p.getType()+  "', `date` = '" +p.getDate()+ "' where id = " + p.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Programme updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


    @Override
    public ObservableList<Annonce> getAll() {
        ObservableList<Annonce> list = FXCollections.observableArrayList();
        try {
            String req = "Select * from annonce";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {

                Annonce a = new Annonce(rs.getInt(1),rs.getString(5), rs.getInt(6), rs.getBoolean(7), rs.getString(8), rs.getString(9), rs.getString(10));
                list.add(a);
                // System.out.println("Votre liste d'annonces : !");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(list);

        return  list;
    }

    /* Avec l’api Stream */
 /*boolean anyMatch(Predicate):Renvoyer un booléen qui précise si au moins un élément du Stream respecte le Predicate*/
    public boolean rechercherAnnonce(Annonce a) {
        return list.stream().anyMatch(e -> e.equals(a));
    }

    /* Avec l’api Stream */
    public boolean rechercherByTitle(String titre) {
        return list.stream().anyMatch(e -> e.getTitre() == titre);
    }

    /* Avec lambda expression */
    public ObservableList<Annonce> trierAnnoncesParType() {
     
   ObservableList<Annonce> aa =FXCollections.observableArrayList();
   List<Annonce> ann=list;
   ann.stream().sorted((a,b)->a.getPrix()-b.getPrix()).collect(Collectors.toList()).forEach(t->aa.add(t));
  return aa;
    }

    /* Avec l'api stream */
    public void AnnonceSansRedondance() {
        list.stream()
                .distinct()
                .forEach((e) -> System.out.println(e));
    }
    public ObservableList<Annonce> chercherAnnonce(String type){
        
        ObservableList<Annonce> a =FXCollections.observableArrayList();
        List<Annonce> ann=list;
            ann.stream().filter(e->e.getType().equalsIgnoreCase(type)).forEach(t->a.add(t));
        return a;
    }
    
   
   
   
}
