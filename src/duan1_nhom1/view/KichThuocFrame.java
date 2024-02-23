/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package duan1_nhom1.view;

import duan1_nhom1.model.KichThuoc;
import duan1_nhom1.model.MauSac;
import duan1_nhom1.service.IService;
import duan1_nhom1.service.KichCoService;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * 1
 *
 * @author anhtuanle
 */
public class KichThuocFrame extends javax.swing.JFrame {

    private KichCoService kichCoService = new KichCoService();
    private KichThuoc kichThuoc = new KichThuoc();
    DefaultTableModel defaultTableModel = new DefaultTableModel();
    int _index;

    /**
     * Creates new form KichThuocFrame
     */
    public KichThuocFrame() {
        initComponents();
        loadTableKichThuoc();
    }

    public void loadTableKichThuoc() {

        defaultTableModel = (DefaultTableModel) tbl_kichthuoc.getModel();
        defaultTableModel.setRowCount(0);
        int count = 1;
        for (KichThuoc hang : kichCoService.getAll()) {
            String status;
            if (hang.isTrangThai()) {
                status = "Còn";
            } else {
                status = "Hết";
            }
            Object[] rowData = {
                hang.getMa(),
                hang.getTen(),
                hang.getMoTa(),
                hang.getNgaySua(),
                hang.getNgayTao(),
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

    private KichThuoc getKichCo() {
        KichThuoc kichThuoc = new KichThuoc();
        kichThuoc.setMa(txt_ma.getText());
        kichThuoc.setTen(txt_ten.getText());
        kichThuoc.setMoTa(txt_mota.getText());

        Date ngayTao = clr_ngaytao.getDate();
        kichThuoc.setNgayTao(ngayTao);

        Date ngaySua = clr_ngaysua.getDate();
        kichThuoc.setNgaySua(ngaySua);
//        hang.isTrangThai(true);
        return kichThuoc;
    }

    public void addKichThuoc() {
        try {
            int check = JOptionPane.showConfirmDialog(this, "bạn có muốn thêm không");
            if (check != JOptionPane.YES_OPTION) {
                return;
            }
            KichThuoc kt = getKichCo();
            kichCoService.add(kt);

            JOptionPane.showMessageDialog(this, "thêm thành công");

            loadTableKichThuoc();
            clearForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "thêm thất bại");
        }

    }

    public void updateKichThuoc() {
        try {
            int check = JOptionPane.showConfirmDialog(this, "bạn có muốn update không");
            if (check != JOptionPane.YES_OPTION) {
                return;
            }
            KichThuoc kichThuoc = getKichCo();
            int row = tbl_kichthuoc.getSelectedRow();
            String id = kichCoService.getAll().get(row).getId();
            kichCoService.update(kichThuoc, id);
            loadTableKichThuoc();
            JOptionPane.showMessageDialog(this, "Update thành công");

            clearForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Update thất bại");
        }

    }

    public void deleteKichThuoc() {
        try {
            int check = JOptionPane.showConfirmDialog(this, "bạn có muốn xóa không");
            if (check != JOptionPane.YES_OPTION) {
                return;
            }
            int row = tbl_kichthuoc.getSelectedRow();
            String id = kichCoService.getAll().get(row).getId();
            kichCoService.delete(id);
            kichCoService.getAll().clear();
            JOptionPane.showMessageDialog(this, "xóa thành công");
            loadTableKichThuoc();
            clearForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "xóa thất bại ");
        }
    }

    public void clickKichThuoc() {
        _index = tbl_kichthuoc.getSelectedRow();
        txt_ma.setText(tbl_kichthuoc.getValueAt(_index, 0).toString());
        txt_ten.setText(tbl_kichthuoc.getValueAt(_index, 1).toString());
        txt_mota.setText(tbl_kichthuoc.getValueAt(_index, 2).toString());
        String ngayTaoString = tbl_kichthuoc.getValueAt(_index, 3).toString();
        Date ngayTao = null;

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            ngayTao = dateFormat.parse(ngayTaoString);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        String ngaySuaString = tbl_kichthuoc.getValueAt(_index, 4).toString();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        btn_search = new javax.swing.JButton();
        txt_search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_kichthuoc = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_ma = new javax.swing.JTextField();
        txt_ten = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        clr_ngaytao = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        clr_ngaysua = new com.toedter.calendar.JDateChooser();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        txt_mota = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(203, 233, 162));

        btn_search.setText("Tìm Kiếm");

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
        jScrollPane1.setViewportView(tbl_kichthuoc);

        jLabel1.setText("Mã size");

        jLabel2.setText("Size");

        jLabel3.setText("Ngày tạo:");

        jLabel4.setText("Ngày sửa");

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

        jLabel5.setText("Mô tả:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_search)
                .addGap(57, 57, 57))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_mota, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clr_ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clr_ngaysua, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_them)
                            .addComponent(btn_xoa)
                            .addComponent(btn_sua)
                            .addComponent(btn_clear))
                        .addGap(59, 59, 59))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_search)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoa))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_them))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btn_sua))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_mota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clr_ngaysua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(clr_ngaytao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_clear)
                        .addGap(40, 40, 40))))
        );

        jTabbedPane1.addTab("Kich thuoc", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_kichthuocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_kichthuocMouseClicked
        // TODO add your handling code here:
        clickKichThuoc();
    }//GEN-LAST:event_tbl_kichthuocMouseClicked

    private void tbl_kichthuocMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_kichthuocMousePressed

    }//GEN-LAST:event_tbl_kichthuocMousePressed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        addKichThuoc();
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        deleteKichThuoc();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
        updateKichThuoc();
    }//GEN-LAST:event_btn_suaActionPerformed

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
                new KichThuocFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private com.toedter.calendar.JDateChooser clr_ngaysua;
    private com.toedter.calendar.JDateChooser clr_ngaytao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_kichthuoc;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_mota;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_ten;
    // End of variables declaration//GEN-END:variables
}
