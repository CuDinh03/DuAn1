/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.repository;

import duan1_nhom1.model.MauSac;
import duan1_nhom1.utils.JdbcHelper;
import duan1_nhom1.viewModel.QLSanPhamViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author anhtuanle
 */
public class SPChiTietRepository {

    private JdbcHelper jdbcHelper;
    List<QLSanPhamViewModel> listSanPham = new ArrayList();
    Connection conn = JdbcHelper.getConnection();

    public List<QLSanPhamViewModel> getAll() {

        String sql = "SELECT spct.id AS ma_san_pham, sp.ten AS ten_san_pham, h.ten AS ten_hang, cl.ten AS ten_chat_lieu, ms.ten AS ten_mau_sac, size.ten AS ten_kich_co, dm.ten AS ten_danh_muc, spct.gia_nhap, spct.gia_ban, spct.so_luong, spct.ngay_nhap, spct.ngay_sua, spct.ngay_tao, spct.trang_thai\n"
                + "FROM san_pham_chi_tiet spct\n"
                + "JOIN Hang h ON spct.id_hang = h.id\n"
                + "JOIN chat_lieu cl ON spct.id_cl = cl.id\n"
                + "JOIN mau_sac ms ON spct.id_ms = ms.id\n"
                + "JOIN Size_ao size ON spct.id_size = size.id\n"
                + "JOIN danh_muc_san_pham dm ON spct.id_dm = dm.id\n"
                + "JOIN san_pham sp ON spct.id_sp = sp.id;";

        try {
            PreparedStatement pr = conn.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                QLSanPhamViewModel qLSanPhamViewModel = new QLSanPhamViewModel();
                qLSanPhamViewModel.setMaSP(rs.getString("ma_san_pham"));
                qLSanPhamViewModel.setTenSP(rs.getString("ten_san_pham"));
                qLSanPhamViewModel.setThuongHieu(rs.getString("ten_hang"));
                qLSanPhamViewModel.setChatLieu(rs.getString("ten_chat_lieu"));
                qLSanPhamViewModel.setMauSac(rs.getString("ten_mau_sac"));
                qLSanPhamViewModel.setKichThuoc(rs.getString("ten_kich_co"));
                qLSanPhamViewModel.setDanhMuc(rs.getString("ten_danh_muc"));
                qLSanPhamViewModel.setGiaNhap(rs.getBigDecimal("gia_nhap"));
                qLSanPhamViewModel.setGiaBan(rs.getBigDecimal("gia_ban"));
                qLSanPhamViewModel.setSoLuong(rs.getInt("so_luong"));
                qLSanPhamViewModel.setNgayNhap(rs.getDate("ngay_nhap"));
                qLSanPhamViewModel.setNgaySua(rs.getDate("ngay_sua"));
                qLSanPhamViewModel.setNgayTao(rs.getDate("ngay_tao"));
                qLSanPhamViewModel.setTrangThai(rs.getInt("trang_thai"));

                listSanPham.add(qLSanPhamViewModel);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi kết nối");
            ex.printStackTrace();
        }
        return listSanPham;
    }

    public boolean insert(QLSanPhamViewModel domainModel) {
        String sql = "INSERT INTO san_pham_chi_tiet \n"
                + "    (id_hang, id_ms, id_cl, id_size, id_anh, id_dm, id_sp, gia_ban, gia_nhap, so_luong, ngay_nhap, ngay_tao, ngay_sua, trang_thai) \n"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, domainModel.getMaSP());
            ps.setString(2, domainModel.getTenSP());
            ps.setString(3, domainModel.getThuongHieu());
            ps.setString(4, domainModel.getMauSac());
            ps.setString(5, domainModel.getChatLieu());
            ps.setString(6, domainModel.getDanhMuc());
            ps.setString(7, domainModel.getKichThuoc());
            ps.setInt(8, domainModel.getSoLuong());
            ps.setBigDecimal(9, domainModel.getGiaNhap());
            ps.setBigDecimal(10, domainModel.getGiaBan());
            ps.setDate(11, new java.sql.Date(domainModel.getNgayNhap().getTime()));
            ps.setDate(12, new java.sql.Date(domainModel.getNgaySua().getTime()));
            ps.setDate(13, new java.sql.Date(domainModel.getNgayTao().getTime()));
            ps.setInt(14, domainModel.getTrangThai());
            

            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
