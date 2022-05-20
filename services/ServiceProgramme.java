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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractMap;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author abdelazizmezri
 */
public class ServiceProgramme implements IService_1<Programme> {

    Connection cnx = DataSource1.getinstance().getCnx();

    @Override
    public void ajouter(Programme p) {
        try {
            int  r,t,g,c;
             r = getIdRegion(p.getRegion());
             t = getIdTransport(p.getTransport());
             g = getIdGuide(p.getGuide());
             c = getIdCategorie(p.getCategorie());
            
            System.out.println(p);
   
             String req = "INSERT INTO programme( `category_id`, `guide_id`, `transport_id`, `titre`, `description`, `prix`, `adresse`, `region_id`,`date`,`image`) "
                     + "VALUES ('" + c + "','" + g + "','" + t + "','" + p.getTitre() + "','" + p.getDescription() + "','" + p.getPrix() + "','" + p.getAdresse() + "','" + r + "','" + p.getDate() +  "','" + p.getImage() + "')";
           
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("programme created !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    


    @Override
    public void supprimer(int id) {
        try {
            String req = "DELETE FROM `programme` WHERE id = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            //System.out.println("Programme deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Programme p) {
        try {
             int  r,t,g,c;
             r = getIdRegion(p.getRegion());
             t = getIdTransport(p.getTransport());
             g = getIdGuide(p.getGuide());
             c = getIdCategorie(p.getCategorie());
            String req = "UPDATE `programme` SET `titre` = '" + p.getTitre() + "', `description` = '" + p.getDescription()+ "', `adresse` = '" + p.getAdresse()+ "', `prix` = '" + p.getPrix()+  "'"
                    + ", `date` = '" + p.getDate()+  "', `guide_id` = '" +g+ "', `category_id` = '" + c+  "', `transport_id` = '" + t+ "', `region_id` = '" + r+  "' where id = " + p.getId();
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Programme updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

      /* @Override
 public ObservableList<Programme> getAll() {
        ObservableList<Programme> list = FXCollections.observableArrayList();
        try {
            String req = "Select * from programme";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Programme p;
             
               
                String category = getCategorie(rs.getInt("category_id"));
                String guide = getguide(rs.getInt("guide_id"));
               String region = getRegion(rs.getInt("region_id"));
               String transport = getTransport(rs.getInt("transport_id"));
               
               
                p = new Programme(rs.getInt("id"),rs.getString("titre"), rs.getString("description"),rs.getFloat("prix"),rs.getString("adresse"),category,guide,region,transport,rs.getDate("date"));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }*/
     @Override
    public ObservableList<Programme> getAll() {
        ObservableList<Programme> list = FXCollections.observableArrayList();
        try {
            String req = "Select * from programme";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                String category = getCategorie(rs.getInt("category_id"));
                String guide = getguide(rs.getInt("guide_id"));
               String region = getRegion(rs.getInt("region_id"));
               String transport = getTransport(rs.getInt("transport_id"));
               
               Programme p = new Programme(rs.getInt(1), category, guide, transport, region,rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10),  rs.getString(11),rs.getString(12));
               
               //Programme p = new Programme(rs.getInt("id"),rs.getString("titre"), rs.getString("description"),rs.getFloat("prix"),rs.getString("adresse"),category,guide,region,transport,rs.getDate("date"));

                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
       
    public Programme getprogramme(int id) {
     Programme p = new Programme();
        try {
            String req = "Select * from programme where `programme`.`id` = " +id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
              
             
               
                String category = getCategorie(rs.getInt("category_id"));
                String guide = getguide(rs.getInt("guide_id"));
               String region = getRegion(rs.getInt("region_id"));
               String transport = getRegion(rs.getInt("transport_id"));
              
               
               
               p = new Programme(rs.getInt(1), category, guide, transport, region,rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10),  rs.getString(11),rs.getString(12));
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return p;
    }
     public int getidP(String titre, String desc,int prix,String adresse){
        int id=0;
      try{
      String req = "select id FROM `programme` WHERE `description`='"+desc +"' and `titre`='"+titre +"' and `prix`='"+prix +"' and `adresse` ='"+ adresse +"'";
     
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()){
          id = rs.getInt(1);
                System.out.println(id);}
      }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       return id;
    }
    
    public String getCategorie(int id){
        String category=null;
      try{
      String req = "Select titre from category where `category`.`id` = " +id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()){
            category = rs.getString("titre");}
      }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    return category;
    }
       public String getguide(int id){
        String guide=null;
      try{
      String req = "Select nom from option_guide where `option_guide`.`id` = " +id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()){
            guide = rs.getString("nom");}
      }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    return guide;
    }
           public String getRegion(int id){
        String region=null;
      try{
      String req = "Select nom from region where `region`.`id` = " +id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()){
            region = rs.getString("nom");}
      }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
    return region;
    }
    public int getIdRegion(String s){
        int region=0;
      try{
      String req = "Select id from region where `region`.`nom` =  '" + s + "'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()){
            region = rs.getInt("id");}
      }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
    return region;
    }
        public String getTransport(int s){
        String transport=null;
      try{
      String req = "Select matricule from option_transport where `option_transport`.`id` = " +s;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()){
            transport = rs.getString("matricule");}
      }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
    return transport;
    }
        
            public int getIdTransport(String s){
        int t=0;
      try{
      String req = "Select id from option_transport where `option_transport`.`matricule` =  '" + s + "'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()){
            t = rs.getInt("id");}
      }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
    return t;
    }
               
            public int getIdGuide(String s){
        int g=0;
      try{
      String req = "Select id from option_guide where `option_guide`.`nom` =  '" + s + "'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()){
            g = rs.getInt("id");}
      }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
    return g;
    }
        
            public int getIdCategorie(String s){
        int region=0;
      try{
      String req = "Select id from category where `category`.`titre` =  '" + s + "'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()){
            region = rs.getInt("id");}
      }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
    return region;
    }
            List<Programme> progrmmes = getAll();
        
   public ObservableList<Programme> chercherProgramme(String titre){
    
     ObservableList<Programme> p= FXCollections.observableArrayList();
             List<Programme> prog = progrmmes;
            prog.stream().filter(e->e.getTitre().equalsIgnoreCase(titre)).forEach(t->p.add(t));
              
             
            return p;

    
}

  
   public Map<String, List<Programme>> Programmes_category(){
    Map<String, List<Programme>> map = progrmmes.stream().collect(Collectors.groupingBy(x->x.getCategorie()));
    System.out.println(map.keySet());
     return map;
     
   }
     public Map<String, List<Programme>> Programmes_region(){
    Map<String, List<Programme>> map = progrmmes.stream().collect(Collectors.groupingBy(x->x.getRegion()));
     return map;
   }
      public  List<Programme> Programmes_tri_PrixAsc(){
   
       List<Programme> sorted = progrmmes.stream().sorted((a,b)->a.getPrix()-b.getPrix()).collect(Collectors.toList());
        
      return sorted;
      }
        public List<Programme> Programmes_tri_PrixDesc(){
   
      List<Programme> sorted = progrmmes.stream().sorted((a,b)->b.getPrix()-a.getPrix()).collect(Collectors.toList());
        
      return sorted;
      }
   
      public ObservableList<Programme> getNbrProgrammeParguide() {
          ObservableList<Programme> list = FXCollections.observableArrayList();
        try {
            String req = "select * from programme where programme.guide_id IS NOT null";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                 String category = getCategorie(rs.getInt("category_id"));
                String guide = getguide(rs.getInt("guide_id"));
               String region = getRegion(rs.getInt("region_id"));
               String transport = getRegion(rs.getInt("transport_id"));

               
             Programme p = new Programme(rs.getInt(1), category, guide, transport, region,rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10),  rs.getString(11),rs.getString(12));

               list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

  
   public Map<String,Integer> getNbrProgrammeParDate() {
          Map<String,Integer> map = new HashMap<String, Integer>() ;
        try {
            String req = "select date as date,COUNT(*) as count from programme group By date";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
               
               String d = rs.getString("date");
               int c = rs.getInt("count");
             
               
                map.put(d, c);
               
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return map;
    }
    public Map<String,Integer> getNbrProgrammeParCategorie() {
          Map<String,Integer> map = new HashMap<String, Integer>() ;
        try {
            String req = "select category_id as category,COUNT(*) as count from programme group By category_id";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
               
               String d = getCategorie( rs.getInt("category"));
               int c = rs.getInt("count");
             
               
                map.put(d, c);
               
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return map;
    }
  
       public Map<String,Integer> getNbrProgrammeParRegion() {
          Map<String,Integer> map = new HashMap<String, Integer>() ;
        try {
            String req = "select region_id as region,COUNT(*) as count from programme group By region_id";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
               
                String d = getRegion( rs.getInt("region"));
               int c = rs.getInt("count");
             
               
                map.put(d, c);
               
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return map;
    }
        public ObservableList<Programme> getNbrProgrammeParTransport() {
          ObservableList<Programme> list = FXCollections.observableArrayList();
        try {
            String req = "select * from programme where programme.transport_id IS NOT null";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                 String category = getCategorie(rs.getInt("category_id"));
                String guide = getguide(rs.getInt("guide_id"));
               String region = getRegion(rs.getInt("region_id"));
               String transport = getRegion(rs.getInt("transport_id"));

               
             Programme p = new Programme(rs.getInt(1), category, guide, transport, region,rs.getString(7), rs.getString(8), rs.getInt(9), rs.getString(10),  rs.getString(11),rs.getString(12));

               list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
   
        
}


