/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.dto.ChiTietSanPhamDto;
import duan1_nhom1.model.ChiTietSanPham;
import duan1_nhom1.repository.SPChiTietRepository;
import duan1_nhom1.tranf.TranferData;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 1
 *
 * @author anhtuanle
 */
public class SPChiTietService implements IService<ChiTietSanPhamDto> {

    private SPChiTietRepository sPChiTietRepository = new SPChiTietRepository();

    public String insert(ChiTietSanPhamDto t) {
        t.setMa(t.getMa());

        t.setIdThuongHieu(t.getIdThuongHieu());
        t.setIdMauSac(t.getIdMauSac());
        t.setIdDanhMuc(t.getIdDanhMuc());
        t.setIdChatLieu(t.getIdChatLieu());
        t.setIdSanPham(t.getIdSanPham());
        t.setIdKichThuoc(t.getIdKichThuoc());
        t.setGiaNhap(t.getGiaNhap());
        t.setGiaBan(t.getGiaBan());
        t.setSoLuong(t.getSoLuong());
        t.setNgayNhap(t.getNgayNhap());
        t.setNgaySua(t.getNgaySua());
        t.setNgayTao(t.getNgayTao());
        t.setTrangThai(t.getTrangThai());

        if (this.sPChiTietRepository.insert(TranferData.convertToEntity(t))) {
            return "Thêm thành công !";
        } else {
            return "Thêm thất bại !";
        }
    }

    @Override
    public void add(ChiTietSanPhamDto t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(ChiTietSanPhamDto t, String id) {
        t.setMa(t.getMa());

        t.setIdThuongHieu(t.getIdThuongHieu());
        t.setIdMauSac(t.getIdMauSac());
        t.setIdDanhMuc(t.getIdDanhMuc());
        t.setIdChatLieu(t.getIdChatLieu());
        t.setIdSanPham(t.getIdSanPham());
        t.setIdKichThuoc(t.getIdKichThuoc());
        t.setGiaNhap(t.getGiaNhap());
        t.setGiaBan(t.getGiaBan());
        t.setSoLuong(t.getSoLuong());
        t.setNgayNhap(t.getNgayNhap());
        t.setNgaySua(t.getNgaySua());
        t.setNgayTao(t.getNgayTao());
        t.setTrangThai(t.getTrangThai());

        if (this.sPChiTietRepository.updateSP(TranferData.convertToEntity(t), id)) {
            System.out.println("Thêm thành công !");
        } else {
            System.out.println("Thêm thất bại !");

        }
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    public List<ChiTietSanPhamDto> getAll() {
        return TranferData.convertListToDtos(sPChiTietRepository.getAll());
    }

    @Override
    public ChiTietSanPhamDto findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void deleteSP(String id) {
        sPChiTietRepository.delete(id);
    }

    public ChiTietSanPhamDto findByMa(String ma) {
        return TranferData.convertToDto(this.sPChiTietRepository.findByMa(ma));
    }

    public ChiTietSanPhamDto findByMaCt(String ma) {
        return TranferData.convertToDto(this.sPChiTietRepository.findByMaCt(ma));
    }

    public ChiTietSanPhamDto findByIdSP(String idSP) {
        return TranferData.convertToDto(this.sPChiTietRepository.findByIDsp(idSP));
    }

    public void changeSL(ChiTietSanPhamDto ctsp) {
        this.sPChiTietRepository.changeQuantity(TranferData.convertToEntity(ctsp));
    }

    public List<ChiTietSanPhamDto> getAllByIdSp(String id) {
        return TranferData.convertListToDtos(this.sPChiTietRepository.getAllChiTietGioHangByIdsp(id));

    }
    
 public ChiTietSanPhamDto findByMaCtLike(String ma) {
        return TranferData.convertToDto(this.sPChiTietRepository.findByMaCtLike(ma));
    }
 
 public List<ChiTietSanPham> getAllSPHadDm() {

        List<ChiTietSanPham> list = this.sPChiTietRepository.getAllSPHadDm();
        List<ChiTietSanPham> listViewModel = new ArrayList<>();

        for (ChiTietSanPham domainModel : list) {
            ChiTietSanPham t = new ChiTietSanPham();
            t.setMa(t.getMa());

        t.setIdThuongHieu(t.getIdThuongHieu());
        t.setIdMauSac(t.getIdMauSac());
        t.setIdDanhMuc(t.getIdDanhMuc());
        t.setIdChatLieu(t.getIdChatLieu());
        t.setIdSanPham(t.getIdSanPham());
        t.setIdKichThuoc(t.getIdKichThuoc());
        t.setGiaNhap(t.getGiaNhap());
        t.setGiaBan(t.getGiaBan());
        t.setSoLuong(t.getSoLuong());
        t.setNgayNhap(t.getNgayNhap());
        t.setNgaySua(t.getNgaySua());
        t.setNgayTao(t.getNgayTao());
        t.setTrangThai(t.isTrangThai());

            listViewModel.add(t);
        }
        return listViewModel;
    }
 
 public List<ChiTietSanPham> findByDm(String dm) {
        List<ChiTietSanPham> list = sPChiTietRepository.findByDm(dm);
        List<ChiTietSanPham> listViewModel = new ArrayList<>();

        for (ChiTietSanPham domainModel : list) {
            ChiTietSanPham t = new ChiTietSanPham();
            t.setMa(t.getMa());

        t.setIdThuongHieu(t.getIdThuongHieu());
        t.setIdMauSac(t.getIdMauSac());
        t.setIdDanhMuc(t.getIdDanhMuc());
        t.setIdChatLieu(t.getIdChatLieu());
        t.setIdSanPham(t.getIdSanPham());
        t.setIdKichThuoc(t.getIdKichThuoc());
        t.setGiaNhap(t.getGiaNhap());
        t.setGiaBan(t.getGiaBan());
        t.setSoLuong(t.getSoLuong());
        t.setNgayNhap(t.getNgayNhap());
        t.setNgaySua(t.getNgaySua());
        t.setNgayTao(t.getNgayTao());
        t.setTrangThai(t.isTrangThai());

            listViewModel.add(t);
        }
        return listViewModel;
    }
}
