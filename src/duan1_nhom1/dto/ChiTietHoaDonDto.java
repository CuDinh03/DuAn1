/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.dto;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author maccuacu
 */
public class ChiTietHoaDonDto {
    private UUID id;
    private UUID idHD;
    private UUID idSP;
    private UUID idNv;
    private Integer soLuong;
    private DecimalFormat giaBan;
    private Date ngayTao;
    private Date ngaySua;
    private Boolean trangThai;

    public ChiTietHoaDonDto() {
    }

    public ChiTietHoaDonDto(UUID id, UUID idHD, UUID idSP, UUID idNv, Integer soLuong, DecimalFormat giaBan, Date ngayTao, Date ngaySua, Boolean trangThai) {
        this.id = id;
        this.idHD = idHD;
        this.idSP = idSP;
        this.idNv = idNv;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public UUID getIdNv() {
        return idNv;
    }

    public void setIdNv(UUID idNv) {
        this.idNv = idNv;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdHD() {
        return idHD;
    }

    public void setIdHD(UUID idHD) {
        this.idHD = idHD;
    }

    public UUID getIdSP() {
        return idSP;
    }

    public void setIdSP(UUID idSP) {
        this.idSP = idSP;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public DecimalFormat getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(DecimalFormat giaBan) {
        this.giaBan = giaBan;
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
