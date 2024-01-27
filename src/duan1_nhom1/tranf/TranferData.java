/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.tranf;

import duan1_nhom1.dto.ChiTietSanPhamDto;
import duan1_nhom1.dto.HoaDonDto;
import duan1_nhom1.dto.KhachDto;
import duan1_nhom1.model.ChiTietSanPham;
import duan1_nhom1.model.HoaDon;
import duan1_nhom1.model.Khach;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author maccuacu
 */
public class TranferData {
    
       public static KhachDto convertToDto(Khach khach) {
        KhachDto dto = new KhachDto();
        if (khach.getId() != null) {
            dto.setId(khach.getId());
        }
        if (khach.getMaKhachHang() != null) {
            dto.setMaKhachHang(khach.getMaKhachHang());
        }
        if (khach.getTenKhachHang() != null) {
            dto.setTenKhachHang(khach.getTenKhachHang());
        }
        if (khach.getSdt() != null) {
            dto.setSdt(khach.getSdt());
        }
        if (khach.getNgayTao() != null) {
            dto.setNgayTao(khach.getNgayTao());
        }
        if (khach.getNgaySua() != null) {
            dto.setNgaySua(khach.getNgaySua());
        }
        if (khach.getTrangThai() != null) {
            dto.setTrangThai(khach.getTrangThai());
        }
        
        return dto;
    }
       
        public static Khach convertToModel(KhachDto dto) {
        Khach model = new Khach();

        if (dto.getId() != null) {
            model.setId(dto.getId());
        }
        if (dto.getMaKhachHang() != null) {
            model.setMaKhachHang(dto.getMaKhachHang());
        }
        if (dto.getTenKhachHang() != null) {
            model.setTenKhachHang(dto.getTenKhachHang());
        }
        if (dto.getSdt() != null) {
            model.setSdt(dto.getSdt());
        }
        if (dto.getNgayTao() != null) {
            model.setNgayTao(dto.getNgayTao());
        }
        if (dto.getNgaySua() != null) {
            model.setNgaySua(dto.getNgaySua());
        }
        if (dto.getTrangThai() != null) {
            model.setTrangThai(dto.getTrangThai());
        }

        return model;
    }
    public static List<KhachDto> convertListKhachToDto(List<Khach> entityList) {
        List<KhachDto> dtoList = new ArrayList<>();
        for (Khach entity : entityList) {
            dtoList.add(convertToDto(entity));
        }
        return dtoList;
    }
        
    
    public static ChiTietSanPhamDto convertToDto(ChiTietSanPham model) {
        ChiTietSanPhamDto dto = new ChiTietSanPhamDto();
        if (model.getMa() != null) dto.setMa(model.getMa());
        if (model.getIdSanPham() != null) dto.setIdSanPham(model.getIdSanPham());
        if (model.getIdKichThuoc() != null) dto.setIdKichThuoc(model.getIdKichThuoc());
        if (model.getIdThuongHieu() != null) dto.setIdThuongHieu(model.getIdThuongHieu());
        if (model.getIdMauSac() != null) dto.setIdMauSac(model.getIdMauSac());
        if (model.getIdChatLieu() != null) dto.setIdChatLieu(model.getIdChatLieu());
        if (model.getIdDanhMuc() != null) dto.setIdDanhMuc(model.getIdDanhMuc());
        if (model.getGiaNhap() != null) dto.setGiaNhap(model.getGiaNhap());
        if (model.getGiaBan() != null) dto.setGiaBan(model.getGiaBan());
        model.setSoLuong(dto.getSoLuong());
        if (model.getNgayTao() != null) dto.setNgayTao(model.getNgayTao());
        if (model.getNgaySua() != null) dto.setNgaySua(model.getNgaySua());
        if (model.getNgayNhap() != null) dto.setNgayNhap(model.getNgayNhap());
        dto.setTrangThai(model.isTrangThai());
        return dto;
    }

    public static ChiTietSanPham convertToEntity(ChiTietSanPhamDto dto) {
        ChiTietSanPham model = new ChiTietSanPham();
        model.setId(UUID.randomUUID()); // Assuming you generate a new UUID for a new entity
        if (dto.getMa() != null) model.setMa(dto.getMa());
        if (dto.getIdSanPham() != null) model.setIdSanPham(dto.getIdSanPham());
        if (dto.getIdKichThuoc() != null) model.setIdKichThuoc(dto.getIdKichThuoc());
        if (dto.getIdThuongHieu() != null) model.setIdThuongHieu(dto.getIdThuongHieu());
        if (dto.getIdMauSac() != null) model.setIdMauSac(dto.getIdMauSac());
        if (dto.getIdChatLieu() != null) model.setIdChatLieu(dto.getIdChatLieu());
        if (dto.getIdDanhMuc() != null) model.setIdDanhMuc(dto.getIdDanhMuc());
        if (dto.getGiaNhap() != null) model.setGiaNhap(dto.getGiaNhap());
        if (dto.getGiaBan() != null) model.setGiaBan(dto.getGiaBan());
        dto.setSoLuong(model.getSoLuong());
        if (dto.getNgayTao() != null) model.setNgayTao(dto.getNgayTao());
        if (dto.getNgaySua() != null) model.setNgaySua(dto.getNgaySua());
        if (dto.getNgayNhap() != null) model.setNgayNhap(dto.getNgayNhap());
        model.setTrangThai(dto.isTrangThai());
        return model;
    }


    public static List<ChiTietSanPham> convertListToEntity(List<ChiTietSanPhamDto> dtoList) {
        List<ChiTietSanPham> entityList = new ArrayList<>();
        for (ChiTietSanPhamDto dto : dtoList) {
            entityList.add(convertToEntity(dto));
        }
        return entityList;
    }
   

}
