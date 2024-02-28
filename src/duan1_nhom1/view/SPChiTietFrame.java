/*1
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package duan1_nhom1.view;

import duan1_nhom1.dto.ChiTietSanPhamDto;
import duan1_nhom1.dto.SanPhamDto;
import duan1_nhom1.model.ChiTietSanPham;
import duan1_nhom1.model.Hang;
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
import java.util.ArrayList;
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
public class SPChiTietFrame extends javax.swing.JFrame {
    
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
    ChiTietSanPhamDto singleItem = new ChiTietSanPhamDto();
    ArrayList<ChiTietSanPhamDto> itemList = new ArrayList<>();
    int _index;
    private int index = -1;

    /**
     * Creates new form SPChiTietFrame
     */
    public SPChiTietFrame() {
        initComponents();
        loadHang();
        loadMauSac();
        loadKichThuoc();
        loadDanhMuc();
        loadSanPham();
        loadChatLieu();
        loadDanhMucSearch();
//        loadTableCTSP(sp);
        addTable(sPChiTietService.getAll());
//        loadDataChiTietSP(list);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//        loadDataQLSP(sPChiTietService.getAllSPHadDm());

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

//    private void loadTableCTSP(SanPhamDto sp) {
//        if (sp == null) {
//            return;
//        }
//        defaultTableModel = (DefaultTableModel) tbl_sanpham.getModel();
//        defaultTableModel.setRowCount(0);
//        int count = 1;
//
//        for (ChiTietSanPhamDto ctsp : this.sPChiTietService.getAllByIdSp(sp.getId())) {
//          
//            String trangThai;
//            if (ctsp.getSoLuong() > 0) {
//                trangThai = "Còn hàng";
//            } else {
//                trangThai = "Hết hàng";
//            }
//
//            Object[] rowData = {
//                count++,
//                ctsp.getMa(),
//                this.sanPhamService.getTenById(ctsp.getIdSanPham()),
//                 this.hangService.getTenById(ctsp.getIdThuongHieu()),
//                this.chatLieuService.getTenById(ctsp.getIdChatLieu()),
//                this.mauSacService.getTenById(ctsp.getIdMauSac()),
//                this.kichCoService.getTenById(ctsp.getIdKichThuoc()),
//                this.danhMucService.getTenById(ctsp.getIdDanhMuc()),
//                
//                
//                ctsp.getGiaNhap(),
//                ctsp.getGiaBan(),
//                ctsp.getSoLuong(),
//                ctsp.getNgayNhap(),
//                ctsp.getNgaySua(),
//                ctsp.getNgayTao(),
//                trangThai
//            };
//            System.out.println(ctsp.getIdThuongHieu());
//            System.out.println( this.hangService.getTenById(ctsp.getIdThuongHieu()));
//            System.out.println( chatLieuService.getTenById(ctsp.getIdChatLieu()));
//            System.out.println( this.kichCoService.getTenById(ctsp.getIdKichThuoc()));
//            defaultTableModel.addRow(rowData);
//
//        }
//    }
    public void addTable(List<ChiTietSanPhamDto> list) {
        defaultTableModel = (DefaultTableModel) tbl_sanpham.getModel();
        defaultTableModel.setRowCount(0);
        int count = 1;
        
        for (ChiTietSanPhamDto chiTietSanPham : list) {
            String trangThai;
            if (chiTietSanPham.getSoLuong() > 0) {
                trangThai = "Còn hàng";
            } else {
                trangThai = "Hết hàng";
            }
            
            defaultTableModel.addRow(new Object[]{
                count++,
                chiTietSanPham.getMa(),
                this.sanPhamService.getTenById(chiTietSanPham.getIdSanPham()),
                this.hangService.getTenById(chiTietSanPham.getIdThuongHieu()),
                this.chatLieuService.getTenById(chiTietSanPham.getIdChatLieu()),
                this.mauSacService.getTenById(chiTietSanPham.getIdMauSac()),
                this.kichCoService.getTenById(chiTietSanPham.getIdKichThuoc()),
                this.danhMucService.getTenById(chiTietSanPham.getIdDanhMuc()),
                chiTietSanPham.getGiaNhap(),
                chiTietSanPham.getGiaBan(),
                chiTietSanPham.getSoLuong(),
                chiTietSanPham.getNgayNhap(),
                chiTietSanPham.getNgaySua(),
                chiTietSanPham.getNgayTao(),
                trangThai
            });
        }
    }
    
    private void loadDataQLSP(List<ChiTietSanPham> listViewModel) {
        DefaultTableModel model = (DefaultTableModel) tbl_sanpham.getModel();
        model.setRowCount(0);
        int count = 1;
        for (int i = 0; i < listViewModel.size(); i++) {
            ChiTietSanPham chiTietSanPham = listViewModel.get(i);
            String trangThai;
            if (chiTietSanPham.getSoLuong() > 0) {
                trangThai = "Còn hàng";
            } else {
                trangThai = "Hết hàng";
            }
            model.addRow(new Object[]{
                count++,
                chiTietSanPham.getMa(),
                this.sanPhamService.getTenById(chiTietSanPham.getIdSanPham()),
                this.hangService.getTenById(chiTietSanPham.getIdThuongHieu()),
                this.chatLieuService.getTenById(chiTietSanPham.getIdChatLieu()),
                this.mauSacService.getTenById(chiTietSanPham.getIdMauSac()),
                this.kichCoService.getTenById(chiTietSanPham.getIdKichThuoc()),
                this.danhMucService.getTenById(chiTietSanPham.getIdDanhMuc()),
                chiTietSanPham.getGiaNhap(),
                chiTietSanPham.getGiaBan(),
                chiTietSanPham.getSoLuong(),
                chiTietSanPham.getNgayNhap(),
                chiTietSanPham.getNgaySua(),
                chiTietSanPham.getNgayTao(),
                trangThai
            
            });
        }
    }
    
    public void loadFindByMa(ChiTietSanPhamDto list) {
        defaultTableModel = (DefaultTableModel) tbl_sanpham.getModel();
        defaultTableModel.setRowCount(0);
        int count = 1;
        
        defaultTableModel.addRow(new Object[]{
            count++,
            list.getMa(),
            this.sanPhamService.getTenById(list.getIdSanPham().toString()),
            this.hangService.getTenById(list.getIdThuongHieu().toString()),
            this.chatLieuService.getTenById(list.getIdChatLieu().toString()),
            this.mauSacService.getTenById(list.getIdMauSac().toString()),
            this.kichCoService.getTenById(list.getIdKichThuoc().toString()),
            this.danhMucService.getTenById(list.getIdDanhMuc().toString()),
            list.getGiaNhap(),
            list.getGiaBan(),
            list.getSoLuong(),
            list.getNgayNhap(),
            list.getNgaySua(),
            list.getNgayTao(),
            list.getTrangThai()
        });
        
    }
    
    public void loadTable(ChiTietSanPhamDto sp) {
        
        int count = 1;
        
        if (sp == null) {
            return;
        }
        
        defaultTableModel = (DefaultTableModel) tbl_sanpham.getModel();
        defaultTableModel.setRowCount(0);
        for (ChiTietSanPhamDto chiTietSanPham : sPChiTietService.getAllByIdSp(sp.getId())) {
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
    
    public void loadDanhMucSearch() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cb_findhang.getModel();
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
        if (btn_conhang.isSelected()) {
            trangThai = true;
        } else if (btn_hethang.isSelected()) {
            trangThai = false;
        }
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
    
    private boolean checkDuplicateObject2(ChiTietSanPhamDto vModelCheck, int index) {
        
        int count = 0;
        List<ChiTietSanPhamDto> listViewModel = this.sPChiTietService.getAll();
        for (int i = 0; i < listViewModel.size(); i++) {
            if (i != index) {
                if (listViewModel.get(i).getIdChatLieu().equals(vModelCheck.getIdChatLieu())
                        && listViewModel.get(i).getIdDanhMuc().equals(vModelCheck.getIdDanhMuc())
                        && listViewModel.get(i).getIdKichThuoc().equals(vModelCheck.getIdKichThuoc())
                        && listViewModel.get(i).getIdMauSac().equals(vModelCheck.getIdMauSac())
                        && listViewModel.get(i).getIdSanPham().equals(vModelCheck.getIdSanPham())
                        && listViewModel.get(i).getIdThuongHieu().equals(vModelCheck.getIdThuongHieu())) {
                    count++;
                }
            }
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean checkDuplicateMaSP2(String maSP, int index) {
        int count = 0;
        for (int i = 0; i < this.sPChiTietService.getAll().size(); i++) {
            if (i != index) {
                if (maSP.equalsIgnoreCase(this.sPChiTietService.getAll().get(i).getMa())) {
                    count++;
                }
            }
        }
        if (count == 0) {
            return false;
        } else {
            return true;
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
        if (btn_conhang.isSelected()) {
            trangThai = true;
        } else if (btn_hethang.isSelected()) {
            trangThai = false;
        }
        ChiTietSanPhamDto ctsp = new ChiTietSanPhamDto("", maSP, idTenSP, idKichCo, idThuongHieu, idMauSac, idChatLieu, idDanhMuc, giaNhap, giaBan, soLuong, ngayTao, ngaySua, ngayNhap, trangThai);

//        sPChiTietService.insert(ctsp);
//        addTable(sPChiTietService.getAll());
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thêm không ?");
        if (confirm != JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "Sửa thất bại !");
            return;
        } else {
            if (this.checkDuplicateObject2(ctsp, index)) {
                if (!checkDuplicateMaSP2(maSP, index)) {
                    JOptionPane.showMessageDialog(this, this.sPChiTietService.insert(ctsp));
                    this.addTable(sPChiTietService.getAll());
                } else {
                    JOptionPane.showMessageDialog(this, "Mã sản phẩm đã tồn tại.");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Sản phẩm này đã tồn tại");
                return;
            }
        }
    }
    
    private void loadDataChiTietSP(List<ChiTietSanPham> list) {
        DefaultTableModel model = (DefaultTableModel) tbl_sanpham.getModel();
        model.setRowCount(0);
        int count = 1;
        for (ChiTietSanPham vModel : list) {
            model.addRow(new Object[]{
                count++,
                vModel.getMa(),
                this.sanPhamService.getTenById(vModel.getIdSanPham().toString()),
                this.hangService.getTenById(vModel.getIdThuongHieu().toString()),
                this.chatLieuService.getTenById(vModel.getIdChatLieu().toString()),
                this.mauSacService.getTenById(vModel.getIdMauSac().toString()),
                this.kichCoService.getTenById(vModel.getIdKichThuoc().toString()),
                this.danhMucService.getTenById(vModel.getIdDanhMuc().toString()),
                vModel.getGiaNhap(),
                vModel.getGiaBan(),
                vModel.getSoLuong(),
                vModel.getNgayNhap(),
                vModel.getNgaySua(),
                vModel.getNgayTao(),
                vModel.isTrangThai()
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel20 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cb_findhang = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sanpham = new javax.swing.JTable();
        Back = new javax.swing.JToggleButton();
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
        txt_masp = new javax.swing.JTextField();
        btn_them2 = new javax.swing.JButton();
        btn_them3 = new javax.swing.JButton();
        btn_them4 = new javax.swing.JButton();
        btn_them5 = new javax.swing.JButton();
        btn_them6 = new javax.swing.JButton();
        btn_conhang = new javax.swing.JRadioButton();
        btn_hethang = new javax.swing.JRadioButton();

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duan1_nhom1/Icon/edit_property_24px.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(203, 233, 162));

        jPanel3.setBackground(new java.awt.Color(203, 233, 162));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cb_findhang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All" }));
        cb_findhang.setToolTipText("");
        cb_findhang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_findhangItemStateChanged(evt);
            }
        });
        cb_findhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_findhangActionPerformed(evt);
            }
        });

        btn_search.setText("Tìm kiếm");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

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
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_search)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 500, Short.MAX_VALUE)
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
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search)
                    .addComponent(Back))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );

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

        buttonGroup1.add(btn_conhang);
        btn_conhang.setText("Còn hàng");

        buttonGroup1.add(btn_hethang);
        btn_hethang.setText("Hết hàng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_kichco, 0, 165, Short.MAX_VALUE)
                            .addComponent(cb_mausac, 0, 165, Short.MAX_VALUE)
                            .addComponent(cb_danhmuc, 0, 165, Short.MAX_VALUE)
                            .addComponent(cb_chatlieu, 0, 165, Short.MAX_VALUE)
                            .addComponent(cb_tensp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_hang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_them2)
                            .addComponent(btn_them3)
                            .addComponent(btn_them4)
                            .addComponent(btn_them5)
                            .addComponent(btn_them6)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_conhang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_hethang)))
                .addGap(76, 76, 76)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                            .addComponent(txt_soluong, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(txt_giaban, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(txt_gianhap)
                            .addComponent(date_ngaynhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(date_ngaysua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(date_ngaytao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 347, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_them)
                    .addComponent(btn_sua)
                    .addComponent(btn_xoa)
                    .addComponent(btn_clear))
                .addGap(49, 49, 49))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(jLabel3)
                                                            .addComponent(cb_tensp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(btn_conhang)
                            .addComponent(btn_hethang)))
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
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Chi tiết sản phẩm", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_hangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_hangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_hangActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
        updateSP();
    }//GEN-LAST:event_btn_suaActionPerformed

    private void cb_mausacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_mausacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_mausacActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        addSanPham();
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        deleteSP();
    }//GEN-LAST:event_btn_xoaActionPerformed

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
        
        boolean trangthai = ctsp.getTrangThai();
        if (trangthai == true) {
            btn_conhang.setSelected(true);
        } else {
            btn_hethang.setSelected(true);
        }

//
//        txt_trangthai.setText(tbl_sanpham.getValueAt(_index, 14).toString());

    }//GEN-LAST:event_tbl_sanphamMouseClicked

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void btn_them2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them2ActionPerformed
        new ChatLieuJFrame().setVisible(true);
    }//GEN-LAST:event_btn_them2ActionPerformed

    private void btn_them3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them3ActionPerformed
        // TODO add your handling code here:
        new DanhMucJFrame().setVisible(true);
    }//GEN-LAST:event_btn_them3ActionPerformed

    private void btn_them4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them4ActionPerformed
        // TODO add your handling code here:
        new HangJFrame().setVisible(true);
    }//GEN-LAST:event_btn_them4ActionPerformed

    private void btn_them5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them5ActionPerformed
        
        new MauSacFrame().setVisible(true);
    }//GEN-LAST:event_btn_them5ActionPerformed

    private void btn_them6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them6ActionPerformed
        // TODO add your handling code here:
        new KichThuocFrame().setVisible(true);
    }//GEN-LAST:event_btn_them6ActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        String im = txtTimKiem.getText();
        ChiTietSanPhamDto sp = sPChiTietService.findByMaCtLike(im);
        if (sp != null) {
            loadFindByMa(sp);
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm");
            txtTimKiem.setText("");
            addTable(sPChiTietService.getAll());
            return;
        }

    }//GEN-LAST:event_btn_searchActionPerformed

    private void cb_findhangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_findhangItemStateChanged

        if (cb_findhang.getSelectedItem().equals("All")) {
            addTable(sPChiTietService.getAllSPHadDm());
        }
        String dm = (String) cb_findhang.getSelectedItem();
        List<ChiTietSanPhamDto> lst = sPChiTietService.findByDm(dm);
        addTable(lst);
        
    }//GEN-LAST:event_cb_findhangItemStateChanged

    private void cb_findhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_findhangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_findhangActionPerformed
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KichThuocFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KichThuocFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KichThuocFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KichThuocFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SPChiTietFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Back;
    private javax.swing.JButton btn_clear;
    private javax.swing.JRadioButton btn_conhang;
    private javax.swing.JRadioButton btn_hethang;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_them2;
    private javax.swing.JButton btn_them3;
    private javax.swing.JButton btn_them4;
    private javax.swing.JButton btn_them5;
    private javax.swing.JButton btn_them6;
    private javax.swing.JButton btn_xoa;
    private javax.swing.ButtonGroup buttonGroup1;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_sanpham;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txt_giaban;
    private javax.swing.JTextField txt_gianhap;
    private javax.swing.JTextField txt_masp;
    private javax.swing.JTextField txt_soluong;
    // End of variables declaration//GEN-END:variables
}
