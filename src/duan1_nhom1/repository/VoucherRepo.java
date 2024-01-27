/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.repository;

import duan1_nhom1.model.DanhMuc;
import duan1_nhom1.model.HoaDon;
import duan1_nhom1.model.Khach;
import duan1_nhom1.model.Voucher;
import duan1_nhom1.utils.JdbcHelper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bachh
 */
public class VoucherRepo {

    Connection conn = JdbcHelper.getConnection();

    public List<Voucher> getAll() {
        List<Voucher> listVouchers = new ArrayList();
        String sql = """
                     SELECT [id]
                           ,[ma]
                           ,[ten]
                           ,[giam_gia]
                           ,[ngay_bat_dau]
                           ,[ngay_het_han]
                           ,[so_luong]
                           ,[ngay_tao]
                           ,[ngay_sua]
                           ,[trang_thai]
                       FROM [dbo].[Voucher]
                     """;

        try {
            PreparedStatement pr = conn.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                Float giamGia = rs.getFloat("giam_gia");
                Date ngayDau = rs.getDate("ngay_bat_dau");
                Date ngayCuoi = rs.getDate("ngay_het_han");
                int soLuong = rs.getInt("so_luong");
                Date ngayTao = rs.getDate("ngay_tao");
                Date ngaySua = rs.getDate("ngay_tao");
                Boolean trangThai = rs.getBoolean("trang_thai");
                Voucher vc = new Voucher(id, ma, ten, giamGia, ngayDau, ngayCuoi, soLuong, ngayTao, ngaySua, trangThai);
                listVouchers.add(vc);
            }
            return listVouchers;
        } catch (SQLException ex) {
            System.out.println("Lỗi kết nối");
            ex.printStackTrace();
        }
        return null;
    }

    public List<Voucher> createVoucher(Voucher voucher) {
//        try {
        List<Voucher> listVouchers = new ArrayList();
        String query = """
                           INSERT INTO [dbo].[Voucher]
                                      ([ma]
                                      ,[ten]
                                      ,[giam_gia]
                                      ,[ngay_bat_dau]
                                      ,[ngay_het_han]
                                      ,[so_luong]
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
                                      ,?
                                      ,?
                                      ,?)
                           """;
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
//                preparedStatement.setObject(1, voucher.getId());
            preparedStatement.setString(1, voucher.getMa());
            preparedStatement.setString(2, voucher.getTen());
            preparedStatement.setFloat(3, voucher.getGiamGia());
            preparedStatement.setDate(4, new java.sql.Date(voucher.getNgayDau().getTime()));
            preparedStatement.setDate(5, new java.sql.Date(voucher.getNgayCuoi().getTime()));
            preparedStatement.setInt(6, voucher.getSoLuong());
            preparedStatement.setDate(7, new java.sql.Date(voucher.getNgayTao().getTime()));
            preparedStatement.setDate(8, new java.sql.Date(voucher.getNgaySua().getTime()));
            preparedStatement.setBoolean(9, voucher.getTrangThai());

            preparedStatement.executeUpdate();
            return listVouchers;
//            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateVoucher(Voucher voucher, String id) {

        String query = """
                           UPDATE [dbo].[Voucher]
                              SET [id] = ?
                                 ,[ma] = ?
                                 ,[ten] = ?
                                 ,[giam_gia] = ?
                                 ,[ngay_bat_dau] = ?
                                 ,[ngay_het_han] = ?
                                 ,[so_luong] = ?
                                 ,[ngay_tao] = ?
                                 ,[ngay_sua] = ?
                                 ,[trang_thai] = ?
                            WHERE = ?;
                           """;

        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, voucher.getMa());
            preparedStatement.setString(2, voucher.getTen());
            preparedStatement.setFloat(3, voucher.getGiamGia());
            preparedStatement.setDate(4, new java.sql.Date(voucher.getNgayDau().getTime()));
            preparedStatement.setDate(5, new java.sql.Date(voucher.getNgayCuoi().getTime()));
            preparedStatement.setInt(6, voucher.getSoLuong());
            preparedStatement.setDate(7, new java.sql.Date(voucher.getNgayTao().getTime()));
            preparedStatement.setDate(8, new java.sql.Date(voucher.getNgaySua().getTime()));
            preparedStatement.setBoolean(9, voucher.getTrangThai());
            // Execute the update
            preparedStatement.executeUpdate();

//            int chek = preparedStatement.executeUpdate();
//
//            // Check the result
//            if (chek > 0) {
//                System.out.println("update   thành công ");
//            } else {
//               System.out.println("update thất bại  ");
//            }
        } catch (Exception e) {
            throw new RuntimeException("Error updating", e);
        }
    }
    public void delete(String id) {
        String sql = "DELETE FROM Voucher WHERE id = ?";

        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            int chek = ps.executeUpdate();

            if (chek > 0) {
                System.out.println("Xóa thành công ");
            } else {
                System.out.println("Xóa thất bại ");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
