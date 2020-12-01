package prolab.pkg2;

import javax.swing.ImageIcon;

/**
 *
 * @author Tayfun Kuşçu
 */
public class Butterfree extends Pokemon {

    public Butterfree(String pokemonID, String pokemonAdi, String pokemonTip, String kartResmi, int hasarPuani) {
        super(pokemonID, pokemonAdi, pokemonTip, kartResmi, hasarPuani);
    }
    
        private String kartResmi ="src\\card\\butterfree.png";
        private ImageIcon icon = new ImageIcon(kartResmi);
        private int hasarPuani=10;
        public int kullanim=0;
        private int kullanim2=0;

    public Butterfree() {
    }
    
    @Override
    public void HasarPuaniGoster(){
        System.out.println(""+this.hasarPuani);
    }
    
        @Override
    public boolean used(int i){
        if(i==1){
            System.out.println("Kullanildi");
            return true;
        }else{
            return false;
        }
    }
    
        @Override
    public boolean used2(int i){
        if(i==1){
            System.out.println("Kullanildi");
            return true;
        }else{
            return false;
        }
    }
    
    

    public int getHasarPuani() {
        return hasarPuani;
    }

    public void setHasarPuani(int hasarPuani) {
        this.hasarPuani = hasarPuani;
    }
    
}
