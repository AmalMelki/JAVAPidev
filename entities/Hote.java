/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidevuser.entities;

/**
 *
 * @author DEll
 */
public class Hote extends User {
     public Hote(int id,String username, String email, int numTel, String firstName, String lastName, String password) {
        super(id, username, email, numTel, firstName, lastName, password);
    }

    public Hote() {
    }

    public Hote(String username, String email, int numTel, String firstName, String lastName, String password) {
        super(username, email, numTel, firstName, lastName, password);
    }

    public Hote(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return "Admin" + super.toString(); 
    }

    
}
