/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.repository;

import duan1_nhom1.model.TaiKhoan;
import duan1_nhom1.utils.JdbcHelper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WEB
 */
public class TaiKhoanRepo {

    private List<TaiKhoan> listTK = new ArrayList<>();

    public void addKhachHang(TaiKhoan taiKhoan) {
//        if (taiKhoan == null) {
//            return;
//        }

        String sql = """
       INSERT INTO [dbo].[tai_khoan]
                    ([ma]
                    ,[ten_dang_nhap]
                    ,[mat_khau]
                     ,[ngay_tao]
                    ,[ngay_sua]
                    ,[trang_thai])
              VALUES
                    (?
                    ,?
                    ,?
                    ,?
                    ,?
                    ,?);  
                 """;

        try (Connection con = JdbcHelper.getConnection(); PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, taiKhoan.getMa());
            stm.setString(2, taiKhoan.getTenDangNhap());
            stm.setString(3, taiKhoan.getMatKhau());
            stm.setDate(4, (Date) taiKhoan.getNgayTao());
            stm.setDate(5, (Date) taiKhoan.getNgaySua());
            stm.setBoolean(6, taiKhoan.getTrangThai());

            int chek = stm.executeUpdate();

            if (chek > 0) {
                System.out.println("KhachHang Đã thêm thành công ");
            } else {
                System.out.println("Thêm thất bại ");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateTaiKhoan(TaiKhoan tk, String id) {

        String sql = """
                UPDATE [dbo].[Khach_Hang]
                SET [ma] = ?,
                    [ten] = ?,
                    [sdt] = ?,
                    [ngay_tao] = ?,
                    [ngay_sua] = ?,
                    [trang_thai] = ?
                WHERE id = ?;
                """;

        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            // Set parameters
            ps.setObject(1, tk.getMa());
            ps.setObject(2, tk.getTenDangNhap());
            ps.setObject(3, tk.getMatKhau());
            ps.setObject(4, tk.getNgayTao());
            ps.setObject(5, tk.getNgaySua());
            ps.setObject(6, tk.getTrangThai());
            ps.setObject(7, tk.getId());
            ps.setObject(7, id);
            // Execute the update
            int chek = ps.executeUpdate();

            // Check the result
            if (chek > 0) {
                System.out.println("update   thành công ");
            } else {
                System.out.println("update thất bại  ");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error updating KhachHang.", e);
        }

    }

    public void deleteTaiKhoan(String id) {
        String sql = """
         DELETE FROM [dbo].[Khach_Hang]
                    WHERE id=?;
            """;

        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            int chek = ps.executeUpdate();

            if (chek > 0) {
                System.out.println("Xóa  thành công ");
            } else {
                System.out.println("Xóa  thất bại ");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<TaiKhoan> getAll() {
        String sql = """
              SELECT [id]
                    ,[ma]
                    ,[ten_dang_nhap]
                    ,[mat_khau]
                    ,[id_chuc_vu]
                    ,[ngay_tao]
                    ,[ngay_sua]
                    ,[trang_thai]
                FROM [dbo].[tai_khoan];
            """;
        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<TaiKhoan> taiKhoan = new ArrayList<>();
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setId(rs.getString(1));
                tk.setMa(rs.getString(2));
                tk.setTenDangNhap(rs.getString(3));
                tk.setMatKhau(rs.getString(4));
                tk.setIdCV(rs.getString(5));
                tk.setNgayTao(rs.getDate(6));
                tk.setNgaySua(rs.getDate(7));
                tk.setTrangThai(rs.getBoolean(8));
                taiKhoan.add(tk);
            }
            return taiKhoan;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public TaiKhoan getTaiKhoan(String ma) {
        String query = """
                       select * from tai_khoan  where tai_khoan.ten_dang_nhap=?;
                       """;
        TaiKhoan tk = new TaiKhoan();
        try (Connection con = JdbcHelper.getConnection(); PreparedStatement stm = con.prepareStatement(query)) {
            stm.setString(1, ma);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                tk.setId(rs.getString(1));
                tk.setId(rs.getString(1));
                tk.setMa(rs.getString(2));
                tk.setTenDangNhap(rs.getString(3));
                tk.setMatKhau(rs.getString(4));
                tk.setIdCV(rs.getString(5));
                tk.setNgayTao(rs.getDate(6));
                tk.setNgaySua(rs.getDate(7));
                tk.setTrangThai(rs.getBoolean(8));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return tk;
    }
}
