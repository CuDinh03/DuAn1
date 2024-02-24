/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.model.Hang;
import duan1_nhom1.repository.HangRepository;
import java.util.List;

/**1
 *
 * @author anhtuanle
 */
public class HangService implements IService<Hang>{
    private HangRepository hangRepository;
    
    public HangService(){
        hangRepository = new HangRepository();
    }
    @Override
    public void add(Hang t) {
        hangRepository.addNew(t);
    }

    @Override
    public void update(Hang t, String id) {
        hangRepository.update(t,id);
    }

    @Override
    public void delete(String id) {
        hangRepository.delete(id);
    }

    @Override
    public List<Hang> getAll() {
        return hangRepository.getAll();
    }

    @Override
    public Hang findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String getTenById(String id) {
        return hangRepository.getTenById(id);
    }
    
   
    public List<String> getAllTen() {
        return hangRepository.getAllTen();
    }
    
    public List<String> getAllId() {
        return hangRepository.getAllId();
    }
    
}
