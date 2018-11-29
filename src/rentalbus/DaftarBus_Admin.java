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
import static rentalbus.DaftarBus_Kasir.nama;
import static rentalbus.Login.nama;

/**
 *
 * @author Sylvia Putri
 */
public class DaftarBus_Admin extends javax.swing.JFrame {
    KoneksiDB kon = new KoneksiDB();
    DetailBus_Admin detailBus;
    ArrayList<Bus> busList;
    
    //CONSTRUCTOR
    public DaftarBus_Admin() throws SQLException {
        initComponents();
        ArrayList<Bus> list = busList();
        show_bus(list);
    }
    
    //Mendapatkan semua data BUS dari DB (tanpa searching)
    public ArrayList<Bus> busList() throws SQLException{
        busList = new ArrayList<>();
        ArrayList<JenisBus> jenisBusList = jenisBusList();
        try{
            kon.connect();
            kon.createQuery("select * from bus");
            Bus bus;
            JenisBus jenisBus = null;
            while(kon.myRs.next()){
                for(int i=0;i<jenisBusList.size();i++){
                    if(kon.myRs.getString("jenis_bus").equals(jenisBusList.get(i).getIdJenis())){
                        jenisBus=jenisBusList.get(i);
                        break;
                    }
                }
                bus = new Bus(kon.myRs.getString("nopol_bus"), kon.myRs.getString("nama_sopir"), jenisBus, kon.myRs.getString("status_sewa"));
                busList.add(bus);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            kon.close();
        }
        return busList;
    }
    
    //Mendapatkan semua data JENIS BUS dari DB (tanpa searching)
    public ArrayList<JenisBus> jenisBusList() throws SQLException{
        ArrayList<JenisBus> jenisBusList = new ArrayList<>();
        try{
            kon.connect();
            kon.createQuery("select * from jenis_bus");
            JenisBus jenisBus;
            while(kon.myRs.next()){
                jenisBus = new JenisBus(kon.myRs.getString("id_jenis"), kon.myRs.getString("nama_jenis"), kon.myRs.getInt("harga_sewa"), kon.myRs.getInt("jumlah_disewa"));
                jenisBusList.add(jenisBus);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            kon.close();
        }
        return jenisBusList;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBus = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnTambahBus = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        comboSearch = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        comboAdvancedSearch = new javax.swing.JComboBox<>();
        txtAdvancedSearch = new javax.swing.JTextField();
        comboSorting = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.setBorder(null);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tableBus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nopol", "Jenis Bus", "Harga Sewa/Hari (Rp)", "Status Sewa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableBus.setCellSelectionEnabled(true);
        tableBus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBusMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableBus);

        jLabel1.setText("Daftar Bus");

        btnSearch.setText("Search");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });

        jLabel2.setText("Search by");

        jLabel3.setText("Sorting by");

        jLabel4.setText("Advanced search by");

        btnTambahBus.setText("Tambah Bus");
        btnTambahBus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahBusMouseClicked(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        comboSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nopol", "Jenis", "Status" }));

        comboAdvancedSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nopol", "Jenis", "Status" }));

        comboSorting.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nopol", "Harga" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(338, 338, 338)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboAdvancedSearch, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboSorting, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSearch)
                                    .addComponent(txtAdvancedSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(397, 397, 397)
                                .addComponent(btnTambahBus))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnTambahBus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtAdvancedSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboAdvancedSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboSorting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addComponent(jLabel2))
                        .addGap(15, 15, 15)
                        .addComponent(btnSearch)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //kalau table di click, keluar detailnya -> menuju halaman DETAIL BUS
    private void tableBusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBusMouseClicked
       int index = tableBus.getSelectedRow();
        TableModel model = tableBus.getModel();
        String nopol = model.getValueAt(index, 0).toString();
        Bus bus = null;
        for(int i=0;i<busList.size();i++){
            if(busList.get(i).getNopol().equals(nopol)){
                bus=busList.get(i);
                break;
            }
        }
        try {
            detailBus = new DetailBus_Admin();
        } catch (SQLException ex) {
            Logger.getLogger(DaftarBus_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        detailBus.setVisible(true);
        this.setVisible(false);
        detailBus.pack();
        detailBus.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        detailBus.lblNopol.setText(bus.getNopol());
        detailBus.lblBanyakSewa.setText(String.valueOf(bus.getJenisBus().getJumlahDisewa())+" kali");
        detailBus.lblHarga.setText("Rp "+String.valueOf(bus.getJenisBus().getHargaSewa()));
        detailBus.txtSopir.setText(bus.getNamaSupir());
        detailBus.lblStatus.setText(bus.getStatusSewa());
        detailBus.comboJenis.setSelectedItem(bus.getJenisBus().getNamaJenis());
    }//GEN-LAST:event_tableBusMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        this.setVisible(false);
        new HomePage_Admin().setVisible(true);
    }//GEN-LAST:event_jButton2MouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        DefaultTableModel model = (DefaultTableModel)tableBus.getModel();
        int tableSize = model.getRowCount();
        for (int i = tableSize - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        ArrayList<Bus> list = null;
        try {
            list = busListWithSearch();
        } catch (SQLException ex) {
            
        }
        show_bus(list);
    }//GEN-LAST:event_btnSearchMouseClicked

    //klik button TAMBAH BUS
    private void btnTambahBusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahBusMouseClicked
        this.setVisible(false);
        try {
            new TambahBus_Admin().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(DaftarBus_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTambahBusMouseClicked

    //Menampilkan data BUS kedalam TABEL
    public void show_bus(ArrayList<Bus> list){
        DefaultTableModel model = (DefaultTableModel)tableBus.getModel();
        Object[] row = new Object[4];
        for(int i=0;i<list.size();i++){
            row[0] = list.get(i).getNopol();
            row[1] = list.get(i).getJenisBus().getNamaJenis();
            row[2] = list.get(i).getJenisBus().getHargaSewa();
            row[3] = list.get(i).getStatusSewa();
            model.addRow(row);
        }
    }
    
    //Mendapatkan data BUS dari DB menggunakan SEARCHING
    public ArrayList<Bus> busListWithSearch() throws SQLException{
        busList = new ArrayList<>();
        ArrayList<JenisBus> jenisBusList = jenisBusList();
        try{
            kon.connect();
            String searchBy="";
            if(comboSearch.getSelectedItem().toString().equals("Nopol"))
                searchBy="nopol_bus";
            else if(comboSearch.getSelectedItem().toString().equals("Jenis"))
                searchBy="nama_jenis";
            else if(comboSearch.getSelectedItem().toString().equals("Status"))
                searchBy="status_sewa";
            
            String advanchedSearchBy="";
            if(comboAdvancedSearch.getSelectedItem().toString().equals("Nopol"))
                advanchedSearchBy="nopol_bus";
            else if(comboAdvancedSearch.getSelectedItem().toString().equals("Jenis"))
                advanchedSearchBy="nama_jenis";
            else if(comboAdvancedSearch.getSelectedItem().toString().equals("Status"))
                advanchedSearchBy="status_sewa";
            
            String sortingBy="";
            if(comboSorting.getSelectedItem().toString().equals("Nopol"))
                sortingBy="nopol_bus";
            else if(comboSorting.getSelectedItem().toString().equals("Harga"))
                sortingBy="harga_sewa";
            
            kon.createQuery("select * from bus, jenis_bus where bus.jenis_bus = jenis_bus.id_jenis and "+searchBy+" like '%"+txtSearch.getText().toString()+"%' and "+advanchedSearchBy+" like '%"+txtAdvancedSearch.getText().toString()+"%' order by "+sortingBy);
            Bus bus;
            JenisBus jenisBus = null;
            while(kon.myRs.next()){
                for(int i=0;i<jenisBusList.size();i++){
                    if(kon.myRs.getString("jenis_bus").equals(jenisBusList.get(i).getIdJenis())){
                        jenisBus=jenisBusList.get(i);
                        break;
                    }
                }
                bus = new Bus(kon.myRs.getString("nopol_bus"), kon.myRs.getString("nama_sopir"), jenisBus, kon.myRs.getString("status_sewa"));
                busList.add(bus);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            kon.close();
        }
        return busList;
    }
    
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
            java.util.logging.Logger.getLogger(DaftarBus_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DaftarBus_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DaftarBus_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DaftarBus_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DaftarBus_Admin().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(DaftarBus_Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnTambahBus;
    private javax.swing.JComboBox<String> comboAdvancedSearch;
    private javax.swing.JComboBox<String> comboSearch;
    private javax.swing.JComboBox<String> comboSorting;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableBus;
    private javax.swing.JTextField txtAdvancedSearch;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
