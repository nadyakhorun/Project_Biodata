
package apk_biodata;

import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Menu_Siswa extends javax.swing.JFrame {
    private DefaultTableModel model = null;
    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();
    
    public Menu_Siswa() {
        initComponents();
        k.connect();
        refreshTable();
    }
    
    class siswa extends Menu_Siswa{
        String nis, nama, tingkat="", jurusan, kelas, alamat, no_telepon;
        
        public siswa() {
            nis = text_nis.getText();
            nama = text_nama.getText();
            if (check_x.isSelected()) {
                tingkat += "X (Sepuluh)";
            }
            else if (check_xi.isSelected()) {
                tingkat += "XI (Sebelas)";
            }
            else if (check_xii.isSelected()) {
                tingkat += "XII (Dua Belas)";
            }
            jurusan = combo_jurusan.getSelectedItem().toString();
            radio_1.setActionCommand("1");
            radio_2.setActionCommand("2");
            radio_3.setActionCommand("3");
            radio_4.setActionCommand("4");
            kelas = buttonGroup1.getSelection().getActionCommand();
            alamat = text_alamat.getText();
            no_telepon = text_hp.getText();
        }
    }
    
    public void refreshTable(){
        model = new DefaultTableModel();
        model.addColumn("NIS");
        model.addColumn("Nama");
        model.addColumn("Tingkat");
        model.addColumn("Jurusan");
        model.addColumn("Kelas");
        model.addColumn("Alamat");
        model.addColumn("No. Telepon");
        tabel_biodata.setModel(model);
        try {
            this.stat = k.getCon().prepareStatement("select * from siswa");
            this.rs = this.stat.executeQuery();
            while (rs.next()) {                
                Object[] data = {
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7)
                    
                };
                model.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        text_nis.setText("");
        text_nama.setText("");
        text_alamat.setText("");
        text_hp.setText("");
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        text_nis = new javax.swing.JTextField();
        text_nama = new javax.swing.JTextField();
        check_x = new javax.swing.JCheckBox();
        check_xi = new javax.swing.JCheckBox();
        check_xii = new javax.swing.JCheckBox();
        combo_jurusan = new javax.swing.JComboBox<>();
        radio_1 = new javax.swing.JRadioButton();
        radio_2 = new javax.swing.JRadioButton();
        radio_3 = new javax.swing.JRadioButton();
        radio_4 = new javax.swing.JRadioButton();
        text_alamat = new javax.swing.JTextField();
        text_hp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_biodata = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btn_input = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("BIODATA SISWA");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("NIS");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nama");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tingkat");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Jurusan");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Kelas");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Alamat");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("No. Telepon");

        check_x.setText("X (Sepuluh)");

        check_xi.setText("XI (Sebelas)");

        check_xii.setText("XII (Dua Belas)");

        combo_jurusan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "RPL", "TKJ", "TKR", " " }));

        buttonGroup1.add(radio_1);
        radio_1.setText("1");

        buttonGroup1.add(radio_2);
        radio_2.setText("2");

        buttonGroup1.add(radio_3);
        radio_3.setText("3");
        radio_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(radio_4);
        radio_4.setText("4");

        tabel_biodata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NIS", "Nama", "Tingkat", "Jurusan", "Kelas", "Alamat", "No. Telepon"
            }
        ));
        tabel_biodata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_biodataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_biodata);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn_input.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_input.setText("INPUT");
        btn_input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inputActionPerformed(evt);
            }
        });

        btn_update.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_update.setText("UPDATE");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_delete.setText("DELETE");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btn_input)
                .addGap(50, 50, 50)
                .addComponent(btn_update)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(btn_delete)
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_input, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(127, 127, 127))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(text_nis)
                                    .addComponent(text_nama)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(check_x)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(check_xi)
                                        .addGap(27, 27, 27)
                                        .addComponent(check_xii))
                                    .addComponent(combo_jurusan, 0, 328, Short.MAX_VALUE)
                                    .addComponent(text_alamat)
                                    .addComponent(text_hp)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(radio_1)
                                        .addGap(18, 18, 18)
                                        .addComponent(radio_2)
                                        .addGap(18, 18, 18)
                                        .addComponent(radio_3)
                                        .addGap(18, 18, 18)
                                        .addComponent(radio_4)))))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(text_nis, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(check_x, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(check_xi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(check_xii, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(radio_1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radio_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radio_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radio_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(text_alamat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_hp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inputActionPerformed
        // TODO add your handling code here:
        try {
            siswa s = new siswa();
            this.stat = k.getCon().prepareStatement("insert into siswa values(?,?,?,?,?,?,?)");
            stat.setString(1, s.nis);
            stat.setString(2, s.nama);
            stat.setString(3, s.tingkat);
            stat.setString(4, s.jurusan);
            stat.setString(5, s.kelas);
            stat.setString(6, s.alamat);
            stat.setString(7, s.no_telepon);
            stat.executeUpdate();
            refreshTable();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btn_inputActionPerformed

    private void radio_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radio_3ActionPerformed

    private void tabel_biodataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_biodataMouseClicked
        // TODO add your handling code here:
        text_nis.setText(model.getValueAt(tabel_biodata.getSelectedRow(), 0).toString());
        text_nama.setText(model.getValueAt(tabel_biodata.getSelectedRow(), 1).toString());
        text_alamat.setText(model.getValueAt(tabel_biodata.getSelectedRow(), 5).toString());
        text_hp.setText(model.getValueAt(tabel_biodata.getSelectedRow(), 6).toString());
    }//GEN-LAST:event_tabel_biodataMouseClicked

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        try {
            stat = k.getCon().prepareStatement("update siswa set nama=?, alamat=?, no_telepon=? where nis=?");
            stat.setString(1, text_nama.getText());
            stat.setString(2, text_alamat.getText());
            stat.setString(3, text_hp.getText());
            stat.setString(4, text_nis.getText());
            stat.executeUpdate();
            refreshTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        try {
            stat = k.getCon().prepareStatement("delete from siswa where nis=?");
            stat.setString(1, text_nis.getText());
            stat.executeUpdate();
            refreshTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Siswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_input;
    private javax.swing.JButton btn_update;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox check_x;
    private javax.swing.JCheckBox check_xi;
    private javax.swing.JCheckBox check_xii;
    private javax.swing.JComboBox<String> combo_jurusan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radio_1;
    private javax.swing.JRadioButton radio_2;
    private javax.swing.JRadioButton radio_3;
    private javax.swing.JRadioButton radio_4;
    private javax.swing.JTable tabel_biodata;
    private javax.swing.JTextField text_alamat;
    private javax.swing.JTextField text_hp;
    private javax.swing.JTextField text_nama;
    private javax.swing.JTextField text_nis;
    // End of variables declaration//GEN-END:variables
}
