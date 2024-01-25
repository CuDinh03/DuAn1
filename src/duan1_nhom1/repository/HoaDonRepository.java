/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.repository;

/**
 *1
 * @author maccuacu
 */
import duan1_nhom1.model.HoaDon;
import duan1_nhom1.utils.JdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class HoaDonRepository {

    private final Connection connection = JdbcHelper.getConnection();

    public void createHoaDon(HoaDon hoaDon) {
        try {
            String query = "INSERT INTO hoa_don (id, id_kh, id_nv, ma, ngay_mua, tong_tien, trang_thai, ngay_tao, ngay_sua) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setObject(1, hoaDon.getId());
                preparedStatement.setObject(2, hoaDon.getIdKhachHang());
                preparedStatement.setObject(3, hoaDon.getIdNv());
                preparedStatement.setString(4, hoaDon.getMa());
                preparedStatement.setDate(5, new java.sql.Date(hoaDon.getNgayMua().getTime()));
                preparedStatement.setDouble(6, hoaDon.getTongTien());
                preparedStatement.setBoolean(7, hoaDon.getTrangThai());
                preparedStatement.setDate(8, new java.sql.Date(hoaDon.getNgayTao().getTime()));
                preparedStatement.setDate(9, new java.sql.Date(hoaDon.getNgaySua().getTime()));

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public HoaDon getHoaDonById(String hoaDonId) {
        String query = "SELECT * FROM hoa_don WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setObject(1, hoaDonId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String id =  resultSet.getString("id");
                    String id_kh =  resultSet.getString("id_kh");
                    String id_Nv =  resultSet.getString("id_Nv");
                    String ma = resultSet.getString("ma");
                    Date ngay_mua = resultSet.getDate("ngay_mua");
                    Double tong_tien = resultSet.getDouble("tong_tien");
                    Boolean trang_thai = resultSet.getBoolean("trang_thai");
                    Date ngay_tao = resultSet.getDate("ngay_tao");
                    Date ngay_sua = resultSet.getDate("ngay_sua");

                    return new HoaDon(id, id_kh, id_Nv, ma, ngay_mua, tong_tien, trang_thai, ngay_tao, ngay_sua);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateHoaDon(HoaDon hoaDon) {
        try {
            String query = "UPDATE hoa_don SET id_kh = ?, id_Nv =?, ma = ?, ngay_mua = ?, " +
                    "tong_tien = ?, trang_thai = ?, ngay_sua = ? WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setObject(1, hoaDon.getIdKhachHang());
                preparedStatement.setObject(2, hoaDon.getIdNv());
                preparedStatement.setString(3, hoaDon.getMa());
                preparedStatement.setDate(4, new java.sql.Date(hoaDon.getNgayMua().getTime()));
                preparedStatement.setDouble(5, hoaDon.getTongTien());
                preparedStatement.setBoolean(6, hoaDon.getTrangThai());
                preparedStatement.setDate(7, new java.sql.Date(hoaDon.getNgaySua().getTime()));
                preparedStatement.setObject(8, hoaDon.getId());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteHoaDon(String hoaDonId) {
        try {
            String query = "DELETE FROM hoa_don WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setObject(1, hoaDonId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<HoaDon> getAllHoaDon() {
        List<HoaDon> hoaDons = new ArrayList<>();
        String query = "SELECT * FROM hoa_don";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String id_kh =  resultSet.getString("id_kh");
                    String id_Nv =  resultSet.getString("id_Nv");
                    String ma = resultSet.getString("ma");
                    Date ngay_mua = resultSet.getDate("ngay_mua");
                    Double tong_tien = resultSet.getDouble("tong_tien");
                    Boolean trang_thai = resultSet.getBoolean("trang_thai");
                    Date ngay_tao = resultSet.getDate("ngay_tao");
                    Date ngay_sua = resultSet.getDate("ngay_sua");


                HoaDon hoaDon = new HoaDon(id, id_kh, id_Nv, ma, ngay_mua, tong_tien, trang_thai, ngay_tao, ngay_sua);
                hoaDons.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hoaDons;
    }
}

    

