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
public class JenisBus {
    private String idJenis;
    private String namaJenis;
    private int hargaSewa;
    private int jumlahDisewa;

    public JenisBus(String idJenis, String namaJenis, int hargaSewa, int jumlahDisewa){
        this.idJenis = idJenis;
        this.namaJenis = namaJenis;
        this.hargaSewa = hargaSewa;
        this.jumlahDisewa = jumlahDisewa;
    }
    
    public String getIdJenis() {
        return idJenis;
    }

    public void setIdJenis(String idJenis) {
        this.idJenis = idJenis;
    }

    public String getNamaJenis() {
        return namaJenis;
    }

    public void setNamaJenis(String namaJenis) {
        this.namaJenis = namaJenis;
    }

    public int getHargaSewa() {
        return hargaSewa;
    }

    public void setHargaSewa(int hargaSewa) {
        this.hargaSewa = hargaSewa;
    }

    public int getJumlahDisewa() {
        return jumlahDisewa;
    }

    public void setJumlahDisewa(int jumlahDisewa) {
        this.jumlahDisewa = jumlahDisewa;
    }    
}
