/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.service;

import duan1_nhom1.dto.VoucherDto;
import duan1_nhom1.model.Voucher;
import duan1_nhom1.repository.VoucherRepo;
import duan1_nhom1.tranf.TranferData;
import java.util.List;

/**
 *
 * @author bachh
 */
public class VoucherService implements IService<VoucherDto> {
    VoucherRepo voucherRepo = new VoucherRepo();

    @Override
    public void add(VoucherDto t) {
        this.voucherRepo.createVoucher(TranferData.convertToEntity(t));
    }

    @Override
    public void update(VoucherDto t, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<VoucherDto> getAll() {
        return TranferData.convertListVoucherToDto(this.voucherRepo.getAll());
    }

    @Override
    public VoucherDto findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
