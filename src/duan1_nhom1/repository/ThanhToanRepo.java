/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.repository;

import duan1_nhom1.model.ThanhToan;
import duan1_nhom1.utils.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WEB
 */
public class ThanhToanRepo {
    private List<ThanhToan>litsThanhToan=new ArrayList<>();
    private List<ThanhToan> getAll() {
        String sql = """
             SELECT 
                        ,[ma]
                        ,[phuong_thuc_thanh_toan]
                        ,[tien_thanh_toan]
                        ,[ngay_thanh_toan]
                        ,[ngay_tao]
                        ,[ngay_sua]
                        ,[trang_thai]
                    FROM [dbo].[Thanh_Toan];
            """;
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<ThanhToan> thanhToan = new ArrayList<>();
            while (rs.next()) {
                ThanhToan tt = new ThanhToan();
                tt.setMaThanhToan(rs.getString(1));
                tt.setPhuongThucTT(rs.getString(2));
                tt.setSoTien(rs.getBigDecimal(3));
                tt.setNgayTT(rs.getDate(4));
                tt.setNgayTao(rs.getDate(5));
                tt.setNgaySua(rs.getDate(6));
                tt.setTrangThai(rs.getBoolean(7));

                thanhToan.add(tt);
            }
            return thanhToan;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addThanhToan(ThanhToan thanhToan) {
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
        int check = 0;
        try (Connection con = DBconnect.getConnection(); PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, thanhToan.getMaThanhToan());
            stm.setString(2, thanhToan.getPhuongThucTT());
            stm.setString(3, thanhToan.getSoTien().toString());
            stm.setDate(4, thanhToan.getNgayTT());
            stm.setDate(5, thanhToan.getNgayTao());
            stm.setDate(6, thanhToan.getNgaySua());
            stm.setBoolean(7, thanhToan.getTrangThai());
            check = stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return check > 0;
    }
    public Boolean updateThanhToan(ThanhToan tt) {
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
        int chek = 0;
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, tt.getMaThanhToan());
            ps.setObject(2, tt.getPhuongThucTT());
            ps.setObject(3, tt.getNgayTT());
            ps.setObject(4, tt.getNgayTao());
            ps.setObject(5, tt.getNgaySua());
            ps.setObject(6, tt.getTrangThai());
            ps.setObject(7, tt.getId());
            chek = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return chek > 0;
    }

    public Boolean deleteThanhToan(String ma) {
        String sql = """
         DELETE FROM [dbo].[Thanh_Toan]
                    WHERE id=?;
            """;
        int chek = 0;
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ma);
            chek = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return chek > 0;
    }
}
