/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.bean;

/**
 *
 * @author maccuacu
 */
public class HoaDonBean {
    
    private Integer soLuongDaBan;
    private String ngayBan;

    public HoaDonBean() {
    }

    public HoaDonBean(Integer soLuongDaBan, String ngayBan) {
        this.soLuongDaBan = soLuongDaBan;
        this.ngayBan = ngayBan;
    }

    public Integer getSoLuongDaBan() {
        return soLuongDaBan;
    }

    public void setSoLuongDaBan(Integer soLuongDaBan) {
        this.soLuongDaBan = soLuongDaBan;
    }

    public String getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(String ngayBan) {
        this.ngayBan = ngayBan;
    }
    
    
    
    
}
