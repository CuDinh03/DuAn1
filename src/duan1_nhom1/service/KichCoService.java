/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.model.KichThuoc;
import duan1_nhom1.model.MauSac;
import duan1_nhom1.repository.KichThuocRepository;
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
public class KichCoService implements IService<KichThuoc>{
    
    private KichThuocRepository KichThuocRepository = new KichThuocRepository();

    @Override
    public void add(KichThuoc kichThuoc) {
        KichThuocRepository.add(kichThuoc);
    }

    @Override
    public void update(KichThuoc kichThuoc, String id) {
       KichThuocRepository.update(kichThuoc);
    }

    @Override
    public void delete(String id) {
        KichThuocRepository.delete(id);
    }

    @Override
    public List<KichThuoc> getAll() {
        return KichThuocRepository.getAll();
    }

    @Override
    public KichThuoc findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
      public String getTenById(String id) {
        return KichThuocRepository.getTenById(id);
    }
    
   
    public List<String> getAllTen() {
        return KichThuocRepository.getAllTen();
    }
    
    public List<String> getAllId() {
        return KichThuocRepository.getAllId();
    }
    
    public List<KichThuoc> timKiem(String ma, String ten) {
        String sql = """
                 SELECT [ma]
                        ,[ten]
                        ,[mo_ta]
                        ,[ngay_tao]
                        ,[ngay_sua]
                        ,[trang_thai]
                   FROM [dbo].[size_ao]
                   WHERE [ma] = ? OR [ten] = ?;
                 """;

        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setObject(1, ma);
            ps.setObject(2, ten);

            try (ResultSet rs = ps.executeQuery()) {
                List<KichThuoc> list = new ArrayList<>();
                while (rs.next()) {
                    KichThuoc kt = new KichThuoc();
                    kt.setMa(rs.getString(1));
                    kt.setTen(rs.getString(2));
                    kt.setMoTa(rs.getString(3));
                    kt.setNgayTao(rs.getDate(4));
                    kt.setNgaySua(rs.getDate(5));
                    kt.setTrangThai(rs.getBoolean(6));
                    list.add(kt);
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
