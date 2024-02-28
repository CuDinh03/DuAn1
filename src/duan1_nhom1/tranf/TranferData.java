/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1_nhom1.tranf;

import duan1_nhom1.dto.ChatLieuDto;
import duan1_nhom1.dto.ChiTietGioHangDto;
import duan1_nhom1.dto.ChiTietHoaDonDto;
import duan1_nhom1.dto.DanhMucDto;
import duan1_nhom1.dto.ChiTietSanPhamDto;
import duan1_nhom1.dto.GioHangDto;
import duan1_nhom1.dto.HangDto;
import duan1_nhom1.dto.HoaDonDto;
import duan1_nhom1.dto.KhachDto;
import duan1_nhom1.dto.SanPhamDto;
import duan1_nhom1.dto.VoucherDto;
import duan1_nhom1.model.ChatLieu;
import duan1_nhom1.model.ChiTietGioHang;
import duan1_nhom1.model.ChiTietHoaDon;
import duan1_nhom1.model.ChiTietSanPham;
import duan1_nhom1.model.DanhMuc;
import duan1_nhom1.model.GioHang;
import duan1_nhom1.model.Hang;
import duan1_nhom1.model.HoaDon;
import duan1_nhom1.model.Khach;
import duan1_nhom1.model.SanPham;
import duan1_nhom1.model.Voucher;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * 1
 *
 * @author maccuacu
 */
public class TranferData {

    public static HoaDonDto convertToDto(HoaDon model) {
        HoaDonDto dto = new HoaDonDto();
        if (model.getId() != null) {
            dto.setId(model.getId());
        }
        if (model.getIdKhachHang() != null) {
            dto.setIdKhachHang(model.getIdKhachHang());
        }
        if (model.getIdNv() != null) {
            dto.setIdNv(model.getIdNv());
        }
        if (model.getMa() != null) {
            dto.setMa(model.getMa());
        }
        if (model.getNgayMua() != null) {
            dto.setNgayMua(model.getNgayMua());
        }
        if (model.getTongTien() != null) {
            dto.setTongTien(model.getTongTien());
        }
        if (model.getTrangThai() != null) {
            dto.setTrangThai(model.getTrangThai());
        }
        if (model.getNgayTao() != null) {
            dto.setNgayTao(model.getNgayTao());
        }
        if (model.getNgaySua() != null) {
            dto.setNgaySua(model.getNgaySua());
        }
        return dto;
    }

    public static HoaDon convertToEntity(HoaDonDto dto) {
        HoaDon model = new HoaDon();
        if (dto.getId() != null) {
            model.setId(dto.getId());
        }
        if (dto.getIdKhachHang() != null) {
            model.setIdKhachHang(dto.getIdKhachHang());
        }
        if (dto.getIdNv() != null) {
            model.setIdNv(model.getIdNv());
        }
        if (dto.getMa() != null) {
            model.setMa(dto.getMa());
        }
        if (dto.getNgayMua() != null) {
            model.setNgayMua(dto.getNgayMua());
        }
        if (dto.getTongTien() != null) {
            model.setTongTien(dto.getTongTien());
        }
        if (dto.getTrangThai() != null) {
            model.setTrangThai(dto.getTrangThai());
        }
        if (dto.getNgayTao() != null) {
            model.setNgayTao(dto.getNgayTao());
        }
        if (dto.getNgaySua() != null) {
            model.setNgaySua(dto.getNgaySua());
        }
        return model;
    }

    public static List<HoaDonDto> convertListHoaDonToDto(List<HoaDon> entityList) {
        List<HoaDonDto> dtoList = new ArrayList<>();
        for (HoaDon entity : entityList) {
            dtoList.add(convertToDto(entity));
        }
        return dtoList;
    }

    public static KhachDto convertToDto(Khach khach) {
        KhachDto dto = new KhachDto();
        if (khach.getId() != null) {
            dto.setId(khach.getId());
        }
        if (khach.getMaKhachHang() != null) {
            dto.setMaKhachHang(khach.getMaKhachHang());
        }
        if (khach.getTenKhachHang() != null) {
            dto.setTenKhachHang(khach.getTenKhachHang());
        }
        if (khach.getSdt() != null) {
            dto.setSdt(khach.getSdt());
        }
        if (khach.getNgayTao() != null) {
            dto.setNgayTao((Date) khach.getNgayTao());
        }
        if (khach.getNgaySua() != null) {
            dto.setNgaySua((Date) khach.getNgaySua());
        }
        if (khach.getTrangThai() != null) {
            dto.setTrangThai(khach.getTrangThai());
        }
        return dto;
    }

    public static Khach convertToModel(KhachDto dto) {
        Khach model = new Khach();

        if (dto.getId() != null) {
            model.setId(dto.getId());
        }
        if (dto.getMaKhachHang() != null) {
            model.setMaKhachHang(dto.getMaKhachHang());
        }
        if (dto.getTenKhachHang() != null) {
            model.setTenKhachHang(dto.getTenKhachHang());
        }
        if (dto.getSdt() != null) {
            model.setSdt(dto.getSdt());
        }
        if (dto.getNgayTao() != null) {
            model.setNgayTao(dto.getNgayTao());
        }
        if (dto.getNgaySua() != null) {
            model.setNgaySua(dto.getNgaySua());
        }
        if (dto.getTrangThai() != null) {
            model.setTrangThai(dto.getTrangThai());
        }

        return model;
    }

    public static List<KhachDto> convertListKhachToDto(List<Khach> entityList) {
        List<KhachDto> dtoList = new ArrayList<>();
        for (Khach entity : entityList) {
            dtoList.add(convertToDto(entity));
        }
        return dtoList;
    }

    public static DanhMucDto convertToDto(DanhMuc model) {
        DanhMucDto dto = new DanhMucDto();
        if (model.getId() != null) {
            dto.setId(model.getId());
        }
        if (model.getMa() != null) {
            dto.setMa(model.getMa());
        }
        if (model.getTen() != null) {
            dto.setTen(model.getTen());
        }
        if (model.getMoTa() != null) {
            dto.setMoTa(model.getMoTa());
        }
        if (model.getNgayTao() != null) {
            dto.setNgayTao(model.getNgayTao());
        }
        if (model.getNgaySua() != null) {
            dto.setNgaySua(model.getNgaySua());
        }
        if (model.getTrangThai() != null) {
            dto.setTrangThai(model.getTrangThai());
        }
        return dto;
    }

    public static DanhMuc convertToEntity(DanhMucDto dto) {
        DanhMuc model = new DanhMuc();
        if (dto.getId() != null) {
            model.setId(dto.getId());
        }
        if (dto.getMa() != null) {
            model.setMa(dto.getMa());
        }
        if (dto.getTen() != null) {
            model.setTen(dto.getTen());
        }
        if (dto.getMoTa() != null) {
            model.setMoTa(dto.getMoTa());
        }
        if (dto.getNgayTao() != null) {
            model.setNgayTao(dto.getNgayTao());
        }
        if (dto.getNgaySua() != null) {
            model.setNgaySua(dto.getNgaySua());
        }
        if (dto.getTrangThai() != null) {
            model.setTrangThai(dto.getTrangThai());
        }
        return model;
    }

    public static List<DanhMucDto> convertListDanhMucToDto(List<DanhMuc> entityList) {
        List<DanhMucDto> dtoList = new ArrayList<>();
        for (DanhMuc entity : entityList) {
            dtoList.add(convertToDto(entity));
        }
        return dtoList;
    }

    public static VoucherDto convertToDto(Voucher model) {
        VoucherDto dto = new VoucherDto();
        if (model.getId() != null) {
            dto.setId(model.getId());
        }
        if (model.getMa() != null) {
            dto.setMa(model.getMa());
        }
        if (model.getTen() != null) {
            dto.setTen(model.getTen());
        }
        if (model.getGiamGia() != null) {
            dto.setGiamGia(model.getGiamGia());
        }
        if (model.getNgayDau() != null) {
            dto.setNgayDau(model.getNgayDau());
        }
        if (model.getNgayCuoi() != null) {
            dto.setNgayCuoi(model.getNgayCuoi());
        }
        if (model.getSoLuong() != null) {
            dto.setSoLuong(model.getSoLuong());
        }
        if (model.getNgayTao() != null) {
            dto.setNgayTao(model.getNgayTao());
        }
        if (model.getNgaySua() != null) {
            dto.setNgaySua(model.getNgaySua());
        }
        if (model.getTrangThai() != null) {
            dto.setTrangThai(model.getTrangThai());
        }
        return dto;
    }

    public static Voucher convertToEntity(VoucherDto dto) {
        Voucher model = new Voucher();
        if (dto.getId() != null) {
            model.setId(dto.getId());
        }
        if (dto.getMa() != null) {
            model.setMa(dto.getMa());
        }
        if (dto.getTen() != null) {
            model.setTen(dto.getTen());
        }
        if (dto.getGiamGia() != null) {
            model.setGiamGia(dto.getGiamGia());
        }
        if (dto.getNgayDau() != null) {
            model.setNgayDau(dto.getNgayDau());
        }
        if (dto.getNgayCuoi() != null) {
            model.setNgayCuoi(dto.getNgayCuoi());
        }
        if (dto.getSoLuong() != null) {
            model.setSoLuong(dto.getSoLuong());
        }
        if (dto.getNgayTao() != null) {
            model.setNgayTao(dto.getNgayTao());
        }
        if (dto.getNgaySua() != null) {
            model.setNgaySua(dto.getNgaySua());
        }
        if (dto.getTrangThai() != null) {
            model.setTrangThai(dto.getTrangThai());
        }
        return model;
    }

    public static List<VoucherDto> convertListVoucherToDto(List<Voucher> entityList) {
        List<VoucherDto> dtoList = new ArrayList<>();
        for (Voucher entity : entityList) {
            dtoList.add(convertToDto(entity));
        }
        return dtoList;
    }

    public static ChiTietSanPhamDto convertToDto(ChiTietSanPham model) {
        ChiTietSanPhamDto dto = new ChiTietSanPhamDto();
        if (model.getId() != null) {
            dto.setId(model.getId());
        }
        if (model.getMa() != null) {
            dto.setMa(model.getMa());
        }
        if (model.getIdSanPham() != null) {
            dto.setIdSanPham(model.getIdSanPham());
        }
        if (model.getIdKichThuoc() != null) {
            dto.setIdKichThuoc(model.getIdKichThuoc());
        }
        if (model.getIdThuongHieu() != null) {
            dto.setIdThuongHieu(model.getIdThuongHieu());
        }
        if (model.getIdMauSac() != null) {
            dto.setIdMauSac(model.getIdMauSac());
        }
        if (model.getIdChatLieu() != null) {
            dto.setIdChatLieu(model.getIdChatLieu());
        }
        if (model.getIdDanhMuc() != null) {
            dto.setIdDanhMuc(model.getIdDanhMuc());
        }
        if (model.getGiaNhap() != null) {
            dto.setGiaNhap(model.getGiaNhap());
        }
        if (model.getGiaBan() != null) {
            dto.setGiaBan(model.getGiaBan());
        }
        if (model.getSoLuong() != null) {
            dto.setSoLuong(model.getSoLuong());
        }
        if (model.getNgayTao() != null) {
            dto.setNgayTao(model.getNgayTao());
        }
        if (model.getNgaySua() != null) {
            dto.setNgaySua(model.getNgaySua());
        }
        if (model.getNgayNhap() != null) {
            dto.setNgayNhap(model.getNgayNhap());
        }
        dto.setTrangThai(model.isTrangThai());
        return dto;
    }

    public static ChiTietSanPham convertToEntity(ChiTietSanPhamDto dto) {
        ChiTietSanPham model = new ChiTietSanPham();
        if (dto.getId() != null) {
            model.setId(dto.getId());
        }
        model.setId(dto.getId());
        if (dto.getMa() != null) {
            model.setMa(dto.getMa());
        }
        if (dto.getIdSanPham() != null) {
            model.setIdSanPham(dto.getIdSanPham());
        }
        if (dto.getIdKichThuoc() != null) {
            model.setIdKichThuoc(dto.getIdKichThuoc());
        }
        if (dto.getIdThuongHieu() != null) {
            model.setIdThuongHieu(dto.getIdThuongHieu());
        }
        if (dto.getIdMauSac() != null) {
            model.setIdMauSac(dto.getIdMauSac());
        }
        if (dto.getIdChatLieu() != null) {
            model.setIdChatLieu(dto.getIdChatLieu());
        }
        if (dto.getIdDanhMuc() != null) {
            model.setIdDanhMuc(dto.getIdDanhMuc());
        }
        if (dto.getGiaNhap() != null) {
            model.setGiaNhap(dto.getGiaNhap());
        }
        if (dto.getGiaBan() != null) {
            model.setGiaBan(dto.getGiaBan());
        }
        if (dto.getSoLuong() != null) {
            model.setSoLuong(dto.getSoLuong());
        }
        if (dto.getNgayTao() != null) {
            model.setNgayTao(dto.getNgayTao());
        }
        if (dto.getNgaySua() != null) {
            model.setNgaySua(dto.getNgaySua());
        }
        if (dto.getNgayNhap() != null) {
            model.setNgayNhap(dto.getNgayNhap());
        }
        model.setTrangThai(dto.getTrangThai());
        return model;
    }

    public static List<ChiTietSanPhamDto> convertListToDtos(List<ChiTietSanPham> entityList) {
        List<ChiTietSanPhamDto> dtoList = new ArrayList<>();
        for (ChiTietSanPham entity : entityList) {
            dtoList.add(convertToDto(entity));
        }
        return dtoList;
        
    }

    public static ChiTietHoaDonDto convertToDto(ChiTietHoaDon model) {
        ChiTietHoaDonDto dto = new ChiTietHoaDonDto();
        if (model.getId() != null) {
            dto.setId(model.getId());
        }
        if (model.getIdHoaDon() != null) {
            dto.setIdHD(model.getIdHoaDon());
        }
        if (model.getIdSanPham() != null) {
            dto.setIdSP(model.getIdSanPham());
        }
        if (model.getSoLuong() != null) {
            dto.setSoLuong(model.getSoLuong());
        }
        if (model.getGiaBan() != null) {
            dto.setGiaBan(model.getGiaBan());
        }
        if (model.getNgayTao() != null) {
            dto.setNgayTao(model.getNgayTao());
        }
        if (model.getNgaySua() != null) {
            dto.setNgaySua(model.getNgaySua());
        }
        if (model.getTrangThai() != null) {
            dto.setTrangThai(model.getTrangThai());
        }
        return dto;
    }

    public static ChiTietHoaDon convertToEntity(ChiTietHoaDonDto dto) {
        ChiTietHoaDon entity = new ChiTietHoaDon();
        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }
        if (dto.getIdHD() != null) {
            entity.setIdHoaDon(dto.getIdHD());
        }
        if (dto.getIdSP() != null) {
            entity.setIdSanPham(dto.getIdSP());
        }
        if (dto.getSoLuong() != null) {
            entity.setSoLuong(dto.getSoLuong());
        }
        if (dto.getGiaBan() != null) {
            entity.setGiaBan(dto.getGiaBan());
        }
        if (dto.getNgayTao() != null) {
            entity.setNgayTao(dto.getNgayTao());
        }
        if (dto.getNgaySua() != null) {
            entity.setNgaySua(dto.getNgaySua());
        }
        if (dto.getTrangThai() != null) {
            entity.setTrangThai(dto.getTrangThai());
        }
        return entity;
    }

    public static List<ChiTietHoaDonDto> convertListCTHDToDto(List<ChiTietHoaDon> entityList) {
        List<ChiTietHoaDonDto> dtoList = new ArrayList<>();
        for (ChiTietHoaDon entity : entityList) {
            dtoList.add(convertToDto(entity));
        }
        return dtoList;

    }

    public static SanPhamDto convertToDto(SanPham model) {
        SanPhamDto dto = new SanPhamDto();
        if (model.getId() != null) {
            dto.setId(model.getId());
        }
        if (model.getMa() != null) {
            dto.setMa(model.getMa());
        }
        if (model.getTen() != null) {
            dto.setTen(model.getTen());
        }
        if (model.getMoTa() != null) {
            dto.setMoTa(model.getMoTa());
        }
        if (model.getNgayTao() != null) {
            dto.setNgayTao(model.getNgayTao());
        }
        if (model.getNgaySua() != null) {
            dto.setNgaySua(model.getNgaySua());
        }
        if (model.getTrangThai() != null) {
            dto.setTrangThai(model.getTrangThai());
        }
        return dto;
    }

    public static SanPham convertToEntity(SanPhamDto dto) {
        SanPham model = new SanPham();
        if (dto.getId() != null) {
            model.setId(dto.getId());
        }
        if (dto.getMa() != null) {
            model.setMa(dto.getMa());
        }
        if (dto.getTen() != null) {
            model.setTen(dto.getTen());
        }
        if (dto.getMoTa() != null) {
            model.setMoTa(dto.getMoTa());
        }
        if (dto.getNgayTao() != null) {
            model.setNgayTao(dto.getNgayTao());
        }
        if (dto.getNgaySua() != null) {
            model.setNgaySua(dto.getNgaySua());
        }
        if (dto.getTrangThai() != null) {
            model.setTrangThai(dto.getTrangThai());
        }
        return model;
    }

    public static List<SanPhamDto> convertListSanPhamToDto(List<SanPham> entityList) {
        List<SanPhamDto> dtoList = new ArrayList<>();
        for (SanPham entity : entityList) {
            dtoList.add(convertToDto(entity));
        }
        return dtoList;
    }

    public static ChatLieuDto convertToDto(ChatLieu model) {
        ChatLieuDto dto = new ChatLieuDto();
        if (model.getId() != null) {
            dto.setId(model.getId());
        }
        if (model.getMa() != null) {
            dto.setMa(model.getMa());
        }
        if (model.getTen() != null) {
            dto.setTen(model.getTen());
        }
        if (model.getMoTa() != null) {
            dto.setMoTa(model.getMoTa());
        }
        if (model.getTrangThai() != null) {
            dto.setTrangThai(model.getTrangThai());
        }
        return dto;
    }

    public static ChatLieu convertToEntity(ChatLieuDto dto) {
        ChatLieu model = new ChatLieu();
        if (dto.getId() != null) {
            model.setId(dto.getId());
        }
        if (dto.getMa() != null) {
            model.setMa(dto.getMa());
        }
        if (dto.getTen() != null) {
            model.setTen(dto.getTen());
        }
        if (dto.getMoTa() != null) {
            model.setMoTa(dto.getMoTa());
        }
        if (dto.getTrangThai() != null) {
            model.setTrangThai(dto.getTrangThai());
        }
        return model;
    }

    public static List<ChatLieuDto> convertListChatLieuToDto(List<ChatLieu> entityList) {
        List<ChatLieuDto> dtoList = new ArrayList<>();
        for (ChatLieu entity : entityList) {
            dtoList.add(convertToDto(entity));
        }
        return dtoList;
    }

    public static HangDto convertToDto(Hang model) {
        HangDto dto = new HangDto();
        if (model.getId() != null) {
            dto.setId(model.getId());
        }
        if (model.getMa() != null) {
            dto.setMa(model.getMa());
        }
        if (model.getTen() != null) {
            dto.setTen(model.getTen());
        }
        if (model.getMoTa() != null) {
            dto.setMoTa(model.getMoTa());
        }
        if (model.getTrangThai() != null) {
            dto.setTrangThai(model.getTrangThai());
        }
        return dto;
    }

    public static Hang convertToEntity(HangDto dto) {
        Hang model = new Hang();
        if (dto.getId() != null) {
            model.setId(dto.getId());
        }
        if (dto.getMa() != null) {
            model.setMa(dto.getMa());
        }
        if (dto.getTen() != null) {
            model.setTen(dto.getTen());
        }
        if (dto.getMoTa() != null) {
            model.setMoTa(dto.getMoTa());
        }
        if (dto.getTrangThai() != null) {
            model.setTrangThai(dto.getTrangThai());
        }
        return model;
    }

    public static List<HangDto> convertListHangToDto(List<Hang> entityList) {
        List<HangDto> dtoList = new ArrayList<>();
        for (Hang entity : entityList) {
            dtoList.add(convertToDto(entity));
        }
        return dtoList;
    }

    public static GioHangDto convertToDto(GioHang model) {
        GioHangDto dto = new GioHangDto();

        if (model.getId() != null) {
            dto.setId(model.getId());
        }
        if (model.getMa() != null) {
            dto.setMa(model.getMa());
        }
        if (model.getIdKH() != null) {
            dto.setIdKH(model.getIdKH());
        }
        if (model.getNgayTao() != null) {
            dto.setNgayTao(model.getNgayTao());
        }
        if (model.getNgaySua() != null) {
            dto.setNgaySua(model.getNgaySua());
        }
        if (model.getTrangThai() != null) {
            dto.setTrangThai(model.getTrangThai());

        }
        return dto;
    }

    public static GioHang convertToEntity(GioHangDto dto) {
        GioHang model = new GioHang();
        if (dto.getId() != null) {
            model.setId(dto.getId());
        }
        if (dto.getMa() != null) {
            model.setMa(dto.getMa());
        }
        if (dto.getIdKH() != null) {
            model.setIdKH(dto.getIdKH());
        }
        if (dto.getNgayTao() != null) {
            model.setNgayTao(dto.getNgayTao());
        }
        if (dto.getNgaySua() != null) {
            model.setNgaySua(dto.getNgaySua());
        }
        if (dto.getTrangThai() != null) {
            model.setTrangThai(dto.getTrangThai());
        }

        return model;
    }

    public static List<GioHangDto> convertListGioHangToDto(List<GioHang> entityList) {
        List<GioHangDto> dtoList = new ArrayList<>();
        for (GioHang entity : entityList) {
            dtoList.add(convertToDto(entity));
        }
        return dtoList;
    }

    public static ChiTietGioHangDto convertToDto(ChiTietGioHang chiTietGioHang) {
        ChiTietGioHangDto dto = new ChiTietGioHangDto();

        if (chiTietGioHang.getId() != null) {
            dto.setId(chiTietGioHang.getId());
        }

        if (chiTietGioHang.getIdGH() != null) {
            dto.setIdGH(chiTietGioHang.getIdGH());
        }

        if (chiTietGioHang.getIdSP() != null) {
            dto.setIdSP(chiTietGioHang.getIdSP());
        }

        if (chiTietGioHang.getSoLuong() != null) {
            dto.setSoLuong(chiTietGioHang.getSoLuong());
        }

        if (chiTietGioHang.getNgayTao() != null) {
            dto.setNgayTao(chiTietGioHang.getNgayTao());
        }

        if (chiTietGioHang.getNgaySua() != null) {
            dto.setNgaySua(chiTietGioHang.getNgaySua());
        }

        if (chiTietGioHang.getTrangThai() != null) {
            dto.setTrangThai(chiTietGioHang.getTrangThai());
        }

        return dto;
    }

    public static ChiTietGioHang convertToEntity(ChiTietGioHangDto dto) {
        ChiTietGioHang entity = new ChiTietGioHang();

        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }

        if (dto.getIdGH() != null) {
            entity.setIdGH(dto.getIdGH());
        }

        if (dto.getIdSP() != null) {
            entity.setIdSP(dto.getIdSP());
        }

        if (dto.getSoLuong() != null) {
            entity.setSoLuong(dto.getSoLuong());
        }

        if (dto.getNgayTao() != null) {
            entity.setNgayTao(dto.getNgayTao());
        }

        if (dto.getNgaySua() != null) {
            entity.setNgaySua(dto.getNgaySua());
        }

        if (dto.getTrangThai() != null) {
            entity.setTrangThai(dto.getTrangThai());
        }

        return entity;
    }
    
     public static List<ChiTietGioHangDto> convertListToDto(List<ChiTietGioHang> entityList) {
        List<ChiTietGioHangDto> dtoList = new ArrayList<>();
        for (ChiTietGioHang entity : entityList) {
            dtoList.add(convertToDto(entity));
        }
        return dtoList;
    }

}
