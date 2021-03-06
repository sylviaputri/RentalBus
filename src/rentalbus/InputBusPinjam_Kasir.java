/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalbus;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sylvia Putri
 */
public class InputBusPinjam_Kasir extends javax.swing.JFrame {
    KoneksiDB kon = new KoneksiDB();
    TransaksiPeminjaman_Kasir tPeminjaman = null;
    
    /**
     * Creates new form InputBusPinjam_Kasir
     */
    public InputBusPinjam_Kasir(TransaksiPeminjaman_Kasir tPeminjaman) {
        initComponents();
        this.tPeminjaman = tPeminjaman;
    }

    private InputBusPinjam_Kasir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        txtNopol = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtPinjam = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtSampai = new javax.swing.JTextField();
        btnOK = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblTerbooking = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel8.setText("Nopol bus");

        jLabel11.setText("Tanggal pinjam");

        jLabel12.setText("sampai");

        btnOK.setText("OK");
        btnOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOKMouseClicked(evt);
            }
        });

        btnClose.setText("Close");

        btnHapus.setText("Hapus");
        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusMouseClicked(evt);
            }
        });

        jLabel1.setText("Input Bus yang Ingin Dipinjam");

        lblTerbooking.setForeground(new java.awt.Color(204, 0, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnClose)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(btnHapus)
                        .addGap(55, 55, 55)
                        .addComponent(btnOK))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNopol, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSampai, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(lblTerbooking, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnClose)
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNopol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtSampai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTerbooking, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOK)
                    .addComponent(btnHapus))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOKMouseClicked
        try {
            kon.connect();
        } catch (SQLException ex) {
            Logger.getLogger(InputBusPinjam_Kasir.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //PIKIR CARANYA
            kon.createQuery("select * from bus where nopol_bus = '" +txtNopol.getText().toString()+"'");
            if(!kon.myRs.next())
                lblTerbooking.setText("bus tidak ditemukan");
            else{
                kon.createQuery("select * from bus where nopol_bus = '" +txtNopol.getText().toString()+"' and status_sewa='tersedia'");
                if(!kon.myRs.next())
                    lblTerbooking.setText("bus sedang dipinjam /  sudah dibooking");
                else{
                    kon.createQuery("select * from bookingbus where nopol = '" +txtNopol.getText().toString()+"' AND tgl_sewa<= '" + txtPinjam.getText().toString()+"' AND tgl_kembali>='"+txtSampai.getText().toString()+"'");
                    if(kon.myRs.next())
                        lblTerbooking.setText("bus sedang dipinjam /  sudah dibooking");
                    else{
                        kon.createQuery("select datediff('"+txtSampai.getText().toString()+"','"+txtPinjam.getText().toString()+"') as selisih");
                        if(kon.myRs.next()){
                            int selisih = kon.myRs.getInt("selisih");
                            kon.createQuery("select * from bus,jenis_bus where nopol_bus = '" +txtNopol.getText().toString()+"' AND bus.jenis_bus=jenis_bus.id_jenis");
                            if(kon.myRs.next()){
                                JenisBus jenisBus = new JenisBus(kon.myRs.getString("id_jenis"), kon.myRs.getString("nama_jenis"), kon.myRs.getInt("harga_sewa"), kon.myRs.getInt("jumlah_disewa"));
                                int subtotal = (selisih+1) * kon.myRs.getInt("harga_sewa");
                                BusPinjam busPinjam = new BusPinjam(kon.myRs.getString("nopol_bus"),txtPinjam.getText().toString(),txtSampai.getText().toString(), jenisBus, kon.myRs.getString("nama_sopir"), jenisBus.getHargaSewa(), subtotal);
                                tPeminjaman.addBusPinjam(busPinjam);
                                this.setVisible(false);
                            }
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(InputBusPinjam_Kasir.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            kon.close();
        } catch (SQLException ex) {
            Logger.getLogger(InputBusPinjam_Kasir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnOKMouseClicked

    //pencet hapus
    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        tPeminjaman.removeBusPinjam(txtNopol.getText().toString());
        this.setVisible(false);
    }//GEN-LAST:event_btnHapusMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputBusPinjam_Kasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblTerbooking;
    public javax.swing.JTextField txtNopol;
    public javax.swing.JTextField txtPinjam;
    public javax.swing.JTextField txtSampai;
    // End of variables declaration//GEN-END:variables
}
