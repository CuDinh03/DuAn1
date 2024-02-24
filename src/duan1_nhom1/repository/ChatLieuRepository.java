/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.repository;

import duan1_nhom1.model.ChatLieu;
import duan1_nhom1.model.DanhMuc;
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
public class ChatLieuRepository {
    // hoan
    private JdbcHelper jdbcHelper;
    List<ChatLieu> listChatLieu = new ArrayList();
    Connection conn = JdbcHelper.getConnection();

    public List<ChatLieu> getAll() {

        String sql = "SELECT id,ma,ten,mo_ta,ngay_tao,ngay_sua,trang_thai FROM chat_lieu";

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
                ChatLieu chatLieu = new ChatLieu(id, ma, ten, moTa, ngayTao, ngaySua, trangThai);
                listChatLieu.add(chatLieu);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi kết nối");
            ex.printStackTrace();
        }
        return listChatLieu;
    }

    public String getTenById(String id) {
        String sql = "SELECT ten FROM chat_lieu WHERE id = ?";

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

    public ChatLieu findByid(String id1) {
        String sql = "SELECT * FROM chat_lieu WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id1);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String id = rs.getString("id");
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                String moTa = rs.getString("mo_ta");
                Date ngayTao = rs.getDate("ngay_tao");
                Date ngaySua = rs.getDate("ngay_tao");
                boolean trangThai = rs.getBoolean("trang_thai");
                ChatLieu chatLieu = new ChatLieu(id, ma, ten, moTa, ngayTao, ngaySua, trangThai);
                return chatLieu;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getAllId() {
        ArrayList<String> listId = new ArrayList<>();

        String sql = "SELECT id FROM chat_lieu";
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

        String sql = "SELECT ten FROM chat_lieu where TrangThai = 0";
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

     public void addNew(ChatLieu chatLieu) {
        if (chatLieu == null) {
            return;
        }

        String sql = "INSERT INTO chat_lieu(ma,ten,mo_ta,ngay_tao,ngay_sua,trang_thai) VALUES(?,?,?,?,?,?)";

        try (Connection con = jdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, chatLieu.getMa());
            ps.setString(2, chatLieu.getTen());
            ps.setString(3, chatLieu.getMoTa());
            ps.setDate(4, new java.sql.Date(chatLieu.getNgayTao().getTime()));
            ps.setDate(5, new java.sql.Date(chatLieu.getNgaySua().getTime()));
            ps.setBoolean(6, chatLieu.getTrangThai());

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

    public void update(ChatLieu chatLieu) {
        String sql = "UPDATE chat_lieu SET ma = ?, ten = ?, mo_ta = ?, ngay_tao = ?,ngay_sua = ?, trang_thai = ? WHERE id = ?";

        try (Connection con = jdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, chatLieu.getMa());
            ps.setObject(2, chatLieu.getTen());
            ps.setObject(3, chatLieu.getMoTa());
            ps.setObject(4, chatLieu.getNgayTao());
            ps.setObject(5, chatLieu.getNgaySua());
            ps.setObject(6, chatLieu.getTrangThai());
            ps.setObject(7, chatLieu.getId());

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
            String query = "DELETE FROM chat_lieu WHERE id = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
