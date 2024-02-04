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

}
