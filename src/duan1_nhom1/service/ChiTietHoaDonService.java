package duan1_nhom1.service;

import duan1_nhom1.dto.ChiTietHoaDonDto;
import duan1_nhom1.repository.ChiTietHoaDonRepository;
import duan1_nhom1.tranf.TranferData;
import java.util.List;

/**
 *
 * @author maccuacu
 */
public class ChiTietHoaDonService implements IService<ChiTietHoaDonDto> {

    private ChiTietHoaDonRepository repo = new ChiTietHoaDonRepository();

    @Override
    public void add(ChiTietHoaDonDto t) {
        this.repo.createChiTietHoaDon(TranferData.convertToEntity(t));
    }

    @Override
    public void update(ChiTietHoaDonDto t, String id) {
        this.repo.updateChiTietHoaDon(TranferData.convertToEntity(t));
    }

    public void update2(ChiTietHoaDonDto t) {
        this.repo.updateChiTietHoaDon(TranferData.convertToEntity(t));
    }

    @Override
    public void delete(String id) {
        this.repo.deleteChiTietHoaDon(id);
    }

    @Override
    public List<ChiTietHoaDonDto> getAll() {
        return TranferData.convertListCTHDToDto(this.repo.getAllChiTietHoaDon());
    }

    @Override
    public ChiTietHoaDonDto findById(String id) {
        return TranferData.convertToDto(this.repo.getChiTietHoaDonById(id));
    }

    public List<ChiTietHoaDonDto> getAllByIdHd(String id) {
        return TranferData.convertListCTHDToDto(repo.getAllChiTietHoaDonByIDHd(id));
    }

}
