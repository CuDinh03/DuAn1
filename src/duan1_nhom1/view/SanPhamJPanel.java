/*1
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package duan1_nhom1.view;

import duan1_nhom1.model.ChiTietSanPham;
import duan1_nhom1.model.Hang;

import duan1_nhom1.model.KichThuoc;
import duan1_nhom1.model.MauSac;
import duan1_nhom1.service.ChatLieuService;
import duan1_nhom1.service.DanhMucService;
import duan1_nhom1.service.HangService;
import duan1_nhom1.service.IService;
import duan1_nhom1.service.KichCoService;
import duan1_nhom1.service.MauSacService;
import duan1_nhom1.service.SPChiTietService;
import duan1_nhom1.service.SanPhamService;
import duan1_nhom1.utils.Uhelper;
import duan1_nhom1.viewModel.QLSanPhamViewModel;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maccuacu
 */
public class SanPhamJPanel extends javax.swing.JPanel {

    private DefaultComboBoxModel defaultComboBoxModel;
    private DefaultTableModel defaultTableModel;
    private MauSacService mauSacService = new MauSacService();
    private HangService hangService = new HangService();
    private KichCoService kichCoService = new KichCoService();
    private SanPhamService sanPhamService = new SanPhamService();
    private IService iService = new SanPhamService();
    private SPChiTietService sPChiTietService = new SPChiTietService();
    private DanhMucService danhMucService = new DanhMucService();
    private ChatLieuService chatLieuService = new ChatLieuService();
    private int index = -1;
    private int _index1 = -1;
    List<KichThuoc> list = kichCoService.getAll();
    private KichThuoc kichThuoc = new KichThuoc();

    /**
     * Creates new form SanPhamJPanel
     */
    public SanPhamJPanel() {
        initComponents();
        loadHang();
        loadMauSac();
        loadKichThuoc();
        loadDanhMuc();
        loadSanPham();
        loadTableKT();
        loadTableMauSac();
        loadChatLieu();
        addTable(sPChiTietService.getAll());
    }
        public void loadTableMauSac() {

        defaultTableModel = (DefaultTableModel) tbl_mausac.getModel();
        defaultTableModel.setRowCount(0);
        int count = 1;
        for (MauSac mauSac : mauSacService.getAll() ) {
            String status;
            if (mauSac.isTrangThai()) {
                status = "Còn";
            }else {
                status = "Hết";
            }
             Object[] rowData = {
                 count++,
                mauSac.getMa(),
                mauSac.getTen(),
                mauSac.getMoTa(),
                mauSac.getNgaySua(),
                mauSac.getNgayTao(),
                
                 status
             };   
            defaultTableModel.addRow(rowData);

        }

    }

    private void clearForm() {
        txt_ma.setText("");
        txt_ten.setText("");
        txt_mota.setText("");
        clr_ngaysua.setDate(null);
        clr_ngaytao.setDate(null);
        txt_trangthai.setText("");
    }

    private MauSac getMauSac() {
        MauSac mauSac = new MauSac();
        mauSac.setMa(txt_ma.getText());
        mauSac.setTen(txt_ten.getText());
        mauSac.setMoTa(txt_mota.getText());

        Date ngayTao = clr_ngaytao.getDate();
        mauSac.setNgayTao(ngayTao);

        Date ngaySua = clr_ngaysua.getDate();
        mauSac.setNgaySua(ngaySua);
//        mauSac.isTrangThai();
        return mauSac;
    }

    public void addMauSac() {
        try {
            int check = JOptionPane.showConfirmDialog(this, "bạn có muốn thêm không");
            if (check != JOptionPane.YES_OPTION) {
                return;
            }
            MauSac ms = getMauSac();
            mauSacService.add(ms);
       
            JOptionPane.showMessageDialog(this, "thêm thành công");
            loadTableMauSac();
            clearForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "thêm thất bại");
        }

    }
    
       
    public void updateMauSac() {
        try {
            int check = JOptionPane.showConfirmDialog(this, "bạn có muốn update không");
            if (check != JOptionPane.YES_OPTION) {
                return;
            }
            MauSac ms = getMauSac();
            int row = tbl_mausac.getSelectedRow();
            String id = mauSacService.getAll().get(row).getId();
            mauSacService.update(ms, id);
            loadTableMauSac();
            JOptionPane.showMessageDialog(this, "Update thành công");
            
            clearForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Update thất bại");
        }

    }


    public void loadTableKT() {

        DefaultTableModel dfm = (DefaultTableModel) tbl_kichthuoc.getModel();

        dfm.setRowCount(0);

        for (KichThuoc kichThuoc : list) {
            Object[] row = new Object[]{
                kichThuoc.getMa(),
                kichThuoc.getTen(),
                kichThuoc.getMoTa(),
                kichThuoc.getNgaySua(),
                kichThuoc.getNgayTao(),
                kichThuoc.isTrangThai()
            };
            dfm.addRow(row);

        }

    }

    private void clearFormMs() {
        txt_ma.setText("");
        txt_ten.setText("");
        txt_mota.setText("");
        clr_ngaysua.setDate(null);
        clr_ngaytao.setDate(null);
    }

    private KichThuoc getData() {
        KichThuoc kichThuoc = new KichThuoc();
        kichThuoc.setMa(txt_ma.getText());
        kichThuoc.setTen(txt_ma.getText());
        kichThuoc.setMoTa(txt_ma.getText());

        Date ngayTao = clr_ngaytao.getDate();
        kichThuoc.setNgayTao(ngayTao);

        Date ngaySua = clr_ngaysua.getDate();
        kichThuoc.setNgaySua(ngaySua);

        return kichThuoc;
    }

    public void addSize() {
        try {
            int check = JOptionPane.showConfirmDialog(this, "bạn có muốn thêm không");
            if (check != JOptionPane.YES_OPTION) {
                return;
            }
            KichThuoc size = getData();
            kichCoService.add(size);
            list = kichCoService.getAll();
            loadTableKT();
            JOptionPane.showMessageDialog(this, "thêm thành công");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "thêm thất bại");
        }

    }

    public void xoa() {
        try {
            int check = JOptionPane.showConfirmDialog(this, "bạn có muốn xóa không");
            if (check != JOptionPane.YES_OPTION) {
                return;
            }

            loadTableKT();
            JOptionPane.showMessageDialog(this, "xóa thành công");
            clearForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "xóa thất bại");
        }
    }

    public void addTable(List<ChiTietSanPham> list) {
        defaultTableModel = (DefaultTableModel) tbl_sanpham1.getModel();
        defaultTableModel.setRowCount(0);
        int count = 1;
        for (ChiTietSanPham chiTietSanPham : list) {
             Object[] rowData = {
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
                chiTietSanPham.isTrangThai()
            };
                        defaultTableModel.addRow(rowData);

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
        DefaultComboBoxModel model = (DefaultComboBoxModel) cb_mausac1.getModel();
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

        UUID id = this.sPChiTietService.getAll().get(index).getId();
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

        UUID uuidIdTenSP = UUID.fromString(idTenSP);
        UUID uuidIdThuongHieu = UUID.fromString(idThuongHieu);
        UUID uuidIdMauSac = UUID.fromString(idMauSac);
        UUID uuidIdChatLieu = UUID.fromString(idChatLieu);
        UUID uuidIdKichCo = UUID.fromString(idKichCo);
        UUID uuidIdDanhMuc = UUID.fromString(idDanhMuc);

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
        ChiTietSanPham ctsp = new ChiTietSanPham(id, maSP, uuidIdTenSP, uuidIdKichCo, uuidIdThuongHieu, uuidIdMauSac, uuidIdChatLieu, uuidIdDanhMuc, giaNhap, giaBan, soLuong, ngayTao, ngaySua, ngayNhap, trangThai);
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
            UUID id = sPChiTietService.getAll().get(row).getId();
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

        UUID uuidIdTenSP = UUID.fromString(idTenSP);
        UUID uuidIdThuongHieu = UUID.fromString(idThuongHieu);
        UUID uuidIdMauSac = UUID.fromString(idMauSac);
        UUID uuidIdChatLieu = UUID.fromString(idChatLieu);
        UUID uuidIdKichCo = UUID.fromString(idKichCo);
        UUID uuidIdDanhMuc = UUID.fromString(idDanhMuc);

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
        QLSanPhamViewModel ctsp = new QLSanPhamViewModel(maSP, uuidIdTenSP, uuidIdKichCo, uuidIdThuongHieu, uuidIdMauSac, uuidIdChatLieu, uuidIdDanhMuc, giaNhap, giaBan, soLuong, ngayTao, ngaySua, ngayNhap, trangThai);

        sPChiTietService.insert(ctsp);
        addTable(sPChiTietService.getAll());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sanpham = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cb_thuonghieu = new javax.swing.JComboBox<>();
        cb_kichthuoc = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cb_mausac = new javax.swing.JComboBox<>();
        jButton8 = new javax.swing.JButton();
        jComboBox4 = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btn_search1 = new javax.swing.JButton();
        txt_search1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_kichthuoc = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_ma = new javax.swing.JTextField();
        txt_ten = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        clr_ngaytao = new com.toedter.calendar.JDateChooser();
        jLabel24 = new javax.swing.JLabel();
        clr_ngaysua = new com.toedter.calendar.JDateChooser();
        btn_them1 = new javax.swing.JButton();
        btn_sua1 = new javax.swing.JButton();
        btn_xoa1 = new javax.swing.JButton();
        btn_clear1 = new javax.swing.JButton();
        txt_mota = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        btn_search2 = new javax.swing.JButton();
        txt_search2 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_danhmuc = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        txt_ma1 = new javax.swing.JTextField();
        txt_danhmuc = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        btn_them2 = new javax.swing.JButton();
        btn_sua2 = new javax.swing.JButton();
        btn_xoa2 = new javax.swing.JButton();
        btn_clear2 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jPanel11 = new javax.swing.JPanel();
        btn_search3 = new javax.swing.JButton();
        txt_search3 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_hang = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        txt_ma2 = new javax.swing.JTextField();
        txt_danhmuc1 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        btn_them3 = new javax.swing.JButton();
        btn_sua3 = new javax.swing.JButton();
        btn_xoa3 = new javax.swing.JButton();
        btn_clear3 = new javax.swing.JButton();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jPanel12 = new javax.swing.JPanel();
        btn_search4 = new javax.swing.JButton();
        txt_search4 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_mausac = new javax.swing.JTable();
        jLabel34 = new javax.swing.JLabel();
        txt_ma3 = new javax.swing.JTextField();
        txt_ten1 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        clr_ngaytao1 = new com.toedter.calendar.JDateChooser();
        jLabel37 = new javax.swing.JLabel();
        clr_ngaysua1 = new com.toedter.calendar.JDateChooser();
        btn_them4 = new javax.swing.JButton();
        btn_sua4 = new javax.swing.JButton();
        btn_xoa4 = new javax.swing.JButton();
        btn_clear4 = new javax.swing.JButton();
        txt_mota1 = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txt_trangthai1 = new javax.swing.JTextField();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(203, 233, 162));

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tbl_sanpham.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        tbl_sanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã ", "Tên", "Kich cỡ", "Thương hiệu", "Màu sắc"
            }
        ));
        jScrollPane1.setViewportView(tbl_sanpham);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(203, 233, 162));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel2.setText("Mã sản phẩm:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel3.setText("Tên sản phẩm:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel4.setText("Thương hiệu:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel5.setText("Kích cỡ:");

        cb_thuonghieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_thuonghieuActionPerformed(evt);
            }
        });

        cb_kichthuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_kichthuocActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel6.setText("Màu sắc:");

        jButton8.setText("Sản phẩm chi tiết");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(127, 127, 127)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_kichthuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_thuonghieu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cb_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cb_kichthuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cb_thuonghieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cb_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jButton8)
                .addGap(29, 29, 29))
        );

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton9.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(266, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jTabbedPane1.addTab("Sản phẩm", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1056, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Cập nhật", jPanel4);

        jPanel9.setBackground(new java.awt.Color(203, 233, 162));

        btn_search1.setText("Tìm Kiếm");

        tbl_kichthuoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên", "Mô tả", "Ngày tạo", "Ngày sửa", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_kichthuoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_kichthuocMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_kichthuocMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_kichthuoc);

        jLabel1.setText("Mã size");

        jLabel22.setText("Size");

        jLabel23.setText("Ngày tạo:");

        jLabel24.setText("Ngày sửa");

        btn_them1.setText("Thêm");
        btn_them1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_them1ActionPerformed(evt);
            }
        });

        btn_sua1.setText("Sửa");

        btn_xoa1.setText("Xóa");
        btn_xoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoa1ActionPerformed(evt);
            }
        });

        btn_clear1.setText("Clear");
        btn_clear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clear1ActionPerformed(evt);
            }
        });

        jLabel25.setText("Mô tả:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_search1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_search1)
                .addGap(57, 57, 57))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1044, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_mota, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clr_ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clr_ngaysua, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_them1)
                            .addComponent(btn_xoa1)
                            .addComponent(btn_sua1)
                            .addComponent(btn_clear1))
                        .addGap(59, 59, 59))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_search1)
                    .addComponent(txt_search1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoa1))
                .addGap(26, 26, 26)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_them1))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btn_sua1))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_mota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clr_ngaysua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(clr_ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(btn_clear1)
                        .addGap(40, 40, 40))))
        );

        jTabbedPane1.addTab("Kich thuoc", jPanel9);

        jPanel10.setBackground(new java.awt.Color(203, 233, 162));

        btn_search2.setText("Tìm Kiếm");

        tbl_danhmuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên", "Mô tả", "Ngày tạo", "Ngày sửa", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_danhmuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_danhmucMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_danhmuc);

        jLabel26.setText("Mã danh mục:");

        jLabel27.setText("Tên danh Mục:");

        jLabel28.setText("Ngày tạo:");

        jLabel29.setText("Ngày sửa");

        btn_them2.setText("Thêm");
        btn_them2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_them2ActionPerformed(evt);
            }
        });

        btn_sua2.setText("Sửa");

        btn_xoa2.setText("Xóa");

        btn_clear2.setText("Clear");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_search2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_search2)
                .addGap(57, 57, 57))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1044, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel29)
                                        .addGap(43, 43, 43))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel27)
                                            .addComponent(jLabel28))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_danhmuc, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(18, 18, 18)
                                .addComponent(txt_ma1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_them2)
                            .addComponent(btn_clear2)
                            .addComponent(btn_sua2)
                            .addComponent(btn_xoa2))
                        .addGap(88, 88, 88))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_search2)
                    .addComponent(txt_search2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txt_ma1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_them2))
                .addGap(26, 26, 26)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txt_danhmuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sua2))
                .addGap(26, 26, 26)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(btn_xoa2)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(btn_clear2))
                .addContainerGap(219, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh mục", jPanel10);

        jPanel11.setBackground(new java.awt.Color(203, 233, 162));

        btn_search3.setText("Tìm Kiếm");

        tbl_hang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên", "Mô tả", "Ngày tạo", "Ngày sửa", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_hang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_hangMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_hang);

        jLabel30.setText("Mã danh mục:");

        jLabel31.setText("Tên danh Mục:");

        jLabel32.setText("Ngày tạo:");

        jLabel33.setText("Ngày sửa");

        btn_them3.setText("Thêm");

        btn_sua3.setText("Sửa");

        btn_xoa3.setText("Xóa");

        btn_clear3.setText("Clear");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_search3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_search3)
                .addGap(57, 57, 57))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1044, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel33)
                                        .addGap(43, 43, 43))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel31)
                                            .addComponent(jLabel32))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_danhmuc1, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                    .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDateChooser4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addGap(18, 18, 18)
                                .addComponent(txt_ma2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_them3)
                            .addComponent(btn_clear3)
                            .addComponent(btn_sua3)
                            .addComponent(btn_xoa3))
                        .addGap(88, 88, 88))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_search3)
                    .addComponent(txt_search3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txt_ma2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_them3))
                .addGap(26, 26, 26)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txt_danhmuc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sua3))
                .addGap(26, 26, 26)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(btn_xoa3)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33)
                    .addComponent(btn_clear3))
                .addContainerGap(219, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Hãng", jPanel11);

        jPanel12.setBackground(new java.awt.Color(203, 233, 162));

        btn_search4.setText("Tìm Kiếm");

        tbl_mausac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã", "Tên", "Mô tả", "Ngày tạo", "Ngày sửa", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_mausac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_mausacMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_mausacMousePressed(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_mausac);

        jLabel34.setText("Mã màu sắc:");

        jLabel35.setText("Tên màu sắc:");

        jLabel36.setText("Ngày tạo:");

        jLabel37.setText("Ngày sửa");

        btn_them4.setText("Thêm");
        btn_them4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_them4ActionPerformed(evt);
            }
        });

        btn_sua4.setText("Sửa");
        btn_sua4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sua4ActionPerformed(evt);
            }
        });

        btn_xoa4.setText("Xóa");
        btn_xoa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoa4ActionPerformed(evt);
            }
        });

        btn_clear4.setText("Clear");
        btn_clear4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clear4ActionPerformed(evt);
            }
        });

        jLabel38.setText("Mô tả:");

        jLabel39.setText("Trạng thái:");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_search4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_search4)
                .addGap(57, 57, 57))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1044, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addGap(18, 18, 18)
                                .addComponent(txt_ten1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addComponent(jLabel39)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_trangthai1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addComponent(jLabel38)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_mota1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                    .addComponent(jLabel37)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(clr_ngaytao1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addComponent(jLabel36)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(clr_ngaysua1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                    .addComponent(jLabel34)
                                    .addGap(18, 18, 18)
                                    .addComponent(txt_ma3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_them4)
                            .addComponent(btn_clear4)
                            .addComponent(btn_sua4)
                            .addComponent(btn_xoa4))
                        .addGap(88, 88, 88))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_search4)
                    .addComponent(txt_search4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txt_ma3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(txt_ten1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_them4))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(txt_mota1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoa4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(txt_trangthai1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clr_ngaysua1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(clr_ngaytao1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(btn_clear4)
                        .addGap(18, 18, 18)
                        .addComponent(btn_sua4)))
                .addGap(32, 32, 32))
        );

        jTabbedPane1.addTab("Màu sắc", jPanel12);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cb_thuonghieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_thuonghieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_thuonghieuActionPerformed

    private void cb_kichthuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_kichthuocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_kichthuocActionPerformed

    private void tbl_kichthuocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_kichthuocMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_kichthuocMouseClicked

    private void tbl_kichthuocMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_kichthuocMousePressed

    }//GEN-LAST:event_tbl_kichthuocMousePressed

    private void btn_them1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them1ActionPerformed
        // TODO add your handling code here:
        addSize();
    }//GEN-LAST:event_btn_them1ActionPerformed

    private void btn_xoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoa1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_xoa1ActionPerformed

    private void btn_clear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clear1ActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btn_clear1ActionPerformed

    private void tbl_danhmucMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_danhmucMousePressed

    }//GEN-LAST:event_tbl_danhmucMousePressed

    private void tbl_hangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_hangMousePressed

    }//GEN-LAST:event_tbl_hangMousePressed

    private void btn_them2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them2ActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_btn_them2ActionPerformed

    private void tbl_mausacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_mausacMouseClicked
        // TODO add your handling code here:
        _index1 = tbl_mausac.getSelectedRow();
        txt_ma.setText(tbl_mausac.getValueAt(_index1, 1).toString());
        txt_ten.setText(tbl_mausac.getValueAt(_index1, 2).toString());
        txt_mota.setText(tbl_mausac.getValueAt(_index1, 3).toString());
        String ngayTaoString = tbl_mausac.getValueAt(_index1, 4).toString();
        Date ngayTao = null;

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            ngayTao = dateFormat.parse(ngayTaoString);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        String ngaySuaString = tbl_mausac.getValueAt(_index1, 5).toString();
        Date ngaySua = null;

        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            ngaySua = dateFormat.parse(ngaySuaString);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        clr_ngaytao.setDate(ngayTao);
        clr_ngaysua.setDate(ngaySua);

        txt_trangthai.setText(tbl_mausac.getValueAt(_index1, 6).toString());
    }//GEN-LAST:event_tbl_mausacMouseClicked

    private void tbl_mausacMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_mausacMousePressed

    }//GEN-LAST:event_tbl_mausacMousePressed

    private void btn_them4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them4ActionPerformed
        // TODO add your handling code here:
        addMauSac();
        loadTableMauSac();
    }//GEN-LAST:event_btn_them4ActionPerformed

    private void btn_sua4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sua4ActionPerformed
        // TODO add your handling code here:
        updateMauSac();
    }//GEN-LAST:event_btn_sua4ActionPerformed

    private void btn_xoa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoa4ActionPerformed
        // TODO add your handling code here:
        try {
            int check = JOptionPane.showConfirmDialog(this, "bạn có muốn xóa không");
            if (check != JOptionPane.YES_OPTION) {
                return;
            }
            int row = tbl_mausac.getSelectedRow();
            String id = mauSacService.getAll().get(row).getId();
            mauSacService.delete(id);

            JOptionPane.showMessageDialog(this, "xóa thành công");
            loadTableMauSac();
            clearForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "xóa thất bại ");
        }
    }//GEN-LAST:event_btn_xoa4ActionPerformed

    private void btn_clear4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clear4ActionPerformed
        // TODO add your handling code here:
        clearFormMs();
    }//GEN-LAST:event_btn_clear4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear1;
    private javax.swing.JButton btn_clear2;
    private javax.swing.JButton btn_clear3;
    private javax.swing.JButton btn_clear4;
    private javax.swing.JButton btn_search1;
    private javax.swing.JButton btn_search2;
    private javax.swing.JButton btn_search3;
    private javax.swing.JButton btn_search4;
    private javax.swing.JButton btn_sua1;
    private javax.swing.JButton btn_sua2;
    private javax.swing.JButton btn_sua3;
    private javax.swing.JButton btn_sua4;
    private javax.swing.JButton btn_them1;
    private javax.swing.JButton btn_them2;
    private javax.swing.JButton btn_them3;
    private javax.swing.JButton btn_them4;
    private javax.swing.JButton btn_xoa1;
    private javax.swing.JButton btn_xoa2;
    private javax.swing.JButton btn_xoa3;
    private javax.swing.JButton btn_xoa4;
    private javax.swing.JComboBox<MauSac> cb_kichthuoc;
    private javax.swing.JComboBox<MauSac> cb_mausac;
    private javax.swing.JComboBox<Hang> cb_thuonghieu;
    private com.toedter.calendar.JDateChooser clr_ngaysua;
    private com.toedter.calendar.JDateChooser clr_ngaysua1;
    private com.toedter.calendar.JDateChooser clr_ngaytao;
    private com.toedter.calendar.JDateChooser clr_ngaytao1;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable tbl_danhmuc;
    private javax.swing.JTable tbl_hang;
    private javax.swing.JTable tbl_kichthuoc;
    private javax.swing.JTable tbl_mausac;
    private javax.swing.JTable tbl_sanpham;
    private javax.swing.JTextField txt_danhmuc;
    private javax.swing.JTextField txt_danhmuc1;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_ma1;
    private javax.swing.JTextField txt_ma2;
    private javax.swing.JTextField txt_ma3;
    private javax.swing.JTextField txt_mota;
    private javax.swing.JTextField txt_mota1;
    private javax.swing.JTextField txt_search1;
    private javax.swing.JTextField txt_search2;
    private javax.swing.JTextField txt_search3;
    private javax.swing.JTextField txt_search4;
    private javax.swing.JTextField txt_ten;
    private javax.swing.JTextField txt_ten1;
    private javax.swing.JTextField txt_trangthai1;
    // End of variables declaration//GEN-END:variables
}
