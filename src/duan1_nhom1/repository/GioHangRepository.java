/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.repository;

import duan1_nhom1.model.GioHang;
import duan1_nhom1.utils.JdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GioHangRepository {

    private final Connection connection = JdbcHelper.getConnection();

    public void createGioHang(GioHang gioHang) {
        try {
            String query = "INSERT INTO gio_hang ( ma, id_kh, ngay_tao, ngay_sua, trang_thai) "
                    + "VALUES ( ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, gioHang.getMa());
                preparedStatement.setString(2, gioHang.getIdKH());
                preparedStatement.setDate(3, new java.sql.Date(gioHang.getNgayTao().getTime()));
                preparedStatement.setDate(4, new java.sql.Date(gioHang.getNgaySua().getTime()));
                preparedStatement.setBoolean(5, gioHang.getTrangThai());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public GioHang findByMa(String magh) {
        String query = "SELECT * FROM gio_hang WHERE ma = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, magh);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String ma = resultSet.getString("ma");
                    String idKH = resultSet.getString("id_kh");
                    Date ngayTao = resultSet.getDate("ngay_tao");
                    Date ngaySua = resultSet.getDate("ngay_sua");
                    Boolean trangThai = resultSet.getBoolean("trang_thai");

                    return new GioHang(id, ma, idKH, ngayTao, ngaySua, trangThai);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateGioHang(GioHang gioHang) {
        try {
            String query = "UPDATE gio_hang SET ma = ?, id_kh = ?, ngay_tao = ?, ngay_sua = ?, trang_thai = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, gioHang.getMa());
                preparedStatement.setString(2, gioHang.getIdKH());
                preparedStatement.setDate(3, new java.sql.Date(gioHang.getNgayTao().getTime()));
                preparedStatement.setDate(4, new java.sql.Date(gioHang.getNgaySua().getTime()));
                preparedStatement.setBoolean(5, gioHang.getTrangThai());
                preparedStatement.setString(6, gioHang.getId());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteGioHang(String id) {
        try {
            String query = "DELETE FROM gio_hang WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<GioHang> getAllGioHang() {
        List<GioHang> gioHangs = new ArrayList<>();
        String query = "SELECT * FROM gio_hang";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String ma = resultSet.getString("ma");
                String idKH = resultSet.getString("id_kh");
                Date ngayTao = resultSet.getDate("ngay_tao");
                Date ngaySua = resultSet.getDate("ngay_sua");
                Boolean trangThai = resultSet.getBoolean("trang_thai");

                GioHang gioHang = new GioHang(id, ma, idKH, ngayTao, ngaySua, trangThai);
                gioHangs.add(gioHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gioHangs;
    }

    // Phương thức findById
    public GioHang findById(String id) {
        String query = "SELECT * FROM gio_hang WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String ma = resultSet.getString("ma");
                    String idKH = resultSet.getString("id_kh");
                    Date ngayTao = resultSet.getDate("ngay_tao");
                    Date ngaySua = resultSet.getDate("ngay_sua");
                    Boolean trangThai = resultSet.getBoolean("trang_thai");

                    return new GioHang(id, ma, idKH, ngayTao, ngaySua, trangThai);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
