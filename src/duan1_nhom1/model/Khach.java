/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.model;

<<<<<<< HEAD
import java.util.UUID;
import java.sql.Date;
=======
import java.util.Date;
>>>>>>> master

/**
 *
 * @author maccuacu
 */
public class Khach {
<<<<<<< HEAD
    private String id;
=======
     private String id;
>>>>>>> master
    private String maKhachHang;
    private String tenKhachHang;
    private String sdt;
    private Date ngayTao;
    private Date ngaySua;
    private Boolean trangThai;

    public Khach() {
    }

    public Khach(String id, String maKhachHang, String tenKhachHang, String sdt, Date ngayTao, Date ngaySua, Boolean trangThai) {
        this.id = id;
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.sdt = sdt;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }
<<<<<<< HEAD

=======
>>>>>>> master
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
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
<<<<<<< HEAD

   
=======
>>>>>>> master
    
}
