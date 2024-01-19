/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.model.SanPham;
import duan1_nhom1.repository.SanPhamRepository;
import duan1_nhom1.viewModel.QLSanPhamViewModel;
import java.util.List;

/**
 *
 * @author anhtuanle
 */
public class SanPhamService implements IService<SanPham> {

    private SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    public void add(SanPham t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(SanPham t, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SanPham> getAll() {
        return sanPhamRepository.getAll();
    }

    @Override
    public SanPham findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getTenById(String id) {
        return sanPhamRepository.getTenById(id);
    }

    public List<String> getAllTen() {
        return sanPhamRepository.getAllTen();
    }

    public List<String> getAllId() {
        return sanPhamRepository.getAllId();
    }

}
