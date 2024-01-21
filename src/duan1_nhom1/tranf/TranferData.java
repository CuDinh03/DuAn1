/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.tranf;

import duan1_nhom1.dto.HoaDonDto;
import duan1_nhom1.dto.KhachDto;
import duan1_nhom1.model.HoaDon;
import duan1_nhom1.model.Khach;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maccuacu
 */
public class TranferData {
    
    public static HoaDonDto convertToDto(HoaDon model) {
        HoaDonDto dto = new HoaDonDto();
        if (model.getId() != null)dto.setId(model.getId());
        if (model.getIdKhachHang() != null) dto.setIdKhachHang(model.getIdKhachHang());
        if (model.getIdNv() != null) dto.setIdNv(model.getIdNv());
        if (model.getMa() != null) dto.setMa(model.getMa());
        if (model.getNgayMua() != null) dto.setNgayMua(model.getNgayMua());
        if (model.getTongTien() != null) dto.setTongTien(model.getTongTien());
        if (model.getTrangThai() != null) dto.setTrangThai(model.getTrangThai());
        if (model.getNgayTao() != null) dto.setNgayTao(model.getNgayTao());
        if (model.getNgaySua() != null) dto.setNgaySua(model.getNgaySua());
        return dto;
    }

    public static HoaDon convertToEntity(HoaDonDto dto) {
        HoaDon model = new HoaDon();
        if (dto.getId() != null) model.setId(dto.getId());
        if (dto.getIdKhachHang() != null) model.setIdKhachHang(dto.getIdKhachHang());
        if (dto.getIdNv() != null) model.setIdNv(model.getIdNv());
        if (dto.getMa() != null) model.setMa(dto.getMa());
        if (dto.getNgayMua() != null) model.setNgayMua(dto.getNgayMua());
        if (dto.getTongTien() != null) model.setTongTien(dto.getTongTien());
        if (dto.getTrangThai() != null) model.setTrangThai(dto.getTrangThai());
        if (dto.getNgayTao() != null) model.setNgayTao(dto.getNgayTao());
        if (dto.getNgaySua() != null) model.setNgaySua(dto.getNgaySua());
        return model;
    }
    public static List<HoaDonDto> convertListToDto(List<HoaDon> entityList) {
        List<HoaDonDto> dtoList = new ArrayList<>();
        for (HoaDon entity : entityList) {
            dtoList.add(convertToDto(entity));
        }
        return dtoList;
    }
    
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
        
   

}
