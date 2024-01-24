/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giao_dien.model;

import java.util.Date;

/**
 *
 * @author acer
 */
public class TaiKhoan {
    private String id ;
    private String ma;
    private String tenDangNhap ;
    private String mk ;
    private String id_cv ;
    private Date ngayTao ;
    private Date ngaySua ;
    private boolean trangThai ;

    public TaiKhoan() {
    }

    public TaiKhoan(String id, String ma, String tenDangNhap, String mk, String id_cv, Date ngayTao, Date ngaySua, boolean trangThai) {
        this.id = id;
        this.ma = ma;
        this.tenDangNhap = tenDangNhap;
        this.mk = mk;
        this.id_cv = id_cv;
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

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }

    public String getId_cv() {
        return id_cv;
    }

    public void setId_cv(String id_cv) {
        this.id_cv = id_cv;
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

    @Override
    public String toString() {
        return "TaiKhoan{" + "id=" + id + ", ma=" + ma + ", tenDangNhap=" + tenDangNhap + ", mk=" + mk + ", id_cv=" + id_cv + ", ngayTao=" + ngayTao + ", ngaySua=" + ngaySua + ", trangThai=" + trangThai + '}';
    }
    
}
