/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidevuser.services;

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
 * @author DEll
 */
public class ServiceRegion {
      Connection cnx = DataSource1.getinstance().getCnx();
     public ObservableList<String> getRegion() {
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            String req = "Select nom from region";
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
