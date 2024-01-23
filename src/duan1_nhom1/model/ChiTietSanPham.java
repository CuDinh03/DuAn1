/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.model;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author maccuacu
 */
public class ChiTietSanPham {
    private UUID id;
    private String ma;
    private UUID idSanPham;
    private UUID idKichThuoc;
    private UUID idThuongHieu;
    private UUID idMauSac;
    private UUID idChatLieu;
    private UUID idDanhMuc;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;
    private int soLuong;
    private Date ngayTao;
    private Date ngaySua;
    private Date ngayNhap;
    private boolean trangThai;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(UUID id, String ma, UUID idSanPham, UUID idKichThuoc, UUID idThuongHieu, UUID idMauSac, UUID idChatLieu, UUID idDanhMuc, BigDecimal giaNhap, BigDecimal giaBan, int soLuong, Date ngayTao, Date ngaySua, Date ngayNhap, boolean trangThai) {
        this.id = id;
        this.ma = ma;
        this.idSanPham = idSanPham;
        this.idKichThuoc = idKichThuoc;
        this.idThuongHieu = idThuongHieu;
        this.idMauSac = idMauSac;
        this.idChatLieu = idChatLieu;
        this.idDanhMuc = idDanhMuc;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.ngayNhap = ngayNhap;
        this.trangThai = trangThai;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public UUID getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(UUID idSanPham) {
        this.idSanPham = idSanPham;
    }

    public UUID getIdKichThuoc() {
        return idKichThuoc;
    }

    public void setIdKichThuoc(UUID idKichThuoc) {
        this.idKichThuoc = idKichThuoc;
    }

    public UUID getIdThuongHieu() {
        return idThuongHieu;
    }

    public void setIdThuongHieu(UUID idThuongHieu) {
        this.idThuongHieu = idThuongHieu;
    }

    public UUID getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(UUID idMauSac) {
        this.idMauSac = idMauSac;
    }

    public UUID getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(UUID idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    public UUID getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(UUID idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
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

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }


}
