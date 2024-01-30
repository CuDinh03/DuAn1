/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.repository;

import duan1_nhom1.model.DanhMuc;
import duan1_nhom1.model.HoaDon;
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
    List<Voucher> listVouchers = new ArrayList();
    Connection conn = JdbcHelper.getConnection();

    public List<Voucher> getAll() {

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
                Date ngayDau= rs.getDate("ngay_bat_dau");
                Date ngayCuoi = rs.getDate("ngay_het_han");
                int soLuong = rs.getInt("so_luong");
                Date ngayTao = rs.getDate("ngay_tao");
                Date ngaySua = rs.getDate("ngay_tao");
                Boolean trangThai = rs.getBoolean("trang_thai");
                Voucher vc = new Voucher(id, ma, ten, giamGia, ngayDau, ngayCuoi, soLuong, ngayTao, ngaySua, trangThai);
                listVouchers.add(vc);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi kết nối");
            ex.printStackTrace();
        }
        return listVouchers;
    }
    public void createVoucher(Voucher voucher) {
        try {
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
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
