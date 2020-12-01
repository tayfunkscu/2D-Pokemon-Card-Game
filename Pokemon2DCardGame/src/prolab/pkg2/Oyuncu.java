package prolab.pkg2;

import java.util.ArrayList;

/**
 *
 * @author Tayfun Kuşçu
 */
public abstract class Oyuncu {
    private String oyuncuAdi;
    private int oyuncuID;
    private int skor;
    private ArrayList<Pokemon> kartListesi;
    private int kartSayisi;

    public Oyuncu(String oyuncuAdi, int oyuncuID, int skor) {
        this.oyuncuAdi = oyuncuAdi;
        this.oyuncuID = oyuncuID;
        this.skor = skor;
    }

    public Oyuncu() {
        oyuncuAdi = "Girilmedi";
        oyuncuID = -1;
        skor = 0;
    }
    
    public abstract int kartSec();
    
    public void SkorGoster(){
        System.out.println(""+this.skor);
    }

    public String getOyuncuAdi() {
        return oyuncuAdi;
    }

    public void setOyuncuAdi(String oyuncuAdi) {
        this.oyuncuAdi = oyuncuAdi;
    }

    public int getOyuncuID() {
        return oyuncuID;
    }

    public void setOyuncuID(int oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }
    
    public int getKartSayisi() {
        return kartSayisi;
    }

    public void setKartSayisi(int kartSayisi) {
        this.kartSayisi = kartSayisi;
    }

    public ArrayList<Pokemon> getKartListesi() {
        return kartListesi;
    }

    public void setKartListesi(ArrayList<Pokemon> kartListesi) {
        this.kartListesi = kartListesi;
    }
    
}
