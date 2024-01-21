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

/**
 *
 * @author bachh
 */
public class DanhMucRepo {
    
    public List<DanhMuc> getAllDanhMuc(){
        
            String query = """
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
            PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<DanhMuc> list = new ArrayList<>();
            while (rs.next()) {
                DanhMuc dm = new DanhMuc();
                dm.setMa(rs.getString(2));
                dm.setTen(rs.getString(3));
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
        String sqlInsert = """
                     INSERT INTO [dbo].[danh_muc_san_pham]
                                ([id]
                                ,[ma]
                                ,[ten]
                                ,[mo_ta]
                                ,[ngay_tao]
                                ,[ngay_sua]
                                ,[trang_thai])
                          VALUES
                                ?,?,?,?,?,?,?                            
                     """;
        try ( java.sql.Connection con = DBConnect.getConnection("AsmGD2d");  PreparedStatement ps = con.prepareStatement(sqlInsert);) {
            ps.setString(2, dm.getMa());
            ps.setString(3, dm.getTen());
            ps.setString(4, dm.getMoTa());
            ps.setDate(5, (Date) dm.getNgayTao());
            ps.setDate(6, (Date) dm.getNgaySua());
            check = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check > 0;   
    }

    public Object add(DanhMuc dataDanhMuc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
