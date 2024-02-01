package duan1_nhom1.repository;
import duan1_nhom1.model.ChiTietGioHang;
import duan1_nhom1.utils.JdbcHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ChiTietGioHangRepository {

    private final Connection connection = JdbcHelper.getConnection();

    public void createChiTietGioHang(ChiTietGioHang chiTietGioHang) {
        try {
            String query = "INSERT INTO Gio_Hang_Chi_Tiet (id_gh, id_sp, so_luong, ngay_tao, ngay_sua, trang_thai) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, chiTietGioHang.getIdGH());
                preparedStatement.setString(2, chiTietGioHang.getIdSP());
                preparedStatement.setInt(3, chiTietGioHang.getSoLuong());
                preparedStatement.setDate(4, new java.sql.Date(chiTietGioHang.getNgayTao().getTime()));
                preparedStatement.setDate(5, new java.sql.Date(chiTietGioHang.getNgaySua().getTime()));
                preparedStatement.setBoolean(6, chiTietGioHang.getTrangThai());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public ChiTietGioHang getChiTietGioHangById(String idGH, String idSP) {
//        String query = "SELECT * FROM Gio_Hang_Chi_Tiet WHERE id_gh = ? AND id_sp = ?";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//            preparedStatement.setString(1, idGH);
//            preparedStatement.setString(2, idSP);
//            try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                if (resultSet.next()) {
//                    Integer soLuong = resultSet.getInt("so_luong");
//                    Date ngayTao = resultSet.getDate("ngay_tao");
//                    Date ngaySua = resultSet.getDate("ngay_sua");
//                    Boolean trangThai = resultSet.getBoolean("trang_thai");
//
//                    return new ChiTietGioHang(id,idGH, idSP, soLuong, ngayTao, ngaySua, trangThai);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public void updateChiTietGioHang(ChiTietGioHang chiTietGioHang) {
        try {
            String query = "UPDATE Gio_Hang_Chi_Tiet SET so_luong = ?, ngay_sua = ?, trang_thai = ? "
                    + "WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, chiTietGioHang.getSoLuong());
                preparedStatement.setDate(2, new java.sql.Date(chiTietGioHang.getNgaySua().getTime()));
                preparedStatement.setBoolean(3, chiTietGioHang.getTrangThai());
                preparedStatement.setString(4, chiTietGioHang.getId());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteChiTietGioHang(String id) {
        try {
            String query = "DELETE FROM Gio_Hang_Chi_Tiet WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, id);


                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ChiTietGioHang> getAllChiTietGioHang() {
        List<ChiTietGioHang> chiTietGioHangs = new ArrayList<>();
        String query = "SELECT * FROM Gio_Hang_Chi_Tiet";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query); ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String idGH = resultSet.getString("id_gh");
                String idSP = resultSet.getString("id_sp");
                Integer soLuong = resultSet.getInt("so_luong");
                Date ngayTao = resultSet.getDate("ngay_tao");
                Date ngaySua = resultSet.getDate("ngay_sua");
                Boolean trangThai = resultSet.getBoolean("trang_thai");

                ChiTietGioHang chiTietGioHang = new ChiTietGioHang(id,idGH, idSP, soLuong, ngayTao, ngaySua, trangThai);
                chiTietGioHangs.add(chiTietGioHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chiTietGioHangs;
    }

    public ChiTietGioHang findById(String id) {
        String query = "SELECT * FROM Gio_Hang_Chi_Tiet WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String idGH = resultSet.getString("id_gh");
                    String idSP = resultSet.getString("id_sp");
                    Integer soLuong = resultSet.getInt("so_luong");
                    Date ngayTao = resultSet.getDate("ngay_tao");
                    Date ngaySua = resultSet.getDate("ngay_sua");
                    Boolean trangThai = resultSet.getBoolean("trang_thai");

                    return new ChiTietGioHang(id,idGH, idSP, soLuong, ngayTao, ngaySua, trangThai);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void changeQuantity(ChiTietGioHang ctgh) {
        String query = "Update Gio_Hang_Chi_Tiet set so_luong = ? where id = ? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, ctgh.getSoLuong());
            preparedStatement.setString(2, ctgh.getId());
            preparedStatement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(SPChiTietRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<ChiTietGioHang> getAllChiTietGioHangByIdgh(String idGh) {
    List<ChiTietGioHang> chiTietGioHangs = new ArrayList<>();
        String query = "SELECT * FROM Gio_Hang_Chi_Tiet where id_gh = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, idGh);
                ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String idGH = resultSet.getString("id_gh");
                String idSP = resultSet.getString("id_sp");
                Integer soLuong = resultSet.getInt("so_luong");
                Date ngayTao = resultSet.getDate("ngay_tao");
                Date ngaySua = resultSet.getDate("ngay_sua");
                Boolean trangThai = resultSet.getBoolean("trang_thai");

                ChiTietGioHang chiTietGioHang = new ChiTietGioHang(id,idGH, idSP, soLuong, ngayTao, ngaySua, trangThai);
                chiTietGioHangs.add(chiTietGioHang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chiTietGioHangs;
    }

}
