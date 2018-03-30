import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Fenetre extends JFrame implements ActionListener {

	public Fenetre() {
		
		this.setTitle("Accueil");
	    this.setSize(720, 520);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	    this.setResizable(false);
	    this.setLayout(null);
	    this.setLocationRelativeTo(null);
	    
    	try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:/Users/ASUS/Pictures/test.png")))));
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
    	/****************************************************************/
        //bouton Début
    	
        JButton btnStart = new JButton("Début");
        btnStart.setBounds(70, 340, 200, 100);
        btnStart.addActionListener(this);
	    add(btnStart);
	    ImageIcon icon = null;
	    try {
			icon= new ImageIcon(ImageIO.read(new File("C:/Users/ASUS/Pictures/btnDebut.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	    btnStart.setIcon(icon);
	    
    	/****************************************************************/
	    
	    //zone texte
	    JLabel introLabel = new JLabel("Avec ce programme vous pouvez ");
	    JLabel introLabe2 = new JLabel("triez les nombres de vos choix,");
	    JLabel introLabe3 = new JLabel("avec un choix de cinq types de ");
	    JLabel introLabe4 = new JLabel("tries aussi que le tri croissant");
	    JLabel introLabe5 = new JLabel("et décroissant.");
	    introLabel.setBackground(Color.gray);
	    introLabel.setForeground(Color.black);
        introLabel.setBounds(340, 5, 480, 90);
        introLabel.setFont(new Font("Monospaced", Font.BOLD, 16));
        add(introLabel);
        introLabe2.setBackground(Color.gray);
	    introLabe2.setForeground(Color.black);
        introLabe2.setBounds(340, 20, 480, 125);
        introLabe2.setFont(new Font("Monospaced", Font.BOLD, 16));
        add(introLabe2);
        introLabe3.setBackground(Color.gray);
	    introLabe3.setForeground(Color.black);
        introLabe3.setBounds(340, 35, 480, 160);
        introLabe3.setFont(new Font("Monospaced", Font.BOLD, 16));
        add(introLabe3);
        introLabe4.setBackground(Color.gray);
	    introLabe4.setForeground(Color.black);
        introLabe4.setBounds(340, 50, 480, 195);
        introLabe4.setFont(new Font("Monospaced", Font.BOLD, 16));
        add(introLabe4);
        introLabe5.setBackground(Color.gray);
	    introLabe5.setForeground(Color.black);
        introLabe5.setBounds(340, 65, 480, 230);
        introLabe5.setFont(new Font("Monospaced", Font.BOLD, 16));
        add(introLabe5);
        
        /****************************************************************/
        
	}
	
	//actionPerformed du bouton Début
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
		Tri nouveauTri=new Tri();
		nouveauTri.setVisible(true);
	}
}
