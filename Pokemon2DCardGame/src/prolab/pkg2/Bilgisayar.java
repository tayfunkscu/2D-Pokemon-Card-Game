package prolab.pkg2;

import java.util.Random;

/**
 *
 * @author Tayfun Kuşçu
 */
public class Bilgisayar extends Oyuncu {

    public Bilgisayar(String oyuncuAdi, int oyuncuID, int skor) {
        super(oyuncuAdi, oyuncuID, skor);
    }

    public Bilgisayar() {
        super();
    }
    @Override
    public int kartSec() {
        Random ran = new Random();
        int secim = ran.nextInt(getKartSayisi())+1;
        return secim;
    }
    
}
