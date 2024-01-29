/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.dto.GioHangDto;
import duan1_nhom1.repository.GioHangRepository;
import duan1_nhom1.tranf.TranferData;
import java.util.List;

/**
 *
 * @author maccuacu
 */
public class GioHangService implements IService<GioHangDto> {

    GioHangRepository repo = new GioHangRepository();

    @Override
    public void add(GioHangDto t) {
        this.repo.createGioHang(TranferData.convertToEntity(t));
    }

    @Override
    public void update(GioHangDto t, String id) {
        this.repo.updateGioHang(TranferData.convertToEntity(t));
    }

    @Override
    public void delete(String id) {
        this.repo.deleteGioHang(id);
    }

    @Override
    public List<GioHangDto> getAll() {
        return TranferData.convertListGioHangToDto(this.repo.getAllGioHang());
    }

    @Override
    public GioHangDto findById(String id) {
        return TranferData.convertToDto(this.repo.findById(id));
    }

    public GioHangDto findByMa(String ma) {
        return TranferData.convertToDto(this.repo.findByMa(ma));
    }

}
