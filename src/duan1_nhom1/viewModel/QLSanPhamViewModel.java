/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.viewModel;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author anhtuanle
 */
public class QLSanPhamViewModel {
    private String maSP;
    private String tenSP;
    private String kichThuoc;
    private String thuongHieu;
    private String mauSac;
    private String chatLieu;
    private String danhMuc;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;
    private int soLuong;
    private Date ngayTao;
    private Date ngaySua;
    private Date ngayNhap;
    private int trangThai;

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public String getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public QLSanPhamViewModel(String maSP, String tenSP, String kichThuoc, String thuongHieu, String mauSac, String chatLieu, String danhMuc, BigDecimal giaNhap, BigDecimal giaBan, int soLuong, Date ngayTao, Date ngaySua, Date ngayNhap, int trangThai) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.kichThuoc = kichThuoc;
        this.thuongHieu = thuongHieu;
        this.mauSac = mauSac;
        this.chatLieu = chatLieu;
        this.danhMuc = danhMuc;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.ngayNhap = ngayNhap;
        this.trangThai = trangThai;
    }

   

//    public String getStatus(int trangThai) {
//        if (trangThai == 1) {
//            return "Còn hàng";
//        } else if (trangThai == 2) {
//            return "Đã xóa";
//        } else if (trangThai == 3) {
//            return "Hết hàng";
//        } else {
//            return "Chưa có ảnh";
//        }
//    } 
//    

    public QLSanPhamViewModel() {
    }
   

 
    
    
    
}
