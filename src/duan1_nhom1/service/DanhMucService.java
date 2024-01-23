/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.model.DanhMuc;
import duan1_nhom1.repository.DanhMucRepository;
import java.util.List;

/**
 *
 * @author anhtuanle
 */
public class DanhMucService implements IService<DanhMuc> {

    private DanhMucRepository danhMucRepository = new DanhMucRepository();

   

    public String getTenById(String id) {
        return danhMucRepository.getTenById(id);
    }

    public List<String> getAllTen() {
        return danhMucRepository.getAllTen();
    }

    public List<String> getAllId() {
        return danhMucRepository.getAllId();
    }

    @Override
    public void add(DanhMuc danhMuc) {
        danhMucRepository.insert(danhMuc);}

    @Override
    public void update(DanhMuc danhMuc, String id) {
        danhMucRepository.update(danhMuc, id);}

    @Override
    public void delete(String id) {
        danhMucRepository.delete(id);}

    @Override
    public List<DanhMuc> getAll() {
        return danhMucRepository.getAll();}

    @Override
    public DanhMuc findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
