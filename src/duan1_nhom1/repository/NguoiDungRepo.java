/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.repository;

import duan1_nhom1.model.NguoiDung;
import duan1_nhom1.service.ChucVuService;
import duan1_nhom1.utils.JdbcHelper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author acer
 */
public class NguoiDungRepo {

    List<NguoiDung> list = new ArrayList<>();
    ChucVuService chucVuService=new ChucVuService();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    public List<NguoiDung> getAll() {
        String sql = "SELECT [id],[ten],[dia_chi],[sdt],[id_cv],[ngay_bd],[ngay_tao],[ngay_sua],[trang_thai] FROM [dbo].[Nguoi_Dung];";
        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<NguoiDung> khach = new ArrayList<>();
            while (rs.next()) {
               NguoiDung kh = new NguoiDung();
                kh.setId(rs.getString(1));
                kh.setTen(rs.getString(2));
                kh.setDiaChi(rs.getString(3));
                kh.setSdt(rs.getString(4));
                kh.setId_cv(rs.getString(5));
                kh.setNgayBD(rs.getDate(6));
                 kh.setNgayTao(rs.getDate(7));
                kh.setNgaySua(rs.getDate(8));
                kh.setTrangThai(rs.getBoolean(9));
                khach.add(kh);
            }
            return khach;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addNguoiDung(NguoiDung nguoiDung) {
        if (nguoiDung == null) {
            return;
        }

        String sql = "INSERT INTO Nguoi_Dung (ten,dia_chi,sdt,id_cv,ngay_bd,ngay_tao,ngay_sua,trang_thai) VALUES(?,?,?,?,?,?,?,?)";

        try (Connection con = JdbcHelper.getConnection(); PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, nguoiDung.getTen());
            stm.setString(2, nguoiDung.getDiaChi());
            stm.setString(3, nguoiDung.getSdt());
            stm.setString(4, nguoiDung.getId_cv());
            stm.setString(5, formatter.format(nguoiDung.getNgayBD()));
            stm.setString(6,  formatter.format(nguoiDung.getNgayTao()));
            stm.setString(7, formatter.format(nguoiDung.getNgaySua()));
            stm.setBoolean(8, nguoiDung.isTrangThai());

            int chek = stm.executeUpdate();

            if (chek > 0) {
                System.out.println("KhachHang Đã thêm thành công ");
            } else {
                System.out.println("Thêm thất bại ");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateNguoiDung(NguoiDung nv, String id) {

        String sql = "UPDATE Nguoi_dung SET ten=?,dia_chi = ?,"
                + "sdt = ?, id_cv = ?,ngay_bd=?,ngay_tao=?,ngay_sua=?,trang_thai=? WHERE id = ?";

        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            // Set parameters
            ps.setObject(1, nv.getTen());
            ps.setObject(2, nv.getDiaChi());
            ps.setObject(3, nv.getSdt());
            ps.setObject(4, nv.getId_cv());
            ps.setObject(5, nv.getNgayBD());
            ps.setObject(6, nv.getNgayTao());
            ps.setObject(7, nv.getNgaySua());
            ps.setObject(8, nv.isTrangThai());
            ps.setObject(9, id);
            // Execute the update
            int chek = ps.executeUpdate();

            // Check the result
            if (chek > 0) {
                System.out.println("update   thành công ");
            } else {
                System.out.println("update thất bại  ");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error updating KhachHang.", e);
        }

    }

    public void deleteNguoiDung(String id) {
        String sql = "DELETE FROM Nguoi_Dung WHERE id = ?";

        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            int chek = ps.executeUpdate();

            if (chek > 0) {
                System.out.println("Xóa  thành công ");
            } else {
                System.out.println("Xóa  thất bại ");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
       NguoiDungRepo repo=new NguoiDungRepo();
        List<NguoiDung> list = new ArrayList<>();
        list=repo.getAll();
        for (NguoiDung nguoiDung : list) {
            System.out.println(nguoiDung.getTen());
        }
    }
}
