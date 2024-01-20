/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.tranf;

import duan1_nhom1.dto.HoaDonDto;
import duan1_nhom1.model.HoaDon;

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
    
}
