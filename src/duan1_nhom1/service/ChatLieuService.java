/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.dto.ChatLieuDto;
import duan1_nhom1.model.ChatLieu;
import duan1_nhom1.model.DanhMuc;
import duan1_nhom1.repository.ChatLieuRepository;
import duan1_nhom1.tranf.TranferData;
import duan1_nhom1.utils.JdbcHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 1
 *
 * @author anhtuanle
 */
public class ChatLieuService implements IService<ChatLieuDto> {

    private ChatLieuRepository chatLieuRepository = new ChatLieuRepository();

    @Override
    public void add(ChatLieuDto chatLieu) {
        chatLieuRepository.addNew(TranferData.convertToEntity(chatLieu));
    }

    @Override
    public void update(ChatLieuDto chatLieu, String id) {
        chatLieuRepository.update(TranferData.convertToEntity(chatLieu));
    }

    @Override
    public void delete(String id) {
        chatLieuRepository.delete(id);
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
    
    public List<ChatLieu> timKiem(String ma, String ten) {
        String sql = """
                 SELECT [ma]
                        ,[ten]
                        ,[mo_ta]
                        ,[ngay_tao]
                        ,[ngay_sua]
                        ,[trang_thai]
                   FROM [dbo].[chat_lieu]
                   WHERE [ma] = ? OR [ten] = ?;
                 """;

        try (Connection con = JdbcHelper.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setObject(1, ma);
            ps.setObject(2, ten);

            try (ResultSet rs = ps.executeQuery()) {
                List<ChatLieu> list = new ArrayList<>();
                while (rs.next()) {
                    ChatLieu cl = new ChatLieu();
                    cl.setMa(rs.getString(1));
                    cl.setTen(rs.getString(2));
                    cl.setMoTa(rs.getString(3));
                    cl.setNgayTao(rs.getDate(4));
                    cl.setNgaySua(rs.getDate(5));
                    cl.setTrangThai(rs.getBoolean(6));
                    list.add(cl);
                }
                return list;
            }

        } catch (Exception e) {
            // Log the exception using a logging framework like log4j or slf4j
            e.printStackTrace();
        }
        return null;
    }

}
