/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rentalbus;

/**
 *
 * @author Sylvia Putri
 */
public class BusPinjam {
    private String nopol;
    private String tgPinjam;
    private String tgKembali;
    private JenisBus jenisBus;
    private String namaSupir;
    private int harga;
    private int subTotal;
    private int denda;
    
    public BusPinjam(String nopol, String tgPinjam, String tgKembali, JenisBus jenisBus, String namaSupir, int harga, int subTotal){
        this.nopol = nopol;
        this.namaSupir = namaSupir;
        this.jenisBus = jenisBus;
        this.tgPinjam = tgPinjam;
        this.tgKembali = tgKembali;
        this.harga = harga;
        this.subTotal = subTotal;
    }
    
    public BusPinjam(String nopol, String tgPinjam, String tgKembali, int subTotal){
        this.nopol = nopol;
        this.namaSupir = "";
        this.jenisBus = null;
        this.tgPinjam = tgPinjam;
        this.tgKembali = tgKembali;
        this.harga = 0;
        this.subTotal = subTotal;
    }
    
    
    //getter setter
    public String getNopol() {
        return nopol;
    }

    public void setNopol(String nopol) {
        this.nopol = nopol;
    }

    public String getTgPinjam() {
        return tgPinjam;
    }

    public void setTgPinjam(String tgPinjam) {
        this.tgPinjam = tgPinjam;
    }

    public String getTgKembali() {
        return tgKembali;
    }

    public void setTgKembali(String tgKembali) {
        this.tgKembali = tgKembali;
    }

    public JenisBus getJenisBus() {
        return jenisBus;
    }

    public void setJenisBus(JenisBus jenisBus) {
        this.jenisBus = jenisBus;
    }

    public String getNamaSupir() {
        return namaSupir;
    }

    public void setNamaSupir(String namaSupir) {
        this.namaSupir = namaSupir;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }

    public int getDenda() {
        return denda;
    }

    public void setDenda(int denda) {
        this.denda = denda;
    }
    
}
