/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidevuser.services;

import edu.pidevuser.entities.rating;
import edu.pidevuser.utils.DataSource;
import edu.pidevuser.utils.DataSource1;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author DEll
 */
public class ServiceRating implements IService_1<rating> {
Connection cnx = DataSource1.getinstance().getCnx();
    @Override
    public void ajouter(rating p) {
          try {
            String req = "INSERT INTO `rating` (`prog_id`, `user_id`, `rating`) VALUES ('" + p.getProgid() + "', '" + p.getUserid()+"', '" + p.getRating()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("rating saved!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(int t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(rating p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<rating> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
