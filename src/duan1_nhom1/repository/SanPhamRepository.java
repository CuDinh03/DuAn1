/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.repository;

import duan1_nhom1.model.SanPham;
import duan1_nhom1.utils.JdbcHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author anhtuanle
 */
public class SanPhamRepository {

    private JdbcHelper jdbcHelper;
    List<SanPham> listSanPham = new ArrayList();
    Connection conn = JdbcHelper.getConnection();

    public List<SanPham> getAll() {

        String sql = "SELECT id,ma,ten,mo_ta,ngay_tao,ngay_sua,trang_thai FROM san_pham";

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
                Boolean trangThai = rs.getBoolean("trang_thai");
                SanPham sanPham = new SanPham(id, ma, ten, moTa, ngayTao, ngaySua, trangThai);
                listSanPham.add(sanPham);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi kết nối");
            ex.printStackTrace();
        }
        return listSanPham;
    }

    public String getTenById(String id) {
        String sql = "SELECT ten FROM san_pham WHERE id = ?";

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

        String sql = "SELECT id FROM san_pham";
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

        String sql = "SELECT ten FROM san_pham where TrangThai = 0";
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

    public SanPham findById(String sanPhamId) {
        String query = "SELECT * FROM San_Pham WHERE id = ?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, sanPhamId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String id = rs.getString("id");
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                String moTa = rs.getString("mo_ta");
                Date ngayTao = rs.getDate("ngay_tao");
                Date ngaySua = rs.getDate("ngay_tao");
                Boolean trangThai = rs.getBoolean("trang_thai");

                return new SanPham(id, ma, ten, moTa, ngayTao, ngaySua, trangThai);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addNew(SanPham sanPham) {
        if (sanPham == null) {
            return;
        }

        String sql = "INSERT INTO San_Pham(ma,ten,mo_ta,ngay_tao,ngay_sua,trang_thai) VALUES(?,?,?,?,?,?)";

        try (Connection con = jdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, sanPham.getMa());
            ps.setString(2, sanPham.getTen());
            ps.setString(3, sanPham.getMoTa());
            ps.setDate(4, new java.sql.Date(sanPham.getNgayTao().getTime()));
            ps.setDate(5, new java.sql.Date(sanPham.getNgaySua().getTime()));
            ps.setBoolean(6, sanPham.getTrangThai());

            int chek = ps.executeUpdate();

            if (chek > 0) {
                System.out.println("San pham Đã thêm thành công ");
            } else {
                System.out.println("Thêm thất bại ");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void update(SanPham sanPham) {
        String sql = "UPDATE san_pham SET ma = ?, ten = ?, mo_ta = ?, ngay_tao = ?,ngay_sua = ?, trang_thai = ? WHERE id = ?";

        try (Connection con = jdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, sanPham.getMa());
            ps.setObject(2, sanPham.getTen());
            ps.setObject(3, sanPham.getMoTa());
            ps.setObject(4, sanPham.getNgayTao());
            ps.setObject(5, sanPham.getNgaySua());
            ps.setObject(6, sanPham.getTrangThai());
            ps.setObject(7, sanPham.getId());

            int chek = ps.executeUpdate();

            if (chek > 0) {
                System.out.println(" update thành công ");
            } else {
                System.out.println("Update thất bại ");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void delete(String id) {
         try {
            String query = "DELETE FROM san_pham WHERE id = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getMaById(String ma) {
        String sql = "SELECT id FROM san_pham WHERE ma = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("ten");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
