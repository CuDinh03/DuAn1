/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.model.ThanhToan;
<<<<<<< HEAD
=======
import duan1_nhom1.repository.ThanhToanRepo;
>>>>>>> master
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author WEB
 */
public class ThanhToanService implements IService<ThanhToan> {
<<<<<<< HEAD
    private List<ThanhToan> litsThanhToan = new ArrayList<>();
    private ThanhToanService thanhToanService=new ThanhToanService();
    @Override
    public void add(ThanhToan t) {
       thanhToanService.add(t);
=======
    private List<ThanhToan>listTT=new ArrayList<>();
    private ThanhToanRepo thanhToanRepo=new ThanhToanRepo();
    @Override
    public void add(ThanhToan t) {
       thanhToanRepo.addThanhToan(t);
>>>>>>> master
    }

    @Override
    public void update(ThanhToan t, String  id) {
<<<<<<< HEAD
   thanhToanService.update(t, id);
=======
   thanhToanRepo.updateThanhToan(t, id);
>>>>>>> master
    }

    @Override
    public void delete(String id) {
<<<<<<< HEAD
    thanhToanService.delete(id);
=======
    thanhToanRepo.deleteThanhToan(id);
>>>>>>> master
    }

    @Override
    public List<ThanhToan> getAll() {
<<<<<<< HEAD
      return thanhToanService.getAll();
=======
      return thanhToanRepo.getAll();
>>>>>>> master
    }

    @Override
    public ThanhToan findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
