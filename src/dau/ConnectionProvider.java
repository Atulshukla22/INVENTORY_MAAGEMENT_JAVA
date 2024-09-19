/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dau;
import java.sql.Connection;
import java.sql.DriverManager;



/**
 *
 * @author dell
 */
public class ConnectionProvider {
    
    public static Connection getcon(){
        try{
          Class.forName("com.mysql.cj.jdbc.Driver");  
        
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory?useSSL=false","root","root");
              return con;
        }
        catch(Exception e){
      System.out.println(e);
      return null;
    }
    }
    
    
}
