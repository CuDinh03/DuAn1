/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.bean.HoaDonBean;
import duan1_nhom1.repository.ThongKeRepository;
import java.util.List;

/**
 *
 * @author maccuacu
 */
public interface IThongKeService {
    
    
   List<HoaDonBean> getListByHoaDon ();
    
}
