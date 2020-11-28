package Adapter;

import Controller.ExecutePetugas;
import Model.Petugas;
import java.util.List;

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
