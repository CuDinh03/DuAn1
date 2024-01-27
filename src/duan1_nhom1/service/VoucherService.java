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
public class VoucherService implements IService<Voucher> {
    VoucherRepo voucherRepo = new VoucherRepo();

    @Override
    public void add(Voucher t) {
        this.voucherRepo.createVoucher(t);
    }

    @Override
    public void update(Voucher t, String id) {
        this.voucherRepo.updateVoucher(t, id);
    }

    @Override
    public void delete(String id) {
        voucherRepo.delete(id);
    }

    @Override
    public List<Voucher> getAll() {
        return voucherRepo.getAll();
    }

    @Override
    public Voucher findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}
