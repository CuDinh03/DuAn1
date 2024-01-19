/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.repository.DanhMucRepository;
import java.util.List;
import org.apache.poi.ss.formula.functions.T;

/**
 *
 * @author anhtuanle
 */
public class DanhMucService implements IService {

    private DanhMucRepository danhMucRepository = new DanhMucRepository();

    @Override
    public void add(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Object t, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List getAll() {
        return danhMucRepository.getAll();
    }

    @Override
    public Object findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getTenById(String id) {
        return danhMucRepository.getTenById(id);
    }

    public List<String> getAllTen() {
        return danhMucRepository.getAllTen();
    }

    public List<String> getAllId() {
        return danhMucRepository.getAllId();
    }

}
