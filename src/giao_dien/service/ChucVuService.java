/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giao_dien.service;

import giao_dien.Repository.ChucVuRepository;
import giao_dien.model.ChucVu;
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
    public ChucVu findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public String getTenById(String id) {
        return chucVuRepository.getTenById(id);
    }

    public List<String> getAllTen() {
        return chucVuRepository.getAllId();
    }

    public List<String> getAllId() {
        return chucVuRepository.getAllId();
    }
}
