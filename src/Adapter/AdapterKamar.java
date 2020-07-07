/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adapter;

import Controller.ExecuteKamar;
import Model.Kamar;
import java.util.List;

/**
 *
 * @author Nada
 */
public class AdapterKamar {
    public Object[][] getAllPts(){
      ExecuteKamar em = new ExecuteKamar();
      List<Kamar> lstkmr = em.ListKmr();
      Object[][] datakmr = new Object[lstkmr.size()][7];
      
      int mysize=0;
      for(Kamar pts:lstkmr){
          datakmr[mysize][0]=pts.getKamar();
          datakmr[mysize][1]=pts.getPasien();
          datakmr[mysize][2]=pts.getPenyakit();
          datakmr[mysize][3]=pts.getDokter();
          datakmr[mysize][4]=pts.getPetugas();
          datakmr[mysize][5]=pts.getMasuk();
          datakmr[mysize][6]=pts.getKeluar();
          mysize++;
      }
      return datakmr;
    }  
}
