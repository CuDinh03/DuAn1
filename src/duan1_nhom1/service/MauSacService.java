/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.model.MauSac;
import duan1_nhom1.model.SanPham;
import duan1_nhom1.repository.MauSacRepository;
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
public class MauSacService implements IService<MauSac>{
    
    private MauSacRepository mauSacRepository;
    
    public MauSacService(){
        mauSacRepository = new MauSacRepository();
    }

    @Override
    public void add(MauSac mauSac) {
        mauSacRepository.insert(mauSac);
    }

    @Override
    public void update(MauSac mauSac, String id) {
        mauSacRepository.update(mauSac, id);
    }

    @Override
    public void delete(String id) {
        mauSacRepository.delete(id);
    }

    @Override
    public List<MauSac> getAll() {
       return mauSacRepository.getAll();
    }

    @Override
    public MauSac findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     public String getTenById(String id) {
        return mauSacRepository.getTenById(id);
    }
    
   
    public List<String> getAllTen() {
        return mauSacRepository.getAllTen();
    }
    
    public List<String> getAllId() {
        return mauSacRepository.getAllId();
    }
    
    public List<MauSac> timKiem(String ma, String ten) {
        String sql = """
                 SELECT [ma]
                        ,[ten]
                        ,[mo_ta]
                        ,[ngay_tao]
                        ,[ngay_sua]
                        ,[trang_thai]
                   FROM [dbo].[mau_sac]
                   WHERE [ma] = ? OR [ten] = ?;
                 """;

        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setObject(1, ma);
            ps.setObject(2, ten);

            try (ResultSet rs = ps.executeQuery()) {
                List<MauSac> list = new ArrayList<>();
                while (rs.next()) {
                    MauSac ms = new MauSac();
                    ms.setMa(rs.getString(1));
                    ms.setTen(rs.getString(2));
                    ms.setMoTa(rs.getString(3));
                    ms.setNgayTao(rs.getDate(4));
                    ms.setNgaySua(rs.getDate(5));
                    ms.setTrangThai(rs.getBoolean(6));
                    list.add(ms);
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
