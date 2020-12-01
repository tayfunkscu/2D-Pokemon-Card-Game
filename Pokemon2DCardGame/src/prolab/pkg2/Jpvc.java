package prolab.pkg2;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Tayfun Kuşçu
 */
public class Jpvc extends javax.swing.JFrame {

    static Oyuncu oyuncular[] = new Oyuncu[2];
    private int hamle_sayisi= 0;
    private static boolean sunum=false;
    ArrayList<JButton> buttons;
   
    public Jpvc(boolean sunum) {
         this.sunum = sunum;
         if(sunum==true){
             System.out.println("Sunum Modunda açılıyor");
         }
         initComponents();
         islemler();
    }
    public int[] kart_karma(){
        boolean yeniden=false;
        int[] kart_sira=new int[10];
        Random rand = new Random();
        for (int i = 0; i < kart_sira.length; i++) {
            int yer = rand.nextInt(10);
            for (int j = 0; j < i; j++) {
                if(kart_sira[j] == yer){
                    yeniden= true;
                    break;
                }
            }
            if(yeniden ==true){
                
                i--;
                yeniden = false;
                continue;
            }else{
                kart_sira[i] = yer;
            }
        }
        return kart_sira;
    }
    
    public ArrayList<Pokemon> pokemon_atama(){
        ArrayList<Pokemon> pokemonlar = new ArrayList<Pokemon>();
        Pikachu pika = new Pikachu("01","Pikachu","Elektrik","src\\cards\\pikachu.png",40);
        Bulbasaur bulb = new Bulbasaur("02","Bulbasaur","Çim","src\\cards\\bulbasaur.png",40);
        Charmander charm = new Charmander("03","Charmander","Ateş","src\\cards\\charmander.png",60);
        Squirtle squirt = new Squirtle("04","Squirtle","Su","src\\cards\\squirtle.png",30);
        Zubat zuba = new Zubat("05","Zubat","Hava","src\\cards\\zubat.png",50);
        Psyduck psyd = new Psyduck("06","Psyduck","Su","src\\cards\\psyduck.png",20);
        Snorlax snorl = new Snorlax("07","Snorlax","Normal","src\\cards\\snorlax.png",30);
        Butterfree butterf = new Butterfree("08","Butterfree","Hava","src\\cards\\butterfree.png",10);
        Jigglypuff jiggly = new Jigglypuff("09","Jigglypuff","Ses","src\\cards\\jigglypuff.png",70);
        Meowth meow = new Meowth("10","Meowth","Normal","src\\cards\\meowth.png",40);
        pokemonlar.add(pika);pokemonlar.add(bulb);pokemonlar.add(charm);pokemonlar.add(squirt);pokemonlar.add(zuba);
        pokemonlar.add(psyd);pokemonlar.add(snorl);pokemonlar.add(butterf);pokemonlar.add(jiggly);pokemonlar.add(meow);
        return pokemonlar;
    }
    
    public ArrayList<JButton> button_atama(ArrayList<Pokemon> pokemons){
        int[] kart_sirasi = kart_karma();
        ArrayList<JButton> Buttons = new ArrayList<JButton>();   
        for (int i = 0; i < kart_sirasi.length; i++) {
            if(kart_sirasi[i] == 0){Buttons.add(jButton1);}
            if(kart_sirasi[i] == 1){Buttons.add(jButton2);}
            if(kart_sirasi[i] == 2){Buttons.add(jButton3);}
            if(kart_sirasi[i] == 3){Buttons.add(jButton4);}
            if(kart_sirasi[i] == 4){Buttons.add(jButton5);}
            if(kart_sirasi[i] == 5){Buttons.add(jButton6);}
            if(kart_sirasi[i] == 6){Buttons.add(jButton7);}
            if(kart_sirasi[i] == 7){Buttons.add(jButton8);}
            if(kart_sirasi[i] == 8){Buttons.add(jButton9);}
            if(kart_sirasi[i] == 9){Buttons.add(jButton10);}
        }
        Buttons = button_gorev_atama(pokemons, Buttons);
        return Buttons;
    }
    
      public ArrayList<JButton> button_gorev_atama(ArrayList<Pokemon> pokemons,ArrayList<JButton> buttons){
        for(int i=0;i<buttons.size();i++){
            if(buttons.get(i) == jButton4 || buttons.get(i) == jButton5 || buttons.get(i) == jButton6 || sunum == true){
                ImageIcon icon = new ImageIcon(System.getProperty("user.dir")+"\\"+pokemons.get(i).getKartResmi());
                buttons.get(i).setIcon(icon);
            }else{
                ImageIcon icon = new ImageIcon(System.getProperty("user.dir")+"\\src\\cards\\background.png");
                buttons.get(i).setIcon(icon);
            }

            buttons.get(i).putClientProperty("kartresmi", pokemons.get(i).getKartResmi());
            buttons.get(i).putClientProperty("isim", pokemons.get(i).getPokemonAdi());
            buttons.get(i).putClientProperty("saldırıpuan", pokemons.get(i).getHasarPuanı());
        }
        jButton4.addActionListener((ActionEvent e) ->{player_vs_computer(jButton4);});
        jButton5.addActionListener((ActionEvent e) ->{player_vs_computer(jButton5);});
        jButton6.addActionListener((ActionEvent e) ->{player_vs_computer(jButton6);});
        
        return buttons;
    }
    
    
    public static void player_vs_computer(JButton playerbtn) {
        ArrayList<JButton> computer1;
        ArrayList<JButton> computer2;
        ArrayList<JButton> other_cards;
        
        computer2 = check_cards_comp2();
       
        int com2_secim = select_card(computer2);
        
        if(computer2.size() > 0){
            ImageIcon icon1 = new ImageIcon(System.getProperty("user.dir")+"\\"+playerbtn.getClientProperty("kartresmi").toString());
            System.out.println(System.getProperty("user.dir")+"\\"+playerbtn.getClientProperty("kartresmi").toString());
            ImageIcon icon2 = new ImageIcon(System.getProperty("user.dir")+"\\"+computer2.get(com2_secim).getClientProperty("kartresmi").toString());
            System.out.println(System.getProperty("user.dir")+"\\"+computer2.get(com2_secim).getClientProperty("kartresmi").toString());
            Savas1.setIcon(icon1);
            Savas2.setIcon(icon2);

            int com1_damage = Integer.valueOf(playerbtn.getClientProperty("saldırıpuan").toString());
            int com2_damage = Integer.valueOf(computer2.get(com2_secim).getClientProperty("saldırıpuan").toString());
            System.out.println(com1_damage+" "+com2_damage);
            if(com1_damage > com2_damage){
                int Puan = Integer.valueOf(Computer_Puan2.getText().toString());
                Computer_Puan2.setText(String.valueOf(Puan+5));
            }
            if(com1_damage < com2_damage){
                int Puan = Integer.valueOf(Computer_Puan1.getText().toString());
                Computer_Puan1.setText(String.valueOf(Puan+5));
            }
            playerbtn.setVisible(false);
            computer2.get(com2_secim).setVisible(false);
        }
        
        
         other_cards = check_other_cards();
        if(other_cards.size() > 0){
            
            int ocard1  = select_card(other_cards);
            ImageIcon icon1 = new ImageIcon(System.getProperty("user.dir")+"\\"+other_cards.get(ocard1).getClientProperty("kartresmi").toString());
            playerbtn.setIcon(icon1);
            
            playerbtn.putClientProperty("kartresmi", other_cards.get(ocard1).getClientProperty("kartresmi").toString());
            playerbtn.putClientProperty("isim", other_cards.get(ocard1).getClientProperty("isim").toString());
            playerbtn.putClientProperty("saldırıpuan", other_cards.get(ocard1).getClientProperty("saldırıpuan").toString());
            other_cards.get(ocard1).setVisible(false);
            other_cards.remove(ocard1);
            playerbtn.setVisible(true);
            
            
            int ocard2  = select_card(other_cards);
            computer2.get(com2_secim).setIcon(other_cards.get(ocard2).getIcon());
            computer2.get(com2_secim).putClientProperty("kartresmi", other_cards.get(ocard2).getClientProperty("kartresmi").toString());
            computer2.get(com2_secim).putClientProperty("isim", other_cards.get(ocard2).getClientProperty("isim").toString());
            computer2.get(com2_secim).putClientProperty("saldırıpuan", other_cards.get(ocard2).getClientProperty("saldırıpuan").toString());
            computer2.get(com2_secim).setVisible(true);
            other_cards.get(ocard2).setVisible(false);
            other_cards.remove(ocard2);

                   
            
        }
                
    }
    
  
    public void islemler(){
        
        ArrayList<Pokemon> pokemons = pokemon_atama();
        ArrayList<JButton> buttons = button_atama(pokemons);
        

    }

    public static ArrayList<JButton> check_cards_comp2(){
        ArrayList<JButton> computer2 = new ArrayList<JButton>();
        if(jButton1.isVisible()){computer2.add(jButton1);}
        if(jButton2.isVisible()){computer2.add(jButton2);}
        if(jButton3.isVisible()){computer2.add(jButton3);}
        return computer2;
    }
     public static ArrayList<JButton> check_other_cards(){
        ArrayList<JButton> others = new ArrayList<JButton>();
        if(jButton7.isVisible()){others.add(jButton7);}
        if(jButton8.isVisible()){others.add(jButton8);}
        if(jButton9.isVisible()){others.add(jButton9);}
        if(jButton10.isVisible()){others.add(jButton10);}
        return others;
   }
    
    public static int select_card(ArrayList<JButton> cards){
        Random rand = new Random();
        int secim = rand.nextInt(cards.size());
        return secim;
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        Savas2 = new javax.swing.JButton();
        Savas1 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Computer_Puan2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Computer_Puan1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1020, 600));
        getContentPane().setLayout(null);

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(280, 10, 75, 110);

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(370, 10, 75, 110);
        getContentPane().add(jButton3);
        jButton3.setBounds(460, 10, 75, 110);

        jButton4.setToolTipText("");
        jButton4.setAlignmentY(0.0F);
        jButton4.setBorderPainted(false);
        jButton4.setName(""); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(280, 400, 75, 110);

        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(370, 400, 75, 110);

        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(460, 400, 75, 110);

        Savas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Savas2ActionPerformed(evt);
            }
        });
        getContentPane().add(Savas2);
        Savas2.setBounds(410, 220, 75, 110);

        Savas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Savas1ActionPerformed(evt);
            }
        });
        getContentPane().add(Savas1);
        Savas1.setBounds(320, 220, 75, 110);
        getContentPane().add(jButton9);
        jButton9.setBounds(120, 230, 50, 80);
        getContentPane().add(jButton10);
        jButton10.setBounds(180, 230, 50, 80);
        getContentPane().add(jButton8);
        jButton8.setBounds(650, 230, 50, 80);
        getContentPane().add(jButton7);
        jButton7.setBounds(590, 230, 50, 80);

        jLabel3.setText("Oyuncu:");
        jLabel3.setToolTipText("");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(680, 450, 80, 40);

        Computer_Puan2.setText("0");
        Computer_Puan2.setToolTipText("");
        getContentPane().add(Computer_Puan2);
        Computer_Puan2.setBounds(740, 450, 70, 40);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bilgisayar:");
        jLabel2.setToolTipText("");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(674, 30, 70, 40);

        Computer_Puan1.setForeground(new java.awt.Color(255, 255, 255));
        Computer_Puan1.setText("0");
        Computer_Puan1.setToolTipText("");
        getContentPane().add(Computer_Puan1);
        Computer_Puan1.setBounds(740, 30, 70, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/prolab/pkg2/battleground.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 830, 540);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 830, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Savas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Savas2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Savas2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void Savas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Savas1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Savas1ActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(() -> {
            new Jpvc(sunum).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    static javax.swing.JLabel Computer_Puan1;
    static javax.swing.JLabel Computer_Puan2;
    static javax.swing.JButton Savas1;
    static javax.swing.JButton Savas2;
    static javax.swing.JButton jButton1;
    static javax.swing.JButton jButton10;
    static javax.swing.JButton jButton2;
    static javax.swing.JButton jButton3;
    static javax.swing.JButton jButton4;
    static javax.swing.JButton jButton5;
    static javax.swing.JButton jButton6;
    static javax.swing.JButton jButton7;
    static javax.swing.JButton jButton8;
    static javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables



   
}
