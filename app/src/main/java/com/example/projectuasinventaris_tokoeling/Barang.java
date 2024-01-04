package com.example.projectuasinventaris_tokoeling;

public class Barang  {
    public Barang(String kodeBarang, String dummyBarang, String s, String imagePath) {
    }

    public String getNamaBarang() {
        return NamaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        NamaBarang = namaBarang;
    }

    public String getKodeBarang() {
        return KodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        KodeBarang = kodeBarang;
    }

    public String getStatusPenjualan() {
        return StatusPenjualan;
    }

    public void setStatusPenjualan(String statusPenjualan) {
        StatusPenjualan = statusPenjualan;
    }

    public int getHargaBarang() {
        return HargaBarang;
    }

    public void setHargaBarang(int hargaBarang) {
        HargaBarang = hargaBarang;
    }

    private String NamaBarang, KodeBarang, StatusPenjualan;
    private int HargaBarang;

    public int getNama() {
        return 0;
    }

    public String getStatus() {
        return null;
    }
}
