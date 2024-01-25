/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.model.ChatLieu;
import duan1_nhom1.repository.ChatLieuRepository;
import java.util.List;

/**
 *1
 * @author anhtuanle
 */
public class ChatLieuService implements IService<ChatLieu>{
    
    private ChatLieuRepository chatLieuRepository = new ChatLieuRepository();

    @Override
    public void add(ChatLieu t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(ChatLieu t, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ChatLieu> getAll() {
       return chatLieuRepository.getAll();
    }

    @Override
    public ChatLieu findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String getTenById(String id) {
        return chatLieuRepository.getTenById(id);
    }

    public List<String> getAllTen() {
        return chatLieuRepository.getAllTen();
    }

    public List<String> getAllId() {
        return chatLieuRepository.getAllId();
    }
    
}
