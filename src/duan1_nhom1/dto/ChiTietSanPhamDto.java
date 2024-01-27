/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author maccuacu
 */
public class ChiTietSanPhamDto {

    private String id;
    private String ma;
    private String idSanPham;
    private String idKichThuoc;
    private String idThuongHieu;
    private String idMauSac;
    private String idChatLieu;
    private String idDanhMuc;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;
    private Integer soLuong;
    private Date ngayTao;
    private Date ngaySua;
    private Date ngayNhap;
    private Boolean trangThai;

    public ChiTietSanPhamDto() {
    }

    public ChiTietSanPhamDto(String id, String ma, String idSanPham, String idKichThuoc, String idThuongHieu, String idMauSac, String idChatLieu, String idDanhMuc, BigDecimal giaNhap, BigDecimal giaBan, Integer soLuong, Date ngayTao, Date ngaySua, Date ngayNhap, Boolean trangThai) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getIdKichThuoc() {
        return idKichThuoc;
    }

    public void setIdKichThuoc(String idKichThuoc) {
        this.idKichThuoc = idKichThuoc;
    }

    public String getIdThuongHieu() {
        return idThuongHieu;
    }

    public void setIdThuongHieu(String idThuongHieu) {
        this.idThuongHieu = idThuongHieu;
    }

    public String getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(String idMauSac) {
        this.idMauSac = idMauSac;
    }

    public String getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(String idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    public String getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(String idDanhMuc) {
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

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
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

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

}
