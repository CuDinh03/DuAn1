/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.model.KichThuoc;
import duan1_nhom1.repository.KichThuocRepository;
import java.util.List;

/**1
 *
 * @author anhtuanle
 */
public class KichCoService implements IService<KichThuoc>{
    
    private KichThuocRepository KichThuocRepository = new KichThuocRepository();

    @Override
    public void add(KichThuoc kichThuoc) {
        KichThuocRepository.add(kichThuoc);
    }

    @Override
    public void update(KichThuoc kichThuoc, String id) {
       KichThuocRepository.update(kichThuoc);
    }

    @Override
    public void delete(String id) {
        KichThuocRepository.delete(id);
    }

    @Override
    public List<KichThuoc> getAll() {
        return KichThuocRepository.getAll();
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
