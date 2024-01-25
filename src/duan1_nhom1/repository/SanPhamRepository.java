/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.repository;

import duan1_nhom1.model.MauSac;
import duan1_nhom1.model.SanPham;
import duan1_nhom1.utils.JdbcHelper;
import duan1_nhom1.viewModel.QLSanPhamViewModel;
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
                boolean trangThai = rs.getBoolean("trang_thai");
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

}
