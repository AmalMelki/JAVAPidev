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
public class rating {
    private int id,userid;
    private String progid;
            private Double rating;

    public rating(int id, int userid, String progid, Double rating) {
        this.id = id;
        this.userid = userid;
        this.progid = progid;
        this.rating = rating;
    }

    public rating(int userid, String progid, double rating) {
        this.userid = userid;
        this.progid = progid;
        this.rating = rating;
    }

    public rating() {
    }
    

    public int getId() {
        return id;
    }

    public int getUserid() {
        return userid;
    }

    public String getProgid() {
        return progid;
    }

    public double getRating() {
        return rating;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setProgid(String progid) {
        this.progid = progid;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Rating{" + "id=" + id + ", userid=" + userid + ", progid=" + progid + ", rating=" + rating + '}';
    }
    
    
}
