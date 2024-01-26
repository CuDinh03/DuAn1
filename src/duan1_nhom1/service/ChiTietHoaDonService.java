/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.model.ChiTietHoaDon;
import duan1_nhom1.repository.ChiTietHoaDonRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WEB
 */
public class ChiTietHoaDonService implements IService<ChiTietHoaDon>{
 private List<ChiTietHoaDon>listHDCT=new ArrayList<>();
 private ChiTietHoaDonRepository ChiTietHoaDon=new ChiTietHoaDonRepository();
    @Override
    public void add(ChiTietHoaDon t) {
      ChiTietHoaDon.createChiTietHoaDon(t);
    }

    @Override
    public void update(ChiTietHoaDon t, String id) {
    ChiTietHoaDon.updateChiTietHoaDon(t);
    }

    @Override
    public void delete(String id) {
    
    }

    @Override
    public List<ChiTietHoaDon> getAll() {
    return ChiTietHoaDon.getAllChiTietHoaDon();
    }

    @Override
    public ChiTietHoaDon findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
