/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.model;
import java.sql.Date;
/**
 *
 * @author WEB
 */
public class ChucVu {
    private String id;
    private String ma;
     private String tenCV;
     private Date ngayTao;
     private Date ngaySua;
     private boolean trangTai;

    public ChucVu() {
    }

    public ChucVu(String id, String ma, String tenCV, Date ngayTao, Date ngaySua, boolean trangTai) {
        this.id = id;
        this.ma = ma;
        this.tenCV = tenCV;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangTai = trangTai;
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

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
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

    public boolean isTrangTai() {
        return trangTai;
    }

    public void setTrangTai(boolean trangTai) {
        this.trangTai = trangTai;
    }

    @Override
    public String toString() {
        return this.getTenCV();
    }

    
}
