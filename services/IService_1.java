/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidevuser.services;

import java.util.List;

/**
 *
 * @author abdelazizmezri
 */
public interface IService_1 <T>{
    public void ajouter(T p);
    public void supprimer(int t);
   
    public void modifier(T p);
    public List<T> getAll();
    
}
