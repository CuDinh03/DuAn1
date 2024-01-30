
package duan1_nhom1.repository;
import duan1_nhom1.model.DanhMuc;
import duan1_nhom1.utils.JdbcHelper;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java .sql.Date;
import java.util.List;

/**
 *
 * @author anhtuanle
 */
public class DanhMucRepository {

    Connection conn = JdbcHelper.getConnection();

    public List<DanhMuc> getAll() {
            List<DanhMuc> listDanhMuc = new ArrayList<>();
        String sql = """
                     SELECT [id]
                           ,[ma]
                           ,[ten]
                           ,[mo_ta]
                           ,[ngay_tao]
                           ,[ngay_sua]
                           ,[trang_thai]
                       FROM [dbo].[danh_muc_san_pham];
                     """;

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
                Boolean trangThai = rs.getBoolean("trang_thai");
                DanhMuc danhMuc = new DanhMuc(id, ma, ten, moTa, ngayTao, ngaySua, trangThai);
                listDanhMuc.add(danhMuc);
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi kết nối");
            ex.printStackTrace();
        }
        return listDanhMuc;
    }

    public String getTenById(String id) {
        String sql = "SELECT ten FROM danh_muc_san_pham WHERE id = ?";

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

        String sql = "SELECT id FROM danh_muc_san_pham";
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

        String sql = "SELECT ten FROM danh_muc_san_pham where TrangThai = 0";
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
    public void addDanhMuc(DanhMuc danhMuc) {
//        if (danhMuc == null) {
//            return;
//        }

        String sql = """
       INSERT INTO [dbo].[danh_muc_san_pham]
                                ([ma]
                                ,[ten]
                                ,[mo_ta]
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

        try (Connection conn = JdbcHelper.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, danhMuc.getMa());
            ps.setString(2, danhMuc.getTen());
            ps.setString(3, danhMuc.getMoTa());
//            ps.setDate(4, danhMuc.getNgayTao().toString());
//            ps.setDate(5, );
            ps.setBoolean(6, danhMuc.getTrangThai());

            int chek = ps.executeUpdate();

            if (chek > 0) {
                System.out.println("Danh Mục Đã thêm thành công ");
            } else {
                System.out.println("Thêm thất bại ");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void update(DanhMuc danhMuc, String id) {
        List<DanhMuc> listDanhMuc = new ArrayList();
        String sql = """
                UPDATE [dbo].[danh_muc_san_pham]
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
            ps.setObject(1, danhMuc.getMa());
            ps.setObject(2, danhMuc.getTen());
            ps.setObject(3, danhMuc.getMoTa());
            ps.setObject(4, danhMuc.getNgayTao());
            ps.setObject(5, danhMuc.getNgaySua());
            ps.setObject(6, danhMuc.getTrangThai());
            ps.setObject(7, danhMuc.getId());
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
        List<DanhMuc> listDanhMuc = new ArrayList();
        String sql = "DELETE FROM danh_muc_san_pham WHERE id = ?";

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
