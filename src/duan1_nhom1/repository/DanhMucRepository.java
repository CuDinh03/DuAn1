/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.repository;

import duan1_nhom1.dto.DanhMucDto;
import duan1_nhom1.model.ChatLieu;
import duan1_nhom1.model.DanhMuc;
import duan1_nhom1.model.Hang;
import duan1_nhom1.model.HoaDon;
import duan1_nhom1.model.Khach;
import duan1_nhom1.utils.JdbcHelper;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author anhtuanle
 */
public class DanhMucRepository {

    List<DanhMucDto> listDanhMuc = new ArrayList();
    Connection conn = JdbcHelper.getConnection();

    public List<DanhMucDto> getAll() {

        String sql = "SELECT id,ma,ten,mo_ta,ngay_tao,ngay_sua,trang_thai FROM danh_muc_san_pham";

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
                DanhMuc danhMuc = new DanhMuc(id, ma, ten, moTa, ngayTao, ngaySua, trangThai);
                listDanhMuc.add(danhMuc);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi kết nối");
            ex.printStackTrace();
        }
        return listDanhMuc;
    }

    public String getTenById(String id) {
        String sql = "SELECT ten FROM danh_muc_san_pham WHERE id = ?";

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

        String sql = "SELECT id FROM danh_muc_san_pham";
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

        String sql = "SELECT ten FROM danh_muc_san_pham where TrangThai = 0";
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
    public void addDanhMuc(DanhMuc danhMuc) {
        if (danhMuc == null) {
            return;
        }

        String sql = """
        INSERT INTO [dbo].[danh_muc_san_pham]
                   ([id]
                   ,[ma]
                   ,[ten]
                   ,[mo_ta]
                   ,[ngay_tao]
                   ,[ngay_sua]
                   ,[trang_thai])
               VALUES
                     (?
                     ,?
                     ,?
                     ,?
                     ,?
                     ,?
                     ,?);  
                 """;

        try (Connection con = JdbcHelper.getConnection(); PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setObject(1, danhMuc.getId());
            preparedStatement.setString(2, danhMuc.getMa());
            preparedStatement.setString(3, danhMuc.getTen());
            preparedStatement.setString(4, danhMuc.getMoTa());
            preparedStatement.setDate(5, new java.sql.Date(danhMuc.getNgayTao().getTime()));
            preparedStatement.setDate(6, new java.sql.Date(danhMuc.getNgaySua().getTime()));
            preparedStatement.setBoolean(7, danhMuc.isTrangThai());

            int chek = preparedStatement.executeUpdate();

            if (chek > 0) {
                System.out.println("Danh Mục Đã thêm thành công ");
            } else {
                System.out.println("Thêm thất bại ");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
