/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giao_dien.Repository;

import giao_dien.DBConnect.DBConnect;
import giao_dien.model.Nhan_vien;
import giao_dien.model.TaiKhoan;
import java.awt.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author acer
 */
public class TaiKhoanRepository {
    DBConnect dBConTect;
    ArrayList<TaiKhoan>listTK=new ArrayList<>();
    
    Connection conn = dBConTect.getConnection();
    PreparedStatement sttm =null;

        public ArrayList<TaiKhoan> getTaiKhoan() {
        ArrayList<TaiKhoan> list = new ArrayList<>();
        String sql = "select* from tai_khoan ";
        try (java.sql.Connection conn=dBConTect.getConnection()){
            PreparedStatement pst =conn.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while (rs.next()) { 
                String id=rs.getString("id");
                String ma =rs.getString("ma");
                String tenDN =rs.getString("ten_dang_nhap");
                String mk =rs.getString("mat_khau");
                String id_cv=rs.getString("id_chuc_vu");
                Date ngayTao =rs.getDate("ngay_tao");
                Date ngaySua =rs.getDate("ngay_sua");
                boolean trangThai=rs.getBoolean("trang_thai");
                TaiKhoan tk=new TaiKhoan(id, ma, tenDN, mk, id_cv, ngayTao, ngaySua, trangThai);
                list.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public Boolean delete(String id) {
        String sql = "DELETE FROM tai_khoan WHERE id = ?";
        int check = 0;
        try (java.sql.Connection cn = DBConnect.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public Boolean them(TaiKhoan tk) {
        String sql = "INSERT INTO tai_khoan (ma,ten_dang_nhap,mat_khau,id_chuc_vu,ngay_tao,ngay_sua,trang_thai) VALUES(?,?,?,?,?,?,?)";
        int check = 0;
        try (java.sql.Connection cn = DBConnect.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
//            ps.setObject(1, tk.getId());
            ps.setObject(1, tk.getMa());
            ps.setObject(2, tk.getTenDangNhap());
            ps.setObject(3, tk.getMk());
            ps.setObject(4, tk.getId_cv());
            ps.setObject(5, tk.getNgayTao());
            ps.setObject(6, tk.getNgaySua());
            ps.setObject(7, tk.isTrangThai());
            check=ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public Boolean sua(TaiKhoan tk,String id) {
        String sql = "UPDATE tai_khoan SET ma=?,ten_dang_nhap = ?,mat_khau = ?,id_chuc_vu=?,ngay_tao=?,ngay_sua=?,trang_thai=? WHERE id = ?";
        int check = 0;
        try (java.sql.Connection cn = DBConnect.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setObject(1, tk.getId());
            ps.setObject(2, tk.getMa());
            ps.setObject(3, tk.getTenDangNhap());
            ps.setObject(4, tk.getMk());
            ps.setObject(5, tk.getId_cv());
            ps.setObject(6, tk.getNgayTao());
            ps.setObject(7, tk.getNgaySua());
            ps.setObject(8, tk.isTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
    
 
}
