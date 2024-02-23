/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package duan1_nhom1.view;

import duan1_nhom1.model.DanhMuc;
import duan1_nhom1.service.DanhMucService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maccuacu
 */
public class DanhMucJPanel extends javax.swing.JPanel {

    private DefaultTableModel defaultTableModel = new DefaultTableModel();
    private DanhMucService danhMucService = new DanhMucService();
    int _index = -1;

    public DanhMucJPanel() {
        initComponents();
        loadTableDM();
    }

    
    public void loadTableDM() {

        defaultTableModel = (DefaultTableModel) tbl_danhmuc.getModel();
        defaultTableModel.setRowCount(0);
        int count = 1;
        for (DanhMuc danhMuc : danhMucService.getAll() ) {
            String status;
            if (danhMuc.getTrangThai()) {
                status = "Còn";
            }else {
                status = "Hết";
            }
             Object[] rowData = {
                 count++,
                danhMuc.getMa(),
                danhMuc.getTen(),
                danhMuc.getMoTa(),
                danhMuc.getNgaySua(),
                danhMuc.getNgayTao(),
                
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
    }

    private DanhMuc getDanhMuc() {
        DanhMuc mauSac = new DanhMuc();
        mauSac.setMa(txt_ma.getText());
        mauSac.setTen(txt_ten.getText());
        mauSac.setMoTa(txt_mota.getText());

        Date ngayTao = clr_ngaytao.getDate();
        mauSac.setNgayTao(ngayTao);

        Date ngaySua = clr_ngaysua.getDate();
        mauSac.setNgaySua(ngaySua);
        mauSac.setTrangThai(true);
        return mauSac;
    }

    public void addDanhMuc() {
        try {
            int check = JOptionPane.showConfirmDialog(this, "bạn có muốn thêm không");
            if (check != JOptionPane.YES_OPTION) {
                return;
            }
            DanhMuc dm = getDanhMuc();
            danhMucService.add(dm);
       
            JOptionPane.showMessageDialog(this, "thêm thành công");
            loadTableDM();
            clearForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "thêm thất bại");
        }

    }
    
       
    public void updateDanhMuc() {
        try {
            int check = JOptionPane.showConfirmDialog(this, "bạn có muốn update không");
            if (check != JOptionPane.YES_OPTION) {
                return;
            }
            DanhMuc dm = getDanhMuc();
            int row = tbl_danhmuc.getSelectedRow();
            String id = danhMucService.getAll().get(row).getId();
            danhMucService.update(dm, id);
            loadTableDM();
            JOptionPane.showMessageDialog(this, "Update thành công");
            
            clearForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Update thất bại");
        }

    }
    
    public void click(){
        _index = tbl_danhmuc.getSelectedRow();
        txt_ma.setText(tbl_danhmuc.getValueAt(_index, 1).toString());
        txt_ten.setText(tbl_danhmuc.getValueAt(_index, 2).toString());
        txt_mota.setText(tbl_danhmuc.getValueAt(_index, 3).toString());
        String ngayTaoString = tbl_danhmuc.getValueAt(_index, 4).toString();
        Date ngayTao = null;

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            ngayTao = dateFormat.parse(ngayTaoString);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        String ngaySuaString = tbl_danhmuc.getValueAt(_index, 5).toString();
        Date ngaySua = null;

        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            ngaySua = dateFormat.parse(ngaySuaString);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        clr_ngaytao.setDate(ngayTao);
        clr_ngaysua.setDate(ngaySua);
    }
    
    public void delete(){
        try {
            int check = JOptionPane.showConfirmDialog(this, "bạn có muốn xóa không");
            if (check != JOptionPane.YES_OPTION) {
                return;
            }
            int row = tbl_danhmuc.getSelectedRow();
            String id = danhMucService.getAll().get(row).getId();
            danhMucService.delete(id);
          
            JOptionPane.showMessageDialog(this, "xóa thành công");
            loadTableDM();
            clearForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "xóa thất bại ");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        btn_search2 = new javax.swing.JButton();
        txt_search2 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_danhmuc = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        txt_ma = new javax.swing.JTextField();
        txt_ten = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        btn_them2 = new javax.swing.JButton();
        btn_sua2 = new javax.swing.JButton();
        btn_xoa2 = new javax.swing.JButton();
        btn_clear2 = new javax.swing.JButton();
        clr_ngaytao = new com.toedter.calendar.JDateChooser();
        clr_ngaysua = new com.toedter.calendar.JDateChooser();
        txt_mota = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();

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
        btn_sua2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sua2ActionPerformed(evt);
            }
        });

        btn_xoa2.setText("Xóa");
        btn_xoa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoa2ActionPerformed(evt);
            }
        });

        btn_clear2.setText("Clear");
        btn_clear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clear2ActionPerformed(evt);
            }
        });

        jLabel30.setText("Mo ta:");

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
                                            .addComponent(jLabel28)
                                            .addComponent(jLabel30))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_ten, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                    .addComponent(clr_ngaytao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(clr_ngaysua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_mota, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(18, 18, 18)
                                .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_them2))
                .addGap(26, 26, 26)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sua2))
                .addGap(26, 26, 26)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txt_mota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(btn_xoa2)
                    .addComponent(clr_ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clr_ngaysua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29)
                    .addComponent(btn_clear2))
                .addContainerGap(219, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1056, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 733, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
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

    private void tbl_danhmucMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_danhmucMousePressed
        click();
    }//GEN-LAST:event_tbl_danhmucMousePressed

    private void btn_them2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_them2ActionPerformed
        // TODO add your handling code here:
        addDanhMuc();
    }//GEN-LAST:event_btn_them2ActionPerformed

    private void btn_sua2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sua2ActionPerformed
        // TODO add your handling code here:
        updateDanhMuc();
    }//GEN-LAST:event_btn_sua2ActionPerformed

    private void btn_xoa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoa2ActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btn_xoa2ActionPerformed

    private void btn_clear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clear2ActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btn_clear2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear2;
    private javax.swing.JButton btn_search2;
    private javax.swing.JButton btn_sua2;
    private javax.swing.JButton btn_them2;
    private javax.swing.JButton btn_xoa2;
    private com.toedter.calendar.JDateChooser clr_ngaysua;
    private com.toedter.calendar.JDateChooser clr_ngaytao;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tbl_danhmuc;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_mota;
    private javax.swing.JTextField txt_search2;
    private javax.swing.JTextField txt_ten;
    // End of variables declaration//GEN-END:variables
}
