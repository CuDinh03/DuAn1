package duan1_nhom1.service;

import duan1_nhom1.dto.SanPhamDto;
import duan1_nhom1.model.Khach;
import duan1_nhom1.model.SanPham;
import duan1_nhom1.repository.SanPhamRepository;
import duan1_nhom1.tranf.TranferData;
import duan1_nhom1.utils.JdbcHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SanPhamService implements IService<SanPhamDto> {

    private SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    public void add(SanPhamDto sanPham) {
        sanPhamRepository.addNew(TranferData.convertToEntity(sanPham));
    }

    @Override
    public void update(SanPhamDto sanPham, String id) {
        sanPhamRepository.update(TranferData.convertToEntity(sanPham));
    }

    @Override
    public void delete(String id) {
        sanPhamRepository.delete(id);
    }

    @Override
    public List<SanPhamDto> getAll() {
        return TranferData.convertListSanPhamToDto(sanPhamRepository.getAll());
    }

    @Override
    public SanPhamDto findById(String id) {
        return TranferData.convertToDto(this.sanPhamRepository.findById(id));
    }

    public String getTenById(String id) {
        return sanPhamRepository.getTenById(id);
    }

    public List<String> getAllTen() {
        return sanPhamRepository.getAllTen();
    }

    public List<String> getAllId() {
        return sanPhamRepository.getAllId();
    }

    public String getMaById(String ma) {
        return sanPhamRepository.getMaById(ma);
    }
    
    public List<SanPham> timKiem(String ma, String ten) {
        String sql = """
                 SELECT [ma]
                        ,[ten]
                        ,[mo_ta]
                        ,[ngay_tao]
                        ,[ngay_sua]
                        ,[trang_thai]
                   FROM [dbo].[san_pham]
                   WHERE [ma] = ? OR [ten] = ?;
                 """;

        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setObject(1, ma);
            ps.setObject(2, ten);

            try (ResultSet rs = ps.executeQuery()) {
                List<SanPham> list = new ArrayList<>();
                while (rs.next()) {
                    SanPham sp = new SanPham();
                    sp.setMa(rs.getString(1));
                    sp.setTen(rs.getString(2));
                    sp.setMoTa(rs.getString(3));
                    sp.setNgayTao(rs.getDate(4));
                    sp.setNgaySua(rs.getDate(5));
                    sp.setTrangThai(rs.getBoolean(6));
                    list.add(sp);
                }
                return list;
            }

        } catch (Exception e) {
            // Log the exception using a logging framework like log4j or slf4j
            e.printStackTrace();
        }
        return null;
    }
}
