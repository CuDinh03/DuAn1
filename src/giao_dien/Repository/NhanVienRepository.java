/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giao_dien.Repository;

import giao_dien.DBConnect.DBConnect;
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
public class NhanVienRepository {
    DBConnect dBConTect;

         public ArrayList<Nhan_vien> getNhanVien() {
        ArrayList<Nhan_vien> list = new ArrayList<>();
        String sql = "select* from Nguoi_Dung ";
        try (Connection conn=DBConnect.getConnection()){
            PreparedStatement pst =conn.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while (rs.next()) { 
                String id=rs.getString("id");
                String ten =rs.getString("ten");
                String dc =rs.getString("dia_chi");
                String sdt =rs.getString("sdt");
                String id_cv=rs.getString("id_cv");
                Date ngaybdDate=rs.getDate("ngay_bd");
                Date ngayTao =rs.getDate("ngay_tao");
                Date ngaySua =rs.getDate("ngay_sua");
                boolean trangThai=rs.getBoolean("trang_thai");
                Nhan_vien nv=new Nhan_vien(id, ten, dc, sdt, id_cv, ngaybdDate, ngayTao, ngaySua, trangThai);
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public Boolean delete(String id) {
        String sql = "DELETE FROM Nguoi_Dung WHERE id = ?";
        int check = 0;
        try (java.sql.Connection cn = DBConnect.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public Boolean them(Nhan_vien nv) {
        String sql = "INSERT INTO Nguoi_Dung (ten,dia_chi,sdt,ngay_bd,ngay_tao,ngay_sua,trang_thai) VALUES(?,?,?,?,?,?,?)";
        int check = 0;
        try (java.sql.Connection cn = DBConnect.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setObject(1, nv.getTen());
            ps.setObject(2, nv.getDiaChi());
            ps.setObject(3, nv.getSdt());
            ps.setObject(4, nv.getNgayBD());
            ps.setObject(5, nv.getNgayTao());
            ps.setObject(6, nv.getNgaySua());
            ps.setObject(7, nv.isTrangThai());
            check=ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }

    public Boolean sua(Nhan_vien nv,String id) {
        String sql = "UPDATE Nguoi_dung SET ten=?,dia_chi = ?,"
                + "sdt = ?,ngay_bd=?,ngay_tao=?,ngay_sua=?,trang_thai=? WHERE id = ?";
        int check = 0;
        try (java.sql.Connection cn = DBConnect.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            
            ps.setObject(1, nv.getTen());
            ps.setObject(2, nv.getDiaChi());
            ps.setObject(3, nv.getSdt());
            ps.setObject(4, nv.getNgayBD());
            ps.setObject(5, nv.getNgayTao());
            ps.setObject(6, nv.getNgaySua());
            ps.setObject(7, nv.isTrangThai());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;
    }
    
}
