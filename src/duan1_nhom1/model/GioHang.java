package duan1_nhom1.model;

import java.util.Date;

public class GioHang {
    private String id;
    private String ma;
    private String idKH;
    private Date ngayTao;
    private Date ngaySua;
    private Boolean trangThai;

    public GioHang() {
    }
    

    public GioHang(String id, String ma, String idKH, Date ngayTao, Date ngaySua, Boolean trangThai) {
        this.id = id;
        this.ma = ma;
        this.idKH = idKH;
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

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
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
        return "ShoppingCart{" +
                "id=" + id +
                ", ma='" + ma + '\'' +
                ", idKH=" + idKH +
                ", ngayTao=" + ngayTao +
                ", ngaySua=" + ngaySua +
                ", trangThai=" + trangThai +
                '}';
    }
}

