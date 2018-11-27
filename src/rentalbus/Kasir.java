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
public class Kasir {
    private String idKasir;
    private String namaKasir;
    private String ktpKasir;
    private String usernameKasir;
    private String passKasir;
    
    
    public Kasir(String idKasir, String namaKasir, String ktpKasir, String usernameKasir, String passKasir){
        this.idKasir = idKasir;
        this.namaKasir = namaKasir;
        this.ktpKasir = ktpKasir;
        this.usernameKasir = usernameKasir;
        this.passKasir = passKasir;
    }

    public String getIdKasir() {
        return idKasir;
    }

    public void setIdKasir(String idKasir) {
        this.idKasir = idKasir;
    }

    public String getNamaKasir() {
        return namaKasir;
    }

    public void setNamaKasir(String namaKasir) {
        this.namaKasir = namaKasir;
    }

    public String getKtpKasir() {
        return ktpKasir;
    }

    public void setKtpKasir(String ktpKasir) {
        this.ktpKasir = ktpKasir;
    }

    public String getUsernameKasir() {
        return usernameKasir;
    }

    public void setUsernameKasir(String usernameKasir) {
        this.usernameKasir = usernameKasir;
    }

    public String getPassKasir() {
        return passKasir;
    }

    public void setPassKasir(String passKasir) {
        this.passKasir = passKasir;
    }
    
    
}
