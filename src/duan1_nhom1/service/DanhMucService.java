/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.dto.DanhMucDto;
import duan1_nhom1.model.DanhMuc;
import duan1_nhom1.repository.DanhMucRepository;
import duan1_nhom1.tranf.TranferData;
import java.util.List;

/**
 *
 * @author anhtuanle
 */
public class DanhMucService implements IService<DanhMucDto> {

    DanhMucRepository danhMucRepository = new DanhMucRepository();

    @Override
    public void add(DanhMucDto dm) {
        this.danhMucRepository.addDanhMuc(TranferData.convertToEntity(dm));
    }

//    @Override
//    public void update(Object t, String id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List getAll() {
        return danhMucRepository.getAll();
    }

//    @Override
//    public Object findById(String id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

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
    public void update(DanhMucDto t, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public DanhMucDto findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
