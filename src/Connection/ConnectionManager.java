package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionManager {
  private Connection conn;
  private String url="jdbc:mysql://localhost:3306/db_ruanginap";
  private String username="root";
  private String password="";
  
  public Connection Logon(){
      
      try {
        conn = DriverManager.getConnection(url, username, password);  
      }
      catch (SQLException ex) {
          ex.printStackTrace();
      }
      return conn;   
  }
  
  public void Logoff(){
    try {
        conn.close();
      }
      catch (SQLException ex) {
          ex.printStackTrace();
      } 
  }
  
}
