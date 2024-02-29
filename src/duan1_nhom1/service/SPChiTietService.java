
package duan1_nhom1.service;

import duan1_nhom1.dto.ChiTietSanPhamDto;
import duan1_nhom1.model.ChiTietSanPham;
import duan1_nhom1.repository.SPChiTietRepository;
import duan1_nhom1.tranf.TranferData;
import java.util.ArrayList;
import java.util.List;


public class SPChiTietService implements IService<ChiTietSanPhamDto> {

    private SPChiTietRepository sPChiTietRepository = new SPChiTietRepository();

    public String insert(ChiTietSanPhamDto t) {
        t.setMa(t.getMa());

        t.setIdThuongHieu(t.getIdThuongHieu());
        t.setIdMauSac(t.getIdMauSac());
        t.setIdDanhMuc(t.getIdDanhMuc());
        t.setIdChatLieu(t.getIdChatLieu());
        t.setIdSanPham(t.getIdSanPham());
        t.setIdKichThuoc(t.getIdKichThuoc());
        t.setGiaNhap(t.getGiaNhap());
        t.setGiaBan(t.getGiaBan());
        t.setSoLuong(t.getSoLuong());
        t.setNgayNhap(t.getNgayNhap());
        t.setNgaySua(t.getNgaySua());
        t.setNgayTao(t.getNgayTao());
        t.setTrangThai(t.getTrangThai());

        if (this.sPChiTietRepository.insert(TranferData.convertToEntity(t))) {
            return "Thêm thành công !";
        } else {
            return "Thêm thất bại !";
        }
    }

    @Override
    public void add(ChiTietSanPhamDto t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(ChiTietSanPhamDto t, String id) {
        t.setMa(t.getMa());

        t.setIdThuongHieu(t.getIdThuongHieu());
        t.setIdMauSac(t.getIdMauSac());
        t.setIdDanhMuc(t.getIdDanhMuc());
        t.setIdChatLieu(t.getIdChatLieu());
        t.setIdSanPham(t.getIdSanPham());
        t.setIdKichThuoc(t.getIdKichThuoc());
        t.setGiaNhap(t.getGiaNhap());
        t.setGiaBan(t.getGiaBan());
        t.setSoLuong(t.getSoLuong());
        t.setNgayNhap(t.getNgayNhap());
        t.setNgaySua(t.getNgaySua());
        t.setNgayTao(t.getNgayTao());
        t.setTrangThai(t.getTrangThai());

        if (this.sPChiTietRepository.updateSP(TranferData.convertToEntity(t), id)) {
            System.out.println("Thêm thành công !");
        } else {
            System.out.println("Thêm thất bại !");

        }
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    public List<ChiTietSanPhamDto> getAll() {
        return TranferData.convertListToDtos(sPChiTietRepository.getAll());
    }

    @Override
    public ChiTietSanPhamDto findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void deleteSP(String id) {
        sPChiTietRepository.delete(id);
    }

    public ChiTietSanPhamDto findByMa(String ma) {
        return TranferData.convertToDto(this.sPChiTietRepository.findByMa(ma));
    }

    public ChiTietSanPhamDto findByMaCt(String ma) {
        return TranferData.convertToDto(this.sPChiTietRepository.findByMaCt(ma));
    }

    public ChiTietSanPhamDto findByIdSP(String idSP) {
        return TranferData.convertToDto(this.sPChiTietRepository.findByIDsp(idSP));
    }

    public void changeSL(ChiTietSanPhamDto ctsp) {
        this.sPChiTietRepository.changeQuantity(TranferData.convertToEntity(ctsp));
    }

    public List<ChiTietSanPhamDto> getAllByIdSp(String id) {
        return TranferData.convertListToDtos(this.sPChiTietRepository.getAllChiTietGioHangByIdsp(id));
    }
    public List<ChiTietSanPham> getAllByIdDm(String id) {
        return sPChiTietRepository.getAllByIdDm(id);
    }
 public ChiTietSanPhamDto findByMaCtLike(String ma) {
        return TranferData.convertToDto(this.sPChiTietRepository.findByMaCtLike(ma));
    }
 
 public List<ChiTietSanPhamDto> getAllSPHadDm() {

        List<ChiTietSanPhamDto> listViewModel = new ArrayList<>();

        for (ChiTietSanPhamDto domainModel : TranferData.convertListToDtos(sPChiTietRepository.getAllSPHadDm())) {
            ChiTietSanPhamDto t = new ChiTietSanPhamDto();
            t.setMa(domainModel.getMa());

        t.setIdThuongHieu(domainModel.getIdThuongHieu());
        t.setIdMauSac(domainModel.getIdMauSac());
        t.setIdDanhMuc(domainModel.getIdDanhMuc());
        t.setIdChatLieu(domainModel.getIdChatLieu());
        t.setIdSanPham(domainModel.getIdSanPham());
        t.setIdKichThuoc(domainModel.getIdKichThuoc());
        t.setGiaNhap(domainModel.getGiaNhap());
        t.setGiaBan(domainModel.getGiaBan());
        t.setSoLuong(domainModel.getSoLuong());
        t.setNgayNhap(domainModel.getNgayNhap());
        t.setNgaySua(domainModel.getNgaySua());
        t.setNgayTao(domainModel.getNgayTao());
        t.setTrangThai(domainModel.getTrangThai());

            listViewModel.add(t);
        }
        return listViewModel;
    }
 
 public List<ChiTietSanPhamDto> findByDm(String dm) {
        List<ChiTietSanPhamDto> listViewModel = new ArrayList<>();


        for (ChiTietSanPhamDto domainModel : TranferData.convertListToDtos(sPChiTietRepository.findByDm(dm))) {
            
            ChiTietSanPhamDto t = new ChiTietSanPhamDto();
            t.setMa(domainModel.getMa());

        t.setIdThuongHieu(domainModel.getIdThuongHieu());
        t.setIdMauSac(domainModel.getIdMauSac());
        t.setIdDanhMuc(domainModel.getIdDanhMuc());
        t.setIdChatLieu(domainModel.getIdChatLieu());
        t.setIdSanPham(domainModel.getIdSanPham());
        t.setIdKichThuoc(domainModel.getIdKichThuoc());
        t.setGiaNhap(domainModel.getGiaNhap());
        t.setGiaBan(domainModel.getGiaBan());
        t.setSoLuong(domainModel.getSoLuong());
        t.setNgayNhap(domainModel.getNgayNhap());
        t.setNgaySua(domainModel.getNgaySua());
        t.setNgayTao(domainModel.getNgayTao());
        t.setTrangThai(domainModel.getTrangThai());

            listViewModel.add(t);
        }
        return listViewModel;
    }
 

}
