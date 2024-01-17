/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.model;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author maccuacu
 */
public class ChiTietSanPham {
    private UUID id;
    private UUID idHang;
    private UUID idMS;
    private UUID idCL;
    private UUID idSize;
    private UUID idAnh;
    private UUID idDM;
    private UUID idSP;
    private DecimalFormat giaBan;
    private DecimalFormat giaNhap;
    private Integer soLuong;
    private Date ngayNhap;
    private Date ngayTao;
    private Date ngaySua;
    private Boolean trangThai;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(UUID id, UUID idHang, UUID idMS, UUID idCL, UUID idSize, UUID idAnh, UUID idDM, UUID idSP, DecimalFormat giaBan, DecimalFormat giaNhap, Integer soLuong, Date ngayNhap, Date ngayTao, Date ngaySua, Boolean trangThai) {
        this.id = id;
        this.idHang = idHang;
        this.idMS = idMS;
        this.idCL = idCL;
        this.idSize = idSize;
        this.idAnh = idAnh;
        this.idDM = idDM;
        this.idSP = idSP;
        this.giaBan = giaBan;
        this.giaNhap = giaNhap;
        this.soLuong = soLuong;
        this.ngayNhap = ngayNhap;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdHang() {
        return idHang;
    }

    public void setIdHang(UUID idHang) {
        this.idHang = idHang;
    }

    public UUID getIdMS() {
        return idMS;
    }

    public void setIdMS(UUID idMS) {
        this.idMS = idMS;
    }

    public UUID getIdCL() {
        return idCL;
    }

    public void setIdCL(UUID idCL) {
        this.idCL = idCL;
    }

    public UUID getIdSize() {
        return idSize;
    }

    public void setIdSize(UUID idSize) {
        this.idSize = idSize;
    }

    public UUID getIdAnh() {
        return idAnh;
    }

    public void setIdAnh(UUID idAnh) {
        this.idAnh = idAnh;
    }

    public UUID getIdDM() {
        return idDM;
    }

    public void setIdDM(UUID idDM) {
        this.idDM = idDM;
    }

    public UUID getIdSP() {
        return idSP;
    }

    public void setIdSP(UUID idSP) {
        this.idSP = idSP;
    }

    public DecimalFormat getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(DecimalFormat giaBan) {
        this.giaBan = giaBan;
    }

    public DecimalFormat getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(DecimalFormat giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
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

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    

}
