/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.model.ChiTietSanPham;
import duan1_nhom1.repository.SPChiTietRepository;
import duan1_nhom1.viewModel.QLSanPhamViewModel;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author anhtuanle
 */
public class SPChiTietService implements IService<ChiTietSanPham> {

    private SPChiTietRepository sPChiTietRepository = new SPChiTietRepository();

    public String insert(QLSanPhamViewModel t) {
        QLSanPhamViewModel domainModel = new QLSanPhamViewModel();
        domainModel.setMa(t.getMa());

        domainModel.setIdThuongHieu(t.getIdThuongHieu());
        domainModel.setIdMauSac(t.getIdMauSac());
        domainModel.setIdDanhMuc(t.getIdDanhMuc());
        domainModel.setIdChatLieu(t.getIdChatLieu());  
        domainModel.setIdSanPham(t.getIdSanPham());
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

    @Override
    public void add(ChiTietSanPham t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(ChiTietSanPham t, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    }

    @Override
    public List<ChiTietSanPham> getAll() {
        return sPChiTietRepository.getAll();
    }

    @Override
    public ChiTietSanPham findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void deleteSP(UUID id) {
        sPChiTietRepository.delete(id);
    }
    
     public String update(ChiTietSanPham t, UUID id) {
        QLSanPhamViewModel domainModel = new QLSanPhamViewModel();
        domainModel.setMa(t.getMa());

        domainModel.setIdThuongHieu(t.getIdThuongHieu());
        domainModel.setIdMauSac(t.getIdMauSac());
        domainModel.setIdDanhMuc(t.getIdDanhMuc());
        domainModel.setIdChatLieu(t.getIdChatLieu());  
        domainModel.setIdSanPham(t.getIdSanPham());
        domainModel.setIdKichThuoc(t.getIdKichThuoc());
        domainModel.setGiaNhap(t.getGiaNhap());
        domainModel.setGiaBan(t.getGiaBan());
        domainModel.setSoLuong(t.getSoLuong());
        domainModel.setNgayNhap(t.getNgayNhap());
        domainModel.setNgaySua(t.getNgaySua());
        domainModel.setNgayTao(t.getNgayTao());
        domainModel.setTrangThai(t.isTrangThai());

        if (this.sPChiTietRepository.updateSP(t,id)) {
            return "Thêm thành công !";
        } else {
            return "Thêm thất bại !";
        }
    }

}
