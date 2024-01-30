package duan1_nhom1.model;

import java.util.Date;

public class GioHangHoaDon {
    private String id;
    private String idGioHang;
    private String idHoaDon;
    private Date ngayTao;
    private Date ngaySua;
    private Boolean trangThai;

    public GioHangHoaDon() {
    }

    public GioHangHoaDon(String id, String idGioHang, String idHoaDon, Date ngayTao, Date ngaySua, Boolean trangThai) {
        this.id = id;
        this.idGioHang = idGioHang;
        this.idHoaDon = idHoaDon;
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

    public String getIdGioHang() {
        return idGioHang;
    }

    public void setIdGioHang(String idGioHang) {
        this.idGioHang = idGioHang;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
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
