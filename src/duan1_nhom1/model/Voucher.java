/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.model;

import java.util.Date;

/**
 *
 * @author maccuacu
 */
public class Voucher {
    private String id;
    private String ma;
    private String ten;
    private Float giamGia;
    private Date ngayDau;
    private Date ngayCuoi;
    private int soLuong;
    private String moTa;
    private Date ngayTao;
    private Date ngaySua;
    private boolean trangThai;

    public Voucher() {
    }

    public Voucher(String id, String ma, String ten, Float giamGia, Date ngayDau, Date ngayCuoi, int soLuong, String moTa, Date ngayTao, Date ngaySua, boolean trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.giamGia = giamGia;
        this.ngayDau = ngayDau;
        this.ngayCuoi = ngayCuoi;
        this.soLuong = soLuong;
        this.moTa = moTa;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
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

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Float getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(Float giamGia) {
        this.giamGia = giamGia;
    }

    public Date getNgayDau() {
        return ngayDau;
    }

    public void setNgayDau(Date ngayDau) {
        this.ngayDau = ngayDau;
    }

    public Date getNgayCuoi() {
        return ngayCuoi;
    }

    public void setNgayCuoi(Date ngayCuoi) {
        this.ngayCuoi = ngayCuoi;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
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

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
}
