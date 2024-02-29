/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.bean;

import java.time.LocalDateTime;

/**
 *
 * @author maccuacu
 */
public class HoaDonBean {
    
    private Integer soLuongDaBan;
    private LocalDateTime ngayBan;

    public HoaDonBean() {
    }

    public HoaDonBean(Integer soLuongDaBan, LocalDateTime ngayBan) {
        this.soLuongDaBan = soLuongDaBan;
        this.ngayBan = ngayBan;
    }

    public Integer getSoLuongDaBan() {
        return soLuongDaBan;
    }

    public void setSoLuongDaBan(Integer soLuongDaBan) {
        this.soLuongDaBan = soLuongDaBan;
    }

    public LocalDateTime getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(LocalDateTime ngayBan) {
        this.ngayBan = ngayBan;
    }


    
    
    
    
}
