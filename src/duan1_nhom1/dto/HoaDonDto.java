/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.dto;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author maccuacu
 */
public class HoaDonDto {
     private UUID id;
    private UUID idKhachHang;
    private String ma;
    private Date ngayMua;
    private Double tongTien;
    private Boolean trangThai;
    private Date ngayTao;
    private Date ngaySua;

    public HoaDonDto() {
    }

    public HoaDonDto(UUID id, UUID idKhachHang, String ma, Date ngayMua, Double tongTien, Boolean trangThai, Date ngayTao, Date ngaySua) {
        this.id = id;
        this.idKhachHang = idKhachHang;
        this.ma = ma;
        this.ngayMua = ngayMua;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(UUID idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }
}
