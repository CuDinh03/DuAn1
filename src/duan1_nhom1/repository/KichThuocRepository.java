/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import duan1_nhom1.model.KichThuoc;
import duan1_nhom1.model.MauSac; 
import duan1_nhom1.utils.JdbcHelper;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author anhtuanle
 */
public class KichThuocRepository {

    private JdbcHelper jdbcHelper;
    List<KichThuoc> listKichThuoc = new ArrayList();
    Connection conn = JdbcHelper.getConnection();

    public List<KichThuoc> getAll() {

        String sql = "SELECT id,ma,ten,mo_ta,ngay_tao,ngay_sua,trang_thai FROM size_ao";

        try {
            PreparedStatement pr = conn.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                String moTa = rs.getString("mo_ta");
                Date ngayTao = rs.getDate("ngay_tao");
                Date ngaySua = rs.getDate("ngay_tao");
                boolean trangThai = rs.getBoolean("trang_thai");
                KichThuoc kichThuoc = new KichThuoc(id, ma, ten, moTa, ngayTao, ngaySua, trangThai);
                listKichThuoc.add(kichThuoc);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi kết nối");
            ex.printStackTrace();
        }
        return listKichThuoc;
    }

    public String getTenById(String id) {
        String sql = "SELECT ten FROM size_ao WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("ten");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getAllId() {
        ArrayList<String> listId = new ArrayList<>();

        String sql = "SELECT id FROM size_ao";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
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

        String sql = "SELECT ten FROM size_ao where TrangThai = 0";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listId.add(rs.getString("ten"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listId;
    }

    public void add(KichThuoc kichThuoc) {
        Connection conn = jdbcHelper.getConnection();
        String sql = "INSERT INTO size_ao(ma,ten,mo_ta,ngay_tao,ngay_sua,trang_thai) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement prepareStatement = conn.prepareStatement(sql);

            prepareStatement.setString(1, kichThuoc.getMa());

            prepareStatement.setString(2, kichThuoc.getTen());

            prepareStatement.setString(3, kichThuoc.getMoTa());

            prepareStatement.setDate(4, new java.sql.Date(kichThuoc.getNgayTao().getTime()));
            prepareStatement.setDate(5, new java.sql.Date(kichThuoc.getNgaySua().getTime()));

            prepareStatement.setBoolean(6, kichThuoc.isTrangThai());

            int rs = prepareStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(KichThuoc kichThuoc) {
         String sql = "UPDATE size_ao SET ma = ?, ten = ?, mo_ta = ?, ngay_tao = ?, ngay_sua = ?, trang_thai = ? WHERE id  = ? ";

        try (Connection con = jdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, kichThuoc.getMa());
            ps.setObject(2, kichThuoc.getTen());
            ps.setObject(3, kichThuoc.getMoTa());
            ps.setObject(4, kichThuoc.getNgayTao());
            ps.setObject(5, kichThuoc.getNgaySua());
            ps.setObject(6, kichThuoc.isTrangThai());
            ps.setObject(7, kichThuoc.getId());

            int chek = ps.executeUpdate();

            if (chek > 0) {
                System.out.println(" updated thành công ");
            } else {
                System.out.println("Update thất bại ");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void delete(String id) {
        String sql = "DELETE FROM size_ao WHERE id = ?";

        try (Connection con = jdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            int chek = ps.executeUpdate();

            if (chek > 0) {
                System.out.println("Xóa thành công ");
            } else {
                System.out.println("Xóa thất bại ");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
    
}
