package Jeu;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.JavaBean;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import part1.Boule;
import part1.Plateforme;
import part2.Brique;

public class Casebrique{
	public Boule getB() {
		return B;
	}
	/*public Brique getBI() {
		return BI;
	}*/
	public Plateforme getP() {
		return P;
	}
	public JPanel getPanel() {
		return Panel;
	}
	private Boule B;
	private List<Brique> BI;
	private Plateforme P;
	private JPanel Panel;
	private Timer timer;
	private int count;
	private JLabel label;
	private JButton Jb;
	private Boolean gameover;
	public int getCount() {
		return count;
	}
	/*private int bouleDx=2;
	private int bouleDy=2;*/
	public Casebrique(){
		this.B=new Boule(100,500,1 );
		this.count=0;
		this.gameover=false;
		this.P=new Plateforme(1,1);
		label=new JLabel();
		this.BI=new ArrayList<>();
		Jb=new JButton("Game Over");
		Jb.setVisible(false);
		for(int i=0;i<10;++i){
			for(int j=0;j<10;++j)
			{
				BI.add(new Brique(60*i, 30*j));
			}
		}
	
		
		Jb.setBounds(200,150,100,30);
		this.Panel=new JPanel(){
			public void paint(Graphics g){
				super.paint(g);
				
				//couleur de la balle
				Graphics2D g2=(Graphics2D) g;
				
				
				g2.setColor(Color.BLUE);
				g2.fillOval(B.getX(), B.getY(), 15, 15);
			
				//creation plate forme
				g2.setColor(Color.ORANGE);
				g2.fillRect(P.getL(),P.getl(),60,20);

				//creation des briques
				
				for(int k=0;k<BI.size();++k)
				{
					g2.setColor(Color.BLACK);
					g2.fillRect(BI.get(k).getL(),BI.get(k).getl(),40,10);
				}
			}
		};

	///Traiter le focus sur le plateforme et ajuster sa position tout en bas de la fenetre                                                                
		this.Panel.setFocusable(true);
		this.Panel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int panelHeight = Panel.getHeight();
				P.setl(panelHeight - 10); // Ajuster la position 'y' pour qu'elle soit collée au bas
				Panel.repaint();
			}
		});
		this.P = new Plateforme(100, Panel.getHeight() - 10);
		this.Panel.addKeyListener(new KeyListener() {
		@Override
		public void keyPressed(KeyEvent event) {
			// TODO Auto-generated method stub
			//throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
			switch(event.getKeyCode()){

				case KeyEvent.VK_LEFT:
					P.setL(P.getL()-10);
					break;
				case KeyEvent.VK_RIGHT:
					P.setL(P.getL()+10);
					break;
			}
			Panel.repaint();
		}

		@Override
		public void keyReleased(KeyEvent event) {
			// TODO Auto-generated method stub
			//throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
		
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			//throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
		}
	
	});
	
	this.Panel.requestFocusInWindow();
	this.timer=new Timer(10, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			B.setX(B.getVd()+B.getX());
			B.setY(B.getVg()+B.getY());
			
			//verifier les collisions avec les bords et inverser la direction
			if(B.getX()<0 || B.getX()+B.getRayon()>=Panel.getWidth()){
				B.setVd(-B.getVd());
			}
			if (B.getY() + B.getRayon() >= P.getl() &&
            B.getX() + B.getRayon() >= P.getL() &&
            B.getX() <= P.getL() + 60) {
            B.setVg(-B.getVg());  // Inverser la direction verticale
			
        }
		if(B.getY()<=0){
			B.setVg(-B.getVg());
		}
		 // Vérifier si la boule tombe sous la plateforme (perte de la balle)
		 if(B.getY()+B.getRayon()>=Panel.getHeight()){
			gameover=true;
			//timer.stop();

		 }
		else{
			Iterator<Brique> I=BI.iterator();
			while(I.hasNext()){
				Brique brique=I.next();
				if(B.getY()+B.getRayon()>=brique.getl() && B.getY()<brique.getl()+10 && B.getX()+B.getRayon()>=brique.getL() && B.getX()<brique.getL()+40)
				{
					B.setVg(-B.getVg());
					I.remove();
					++count;
					break;
				}
			}
			//Panel.repaint();
			label.setText("Score du joueur :"+count);
		}
       
		
		
		Panel.repaint();
		}
		
	});
	this.Panel.setLayout(null);
	this.Panel.add(label);
	if(gameover){
		//g2.setColor(Color.RED);
		//g2.drawString("Game Over",200, 150);
		Jb.setVisible(true);
	}
	
	this.timer.start();
	//faire rebondir le ballon et faire les cas d'arrets du jeu




	}
	




}