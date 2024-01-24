/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giao_dien.service;

import giao_dien.DBConnect.DBConnect;
import giao_dien.Repository.NhanVienRepository;
import giao_dien.model.Nhan_vien;
import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author acer
 */
public class NhanVienService implements IService<Nhan_vien>{
    NhanVienRepository nhanVienRepository=new NhanVienRepository();
    private ArrayList<Nhan_vien>list=new ArrayList<>();
    public ArrayList<Nhan_vien>getlist(){
        return nhanVienRepository.getNhanVien();
    }

    @Override
    public void add(Nhan_vien t) {
        nhanVienRepository.them(t);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Nhan_vien t, String id) {
        nhanVienRepository.sua(t, id);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        nhanVienRepository.delete(id);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Nhan_vien findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
