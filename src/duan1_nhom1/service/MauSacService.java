/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.model.MauSac;
import duan1_nhom1.repository.MauSacRepository;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.formula.functions.T;

/**
 *
 * @author anhtuanle
 */
public class MauSacService implements IService<MauSac>{
    
    private MauSacRepository mauSacRepository;
    
    public MauSacService(){
        mauSacRepository = new MauSacRepository();
    }

    @Override
    public void add(MauSac t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(MauSac t, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<MauSac> getAll() {
       return mauSacRepository.getAll();
    }

    @Override
    public MauSac findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     public String getTenById(String id) {
        return mauSacRepository.getTenById(id);
    }
    
   
    public List<String> getAllTen() {
        return mauSacRepository.getAllTen();
    }
    
    public List<String> getAllId() {
        return mauSacRepository.getAllId();
    }

    
}
