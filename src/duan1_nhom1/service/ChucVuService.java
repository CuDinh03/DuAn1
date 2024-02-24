/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.model.ChucVu;
import duan1_nhom1.repository.ChucVuRepository;
import java.util.List;

/**
 *
 * @author acer
 */
public class ChucVuService implements IService<ChucVu>{
    ChucVuRepository chucVuRepository =new ChucVuRepository();
    @Override
    public void add(ChucVu t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(ChucVu t, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ChucVu> getAll() {
        return chucVuRepository.getAll();
    }

    @Override
    public ChucVu findById(String id) {
        return chucVuRepository.getChucVuById(id);
    }
    
    public String getTenById(String id) {
        return chucVuRepository.getTenById(id);
    }

    public List<String> getAllTen() {
        return chucVuRepository.getAllTen();
    }

    public List<String> getAllId() {
        return chucVuRepository.getAllId();
    }
    
}
