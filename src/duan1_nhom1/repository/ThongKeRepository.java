/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.repository;

import duan1_nhom1.bean.HoaDonBean;
import duan1_nhom1.utils.JdbcHelper;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author maccuacu
 */
public class ThongKeRepository {

    public List<HoaDonBean> getList() {
        try {
            Connection conn = JdbcHelper.getConnection();
            String sql = "  SELECT ngay_mua, COUNT(*) as so_luong FROM Hoa_Don GROUP BY ngay_mua ORDER BY ngay_mua";
            List<HoaDonBean> list = new ArrayList<>();
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonBean hoaDonBean = new HoaDonBean();
                hoaDonBean.setNgayBan(((java.sql.Date) rs.getObject("ngay_mua")).toLocalDate());
                hoaDonBean.setSoLuongDaBan(rs.getInt("so_luong"));
                list.add(hoaDonBean);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
