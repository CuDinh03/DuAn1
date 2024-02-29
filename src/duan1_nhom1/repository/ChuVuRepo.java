/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.repository;

import duan1_nhom1.model.ChucVu;
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
 * @author WEB
 */
public class ChuVuRepo {
     private List<ChucVu> listCV = new ArrayList<>();

    public List<ChucVu> getAll() {
        String sql = """
                 SELECT
                     [id]
                    ,[ma]
                    ,[ten_chuc_vu]
                    ,[ngay_tao]
                    ,[ngay_sua]
                    ,[trang_thai]
                FROM [dbo].[chuc_vu];
            """;
        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<ChucVu> chucVu = new ArrayList<>();
            while (rs.next()) {
                ChucVu tk = new ChucVu();
                tk.setId(rs.getString(1));
                tk.setMa(rs.getString(2));
                tk.setTenCV(rs.getString(3));
                tk.setNgayTao(rs.getDate(4));
                tk.setNgaySua(rs.getDate(5));
                tk.setTrangTai(rs.getBoolean(6));
                chucVu.add(tk);
            }
            return chucVu;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
