package duan1_nhom1.service;

import duan1_nhom1.model.HoaDon;
import duan1_nhom1.model.Khach;
import duan1_nhom1.repository.KhachRepo;
import duan1_nhom1.utils.JdbcHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KhachService implements IService<Khach> {

    private List<Khach> listKhach = new ArrayList<>();
    private KhachRepo khachHangRepo = new KhachRepo();

    @Override
    public void add(Khach khachhang) {
        khachHangRepo.addKhachHang(khachhang);
    }

    @Override
    public void update(Khach kh, String id) {
        khachHangRepo.updateKhachHang(kh, id);
    }

    @Override
    public void delete(String id) {
        khachHangRepo.deleteKhach(id);
    }

    @Override
    public Khach findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Khach> getAll() {
        return khachHangRepo.getAll();
    }

    public List<Khach> timKiem(String ma, String ten, String sdt) {
        String sql = """
                 SELECT [ma]
                        ,[ten]
                        ,[sdt]
                        ,[ngay_tao]
                        ,[ngay_sua]
                        ,[trang_thai]
                   FROM [dbo].[Khach_Hang]
                   WHERE [ma] = ? OR [ten] = ? OR [sdt] = ?;
                 """;

        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setObject(1, ma);
            ps.setObject(2, ten);
            ps.setObject(3, sdt);

            try (ResultSet rs = ps.executeQuery()) {
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
            }

        } catch (Exception e) {
            // Log the exception using a logging framework like log4j or slf4j
            e.printStackTrace();
        }
        return null;
    }

    public List<Khach> locKhach(Boolean trangThai) {
        String sql = """
                 SELECT *
                 FROM Khach_Hang
                 WHERE (trang_thai = ? OR ? IS NULL);
                 """;

        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setObject(1, trangThai);
            ps.setObject(2, trangThai);
            try (ResultSet rs = ps.executeQuery()) {
                List<Khach> list = new ArrayList<>();
                while (rs.next()) {
                    Khach kh = new Khach();
                    kh.setId(rs.getString(1));
                    kh.setMaKhachHang(rs.getString(2));
                    kh.setTenKhachHang(rs.getString(3));
                    kh.setSdt(rs.getString(4));
                    kh.setNgayTao(rs.getDate(5));
                    kh.setNgaySua(rs.getDate(6));
                    kh.setTrangThai(rs.getBoolean(7));
                    list.add(kh);
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
