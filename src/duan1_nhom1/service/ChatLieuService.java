/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.dto.ChatLieuDto;
import duan1_nhom1.model.ChatLieu;
import duan1_nhom1.repository.ChatLieuRepository;
import duan1_nhom1.tranf.TranferData;
import java.util.List;

/**
 * 1
 *
 * @author anhtuanle
 */
public class ChatLieuService implements IService<ChatLieuDto> {

    private ChatLieuRepository chatLieuRepository = new ChatLieuRepository();

    @Override
    public void add(ChatLieuDto t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(ChatLieuDto t, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ChatLieuDto> getAll() {
        return TranferData.convertListChatLieuToDto(chatLieuRepository.getAll());
    }

    @Override
    public ChatLieuDto findById(String id) {
        return TranferData.convertToDto(this.chatLieuRepository.findByid(id));
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
