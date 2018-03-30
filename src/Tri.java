import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class Tri extends JFrame implements ActionListener {
	
	int j=0;
	int k=0;
	int l=1;
	JButton btnGenerate;
	JButton btnInitAlea;
	JButton btnTri;
	JRadioButton triCroissant;
	JRadioButton triDecroissant;
	JTextField nbrCase;
	JComboBox<String> comboBox;
	JTextField[] arrayTextField  = new JTextField[30];
	int n;
	int h=1;
	JPanel tabPanel;
	boolean test=false;

	public Tri(){
		
		this.setTitle("Tri");
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
		//partie gauche des options
		
		JLabel introLabel = new JLabel("Méthode de tri");
	    introLabel.setBackground(Color.gray);
	    introLabel.setForeground(Color.black);
        introLabel.setBounds(350, 30, 200, 30);
        introLabel.setFont(new Font("Monospaced", Font.BOLD, 11));
        add(introLabel);
		
		
        //comboBox
        comboBox = new JComboBox<String>();
		comboBox.setBounds(350, 63, 130, 20);
		comboBox.addItem("---");
		comboBox.addItem("Tri à bulles");
		comboBox.addItem("Tri par sélection");
		comboBox.addItem("Tri par insertion");
		//comboBox.addItem("Tri rapide");
		add(comboBox);
		
		//boutons radio
		triCroissant = new JRadioButton("Croissant");
		triCroissant.addActionListener(this);
		triDecroissant = new JRadioButton("Décroissant");
		triDecroissant.addActionListener(this);
		ButtonGroup bg = new ButtonGroup();
		triCroissant.setBounds(350, 93, 130, 20);
		triDecroissant.setBounds(350, 123, 130, 20);
		bg.add(triCroissant);
		bg.add(triDecroissant);
		add(triCroissant);
		add(triDecroissant);

		/****************************************************************/
	    //Séparateur
		
		ImageIcon icon = null;
	    try {
			icon= new ImageIcon(ImageIO.read(new File("C:/Users/ASUS/Pictures/séparateur.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel separateur = new JLabel(icon);
		separateur.setBounds(500, 40, 7, 150);
		add(separateur);
		
		/****************************************************************/
		//partie droite des options
		
		JLabel introLabe2 = new JLabel("Nombre de case");
	    introLabe2.setBackground(Color.gray);
	    introLabe2.setForeground(Color.black);
        introLabe2.setBounds(530, 30, 200, 30);
        introLabe2.setFont(new Font("Monospaced", Font.BOLD, 11));
        add(introLabe2);
        
        //nbr de case
        nbrCase = new JTextField();
        nbrCase.setBounds(530, 63, 20, 20);
		add(nbrCase);
		
		//bouton de generation du tableau non initialiser
		btnGenerate = new JButton("Générer");
		btnGenerate.setFont(new Font("Monospaced", Font.BOLD, 11));
        btnGenerate.setBounds(560, 63, 90, 20);
        btnGenerate.addActionListener(this);
	    add(btnGenerate);
		
	    //bouton d'initialisation aléatoire
	    btnInitAlea = new JButton("Init aléatoire");
	    btnInitAlea.setFont(new Font("Monospaced", Font.BOLD, 10));
	    btnInitAlea.setBounds(530, 98, 120, 20);
	    btnInitAlea.addActionListener(this);
	    add(btnInitAlea);
	    
	    ////bouton de Tri
	    btnTri = new JButton("Tri");
	    btnTri.setFont(new Font("Monospaced", Font.BOLD, 12));
	    btnTri.setBounds(530, 140, 120, 30);
	    btnTri.addActionListener(this);
	    add(btnTri);

		/****************************************************************/
		//panel audessous
	    
		tabPanel = new JPanel();
		tabPanel.setBounds(65, 253, 600, 200);
		tabPanel.setBackground(Color.WHITE);
		tabPanel.setVisible(true);
		add(tabPanel);
	    
	}

	public void actionPerformed(ActionEvent e) {
		if(triCroissant.isSelected()){
			h=1;
			if(n!=0){
			for(int i=0;i<n;i++){
			arrayTextField[i].setBackground(Color.white);	
			}
			}
		}
		if(triDecroissant.isSelected()){
			h=1;
			if(n!=0){
			for(int i=0;i<n;i++){
			arrayTextField[i].setBackground(Color.white);	
			}
			}
		}
		
		//séléction du bouton de génération des cases
		if ((JButton)e.getSource()==btnGenerate){
			h=1;
			int i;
			int x=77;
			int z=77;
			int y=77;
			boolean test2=true;
			
			if(nbrCase.getText().equals("")){
				JOptionPane.showMessageDialog(null,"Veuillez entrer s'il vous plait un entrier entre 1 et 30 ","Nombre de case!",JOptionPane.WARNING_MESSAGE);
			}
			
			if(n!=0){
				for(i=0;i<n;i++) {
					arrayTextField[i].setVisible(false);
				}
			}
			
			//controle de saisie sur la case nbrCase
			if(!nbrCase.getText().equals("")){
				try
				{
				Integer.parseInt(nbrCase.getText());
				}
				catch (NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null,"Veuillez entrer s'il vous plait un entrier entre 1 et 30 ","Nombre de case!",JOptionPane.WARNING_MESSAGE);
				}
				if ((0<Integer.parseInt(nbrCase.getText()))&&(Integer.parseInt(nbrCase.getText())<=30)) {
				
				n=Integer.parseInt(nbrCase.getText()); 
				test=true;
				test2 = true;
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Veuillez entrer s'il vous plait un entrier entre 1 et 30 ","Nombre de case!",JOptionPane.WARNING_MESSAGE);
				}
			
				for(i=0;i<n;i++) {
						arrayTextField[i] = new JTextField();
						if(i<10){
							arrayTextField[i].setBounds(x, 274, 40, 40); 
							x+=60; }
						else if ((10<=i)&&(i<20)) {
							arrayTextField[i].setBounds(z, 334, 40, 40); 
							z+=60; }
						else if ((20<=i)&&(i<30)) {
							arrayTextField[i].setBounds(y, 394, 40, 40); 
							y+=60; }
						arrayTextField[i].setText("");
						add(arrayTextField[i]);
					}repaint();
			}
			
		}
		
		//séléction du bouton d'initialisation aléatoire
		if ((JButton)e.getSource()==btnInitAlea){
			if(nbrCase.getText().equals("")){
				JOptionPane.showMessageDialog(null,"Veuillez entrer s'il vous plait un entrier entre 1 et 30 ","Nombre de case!",JOptionPane.WARNING_MESSAGE);
			}
			else if(test==false){	
				JOptionPane.showMessageDialog(null,"Veuillez s'il vous plait générer des cases ","Génération des cases!",JOptionPane.WARNING_MESSAGE);
			}
			else if(test==true){
			int i;
			k=0;
			l=1;
			n=Integer.parseInt(nbrCase.getText());
				for(i=0;i<n;i++) {
					Random randomGenerator = new Random();
					int randomInt = randomGenerator.nextInt(100);
					arrayTextField[i].setText(randomInt+"");
					//System.setProperty("myColor2", "0x99CCFF");
					//arrayTextField[i].setBackground(Color.getColor("myColor"));
					add(arrayTextField[i]);
					}
				repaint();	
			}
		}
		
		//séléction du bouton de tri
		if ((JButton)e.getSource()==btnTri){
			
			//Controle de saisie sur le nombre de case
			if(nbrCase.getText().equals("")){
				JOptionPane.showMessageDialog(null,"Veuillez entrer s'il vous plait un entrier entre 1 et 30 ","Nombre de case!",JOptionPane.WARNING_MESSAGE);
			}
			else if((n==0)){	
				JOptionPane.showMessageDialog(null,"Veuillez s'il vous plait générer des cases ","Génération des cases!",JOptionPane.WARNING_MESSAGE);
			}
			else n=Integer.parseInt(nbrCase.getText());
			
			//Controle de saisie sur la méthode de tri
			String typeDeTri1=(String) comboBox.getSelectedItem();
			if(typeDeTri1.equals("---")){
				JOptionPane.showMessageDialog(null,"Veuillez choisir s'il vous plait la méthode de tri  ","Méthode de tri!",JOptionPane.WARNING_MESSAGE);
			}
			
			//Controle de saisie sur l'ordre de tri
			if(!triCroissant.isSelected()&&!triDecroissant.isSelected()){
				JOptionPane.showMessageDialog(null,"Veuillez choisir s'il vous plait l'ordre de tri  ","Ordre de tri!",JOptionPane.WARNING_MESSAGE);
			}
			
			

			//controle de saisie sur les cases
			boolean test2=true;
			boolean test3=true;
			for(int c=0;c<n;c++){

				if(arrayTextField[c].getText().equals("")){
					test3=false;
				}else {
					try
					{
					Integer.parseInt(arrayTextField[c].getText());
					}
					catch (NumberFormatException ex)
					{
						test2=false;
					}
				}
			}
			if(test3==false){
				JOptionPane.showMessageDialog(null,"Veuillez remplir tous les cases","Contenu des cases!",JOptionPane.WARNING_MESSAGE);
			}
			if(test2==false){
				JOptionPane.showMessageDialog(null,"Veuillez entrer des entiers valables","Contenu des cases!",JOptionPane.WARNING_MESSAGE);
			}
			
			//récupération du type de tri
			for(int i=0;i<n;i++){
				if(typeDeTri1.equals("---")){
					
				}
				else if(!triCroissant.isSelected()&&!triDecroissant.isSelected()){
				}
				
			}
			String typeDeTri=(String) comboBox.getSelectedItem();
			if (typeDeTri=="Tri à bulles"){
				if (triCroissant.isSelected()){
					//récupération du type de tri croissant ou décroissant
				int i=0;
				JTextField tmp= new JTextField();
				int a=0;
	    		int b=0;
	    		
	    		
					    if(i<n){
					    	if(j<n-1){
					    		a=Integer.parseInt(arrayTextField[j].getText());
					    		b=Integer.parseInt(arrayTextField[j+1].getText());
					    		if (a>b){
					    			System.setProperty("myColor3", "0x99C11EE");
									arrayTextField[j].setBackground(Color.getColor("myColor3"));
									arrayTextField[j+1].setBackground(Color.getColor("myColor3"));
					            	 tmp.setText(arrayTextField[j].getText()); 
							         arrayTextField[j].setText(arrayTextField[j+1].getText());
							         
							         arrayTextField[j+1].setText(tmp.getText());  
					             }
					    	}
					    	j++;
					    	if(j==n) j=0;
					    }
					    i++;
					    boolean test=true;
					    int z;
					    for(z=0;z<n-1;z++){
					    	a=Integer.parseInt(arrayTextField[z].getText());
				    		b=Integer.parseInt(arrayTextField[z+1].getText());
				    		if (a>b){
				    			test=false;
					    	}
				    		if((test==true)&&(z==n-2)){
				    	System.setProperty("myColor2", "0x99CCFF");
				    	for(int k=0;k<n;k++){
						arrayTextField[k].setBackground(Color.getColor("myColor2"));}
		    			JOptionPane.showMessageDialog(null,"Tri términé ","Fin du tri!",JOptionPane.WARNING_MESSAGE);
				    	}
					    }
				}
				if (triDecroissant.isSelected()){

					int i=0;
					JTextField tmp= new JTextField();
					int a=0;
		    		int b=0;
		    		
		    		if(i<n){
				    	if(j<n-1){
				    		a=Integer.parseInt(arrayTextField[j].getText());
				    		b=Integer.parseInt(arrayTextField[j+1].getText());
				    		if (a<b){
				            	 tmp.setText(arrayTextField[j].getText()); 
						         arrayTextField[j].setText(arrayTextField[j+1].getText());
						         arrayTextField[j+1].setText(tmp.getText());  
				             }
				    	}
				    	j++;
				    	if(j==n) j=0;
				    }
				    i++;    
				    boolean test=true;
				    int z;
				    for(z=0;z<n-1;z++){
				    	a=Integer.parseInt(arrayTextField[z].getText());
			    		b=Integer.parseInt(arrayTextField[z+1].getText());
			    		if (a<b){
			    			test=false;
				    	}
			    		if((test==true)&&(z==n-2)){
			    	System.setProperty("myColor2", "0x99CCFF");
			    	for(int k=0;k<n;k++){
					arrayTextField[k].setBackground(Color.getColor("myColor2"));}
	    			JOptionPane.showMessageDialog(null,"Tri términé ","Fin du tri!",JOptionPane.WARNING_MESSAGE);
			    	}
				    }
				}
			}
		}
		if ((JButton)e.getSource()==btnTri){
			//récupération du type de tri
			String typeDeTri=(String) comboBox.getSelectedItem();
			if (typeDeTri=="Tri par sélection"){
				if (triCroissant.isSelected()){
					//récupération du type de tri croissant ou décroissant
					
				int j;
				JTextField tmp= new JTextField();
				int a=0;
	    		int b=0;
	    		int min;
	    		
	    		
	    		for(int k=0;k<n;k++){
			    	min=k;
			    	for(j=k+1;j<n;j++){
			    		a=Integer.parseInt(arrayTextField[j].getText());
			    		b=Integer.parseInt(arrayTextField[min].getText());
			    		if(a<b){
			    			min=j;
			    		}
			    	}
			    	if(min!=k){
			    		 tmp.setText(arrayTextField[k].getText()); 
				         arrayTextField[k].setText(arrayTextField[min].getText());
				         arrayTextField[min].setText(tmp.getText());
			    	}
			    }   
	    		
	    		
					    k++;
					    boolean test=true;
					    int z;
					    for(z=0;z<n-1;z++){
					    	a=Integer.parseInt(arrayTextField[z].getText());
				    		b=Integer.parseInt(arrayTextField[z+1].getText());
				    		if (a>b){
				    			test=false;
					    	}
				    		if((test==true)&&(z==n-2)){
				    	System.setProperty("myColor2", "0x99CCFF");
				    	for(int c=0;c<n;c++){
						arrayTextField[c].setBackground(Color.getColor("myColor2"));}
		    			JOptionPane.showMessageDialog(null,"Tri términé ","Fin du tri!",JOptionPane.WARNING_MESSAGE);
				    	}
					    }
				}
				if (triDecroissant.isSelected()){
					
					if(k>=n){
						k=0;
					}
					int j;
					JTextField tmp= new JTextField();
					int a=0;
		    		int b=0;
		    		int min;
						    if(k<n){
						    	min=k;
						    	for(j=k+1;j<n;j++){
						    		a=Integer.parseInt(arrayTextField[j].getText());
						    		b=Integer.parseInt(arrayTextField[min].getText());
						    		if(a>b){
						    			min=j;
						    		}
						    	}
						    	if(min!=k){
						    		 tmp.setText(arrayTextField[k].getText()); 
							         arrayTextField[k].setText(arrayTextField[min].getText());
							         arrayTextField[min].setText(tmp.getText());
						    	}
						    }     
						    k++;
						    boolean test=true;
						    int z;
						    for(z=0;z<n-1;z++){
						    	a=Integer.parseInt(arrayTextField[z].getText());
					    		b=Integer.parseInt(arrayTextField[z+1].getText());
					    		if (a<b){
					    			test=false;
						    	}
					    		if((test==true)&&(z==n-2)){
					    	System.setProperty("myColor2", "0x99CCFF");
					    	for(int k=0;k<n;k++){
							arrayTextField[k].setBackground(Color.getColor("myColor2"));}
			    			JOptionPane.showMessageDialog(null,"Tri términé ","Fin du tri!",JOptionPane.WARNING_MESSAGE);
					    	}
						    }
					}
			}
		}

		if ((JButton)e.getSource()==btnTri){
			//récupération du type de tri
			String typeDeTri=(String) comboBox.getSelectedItem();
			if (typeDeTri=="Tri par insertion"){
				if (triCroissant.isSelected()){
					//récupération du type de tri croissant ou décroissant
					int elt,j;
					JTextField tmp= new JTextField();
					while(h<n){
						elt = Integer.parseInt(arrayTextField[h].getText());
						j=h-1;
						while((j>=0)&&(Integer.parseInt(arrayTextField[j].getText())>elt)){
							arrayTextField[j+1].setText(arrayTextField[j].getText());
							j--;
						}
						arrayTextField[j+1].setText(""+elt);
						h++;
					}
					boolean test=true;
				    int z;
				    int a,b;
				    for(z=0;z<n-1;z++){
				    	a=Integer.parseInt(arrayTextField[z].getText());
			    		b=Integer.parseInt(arrayTextField[z+1].getText());
			    		if (a>b){
			    			test=false;
				    	}
			    		if((test==true)&&(z==n-2)){
			    	System.setProperty("myColor2", "0x99CCFF");
			    	for(int k=0;k<n;k++){
					arrayTextField[k].setBackground(Color.getColor("myColor2"));}
	    			JOptionPane.showMessageDialog(null,"Tri términé ","Fin du tri!",JOptionPane.WARNING_MESSAGE);
			    	}
				    }
				}
			}
				if (triDecroissant.isSelected()){

					int elt,i,j;
					JTextField tmp= new JTextField();
					while(h<n){
						elt = Integer.parseInt(arrayTextField[h].getText());
						j=h-1;
						while((j>=0)&&(Integer.parseInt(arrayTextField[j].getText())<elt)){
							arrayTextField[j+1].setText(arrayTextField[j].getText());
							j--;
						}
						arrayTextField[j+1].setText(""+elt);
						h++;
					}
					boolean test=true;
				    int z;
				    int a,b;
				    for(z=0;z<n-1;z++){
				    	a=Integer.parseInt(arrayTextField[z].getText());
			    		b=Integer.parseInt(arrayTextField[z+1].getText());
			    		if (a<b){
			    			test=false;
				    	}
			    		if((test==true)&&(z==n-2)){
			    	System.setProperty("myColor2", "0x99CCFF");
			    	for(int k=0;k<n;k++){
					arrayTextField[k].setBackground(Color.getColor("myColor2"));}
	    			JOptionPane.showMessageDialog(null,"Tri términé ","Fin du tri!",JOptionPane.WARNING_MESSAGE);
			    	}
				    }
			}
		}
		
		/*if ((JButton)e.getSource()==btnTri){
			//récupération du type de tri
			String typeDeTri=(String) comboBox.getSelectedItem();
			if (typeDeTri=="Tri rapide"){
				if (triDecroissant.isSelected()){
					//récupération du type de tri croissant ou décroissant
					triRapideDecroissante(1, n-1);}
				if (triCroissant.isSelected()){
					//récupération du type de tri croissant ou décroissant
					triRapideCroissante(1, n-1);}
				    }
				}
		}
		
		
	
	   public void triRapideCroissante(int debut, int fin)
	   {
	       int gauche = debut-1;
	       int droite = fin+1;
	       JTextField tmp= new JTextField();
	       int pivot =Integer.parseInt(arrayTextField[debut].getText());
	       if(debut >= fin)
	           return;
	       while(true)
	       {
	           do droite--; while(Integer.parseInt(arrayTextField[droite].getText()) > pivot);
	           do gauche++; while(Integer.parseInt(arrayTextField[gauche].getText()) < pivot);

	           if(gauche < droite){
	           tmp.setText(arrayTextField[droite].getText()); 
	           arrayTextField[droite].setText(arrayTextField[gauche].getText());
	           arrayTextField[gauche].setText(tmp.getText());  }
	           else break;
	       }
	       triRapideCroissante(debut, droite);
	       triRapideCroissante(droite+1, fin);
	   }
	       public void triRapideDecroissante(int debut, int fin)
	   {
	       int gauche = debut-1;
	       int droite = fin+1;
	       JTextField tmp= new JTextField();
	       int pivot =Integer.parseInt(arrayTextField[debut].getText());
	       if(debut >= fin)
	           return;
	       while(true)
	       {
	           do droite--; while(Integer.parseInt(arrayTextField[droite].getText()) < pivot);
	           do gauche++; while(Integer.parseInt(arrayTextField[gauche].getText()) > pivot);

	           if(gauche < droite){
	           tmp.setText(arrayTextField[droite].getText()); 
	           arrayTextField[droite].setText(arrayTextField[gauche].getText());
	   		   arrayTextField[gauche].setText(tmp.getText());  }
	           else break;
	       }
	       triRapideDecroissante(debut, droite);
	       triRapideDecroissante(droite+1, fin);
	   }*/
}}