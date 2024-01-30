/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.dto;

/**
 *
 * @author maccuacu
 */
public class NgayThangDto {
    private int thang;
    private Integer ngay;

    public NgayThangDto() {
    }
    

    public NgayThangDto(int thang) {
        this.thang = thang;
    }
    
    public NgayThangDto(Integer ngay){
        this.ngay = ngay;
    }
    
    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public Integer getNgay() {
        return ngay;
    }

    public void setNgay(Integer ngay) {
        this.ngay = ngay;
    }

    @Override
    public String toString() {
        return "thang " + thang ;
    }
    
}
