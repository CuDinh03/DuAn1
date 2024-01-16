CREATE DATABASE PRO1041_Duan1;

USE PRO1041_Duan1;

CREATE TABLE chuc_vu(
    id UNIQUEIDENTIFIER DEFAULT (newid()) NOT NULL PRIMARY KEY,
    ma VARCHAR(10),
    ten_chuc_vu NVARCHAR(25),
    ngay_tao DATE,
    ngay_sua DATE,
    trang_thai BIT

);

CREATE TABLE tai_khoan (
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    ma Nvarchar(10),
    ten_dang_nhap Nvarchar(10),
    mat_khau Nvarchar(10),
    id_chuc_vu UNIQUEIDENTIFIER,
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT
);



CREATE TABLE san_pham (
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    ma Nvarchar(10),
    ten Nvarchar(50),
    mo_ta Nvarchar(100),
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT
);

CREATE TABLE san_pham_chi_tiet (
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    id_hang UNIQUEIDENTIFIER,
    id_ms UNIQUEIDENTIFIER,
    id_cl UNIQUEIDENTIFIER,
    id_size UNIQUEIDENTIFIER,
    id_anh UNIQUEIDENTIFIER,
    id_dm UNIQUEIDENTIFIER,
    id_sp UNIQUEIDENTIFIER,
    gia_ban Decimal,
    gia_nhap Decimal,
    so_luong Int,
    ngay_nhap Date,
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT

);
CREATE TABLE danh_muc_san_pham (
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    ma Nvarchar(10),
    ten Nvarchar(50),
    mo_ta Nvarchar(MAX),
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT
);
CREATE TABLE Hang (
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    ma Nvarchar(10),
    ten Nvarchar(50),
    mo_ta Nvarchar(MAX),
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT
);
CREATE TABLE mau_sac (
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    ma Nvarchar(10),
    ten Nvarchar(50),
    mo_ta Nvarchar(MAX),
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT
);

CREATE TABLE chat_lieu (
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    ma Nvarchar(10),
    ten Nvarchar(50),
    mo_ta Nvarchar(MAX),
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT
);

CREATE TABLE Size_ao (
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    ma Nvarchar(10),
    ten Nvarchar(50),
    mo_ta Nvarchar(MAX),
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT
);


CREATE TABLE hinh_anh (
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    ma Nvarchar(10),
    duong_dan Nvarchar(MAX),
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT
);

CREATE TABLE San_Pham_Danh_Muc (
    id_sp UNIQUEIDENTIFIER,
    id_dm UNIQUEIDENTIFIER,
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT,
    PRIMARY KEY (id_sp, id_dm)
);
CREATE TABLE San_Pham_Mau_Sac (
    id_sp UNIQUEIDENTIFIER,
    id_ms UNIQUEIDENTIFIER,
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT,
    PRIMARY KEY (id_sp, id_ms)
);

CREATE TABLE San_Pham_Kich_Thuoc (
    id_sp UNIQUEIDENTIFIER,
    id_kt UNIQUEIDENTIFIER,
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT,
    PRIMARY KEY (id_sp, id_kt)

);

CREATE TABLE Voucher (
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    ma Nvarchar(10),
    ten Nvarchar(50),
    giam_gia FLOAT,
    ngay_bat_dau Date,
    ngay_het_han Date,
    so_luong Int,
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT
);

CREATE TABLE Khach_Hang (
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    ma Nvarchar(10),
    ten Nvarchar(50),
    sdt Nvarchar(10),
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT
);

CREATE TABLE Hoa_Don (
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    id_kh UNIQUEIDENTIFIER,
    ma Nvarchar(10),
    id_nv UNIQUEIDENTIFIER,
    ngay_mua Date,
    tong_tien Decimal,
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT
);



CREATE TABLE Hoa_Don_Chi_Tiet (
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    id_hd UNIQUEIDENTIFIER,
    id_sp UNIQUEIDENTIFIER,
    so_luong Int,
    gia_ban Decimal,
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT
);

CREATE TABLE Hoa_Don_Voucher (
    id_hd UNIQUEIDENTIFIER,
    id_voucher UNIQUEIDENTIFIER,
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT,
    PRIMARY KEY (id_hd, id_voucher)

);


CREATE TABLE Gio_Hang (
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    ma Nvarchar(255),
    id_kh UNIQUEIDENTIFIER,
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT
);

CREATE TABLE Gio_Hang_Chi_Tiet (
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    id_gh UNIQUEIDENTIFIER,
    id_sp UNIQUEIDENTIFIER,
    so_luong Int,
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT
);

CREATE TABLE Gio_Hang_Hoa_Don (
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    id_gh UNIQUEIDENTIFIER,
    id_hd UNIQUEIDENTIFIER,
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT

);


CREATE TABLE Thanh_Toan (
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    ma Nvarchar(10),
    id_hd UNIQUEIDENTIFIER,
    phuong_thuc_thanh_toan Nvarchar(50),
    tien_thanh_toan Decimal,
    ngay_thanh_toan Date,
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT
);

DROP table Thanh_Toan

CREATE TABLE Nguoi_Dung (
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    ten Nvarchar(10),
    dia_chi TEXT,
    sdt Nvarchar(10),
    id_cv UNIQUEIDENTIFIER,
    ngay_bd Date,
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT
);

-- khoa quan he

ALTER TABLE tai_khoan ADD CONSTRAINT FK_TaiKhoan_ChucVu FOREIGN KEY (id_chuc_vu) REFERENCES chuc_vu(ID);
ALTER TABLE Nguoi_Dung ADD CONSTRAINT FK_Nguoi_Dung_ChucVu FOREIGN KEY (id_cv) REFERENCES chuc_vu(ID);
ALTER TABLE Thanh_Toan ADD CONSTRAINT FK_thanh_toan_hoa_don FOREIGN KEY (id_hd) REFERENCES Hoa_Don(ID);
ALTER TABLE Hoa_Don ADD CONSTRAINT FK_hoa_don_nguoi_dung FOREIGN KEY (id_nv) REFERENCES Nguoi_Dung(ID);
ALTER TABLE san_pham_chi_tiet ADD CONSTRAINT FK_SanPhamChiTiet_Hang FOREIGN KEY (id_hang) REFERENCES Hang(ID)
ALTER TABLE san_pham_chi_tiet ADD CONSTRAINT FK_SanPhamChiTiet_MauSac FOREIGN KEY (id_ms) REFERENCES mau_sac(ID)
ALTER TABLE san_pham_chi_tiet ADD CONSTRAINT FK_SanPhamChiTiet_ChatLieu FOREIGN KEY (id_cl) REFERENCES chat_lieu(ID)
ALTER TABLE san_pham_chi_tiet ADD CONSTRAINT FK_SanPhamChiTiet_Size FOREIGN KEY (id_size) REFERENCES Size_ao(ID)
ALTER TABLE san_pham_chi_tiet ADD CONSTRAINT FK_SanPhamChiTiet_Anh FOREIGN KEY (id_anh) REFERENCES hinh_anh(ID)
ALTER TABLE san_pham_chi_tiet ADD CONSTRAINT FK_SanPhamChiTiet_DanhMuc FOREIGN KEY (id_dm) REFERENCES danh_muc_san_pham(ID)
ALTER TABLE san_pham_chi_tiet ADD CONSTRAINT FK_SanPhamChiTiet_SanPham FOREIGN KEY (id_sp) REFERENCES san_pham(ID)

ALTER TABLE Gio_Hang_Chi_Tiet ADD CONSTRAINT FK_GioHangChiTiet_GioHang FOREIGN KEY (id_gh) REFERENCES Gio_Hang(ID)
ALTER TABLE Gio_Hang_Chi_Tiet ADD CONSTRAINT FK_GioHangChiTiet_SanPham FOREIGN KEY (id_sp) REFERENCES san_pham(ID)


ALTER TABLE Hoa_Don ADD FOREIGN KEY (id_kh) REFERENCES Khach_Hang(ID)
ALTER TABLE San_Pham_Kich_Thuoc ADD FOREIGN KEY (id_sp) REFERENCES san_pham(ID)
ALTER TABLE San_Pham_Kich_Thuoc ADD FOREIGN KEY (id_kt) REFERENCES Size_ao(ID)
ALTER TABLE San_Pham_Mau_Sac ADD FOREIGN KEY (id_sp) REFERENCES san_pham(ID)
ALTER TABLE San_Pham_Mau_Sac ADD FOREIGN KEY (id_ms) REFERENCES mau_sac(ID)
ALTER TABLE San_Pham_Danh_Muc ADD FOREIGN KEY (id_sp) REFERENCES san_pham(ID)
ALTER TABLE San_Pham_Danh_Muc ADD FOREIGN KEY (id_dm) REFERENCES danh_muc_san_pham(ID)
ALTER TABLE Hoa_Don_Chi_Tiet ADD FOREIGN KEY (id_hd) REFERENCES Hoa_Don(ID)
ALTER TABLE Hoa_Don_Chi_Tiet ADD FOREIGN KEY (id_sp) REFERENCES san_pham(ID)
ALTER TABLE Gio_Hang_Hoa_Don ADD FOREIGN KEY (id_gh) REFERENCES Gio_Hang(ID)
ALTER TABLE Gio_Hang_Hoa_Don ADD FOREIGN KEY (id_hd) REFERENCES Hoa_Don(ID)
ALTER TABLE Hoa_Don_Voucher ADD FOREIGN KEY (id_voucher) REFERENCES Voucher(ID)
ALTER TABLE Hoa_Don_Voucher ADD FOREIGN KEY (id_hd) REFERENCES Hoa_Don(ID)





