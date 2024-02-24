/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.repository;
import duan1_nhom1.model.GioHangHoaDon;
import java.sql.*;
import duan1_nhom1.utils.JdbcHelper;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maccuacu
 */
public class GioHangHoaDonRepository {
        private final Connection connection = JdbcHelper.getConnection();



    public void createGioHangHoaDon(GioHangHoaDon gioHangHoaDon) {
        try {
            String query = "INSERT INTO gio_hang_hoa_don ( id_gh, id_hd, ngay_tao, ngay_sua, trang_thai) "
                    + "VALUES ( ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, gioHangHoaDon.getIdGioHang());
                preparedStatement.setString(2, gioHangHoaDon.getIdHoaDon());
                preparedStatement.setDate(3, new java.sql.Date(gioHangHoaDon.getNgayTao().getTime()));
                preparedStatement.setDate(4, new java.sql.Date(gioHangHoaDon.getNgaySua().getTime()));
                preparedStatement.setBoolean(5, gioHangHoaDon.getTrangThai());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
public List<GioHangHoaDon> getAllGioHangHoaDon( String idhd) {
    List<GioHangHoaDon> gioHangHoaDons = new ArrayList<>();
    String query = "SELECT * FROM Gio_Hang_Hoa_Don WHERE  id_hd = ?";
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, idhd);

        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                GioHangHoaDon gioHangHoaDon = new GioHangHoaDon();
                gioHangHoaDon.setId(resultSet.getString("id"));
                gioHangHoaDon.setIdGioHang(resultSet.getString("id_gh"));
                gioHangHoaDon.setIdHoaDon(resultSet.getString("id_hd"));
                gioHangHoaDon.setNgayTao(resultSet.getDate("ngay_tao"));
                gioHangHoaDon.setNgaySua(resultSet.getDate("ngay_sua"));
                gioHangHoaDon.setTrangThai(resultSet.getBoolean("trang_thai"));
                gioHangHoaDons.add(gioHangHoaDon);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return gioHangHoaDons;
}
    public GioHangHoaDon getGioHangHoaDonById(String idhoadon) {
        String query = "SELECT * FROM Gio_Hang_Hoa_Don WHERE id_hd = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, idhoadon);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    GioHangHoaDon gioHangHoaDon = new GioHangHoaDon();
                    gioHangHoaDon.setId(resultSet.getString("id"));
                    gioHangHoaDon.setIdGioHang(resultSet.getString("id_gh"));
                    gioHangHoaDon.setIdHoaDon(resultSet.getString("id_hd"));
                    gioHangHoaDon.setNgayTao(resultSet.getDate("ngay_tao"));
                    gioHangHoaDon.setNgaySua(resultSet.getDate("ngay_sua"));
                    gioHangHoaDon.setTrangThai(resultSet.getBoolean("trang_thai"));
                    return gioHangHoaDon;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    
}
