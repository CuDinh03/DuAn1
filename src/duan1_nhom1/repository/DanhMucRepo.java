/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.repository;

import com.sun.jdi.connect.spi.Connection;
import duan1_nhom1.model.DanhMuc;
import duan1_nhom1.utils.DBConnect;
import duan1_nhom1.utils.JdbcHelper;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author bachh
 */
public class DanhMucRepo {
    
    public List<DanhMuc> getAllDanhMuc(){
        
            String sql = """
                    SELECT [id]
                          ,[ma]
                          ,[ten]
                          ,[mo_ta]
                          ,[ngay_tao]
                          ,[ngay_sua]
                          ,[trang_thai]
                      FROM [dbo].[danh_muc_san_pham]
                    """;
            try ( java.sql.Connection con = DBConnect.getConnection("PRO1041_Duan1"); 
            PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<DanhMuc> list = new ArrayList<>();
            while (rs.next()) {
                DanhMuc dm = new DanhMuc();
                UUID id = UUID.fromString((String)rs.getObject("id"));
                dm.setId(rs.getString(1));
                dm.setMa(rs.getString(2));
                dm.setTen(rs.getString(3));
                dm.setMoTa(rs.getString(4));
                dm.setNgayTao(rs.getDate(5));
                dm.setNgaySua(rs.getDate(6));
                list.add(dm);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean addDanhMuc(DanhMuc dm) {
        int check = 0;
        String sql = """
                     INSERT INTO [dbo].[danh_muc_san_pham]
                                ([id]
                                ,[ma]
                                ,[ten]
                                ,[mo_ta]
                                ,[ngay_tao]
                                ,[ngay_sua]
                                ,[trang_thai])
                          VALUES
                                (?,?,?,?,?,?,? )                           
                     """;
        try ( java.sql.Connection con = DBConnect.getConnection("PRO1041_Duan1");  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, dm.getId());
            ps.setObject(2, dm.getMa());
            ps.setObject(3, dm.getTen());
            ps.setObject(4, dm.getMoTa());
            ps.setObject(5, dm.getNgayTao());
            ps.setObject(6, dm.getNgaySua());
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return check > 0;   
    }
    public boolean updateDanhMuc(DanhMuc dm, String id) {
        int check = 0;
        String sql = """
                    UPDATE [dbo].[danh_muc_san_pham]
                       SET [id] = ?
                          ,[ma] = ?
                          ,[ten] = ?
                          ,[mo_ta] = ?
                          ,[ngay_tao] = ?
                          ,[ngay_sua] = ?
                          ,[trang_thai] = ?
                     WHERE id = ?
                     """;
        try (java.sql.Connection con = DBConnect.getConnection("PRO1041_Duan1");  PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setObject(1, dm.getId());
            ps.setObject(2, dm.getMa());
            ps.setObject(3, dm.getTen());
            ps.setObject(4, dm.getMoTa());
            ps.setObject(5, dm.getNgayTao());
            ps.setObject(6, dm.getNgaySua());
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return check > 0;
    }
    public boolean deleteDanhMuc(String id) {
        int check = 0;
        String sql = """
                     DELETE FROM [dbo].[danh_muc_san_pham]
                           WHERE id = ?
                     """;
        try ( java.sql.Connection con = DBConnect.getConnection("PRO1041_Duan1");  
                PreparedStatement ps = con.prepareStatement(sql)
                ) {
            ps.setObject(1, id);
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return check > 0;
    }

    public Object updateDanhMuc(DanhMuc dataDanhMuc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
