/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.repository;

import duan1_nhom1.model.ChiTietHoaDon;
import duan1_nhom1.utils.JdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChiTietHoaDonRepository {

    private final Connection connection = JdbcHelper.getConnection();

    public void createChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
        try {
            String query = "INSERT INTO Hoa_Don_Chi_Tiet (id, id_hd, id_sp, so_luong, gia_ban, ngay_tao, ngay_sua, trang_thai) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setObject(1, chiTietHoaDon.getId());
                preparedStatement.setObject(2, chiTietHoaDon.getIdHoaDon());
                preparedStatement.setObject(3, chiTietHoaDon.getIdSanPham());
                preparedStatement.setInt(4, chiTietHoaDon.getSoLuong());
                preparedStatement.setDouble(5, chiTietHoaDon.getGiaBan());
                preparedStatement.setDate(6, new java.sql.Date(chiTietHoaDon.getNgayTao().getTime()));
                preparedStatement.setDate(7, new java.sql.Date(chiTietHoaDon.getNgaySua().getTime()));
                preparedStatement.setBoolean(8, chiTietHoaDon.getTrangThai());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ChiTietHoaDon getChiTietHoaDonById(String chiTietHoaDonId) {
        String query = "SELECT * FROM Hoa_Don_Chi_Tiet WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setObject(1, chiTietHoaDonId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String id = (String) resultSet.getObject("id");
                    String id_hd = (String) resultSet.getObject("id_hd");
                    String id_sp = (String) resultSet.getObject("id_sp");
                    Integer so_luong = resultSet.getInt("so_luong");
                    Double gia_ban = resultSet.getDouble("gia_ban");
                    Date ngay_tao = resultSet.getDate("ngay_tao");
                    Date ngay_sua = resultSet.getDate("ngay_sua");
                    Boolean trang_thai = resultSet.getBoolean("trang_thai");

                    return new ChiTietHoaDon(id, id_hd, id_sp, so_luong, gia_ban, ngay_tao, ngay_sua, trang_thai);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
        try {
            String query = "UPDATE Hoa_Don_Chi_Tiet SET id_hd = ?, id_sp = ?, so_luong = ?, "
                    + "gia_ban = ?, ngay_sua = ?, trang_thai = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setObject(1, chiTietHoaDon.getIdHoaDon());
                preparedStatement.setObject(2, chiTietHoaDon.getIdSanPham());
                preparedStatement.setInt(3, chiTietHoaDon.getSoLuong());
                preparedStatement.setDouble(4, chiTietHoaDon.getGiaBan());
                preparedStatement.setDate(5, new java.sql.Date(chiTietHoaDon.getNgaySua().getTime()));
                preparedStatement.setBoolean(6, chiTietHoaDon.getTrangThai());
                preparedStatement.setObject(7, chiTietHoaDon.getId());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteChiTietHoaDon(String chiTietHoaDonId) {
        try {
            String query = "UPDATE Hoa_Don_Chi_Tiet set trang_thai = 0 WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setObject(1, chiTietHoaDonId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ChiTietHoaDon> getAllChiTietHoaDon() {
        List<ChiTietHoaDon> chiTietHoaDons = new ArrayList<>();
        /*
        status/ trang thai
        0: da xoa
        1: dang ton tai
         */
        String query = "SELECT * FROM Hoa_Don_Chi_Tiet where trang_thai = 1";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String id = (String) resultSet.getObject("id");
                String id_hd = (String) resultSet.getObject("id_hd");
                String id_sp = (String) resultSet.getObject("id_sp");
                Integer so_luong = resultSet.getInt("so_luong");
                Double gia_ban = resultSet.getDouble("gia_ban");
                Date ngay_tao = resultSet.getDate("ngay_tao");
                Date ngay_sua = resultSet.getDate("ngay_sua");
                Boolean trang_thai = resultSet.getBoolean("trang_thai");

                ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(id, id_hd, id_sp, so_luong, gia_ban, ngay_tao, ngay_sua, trang_thai);
                chiTietHoaDons.add(chiTietHoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chiTietHoaDons;
    }

    public List<ChiTietHoaDon> getAllChiTietHoaDonByIDHd(String id) {
        List<ChiTietHoaDon> chiTietHoaDons = new ArrayList<>();
        System.out.println(id);
        String query = "SELECT * from Hoa_Don_Chi_Tiet WHERE id_hd = ? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String id_hd = (String) resultSet.getObject("id_hd");
                String id_sp = (String) resultSet.getObject("id_sp");
                Integer so_luong = resultSet.getInt("so_luong");
                Double gia_ban = resultSet.getDouble("gia_ban");
                Date ngay_tao = resultSet.getDate("ngay_tao");
                Date ngay_sua = resultSet.getDate("ngay_sua");
                Boolean trang_thai = resultSet.getBoolean("trang_thai");

                ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(id, id_hd, id_sp, so_luong, gia_ban, ngay_tao, ngay_sua, trang_thai);
                chiTietHoaDons.add(chiTietHoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chiTietHoaDons;
    }
    
}
