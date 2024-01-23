/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.repository;


import duan1_nhom1.model.DanhMuc;
import duan1_nhom1.model.KichThuoc;
import duan1_nhom1.model.MauSac;
import duan1_nhom1.utils.JdbcHelper;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.UUID;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author anhtuanle
 */
public class MauSacRepository {

    private JdbcHelper jdbcHelper;
    List<MauSac> listMauSac = new ArrayList();
    Connection conn = JdbcHelper.getConnection();

    public List<MauSac> getAll() {

        String sql = "SELECT id,ma,ten,mo_ta,ngay_tao,ngay_sua,trang_thai FROM mau_sac";

        try {
            PreparedStatement pr = conn.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                String moTa = rs.getString("mo_ta");
                Date ngayTao = rs.getDate("ngay_tao");
                Date ngaySua = rs.getDate("ngay_tao");
                boolean trangThai = rs.getBoolean("trang_thai");
                MauSac mauSac = new MauSac(id, ma, ten, moTa, ngayTao, ngaySua, trangThai);
                listMauSac.add(mauSac);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi kết nối");
            ex.printStackTrace();
        }
        return listMauSac;
    }

    public String getTenById(String id) {
        String sql = "SELECT ten FROM mau_sac WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("ten");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getAllId() {
        ArrayList<String> listId = new ArrayList<>();

        String sql = "SELECT id FROM mau_sac";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listId.add(rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listId;
    }

    public List<String> getAllTen() {
        ArrayList<String> listId = new ArrayList<>();

        String sql = "SELECT ten FROM mau_sac where TrangThai = 0";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listId.add(rs.getString("ten"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listId;
    }

    public void insert(MauSac mauSac) {
        if (mauSac == null) {
            return;
        }

        String sql = "INSERT INTO mau_sac(ma,ten,mo_ta,ngay_tao,ngay_sua,trang_thai) VALUES(?,?,?,?,?,?)";

        try (Connection con = jdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, mauSac.getMa());
            ps.setString(2, mauSac.getTen());
            ps.setString(3, mauSac.getMoTa());
            ps.setDate(4, new java.sql.Date(mauSac.getNgayTao().getTime()));
            ps.setDate(5, new java.sql.Date(mauSac.getNgaySua().getTime()));
            ps.setBoolean(6, mauSac.isTrangThai());

            int chek = ps.executeUpdate();

            if (chek > 0) {
                System.out.println("KhachHang Đã thêm thành công ");
            } else {
                System.out.println("Thêm thất bại ");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void update(MauSac mauSac, String id) {
        String sql = """
                UPDATE [dbo].[mau_sac]
                SET [ma] = ?,
                    [ten] = ?,
                    [mo_ta] = ?,
                    [ngay_tao] = ?,
                    [ngay_sua] = ?,
                    [trang_thai] = ?
                WHERE id = ?;
                """;

        try (Connection con = jdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, mauSac.getMa());
            ps.setObject(2, mauSac.getTen());
            ps.setObject(3, mauSac.getMoTa());
            ps.setObject(4, mauSac.getNgayTao());
            ps.setObject(5, mauSac.getNgaySua());
            ps.setObject(6, mauSac.isTrangThai());
            ps.setObject(7, id);

            int chek = ps.executeUpdate();

            if (chek > 0) {
                System.out.println(" updated thành công ");
            } else {
                System.out.println("Update thất bại ");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void delete(String id) {
        String sql = "DELETE FROM mau_sac WHERE id = ?";

        try (Connection con = jdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
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

}
