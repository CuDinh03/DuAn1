<<<<<<< HEAD
/*1
=======
/*
>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package duan1_nhom1.view;

<<<<<<< HEAD
import duan1_nhom1.dto.HoaDonDto;
import duan1_nhom1.model.HoaDon;
import duan1_nhom1.model.Khach;
import duan1_nhom1.repository.HoaDonRepository;
import duan1_nhom1.service.HoaDonService;
import duan1_nhom1.service.KhachService;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

=======
>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)
/**
 *
 * @author WEB
 */
public class ViewKhachHang extends javax.swing.JFrame {

<<<<<<< HEAD
    private DefaultTableModel tableModel = new DefaultTableModel();
    private KhachService khachService = new KhachService();
    private List<Khach> listKH = new ArrayList<>();
    private List<HoaDon> listHD = new ArrayList<>();
    private HoaDonRepository hoaDon = new HoaDonRepository();
    private DefaultComboBoxModel cbbBox = new DefaultComboBoxModel();

    public ViewKhachHang() {
        initComponents();
        setLocationRelativeTo(null);
        listHD = hoaDon.getAllHoaDon();
        showDataKhach();
        showDataHoaDon();

    }

    public void showDataKhach() {
        tableModel = (DefaultTableModel) tblKhachHang.getModel();
        tableModel.setRowCount(0);
        listKH = khachService.getAll();
        for (Khach khachHang : listKH) {
            tableModel.addRow(new Object[]{
                khachHang.getMaKhachHang(),
                khachHang.getTenKhachHang(),
                khachHang.getSdt(),
                khachHang.getNgayTao(),
                khachHang.getNgaySua(),
                khachHang.getTrangThai() ? "Hoạt động" : "không hoạt động "
            });
        }
    }

    public void showDataKhach2() {
        tableModel = (DefaultTableModel) tblKhachHang.getModel();
        tableModel.setRowCount(0);
        for (Khach khachHang : listKH) {
            tableModel.addRow(new Object[]{
                khachHang.getMaKhachHang(),
                khachHang.getTenKhachHang(),
                khachHang.getSdt(),
                khachHang.getNgayTao(),
                khachHang.getNgaySua(),
                khachHang.getTrangThai() ? "Hoạt động" : "không hoạt động "
            });
        }
    }

    public void showDataHoaDon() {
        tableModel = (DefaultTableModel) tblDanhSachMua.getModel();
        tableModel.setRowCount(0);
        for (HoaDon hoaDon : listHD) {
            tableModel.addRow(new Object[]{
                hoaDon.getMa(),
                hoaDon.getNgayMua(),
                hoaDon.getTongTien(),
                hoaDon.getNgayTao(),
                hoaDon.getNgaySua(),
                hoaDon.getTrangThai() ? "Hoạt động" : "không hoạt động "
            });
        }
    }

    private Khach getDataKhach() {
        Khach khach = new Khach();
        khach.setMaKhachHang(txtMa.getText());
        khach.setTenKhachHang(txtTen.getText());
        khach.setSdt(txtSdt.getText());
        khach.setNgayTao(Date.valueOf(txtNgaytao.getText()));
        khach.setNgaySua(Date.valueOf(txtNgaysua.getText()));
        khach.setTrangThai(rioHoatdong.isSelected());
        return khach;
    }

    private void showDetaiKhach(int index) {
        Khach khach = listKH.get(index);
        txtMa.setText(khach.getMaKhachHang());
        txtTen.setText(khach.getTenKhachHang());
        txtSdt.setText(khach.getSdt());
        txtNgaytao.setText(khach.getNgayTao().toString());
        txtNgaysua.setText(khach.getNgaySua().toString());
        boolean trangthai = khach.getTrangThai();
        if (trangthai == true) {
            rioHoatdong.setSelected(true);
        } else {
            riodunghoatdong.setSelected(true);
        }
    }

    private void clearFormKhach() {
        txtMa.setText("");
        txtTen.setText("");
        txtSdt.setText("");
        txtNgaytao.setText("");
        txtNgaysua.setText("");
        txtTimKiem.setText("");
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();

    }

    public void addKhach() {
        try {
            int check = JOptionPane.showConfirmDialog(this, "bạn có muốn thêm không");
            if (check != JOptionPane.YES_OPTION) {
                return;
            }
            Khach nv = getDataKhach();
            khachService.add(nv);
            listKH = khachService.getAll();
            showDataKhach();
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            clearFormKhach();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }

    }

    public void updateKhach() {
        try {
            int check = JOptionPane.showConfirmDialog(this, "bạn có muốn update không");
            if (check != JOptionPane.YES_OPTION) {
                return;
            }
            Khach nv = getDataKhach();
            int row = tblKhachHang.getSelectedRow();
            String id = listKH.get(row).getId();
            khachService.update(nv, id);
            showDataKhach();
            JOptionPane.showMessageDialog(this, "Update thành công");
            clearFormKhach();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Update thất bại");
        }

    }

    public void xoaKhach() {
        try {
            int check = JOptionPane.showConfirmDialog(this, "bạn có muốn xóa không");
            if (check != JOptionPane.YES_OPTION) {
                return;
            }
            int row = tblKhachHang.getSelectedRow();
            String id = listKH.get(row).getId();
            khachService.delete(id);
            showDataKhach();
            JOptionPane.showMessageDialog(this, "xóa thành công");
            clearFormKhach();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "xóa thất bại ");
        }
    }

    public void searchKhach() {
        try {
            String ma = txtTimKiem.getText();
            String ten = txtTimKiem.getText();
            String sdt = txtTimKiem.getText();
            if (ma.trim().isEmpty()) {
                ma = null;
            }
            if (ten.trim().isEmpty()) {
                ten = null;
            }
            if (sdt.trim().isEmpty()) {
                sdt = null;
            }
            listKH = khachService.timKiem(ma, ten, sdt);
            showDataKhach2();

//            listHoaDon = hoaDonService.searhListNhanVien(khach);
//            showDataHoaDon2();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void locKH() {
        Boolean trangThai = null;
        boolean checkkh = hoatDong.isSelected();
        if (checkkh == true) {
            trangThai = true;
        } else {
            trangThai = false;
        }

        listKH = khachService.locKhach(trangThai);
        showDataKhach2();

    }

    public void searchKhachTheoHoaDon() {
        try {
            String maKhach = txtTimKiemTheoHoaDon.getText();
            if (maKhach.trim().isEmpty()) {
                maKhach = null;
            }

            listHD = hoaDon.timKhachTheoHD(maKhach);
            showDataHoaDon();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
=======
    /**
     * Creates new form ViewKhachHang
     */
    public ViewKhachHang() {
        initComponents();
>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

<<<<<<< HEAD
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
=======
>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)
        ViewKhachHang = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblDanhSachMua = new javax.swing.JTable();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
<<<<<<< HEAD
        tbntim = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtTimKiemTheoHoaDon = new javax.swing.JTextField();
=======
        jButton2 = new javax.swing.JButton();
>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)
        jPanel13 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
<<<<<<< HEAD
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txtNgaytao = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txtNgaysua = new javax.swing.JTextField();
        rioHoatdong = new javax.swing.JRadioButton();
        riodunghoatdong = new javax.swing.JRadioButton();
        jPanel20 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        btnLocKhach = new javax.swing.JButton();
        btnNewKH = new javax.swing.JButton();
        hoatDong = new javax.swing.JRadioButton();
        khongHoatDong = new javax.swing.JRadioButton();
        btnAdd = new javax.swing.JButton();
        btnUpdateKH = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
=======
        jLabel34 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        txtIDKH = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtSDT1 = new javax.swing.JTextField();
        txtDiaChi1 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txtDiaChi2 = new javax.swing.JTextField();
        txtDiaChi3 = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        cboLocLoaiKH = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        btnNewKH = new javax.swing.JButton();
        btnDeleteKH = new javax.swing.JButton();
        btnUpdateKH = new javax.swing.JButton();
        btnDeleteKH1 = new javax.swing.JButton();
>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ViewKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        ViewKhachHang.setForeground(new java.awt.Color(203, 233, 191));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel29.setText("Quản lý khách hàng");

        jPanel9.setBackground(new java.awt.Color(204, 255, 153));
        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblDanhSachMua.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
<<<<<<< HEAD
                "Mã hóa đơn", "Ngày mua", "Tổng tiền", "Trạng thái"
=======
                "Mã hóa đơn", "Mã khách hàng", "Ngày mua", "Tổng tiền"
>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)
            }
        ));
        tblDanhSachMua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachMuaMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tblDanhSachMua);

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
<<<<<<< HEAD
                "Mã khách hàng ", "Tên khách hàng ", "Số điện thoại ", "Ngày tạo ", "Ngày sửa", "Trạng thái "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
=======
                "ID", "Mã khách hàng ", "Tên khách hàng ", "Địa Chỉ", "Số điện thoại ", "Ngày tạo ", "Ngày sửa", "Trạng thái "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tblKhachHang);

        jLabel30.setText("Thông tin khách hàng");

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel31.setText("Danh sách hóa đơn đã mua");

<<<<<<< HEAD
        tbntim.setText("Find");
        tbntim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbntimActionPerformed(evt);
            }
        });

        jLabel2.setText("Mã Khách Hàng ");

        jButton1.setText("Tìm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
=======
        jButton2.setText("Find");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane12))
                        .addContainerGap())
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
<<<<<<< HEAD
                        .addComponent(tbntim)
                        .addGap(18, 18, 18))))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel2)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiemTheoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addComponent(jButton1)
=======
                        .addComponent(jButton2)
                        .addGap(18, 18, 18))))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
<<<<<<< HEAD
                    .addComponent(tbntim))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel31)
                .addGap(8, 8, 8)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1)
                    .addComponent(txtTimKiemTheoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
=======
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(204, 255, 153));
        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());

<<<<<<< HEAD
        jLabel32.setText("THÊM KHÁCH HÀNG MỚI");

        jLabel33.setText("Mã khách hàng ");

=======
        jLabel32.setText("Chi tiết");

        jLabel33.setText("Mã khách hàng ");

        jLabel34.setText("Địa chỉ ");

>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)
        jLabel36.setText("Số  điện thoại ");

        jLabel37.setText("Ngày tạo ");

        jLabel38.setText(" Trạng thái ");

<<<<<<< HEAD
=======
        jLabel39.setText("ID");

>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)
        jLabel1.setText("Tên khách hàng ");

        jLabel43.setText("Ngày sửa ");

<<<<<<< HEAD
        buttonGroup1.add(rioHoatdong);
        rioHoatdong.setText("Hoạt động");

        buttonGroup1.add(riodunghoatdong);
        riodunghoatdong.setText("Không hoạt động");

=======
>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)
        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< HEAD
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(rioHoatdong)
                                .addGap(31, 31, 31)
                                .addComponent(riodunghoatdong))
                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMa)
                                .addComponent(txtTen, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                .addComponent(txtSdt)
                                .addComponent(txtNgaytao)
                                .addComponent(txtNgaysua)))))
=======
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTen)
                            .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                            .addComponent(txtIDKH)
                            .addComponent(txtSDT1)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel38))
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiaChi3)
                            .addComponent(txtDiaChi1)
                            .addComponent(txtDiaChi2)
                            .addComponent(txtDiaChi))))
                .addGap(108, 108, 108))
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
<<<<<<< HEAD
                .addGap(22, 22, 22)
                .addComponent(jLabel32)
                .addGap(37, 37, 37)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(txtNgaysua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(rioHoatdong)
                            .addComponent(riodunghoatdong))
                        .addGap(57, 57, 57))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(txtNgaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
=======
                .addGap(13, 13, 13)
                .addComponent(jLabel32)
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(txtIDKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(txtSDT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(txtDiaChi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel43)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel38)
                        .addGap(60, 60, 60))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(txtDiaChi3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDiaChi2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel20.setBackground(new java.awt.Color(204, 255, 153));
        jPanel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel20.setForeground(new java.awt.Color(203, 233, 191));

        jLabel40.setText("Bộ lọc");

        jLabel41.setText("Trạng thái ");

<<<<<<< HEAD
        btnLocKhach.setText("Lọc");
        btnLocKhach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocKhachActionPerformed(evt);
=======
        cboLocLoaiKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "VIP", "Thường" }));

        jButton1.setText("Lọc");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)
            }
        });

        btnNewKH.setText("reset");
        btnNewKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewKHActionPerformed(evt);
            }
        });

<<<<<<< HEAD
        buttonGroup2.add(hoatDong);
        hoatDong.setText("Hoạt động");

        buttonGroup2.add(khongHoatDong);
        khongHoatDong.setText("Không hoạt động ");

=======
>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)
        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< HEAD
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hoatDong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(khongHoatDong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLocKhach)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNewKH, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(jPanel20Layout.createSequentialGroup()
=======
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
<<<<<<< HEAD
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
=======
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(cboLocLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jButton1)
                                .addGap(26, 26, 26)
                                .addComponent(btnNewKH, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(58, Short.MAX_VALUE))
>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
<<<<<<< HEAD
                    .addComponent(btnLocKhach)
                    .addComponent(btnNewKH)
                    .addComponent(hoatDong)
                    .addComponent(khongHoatDong))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        btnAdd.setBackground(new java.awt.Color(204, 255, 102));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
=======
                    .addComponent(cboLocLoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(btnNewKH))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        btnDeleteKH.setBackground(new java.awt.Color(204, 255, 102));
        btnDeleteKH.setText("Add");
        btnDeleteKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteKHActionPerformed(evt);
>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)
            }
        });

        btnUpdateKH.setBackground(new java.awt.Color(204, 255, 102));
        btnUpdateKH.setText("Update");
        btnUpdateKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateKHActionPerformed(evt);
            }
        });

<<<<<<< HEAD
        btnDelete.setBackground(new java.awt.Color(204, 255, 102));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
=======
        btnDeleteKH1.setBackground(new java.awt.Color(204, 255, 102));
        btnDeleteKH1.setText("Delete");
        btnDeleteKH1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteKH1ActionPerformed(evt);
>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
<<<<<<< HEAD
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnUpdateKH, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
=======
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(btnDeleteKH, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnUpdateKH, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnDeleteKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)))
>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
<<<<<<< HEAD
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateKH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
=======
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateKH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteKH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ViewKhachHangLayout = new javax.swing.GroupLayout(ViewKhachHang);
        ViewKhachHang.setLayout(ViewKhachHangLayout);
        ViewKhachHangLayout.setHorizontalGroup(
            ViewKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(ViewKhachHangLayout.createSequentialGroup()
                .addGap(316, 316, 316)
                .addComponent(jLabel29)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        ViewKhachHangLayout.setVerticalGroup(
            ViewKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ViewKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
<<<<<<< HEAD
            .addGroup(layout.createSequentialGroup()
                .addComponent(ViewKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(ViewKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
=======
            .addGap(0, 1061, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(ViewKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 759, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ViewKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblDanhSachMuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachMuaMouseClicked
        // TODO add your handling code here:
        //         int row = tblKhachHang.getSelectedRow();
        //
        //        String maKH = tblKhachHang.getValueAt(row, 0).toString();
        //        showDatals(maKH);
    }//GEN-LAST:event_tblDanhSachMuaMouseClicked

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        // TODO add your handling code here:
        int row = tblKhachHang.getSelectedRow();
<<<<<<< HEAD
        showDetaiKhach(row);
//                listHD = sevice.DanhSachMuaHang(list.get(row).getId());
//                showHoaDonKhachHangMua();
=======
        //        showViTriKhachHang(row);
        //        listHD = sevice.DanhSachMuaHang(list.get(row).getId());
        //        showHoaDonKhachHangMua();
>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        //        // TODO add your handling code here:
        //        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(tableModel);
        //        tblKhachHang.setRowSorter(obj);
        //        obj.setRowFilter(RowFilter.regexFilter(txtTimKiem.getText()));
    }//GEN-LAST:event_txtTimKiemKeyReleased

<<<<<<< HEAD
    private void tbntimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbntimActionPerformed
        searchKhach();
    }//GEN-LAST:event_tbntimActionPerformed

    private void btnLocKhachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocKhachActionPerformed
        // TODO add your handling code here:
        locKH();
    }//GEN-LAST:event_btnLocKhachActionPerformed

    private void btnNewKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewKHActionPerformed

        clearFormKhach();
        showDataKhach();
        showDataHoaDon();
    }//GEN-LAST:event_btnNewKHActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        addKhach();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateKHActionPerformed
        updateKhach();
    }//GEN-LAST:event_btnUpdateKHActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        searchKhachTheoHoaDon();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        xoaKhach();
    }//GEN-LAST:event_btnDeleteActionPerformed
=======
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //         TODO add your handling code here:
        //        timKiemKhachHang();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //        locKH();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnNewKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewKHActionPerformed
        // TODO add your handling code here:
        txtIDKH.setText("");
        txtTen.setText("");
        txtSDT.setText("");
        txtDiaChi.setText("");
        //        txtGhiChu.setText("");
        //        cboLoaiKH.setSelectedIndex(0);
        //        buttonGroup1.clearSelection();
        //        list = sevice.getAll();
        //        showDataKhachHangToTable();
    }//GEN-LAST:event_btnNewKHActionPerformed

    private void btnDeleteKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteKHActionPerformed
        // TODO add your handling code here:
        //        try {
            //            int row = tblKhachHang.getSelectedRow();
            //            sevice.delete(list.get(row).getId());
            //            list = sevice.getAll();
            //            showDataKhachHangToTable();
            //            txtIDKH.setText("");
            //            txtTen.setText("");
            //            txtSDT.setText("");
            //            txtDiaChi.setText("");
            //            txtGhiChu.setText("");
            //            cboLoaiKH.setSelectedIndex(0);
            //            buttonGroup1.clearSelection();
            //            JOptionPane.showMessageDialog(this, "Xóa thành công");
            //        } catch (Exception e) {
            //            JOptionPane.showMessageDialog(this, "Xóa thất bại");
            //        }
    }//GEN-LAST:event_btnDeleteKHActionPerformed

    private void btnUpdateKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateKHActionPerformed
        // TODO add your handling code here:
        //        try {
            //            int row = tblKhachHang.getSelectedRow();
            //            sevice.update(getFormKhachHang(), list.get(row).getId());
            //            list = sevice.getAll();
            //            showDataKhachHangToTable();
            //            JOptionPane.showMessageDialog(this, "Update thành công");
            //        } catch (Exception e) {
            //            JOptionPane.showMessageDialog(this, "Update thất bại");
            //        }
    }//GEN-LAST:event_btnUpdateKHActionPerformed

    private void btnDeleteKH1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteKH1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteKH1ActionPerformed
>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ViewKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ViewKhachHang;
<<<<<<< HEAD
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLocKhach;
    private javax.swing.JButton btnNewKH;
    private javax.swing.JButton btnUpdateKH;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton hoatDong;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
=======
    private javax.swing.JButton btnDeleteKH;
    private javax.swing.JButton btnDeleteKH1;
    private javax.swing.JButton btnNewKH;
    private javax.swing.JButton btnUpdateKH;
    private javax.swing.JComboBox<String> cboLocLoaiKH;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
<<<<<<< HEAD
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
=======
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
<<<<<<< HEAD
    private javax.swing.JRadioButton khongHoatDong;
    private javax.swing.JRadioButton rioHoatdong;
    private javax.swing.JRadioButton riodunghoatdong;
    private javax.swing.JTable tblDanhSachMua;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JButton tbntim;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNgaysua;
    private javax.swing.JTextField txtNgaytao;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiemTheoHoaDon;
=======
    private javax.swing.JTable tblDanhSachMua;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDiaChi1;
    private javax.swing.JTextField txtDiaChi2;
    private javax.swing.JTextField txtDiaChi3;
    private javax.swing.JTextField txtIDKH;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSDT1;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
>>>>>>> 9b6b4c2 (upadate khach hàng,thanh toán)
    // End of variables declaration//GEN-END:variables
}
