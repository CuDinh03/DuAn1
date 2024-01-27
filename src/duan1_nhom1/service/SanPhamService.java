package duan1_nhom1.service;

import duan1_nhom1.dto.SanPhamDto;
import duan1_nhom1.model.SanPham;
import duan1_nhom1.repository.SanPhamRepository;
import duan1_nhom1.tranf.TranferData;
import java.util.List;

public class SanPhamService implements IService<SanPhamDto> {

    private SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    public void add(SanPhamDto t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(SanPhamDto t, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

}
