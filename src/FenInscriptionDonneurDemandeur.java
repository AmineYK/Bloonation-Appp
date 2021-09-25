import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FenInscriptionDonneurDemandeur extends JFrame {

	private JPanel contentPane;
	String NOMM=null;
	String PRENOMM=null;
	Connection cnx = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultat = null;
	Connection cnx1 = null;
	PreparedStatement preparedStatement1 = null;
	ResultSet resultat1 = null;
	private JLabel labelnomprenom;
	private JTextField nomDD;
	private JTextField prenomDD;
	private JTextField adresseDD;
	private JTextField telDD;
	private JTextField emailDD;
	private JTextField ageDD;
	private JTextField usernameDD;
	private JPasswordField passwordDD;
	private JPasswordField confirmepasswordDD;
	private JComboBox etatsanteDD;
	private JLabel lblerror4;
	private JLabel lblerror41;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new NimbusLookAndFeel());
					FenInscriptionDonneurDemandeur frame = new FenInscriptionDonneurDemandeur();
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
	public FenInscriptionDonneurDemandeur() {
		super("Inscription - Banque de Sang");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430,600);
		super.setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ImageIcon obj1 = new ImageIcon(getClass().getResource("/Icones/transfuse_38039.png"));
		super.setIconImage(obj1.getImage());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		cnx=ConnexionMySql.ConnectionDB();
		cnx1=ConnexionMySql.ConnectionDB();
		//remplirnomprenom();
		//remplirnumerodon();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(184,54,52));
		panel.setBounds(10, 54, 414, 10);
		contentPane.add(panel);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(getClass().getResource("/Icones/Patient_Male_icon-icons.com_75053.png")));
		label_3.setBounds(7, 2, 46, 49);
		contentPane.add(label_3);
		
		JLabel lblBanqueDeSang = new JLabel("Donneur/Demandeur");
		lblBanqueDeSang.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 24));
		lblBanqueDeSang.setBounds(85, 12, 279, 39);
		contentPane.add(lblBanqueDeSang);
		//remplirnomprenom1();
		
		ButtonGroup group = new ButtonGroup();
		ButtonGroup group1 = new ButtonGroup();
		ButtonGroup group2 = new ButtonGroup();
		ButtonGroup group3 = new ButtonGroup();
		
		JLabel lblInscription = new JLabel("Inscription");
		lblInscription.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 24));
		lblInscription.setBounds(145, 70, 167, 39);
		contentPane.add(lblInscription);
		
		JLabel label_17 = new JLabel("Nom");
		label_17.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_17.setBounds(35, 112, 79, 26);
		contentPane.add(label_17);
		
		nomDD = new JTextField();
		nomDD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				if(key==10){
					prenomDD.requestFocus();
				}
			}
		});
		nomDD.setForeground(Color.BLACK);
		nomDD.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		nomDD.setColumns(16);
		nomDD.setBackground(new Color(184, 54, 52));
		nomDD.setBounds(35, 136, 155, 26);
		contentPane.add(nomDD);
		
		JLabel lblPrenom_1 = new JLabel("Prenom");
		lblPrenom_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblPrenom_1.setBounds(242, 112, 79, 26);
		contentPane.add(lblPrenom_1);
		
		prenomDD = new JTextField();
		prenomDD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				if(key==10){
					adresseDD.requestFocus();
				}
			}
		});
		prenomDD.setForeground(Color.BLACK);
		prenomDD.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		prenomDD.setColumns(16);
		prenomDD.setBackground(new Color(184, 54, 52));
		prenomDD.setBounds(242, 136, 155, 26);
		contentPane.add(prenomDD);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblAdresse.setBounds(35, 177, 79, 26);
		contentPane.add(lblAdresse);
		
		adresseDD = new JTextField();
		adresseDD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				if(key==10){
					telDD.requestFocus();
				}
			}
		});
		adresseDD.setForeground(Color.BLACK);
		adresseDD.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		adresseDD.setColumns(16);
		adresseDD.setBackground(new Color(184, 54, 52));
		adresseDD.setBounds(35, 201, 155, 26);
		contentPane.add(adresseDD);
		
		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblTelephone.setBounds(242, 175, 79, 26);
		contentPane.add(lblTelephone);
		
		telDD = new JTextField();
		telDD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
						int ccc = e.getKeyChar();
						if(Character.isAlphabetic(ccc)){
							telDD.setEditable(false);
							lblerror4.setText("Invalide");
						}else{
							telDD.setEditable(true);
							lblerror4.setText("");
						}
						int key=e.getKeyCode();
						if(key==10){
							emailDD.requestFocus();
						}
					}
					
			
			
		});
		telDD.setForeground(Color.BLACK);
		telDD.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		telDD.setColumns(16);
		telDD.setBackground(new Color(184, 54, 52));
		telDD.setBounds(242, 201, 155, 26);
		contentPane.add(telDD);
		
		lblerror4 = new JLabel("");
		lblerror4.setForeground(Color.RED);
		lblerror4.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		lblerror4.setBounds(242, 226, 79, 14);
		contentPane.add(lblerror4);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblEmail.setBounds(35, 238, 79, 26);
		contentPane.add(lblEmail);
		
		emailDD = new JTextField();
		emailDD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				if(key==10){
					ageDD.requestFocus();
				}
			}
		});
		emailDD.setText("abcdef@email.com");
		emailDD.setForeground(Color.BLACK);
		emailDD.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		emailDD.setColumns(16);
		emailDD.setBackground(new Color(184, 54, 52));
		emailDD.setBounds(35, 262, 155, 26);
		contentPane.add(emailDD);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblAge.setBounds(242, 238, 79, 26);
		contentPane.add(lblAge);
		
		ageDD = new JTextField();
		ageDD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int ccc = e.getKeyChar();
				if(Character.isAlphabetic(ccc)){
					ageDD.setEditable(false);
					lblerror41.setText("Invalide");
				}else{
					ageDD.setEditable(true);
					lblerror41.setText("");
				}
				int key=e.getKeyCode();
				if(key==10){
					usernameDD.requestFocus();
				}
			
			}
		});
		ageDD.setForeground(Color.BLACK);
		ageDD.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		ageDD.setColumns(16);
		ageDD.setBackground(new Color(184, 54, 52));
		ageDD.setBounds(242, 262, 155, 26);
		contentPane.add(ageDD);
		
		lblerror41 = new JLabel("");
		lblerror41.setForeground(Color.RED);
		lblerror41.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		lblerror41.setBounds(242, 287, 79, 14);
		contentPane.add(lblerror41);
		
		JLabel lblEtatDeSant = new JLabel("Etat de Sant\u00E9");
		lblEtatDeSant.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblEtatDeSant.setBounds(35, 299, 98, 26);
		contentPane.add(lblEtatDeSant);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblUsername.setBounds(242, 299, 79, 26);
		contentPane.add(lblUsername);
		
		usernameDD = new JTextField();
		usernameDD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				if(key==10){
					passwordDD.requestFocus();
				}
			}
		});
		usernameDD.setForeground(Color.BLACK);
		usernameDD.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		usernameDD.setColumns(16);
		usernameDD.setBackground(new Color(184, 54, 52));
		usernameDD.setBounds(242, 323, 155, 26);
		contentPane.add(usernameDD);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblPassword_1.setBounds(35, 360, 79, 26);
		contentPane.add(lblPassword_1);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblConfirmPassword.setBounds(242, 360, 141, 26);
		contentPane.add(lblConfirmPassword);
		
		JLabel lblSexe = new JLabel("Sexe");
		lblSexe.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblSexe.setBounds(35, 427, 79, 26);
		contentPane.add(lblSexe);
		
		JLabel lblGroupeSanguin = new JLabel("Groupe Sanguin");
		lblGroupeSanguin.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblGroupeSanguin.setBounds(242, 427, 119, 26);
		contentPane.add(lblGroupeSanguin);
		
		JComboBox groupesanguinDD = new JComboBox();
		groupesanguinDD.setModel(new DefaultComboBoxModel(new String[] {"A-", "A+", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
		groupesanguinDD.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		groupesanguinDD.setBackground(new Color(184, 54, 52));
		groupesanguinDD.setBounds(242, 448, 155, 26);
		contentPane.add(groupesanguinDD);
		
		JRadioButton rdbtnMasculin = new JRadioButton("Masculin");
		rdbtnMasculin.setBackground(new Color(253,198,197));
		rdbtnMasculin.setFont(new Font("Lucida Fax", Font.ITALIC, 11));
		rdbtnMasculin.setBounds(35, 451, 75, 23);
		contentPane.add(rdbtnMasculin);
		
		JRadioButton rdbtnFeminin = new JRadioButton("Feminin");
		rdbtnFeminin.setBackground(new Color(253,198,197));
		rdbtnFeminin.setFont(new Font("Lucida Fax", Font.ITALIC, 11));
		rdbtnFeminin.setBounds(120, 451, 70, 23);
		contentPane.add(rdbtnFeminin);
		ButtonGroup group11 = new ButtonGroup();
		group11.add(rdbtnFeminin);
		group11.add(rdbtnMasculin);
		
		JButton btnSinscrire_1 = new JButton("S'inscrire");
		btnSinscrire_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSinscrire_1.setBackground(new Color(253,198,197));
				btnSinscrire_1.setForeground(Color.BLACK);
			}	
			public void mouseExited(MouseEvent e) {
				btnSinscrire_1.setBackground(new Color(184,54,52));
				btnSinscrire_1.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
                    int bgh=0;
				    String ssString=null;
				String sql1="select * from medecin where username='"+usernameDD.getText().toString()+"'";
				try {
					preparedStatement= cnx.prepareStatement(sql1);
					resultat=preparedStatement.executeQuery();
					if(resultat.next()){
						JOptionPane.showMessageDialog(null,"Attention ! Username deja utilisé ,changez le !");
						bgh=1;
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if(bgh == 0){
				String sql="insert into donneur (nomdonneur,prenomdonneur,adressedonneur,teldonneur,emaildonneur,age,genre,groupesangdonneur,username,password,etatsante) "
						+ "values (?,?,?,?,?,?,?,?,?,? , ? )";
				if(usernameDD.getText().equals("") || passwordDD.getText().equals("") || nomDD.getText().equals("") 
						|| prenomDD.getText().equals("")  ||  adresseDD.getText().equals("")  
						|| telDD.getText().equals("")   || emailDD.getText().equals("")  
						||confirmepasswordDD.getText().equals("") || ageDD.getText().equals("")
						|| (!rdbtnMasculin.isSelected() && !rdbtnFeminin.isSelected())
						) 
						{
					JOptionPane.showMessageDialog(null,"Remplissez le(s) champ(s) vide(s) ! ");
				}else{
					if(!passwordDD.getText().equals(confirmepasswordDD.getText())){
						JOptionPane.showMessageDialog(null,"Please confirm password ! ");
					}else{
						if(Integer.valueOf(ageDD.getText().toString()) > 100 ){JOptionPane.showMessageDialog(null,"Age non valide !");}
						else{
						if(rdbtnMasculin.isSelected()){ssString="Masculin";}
						if(rdbtnFeminin.isSelected()){ssString="Feminin";}
						try {
							preparedStatement=cnx.prepareStatement(sql);
							preparedStatement.setString(1,nomDD.getText().toString());
							preparedStatement.setString(2,prenomDD.getText().toString());
							preparedStatement.setString(3,adresseDD.getText().toString());
							preparedStatement.setString(4,telDD.getText().toString());
							preparedStatement.setString(5,emailDD.getText().toString());
							preparedStatement.setString(6,ageDD.getText().toString());
							preparedStatement.setString(7,ssString);
							preparedStatement.setString(8,groupesanguinDD.getSelectedItem().toString());
							preparedStatement.setString(9,usernameDD.getText().toString());
							preparedStatement.setString(10,passwordDD.getText().toString());
							preparedStatement.setString(11,etatsanteDD.getSelectedItem().toString());
							preparedStatement.execute();
							JOptionPane.showMessageDialog(null,"Inscription reussie !");
							nomDD.setText("");
							prenomDD.setText("");
							usernameDD.setText("");
							confirmepasswordDD.setText("");
							passwordDD.setText("");
							emailDD.setText("");
							ageDD.setText("");
							telDD.setText("");
							adresseDD.setText("");
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}}
				}
			

			}
			}
		});
		btnSinscrire_1.setForeground(Color.BLACK);
		btnSinscrire_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 13));
		btnSinscrire_1.setBackground(new Color(184, 54, 52));
		btnSinscrire_1.setBounds(145, 532, 119, 30);
		contentPane.add(btnSinscrire_1);
		
		passwordDD = new JPasswordField();
		passwordDD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				if(key==10){
					confirmepasswordDD.requestFocus();
				}
			}
		});
		passwordDD.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		passwordDD.setBackground(new Color(184, 54, 52));
		passwordDD.setBounds(35, 387, 155, 26);
		contentPane.add(passwordDD);
		
		confirmepasswordDD = new JPasswordField();
		confirmepasswordDD.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		confirmepasswordDD.setBackground(new Color(184, 54, 52));
		confirmepasswordDD.setBounds(242, 390, 155, 26);
		contentPane.add(confirmepasswordDD);
		
		 etatsanteDD = new JComboBox();
		etatsanteDD.setModel(new DefaultComboBoxModel(new String[] {"Maladie Chronique", "Maladie Contagieuse", "Sans Maladie "}));
		etatsanteDD.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		etatsanteDD.setBackground(new Color(184, 54, 52));
		etatsanteDD.setBounds(35, 322, 155, 26);
		contentPane.add(etatsanteDD);
		
		JLabel label_9 = new JLabel("");
		label_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Auth obj=new Auth();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		label_9.setIcon(new ImageIcon(getClass().getResource("/Icones/arrow-address-back_icon-icons.com_54065.png")));
		label_9.setBounds(9, 67, 59, 39);
		contentPane.add(label_9);
		JLabel label_a = new JLabel("");
		label_a.setIcon(new ImageIcon(getClass().getResource("/Icones/5.png")));
		
		label_a.setBounds(-13, 0, 605, 400);
		contentPane.add(label_a);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(getClass().getResource("/Icones/2.png")));
		label.setBounds(-11, -13, 450, 641);
		contentPane.add(label);

		
		
	}

	 /* void remplirnumerodon() {
		 
		String sql="select * from donneur";
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			while(resultat.next()){
				numerodon.addItem(resultat.getString("numdonneur"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	 

	void remplirnomprenom() {
		String nom=null;
		String prenom=null;
		 String sql="select * from medecinconnecte";
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			if(resultat.next()){
				nom=resultat.getString("nom");
				NOMM=resultat.getString("nom");
				prenom=resultat.getString("prenom");
				PRENOMM=resultat.getString("prenom");
				labelnomprenom = new JLabel("Dr "+nom+" "+prenom);
				labelnomprenom.setFont(new Font("Lucida Fax", Font.ITALIC, 13));
				labelnomprenom.setBounds(290, 34, 150, 14);
				contentPane.add(labelnomprenom);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		}
	void remplirbanquesang() {
		String nom=null;
		String prenom=null;
		 String sql="select * from banquesang";
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			while(resultat.next()){
				banquesang.addItem(resultat.getString("adressebs")+" "+resultat.getString("numbs"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		}

	void remplirnomprenom1() {
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			if(resultat.next()){
				nom.setText(resultat.getString("nomdonneur"));
				prenom.setText(resultat.getString("prenomdonneur"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		}*/
}
