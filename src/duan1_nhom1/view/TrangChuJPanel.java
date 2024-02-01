package duan1_nhom1.view;

import duan1_nhom1.dto.ChiTietGioHangDto;
import duan1_nhom1.dto.ChiTietHoaDonDto;
import duan1_nhom1.dto.ChiTietSanPhamDto;
import duan1_nhom1.dto.GioHangDto;
import duan1_nhom1.dto.HoaDonDto;
import duan1_nhom1.dto.KhachDto;
import duan1_nhom1.model.ChiTietSanPham;
import duan1_nhom1.model.GioHangHoaDon;
import duan1_nhom1.model.HoaDon;
import duan1_nhom1.model.Khach;
import duan1_nhom1.repository.GioHangHoaDonRepository;
import duan1_nhom1.service.ChatLieuService;
import duan1_nhom1.service.ChiTietGioHangService;
import duan1_nhom1.service.ChiTietHoaDonService;
import duan1_nhom1.service.DanhMucService;
import duan1_nhom1.service.GioHangService;
import duan1_nhom1.service.HangService;
import duan1_nhom1.service.HoaDonService;
import duan1_nhom1.service.IService;
import duan1_nhom1.service.KhachService;
import duan1_nhom1.service.KichCoService;
import duan1_nhom1.service.MauSacService;
import duan1_nhom1.service.SPChiTietService;
import duan1_nhom1.service.SanPhamService;
import duan1_nhom1.service.ThanhToanService;
import duan1_nhom1.utils.MsgBox;
import java.awt.Color;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.regex.*;

public class TrangChuJPanel extends javax.swing.JPanel {

    int row1 = -1;
    int row2 = -1;
    int row3 = -1;
    private ChiTietHoaDonService hdctService = new ChiTietHoaDonService();
    private ThanhToanService thanhToanService = new ThanhToanService();
    private List<HoaDon> listHD = new ArrayList<>();
    private HoaDonService hds = new HoaDonService();
    private List<ChiTietSanPham> listCTSP = new ArrayList<>();
    private SPChiTietService CTSP = new SPChiTietService();
    private IService iService = new SanPhamService();
    private SPChiTietService sPChiTietService = new SPChiTietService();
    private DefaultComboBoxModel defaultComboBoxModel;
    private DefaultTableModel defaultTableModel;
    private MauSacService mauSacService = new MauSacService();
    private HangService hangService = new HangService();
    private KichCoService kichCoService = new KichCoService();
    private SanPhamService sanPhamService = new SanPhamService();
    private DanhMucService danhMucService = new DanhMucService();
    private ChatLieuService chatLieuService = new ChatLieuService();
    List<ChiTietGioHangDto> cTgioHangList = new ArrayList<>();
    ChiTietSanPhamDto ctspView = new ChiTietSanPhamDto();
    ChiTietGioHangDto ctghView = new ChiTietGioHangDto();
    KhachDto khachView = new KhachDto();
    KhachService khachS = new KhachService();
    ChiTietGioHangService ctghService = new ChiTietGioHangService();
    ChiTietHoaDonService cthdService = new ChiTietHoaDonService();
    GioHangService ghService = new GioHangService();
    int _index = -1;

    public TrangChuJPanel() {
        initComponents();

        showDateHoaDon();
        loadBanHangGH();
        loadBanHangSp(sPChiTietService.getAll());
    }

    public void showDateHoaDon() {
        defaultTableModel = (DefaultTableModel) tbl_banhanghd.getModel();
        defaultTableModel.setRowCount(0);
        int count = 1;
        for (HoaDonDto hd : hds.getAllHD()) {
            Object[] rowData = {
                count++,
                hd.getMa(),
                hd.getNgayMua(),
                hd.getIdNv()
            };
            defaultTableModel.addRow(rowData);

        }
    }

    public void loadBanHangGH() {
        defaultTableModel = (DefaultTableModel) this.tbl_banhanggh.getModel();
        defaultTableModel.setRowCount(0);
        int count = 1;
        for (ChiTietGioHangDto items : cTgioHangList) {

            defaultTableModel.addRow(new Object[]{
                count++,
                this.sPChiTietService.findByIdSP(items.getIdSP()).getMa(),
                this.sanPhamService.findById(items.getIdSP()).getTen(),
                this.hangService.getTenById(this.CTSP.findByIdSP(items.getIdSP()).getIdThuongHieu()),
                this.kichCoService.getTenById(this.CTSP.findByIdSP(items.getIdSP()).getIdKichThuoc()),
                this.mauSacService.getTenById(this.CTSP.findByIdSP(items.getIdSP()).getIdMauSac()),
                items.getSoLuong(),
                (this.CTSP.findByIdSP(items.getIdSP()).getGiaBan().multiply(new BigDecimal(items.getSoLuong())))
            });
        }

    }

    public void loadBanHangSp(List<ChiTietSanPhamDto> list) {
        defaultTableModel = (DefaultTableModel) tbl_banhangsp.getModel();
        defaultTableModel.setRowCount(0);
        int count = 1;
        for (ChiTietSanPhamDto chiTietSanPham : list) {
            defaultTableModel.addRow(new Object[]{
                count++,
                this.sanPhamService.getTenById(chiTietSanPham.getIdSanPham()),
                chiTietSanPham.getMa(),
                this.hangService.getTenById(chiTietSanPham.getIdThuongHieu()),
                this.kichCoService.getTenById(chiTietSanPham.getIdKichThuoc()),
                this.mauSacService.getTenById(chiTietSanPham.getIdMauSac()),
                this.danhMucService.getTenById(chiTietSanPham.getIdDanhMuc()),
                chiTietSanPham.getSoLuong(),
                chiTietSanPham.getGiaBan(),});
        }
    }

    private ChiTietGioHangDto findItemByProductId(String idSp) {
        for (ChiTietGioHangDto item : cTgioHangList) {
            if (item.getIdSP().equals(idSp)) {
                return item;
            }
        }
        return null;
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^(\\+84|0)\\d{9,10}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }

    public String generateInvoiceCode() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int length = 10;

        StringBuilder invoiceCode = new StringBuilder();
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            invoiceCode.append(randomChar);
        }

        return invoiceCode.toString();
    }

    public String generateGHCode() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int length = 10;

        StringBuilder ghCode = new StringBuilder();
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            ghCode.append(randomChar);
        }

        return ghCode.toString();
    }

    public void saveCT(String idgh, String idHd) {

        for (ChiTietGioHangDto gh : cTgioHangList) {
            gh.setIdGH(idgh);
            this.ctghService.add(gh);
            ChiTietHoaDonDto cthd = new ChiTietHoaDonDto("", idHd, gh.getIdSP(), "", gh.getSoLuong(), this.CTSP.findByIdSP(gh.getIdSP()).getGiaBan().doubleValue(), new Date(), new Date(), Boolean.FALSE);
            this.cthdService.add(cthd);
        }
    }

    public BigDecimal calculateTotalPrice() {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (ChiTietGioHangDto item : cTgioHangList) {
            BigDecimal itemPrice = this.CTSP.findByIdSP(item.getIdSP()).getGiaBan();
            int itemQuantity = item.getSoLuong();
            BigDecimal itemTotal = itemPrice.multiply(BigDecimal.valueOf(itemQuantity));
            totalPrice = totalPrice.add(itemTotal);
        }
        return totalPrice;
    }

    public void searchKhach() {
        try {
            String sdt = txtSdt.getText().trim();
            KhachDto khachDto = this.khachS.findBySdt(sdt);
            if (khachDto != null) {
                khachView = khachDto;
                this.txtTenKhach.setText(khachView.getTenKhachHang());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_banhangsp = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_banhanghd = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_banhanggh = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        tienTraLai = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtMahdTT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jlbTongTienSauGiam = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jlbTienThua = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        txtTenKhach = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        txtTienThua = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnThemVaoGH = new javax.swing.JButton();
        btnDeleteAll = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(203, 233, 162));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(203, 233, 162));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel2.setText("Hóa đơn chờ");

        tbl_banhangsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên sản phẩm", "Mã sản phẩm", "Hãng", "Kích cỡ", "Màu sắc", "Danh mục", "Số lượng", "Đơn giá"
            }
        ));
        tbl_banhangsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_banhangspMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_banhangsp);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel3.setText("Giỏ hàng");

        tbl_banhanghd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã HD", "Ngày tạo", "Mã nhân viên"
            }
        ));
        tbl_banhanghd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_banhanghdMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_banhanghd);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel4.setText("Sản phẩm");

        tbl_banhanggh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Hãng", "Kích cỡ", "Màu sắc", "Số lượng", "Đơn giá"
            }
        ));
        tbl_banhanggh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_banhangghMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_banhanggh);

        jButton8.setText("Tìm kiếm");

        jButton9.setText("Tạo hóa đơn");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Hủy");

        tienTraLai.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Mã hóa đơn:");

        jLabel6.setText("Tổng tiền:");

        jLabel8.setText("Voucher:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Tổng tiền sau giảm:");

        jlbTongTienSauGiam.setText("-");

        jLabel11.setText("SĐT:");

        jButton11.setText("Tìm");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel13.setText("Tên khách hàng:");

        jLabel15.setText("Phương thức TT:");

        jLabel18.setText("Tiền khách đưa:");

        jLabel19.setText("Trả lại:");

        jlbTienThua.setText("-");

        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Tiền mặt ");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Chuyển khoản ");

        javax.swing.GroupLayout tienTraLaiLayout = new javax.swing.GroupLayout(tienTraLai);
        tienTraLai.setLayout(tienTraLaiLayout);
        tienTraLaiLayout.setHorizontalGroup(
            tienTraLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tienTraLaiLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jButton11)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(tienTraLaiLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(tienTraLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tienTraLaiLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(tienTraLaiLayout.createSequentialGroup()
                        .addGroup(tienTraLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tienTraLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, tienTraLaiLayout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(18, 18, 18)
                                    .addComponent(jlbTongTienSauGiam))
                                .addGroup(tienTraLaiLayout.createSequentialGroup()
                                    .addGroup(tienTraLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel5))
                                    .addGap(38, 38, 38)
                                    .addGroup(tienTraLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtMahdTT)
                                        .addComponent(jComboBox1, 0, 171, Short.MAX_VALUE))))
                            .addGroup(tienTraLaiLayout.createSequentialGroup()
                                .addGroup(tienTraLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addGroup(tienTraLaiLayout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(18, 18, 18)
                                        .addComponent(jlbTienThua))
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(tienTraLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTienKhachDua)
                                    .addComponent(txtTenKhach)
                                    .addGroup(tienTraLaiLayout.createSequentialGroup()
                                        .addGroup(tienTraLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(tienTraLaiLayout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(btnThanhToan))
                                            .addComponent(jRadioButton2)
                                            .addComponent(jRadioButton1)
                                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(tienTraLaiLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120))))
        );
        tienTraLaiLayout.setVerticalGroup(
            tienTraLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tienTraLaiLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(tienTraLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMahdTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(tienTraLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tienTraLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jlbTongTienSauGiam))
                .addGap(18, 18, 18)
                .addGroup(tienTraLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton11)
                .addGap(21, 21, 21)
                .addGroup(tienTraLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTenKhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tienTraLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addGap(35, 35, 35)
                .addGroup(tienTraLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tienTraLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tienTraLaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jlbTienThua)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThanhToan)
                .addGap(75, 75, 75))
        );

        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Xóa");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnThemVaoGH.setText("Thêm sản phẩm");
        btnThemVaoGH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemVaoGHActionPerformed(evt);
            }
        });

        btnDeleteAll.setText("Xoá toàn bộ ");
        btnDeleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(131, 131, 131)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(jButton8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnThemVaoGH))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4)
                                    .addComponent(jButton5)
                                    .addComponent(btnDeleteAll))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tienTraLai, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(397, 397, 397)
                            .addComponent(jButton9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton10))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jButton9)
                            .addComponent(jButton10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jButton4)
                                .addGap(49, 49, 49)
                                .addComponent(jButton5)
                                .addGap(18, 18, 18)
                                .addComponent(btnDeleteAll)))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8)
                            .addComponent(btnThemVaoGH))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tienTraLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Trang chủ", jPanel3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1091, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 708, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_banhangspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_banhangspMouseClicked
        // TODO add your handling code here:
        int index = -1;
        index = this.tbl_banhangsp.getSelectedRow();
        if (index == -1) {
            return;
        }

        ctspView = this.sPChiTietService.findByMaCt(this.tbl_banhangsp.getValueAt(index, 2).toString());

    }//GEN-LAST:event_tbl_banhangspMouseClicked

    private void btnThemVaoGHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemVaoGHActionPerformed
        // TODO add your handling code here:

        String userInput = JOptionPane.showInputDialog(null, "Nhập số lượng sản phẩm:", "Nhập số lượng", JOptionPane.QUESTION_MESSAGE);
        if (userInput != null && !userInput.isEmpty()) {
            Integer quantity = Integer.valueOf(userInput);
            ChiTietGioHangDto chiTietGioHang = this.findItemByProductId(ctspView.getIdSanPham());
            if (chiTietGioHang != null) {
                chiTietGioHang.setSoLuong(chiTietGioHang.getSoLuong() + quantity);
            } else {
                ChiTietGioHangDto item = new ChiTietGioHangDto("", "", ctspView.getIdSanPham(), quantity, new Date(), new Date(), Boolean.TRUE);

                ctspView.setSoLuong(ctspView.getSoLuong() - quantity);
                sPChiTietService.changeSL(ctspView);
                cTgioHangList.add(item);

            }
        }
        this.txtTongTien.setText(calculateTotalPrice().toString());
        this.loadBanHangGH();
        this.loadBanHangSp(sPChiTietService.getAll());

    }//GEN-LAST:event_btnThemVaoGHActionPerformed

    private void tbl_banhangghMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_banhangghMouseClicked
        // TODO add your handling code here:
        int index = -1;
        index = this.tbl_banhanggh.getSelectedRow();
        if (index == -1) {
            return;
        }

        String idSp = this.CTSP.findByMaCt(this.tbl_banhanggh.getValueAt(index, 1).toString()).getIdSanPham();
        ctghView.setIdSP(idSp);

    }//GEN-LAST:event_tbl_banhangghMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xoá không?", "Confirmation", JOptionPane.YES_NO_OPTION);
        switch (option) {
            case JOptionPane.YES_OPTION -> {

                String ma = ctghView.getIdSP();
                System.out.println(ma);

                for (ChiTietGioHangDto items : cTgioHangList) {
                    if (items.getIdSP().equals(ma)) {
                        ctspView.setSoLuong(ctspView.getSoLuong() + items.getSoLuong());
                        sPChiTietService.changeSL(ctspView);
                        cTgioHangList.remove(items);
                        JOptionPane.showMessageDialog(this, "Xoá thành công");
                        break;
                    }
                }
                this.loadBanHangGH();
                this.loadBanHangSp(sPChiTietService.getAll());
            }
            case JOptionPane.NO_OPTION -> {
            }
            case JOptionPane.CANCEL_OPTION, JOptionPane.CLOSED_OPTION -> {
            }
            default -> {
            }
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnDeleteAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAllActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xoá không?", "Confirmation", JOptionPane.YES_NO_OPTION);
        switch (option) {
            case JOptionPane.YES_OPTION -> {
                for (ChiTietGioHangDto items : cTgioHangList) {
                    ctspView.setSoLuong(ctspView.getSoLuong() + items.getSoLuong());
                    sPChiTietService.changeSL(ctspView);
                }
                this.cTgioHangList.clear();
                JOptionPane.showMessageDialog(this, "Xoá thành công");
                this.loadBanHangGH();
                this.loadBanHangSp(sPChiTietService.getAll());
            }

            case JOptionPane.NO_OPTION -> {
            }
            case JOptionPane.CANCEL_OPTION, JOptionPane.CLOSED_OPTION -> {
            }
            default -> {
            }
        }

    }//GEN-LAST:event_btnDeleteAllActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
//        String userInput = JOptionPane.showInputDialog(null, "Nhập số điện thoại của khách:", "Tạo hoá đơn", JOptionPane.QUESTION_MESSAGE);

//        if (userInput != null && !userInput.isEmpty()) {
//            try {
//                if (this.isValidPhoneNumber(userInput)) {
//                    String idKhach = this.khachS.findBySdt(userInput).getId();
//                    System.out.println(idKhach);
//                    if (idKhach != null) {
        HoaDonDto hd = new HoaDonDto();
        hd.setIdNv("497bc77a-ae69-4f07-9436-72f37de7652f");
        hd.setMa(generateInvoiceCode());
        hd.setNgayMua(new Date());
        hd.setNgaySua(new Date());
        hd.setNgayTao(new Date());
        hd.setTongTien(calculateTotalPrice().doubleValue());
        hd.setTrangThai(Boolean.FALSE);
        this.hds.add(hd);
        JOptionPane.showMessageDialog(null, "Tạo hoá đơn thành công");
        cTgioHangList.clear();
        this.loadBanHangGH();
        this.loadBanHangSp(sPChiTietService.getAll());
        this.showDateHoaDon();
//                    } else {
//                        KhachDto khach = new KhachDto();

//                    }
//                } else {
//                    JOptionPane.showMessageDialog(null, "Yêu cầu nhập đúng định dạng số điện thoại.");
//                }
//
//            } catch (NumberFormatException e) {
//                JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
////            }
//        } else {
//            JOptionPane.showMessageDialog(null, "Bạn đã hủy .");
//        }        // TODO add your handling code here:

    }//GEN-LAST:event_jButton9ActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        if (txtTienKhachDua.getText().trim().equals("")) {
            txtTienKhachDua.setText("0");
        }
        HoaDonDto hoaDonDto = this.hds.findByMa(this.txtMahdTT.getText().trim());
        hoaDonDto.setTrangThai(Boolean.TRUE);
        hoaDonDto.setTongTien(calculateTotalPrice().doubleValue());
        if (this.khachView != null) {
            hoaDonDto.setIdKhachHang(khachView.getId());
        }

        System.out.println(hoaDonDto.getId());
        Double tienkh = Double.valueOf(this.txtTienKhachDua.getText().trim());
        Double tienThua = tienkh - calculateTotalPrice().doubleValue();
        Double tongTien = Double.valueOf(this.txtTongTien.getText().trim());
        txtTienThua.setText(tienThua.toString());

        try {
            if (txtMahdTT.getText().equals("")) {
                MsgBox.alert(this, "Vui lòng chọn hóa đơn trước khi nhấn thanh toán");
                return;
            } else if (tbl_banhanggh.getRowCount() == 0) {
                MsgBox.alert(this, "Vui lòng chọn sản phẩm trước khi nhấn thanh toán");
                return;
            } else {

                if (MsgBox.confirm(this, "Bạn chắc chắn muốn thanh toán hóa đơn này chứ?")) {
                    if (tienkh == tongTien || tienkh > tongTien) {
                        MsgBox.alert(this, "Số tiền khách đưa không đủ để thanh toán");
                        txtTienKhachDua.setBackground(Color.red);
                        return;
                    } else {
                        txtTienKhachDua.setBackground(Color.white);
                        this.hds.update(hoaDonDto, hoaDonDto.getId());
                        this.jlbTienThua.setText(tienThua.toString());
                        List<ChiTietHoaDonDto> listCthd = this.cthdService.getAllByIdHd(hoaDonDto.getId());
                        for (ChiTietHoaDonDto chiTietHoaDonDto : listCthd) {
                            chiTietHoaDonDto.setTrangThai(Boolean.TRUE);
                            this.cthdService.update2(chiTietHoaDonDto);
                        }
                        GioHangDto ghd = new GioHangDto();
                        if (this.khachView != null) {
                            ghd.setIdKH(khachView.getId());
                        }
                        ghd.setMa(generateGHCode());
                        String magh = ghd.getMa();
                        ghd.setNgaySua(new Date());
                        ghd.setNgayTao(new Date());
                        ghd.setTrangThai(Boolean.FALSE);
                        this.ghService.add(ghd);
                        this.saveCT(this.ghService.findByMa(magh).getId(), hoaDonDto.getId());
                        GioHangHoaDonRepository repo = new GioHangHoaDonRepository();
                        repo.createGioHangHoaDon(new GioHangHoaDon("", this.ghService.findByMa(magh).getId(), hoaDonDto.getId(), new Date(), new Date(), Boolean.TRUE));

                        String id = repo.getGioHangHoaDonById(hoaDonDto.getId()).getIdGioHang();
                        System.out.println(id);

                        ghd.setTrangThai(Boolean.TRUE);
                        this.ghService.update(ghd, id);
                        for (ChiTietGioHangDto ctgh : cTgioHangList) {
                            ctgh.setTrangThai(Boolean.TRUE);
                            this.ctghService.update(ctgh, ctgh.getId());
//                        if (Msgbox.confirm(this, "Bạn muốn in hóa đơn này không ??")) {
//                            xuatHoaDon();
//                        }
                        }
                        cTgioHangList.clear();
                        this.txtMahdTT.setText("");
                        this.txtTongTien.setText("");
                        this.txtTienKhachDua.setText("");
                        this.txtSdt.setText("");
                        this.loadBanHangGH();
                        this.loadBanHangSp(sPChiTietService.getAll());
                        this.showDateHoaDon();
                        MsgBox.alert(this, "Thanh toán thành công!");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Thanh toán thất bại");
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void tbl_banhanghdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_banhanghdMouseClicked
        // TODO add your handling code here:
        int index = -1;
        index = this.tbl_banhanghd.getSelectedRow();
        if (index == -1) {
            return;
        }

//        String idhd = this.hds.findByMa(this.tbl_banhanghd.getValueAt(index, 1).toString()).getId();
//        List<ChiTietHoaDonDto> listCTHD = this.cthdService.getAllByIdHd(idhd);
//        GioHangHoaDonRepository repo = new GioHangHoaDonRepository();
//        String idgh = repo.getGioHangHoaDonById(idhd).getIdGioHang();
//        cTgioHangList.clear();
//        for (ChiTietGioHangDto item : this.ctghService.getAll()) {
//            if (item.getIdGH().equals(idgh)) {
//                cTgioHangList.add(item);
//            }
//        }
        String mahd = this.tbl_banhanghd.getValueAt(index, 1).toString();
        this.txtMahdTT.setText(mahd);
        this.txtTongTien.setText(calculateTotalPrice().toString());

        this.loadBanHangGH();
        this.loadBanHangSp(sPChiTietService.getAll());
//        this.showDateHoaDon();
    }//GEN-LAST:event_tbl_banhanghdMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        searchKhach();
    }//GEN-LAST:event_jButton11ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteAll;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemVaoGH;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jlbTienThua;
    private javax.swing.JLabel jlbTongTienSauGiam;
    private javax.swing.JTable tbl_banhanggh;
    private javax.swing.JTable tbl_banhanghd;
    private javax.swing.JTable tbl_banhangsp;
    private javax.swing.JPanel tienTraLai;
    private javax.swing.JTextField txtMahdTT;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTenKhach;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
