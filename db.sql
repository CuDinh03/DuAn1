CREATE DATABASE PRO1041_Duan1;

USE PRO1041_Duan1;


CREATE TABLE chuc_vu
(
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




CREATE TABLE san_pham

    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    ma Nvarchar(10),
    ten Nvarchar(50),
    mo_ta Nvarchar(100),
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT
);

CREATE TABLE san_pham_chi_tiet
(
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    ma NVARCHAR(50),
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
CREATE TABLE danh_muc_san_pham
(
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    ma Nvarchar(10),
    ten Nvarchar(50),
    mo_ta Nvarchar(MAX),
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT
);

CREATE TABLE Hang
(
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    ma Nvarchar(10),
    ten Nvarchar(50),
    mo_ta Nvarchar(MAX),
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT
);

CREATE TABLE mau_sac
(
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    ma Nvarchar(10),
    ten Nvarchar(50),
    mo_ta Nvarchar(MAX),
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT
);


CREATE TABLE chat_lieu
(
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    ma Nvarchar(10),
    ten Nvarchar(50),
    mo_ta Nvarchar(MAX),
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT
);


CREATE TABLE Size_ao
(
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    ma Nvarchar(10),
    ten Nvarchar(50),
    mo_ta Nvarchar(MAX),
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT
);


CREATE TABLE hinh_anh
(
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    ma Nvarchar(10),
    duong_dan Nvarchar(MAX),
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT
);

CREATE TABLE San_Pham_Danh_Muc
(

    id_sp UNIQUEIDENTIFIER,
    id_dm UNIQUEIDENTIFIER,
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT,
    PRIMARY KEY (id_sp, id_dm)
);

CREATE TABLE San_Pham_Mau_Sac
(
    id_sp UNIQUEIDENTIFIER,
    id_ms UNIQUEIDENTIFIER,
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT,
    PRIMARY KEY (id_sp, id_ms)
);


CREATE TABLE San_Pham_Kich_Thuoc
(
    id_sp UNIQUEIDENTIFIER,
    id_kt UNIQUEIDENTIFIER,
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT,
    PRIMARY KEY (id_sp, id_kt)

);

CREATE TABLE Voucher
(
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


CREATE TABLE Khach_Hang
(
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    ma Nvarchar(10),
    ten Nvarchar(50),
    sdt Nvarchar(10),
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT
);


CREATE TABLE Hoa_Don
(
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




CREATE TABLE Hoa_Don_Chi_Tiet
(
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    id_hd UNIQUEIDENTIFIER,
    id_sp UNIQUEIDENTIFIER,
    so_luong Int,
    gia_ban Decimal,
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT
);


CREATE TABLE Hoa_Don_Voucher
(
    id_hd UNIQUEIDENTIFIER,
    id_voucher UNIQUEIDENTIFIER,
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT,
    PRIMARY KEY (id_hd, id_voucher)

);


CREATE TABLE Gio_Hang
(
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    ma Nvarchar(255),
    id_kh UNIQUEIDENTIFIER,
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT
);


CREATE TABLE Gio_Hang_Chi_Tiet
(
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    id_gh UNIQUEIDENTIFIER,
    id_sp UNIQUEIDENTIFIER,
    so_luong Int,
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT
);

CREATE TABLE Gio_Hang_Hoa_Don
(
    id UNIQUEIDENTIFIER DEFAULT NEWID() NOT NULL PRIMARY KEY,
    id_gh UNIQUEIDENTIFIER,
    id_hd UNIQUEIDENTIFIER,
    ngay_tao Date,
    ngay_sua Date,
    trang_thai BIT

);


CREATE TABLE Thanh_Toan
(
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


CREATE TABLE Nguoi_Dung
(
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
ALTER TABLE san_pham_chi_tiet ADD CONSTRAINT FK_SanPhamChiTiet_MauSac FOREIGN KEY (id_ms) REFERENCES San_Pham_Mau_Sac(id_ms)
ALTER TABLE san_pham_chi_tiet ADD CONSTRAINT FK_SanPhamChiTiet_DanhMuc FOREIGN KEY (id_dm) REFERENCES San_Pham_Danh_Muc(id_dm)
ALTER TABLE san_pham_chi_tiet ADD CONSTRAINT FK_SanPhamChiTiet_Size FOREIGN KEY (id_size) REFERENCES San_Pham_Kich_Thuoc(id_kt)


ALTER TABLE san_pham_chi_tiet ADD CONSTRAINT FK_SanPhamChiTiet_ChatLieu FOREIGN KEY (id_cl) REFERENCES chat_lieu(ID)
ALTER TABLE san_pham_chi_tiet ADD CONSTRAINT FK_SanPhamChiTiet_Anh FOREIGN KEY (id_anh) REFERENCES hinh_anh(ID)
ALTER TABLE san_pham_chi_tiet ADD CONSTRAINT FK_SanPhamChiTiet_SanPham FOREIGN KEY (id_sp) REFERENCES san_pham(ID)
ALTER TABLE Gio_Hang_Chi_Tiet ADD CONSTRAINT FK_GioHangChiTiet_GioHang FOREIGN KEY (id_gh) REFERENCES Gio_Hang(ID)
ALTER TABLE Gio_Hang_Chi_Tiet ADD CONSTRAINT FK_GioHangChiTiet_SanPham FOREIGN KEY (id_sp) REFERENCES san_pham(ID)

ALTER TABLE Hoa_Don ADD FOREIGN KEY (id_kh) REFERENCES Khach_Hang(ID)

ALTER TABLE San_Pham_Kich_Thuoc ADD FOREIGN KEY (id_sp) REFERENCES san_pham_chi_tiet(ID)
ALTER TABLE San_Pham_Kich_Thuoc ADD FOREIGN KEY (id_kt) REFERENCES Size_ao(ID)
ALTER TABLE San_Pham_Mau_Sac ADD FOREIGN KEY (id_sp) REFERENCES san_pham_chi_tiet(ID)
ALTER TABLE San_Pham_Mau_Sac ADD FOREIGN KEY (id_ms) REFERENCES mau_sac(ID)
ALTER TABLE San_Pham_Danh_Muc ADD FOREIGN KEY (id_sp) REFERENCES san_pham_chi_tiet(ID)
ALTER TABLE San_Pham_Danh_Muc ADD FOREIGN KEY (id_dm) REFERENCES danh_muc_san_pham(ID)


ALTER TABLE Hoa_Don_Chi_Tiet ADD FOREIGN KEY (id_hd) REFERENCES Hoa_Don(ID)
ALTER TABLE Hoa_Don_Chi_Tiet ADD FOREIGN KEY (id_sp) REFERENCES san_pham(ID)
ALTER TABLE Gio_Hang_Hoa_Don ADD FOREIGN KEY (id_gh) REFERENCES Gio_Hang(ID)
ALTER TABLE Gio_Hang_Hoa_Don ADD FOREIGN KEY (id_hd) REFERENCES Hoa_Don(ID)
ALTER TABLE Hoa_Don_Voucher ADD FOREIGN KEY (id_voucher) REFERENCES Voucher(ID)
ALTER TABLE Hoa_Don_Voucher ADD FOREIGN KEY (id_hd) REFERENCES Hoa_Don(ID)

--- them data---


-- data chuc_vu 
INSERT INTO chuc_vu
    (id, ma, ten_chuc_vu, ngay_tao, ngay_sua, trang_thai)
VALUES
    (NEWID(), 'CV001', 'Quản lý', '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'CV002', 'Nhân viên bán hàng', '2024-01-20', '2024-01-20', 1);

-- data tai_khoan 
INSERT INTO tai_khoan
    (id, ma, ten_dang_nhap, mat_khau, id_chuc_vu, ngay_tao, ngay_sua, trang_thai)
VALUES
    (NEWID(), 'TK001', 'admin', 'admin123', (SELECT id
        FROM chuc_vu
        WHERE ma = 'CV001'), '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'TK002', 'nv1', 'nv1234', (SELECT id
        FROM chuc_vu
        WHERE ma = 'CV002'), '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'TK003', 'nv2', 'nv1234', (SELECT id
        FROM chuc_vu
        WHERE ma = 'CV002'), '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'TK004', 'nv3', 'nv1234', (SELECT id
        FROM chuc_vu
        WHERE ma = 'CV002'), '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'TK005', 'nv4', 'nv1234', (SELECT id
        FROM chuc_vu
        WHERE ma = 'CV002'), '2024-01-20', '2024-01-20', 1);

-- data  san_pham 
INSERT INTO san_pham
    (id, ma, ten, mo_ta, ngay_tao, ngay_sua, trang_thai)
VALUES
    (NEWID(), 'SP001', 'Áo Polo Nam', 'Áo Polo màu đen, kiểu dáng thời trang', '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'SP002', 'Áo Sơ Mi Nam', 'Áo sơ mi trắng cổ tròn', '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'SP003', 'Áo Thun Nam', 'Áo thun đỏ in hình ngộ nghĩnh', '2024-01-20', '2024-01-20', 1);


-- data danh_muc_san_pham  
INSERT INTO danh_muc_san_pham
    (id, ma, ten, mo_ta, ngay_tao, ngay_sua, trang_thai)
VALUES
    (NEWID(), 'DM001', 'Áo Polo', 'Danh mục chứa các sản phẩm áo Polo nam', '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'DM002', 'Áo Sơ Mi', 'Danh mục chứa các sản phẩm áo Sơ Mi nam', '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'DM003', 'Áo Thun', 'Danh mục chứa các sản phẩm áo Thun nam', '2024-01-20', '2024-01-20', 1);

-- data Hang 
INSERT INTO Hang
    (id, ma, ten, mo_ta, ngay_tao, ngay_sua, trang_thai)
VALUES
    (NEWID(), 'H001', 'Nike', 'Thương hiệu thể thao nổi tiếng', '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'H002', 'Adidas', 'Thương hiệu thể thao và thời trang', '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'H003', 'H&M', 'Thương hiệu quần áo denim', '2024-01-20', '2024-01-20', 1);

-- data mau_sac 

INSERT INTO mau_sac
    (id, ma, ten, mo_ta, ngay_tao, ngay_sua, trang_thai)
VALUES
    (NEWID(), 'MS001', 'Đen', 'Màu đen', '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'MS002', 'Trắng', 'Màu trắng', '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'MS003', 'Đỏ', 'Màu đỏ', '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'MS004', 'Cam', 'Màu cam', '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'MS005', 'Vàng', 'Màu vàng', '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'MS006', 'Xanh lá', 'Màu xanh lá', '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'MS007', 'Xanh nước biển', 'Màu xanh nước biển', '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'MS008', 'Hồng', 'Màu hồng', '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'MS009', 'Tím', 'Màu tím', '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'MS010', 'Than chì', 'Màu than chì', '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'MS011', 'Nâu', 'Màu nâu', '2024-01-20', '2024-01-20', 1);


-- data chat_lieu 
INSERT INTO chat_lieu
    (id, ma, ten, mo_ta, ngay_tao, ngay_sua, trang_thai)
VALUES
    (NEWID(), 'CL001', 'Cotton', 'Chất liệu cotton', '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'CL002', 'Denim', 'Chất liệu denim', '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'CL003', 'Polyester', 'Chất liệu polyester', '2024-01-20', '2024-01-20', 1);

-- data Size_ao 
INSERT INTO Size_ao
    (id, ma, ten, mo_ta, ngay_tao, ngay_sua, trang_thai)
VALUES
    (NEWID(), 'SA001', 'M', 'Size M', '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'SA002', 'L', 'Size L', '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'SA003', 'XL', 'Size XL', '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'SA003', 'S', 'Size S', '2024-01-20', '2024-01-20', 1);
-- data hinh_anh 
INSERT INTO hinh_anh
    (id, ma, duong_dan, ngay_tao, ngay_sua, trang_thai)
VALUES
    (NEWID(), 'HA001', '/images/product1.jpg', '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'HA002', '/images/product2.jpg', '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'HA003', '/images/product3.jpg', '2024-01-20', '2024-01-20', 1);


-- data san_pham_chi_tiet 
INSERT INTO san_pham_chi_tiet
    (
    id, id_hang, id_ms, id_cl, id_size, id_anh, id_dm, id_sp, gia_ban, gia_nhap, so_luong, ngay_nhap, ngay_tao, ngay_sua, trang_thai
    )
VALUES
    (NEWID(), (SELECT TOP 1
            id
        FROM Hang
        WHERE ma = 'H001'), (SELECT TOP 1
            id
        FROM mau_sac
        WHERE ma = 'MS001'),
        (SELECT TOP 1
            id
        FROM chat_lieu
        WHERE ma = 'CL001'), (SELECT TOP 1
            id
        FROM Size_ao
        WHERE ma = 'SA001'),
        (SELECT TOP 1
            id
        FROM hinh_anh
        WHERE ma = 'HA001'), (SELECT TOP 1
            id
        FROM danh_muc_san_pham
        WHERE ma = 'DM001'),
        (SELECT TOP 1
            id
        FROM san_pham
        WHERE ma = 'SP001'), 150.00, 100.00, 50, '2024-01-20', '2024-01-20', '2024-01-20', 1),

    (NEWID(), (SELECT TOP 1
            id
        FROM Hang
        WHERE ma = 'H002'), (SELECT TOP 1
            id
        FROM mau_sac
        WHERE ma = 'MS002'),
        (SELECT TOP 1
            id
        FROM chat_lieu
        WHERE ma = 'CL002'), (SELECT TOP 1
            id
        FROM Size_ao
        WHERE ma = 'SA002'),
        (SELECT TOP 1
            id
        FROM hinh_anh
        WHERE ma = 'HA002'), (SELECT TOP 1
            id
        FROM danh_muc_san_pham
        WHERE ma = 'DM002'),
        (SELECT TOP 1
            id
        FROM san_pham
        WHERE ma = 'SP002'), 200.00, 150.00, 30, '2024-01-20', '2024-01-20', '2024-01-20', 1),

    (NEWID(), (SELECT TOP 1
            id
        FROM Hang
        WHERE ma = 'H003'), (SELECT TOP 1
            id
        FROM mau_sac
        WHERE ma = 'MS003'),
        (SELECT TOP 1
            id
        FROM chat_lieu
        WHERE ma = 'CL003'), (SELECT TOP 1
            id
        FROM Size_ao
        WHERE ma = 'SA003'),
        (SELECT TOP 1
            id
        FROM hinh_anh
        WHERE ma = 'HA003'), (SELECT TOP 1
            id
        FROM danh_muc_san_pham
        WHERE ma = 'DM003'),
        (SELECT TOP 1
            id
        FROM san_pham
        WHERE ma = 'SP003'), 120.00, 80.00, 40, '2024-01-20', '2024-01-20', '2024-01-20', 1);

-- data San_Pham_Danh_Muc
INSERT INTO San_Pham_Danh_Muc
    (id_sp, id_dm, ngay_tao, ngay_sua, trang_thai)
VALUES
    ((SELECT TOP 1
            id
        FROM san_pham_chi_tiet
        WHERE ma = 'SPCT001'), (SELECT TOP 1
            id
        FROM danh_muc_san_pham
        WHERE ma = 'DM001'), '2024-01-20', '2024-01-20', 1),
    ((SELECT TOP 1
            id
        FROM san_pham_chi_tiet
        WHERE ma = 'SPCT002'), (SELECT TOP 1
            id
        FROM danh_muc_san_pham
        WHERE ma = 'DM002'), '2024-01-21', '2024-01-21', 1),
    ((SELECT TOP 1
            id
        FROM san_pham_chi_tiet
        WHERE ma = 'SPCT003'), (SELECT TOP 1
            id
        FROM danh_muc_san_pham
        WHERE ma = 'DM003'), '2024-01-22', '2024-01-22', 1);

-- data San_Pham_Mau_Sac
INSERT INTO San_Pham_Mau_Sac
    (id_sp, id_ms, ngay_tao, ngay_sua, trang_thai)
VALUES
    ((SELECT TOP 1
            id
        FROM san_pham_chi_tiet
        WHERE ma = 'SPCT001'), (SELECT TOP 1
            id
        FROM mau_sac
        WHERE ma = 'MS001'), '2024-01-20', '2024-01-20', 1),
    ((SELECT TOP 1
            id
        FROM san_pham_chi_tiet
        WHERE ma = 'SPCT002'), (SELECT TOP 1
            id
        FROM mau_sac
        WHERE ma = 'MS002'), '2024-01-21', '2024-01-21', 1),
    ((SELECT TOP 1
            id
        FROM san_pham_chi_tiet
        WHERE ma = 'SPCT003'), (SELECT TOP 1
            id
        FROM mau_sac
        WHERE ma = 'MS003'), '2024-01-22', '2024-01-22', 1);

-- data  San_Pham_Kich_Thuoc
INSERT INTO San_Pham_Kich_Thuoc
    (id_sp, id_kt, ngay_tao, ngay_sua, trang_thai)
VALUES
    ((SELECT TOP 1
            id
        FROM san_pham_chi_tiet
        WHERE ma = 'SPCT001'), (SELECT TOP 1
            id
        FROM Size_ao
        WHERE ma = 'Size001'), '2024-01-20', '2024-01-20', 1),
    ((SELECT TOP 1
            id
        FROM san_pham_chi_tiet
        WHERE ma = 'SPCT002'), (SELECT TOP 1
            id
        FROM Size_ao
        WHERE ma = 'Size002'), '2024-01-21', '2024-01-21', 1),
    ((SELECT TOP 1
            id
        FROM san_pham_chi_tiet
        WHERE ma = 'SPCT003'), (SELECT TOP 1
            id
        FROM Size_ao
        WHERE ma = 'Size003'), '2024-01-22', '2024-01-22', 1);


-- data Voucher table
INSERT INTO Voucher
    (id, ma, ten, giam_gia, ngay_bat_dau, ngay_het_han, so_luong, ngay_tao, ngay_sua, trang_thai)
VALUES
    (NEWID(), 'V001', 'Voucher 1', 10.00, '2024-01-20', '2024-02-20', 50, '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'V002', 'Voucher 2', 15.00, '2024-01-25', '2024-02-25', 30, '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'V003', 'Voucher 3', 20.00, '2024-01-30', '2024-02-28', 40, '2024-01-20', '2024-01-20', 1);
-- data Khach_Hang
INSERT INTO Khach_Hang
    (id, ma, ten, sdt, ngay_tao, ngay_sua, trang_thai)
VALUES
    (NEWID(), 'KH001', 'KH 1', '1234567890', '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'KH002', 'Kh 2', '9876543210', '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'KH003', 'Kh 3', '5551234567', '2024-01-20', '2024-01-20', 1);

-- data Hoa_Don
INSERT INTO Hoa_Don
    (id, id_kh, ma, id_nv, ngay_mua, tong_tien, ngay_tao, ngay_sua, trang_thai)
VALUES
    (NEWID(), (SELECT TOP 1
            id
        FROM Khach_Hang
        WHERE ma = 'KH001'), 'HD001', (SELECT TOP 1
            id
        FROM Nguoi_Dung
        WHERE ten = 'nv1'), '2024-01-20', 150.00, '2024-01-20', '2024-01-20', 1),
    (NEWID(), (SELECT TOP 1
            id
        FROM Khach_Hang
        WHERE ma = 'KH002'), 'HD002', (SELECT TOP 1
            id
        FROM Nguoi_Dung
        WHERE ten = 'nv2'), '2024-01-21', 200.00, '2024-01-21', '2024-01-21', 1),
    (NEWID(), (SELECT TOP 1
            id
        FROM Khach_Hang
        WHERE ma = 'KH003'), 'HD003', (SELECT TOP 1
            id
        FROM Nguoi_Dung
        WHERE ten = 'nv3'), '2024-01-22', 120.00, '2024-01-22', '2024-01-22', 1);

-- data Hoa_Don_Chi_Tiet
INSERT INTO Hoa_Don_Chi_Tiet
    (id, id_hd, id_sp, so_luong, gia_ban, ngay_tao, ngay_sua, trang_thai)
VALUES
    (NEWID(), (SELECT TOP 1
            id
        FROM Hoa_Don
        WHERE ma = 'HD001'), (SELECT TOP 1
            id
        FROM san_pham
        WHERE ma = 'SP001'), 2, 75.00, '2024-01-20', '2024-01-20', 1),
    (NEWID(), (SELECT TOP 1
            id
        FROM Hoa_Don
        WHERE ma = 'HD002'), (SELECT TOP 1
            id
        FROM san_pham
        WHERE ma = 'SP002'), 3, 60.00, '2024-01-21', '2024-01-21', 1),
    (NEWID(), (SELECT TOP 1
            id
        FROM Hoa_Don
        WHERE ma = 'HD003'), (SELECT TOP 1
            id
        FROM san_pham
        WHERE ma = 'SP003'), 1, 120.00, '2024-01-22', '2024-01-22', 1);

-- data Hoa_Don_Voucher
INSERT INTO Hoa_Don_Voucher
    (id_hd, id_voucher, ngay_tao, ngay_sua, trang_thai)
VALUES
    ((SELECT TOP 1
            id
        FROM Hoa_Don
        WHERE ma = 'HD001'), (SELECT TOP 1
            id
        FROM Voucher
        WHERE ma = 'V001'), '2024-01-20', '2024-01-20', 1),
    ((SELECT TOP 1
            id
        FROM Hoa_Don
        WHERE ma = 'HD002'), (SELECT TOP 1
            id
        FROM Voucher
        WHERE ma = 'V002'), '2024-01-21', '2024-01-21', 1),
    ((SELECT TOP 1
            id
        FROM Hoa_Don
        WHERE ma = 'HD003'), (SELECT TOP 1
            id
        FROM Voucher
        WHERE ma = 'V003'), '2024-01-22', '2024-01-22', 1);

-- data Gio_Hang
INSERT INTO Gio_Hang
    (id, ma, id_kh, ngay_tao, ngay_sua, trang_thai)
VALUES
    (NEWID(), 'GH001', (SELECT TOP 1
            id
        FROM Khach_Hang
        WHERE ma = 'KH001'), '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'GH002', (SELECT TOP 1
            id
        FROM Khach_Hang
        WHERE ma = 'KH002'), '2024-01-21', '2024-01-21', 1),
    (NEWID(), 'GH003', (SELECT TOP 1
            id
        FROM Khach_Hang
        WHERE ma = 'KH003'), '2024-01-22', '2024-01-22', 1);

-- data Gio_Hang_Chi_Tiet
INSERT INTO Gio_Hang_Chi_Tiet
    (id, id_gh, id_sp, so_luong, ngay_tao, ngay_sua, trang_thai)
VALUES
    (NEWID(), (SELECT TOP 1
            id
        FROM Gio_Hang
        WHERE ma = 'GH001'), (SELECT TOP 1
            id
        FROM san_pham
        WHERE ma = 'SP001'), 2, '2024-01-20', '2024-01-20', 1),
    (NEWID(), (SELECT TOP 1
            id
        FROM Gio_Hang
        WHERE ma = 'GH002'), (SELECT TOP 1
            id
        FROM san_pham
        WHERE ma = 'SP002'), 3, '2024-01-21', '2024-01-21', 1),
    (NEWID(), (SELECT TOP 1
            id
        FROM Gio_Hang
        WHERE ma = 'GH003'), (SELECT TOP 1
            id
        FROM san_pham
        WHERE ma = 'SP003'), 1, '2024-01-22', '2024-01-22', 1);

-- data Gio_Hang_Hoa_Don
INSERT INTO Gio_Hang_Hoa_Don
    (id, id_gh, id_hd, ngay_tao, ngay_sua, trang_thai)
VALUES
    (NEWID(), (SELECT TOP 1
            id
        FROM Gio_Hang
        WHERE ma = 'GH001'), (SELECT TOP 1
            id
        FROM Hoa_Don
        WHERE ma = 'HD001'), '2024-01-20', '2024-01-20', 1),
    (NEWID(), (SELECT TOP 1
            id
        FROM Gio_Hang
        WHERE ma = 'GH002'), (SELECT TOP 1
            id
        FROM Hoa_Don
        WHERE ma = 'HD002'), '2024-01-21', '2024-01-21', 1),
    (NEWID(), (SELECT TOP 1
            id
        FROM Gio_Hang
        WHERE ma = 'GH003'), (SELECT TOP 1
            id
        FROM Hoa_Don
        WHERE ma = 'HD003'), '2024-01-22', '2024-01-22', 1);

-- data Thanh_Toan
INSERT INTO Thanh_toan
    (id, ma, id_hd, phuong_thuc_thanh_toan, tien_thanh_toan, ngay_thanh_toan, ngay_tao, ngay_sua, trang_thai)
VALUES
    (NEWID(), 'TT001', (SELECT TOP 1
            id
        FROM Hoa_Don
        WHERE ma = 'HD001'), 'Credit Card', 150.00, '2024-01-22', '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'TT002', (SELECT TOP 1
            id
        FROM Hoa_Don
        WHERE ma = 'HD002'), 'Cash', 200.00, '2024-01-23', '2024-01-21', '2024-01-21', 1),
    (NEWID(), 'TT003', (SELECT TOP 1
            id
        FROM Hoa_Don
        WHERE ma = 'HD003'), 'PayPal', 120.00, '2024-01-24', '2024-01-22', '2024-01-22', 1);

-- data Nguoi_Dung
INSERT INTO Nguoi_Dung
    (id, ten, dia_chi, sdt, id_cv, ngay_bd, ngay_tao, ngay_sua, trang_thai)
VALUES
    (NEWID(), 'nv1', 'Address 1', '1112223333', (SELECT TOP 1
            id
        FROM chuc_vu
        WHERE ma = 'CV002'), '2024-01-20', '2024-01-20', '2024-01-20', 1),
    (NEWID(), 'nv2', 'Address 2', '4445556666', (SELECT TOP 1
            id
        FROM chuc_vu
        WHERE ma = 'CV002'), '2024-01-21', '2024-01-21', '2024-01-21', 1),
    (NEWID(), 'nv3', 'Address 3', '7778889999', (SELECT TOP 1
            id
        FROM chuc_vu
        WHERE ma = 'CV002'), '2024-01-22', '2024-01-22', '2024-01-22', 1),
    (NEWID(), 'admin', 'Address 5', '123456789', (SELECT TOP 1
            id
        FROM chuc_vu
        WHERE ma = 'CV001'), '2024-01-22', '2024-01-22', '2024-01-22', 1);

