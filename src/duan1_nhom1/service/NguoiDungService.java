/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.model.NguoiDung;
import duan1_nhom1.repository.NguoiDungRepo;
import duan1_nhom1.utils.JdbcHelper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.Connection;

/**
 *
 * @author acer
 */
public class NguoiDungService implements IService<NguoiDung> {

    private List<NguoiDung> listND = new ArrayList<>();
    private NguoiDungRepo NguoiDungRepo = new NguoiDungRepo();

    @Override
    public void add(NguoiDung t) {
        NguoiDungRepo.addNguoiDung(t);
    }

    @Override
    public void update(NguoiDung t, String id) {
        NguoiDungRepo.updateNguoiDung(t, id);
    }

    @Override
    public void delete(String id) {
        NguoiDungRepo.deleteNguoiDung(id);
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<NguoiDung> getAll() {
        return NguoiDungRepo.getAll();
    }

    @Override
    public NguoiDung findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<NguoiDung> timKiem(String ma) {
        String sql = """
                   SELECT [ten]
                             ,[dia_chi]
                             ,[sdt]
                             ,[id_cv]
                             ,[ngay_bd]
                             ,[ngay_tao]
                             ,[ngay_sua]
                             ,[trang_thai]
                         FROM [dbo].[Nguoi_Dung] where ten=?;
                     """;
        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            List<NguoiDung> list = new ArrayList<>();
            while (rs.next()) {
                NguoiDung kh = new NguoiDung();
                kh.setTen(rs.getString(1));
                kh.setDiaChi(rs.getString(2));
                kh.setSdt(rs.getString(3));
                kh.setNgayBD(rs.getDate(4));
                kh.setNgayTao(rs.getDate(5));
                kh.setNgaySua(rs.getDate(6));
             kh.setTrangThai(rs.getBoolean(4));
                list.add(kh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
