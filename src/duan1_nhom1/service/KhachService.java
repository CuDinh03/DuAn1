/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;
import duan1_nhom1.dto.KhachDto;
import duan1_nhom1.repository.KhachRepo;
import duan1_nhom1.tranf.TranferData;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author maccuacu
 */
public class KhachService implements IService<KhachDto>{
    
    KhachRepo repo = new KhachRepo();

    @Override
    public void add(KhachDto t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(KhachDto t, UUID id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(UUID id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<KhachDto> getAll() {
        return TranferData.convertListKhachToDto(this.repo.getAll());
    }

    @Override
    public KhachDto findById(UUID id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
