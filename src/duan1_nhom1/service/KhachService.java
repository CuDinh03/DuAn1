/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.model.Khach;
import duan1_nhom1.repository.KhachRepo;
import duan1_nhom1.utils.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author WEB
 */
public class KhachService implements IService<Khach>{
    private List<Khach> listKhach = new ArrayList<>();
    private KhachRepo khachHangRepo = new KhachRepo();

    @Override
    public void add(Khach khachhang) {
        khachHangRepo.addKhachHang(khachhang);
    }

    @Override
    public void update(Khach kh, UUID id) {
      khachHangRepo.updateKhachHang(kh);
    }

    @Override
    public void delete(UUID id) {
     khachHangRepo.deleteNhanVien(id);
    }



    @Override
    public Khach findById(UUID id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Khach> getAll() {
     return khachHangRepo.getAll();
    }
public List<Khach> timKiem(String ma, String ten,String sdt,Boolean trangThai) {
        String sql = """
                    SELECT [ma]
                           ,[ten]
                           ,[sdt]
                           ,[ngay_tao]
                           ,[ngay_sua]
                           ,[trang_thai]
                       FROM [dbo].[Khach_Hang]
                       where [ma] = ? or  [ten] = ? or[sdt]=? or [trang_thai]=? ;
                     """;
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ma);
            ps.setObject(2, ten);
            ps.setObject(3, sdt);
            ps.setObject(4, trangThai);
            ResultSet rs = ps.executeQuery();
            List<Khach> list = new ArrayList<>();
            while (rs.next()) {
                Khach kh = new Khach();
                kh.setMaKhachHang(rs.getString(1));
                kh.setTenKhachHang(rs.getString(2));
                kh.setSdt(rs.getString(3));
                kh.setNgayTao(rs.getDate(4));
                kh.setNgaySua(rs.getDate(5));
                kh.setTrangThai(rs.getBoolean(6));
                list.add(kh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
   
}
