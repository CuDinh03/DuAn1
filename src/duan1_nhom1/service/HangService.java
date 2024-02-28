/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.model.Hang;
import duan1_nhom1.model.KichThuoc;
import duan1_nhom1.repository.HangRepository;
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
public class HangService implements IService<Hang>{
    private HangRepository hangRepository;
    
    public HangService(){
        hangRepository = new HangRepository();
    }
    @Override
    public void add(Hang t) {
        hangRepository.addNew(t);
    }

    @Override
    public void update(Hang t, String id) {
        hangRepository.update(t,id);
    }

    @Override
    public void delete(String id) {
        hangRepository.delete(id);
    }

    @Override
    public List<Hang> getAll() {
        return hangRepository.getAll();
    }

    @Override
    public Hang findById(String hangId) {
        return hangRepository.findById(hangId);
    }
    
    public String getTenById(String id) {
        return hangRepository.getTenById(id);
    }
    
   
    public List<String> getAllTen() {
        return hangRepository.getAllTen();
    }
    
    public List<String> getAllId() {
        return hangRepository.getAllId();
    }
    
     
    public List<Hang> timKiem(String ma, String ten) {
        String sql = """
                 SELECT [ma]
                        ,[ten]
                        ,[mo_ta]
                        ,[ngay_tao]
                        ,[ngay_sua]
                        ,[trang_thai]
                   FROM [dbo].[hang]
                   WHERE [ma] = ? OR [ten] = ?;
                 """;

        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setObject(1, ma);
            ps.setObject(2, ten);

            try (ResultSet rs = ps.executeQuery()) {
                List<Hang> list = new ArrayList<>();
                while (rs.next()) {
                    Hang hang = new Hang();
                    hang.setMa(rs.getString(1));
                    hang.setTen(rs.getString(2));
                    hang.setMoTa(rs.getString(3));
                    hang.setNgayTao(rs.getDate(4));
                    hang.setNgaySua(rs.getDate(5));
                    hang.setTrangThai(rs.getBoolean(6));
                    list.add(hang);
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
