package prolab.pkg2;

import javax.swing.ImageIcon;

/**
 *
 * @author Tayfun Kuşçu
 */
public class Meowth extends Pokemon {
    
        private String kartResmi ="src\\card\\meowth.png";
        private ImageIcon icon = new ImageIcon(kartResmi);
        private int hasarPuani=40;
        public int kullanim=0;
        private int kullanim2=0;

    public Meowth() {
    }


    public Meowth(String pokemonID, String pokemonAdi, String pokemonTip, String kartResmi, int hasarPuani) {
        super(pokemonID, pokemonAdi, pokemonTip, kartResmi, hasarPuani);
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
