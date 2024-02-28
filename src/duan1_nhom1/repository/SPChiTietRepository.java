/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.repository;

import duan1_nhom1.dto.ChiTietSanPhamDto;
import duan1_nhom1.model.ChiTietGioHang;
import duan1_nhom1.model.ChiTietSanPham;
import duan1_nhom1.model.MauSac;
import duan1_nhom1.service.SPChiTietService;
import duan1_nhom1.utils.JdbcHelper;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anhtuanle
 */
public class SPChiTietRepository {

    Connection conn = JdbcHelper.getConnection();
    private SPChiTietService sPChiTietService;

    public List<ChiTietSanPham> getAll() {
        List<ChiTietSanPham> listSanPham = new ArrayList();
        String sql = "SELECT * FROM san_pham_chi_tiet";

        try {
            PreparedStatement pr = conn.prepareStatement(sql);
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {

                String idString = resultSet.getString("id");

                String ma = resultSet.getString("ma");
                String idSPString = resultSet.getString("id_sp");

                String idHangString = resultSet.getString("id_hang");
                String idClString = resultSet.getString("id_cl");

                String idMsString = resultSet.getString("id_ms");

                String idSizeString = resultSet.getString("id_size");

                String idDmString = resultSet.getString("id_dm");

                BigDecimal giaNhap = resultSet.getBigDecimal("gia_nhap");
                BigDecimal giaBan = resultSet.getBigDecimal("gia_ban");
                int soLuong = resultSet.getInt("so_luong");
                Date ngayNhap = resultSet.getDate("ngay_nhap");
                Date ngayTao = resultSet.getDate("ngay_tao");
                Date ngaySua = resultSet.getDate("ngay_sua");
                Boolean trangThai = resultSet.getBoolean("trang_thai");

                ChiTietSanPham chiTietSanPham = new ChiTietSanPham(idString, ma, idSPString, idSizeString, idHangString, idMsString, idClString, idDmString, giaNhap, giaBan, soLuong, ngayTao, ngaySua, ngayNhap, trangThai);
                listSanPham.add(chiTietSanPham);
            }
        } catch (Exception ex) {
            System.out.println("Lỗi kết nối");
            ex.printStackTrace();
        }
        return listSanPham;
    }

    public Boolean insert(ChiTietSanPham sanPham) {
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

    public void delete(String id) {
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

    public Boolean updateSP(ChiTietSanPham t, String id) {
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

    public ChiTietSanPham findByMa(String madto) {
        String query = "SELECT c.id, c.ma, s.id as id_sp, c.id_hang,c.id_cl,c.id_ms,c.id_size,c.id_dm,c.gia_nhap,c.gia_ban,c.so_luong,c.ngay_nhap,c.ngay_tao,c.ngay_sua, c.trang_thai from san_pham_chi_tiet c JOIN san_pham s ON c.id_sp = s.id WHERE s.ma = ? ";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, madto);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idString = resultSet.getString("id");

                String ma = resultSet.getString("ma");
                String idSPString = resultSet.getString("id_sp");

                String idHangString = resultSet.getString("id_hang");
                String idClString = resultSet.getString("id_cl");

                String idMsString = resultSet.getString("id_ms");

                String idSizeString = resultSet.getString("id_size");

                String idDmString = resultSet.getString("id_dm");

                BigDecimal giaNhap = resultSet.getBigDecimal("gia_nhap");
                BigDecimal giaBan = resultSet.getBigDecimal("gia_ban");
                Integer soLuong = resultSet.getInt("so_luong");
                System.out.println(soLuong);
                Date ngayNhap = resultSet.getDate("ngay_nhap");
                Date ngayTao = resultSet.getDate("ngay_tao");
                Date ngaySua = resultSet.getDate("ngay_sua");
                Boolean trangThai = resultSet.getBoolean("trang_thai");

                ChiTietSanPham chiTietSanPham = new ChiTietSanPham(idString, ma, idSPString, idSizeString, idHangString, idMsString, idClString, idDmString, giaNhap, giaBan, soLuong, ngayTao, ngaySua, ngayNhap, trangThai);
                return chiTietSanPham;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ChiTietSanPham findByMaCt(String madto) {
        String query = "SElect * from san_pham_chi_tiet where ma = ? ";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, madto);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idString = resultSet.getString("id");

                String ma = resultSet.getString("ma");
                String idSPString = resultSet.getString("id_sp");

                String idHangString = resultSet.getString("id_hang");
                String idClString = resultSet.getString("id_cl");

                String idMsString = resultSet.getString("id_ms");

                String idSizeString = resultSet.getString("id_size");

                String idDmString = resultSet.getString("id_dm");

                BigDecimal giaNhap = resultSet.getBigDecimal("gia_nhap");
                BigDecimal giaBan = resultSet.getBigDecimal("gia_ban");
                Integer soLuong = resultSet.getInt("so_luong");
                System.out.println(soLuong);
                Date ngayNhap = resultSet.getDate("ngay_nhap");
                Date ngayTao = resultSet.getDate("ngay_tao");
                Date ngaySua = resultSet.getDate("ngay_sua");
                Boolean trangThai = resultSet.getBoolean("trang_thai");

                ChiTietSanPham chiTietSanPham = new ChiTietSanPham(idString, ma, idSPString, idSizeString, idHangString, idMsString, idClString, idDmString, giaNhap, giaBan, soLuong, ngayTao, ngaySua, ngayNhap, trangThai);
                return chiTietSanPham;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ChiTietSanPham findByMaCtLike(String madto) {
        String query = "SElect * from san_pham_chi_tiet where ma like ? ";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, madto);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idString = resultSet.getString("id");

                String ma = resultSet.getString("ma");
                String idSPString = resultSet.getString("id_sp");

                String idHangString = resultSet.getString("id_hang");
                String idClString = resultSet.getString("id_cl");

                String idMsString = resultSet.getString("id_ms");

                String idSizeString = resultSet.getString("id_size");

                String idDmString = resultSet.getString("id_dm");

                BigDecimal giaNhap = resultSet.getBigDecimal("gia_nhap");
                BigDecimal giaBan = resultSet.getBigDecimal("gia_ban");
                Integer soLuong = resultSet.getInt("so_luong");
                System.out.println(soLuong);
                Date ngayNhap = resultSet.getDate("ngay_nhap");
                Date ngayTao = resultSet.getDate("ngay_tao");
                Date ngaySua = resultSet.getDate("ngay_sua");
                Boolean trangThai = resultSet.getBoolean("trang_thai");

                ChiTietSanPham chiTietSanPham = new ChiTietSanPham(idString, ma, idSPString, idSizeString, idHangString, idMsString, idClString, idDmString, giaNhap, giaBan, soLuong, ngayTao, ngaySua, ngayNhap, trangThai);
                return chiTietSanPham;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ChiTietSanPham findByIDsp(String idsp) {
        String query = "SELECT c.id, c.ma, s.id as id_sp, c.id_hang,c.id_cl,c.id_ms,c.id_size,c.id_dm,c.gia_nhap,c.gia_ban,c.so_luong,c.ngay_nhap,c.ngay_tao,c.ngay_sua, c.trang_thai from san_pham_chi_tiet c JOIN san_pham s ON c.id_sp = s.id WHERE s.id = ? ";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, idsp);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idString = resultSet.getString("id");

                String ma = resultSet.getString("ma");
                String idSPString = resultSet.getString("id_sp");

                String idHangString = resultSet.getString("id_hang");
                String idClString = resultSet.getString("id_cl");

                String idMsString = resultSet.getString("id_ms");

                String idSizeString = resultSet.getString("id_size");

                String idDmString = resultSet.getString("id_dm");

                BigDecimal giaNhap = resultSet.getBigDecimal("gia_nhap");
                BigDecimal giaBan = resultSet.getBigDecimal("gia_ban");
                Integer soLuong = resultSet.getInt("so_luong");
                System.out.println(soLuong);
                Date ngayNhap = resultSet.getDate("ngay_nhap");
                Date ngayTao = resultSet.getDate("ngay_tao");
                Date ngaySua = resultSet.getDate("ngay_sua");
                Boolean trangThai = resultSet.getBoolean("trang_thai");

                ChiTietSanPham chiTietSanPham = new ChiTietSanPham(idString, ma, idSPString, idSizeString, idHangString, idMsString, idClString, idDmString, giaNhap, giaBan, soLuong, ngayTao, ngaySua, ngayNhap, trangThai);
                return chiTietSanPham;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void changeQuantity(ChiTietSanPham ctsp) {
        String query = "Update san_pham_chi_tiet set so_luong = ? where id = ?  ";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setInt(1, ctsp.getSoLuong());
            preparedStatement.setString(2, ctsp.getId());
            preparedStatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(SPChiTietRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        SPChiTietRepository sp = new SPChiTietRepository();
        List<ChiTietSanPham> list = new ArrayList<>();
        list = sp.getAll();
        for (ChiTietSanPham chiTietSanPham : list) {
            System.out.println(chiTietSanPham.toString());
        }
    }

    public List<ChiTietSanPham> getAllChiTietGioHangByIdsp(String id) {
        List<ChiTietSanPham> chiTietSanPhams = new ArrayList<>();
        String query = "SELECT * from san_pham_chi_tiet WHERE id_sp = ? ";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idString = resultSet.getString("id");

                String ma = resultSet.getString("ma");
                String idSPString = resultSet.getString("id_sp");

                String idHangString = resultSet.getString("id_hang");
                System.out.println("id hang repo" + idHangString);
                String idClString = resultSet.getString("id_cl");

                String idMsString = resultSet.getString("id_ms");

                String idSizeString = resultSet.getString("id_size");

                String idDmString = resultSet.getString("id_dm");

                BigDecimal giaNhap = resultSet.getBigDecimal("gia_nhap");
                BigDecimal giaBan = resultSet.getBigDecimal("gia_ban");
                Integer soLuong = resultSet.getInt("so_luong");
                System.out.println(soLuong);
                Date ngayNhap = resultSet.getDate("ngay_nhap");
                Date ngayTao = resultSet.getDate("ngay_tao");
                Date ngaySua = resultSet.getDate("ngay_sua");
                Boolean trangThai = resultSet.getBoolean("trang_thai");

                ChiTietSanPham chiTietSanPham = new ChiTietSanPham(idString, ma, idSPString, idHangString, idClString, idMsString, idSizeString, idDmString, giaNhap, giaBan, soLuong, ngayNhap, ngayTao, ngaySua, trangThai);
                chiTietSanPhams.add(chiTietSanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chiTietSanPhams;
    }

    public List<ChiTietSanPham> getAllSPHadDm() {
        List<ChiTietSanPham> list = new ArrayList<>();
        String sql = "SELECT spct.id, spct.ma, sp.ten AS ten_san_pham, h.ten AS ten_hang, cl.ten AS ten_chat_lieu, ms.ten AS ten_mau_sac, s.ten AS ten_size, dm.ten AS ten_danh_muc, spct.gia_nhap, spct.gia_ban, spct.so_luong, spct.ngay_nhap, spct.ngay_tao, spct.ngay_sua, spct.trang_thai "
                + "FROM san_pham_chi_tiet spct "
                + "JOIN san_pham sp ON spct.id_sp = sp.id "
                + "JOIN Hang h ON spct.id_hang = h.id "
                + "JOIN chat_lieu cl ON spct.id_cl = cl.id "
                + "JOIN mau_sac ms ON spct.id_ms = ms.id "
                + "JOIN Size_ao s ON spct.id_size = s.id "
                + "JOIN danh_muc_san_pham dm ON spct.id_dm = dm.id";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String idString = resultSet.getString("id");
                String ma = resultSet.getString("ma");
                String idSPString = resultSet.getString("id_sp");
                String idHangString = resultSet.getString("id_hang");
                String idClString = resultSet.getString("id_cl");
                String idMsString = resultSet.getString("id_ms");
                String idSizeString = resultSet.getString("id_size");
                String idDmString = resultSet.getString("id_dm");
                BigDecimal giaNhap = resultSet.getBigDecimal("gia_nhap");
                BigDecimal giaBan = resultSet.getBigDecimal("gia_ban");
                int soLuong = resultSet.getInt("so_luong");
                Date ngayNhap = resultSet.getDate("ngay_nhap");
                Date ngayTao = resultSet.getDate("ngay_tao");
                Date ngaySua = resultSet.getDate("ngay_sua");
                boolean trangThai = resultSet.getBoolean("trang_thai");
                ChiTietSanPham chiTietSanPham = new ChiTietSanPham(idString, ma, idSPString, idHangString, idClString, idMsString, idSizeString, idDmString, giaNhap, giaBan, soLuong, ngayNhap, ngayTao, ngaySua, trangThai);
                list.add(chiTietSanPham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<ChiTietSanPham> findByDm(String dm) {
        List<ChiTietSanPham> list = new ArrayList<>();
        String sql = "SELECT * FROM san_pham_chi_tiet \n"
                + "JOIN danh_muc_san_pham ON san_pham_chi_tiet.id_dm = danh_muc_san_pham.id\n"
                + "WHERE ten = ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dm);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String idString = resultSet.getString("id");
                String ma = resultSet.getString("ma");
                String idSPString = resultSet.getString("id_sp");
                String idHangString = resultSet.getString("id_hang");
                String idClString = resultSet.getString("id_cl");
                String idMsString = resultSet.getString("id_ms");
                String idSizeString = resultSet.getString("id_size");
                String idDmString = resultSet.getString("id_dm");
                BigDecimal giaNhap = resultSet.getBigDecimal("gia_nhap");
                BigDecimal giaBan = resultSet.getBigDecimal("gia_ban");
                int soLuong = resultSet.getInt("so_luong");
                Date ngayNhap = resultSet.getDate("ngay_nhap");
                Date ngayTao = resultSet.getDate("ngay_tao");
                Date ngaySua = resultSet.getDate("ngay_sua");
                boolean trangThai = resultSet.getBoolean("trang_thai");
                ChiTietSanPham chiTietSanPham = new ChiTietSanPham(idString, ma, idSPString, idHangString, idClString, idMsString, idSizeString, idDmString, giaNhap, giaBan, soLuong, ngayNhap, ngayTao, ngaySua, trangThai);
                list.add(chiTietSanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<ChiTietSanPham> getAllByIdDm(String id) {
        List<ChiTietSanPham> chiTietSanPhams = new ArrayList<>();
        String query = "SELECT * from san_pham_chi_tiet WHERE id_dm = ? ";
        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setObject(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String idString = resultSet.getString("id");

                String ma = resultSet.getString("ma");
                String idSPString = resultSet.getString("id_sp");

                String idHangString = resultSet.getString("id_hang");
                System.out.println("id hang repo" + idHangString);
                String idClString = resultSet.getString("id_cl");

                String idMsString = resultSet.getString("id_ms");

                String idSizeString = resultSet.getString("id_size");

                String idDmString = resultSet.getString("id_dm");

                BigDecimal giaNhap = resultSet.getBigDecimal("gia_nhap");
                BigDecimal giaBan = resultSet.getBigDecimal("gia_ban");
                Integer soLuong = resultSet.getInt("so_luong");
                System.out.println(soLuong);
                Date ngayNhap = resultSet.getDate("ngay_nhap");
                Date ngayTao = resultSet.getDate("ngay_tao");
                Date ngaySua = resultSet.getDate("ngay_sua");
                Boolean trangThai = resultSet.getBoolean("trang_thai");

                ChiTietSanPham chiTietSanPham = new ChiTietSanPham(idString, ma, idSPString, idHangString, idClString, idMsString, idSizeString, idDmString, giaNhap, giaBan, soLuong, ngayNhap, ngayTao, ngaySua, trangThai);
                chiTietSanPhams.add(chiTietSanPham);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chiTietSanPhams;
    }
}
