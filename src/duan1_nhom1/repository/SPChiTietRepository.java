/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.repository;

import duan1_nhom1.model.MauSac;
import duan1_nhom1.utils.JdbcHelper;
import duan1_nhom1.viewModel.QLSanPhamViewModel;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author anhtuanle
 */
public class SPChiTietRepository {

    private JdbcHelper jdbcHelper;
    List<QLSanPhamViewModel> listSanPham = new ArrayList();
    Connection conn = JdbcHelper.getConnection();

    public List<QLSanPhamViewModel> getAll() {

        String sql = "SELECT spct.id AS ma_san_pham, sp.ten AS ten_san_pham, h.id AS id_hang, cl.id AS id_cl, ms.id AS id_ms, size.id AS id_size, dm.id AS id_dm, spct.gia_nhap, spct.gia_ban, spct.so_luong, spct.ngay_nhap, spct.ngay_sua, spct.ngay_tao, spct.trang_thai\n"
                + "FROM san_pham_chi_tiet spct\n"
                + "JOIN Hang h ON spct.id_hang = h.id\n"
                + "JOIN chat_lieu cl ON spct.id_cl = cl.id\n"
                + "JOIN mau_sac ms ON spct.id_ms = ms.id\n"
                + "JOIN Size_ao size ON spct.id_size = size.id\n"
                + "JOIN danh_muc_san_pham dm ON spct.id_dm = dm.id\n"
                + "JOIN san_pham sp ON spct.id_sp = sp.id;";

        try {
            PreparedStatement pr = conn.prepareStatement(sql);
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {
                String maSP = resultSet.getString("ma_san_pham");
                String tenSP = resultSet.getString("ten_san_pham");
                String idHangString = resultSet.getString("id_hang");
                UUID idHang = UUID.fromString(idHangString);

                String idClString = resultSet.getString("id_cl");
                UUID idCl = UUID.fromString(idClString);

                String idMsString = resultSet.getString("id_ms");
                UUID idMs = UUID.fromString(idMsString);

                String idSizeString = resultSet.getString("id_size");
                UUID idSize = UUID.fromString(idSizeString);

                String idDmString = resultSet.getString("id_dm");
                UUID idDm = UUID.fromString(idDmString);

                BigDecimal giaNhap = resultSet.getBigDecimal("gia_nhap");
                BigDecimal giaBan = resultSet.getBigDecimal("gia_ban");
                int soLuong = resultSet.getInt("so_luong");
                Date ngayNhap = resultSet.getDate("ngay_nhap");
                Date ngayTao = resultSet.getDate("ngay_tao");
                Date ngaySua = resultSet.getDate("ngay_sua");
                boolean trangThai = resultSet.getBoolean("trang_thai");

                QLSanPhamViewModel qLSanPhamViewModel = new QLSanPhamViewModel(maSP, tenSP, idSize, idHang, idMs, idCl, idDm, giaNhap, giaBan, soLuong, ngayTao, ngaySua, ngayNhap, trangThai);

                listSanPham.add(qLSanPhamViewModel);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi kết nối");
            ex.printStackTrace();
        }
        return listSanPham;
    }

    public boolean insert(QLSanPhamViewModel sanPham) {
        String sql = "INSERT INTO san_pham_chi_tiet \n"
                + "    (ma_sp, ten_sp, id_hang, id_cl, id_ms, id_size, id_dm, gia_nhap, gia_ban, so_luong, ngay_nhap, ngay_tao, ngay_sua, trang_thai) \n"
                + "VALUES \n"
                + "    (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, sanPham.getMaSP());
            ps.setString(2, sanPham.getTenSP());
            ps.setObject(3, sanPham.getIdThuongHieu());
            ps.setObject(4, sanPham.getIdChatLieu());
            ps.setObject(5, sanPham.getIdMauSac());
            ps.setObject(6, sanPham.getIdKichThuoc());
            ps.setObject(7, sanPham.getIdDanhMuc());
            ps.setBigDecimal(8, sanPham.getGiaNhap());
            ps.setBigDecimal(9, sanPham.getGiaBan());
            ps.setInt(10, sanPham.getSoLuong());
            ps.setDate(11, new java.sql.Date(sanPham.getNgayNhap().getTime()));
            ps.setDate(12, new java.sql.Date(sanPham.getNgaySua().getTime()));
            ps.setDate(13, new java.sql.Date(sanPham.getNgayTao().getTime()));
            ps.setBoolean(14, sanPham.isTrangThai());

            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
