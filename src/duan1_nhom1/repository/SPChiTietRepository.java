/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.repository;

import duan1_nhom1.model.ChiTietSanPham;
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


    Connection conn = JdbcHelper.getConnection();

    public List<ChiTietSanPham> getAll() {
        List<ChiTietSanPham> listSanPham = new ArrayList();
        String sql = "SELECT * FROM san_pham_chi_tiet";

        try {
            PreparedStatement pr = conn.prepareStatement(sql);
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {

                String idString = resultSet.getString("id");
                UUID id = UUID.fromString(idString);

                String ma = resultSet.getString("ma");
                String idSPString = resultSet.getString("id_sp");
                UUID idSanPham = UUID.fromString(idSPString);

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

                ChiTietSanPham chiTietSanPham = new ChiTietSanPham(id, ma, idSanPham, idSize, idHang, idMs, idCl, idDm, giaNhap, giaBan, soLuong, ngayTao, ngaySua, ngayNhap, trangThai);
                listSanPham.add(chiTietSanPham);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi kết nối");
            ex.printStackTrace();
        }
        return listSanPham;
    }

    public boolean insert(QLSanPhamViewModel sanPham) {
        String sql = "INSERT INTO san_pham_chi_tiet \n"
                + "    (ma, id_sp, id_hang, id_cl, id_ms, id_size, id_dm, gia_nhap, gia_ban, so_luong, ngay_nhap, ngay_tao, ngay_sua, trang_thai) \n"
                + "VALUES \n"
                + "    (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, sanPham.getMa());
            ps.setObject(2, sanPham.getIdSanPham());
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

    public void delete(UUID id) {
        String sql = "DELETE FROM san_pham_chi_tiet WHERE id = ?";

        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            int chek = ps.executeUpdate();

            if (chek > 0) {
                System.out.println("Xóa thành công ");
            } else {
                System.out.println("Xóa thất bại ");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

   public boolean updateSP(ChiTietSanPham t, UUID id) {
    String sql = """
            UPDATE [dbo].[san_pham_chi_tiet]
            SET [ma] = ?,
                [id_sp] = ?,
                [id_hang] = ?,
                [id_cl] = ?,
                [id_ms] = ?,
                [id_size] = ?,
                [id_dm] = ?,
                [gia_nhap] = ?,
                [gia_ban] = ?,
                [so_luong] = ?,
                [ngay_nhap] = ?,
                [ngay_tao] = ?,
                [ngay_sua] = ?,
                [trang_thai] = ?
            WHERE [id] = ?;
            """;

    try {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1, t.getMa());
        ps.setObject(2, t.getIdSanPham());
        ps.setObject(3, t.getIdThuongHieu());
        ps.setObject(4, t.getIdChatLieu());
        ps.setObject(5, t.getIdMauSac());
        ps.setObject(6, t.getIdKichThuoc());
        ps.setObject(7, t.getIdDanhMuc());
        ps.setBigDecimal(8, t.getGiaNhap());
        ps.setBigDecimal(9, t.getGiaBan());
        ps.setInt(10, t.getSoLuong());
        ps.setDate(11, new java.sql.Date(t.getNgayNhap().getTime()));
        ps.setDate(12, new java.sql.Date(t.getNgaySua().getTime()));
        ps.setDate(13, new java.sql.Date(t.getNgayTao().getTime()));
        ps.setBoolean(14, t.isTrangThai());
        ps.setObject(15, id);

        int result = ps.executeUpdate();
        return result > 0;
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return false;
}


    

}
