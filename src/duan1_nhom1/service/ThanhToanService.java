/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.model.ThanhToan;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author WEB
 */
public class ThanhToanService implements IService<ThanhToan> {
    private List<ThanhToan> litsThanhToan = new ArrayList<>();
    private ThanhToanService thanhToanService=new ThanhToanService();
    @Override
    public void add(ThanhToan t) {
       thanhToanService.add(t);
    }

    @Override
    public void update(ThanhToan t, UUID id) {
   thanhToanService.update(t, id);
    }

    @Override
    public void delete(UUID id) {
    thanhToanService.delete(id);
    }

    @Override
    public List<ThanhToan> getAll() {
      return thanhToanService.getAll();
    }

    @Override
    public ThanhToan findById(UUID id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
