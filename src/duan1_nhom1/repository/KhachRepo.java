/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.repository;

import duan1_nhom1.model.Khach;
import duan1_nhom1.utils.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WEB
 */
public class KhachRepo {

    private List<Khach> listKhach = new ArrayList<>();

    private List<Khach> getAll() {
        String sql = """
                SELECT [[ma]
                      ,[ten]
                      ,[sdt]
                      ,[ngay_tao]
                      ,[ngay_sua]
                      ,[trang_thai]
                  FROM [dbo].[Khach_Hang];
            """;
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<Khach> khach = new ArrayList<>();
            while (rs.next()) {
                Khach kh = new Khach();
                kh.setMaKhachHang(rs.getString(1));
                kh.setTenKhachHang(rs.getString(2));
                kh.setSdt(rs.getString(3));
                kh.setNgayTao(rs.getDate(4));
                kh.setNgaySua(rs.getDate(5));
                kh.setTrangThai(rs.getBoolean(6));

                khach.add(kh);
            }
            return khach;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addKhachHang(Khach khachHang) {
        if (khachHang == null) {
            return false;
        }
        String sql = """
            INSERT INTO [dbo].[Khach_Hang]
                         ([ma]
                         ,[ten]
                         ,[sdt]
                         ,[ngay_tao]
                         ,[ngay_sua]
                         ,[trang_thai])
                   VALUES
                         (?
                         ,?
                         ,?
                         ,?
                         ,?
                         ,?);  
                     """;
        int check = 0;
        try (Connection con = DBconnect.getConnection(); PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, khachHang.getMaKhachHang());
            stm.setString(2, khachHang.getTenKhachHang());
            stm.setString(3, khachHang.getSdt());
            stm.setDate(4, khachHang.getNgayTao());
            stm.setDate(5, khachHang.getNgaySua());
            stm.setBoolean(6, khachHang.getTrangThai());
            check = stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return check > 0;
    }
    public Boolean updateNhanVien(Khach kh) {
        String sql = """
   UPDATE [dbo].[Khach_Hang]
                  SET [ma] = ?
                     ,[ten] = ?
                     ,[sdt] = ?
                     ,[ngay_tao] = ?
                     ,[ngay_sua] = ?
                     ,[trang_thai] = ?
                WHERE id =?;
            """;
        int chek = 0;
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, kh.getMaKhachHang());
            ps.setObject(2, kh.getTenKhachHang());
            ps.setObject(3, kh.getSdt());
            ps.setObject(4, kh.getNgayTao());
            ps.setObject(5, kh.getNgaySua());
            ps.setObject(6, kh.getTrangThai());
            ps.setObject(7, kh.getId());
            chek = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return chek > 0;
    }

    public Boolean deleteNhanVien(String ma) {
        String sql = """
         DELETE FROM [dbo].[Khach_Hang]
                    WHERE id=?;
            """;
        int chek = 0;
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ma);
            chek = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return chek > 0;
    }
    
    

}
