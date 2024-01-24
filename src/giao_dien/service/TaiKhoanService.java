/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giao_dien.service;

import com.sun.jdi.connect.spi.Connection;
import giao_dien.DBConnect.DBConnect;
import giao_dien.Repository.TaiKhoanRepository;
import giao_dien.model.TaiKhoan;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author acer
 */
public class TaiKhoanService implements IService<TaiKhoan>{
    TaiKhoanRepository taiKhoanRepository=new TaiKhoanRepository();
    private ArrayList<TaiKhoan>list=new ArrayList<>();
    private DBConnect dBConnect=new DBConnect();
    public ArrayList<TaiKhoan>getlist(){
        return taiKhoanRepository.getTaiKhoan();
    }

    @Override
    public void add(TaiKhoan t) {
        taiKhoanRepository.them(t);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(TaiKhoan t, String id) {
        taiKhoanRepository.sua(t, id);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        taiKhoanRepository.delete(id);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TaiKhoan findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}
