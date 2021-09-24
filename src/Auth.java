import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.border.MatteBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Auth extends JFrame {

	private JPanel contentPane;
	PreparedStatement preparedStatement=null;
	Connection cnx=null;
	ResultSet resultat=null;
	PreparedStatement preparedStatement1=null;
	Connection cnx1=null;
	ResultSet resultat1=null;
	PreparedStatement preparedStatement2=null;
	Connection cnx2=null;
	ResultSet resultat2=null;
	PreparedStatement preparedStatement3=null;
	Connection cnx3=null;
	ResultSet resultat3=null;
	private JTextField username1DD;
	private JPasswordField password1DD;
	private JRadioButton rdbtnBanqueDeSang;
	private JRadioButton rdbtnMedecin;
	private JRadioButton rdbtnDonneurdemandeur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new NimbusLookAndFeel());
					Auth frame = new Auth();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Auth() {
		super("Authentification");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608,450);
		super.setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ImageIcon obj1 = new ImageIcon("C:\\Users\\Belinfo\\OneDrive\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\transfuse_38039.png");
		super.setIconImage(obj1.getImage());
		setContentPane(contentPane);
		contentPane.setLayout(null);
		cnx=ConnexionMySql.ConnectionDB();
		
		JLabel label_1 = new JLabel("BlooNation");
		label_1.setFont(new Font("Lucida Handwriting", Font.BOLD | Font.ITALIC, 21));
		label_1.setBounds(10, 13, 154, 39);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("by AmineYK");
		label_2.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		label_2.setBounds(124, 44, 88, 14);
		contentPane.add(label_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 255));
		panel.setBounds(10, 63, 203, 7);
		contentPane.add(panel);
		
		JLabel label_3 = new JLabel("La vie , on a  \u00E7a dans le sang  ");
		label_3.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 17));
		label_3.setBounds(10, 118, 284, 48);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\blood_testing_bloods_transfusion_coronavirus_icon_141483.png"));
		label_4.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 17));
		label_4.setBounds(72, 162, 145, 145);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Partageons-la en donnant");
		label_5.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 19));
		label_5.setBounds(10, 301, 274, 48);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\blood_medical_18050.png"));
		label_6.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 17));
		label_6.setBounds(106, 350, 64, 57);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Amine YK");
		label_7.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 13));
		label_7.setBounds(172, 428, 74, 14);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("All @ Rights Reserved ");
		label_8.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		label_8.setBounds(36, 428, 145, 14);
		contentPane.add(label_8);
		JLabel label_13 = new JLabel("Username ");
		label_13.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_13.setBounds(374, 206, 79, 26);
		contentPane.add(label_13);
		
		username1DD = new JTextField();
		username1DD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				if(key==10){
					password1DD.requestFocus();
				}
			}
		});
		username1DD.setForeground(Color.BLACK);
		username1DD.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		username1DD.setColumns(16);
		username1DD.setBackground(new Color(184, 54, 52));
		username1DD.setBounds(374, 239, 155, 26);
		contentPane.add(username1DD);
		
		JLabel label_14 = new JLabel("Password");
		label_14.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_14.setBounds(374, 284, 79, 26);
		contentPane.add(label_14);
		
		password1DD = new JPasswordField();
		password1DD.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		password1DD.setColumns(16);
		password1DD.setBackground(new Color(184, 54, 52));
		password1DD.setBounds(374, 315, 155, 26);
		contentPane.add(password1DD);
		
		JButton button_1 = new JButton("Se Connecter");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button_1.setBackground(new Color(253,198,197));
				button_1.setForeground(Color.BLACK);
			}	
			public void mouseExited(MouseEvent e) {
				button_1.setBackground(new Color(184,54,52));
				button_1.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!rdbtnDonneurdemandeur.isSelected() && !rdbtnBanqueDeSang.isSelected() && !rdbtnMedecin.isSelected()){
					JOptionPane.showMessageDialog(null,"Vous etes qui ?? -__' ?");
				}else{
				if(rdbtnDonneurdemandeur.isSelected()){
				String sql="select * from donneur";
				String sql1="truncate donneurconnecte";
				String sql2="insert into donneurconnecte (nomdonneurconnecte ,prenomdonneurconnecte) values (? , ? )";
				String sql3="select * from donneur where username='"+username1DD.getText().toString()+"'";
				String nom=null;
				String prenom=null;
				int a=0;
				if(username1DD.getText().equals("") || password1DD.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Remplissez le(s) champ(s) vide(s) ! ");
				}else{
					try {	
						preparedStatement=cnx.prepareStatement(sql);
						resultat=preparedStatement.executeQuery();
						while(resultat.next()){
							if(resultat.getString("username").equals(username1DD.getText()) && resultat.getString("password").equals(password1DD.getText())){
								
								cnx1=ConnexionMySql.ConnectionDB();
								preparedStatement1=cnx1.prepareStatement(sql3);
								resultat1=preparedStatement1.executeQuery();
								if(resultat1.next()){
									nom=resultat1.getString("nomdonneur");
									prenom=resultat1.getString("prenomdonneur");
								}
								cnx2=ConnexionMySql.ConnectionDB();
								preparedStatement2=cnx2.prepareStatement(sql1);
								preparedStatement2.execute();
								cnx3=ConnexionMySql.ConnectionDB();
								preparedStatement3=cnx3.prepareStatement(sql2);
								preparedStatement3.setString(1,nom);
								preparedStatement3.setString(2,prenom);
								preparedStatement3.execute();
								FenDonneurDemandeur obj = new FenDonneurDemandeur();
								obj.setLocationRelativeTo(null);
								obj.setVisible(true);
								dispose();
								a=1;
							}}
						if(a==0){
							JOptionPane.showMessageDialog(null,"Username Introuvable ou password Incorrecte !! ");
							}
						}
						
					catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}	
			}
				if(rdbtnMedecin.isSelected()){
					String sql="select * from medecin";
					String sql1="truncate medecinconnecte";
					String sql2="insert into medecinconnecte ( nom ,prenom ) values (? , ? )";
					String sql3="select * from medecin where username='"+username1DD.getText().toString()+"'";
					String nom=null;
					String prenom=null;
					int a=0;
					if(username1DD.getText().equals("") || password1DD.getText().equals("")){
						JOptionPane.showMessageDialog(null,"Remplissez le(s) champ(s) vide(s) ! ");
					}else{
						try {	
							preparedStatement=cnx.prepareStatement(sql);
							resultat=preparedStatement.executeQuery();
							while(resultat.next()){
								if(resultat.getString("username").equals(username1DD.getText()) && resultat.getString("password").equals(password1DD.getText())){
									
									cnx1=ConnexionMySql.ConnectionDB();
									preparedStatement1=cnx1.prepareStatement(sql3);
									resultat1=preparedStatement1.executeQuery();
									if(resultat1.next()){
										nom=resultat1.getString("nommedecin");
										prenom=resultat1.getString("prenommedecin");
									}
									cnx2=ConnexionMySql.ConnectionDB();
									preparedStatement2=cnx2.prepareStatement(sql1);
									preparedStatement2.execute();
									cnx3=ConnexionMySql.ConnectionDB();
									preparedStatement3=cnx3.prepareStatement(sql2);
									preparedStatement3.setString(1,nom);
									preparedStatement3.setString(2,prenom);
									preparedStatement3.execute();
									FenMedecin obj = new FenMedecin();
									obj.setLocationRelativeTo(null);
									obj.setVisible(true);
									dispose();
									a=1;
								}}
							if(a==0){
								JOptionPane.showMessageDialog(null,"Username Introuvable ou password Incorrecte !! ");
								}
							}
							
						catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}	
				}
				if(rdbtnBanqueDeSang.isSelected()){
					String sql="select * from banquesang";
					String sql1="truncate banquesangconnecte";
					String sql2="insert into banquesangconnecte (adresse ,numerobs) values (? , ? )";
					String sql3="select * from banquesang where username='"+username1DD.getText().toString()+"'";
					String num=null;
					String adr=null;
					int a=0;
					if(username1DD.getText().equals("") || password1DD.getText().equals("")){
						JOptionPane.showMessageDialog(null,"Remplissez le(s) champ(s) vide(s) ! ");
					}else{
						try {	
							preparedStatement=cnx.prepareStatement(sql);
							resultat=preparedStatement.executeQuery();
							while(resultat.next()){
								if(resultat.getString("username").equals(username1DD.getText()) && resultat.getString("password").equals(password1DD.getText())){
									
									cnx1=ConnexionMySql.ConnectionDB();
									preparedStatement1=cnx1.prepareStatement(sql3);
									resultat1=preparedStatement1.executeQuery();
									if(resultat1.next()){
										num=resultat1.getString("numbs");
										adr=resultat1.getString("adressebs");
									}
									cnx2=ConnexionMySql.ConnectionDB();
									preparedStatement2=cnx2.prepareStatement(sql1);
									preparedStatement2.execute();
									cnx3=ConnexionMySql.ConnectionDB();
									preparedStatement3=cnx3.prepareStatement(sql2);
									preparedStatement3.setString(1,adr);
									preparedStatement3.setString(2,num);
									preparedStatement3.execute();
									FenBanqueDeSang obj = new FenBanqueDeSang();
									obj.setLocationRelativeTo(null);
									obj.setVisible(true);
									dispose();
									a=1;
								}}
							if(a==0){
								JOptionPane.showMessageDialog(null,"Username Introuvable ou password Incorrecte !! ");
								}
							}
							
						catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}	
				}
			
				}}
			
		});
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 13));
		button_1.setBackground(new Color(184, 54, 52));
		button_1.setBounds(391, 400, 119, 30);
		contentPane.add(button_1);
		
		JLabel lblVousEtes = new JLabel("Vous etes ?");
		lblVousEtes.setFont(new Font("Lucida Handwriting", Font.BOLD | Font.ITALIC, 21));
		lblVousEtes.setBounds(375, 10, 154, 39);
		contentPane.add(lblVousEtes);
		
		 rdbtnBanqueDeSang = new JRadioButton("Banque de Sang");
		rdbtnBanqueDeSang.setFont(new Font("Lucida Fax", Font.ITALIC, 18));
		rdbtnBanqueDeSang.setBackground(new Color(251,198,197));
		rdbtnBanqueDeSang.setBounds(329, 162, 260, 37);
		contentPane.add(rdbtnBanqueDeSang);
		
		 rdbtnMedecin = new JRadioButton("Medecin");
		rdbtnMedecin.setFont(new Font("Lucida Fax", Font.ITALIC, 18));
		rdbtnMedecin.setBackground(new Color(251, 198, 197));
		rdbtnMedecin.setBounds(329, 106, 260, 37);
		contentPane.add(rdbtnMedecin);
		
		 rdbtnDonneurdemandeur = new JRadioButton("Donneur/Demandeur");
		rdbtnDonneurdemandeur.setFont(new Font("Lucida Fax", Font.ITALIC, 18));
		rdbtnDonneurdemandeur.setBackground(new Color(251, 198, 197));
		rdbtnDonneurdemandeur.setBounds(329, 52, 260, 37);
		contentPane.add(rdbtnDonneurdemandeur);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnBanqueDeSang);
		group.add(rdbtnMedecin);
		group.add(rdbtnDonneurdemandeur);
		
		JLabel lblVousAvezPas = new JLabel("Vous n'avez pas de compte ? ");
		lblVousAvezPas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!rdbtnBanqueDeSang.isSelected() && !rdbtnDonneurdemandeur.isSelected() && !rdbtnMedecin.isSelected()){
					JOptionPane.showMessageDialog(null,"Vous etes qui ?? -__' ?");				
				}
				else{
					if(rdbtnBanqueDeSang.isSelected()){
						FenInscriptionBanquedeSang obj = new FenInscriptionBanquedeSang();
		                   obj.setVisible(true);
		                   obj.setLocationRelativeTo(null);
		                   dispose();
					}
                    if(rdbtnDonneurdemandeur.isSelected()){
                    	FenInscriptionDonneurDemandeur obj = new FenInscriptionDonneurDemandeur();
 	                   obj.setVisible(true);
 	                   obj.setLocationRelativeTo(null);
 	                   dispose();
					}
                    if(rdbtnMedecin.isSelected()){
	                   FenInscriptionMedecin obj = new FenInscriptionMedecin();
	                   obj.setVisible(true);
	                   obj.setLocationRelativeTo(null);
	                   dispose();
                      }
					
				}
			}
		});
		lblVousAvezPas.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblVousAvezPas.setBounds(357, 338, 196, 26);
		contentPane.add(lblVousAvezPas);
		
		JLabel lblQuestCeQue = new JLabel("Qu'est ce que vous attendez ? Inscrivez-vous ");
		lblQuestCeQue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!rdbtnBanqueDeSang.isSelected() && !rdbtnDonneurdemandeur.isSelected() && !rdbtnMedecin.isSelected()){
					JOptionPane.showMessageDialog(null,"Vous etes qui ?? -__' ?");				
				}
				else{
					if(rdbtnBanqueDeSang.isSelected()){
						FenInscriptionBanquedeSang obj = new FenInscriptionBanquedeSang();
		                   obj.setVisible(true);
		                   obj.setLocationRelativeTo(null);
		                   dispose();
					}
                    if(rdbtnDonneurdemandeur.isSelected()){
                    	FenInscriptionDonneurDemandeur obj = new FenInscriptionDonneurDemandeur();
 	                   obj.setVisible(true);
 	                   obj.setLocationRelativeTo(null);
 	                   dispose();
					}
                    if(rdbtnMedecin.isSelected()){
	                   FenInscriptionMedecin obj = new FenInscriptionMedecin();
	                   obj.setVisible(true);
	                   obj.setLocationRelativeTo(null);
	                   dispose();
                      }
					
				}
			}
		});
		lblQuestCeQue.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 11));
		lblQuestCeQue.setBounds(320, 350, 274, 39);
		contentPane.add(lblQuestCeQue);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\transfuse_38039.png"));
		label_9.setBounds(224, 10, 70, 60);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = JOptionPane.showConfirmDialog(null,"Voulez-vous quitter BlooNation ?","Fermeture de BlooNation",JOptionPane.YES_NO_OPTION);
				if(a==0){
				dispose();}
			}
		});
		label_10.setIcon(new ImageIcon("C:\\Users\\Belinfo\\OneDrive\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\Childish-Cross_24996.png"));
		label_10.setBounds(556, -8, 48, 60);
		contentPane.add(label_10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\w.png"));
		label.setBounds(-23, 0, 646, 461);
		contentPane.add(label);
		
	}
}
