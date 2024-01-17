/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.model;

import java.util.UUID;
import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author maccuacu
 */
public class ThanhToan {
    private UUID id;
    private String maThanhToan;
    private UUID id_hd;
    private String phuongThucTT;
    private BigDecimal soTien;
    private Date ngayTT;
    private Date ngayTao;
    private Date ngaySua;
    private Boolean trangThai;

    public ThanhToan() {
    }

    public ThanhToan(UUID id, String maThanhToan, UUID id_hd, String phuongThucTT, BigDecimal soTien, Date ngayTT, Date ngayTao, Date ngaySua, Boolean trangThai) {
        this.id = id;
        this.maThanhToan = maThanhToan;
        this.id_hd = id_hd;
        this.phuongThucTT = phuongThucTT;
        this.soTien = soTien;
        this.ngayTT = ngayTT;
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

    public String getMaThanhToan() {
        return maThanhToan;
    }

    public void setMaThanhToan(String maThanhToan) {
        this.maThanhToan = maThanhToan;
    }

    public UUID getId_hd() {
        return id_hd;
    }

    public void setId_hd(UUID id_hd) {
        this.id_hd = id_hd;
    }

    public String getPhuongThucTT() {
        return phuongThucTT;
    }

    public void setPhuongThucTT(String phuongThucTT) {
        this.phuongThucTT = phuongThucTT;
    }

    public BigDecimal getSoTien() {
        return soTien;
    }

    public void setSoTien(BigDecimal soTien) {
        this.soTien = soTien;
    }

    public Date getNgayTT() {
        return ngayTT;
    }

    public void setNgayTT(Date ngayTT) {
        this.ngayTT = ngayTT;
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

    @Override
    public String toString() {
        return "ThanhToan{" + "id=" + id + ", maThanhToan=" + maThanhToan + ", id_hd=" + id_hd + ", phuongThucTT=" + phuongThucTT + ", soTien=" + soTien + ", ngayTT=" + ngayTT + ", ngayTao=" + ngayTao + ", ngaySua=" + ngaySua + ", trangThai=" + trangThai + '}';
    }

   
}
