/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalbus;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javax.swing.JOptionPane;

/**
 *
 * @author Sylvia Putri
 */
public class Login extends javax.swing.JFrame {
    KoneksiDB kon = new KoneksiDB();
    ArrayList<Bus> busList;
    
    static String nama;
    
    /**
     * Creates new form Login
     */
    public Login() throws SQLException {
        initComponents();
        busList = busList();
        updateStatusAllBus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        txtPassword = new javax.swing.JPasswordField();
        txtUsername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        jLabel3.setText("Welcome");

        btnLogin.setText("LOGIN");
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoginMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(340, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogin)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(336, 336, 336))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(145, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(37, 37, 37)
                .addComponent(btnLogin)
                .addGap(111, 111, 111))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseClicked
        //kalau username dan password = "admin", masuk ke homepage Admin
        if(txtUsername.getText().equals("admin") && txtPassword.getText().equals("admin")){
            this.setVisible(false);
            new HomePage_Admin().setVisible(true);
        }
        else{
            try {
                kon.connect();
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                kon.createQuery("select * from kasir where username='"+txtUsername.getText()+"' and password='" + txtPassword.getText()+"'");
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                while(kon.myRs.next())
                    nama = kon.myRs.getString("nama_kasir");
                if(nama==null){ //kalau user&pass ga ketemu di DB
                    JOptionPane.showMessageDialog(null, "Username atau password salah", "", JOptionPane.WARNING_MESSAGE);
                }
                else{
                    System.out.println(nama);
                    //pindah ke homepage kasir
                    this.setVisible(false);
                    new HomePage_Kasir(nama).setVisible(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                kon.close();
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnLoginMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Login().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }
    
    public void updateStatusAllBus() throws SQLException{
        kon.connect();
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNow = sdf.format(cal.getTime());
        for(int i=0; i<busList.size(); i++){
            kon.createQuery("select * from bookingbus where nopol='"+busList.get(i).getNopol()+"' AND tgl_sewa<= '" + dateNow +"'");
            //kalau ada, set status jadi "dipinjam"
            if(kon.myRs.next()){
                kon.createUpdate("UPDATE `bus` SET `status_sewa` = 'dipinjam' WHERE `bus`.`nopol_bus` = '"+busList.get(i).getNopol()+"' ");
            }
        }
        kon.close();
    }
    
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
