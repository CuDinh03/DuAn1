package duan1_nhom1.repository;

import duan1_nhom1.model.HoaDon;
import duan1_nhom1.model.Khach;
import duan1_nhom1.utils.JdbcHelper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhachRepo {

    private List<Khach> listKhach = new ArrayList<>();

    public void addKhachHang(Khach khachHang) {
        if (khachHang == null) {
            return;
        }

        String sql = """
        INSERT INTO [dbo].[Khach_Hang]
                     ([ma]
                     ,[ten]
                     ,[sdt]
                     ,[ngay_tao]
                     ,[ngay_sua]
                     ,[trang_thai])
               VALUES
                     (?
                     ,?
                     ,?
                     ,?
                     ,?
                     ,?);  
                 """;

        try (Connection con = JdbcHelper.getConnection(); PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1, khachHang.getMaKhachHang());
            stm.setString(2, khachHang.getTenKhachHang());
            stm.setString(3, khachHang.getSdt());
            stm.setDate(4, (Date) khachHang.getNgayTao());
            stm.setDate(5, (Date) khachHang.getNgaySua());
            stm.setBoolean(6, khachHang.getTrangThai());

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

    public Khach getHoaDonById(String idKhach) {
        String sql = "SELECT * FROM hoa_don WHERE id = ?";
        try (Connection con = JdbcHelper.getConnection(); PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setObject(1, idKhach);
            try (ResultSet resultSet = stm.executeQuery()) {
                if (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String ma = resultSet.getString("ma");
                    String ten = resultSet.getString("ten");
                    String sdt = resultSet.getString("sdt");
                    Date ngay_tao = resultSet.getDate("ngay_tao");
                    Date ngay_sua = resultSet.getDate("ngay_sua");
                    Boolean trang_thai = resultSet.getBoolean("trang_thai");
                    return new Khach(id, ma, ten, sdt, ngay_tao, ngay_sua, trang_thai);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateKhachHang(Khach kh, String id) {

        String sql = """
                UPDATE [dbo].[Khach_Hang]
                SET [ma] = ?,
                    [ten] = ?,
                    [sdt] = ?,
                    [ngay_tao] = ?,
                    [ngay_sua] = ?,
                    [trang_thai] = ?
                WHERE id = ?;
                """;

        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            // Set parameters
            ps.setObject(1, kh.getMaKhachHang());
            ps.setObject(2, kh.getTenKhachHang());
            ps.setObject(3, kh.getSdt());
            ps.setObject(4, kh.getNgayTao());
            ps.setObject(5, kh.getNgaySua());
            ps.setObject(6, kh.getTrangThai());
            ps.setObject(7, kh.getId());
            ps.setObject(7, id);
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

    public void deleteKhach(String id) {
        String sql = """
         DELETE FROM [dbo].[Khach_Hang]
                    WHERE id=?;
            """;

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

    public List<Khach> getAll() {
        String sql = """
                SELECT [id]
                     ,[ma]
                      ,[ten]
                      ,[sdt]
                      ,[ngay_tao]
                      ,[ngay_sua]
                      ,[trang_thai]
                  FROM [dbo].[Khach_Hang];
            """;
        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<Khach> khach = new ArrayList<>();
            while (rs.next()) {
                Khach kh = new Khach();
                kh.setId(rs.getString(1));
                kh.setMaKhachHang(rs.getString(2));
                kh.setTenKhachHang(rs.getString(3));
                kh.setSdt(rs.getString(4));
                kh.setNgayTao(rs.getDate(5));
                kh.setNgaySua(rs.getDate(6));
                kh.setTrangThai(rs.getBoolean(7));
                khach.add(kh);
            }
            return khach;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Khach> timKiem(String ma) {
        String sql = """
                    SELECT [ma]
                           ,[ten]
                           ,[sdt]
                           ,[ngay_tao]
                           ,[ngay_sua]
                           ,[trang_thai]
                       FROM [dbo].[Khach_Hang]
                       where [ma] = ? or  [ten] = ? or[sdt]=? or [trang_thai]=? ;
                     """;
        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Khach> locKhach(Boolean trangThai) {
        String sql = """
                    SELECT [ma]
                           ,[ten]
                           ,[sdt]
                           ,[ngay_tao]
                           ,[ngay_sua]
                           ,[trang_thai]
                       FROM [dbo].[Khach_Hang]
                       where [ma] = ? or  [ten] = ? or[sdt]=? or [trang_thai]=? ;
                     """;
        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, trangThai);
            ResultSet rs = ps.executeQuery();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Khach findById(String id) {
        String sql = "Select * from [dbo].[Khach_hang] where id = ?";
        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Khach kh = new Khach();
                kh.setMaKhachHang(rs.getString(2));
                kh.setTenKhachHang(rs.getString(3));
                kh.setSdt(rs.getString(4));
                kh.setNgayTao(rs.getDate(5));
                kh.setNgaySua(rs.getDate(6));
                kh.setTrangThai(rs.getBoolean(7));
                return kh;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) {
//        Khach k = new Khach();
//        KhachRepo repo = new KhachRepo();
//            
//        k = repo.findById("5291043a-e9b3-46d8-8545-84f02050fda1");
//        System.out.println(k);
//    }
    public Khach finBySdt(String sdtk) {
        String sql = "Select * from [dbo].[Khach_hang] where sdt = ?";
        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, sdtk);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String ma = rs.getString("ma");
                String ten = rs.getString("ten");
                String sdt = rs.getString("sdt");
                Date ngay_tao = rs.getDate("ngay_tao");
                Date ngay_sua = rs.getDate("ngay_sua");
                Boolean trang_thai = rs.getBoolean("trang_thai");
                return new Khach(id, ma, ten, sdt, ngay_tao, ngay_sua, trang_thai);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
