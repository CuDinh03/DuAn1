/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giao_dien.model;

import com.sun.jdi.connect.spi.Connection;
import java.util.List;
import java.util.ArrayList;


import java.sql.*;
/**
 *
 * @author acer
 */
public class TaiKhoanDAO {
    public int add(TaiKhoan ee){
       Connection conn=null;
        PreparedStatement sttm=null; 
        try {
            conn=Database
        } catch (Exception e) {
            System.out.println("Error:"+e.toString());
        }finally{
            
        }
    }

    
}
