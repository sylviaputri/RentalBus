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
public class Bus {
    private String nopol;
    private String namaSupir;
    private JenisBus jenisBus;
    private String statusSewa;

    public Bus(String nopol, String namaSupir, JenisBus jenisBus, String statusSewa){
        this.nopol = nopol;
        this.namaSupir = namaSupir;
        this.jenisBus = jenisBus;
        this.statusSewa = statusSewa;
    }
    
    public String getNopol() {
        return nopol;
    }

    public void setNopol(String nopol) {
        this.nopol = nopol;
    }

    public String getNamaSupir() {
        return namaSupir;
    }

    public void setNamaSupir(String namaSupir) {
        this.namaSupir = namaSupir;
    }

    public JenisBus getJenisBus() {
        return jenisBus;
    }

    public void setJenisBus(JenisBus jenisBus) {
        this.jenisBus = jenisBus;
    }

    public String getStatusSewa() {
        return statusSewa;
    }

    public void setStatusSewa(String statusSewa) {
        this.statusSewa = statusSewa;
    }
    
    
}
