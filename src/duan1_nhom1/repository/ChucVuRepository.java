/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.repository;

import duan1_nhom1.model.ChucVu;
import duan1_nhom1.utils.JdbcHelper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class ChucVuRepository {
    JdbcHelper dBConTect;

         public ArrayList<ChucVu> getChucVu() {
        ArrayList<ChucVu> list = new ArrayList<>();
        String sql = "select* from chuc_vu ";
        try (Connection conn=JdbcHelper.getConnection()){
            PreparedStatement pst =conn.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while (rs.next()) { 
                String id=rs.getString("id");
                String ma=rs.getString("ma");
                String tencv =rs.getString("ten_chuc_vu");
                
                Date ngayTao =rs.getDate("ngay_tao");
                Date ngaySua =rs.getDate("ngay_sua");
                boolean trangThai=rs.getBoolean("trang_thai");
                ChucVu nv=new ChucVu(id, ma, tencv, ngayTao, ngaySua, trangThai);
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
         public String getTenById(String id) {
        String sql = "SELECT ten_chuc_vu FROM chuc_vu WHERE id = ?";
        java.sql.Connection cn = JdbcHelper.getConnection();
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("ten_chuc_vu");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getAllId() {
        ArrayList<String> listId = new ArrayList<>();
        java.sql.Connection cn = JdbcHelper.getConnection();
        String sql = "SELECT id FROM chuc_vu";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listId.add(rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listId;
    }

    public List<String> getAllTen() {
        ArrayList<String> listId = new ArrayList<>();
        java.sql.Connection cn = JdbcHelper.getConnection();
        String sql = "SELECT ten_chuc_vu FROM chuc_vu where TrangThai = 0";
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listId.add(rs.getString("ten_chuc_vu"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listId;
    }
}
