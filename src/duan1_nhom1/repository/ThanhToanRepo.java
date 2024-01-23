/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.repository;

import duan1_nhom1.model.ThanhToan;
import duan1_nhom1.utils.JdbcHelper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author WEB
 */
public class ThanhToanRepo {

    private List<ThanhToan> litsThanhToan = new ArrayList<>();

    public void addThanhToan(ThanhToan thanhToan) {
        String sql = """
          INSERT INTO [dbo].[Thanh_Toan]
                                    ([ma]
                                    ,[phuong_thuc_thanh_toan]
                                    ,[tien_thanh_toan]
                                    ,[ngay_thanh_toan]
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
        try (Connection con = JdbcHelper.getConnection(); PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, thanhToan.getMaThanhToan());
            stm.setString(2, thanhToan.getPhuongThucTT());
            stm.setString(3, thanhToan.getSoTien().toString());
            stm.setDate(4, (Date) thanhToan.getNgayTT());
            stm.setDate(5, (Date) thanhToan.getNgayTao());
            stm.setDate(6, (Date) thanhToan.getNgaySua());
            stm.setBoolean(7, thanhToan.getTrangThai());
            int chek = stm.executeUpdate();

            if (chek > 0) {
                System.out.println("Add thành công ");
            } else {
                System.out.println("Add thất bại ");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateThanhToan(ThanhToan tt, String id ) {
        String sql = """
         UPDATE [dbo].[Thanh_Toan]
            SET
               [ma] =?
               ,[phuong_thuc_thanh_toan] = ?
               ,[tien_thanh_toan] = ?
               ,[ngay_thanh_toan] = ?
               ,[ngay_tao] = ?
               ,[ngay_sua] = ?
               ,[trang_thai] = ?
          WHERE where id=?;
            """;
        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, tt.getMaThanhToan());
            ps.setObject(2, tt.getPhuongThucTT());
            ps.setObject(3, tt.getNgayTT());
            ps.setObject(4, tt.getNgayTao());
            ps.setObject(5, tt.getNgaySua());
            ps.setObject(6, tt.getTrangThai());
            ps.setObject(7, tt.getId());
            int chek = ps.executeUpdate();
            if (chek > 0) {
                System.out.println("update thành công ");
            } else {
                System.out.println("update thất bại ");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void deleteThanhToan(String  id) {
        String sql = """
         DELETE FROM [dbo].[Thanh_Toan]
                    WHERE id=?;
            """;
        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            int chek = ps.executeUpdate();
            if (chek > 0) {
                System.out.println("Add thành công ");
            } else {
                System.out.println("Add thất bại ");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public List<ThanhToan> getAll() {
    String sql = """
        SELECT 
            [ma],
            [phuong_thuc_thanh_toan],
            [tien_thanh_toan],
            [ngay_thanh_toan],
            [ngay_tao],
            [ngay_sua],
            [trang_thai]
        FROM [dbo].[Thanh_Toan]
    """;

    try (Connection con = JdbcHelper.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        List<ThanhToan> listTT = new ArrayList<>();
        while (rs.next()) {
            ThanhToan thanhToan = new ThanhToan();
            thanhToan.setMaThanhToan(rs.getString("ma"));
            thanhToan.setPhuongThucTT(rs.getString("phuong_thuc_thanh_toan"));
            thanhToan.setSoTien(rs.getBigDecimal("tien_thanh_toan"));
            thanhToan.setNgayTT(rs.getDate("ngay_thanh_toan"));
            thanhToan.setNgayTao(rs.getDate("ngay_tao"));
            thanhToan.setNgaySua(rs.getDate("ngay_sua"));
            thanhToan.setTrangThai(rs.getBoolean("trang_thai"));

            listTT.add(thanhToan);
        }
        return listTT;

    } catch (Exception e) {
        // Log the exception or rethrow it as a runtime exception
        throw new RuntimeException("Error retrieving payments", e);
    }
}

}
