/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.dto.HoaDonDto;
import duan1_nhom1.repository.HoaDonRepository;
import duan1_nhom1.tranf.TranferData;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author maccuacu
 */
public class HoaDonService implements IService<HoaDonDto>{
    
    HoaDonRepository repo = new HoaDonRepository();

    @Override
    public void add(HoaDonDto t) {
        this.repo.createHoaDon(TranferData.convertToEntity(t));
    }

    @Override
    public void update(HoaDonDto t, UUID id) {
        this.repo.updateHoaDon(TranferData.convertToEntity(t));
    }

    @Override
    public void delete(UUID id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HoaDonDto> getAll() {
        
        return TranferData.convertListToDto(this.repo.getAllHoaDon());
    }

    @Override
    public HoaDonDto findById(UUID id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
    
    
}
