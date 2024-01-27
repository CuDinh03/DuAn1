/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.dto.ChiTietHoaDonDto;
import duan1_nhom1.repository.ChiTietHoaDonRepository;
import duan1_nhom1.tranf.TranferData;
import java.util.List;

/**
 *
 * @author maccuacu
 */
public class ChiTietHoaDonService implements IService<ChiTietHoaDonDto>{
    
    private ChiTietHoaDonRepository repo = new ChiTietHoaDonRepository();

    @Override
    public void add(ChiTietHoaDonDto t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(ChiTietHoaDonDto t, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ChiTietHoaDonDto> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ChiTietHoaDonDto findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public List<ChiTietHoaDonDto> getAllByIdHd(String id){
        return TranferData.convertListCTHDToDto(repo.getAllChiTietHoaDonByIDHd(id));
    }
    
}
