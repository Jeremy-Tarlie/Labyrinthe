package Labyrinthe;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyWindows extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final int SIZE = 50; // Taille des carrés
    // 0 = vide
 	// 1 = mur
 	// 2 = départ
 	// 3 = arrivée
 	// 4 = joueur
 	private static int[][] map = {
 	        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
 	        {1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
 	        {1, 0, 1, 1, 0, 1, 1, 1, 0, 3},
 	        {1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
 	        {1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
 	        {1, 1, 0, 0, 0, 1, 0, 0, 1, 1},
 	        {1, 0, 0, 1, 0, 1, 1, 0, 0, 1},
 	        {1, 0, 1, 0, 0, 1, 0, 1, 0, 1},
 	        {2, 4, 1, 0, 1, 0, 0, 0, 0, 1},
 	        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
 	    };
 	public static boolean firstTime = true;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dessiner le labirynthe avec des carrées
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
            	g.setColor(Color.BLACK);
            	int x = i * SIZE;
            	int y = j * SIZE;
            	if(map[j][i] == 1) {            		
            		g.fillRect(x, y, SIZE, SIZE);
            	} else if (map[j][i] == 2) {
            		g.setColor(Color.GREEN);
            		g.fillRect(x, y, SIZE, SIZE);
            	}else if (map[j][i] == 3) {
            		g.setColor(Color.RED);
            		g.fillRect(x, y, SIZE, SIZE);
            	}else if (map[j][i] == 4) {
            		g.setColor(Color.GRAY);
            		g.fillRect(x, y, SIZE, SIZE);
            	}
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 600); // Définir la taille préférée du JPanel
    }

    public static void main(String[] args) {
    	 JFrame frame = new JFrame("Carrés Noirs");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         // Créer les boutons de direction
         JButton upButton = new JButton("Haut");
         JButton downButton = new JButton("Bas");
         JButton leftButton = new JButton("Gauche");
         JButton rightButton = new JButton("Droite");

         // Créer un JPanel pour les boutons de direction
         JPanel buttonPanel = new JPanel(new GridLayout(2,2));
         buttonPanel.add(upButton);
         buttonPanel.add(downButton);
         buttonPanel.add(leftButton);
         buttonPanel.add(rightButton);
         
         // Redimensionnement des boutons
         upButton.setPreferredSize(new Dimension(100, 50));
         downButton.setPreferredSize(new Dimension(100, 50));
         leftButton.setPreferredSize(new Dimension(100, 50));
         rightButton.setPreferredSize(new Dimension(100, 50));
         
         
         upButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						if(map[j][i] == 4 && map[j-1][i] != 1) {
							if(map[j-1][i] == 3) {
								JOptionPane.showMessageDialog(null, "Vous avez gagné ! Félicitations !", "Victoire", JOptionPane.INFORMATION_MESSAGE);
							} else {								
								map[j][i] = 0;
								map[j-1][i] = 4;
							}
						}
					}
				}
                 frame.repaint();
             }
             
         });

         downButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
            	 for (int i = 0; i < 10; i++) {
 					for (int j = 0; j < 10; j++) {
 						if(map[j][i] == 4 && map[j+1][i] != 1 && firstTime) {
 							if(map[j+1][i] == 3) {
 	  							JOptionPane.showMessageDialog(null, "Vous avez gagné ! Félicitations !", "Victoire", JOptionPane.INFORMATION_MESSAGE);
 	  						} else { 	  							
 	  							map[j][i] = 0;
 	  							map[j+1][i] = 4;
 	  							firstTime = false;
 	  						}
 						}
 					}
 				}
            	 frame.repaint();
            	 firstTime = true;
             }
         });

         leftButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
            	 for (int i = 0; i < 10; i++) {
 					for (int j = 0; j < 10; j++) {
 						if(map[j][i] == 4 && map[j][i-1] != 1) {
 							if(map[j][i-1] == 3) {
 	  							JOptionPane.showMessageDialog(null, "Vous avez gagné ! Félicitations !", "Victoire", JOptionPane.INFORMATION_MESSAGE);
 	  						} else { 	  							
 	  							map[j][i] = 0;
 	  							map[j][i-1] = 4;
 	  						}
 						}
 					}
 				}
            	 frame.repaint();
             }
         });

         rightButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
            	 for (int i = 0; i < 10; i++) {
  					for (int j = 0; j < 10; j++) {
  						if(map[j][i] == 4 && map[j][i+1] != 1 && firstTime) {
  							if(map[j][i+1] == 3) {
  	  							JOptionPane.showMessageDialog(null, "Vous avez gagné ! Félicitations !", "Victoire", JOptionPane.INFORMATION_MESSAGE);
  	  						} else {  	  							
  	  							map[j][i] = 0;
  	  							map[j][i+1] = 4;
  	  							firstTime = false;
  	  						}
  						}
  					}
  				}
            	 frame.repaint();
            	 firstTime = true;
             }
         });

         // Ajouter le JPanel des boutons de direction et le JPanel des carrés noirs à la fenêtre
         frame.getContentPane().setLayout(new FlowLayout());
         frame.getContentPane().add(buttonPanel);
         frame.getContentPane().add(new MyWindows());

         frame.pack();
         frame.setVisible(true);
    }
}
