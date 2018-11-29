/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rentalbus;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Sylvia Putri
 */
public class DaftarKasir_Admin extends javax.swing.JFrame {
    KoneksiDB kon = new KoneksiDB();
    DetailKasir_Admin detailKasir;
    ArrayList<Kasir> kasirList;

    /** Creates new form DaftarKasir_Admin */
    public DaftarKasir_Admin() throws SQLException {
        initComponents();
        ArrayList<Kasir> list = kasirList();
        show_kasir(list);
    }
    
    //Mendapatkan semua data KASIR dari DB
    public ArrayList<Kasir> kasirList() throws SQLException{
        kasirList = new ArrayList<>();
        try{
            kon.connect();
            kon.createQuery("select * from kasir");
            Kasir kasir;
            while(kon.myRs.next()){
                kasir = new Kasir(kon.myRs.getString("id_kasir"), kon.myRs.getString("nama_kasir"), kon.myRs.getString("no_ktp"), kon.myRs.getString("username"), kon.myRs.getString("password"));
                kasirList.add(kasir);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            kon.close();
        }
        return kasirList;
    }
    
    //Menampilkan data KASIR kedalam TABEL
    public void show_kasir(ArrayList<Kasir> list){
        DefaultTableModel model = (DefaultTableModel)tableKasir.getModel();
        Object[] row = new Object[4];
        for(int i=0;i<list.size();i++){
            row[0] = list.get(i).getIdKasir();
            row[1] = list.get(i).getNamaKasir();
            row[2] = list.get(i).getKtpKasir();
            model.addRow(row);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableKasir = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnTambahKasir = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setBorder(null);

        tableKasir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Kasir", "Nama", "No KTP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableKasir.setCellSelectionEnabled(true);
        tableKasir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKasirMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableKasir);
        tableKasir.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabel1.setText("Daftar Kasir");

        btnTambahKasir.setText("Tambah Kasir");
        btnTambahKasir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahKasirMouseClicked(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTambahKasir)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnBack)
                            .addGap(334, 334, 334)
                            .addComponent(jLabel1))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(119, 119, 119)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                .addComponent(btnTambahKasir)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        this.setVisible(false);
        new HomePage_Admin().setVisible(true);
    }//GEN-LAST:event_btnBackMouseClicked

    //kalau data tabel diklik, ke DETAIL KASIR
    private void tableKasirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKasirMouseClicked
        int index = tableKasir.getSelectedRow();
        TableModel model = tableKasir.getModel();
        String idKasir = model.getValueAt(index, 0).toString();
        Kasir kasir = null;
        for(int i=0;i<kasirList.size();i++){
            if(kasirList.get(i).getIdKasir().equals(idKasir)){
                kasir=kasirList.get(i);
                break;
            }
        }
        detailKasir = new DetailKasir_Admin();
        detailKasir.setVisible(true);
        this.setVisible(false);
        detailKasir.pack();
        detailKasir.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        detailKasir.lblIdKasir.setText(kasir.getIdKasir());
        detailKasir.txtNama.setText(kasir.getNamaKasir());
        detailKasir.txtKTP.setText(kasir.getKtpKasir());
        detailKasir.txtUsername.setText(kasir.getUsernameKasir());
    }//GEN-LAST:event_tableKasirMouseClicked

    //button TAMBAH di klik
    private void btnTambahKasirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahKasirMouseClicked
        this.setVisible(false);
        try {
            new TambahKasir_Admin().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(DaftarKasir_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTambahKasirMouseClicked

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
            java.util.logging.Logger.getLogger(DaftarKasir_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DaftarKasir_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DaftarKasir_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DaftarKasir_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DaftarKasir_Admin().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(DaftarKasir_Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnTambahKasir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableKasir;
    // End of variables declaration//GEN-END:variables

}
