/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.repository.SPChiTietRepository;
import duan1_nhom1.viewModel.QLSanPhamViewModel;
import java.util.List;

/**
 *
 * @author anhtuanle
 */
public class SPChiTietService implements IService<QLSanPhamViewModel> {

    private SPChiTietRepository sPChiTietRepository = new SPChiTietRepository();

    @Override
    public void add(QLSanPhamViewModel t) {
       sPChiTietRepository.insert(t);
    }

    @Override
    public void update(QLSanPhamViewModel t, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<QLSanPhamViewModel> getAll() {
        return sPChiTietRepository.getAll();
    }

    @Override
    public QLSanPhamViewModel findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String insert(QLSanPhamViewModel t) {
        QLSanPhamViewModel domainModel = new QLSanPhamViewModel();

        domainModel.setIdThuongHieu(t.getIdThuongHieu());
        domainModel.setIdMauSac(t.getIdMauSac());
        domainModel.setIdDanhMuc(t.getIdDanhMuc());
        domainModel.setIdChatLieu(t.getIdChatLieu());
        domainModel.setTenSP(t.getTenSP());
        domainModel.setMaSP(t.getMaSP());
        domainModel.setIdKichThuoc(t.getIdKichThuoc());
        domainModel.setGiaNhap(t.getGiaNhap());
        domainModel.setGiaBan(t.getGiaBan());
        domainModel.setSoLuong(t.getSoLuong());
        domainModel.setNgayNhap(t.getNgayNhap());
        domainModel.setNgaySua(t.getNgaySua());
        domainModel.setNgayTao(t.getNgayTao());
        domainModel.setTrangThai(t.isTrangThai());

        if (this.sPChiTietRepository.insert(domainModel)) {
            return "Thêm thành công !";
        } else {
            return "Thêm thất bại !";
        }
    }
}
