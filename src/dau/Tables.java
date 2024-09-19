/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dau;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class Tables {

    public static void main(String[] args) {

        Statement st = null;
        Connection con = null;

        try {
            con = ConnectionProvider.getcon();
            st = con.createStatement();
            //st.executeUpdate("create table application_user(appuser int AUTO_INCREMENT primary key, userRole varchar(50),name varchar(200),mobileNumber varchar(11),email varchar(200),password varchar(50),address varchar(200), status varchar(50))");
           // st.executeUpdate("insert into application_user(userRole,name,mobileNumber,email,password,address,status) values('super admin','super admin','907856784','superadmin@gmail.com','admin','india','active')");
          // st.executeUpdate("create table category(category int AUTO_INCREMENT primary key , name varchar(200))");
          //st.executeUpdate("create table product(product_Pk int AUTO_INCREMENT primary key , name varchar(200) , quantity int , price int , discription varchar(500), category_fk int)");
       //   st.executeUpdate("create table customer(customer_Pk int AUTO_INCREMENT primary key , name varchar(200) , mobile_Number varchar(11) , Email varchar(200))");
           st.executeUpdate("create table order_details(order_Pk int AUTO_INCREMENT primary key , order_id varchar(200) , orderDate varchar(11) , totalPaid int )");  
       JOptionPane.showMessageDialog(null, " table create succesfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            if (con != null) {
                try {

                    con.close();
                    st.close();

                } catch (Exception e) {
                }
            }
        }

    }
}
