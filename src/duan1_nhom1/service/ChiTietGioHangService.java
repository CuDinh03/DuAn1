/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.dto.ChiTietGioHangDto;
import duan1_nhom1.repository.ChiTietGioHangRepository;
import duan1_nhom1.tranf.TranferData;
import java.util.List;

/**
 *
 * @author maccuacu
 */
public class ChiTietGioHangService implements IService<ChiTietGioHangDto> {

    

    ChiTietGioHangRepository repo = new ChiTietGioHangRepository();

    public void changeSL(ChiTietGioHangDto ctghView) {
       this.repo.changeQuantity(TranferData.convertToEntity(ctghView));  }
    
    @Override
    public void add(ChiTietGioHangDto t) {
        this.repo.createChiTietGioHang(TranferData.convertToEntity(t));
    }

    @Override
    public void update(ChiTietGioHangDto t, String id) {
        this.repo.updateChiTietGioHang(TranferData.convertToEntity(t));

    }

    @Override
    public void delete(String id) {
        this.repo.deleteChiTietGioHang(id);
    }

    @Override
    public List<ChiTietGioHangDto> getAll() {
        return TranferData.convertListToDto(this.repo.getAllChiTietGioHang());
    }

    @Override
    public ChiTietGioHangDto findById(String id) {
        return TranferData.convertToDto(this.repo.findById(id));
    }
    

}