/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapter;

import Controller.ExecutePetugas;
import Model.Petugas;
import java.util.List;

/**
 *
 * @author Nada
 */
public class AdapterPetugas {
    public Object[][] getAllPts(){
      ExecutePetugas em = new ExecutePetugas();
      List<Petugas> lstpts = em.ListPts();
      Object[][] datapts = new Object[lstpts.size()][2];
      
      int mysize=0;
      for(Petugas pts:lstpts){
          datapts[mysize][0]=pts.getID();
          datapts[mysize][1]=pts.getNama();
          mysize++;
      }
      return datapts;
    }  
}
