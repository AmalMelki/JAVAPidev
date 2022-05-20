/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidevuser.entities;

import java.util.Date;



/**
 *
 * @author bhk
 */
public class Programme {
    private int id;
    private int prix;
    private String titre,description,adresse;
    private String categorie;
    private String guide;
    private String transport;
    private String region;
    private String date;
    private String image;
    private int Rating;
  

    public Programme() {
    }

    public Programme(int id, int prix, String titre, String description, String adresse, String categorie,String guide, String transport, String region, String images) {
        this.id = id;
        this.prix = prix;
        this.titre = titre;
        this.description = description;
        this.adresse = adresse;
        this.categorie = categorie;
        this.guide = guide;
        this.transport = transport;
        this.region = region;
        this.image = image;
    }

        public Programme( String titre, String description, String adresse,String categorie, String guide, String transport, String region, String images) {
       
        this.titre = titre;
        this.description = description;
        this.adresse = adresse;
         this.categorie = categorie;
        this.guide = guide;
        this.transport = transport;
        this.region = region;
        this.image = image;
    }
       public Programme(int id,String titre, String description,int prix,String adresse,String category,String guide,String region, String transport, String date) {
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.adresse = adresse;
        this.categorie=  category;
        this.guide=guide;
         this.region = region;
          this.transport = transport;
          this.date = date;
    }

    public Programme(String titre, String description,int prix,String adresse) {
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.adresse = adresse;
    }

    public Programme(int id, String titre, String description) {
        this.id = id;
        this.titre = titre;
        this.description = description;
    }

    public Programme(int id, String category, String guide, String transport,String region, String titre, String description, int prix, String date, String adresse,String image) {
        this.id=id;   
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.adresse = adresse;
        this.categorie=  category;
        this.guide=guide;
         this.region = region;
          this.transport = transport;
          this.date = date;
          this.image=image;
      
    }

    public Programme(String titre, String desc, int prix, String adresse, String region,String Guide,String transport,String category,String date, String image) {
         this.titre = titre;
        this.description = desc;
        this.prix = prix;
        this.adresse = adresse;
         this.region = region;
         this.guide=Guide;
         this.categorie=category;
         this.transport=transport;
         this.date=date;
         this.image=image;
        
    }

  
    
       


    public int getId() {
        return id;
    }

    public int getPrix() {
        return prix;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getGuide() {
        return guide;
    }

    public String getTransport() {
        return transport;
    }

    public String getRegion() {
        return region;
    }

    public String getDate() {
        return date;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Programme{" + "id=" + id + ", prix=" + prix + ", titre=" + titre + ", description=" + description + ", adresse=" + adresse + ", categorie=" + categorie + ", guide=" + guide + ", transport=" + transport + ", region=" + region + ", date=" + date + ", image=" + image + '}';
    }

 

 

   

  

    

   

   

  
   

    
  
    
    
}
