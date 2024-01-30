/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package duan1_nhom1.view;

import duan1_nhom1.dto.ChiTietSanPhamDto;
import duan1_nhom1.service.ChatLieuService;
import duan1_nhom1.service.DanhMucService;
import duan1_nhom1.service.HangService;
import duan1_nhom1.service.IService;
import duan1_nhom1.service.KichCoService;
import duan1_nhom1.service.MauSacService;
import duan1_nhom1.service.SPChiTietService;
import duan1_nhom1.service.SanPhamService;
import duan1_nhom1.utils.Uhelper;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anhtuanle
 */
public class SPChiTietJPanel extends javax.swing.JPanel {

    
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
    int _index;
    private int index = -1;
    
    public SPChiTietJPanel(ChiTietSanPhamDto sp) {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    
    private void clearForm() {
        txt_masp.setText("");
        cb_tensp.setSelectedIndex(0);
        cb_hang.setSelectedIndex(0);
        cb_chatlieu.setSelectedIndex(0);
        cb_mausac.setSelectedIndex(0);
        cb_kichco.setSelectedIndex(0);
        cb_danhmuc.setSelectedIndex(0);
        txt_gianhap.setText("");
        txt_giaban.setText("");
        txt_soluong.setText("");
        date_ngaynhap.setDate(null);
        date_ngaytao.setDate(null);
        date_ngaysua.setDate(null);
        

    }

    public void addTable(List<ChiTietSanPhamDto> list) {
        defaultTableModel = (DefaultTableModel) tbl_sanpham.getModel();
        defaultTableModel.setRowCount(0);
        int count = 1;
       
        for (ChiTietSanPhamDto chiTietSanPham : list) {
            defaultTableModel.addRow(new Object[]{
                count++,
                chiTietSanPham.getMa(),
                this.sanPhamService.getTenById(chiTietSanPham.getIdSanPham().toString()),
                this.hangService.getTenById(chiTietSanPham.getIdThuongHieu().toString()),
                this.chatLieuService.getTenById(chiTietSanPham.getIdChatLieu().toString()),
                this.mauSacService.getTenById(chiTietSanPham.getIdMauSac().toString()),
                this.kichCoService.getTenById(chiTietSanPham.getIdKichThuoc().toString()),
                this.danhMucService.getTenById(chiTietSanPham.getIdDanhMuc().toString()),
                chiTietSanPham.getGiaNhap(),
                chiTietSanPham.getGiaBan(),
                chiTietSanPham.getSoLuong(),
                chiTietSanPham.getNgayNhap(),
                chiTietSanPham.getNgaySua(),
                chiTietSanPham.getNgayTao(),
                chiTietSanPham.getTrangThai()
            });
        }
    }

    public void loadDanhMuc() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cb_danhmuc.getModel();
        List<String> list = danhMucService.getAllId();
        for (String str : list) {
            model.addElement(danhMucService.getTenById(str));
        }
    }

    public void loadChatLieu() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cb_chatlieu.getModel();
        List<String> list = chatLieuService.getAllId();
        for (String str : list) {
            model.addElement(chatLieuService.getTenById(str));
        }
    }

    public void loadSanPham() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cb_tensp.getModel();
        List<String> list = sanPhamService.getAllId();
        for (String str : list) {
            model.addElement(sanPhamService.getTenById(str));
        }
    }

    public void loadKichThuoc() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cb_kichco.getModel();
        List<String> list = kichCoService.getAllId();
        for (String str : list) {
            model.addElement(kichCoService.getTenById(str));
        }
    }

    public void loadMauSac() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cb_mausac.getModel();
        List<String> list = mauSacService.getAllId();
        for (String str : list) {
            model.addElement(mauSacService.getTenById(str));
        }
    }

    public void loadHang() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cb_hang.getModel();
        List<String> list = hangService.getAllId();
        for (String str : list) {
            model.addElement(hangService.getTenById(str));
        }
    }


    private void updateSP() {
        if (Uhelper.checkNull(txt_giaban, "Không để trống giá bán")) {
            return;
        }
        if (Uhelper.checkNull(txt_gianhap, "Không để trống giá nhập")) {
            return;
        }
        if (Uhelper.checkKiTuDacBiet(txt_giaban, "Không nhập các kí tự đặc biệt !")) {
            return;
        }
        if (Uhelper.checkKiTuDacBiet(txt_gianhap, "Không nhập các kí tự đặc biệt !")) {
            return;
        }
        if (Uhelper.checkNumber(txt_giaban, "Vui lòng nhập giá bán là số")) {
            return;
        }
        if (Uhelper.checkNumber(txt_gianhap, "Vui lòng nhập giá nhập là số")) {
            return;
        }
        if (Uhelper.checkNull(txt_masp, "Vui lòng nhập mã sản phẩm")) {
            return;
        }
        index = tbl_sanpham.getSelectedRow();

        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Bạn vui lòng chọn sản phẩm cần sửa !");
            return;
        }

        String id = this.sPChiTietService.getAll().get(index).getId();
        String maSP = txt_masp.getText().trim();
        String idTenSP = sanPhamService.getAllId().get(cb_tensp.getSelectedIndex());
        String idThuongHieu = hangService.getAllId().get(cb_hang.getSelectedIndex());
        String idMauSac = mauSacService.getAllId().get(cb_mausac.getSelectedIndex());
        String idChatLieu = chatLieuService.getAllId().get(cb_chatlieu.getSelectedIndex());
        String idKichCo = kichCoService.getAllId().get(cb_kichco.getSelectedIndex());
        String idDanhMuc = danhMucService.getAllId().get(cb_danhmuc.getSelectedIndex());
        BigDecimal giaNhap = new BigDecimal(txt_gianhap.getText());
        BigDecimal giaBan = new BigDecimal(txt_giaban.getText());
//        boolean trangThai = Boolean.parseBoolean(txt_trangthai.getText());
        Integer soLuong = Integer.parseInt(txt_soluong.getText());

        if (giaBan.compareTo(giaNhap) != 0 && giaBan.compareTo(giaNhap) != 1) {
            JOptionPane.showMessageDialog(this, "Giá bán lớn hơn giá nhập, bạn vui lòng nhập lại giá bán !");
            return;
        }

        Date ngayNhap = new Date();
        String timeStamp = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").format(Calendar.getInstance().getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
        try {
            ngayNhap = sdf.parse(timeStamp);
        } catch (ParseException ex) {
            Logger.getLogger(SPChiTietFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        Date ngayTao = new Date();
        try {
            ngayTao = sdf.parse(timeStamp);
        } catch (ParseException ex) {
            Logger.getLogger(SPChiTietFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        Date ngaySua = new Date();
        try {
            ngaySua = sdf.parse(timeStamp);
        } catch (ParseException ex) {
            Logger.getLogger(SPChiTietFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        boolean trangThai = true;
        ChiTietSanPhamDto ctsp = new ChiTietSanPhamDto(id, maSP, idTenSP, idKichCo, idThuongHieu, idMauSac, idChatLieu, idDanhMuc, giaNhap, giaBan, soLuong, ngayTao, ngaySua, ngayNhap, trangThai);
        this.sPChiTietService.update(ctsp, id);
        addTable(sPChiTietService.getAll());

    }

    private void deleteSP() {
        try {
            int check = JOptionPane.showConfirmDialog(this, "bạn có muốn xóa không");
            if (check != JOptionPane.YES_OPTION) {
                return;
            }
            int row = tbl_sanpham.getSelectedRow();
            String id = sPChiTietService.getAll().get(row).getId();
            sPChiTietService.deleteSP(id);

            JOptionPane.showMessageDialog(this, "xóa thành công");
            addTable(sPChiTietService.getAll());
            clearForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "xóa thất bại ");
        }
    }

    private void addSanPham() {
        if (Uhelper.checkNull(txt_giaban, "Không để trống giá bán")) {
            return;
        }
        if (Uhelper.checkNull(txt_gianhap, "Không để trống giá nhập")) {
            return;
        }
        if (Uhelper.checkKiTuDacBiet(txt_giaban, "Không nhập các kí tự đặc biệt !")) {
            return;
        }
        if (Uhelper.checkKiTuDacBiet(txt_gianhap, "Không nhập các kí tự đặc biệt !")) {
            return;
        }
        if (Uhelper.checkNumber(txt_giaban, "Vui lòng nhập giá bán là số")) {
            return;
        }
        if (Uhelper.checkNumber(txt_gianhap, "Vui lòng nhập giá nhập là số")) {
            return;
        }
        if (Uhelper.checkNull(txt_masp, "Vui lòng nhập mã sản phẩm")) {
            return;
        }

        String maSP = txt_masp.getText().trim();
        String idTenSP = sanPhamService.getAllId().get(cb_tensp.getSelectedIndex());
        String idThuongHieu = hangService.getAllId().get(cb_hang.getSelectedIndex());
        String idMauSac = mauSacService.getAllId().get(cb_mausac.getSelectedIndex());
        String idChatLieu = chatLieuService.getAllId().get(cb_chatlieu.getSelectedIndex());
        String idKichCo = kichCoService.getAllId().get(cb_kichco.getSelectedIndex());
        String idDanhMuc = danhMucService.getAllId().get(cb_danhmuc.getSelectedIndex());
        BigDecimal giaNhap = new BigDecimal(txt_gianhap.getText());
        BigDecimal giaBan = new BigDecimal(txt_giaban.getText());
//        boolean trangThai = Boolean.parseBoolean(txt_trangthai.getText());
        int soLuong = Integer.parseInt(txt_soluong.getText());

        if (giaBan.compareTo(giaNhap) != 0 && giaBan.compareTo(giaNhap) != 1) {
            JOptionPane.showMessageDialog(this, "Giá bán lớn hơn giá nhập, bạn vui lòng nhập lại giá bán !");
            return;
        }

        Date ngayNhap = new Date();
        String timeStamp = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").format(Calendar.getInstance().getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
        try {
            ngayNhap = sdf.parse(timeStamp);
        } catch (ParseException ex) {
            Logger.getLogger(SPChiTietFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        Date ngayTao = new Date();
        try {
            ngayTao = sdf.parse(timeStamp);
        } catch (ParseException ex) {
            Logger.getLogger(SPChiTietFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        Date ngaySua = new Date();
        try {
            ngaySua = sdf.parse(timeStamp);
        } catch (ParseException ex) {
            Logger.getLogger(SPChiTietFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        boolean trangThai = true;
        ChiTietSanPhamDto ctsp = new ChiTietSanPhamDto("", maSP, idTenSP, idKichCo, idThuongHieu, idMauSac, idChatLieu, idDanhMuc, giaNhap, giaBan, soLuong, ngayTao, ngaySua, ngayNhap, trangThai);

        sPChiTietService.insert(ctsp);
        addTable(sPChiTietService.getAll());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cb_findhang = new javax.swing.JComboBox<>();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sanpham = new javax.swing.JTable();
        Back = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cb_tensp = new javax.swing.JComboBox<>();
        cb_hang = new javax.swing.JComboBox<>();
        cb_chatlieu = new javax.swing.JComboBox<>();
        cb_danhmuc = new javax.swing.JComboBox<>();
        cb_mausac = new javax.swing.JComboBox<>();
        cb_kichco = new javax.swing.JComboBox<>();
        txt_gianhap = new javax.swing.JTextField();
        txt_giaban = new javax.swing.JTextField();
        txt_soluong = new javax.swing.JTextField();
        date_ngaynhap = new com.toedter.calendar.JDateChooser();
        date_ngaysua = new com.toedter.calendar.JDateChooser();
        date_ngaytao = new com.toedter.calendar.JDateChooser();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        txt_trangthai = new javax.swing.JTextField();
        txt_masp = new javax.swing.JTextField();
        btn_them1 = new javax.swing.JButton();
        btn_them2 = new javax.swing.JButton();
        btn_them3 = new javax.swing.JButton();
        btn_them4 = new javax.swing.JButton();
        btn_them5 = new javax.swing.JButton();
        btn_them6 = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(203, 233, 162));

        jPanel3.setBackground(new java.awt.Color(203, 233, 162));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_search.setText("Tìm kiếm");

        tbl_sanpham.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        tbl_sanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Hãng", "Chất liệu", "Màu sắc", "Kích cỡ", "Danh mục", "Giá nhập", "Giá bán", "Số lượng", "Ngày nhập", "Ngày sửa", "Ngày tạo", "Trạng thái"
            }
        ));
        tbl_sanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sanphamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_sanpham);

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(cb_findhang, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(313, 313, 313)
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_search)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 282, Short.MAX_VALUE)
                .addComponent(Back)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_findhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search)
                    .addComponent(Back))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setText("Hình ảnh");

        jLabel3.setText("Tên sản phẩm:");

        jLabel4.setText("Hãng:");

        jLabel5.setText("Chất liệu:");

        jLabel6.setText("Danh Mục:");

        jLabel8.setText("Kích cỡ:");

        jLabel9.setText("Trang thai:");

        jLabel10.setText("Màu sắc:");

        jLabel11.setText("Mã sản phẩm:");

        jLabel12.setText("Giá nhập:");

        jLabel13.setText("Giá bán:");

        jLabel14.setText("Số lượng:");

        jLabel15.setText("Ngày nhập:");

        jLabel16.setText("Ngày sửa:");

        jLabel17.setText("Ngày tạo:");

        cb_hang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_hangActionPerformed(evt);
            }
        });

        cb_mausac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_mausacActionPerformed(evt);
            }
        });

        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        btn_them1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duan1_nhom1/Icon/edit_property_24px.png"))); // NOI18N
        btn_them1.setBorder(null);
        btn_them1.setBorderPainted(false);
        btn_them1.setContentAreaFilled(false);
        btn_them1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_them1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_them1ActionPerformed(evt);
            }
        });

        btn_them2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duan1_nhom1/Icon/edit_property_24px.png"))); // NOI18N
        btn_them2.setBorder(null);
        btn_them2.setBorderPainted(false);
        btn_them2.setContentAreaFilled(false);
        btn_them2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_them2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_them2ActionPerformed(evt);
            }
        });

        btn_them3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duan1_nhom1/Icon/edit_property_24px.png"))); // NOI18N
        btn_them3.setBorder(null);
        btn_them3.setBorderPainted(false);
        btn_them3.setContentAreaFilled(false);
        btn_them3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_them3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_them3ActionPerformed(evt);
            }
        });

        btn_them4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duan1_nhom1/Icon/edit_property_24px.png"))); // NOI18N
        btn_them4.setBorder(null);
        btn_them4.setBorderPainted(false);
        btn_them4.setContentAreaFilled(false);
        btn_them4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_them4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_them4ActionPerformed(evt);
            }
        });

        btn_them5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duan1_nhom1/Icon/edit_property_24px.png"))); // NOI18N
        btn_them5.setBorder(null);
        btn_them5.setBorderPainted(false);
        btn_them5.setContentAreaFilled(false);
        btn_them5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_them5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_them5ActionPerformed(evt);
            }
        });

        btn_them6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duan1_nhom1/Icon/edit_property_24px.png"))); // NOI18N
        btn_them6.setBorder(null);
        btn_them6.setBorderPainted(false);
        btn_them6.setContentAreaFilled(false);
        btn_them6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_them6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_them6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel2)
                .addGap(129, 129, 129)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cb_kichco, 0, 165, Short.MAX_VALUE)
                    .addComponent(cb_mausac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_danhmuc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_chatlieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_tensp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_hang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_trangthai, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_them1)
                    .addComponent(btn_them2)
                    .addComponent(btn_them3)
                    .addComponent(btn_them4)
                    .addComponent(btn_them5)
                    .addComponent(btn_them6))
                .addGap(76, 76, 76)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(txt_masp))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_soluong)
                            .addComponent(txt_giaban)
                            .addComponent(txt_gianhap)
                            .addComponent(date_ngaynhap, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(date_ngaysua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(date_ngaytao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_them)
                    .addComponent(btn_sua)
                    .addComponent(btn_xoa)
                    .addComponent(btn_clear))
                .addGap(49, 49, 49))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel3)
                                                                .addComponent(cb_tensp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addComponent(btn_them1))
                                                        .addGap(14, 14, 14)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel4)
                                                            .addComponent(cb_hang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addComponent(btn_them4))
                                                .addGap(15, 15, 15)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel5)
                                                        .addComponent(cb_chatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(btn_them2, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addGap(14, 14, 14)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel6)
                                                    .addComponent(cb_danhmuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(btn_them3))
                                        .addGap(14, 14, 14)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel10)
                                            .addComponent(cb_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(btn_them5))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(cb_kichco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btn_them6))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel11)
                                            .addComponent(btn_them)
                                            .addComponent(txt_masp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(14, 14, 14)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel12)
                                            .addComponent(txt_gianhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(14, 14, 14)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel13)
                                            .addComponent(txt_giaban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btn_sua))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel14)
                                                    .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(17, 17, 17)
                                                .addComponent(jLabel15))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btn_xoa))))
                                    .addComponent(date_ngaynhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addComponent(jLabel16))
                            .addComponent(date_ngaysua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17)
                            .addComponent(date_ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_clear))))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1148, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 729, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_sanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sanphamMouseClicked
        // TODO add your handling code here:

        index = tbl_sanpham.getSelectedRow();

        //        _index = tbl_sanpham.getSelectedRow();
        ChiTietSanPhamDto ctsp = this.sPChiTietService.getAll().get(index);

        txt_masp.setText(ctsp.getMa());
        cb_tensp.setSelectedItem(sanPhamService.getTenById(ctsp.getIdSanPham()));
        cb_hang.setSelectedItem(hangService.getTenById(ctsp.getIdThuongHieu()));
        cb_chatlieu.setSelectedItem(chatLieuService.getTenById(ctsp.getIdChatLieu()));
        cb_mausac.setSelectedItem(mauSacService.getTenById(ctsp.getIdMauSac()));
        cb_kichco.setSelectedItem(kichCoService.getTenById(ctsp.getIdKichThuoc()));
        cb_danhmuc.setSelectedItem((danhMucService.getTenById(ctsp.getIdDanhMuc())));
        txt_gianhap.setText("" + ctsp.getGiaNhap());
        txt_giaban.setText("" + ctsp.getGiaBan());
        txt_soluong.setText("" + ctsp.getSoLuong());

        String ngayNhapString = tbl_sanpham.getValueAt(index, 11).toString();
        Date ngayNhap = null;

        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            ngayNhap = dateFormat.parse(ngayNhapString);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        String ngaySuaString = tbl_sanpham.getValueAt(index, 12).toString();
        Date ngaySua = null;

        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            ngaySua = dateFormat.parse(ngaySuaString);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        String ngayTaoString = tbl_sanpham.getValueAt(index, 13).toString();
        Date ngayTao = null;

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            ngayTao = dateFormat.parse(ngayTaoString);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        date_ngaynhap.setDate(ngayNhap);
        date_ngaysua.setDate(ngaySua);
        date_ngaytao.setDate(ngayTao);
        tbl_sanpham.setRowSelectionInterval(index, index);

        //
        //        txt_trangthai.setText(tbl_sanpham.getValueAt(_index, 14).toString());
    }//GEN-LAST:event_tbl_sanphamMouseClicked

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed

        
    }//GEN-LAST:event_BackActionPerformed

    private void cb_hangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_hangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_hangActionPerformed

    private void cb_mausacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_mausacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_mausacActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        addSanPham();
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
        updateSP();
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        deleteSP();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_them1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them1ActionPerformed
        // TODO add your handling code here:
        new SanPhamFrame().setVisible(true);
      
    }//GEN-LAST:event_btn_them1ActionPerformed

    private void btn_them2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them2ActionPerformed
        // TODO add your handling code here:
        new HangJPanel().setVisible(true);
 
    }//GEN-LAST:event_btn_them2ActionPerformed

    private void btn_them3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them3ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_them3ActionPerformed

    private void btn_them4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them4ActionPerformed
        // TODO add your handling code here:
        new DanhMucJPanel().setVisible(true);

    }//GEN-LAST:event_btn_them4ActionPerformed

    private void btn_them5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them5ActionPerformed
        // TODO add your handling code here:
        new MauSacFrame().setVisible(true);

    }//GEN-LAST:event_btn_them5ActionPerformed

    private void btn_them6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them6ActionPerformed
        // TODO add your handling code here:
        new KichThuocFrame().setVisible(true);
    }//GEN-LAST:event_btn_them6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Back;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_them1;
    private javax.swing.JButton btn_them2;
    private javax.swing.JButton btn_them3;
    private javax.swing.JButton btn_them4;
    private javax.swing.JButton btn_them5;
    private javax.swing.JButton btn_them6;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<String> cb_chatlieu;
    private javax.swing.JComboBox<String> cb_danhmuc;
    private javax.swing.JComboBox<String> cb_findhang;
    private javax.swing.JComboBox<String> cb_hang;
    private javax.swing.JComboBox<String> cb_kichco;
    private javax.swing.JComboBox<String> cb_mausac;
    private javax.swing.JComboBox<String> cb_tensp;
    private com.toedter.calendar.JDateChooser date_ngaynhap;
    private com.toedter.calendar.JDateChooser date_ngaysua;
    private com.toedter.calendar.JDateChooser date_ngaytao;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_sanpham;
    private javax.swing.JTextField txt_giaban;
    private javax.swing.JTextField txt_gianhap;
    private javax.swing.JTextField txt_masp;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_soluong;
    private javax.swing.JTextField txt_trangthai;
    // End of variables declaration//GEN-END:variables
}
