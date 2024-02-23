package duan1_nhom1.repository;

import duan1_nhom1.model.Hang;
import duan1_nhom1.utils.JdbcHelper;
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
public class HangRepository {

    List<Hang> listHang = new ArrayList();
    Connection conn = JdbcHelper.getConnection();

    public List<Hang> getAll() {

        String sql = "SELECT id,ma,ten,mo_ta,ngay_tao,ngay_sua,trang_thai FROM hang";

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
                Hang hang = new Hang(id, ma, ten, moTa, ngayTao, ngaySua, trangThai);
                listHang.add(hang);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi kết nối");
            ex.printStackTrace();
        }
        return listHang;
    }

    public String getTenById(String id) {
        String sql = "SELECT ten FROM Hang WHERE id = ?";

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
        
        String sql = "SELECT id FROM Hang";
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
        
        String sql = "SELECT ten FROM Hang where TrangThai = 0";
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

   public void addNew(Hang hang) {
        if (hang == null) {
            return;
        }

        String sql = "INSERT INTO hang(ma,ten,mo_ta,ngay_tao,ngay_sua,trang_thai) VALUES(?,?,?,?,?,?)";

        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, hang.getMa());
            ps.setString(2, hang.getTen());
            ps.setString(3, hang.getMoTa());
            ps.setDate(4, new java.sql.Date(hang.getNgayTao().getTime()));
            ps.setDate(5, new java.sql.Date(hang.getNgaySua().getTime()));
            ps.setBoolean(6, hang.getTrangThai());

            int chek = ps.executeUpdate();

            if (chek > 0) {
                System.out.println("San pham Đã thêm thành công ");
            } else {
                System.out.println("Thêm thất bại ");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
    public void update(Hang hang, String id) {
        List<Hang> listHang = new ArrayList();
        String sql = """
                UPDATE [dbo].[hang]
                SET [ma] = ?,
                    [ten] = ?,
                    [mo_ta] = ?,
                    [ngay_tao] = ?,
                    [ngay_sua] = ?,
                    [trang_thai] = ?
                WHERE id = ?;
                """;

        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            // Set parameters
            ps.setObject(1, hang.getMa());
            ps.setObject(2, hang.getTen());
            ps.setObject(3, hang.getMoTa());
            ps.setObject(4, hang.getNgayTao());
            ps.setObject(5, hang.getNgaySua());
            ps.setObject(6, hang.getTrangThai());
            ps.setObject(7, hang.getId());
            ps.setObject(7, id);
            // Execute the update
            int chek = ps.executeUpdate();

            // Check the result
            if (chek > 0) {
                System.out.println("update thành công ");
            } else {
                System.out.println("update thất bại  ");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error updating danh muc.", e);
        }
    }

    public void delete(String id) {
        List<Hang> listHang = new ArrayList();
        String sql = "DELETE FROM hang WHERE id = ?";

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
}
