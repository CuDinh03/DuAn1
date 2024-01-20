/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.repository;

/**
 *
 * @author maccuacu
 */
import duan1_nhom1.model.ChiTietHoaDon;
import duan1_nhom1.utils.JdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ChiTietHoaDonRepository {

    private final Connection connection = JdbcHelper.getConnection();

    public void createChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
        try {
            String query = "INSERT INTO chi_tiet_hoa_don (id, idHoaDon, idSanPham, soLuong, giaBan, ngayTao, ngaySua, trangThai) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
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

    public ChiTietHoaDon getChiTietHoaDonById(UUID chiTietHoaDonId) {
        String query = "SELECT * FROM chi_tiet_hoa_don WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setObject(1, chiTietHoaDonId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    UUID id = (UUID) resultSet.getObject("id");
                    UUID idHoaDon = (UUID) resultSet.getObject("idHoaDon");
                    UUID idSanPham = (UUID) resultSet.getObject("idSanPham");
                    int soLuong = resultSet.getInt("soLuong");
                    Double giaBan = resultSet.getDouble("giaBan");
                    Date ngayTao = resultSet.getDate("ngayTao");
                    Date ngaySua = resultSet.getDate("ngaySua");
                    Boolean trangThai = resultSet.getBoolean("trangThai");

                    return new ChiTietHoaDon(id, idHoaDon, idSanPham, soLuong, giaBan, ngayTao, ngaySua, trangThai);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
        try {
            String query = "UPDATE chi_tiet_hoa_don SET idHoaDon = ?, idSanPham = ?, soLuong = ?, " +
                    "giaBan = ?, ngaySua = ?, trangThai = ? WHERE id = ?";
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

    public void deleteChiTietHoaDon(UUID chiTietHoaDonId) {
        try {
            String query = "DELETE FROM chi_tiet_hoa_don WHERE id = ?";
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
        String query = "SELECT * FROM chi_tiet_hoa_don";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                UUID id = (UUID) resultSet.getObject("id");
                UUID idHoaDon = (UUID) resultSet.getObject("idHoaDon");
                UUID idSanPham = (UUID) resultSet.getObject("idSanPham");
                int soLuong = resultSet.getInt("soLuong");
                Double giaBan = resultSet.getDouble("giaBan");
                Date ngayTao = resultSet.getDate("ngayTao");
                Date ngaySua = resultSet.getDate("ngaySua");
                Boolean trangThai = resultSet.getBoolean("trangThai");

                ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(id, idHoaDon, idSanPham, soLuong, giaBan, ngayTao, ngaySua, trangThai);
                chiTietHoaDons.add(chiTietHoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chiTietHoaDons;
    }
}

