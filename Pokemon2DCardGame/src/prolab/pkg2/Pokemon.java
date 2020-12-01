package prolab.pkg2;

/**
 *
 * @author Tayfun Kuşçu
 */
public class Pokemon {
    private String pokemonID;
    private String pokemonAdi;
    private String pokemonTip;
    private int kullanim;
    private int kullanim2;
    private String kartResmi;
    private int hasarPuani;

    public String getKartResmi() {
        return kartResmi;
    }

    public Pokemon() {
    }

    public Pokemon(String pokemonID, String pokemonAdi, String pokemonTip,String kartResmi,int hasarPuani) {
        this.pokemonID = pokemonID;
        this.pokemonAdi = pokemonAdi;
        this.pokemonTip = pokemonTip;
        this.kullanim= 0;
        this.kullanim2= 0;
        this.kartResmi = kartResmi;
        this.hasarPuani = hasarPuani;
    }

    

    public void setKartResmi(String kartResmi) {
        this.kartResmi = kartResmi;
    }


    public int getHasarPuanı() {
        return hasarPuani;
    }

    public void setHasarPuanı(int hasarPuanı) {
        this.hasarPuani = hasarPuanı;
    }

    public int getKullanim() {
        return kullanim;
    }

    public String getPokemonID() {
        return pokemonID;
    }

    public void setPokemonID(String pokemonID) {
        this.pokemonID = pokemonID;
    }

    public String getPokemonAdi() {
        return pokemonAdi;
    }

    public void setPokemonAdi(String pokemonAdi) {
        this.pokemonAdi = pokemonAdi;
    }

    public String getPokemonTip() {
        return pokemonTip;
    }

    public void setPokemonTip(String pokemonTip) {
        this.pokemonTip = pokemonTip;
    }

    public int getKullanim2() {
        return kullanim2;
    }

    public void setKullanim2() {
        this.kullanim2 = 1;
    }

    public void setKullanim() {
        this.kullanim = 1;
    }
    
    public void bilgi(){
        System.out.println(""+this.getPokemonID());
        System.out.println(""+this.getPokemonAdi());
        System.out.println(""+this.getPokemonTip());
    }
    
    public void HasarPuaniGoster(){
        System.out.println("xx");
    }
    
    public boolean used(int i){
        if(i==1){
            System.out.println("Kullanildi");
            return true;
        }else{
            return false;
        }
    }
    
    public boolean used2(int i){
        if(i==1){
            System.out.println("Kullanildi");
            return true;
        }else{
            return false;
        }
    }


}
