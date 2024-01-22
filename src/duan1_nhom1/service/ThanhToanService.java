/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.model.ThanhToan;
import duan1_nhom1.repository.ThanhToanRepo;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author WEB
 */
public class ThanhToanService implements IService<ThanhToan> {
    private List<ThanhToan>listTT=new ArrayList<>();
    private ThanhToanRepo thanhToanRepo=new ThanhToanRepo();
    @Override
    public void add(ThanhToan t) {
       thanhToanRepo.addThanhToan(t);
    }

    @Override
    public void update(ThanhToan t, String  id) {
   thanhToanRepo.updateThanhToan(t, id);
    }

    @Override
    public void delete(String id) {
    thanhToanRepo.deleteThanhToan(id);
    }

    @Override
    public List<ThanhToan> getAll() {
      return thanhToanRepo.getAll();
    }

    @Override
    public ThanhToan findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
