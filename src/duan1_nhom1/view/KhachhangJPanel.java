/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package duan1_nhom1.view;

import duan1_nhom1.model.HoaDon;
import duan1_nhom1.model.Khach;
import duan1_nhom1.repository.HoaDonRepository;
import duan1_nhom1.service.KhachService;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maccuacu
 */
public class KhachHangJPanel extends javax.swing.JPanel {

    private DefaultTableModel tableModel = new DefaultTableModel();
    private KhachService khachService = new KhachService();
    private List<Khach> listKH = new ArrayList<>();
    private List<HoaDon> listHD = new ArrayList<>();
    private HoaDonRepository hoaDon = new HoaDonRepository();
    private DefaultComboBoxModel cbbBox = new DefaultComboBoxModel();

    /**
     * Creates new form KhachHangJPanel
     */
    public KhachHangJPanel() {
        initComponents();
        listKH = khachService.getAll();
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
                hoaDon.getTrangThai() ? "Đã thanh toán" : "Chưa thanh toán "
            });
        }
    }

    private Khach getDataKhach() {
        Khach khach = new Khach();
        khach.setMaKhachHang(txtMa.getText());
        khach.setTenKhachHang(txtTen.getText());
        khach.setSdt(txtSdt.getText());
        khach.setTrangThai(rioHoatdong.isSelected());
        return khach;
    }

    private void showDetaiKhach(int index) {
        Khach khach = listKH.get(index);
        txtMa.setText(khach.getMaKhachHang());
        txtTen.setText(khach.getTenKhachHang());
        txtSdt.setText(khach.getSdt());
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
             if (txtMa.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập mã khách hàng");
                return ;
            }
            if (txtTen.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập tên khách hàng");
                return ;
            }
            if (txtSdt.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập sdt khách hàng");
                return ;
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

//            listHD = hoaDon.timKhachTheoHD(maKhach);
            showDataHoaDon();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
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
        tbntim = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtTimKiemTheoHoaDon = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
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
                "Mã hóa đơn", "Ngày mua", "Tổng tiền", "Trạng thái"
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
                "Mã khách hàng ", "Tên khách hàng ", "Số điện thoại ", "Trạng thái "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
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
                        .addComponent(tbntim)
                        .addGap(18, 18, 18))))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiemTheoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jButton1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbntim))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel31)
                .addGap(9, 9, 9)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTimKiemTheoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel13.setBackground(new java.awt.Color(204, 255, 153));
        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel32.setText("THÊM KHÁCH HÀNG MỚI");

        jLabel33.setText("Mã khách hàng ");

        jLabel36.setText("Số  điện thoại ");

        jLabel38.setText(" Trạng thái ");

        jLabel1.setText("Tên khách hàng ");

        buttonGroup2.add(rioHoatdong);
        rioHoatdong.setText("Hoạt động");

        buttonGroup2.add(riodunghoatdong);
        riodunghoatdong.setText("Không hoạt động");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(jLabel38))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtMa)
                                .addComponent(txtTen, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                                .addComponent(txtSdt))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(rioHoatdong)
                                .addGap(18, 18, 18)
                                .addComponent(riodunghoatdong)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
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
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(rioHoatdong)
                    .addComponent(riodunghoatdong))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel20.setBackground(new java.awt.Color(204, 255, 153));
        jPanel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel20.setForeground(new java.awt.Color(203, 233, 191));

        jLabel40.setText("Bộ lọc");

        jLabel41.setText("Trạng thái ");

        btnLocKhach.setText("Lọc");
        btnLocKhach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocKhachActionPerformed(evt);
            }
        });

        btnNewKH.setText("reset");
        btnNewKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewKHActionPerformed(evt);
            }
        });

        buttonGroup1.add(hoatDong);
        hoatDong.setText("Hoạt động");

        buttonGroup1.add(khongHoatDong);
        khongHoatDong.setText("Không hoạt động ");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            }
        });

        btnUpdateKH.setBackground(new java.awt.Color(204, 255, 102));
        btnUpdateKH.setText("Update");
        btnUpdateKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateKHActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(204, 255, 102));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnUpdateKH, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateKH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(ViewKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(ViewKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(ViewKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
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
        showDetaiKhach(row);
        //                listHD = sevice.DanhSachMuaHang(list.get(row).getId());
        //                showHoaDonKhachHangMua();
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

    private void tbntimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbntimActionPerformed
        searchKhach();
    }//GEN-LAST:event_tbntimActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        searchKhachTheoHoaDon();
    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        xoaKhach();
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ViewKhachHang;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLocKhach;
    private javax.swing.JButton btnNewKH;
    private javax.swing.JButton btnUpdateKH;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JRadioButton hoatDong;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JRadioButton khongHoatDong;
    private javax.swing.JRadioButton rioHoatdong;
    private javax.swing.JRadioButton riodunghoatdong;
    private javax.swing.JTable tblDanhSachMua;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JButton tbntim;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiemTheoHoaDon;
    // End of variables declaration//GEN-END:variables
}
