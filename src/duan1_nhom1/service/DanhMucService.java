/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.dto.DanhMucDto;
import duan1_nhom1.model.DanhMuc;
import duan1_nhom1.model.Hang;
import duan1_nhom1.repository.DanhMucRepository;
import duan1_nhom1.tranf.TranferData;
import duan1_nhom1.utils.JdbcHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**1
 *
 * @author anhtuanle
 */
public class DanhMucService implements IService<DanhMuc> {

    DanhMucRepository danhMucRepository = new DanhMucRepository();

    @Override
    public void add(DanhMuc t) {
       danhMucRepository.addDanhMuc(t);
    }

    @Override
    public List<DanhMuc> getAll() {
         return danhMucRepository.getAll();
    }

    public String getTenById(String id) {
        return danhMucRepository.getTenById(id);
    }

    public List<String> getAllTen() {
        return danhMucRepository.getAllTen();
    }

    public List<String> getAllId() {
        return danhMucRepository.getAllId();
    }

    @Override
    public void update(DanhMuc danhMuc, String id) {
        danhMucRepository.update(danhMuc, id);}

    @Override
    public void delete(String id) {
        danhMucRepository.delete(id);}
    @Override
    public DanhMuc findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
      
    public List<DanhMuc> timKiem(String ma, String ten) {
        String sql = """
                 SELECT [ma]
                        ,[ten]
                        ,[mo_ta]
                        ,[ngay_tao]
                        ,[ngay_sua]
                        ,[trang_thai]
                   FROM [dbo].[danh_muc_san_pham]
                   WHERE [ma] = ? OR [ten] = ?;
                 """;

        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setObject(1, ma);
            ps.setObject(2, ten);

            try (ResultSet rs = ps.executeQuery()) {
                List<DanhMuc> list = new ArrayList<>();
                while (rs.next()) {
                    DanhMuc dm = new DanhMuc();
                    dm.setMa(rs.getString(1));
                    dm.setTen(rs.getString(2));
                    dm.setMoTa(rs.getString(3));
                    dm.setNgayTao(rs.getDate(4));
                    dm.setNgaySua(rs.getDate(5));
                    dm.setTrangThai(rs.getBoolean(6));
                    list.add(dm);
                }
                return list;
            }

        } catch (Exception e) {
            // Log the exception using a logging framework like log4j or slf4j
            e.printStackTrace();
        }
        return null;
    }
    

}
