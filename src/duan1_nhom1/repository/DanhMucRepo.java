/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.repository;

import com.sun.jdi.connect.spi.Connection;
import duan1_nhom1.model.DanhMuc;
import duan1_nhom1.utils.JdbcHelper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author bachh
 */
public class DanhMucRepo {
    private final Connection connection = JdbcHelper.getConnection();
    
    public void createDanhMuc (DanhMuc danhMuc){
        try {
            String query = """
                    INSERT INTO [dbo].[danh_muc_san_pham]
                               ([id]
                               ,[ma]
                               ,[ten]
                               ,[mo_ta]
                               ,[ngay_tao]
                               ,[ngay_sua]
                               ,[trang_thai])
                         VALUES
                               ?
                               ,?
                               ,?
                               ,?
                               ,?
                               ,?
                               ,?
                    """;
            try (PreparedStatement prepareStatement = connection.prepareStatement(query){
                prepareStatement.setObject(1, danhMuc.getId());
                prepareStatement.setObject(2, danhMuc.getMa());
                prepareStatement.setObject(3, danhMuc.getTen());
                prepareStatement.setObject(4, new java.sql.Date(danhMuc.getNgayTao().getTime()));
                prepareStatement.setObject(4, new java.sql.Date(danhMuc.getNgaySua().getTime()));
                
                prepareStatement.executeUpdate();
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
    }
}
