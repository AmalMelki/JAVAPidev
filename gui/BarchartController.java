/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pidevuser.gui;

import edu.pidevuser.services.ServiceProgramme;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author DEll
 */
public class BarchartController implements Initializable {

    @FXML
    private BarChart<String, Integer> barchart;
    @FXML
    private NumberAxis y;
    @FXML
    private CategoryAxis x;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
      
       XYChart.Series<String,Integer> dataSeries1 = new XYChart.Series();
      
          ServiceProgramme sp = new ServiceProgramme();
        Map<String,Integer> map = new HashMap<>();
        map=sp.getNbrProgrammeParCategorie();
        List<String> keys = new ArrayList<>();
        List<Integer> Values = new ArrayList<>();
    
         for(Integer st:map.values()){
       Values.add(st);
        
     }
         System.out.println(Values); 
                for(String et:map.keySet()){
       keys.add(et);
       
     }
                 System.out.println(keys);
        
        
        for(int i=0; i< map.size();i++){
            
        dataSeries1.getData().add(new XYChart.Data<>(keys.get(i),Values.get(i)));
          
           
        }
         System.out.println(dataSeries1);
         barchart.getData().add(dataSeries1);
         
        
             
        
    }    
    
}
