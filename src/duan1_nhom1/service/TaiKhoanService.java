/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.model.TaiKhoan;
import duan1_nhom1.repository.TaiKhoanRepo;
import duan1_nhom1.utils.JdbcHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WEB
 */
public class TaiKhoanService implements IService<TaiKhoan>{
    private List<TaiKhoan> listTK = new ArrayList<>();
    private TaiKhoanRepo taiKhoanRepo = new TaiKhoanRepo();
    @Override
    public void add(TaiKhoan t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(TaiKhoan t, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<TaiKhoan> getAll() {
    return taiKhoanRepo.getAll();
    }

    @Override
    public TaiKhoan findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public TaiKhoan getTaiKhoan(String ma) {
        String query = """
                       select tai_khoan.ma,ten_dang_nhap,mat_khau,trang_thai
                       from tai_khoan
                       where tai_khoan.ma=?
                       """;
        TaiKhoan tk = new TaiKhoan();
        try (Connection con = JdbcHelper.getConnection(); PreparedStatement stm = con.prepareStatement(query)) {
            stm.setString(1, ma);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                tk.setId(rs.getString(1));
                tk.setId(rs.getString(1));
                tk.setMa(rs.getString(2));
                tk.setTenDangNhap(rs.getString(3));
                tk.setMatKhau(rs.getString(4));
                tk.setIdCV(rs.getString(5));
                tk.setNgayTao(rs.getDate(6));
                tk.setNgaySua(rs.getDate(7));
                tk.setTrangThai(rs.getBoolean(8));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return tk;
    }
    
}
