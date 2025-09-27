package Jeu;

//import java.swing.*;6

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class App {
    public static void main(String[] args) {
        JFrame Fenetre=new JFrame();
        Fenetre.setSize(600,600);
        Casebrique Case=new Casebrique();
        JLabel score=new JLabel("Score : "+Case.getCount());
       // Fenetre.add(score);
        Fenetre.add(Case.getPanel());
        Fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Fenetre.setVisible(true);
    }
}
