/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.dto.HoaDonDto;
import duan1_nhom1.model.HoaDon;
import duan1_nhom1.repository.HoaDonRepository;
import duan1_nhom1.tranf.TranferData;
import duan1_nhom1.utils.JdbcHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 1
 *
 * @author maccuacu
 */
public class HoaDonService implements IService<HoaDonDto> {

    HoaDonRepository repo = new HoaDonRepository();

    @Override
    public void add(HoaDonDto t) {
        this.repo.createHoaDon(TranferData.convertToEntity(t));
    }

    public List<HoaDonDto> getAllHD() {
        return TranferData.convertListHoaDonToDto(this.repo.getAllHoaDonStatus());
    }

    @Override
    public List<HoaDonDto> getAll() {

        return TranferData.convertListHoaDonToDto(this.repo.getAllHoaDon());
    }

    @Override
    public void update(HoaDonDto t, String id) {
        this.repo.updateHoaDon(TranferData.convertToEntity(t));
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HoaDonDto findById(String id) {
        return TranferData.convertToDto(repo.getHoaDonById(id));
    }

    public List<HoaDon> searhListNhanVien(String maKhach) {
        String sql = """
            DECLARE @maKhach NVARCHAR(255)
                   SET @maKhach =?
                  select Hoa_Don.ma,Hoa_Don.ngay_mua,Hoa_Don.tong_tien,Hoa_Don.ngay_tao,Hoa_Don.trang_thai
                   from Hoa_Don join Khach_Hang on Hoa_Don.id_kh= Khach_Hang.id
                  WHERE (Khach_Hang.ma LIKE '%' + @maKhach + '%' OR @maKhach IS NULL);
            """;
        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maKhach);
            ResultSet rs = ps.executeQuery();
            List<HoaDon> hoadon = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setId(rs.getString(1));
                hd.setIdKhachHang(rs.getString(2));
                hd.setMa(rs.getString(3));
                hd.setIdNv(rs.getString(4));
                hd.setNgayMua(rs.getDate(5));
                hd.setTongTien(rs.getDouble(6));
                hd.setNgayTao(rs.getDate(7));
                hd.setNgaySua(rs.getDate(8));
                hd.setTrangThai(rs.getBoolean(9));
                hoadon.add(hd);
            }
            return hoadon;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public HoaDonDto findByMa(String ma) {
        return TranferData.convertToDto(repo.getHoaDonByMa(ma));
    }

}
