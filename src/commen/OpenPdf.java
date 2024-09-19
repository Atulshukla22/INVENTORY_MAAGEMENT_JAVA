/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package commen;

import dau.InventoryUtils;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class OpenPdf {
     public static void OpenById(String id){
    try{
     if((new File(InventoryUtils.BillPath + id+ ".pdf")).exists()){
         Process p = Runtime
                 .getRuntime()
                 .exec("rundll32 url.dll,FileProtocolHandler "+InventoryUtils.BillPath+""+id+".pdf");
         
     }
     else{
         JOptionPane.showMessageDialog(null, "File Not Exist");
     }
    
    }
    catch(Exception e){}
    
}
    
}
