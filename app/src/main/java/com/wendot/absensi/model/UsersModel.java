package com.wendot.absensi.model;

public class UsersModel {
    String nama, nik, nip, nohp, password, role;

    public UsersModel() {
    }

    public UsersModel(String nama, String nik, String nip, String nohp, String password, String role) {
        this.nama = nama;
        this.nik = nik;
        this.nip = nip;
        this.nohp = nohp;
        this.password = password;
        this.role = role;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
