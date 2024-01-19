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
public class SPChiTietService implements IService<QLSanPhamViewModel>{
    
    private SPChiTietRepository sPChiTietRepository = new SPChiTietRepository();

    @Override
    public void add(QLSanPhamViewModel t) {
        QLSanPhamViewModel domainModel = new QLSanPhamViewModel();

        domainModel.setThuongHieu(t.getThuongHieu());
        domainModel.setMauSac(t.getMauSac());
        domainModel.setDanhMuc(t.getDanhMuc());
        domainModel.setChatLieu(t.getChatLieu());
        domainModel.setTenSP(t.getTenSP());
        domainModel.setMaSP(t.getMaSP());
        domainModel.setKichThuoc(t.getKichThuoc());
        domainModel.setGiaNhap(t.getGiaNhap());
        domainModel.setGiaBan(t.getGiaBan());
        domainModel.setSoLuong(t.getSoLuong());
        domainModel.setNgayNhap(t.getNgayNhap());
        domainModel.setNgaySua(t.getNgaySua());
        domainModel.setNgayTao(t.getNgayTao());
        domainModel.setTrangThai(t.getTrangThai());
        

        if (this.sPChiTietRepository.insert(domainModel)) {
            System.out.println("them thanh cong");;
        } else {
            System.out.println("them that bai");;
        }
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
    
}
