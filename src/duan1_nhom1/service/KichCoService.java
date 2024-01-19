/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.model.KichThuoc;
import duan1_nhom1.repository.KichThuocRepository;
import java.util.List;

/**
 *
 * @author anhtuanle
 */
public class KichCoService implements IService<KichThuoc>{
    
    private KichThuocRepository KichThuocRepository = new KichThuocRepository();

    @Override
    public void add(KichThuoc t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(KichThuoc t, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<KichThuoc> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public KichThuoc findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
      public String getTenById(String id) {
        return KichThuocRepository.getTenById(id);
    }
    
   
    public List<String> getAllTen() {
        return KichThuocRepository.getAllTen();
    }
    
    public List<String> getAllId() {
        return KichThuocRepository.getAllId();
    }

}
