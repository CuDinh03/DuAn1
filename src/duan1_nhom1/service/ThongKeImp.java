/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.bean.HoaDonBean;
import duan1_nhom1.repository.ThongKeRepository;
import java.util.List;

/**
 *1
 * @author maccuacu
 */
public class ThongKeImp implements IThongKeService{
    
    private ThongKeRepository repo = new ThongKeRepository();
    
    @Override
    public List<HoaDonBean> getListByHoaDon() {
        return repo.getList();
    }
    
    
    
}
