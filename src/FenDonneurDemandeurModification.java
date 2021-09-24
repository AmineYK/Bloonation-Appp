import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FenDonneurDemandeurModification extends JFrame {

	private JPanel contentPane;
	Connection cnx=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultat =null;
	Connection cnx1=null;
	PreparedStatement preparedStatement1=null;
	ResultSet resultat1 =null;
	private JLabel labelnomprenom;
	private JTextField nom;
	private JTextField prenom;
	private JTextField adresse;
	private JTextField tel;
	private JTextField age;
	private JTextField email;
	private JTextField username;
	private JPasswordField confirmepassword;
	private JPasswordField password;
	private JComboBox etatsante;
	private JComboBox gs;
	private JRadioButton feminin;
	private JRadioButton masculin;
	private JTextField numero;
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
					FenDonneurDemandeurModification frame = new FenDonneurDemandeurModification();
					
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
	public FenDonneurDemandeurModification() {
		super("Donneur/Demandeur - Modification du Profile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404,580);
		super.setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ImageIcon obj1 = new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\transfuse_38039.png");
		super.setIconImage(obj1.getImage());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		cnx=ConnexionMySql.ConnectionDB();
		cnx1=ConnexionMySql.ConnectionDB();
		remplirnomprenom();
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\Patient_Male_icon-icons.com_75053.png"));
		label_1.setBounds(9, 5, 46, 49);
		contentPane.add(label_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(184, 54, 52));
		panel.setBounds(5, 62, 389, 10);
		contentPane.add(panel);
		
		JLabel lblBanqueDeSang = new JLabel("Donneur/Demandeur");
		lblBanqueDeSang.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 22));
		lblBanqueDeSang.setBounds(81, 7, 257, 39);
		contentPane.add(lblBanqueDeSang);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnModifier.setBackground(new Color(253,198,197));
				btnModifier.setForeground(Color.BLACK);
			}	
			public void mouseExited(MouseEvent e) {
				btnModifier.setBackground(new Color(184,54,52));
				btnModifier.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				String genre=null;
			String sql="update donneur set nomdonneur = ? ,prenomdonneur=?,adressedonneur=?,teldonneur=?,emaildonneur=? "
						+ ",age=?,genre=?,groupesangdonneur=?,username=?,password=?,etatsante=? where numdonneur = "+numero.getText().toString()+" ";
				String sql1="update donneurconnecte set nomdonneurconnecte= ? ,prenomdonneurconnecte=? ";
				
				if(username.getText().equals("") || password.getText().equals("") || adresse.getText().equals("") 
						|| tel.getText().equals("") || email.getText().equals("")|| age.getText().equals("")|| prenom.getText().equals("")|| nom.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Remplissez le(s) champ(s) vide(s) ! ");
				}else{
					if(!password.getText().equals(confirmepassword.getText())){
						JOptionPane.showMessageDialog(null,"Please confirm password ! ");
					}else{
						try {
							if(masculin.isSelected()){genre="Masculin";}
							if(feminin.isSelected()){genre="Feminin";}
						
							preparedStatement1=cnx1.prepareStatement(sql1);
							preparedStatement1.setString(1,nom.getText().toString());
							preparedStatement1.setString(2,prenom.getText().toString());
							preparedStatement1.execute();
							preparedStatement=cnx.prepareStatement(sql);
							preparedStatement.setString(1,nom.getText().toString());
							preparedStatement.setString(2,prenom.getText().toString());
							preparedStatement.setString(3,adresse.getText().toString());
							preparedStatement.setString(4,tel.getText().toString());
							preparedStatement.setString(5,email.getText().toString());
							preparedStatement.setString(6,age.getText().toString());
							preparedStatement.setString(7,genre);
							preparedStatement.setString(8,gs.getSelectedItem().toString());
							preparedStatement.setString(9,username.getText().toString());
							preparedStatement.setString(10,password.getText().toString());
							preparedStatement.setString(11,etatsante.getSelectedItem().toString());
							preparedStatement.execute();
							JOptionPane.showMessageDialog(null,"Modification(s) Enregistrée(s) !");
							nom.setText("");
							adresse.setText("");
							prenom.setText("");
							email.setText("");
							
							age.setText("");
							tel.setText("");
							username.setText("");
							confirmepassword.setText("");
							password.setText("");
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				
			}

			}
		});
		btnModifier.setForeground(Color.BLACK);
		btnModifier.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 13));
		btnModifier.setBackground(new Color(184, 54, 52));
		btnModifier.setBounds(141, 528, 119, 30);
		contentPane.add(btnModifier);
		
		JLabel lblModification = new JLabel("Modification");
		lblModification.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 24));
		lblModification.setBounds(110, 82, 167, 39);
		contentPane.add(lblModification);
		
		JLabel label_9 = new JLabel("");
		label_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FenDonneurDemandeur obj=new FenDonneurDemandeur();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		label_9.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\arrow-address-back_icon-icons.com_54065.png"));
		label_9.setBounds(9, 76, 59, 39);
		contentPane.add(label_9);
		
		JLabel label_2 = new JLabel("Nom");
		label_2.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_2.setBounds(19, 136, 79, 26);
		contentPane.add(label_2);
		
		nom = new JTextField();
		nom.setForeground(Color.BLACK);
		nom.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		nom.setColumns(16);
		nom.setBackground(new Color(184, 54, 52));
		nom.setBounds(19, 163, 155, 26);
		contentPane.add(nom);
		
		JLabel label_3 = new JLabel("Prenom");
		label_3.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_3.setBounds(227, 136, 79, 26);
		contentPane.add(label_3);
		
		prenom = new JTextField();
		prenom.setForeground(Color.BLACK);
		prenom.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		prenom.setColumns(16);
		prenom.setBackground(new Color(184, 54, 52));
		prenom.setBounds(227, 163, 155, 26);
		contentPane.add(prenom);
		
		adresse = new JTextField();
		adresse.setForeground(Color.BLACK);
		adresse.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		adresse.setColumns(16);
		adresse.setBackground(new Color(184, 54, 52));
		adresse.setBounds(19, 229, 155, 26);
		contentPane.add(adresse);
		
		JLabel label_4 = new JLabel("Adresse");
		label_4.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_4.setBounds(19, 205, 79, 26);
		contentPane.add(label_4);
		
		tel = new JTextField();
		tel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int ccc = e.getKeyChar();
				if(Character.isAlphabetic(ccc)){
					tel.setEditable(false);
					lblerror4.setText("Invalide");
				}else{
					tel.setEditable(true);
					lblerror4.setText("");
				}
			}
		});
		tel.setForeground(Color.BLACK);
		tel.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		tel.setColumns(16);
		tel.setBackground(new Color(184, 54, 52));
		tel.setBounds(227, 226, 155, 26);
		contentPane.add(tel);
		
		lblerror4 = new JLabel("");
		lblerror4.setForeground(Color.RED);
		lblerror4.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		lblerror4.setBounds(227, 252, 79, 14);
		contentPane.add(lblerror4);
		
		JLabel label_5 = new JLabel("Telephone");
		label_5.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_5.setBounds(227, 200, 79, 26);
		contentPane.add(label_5);
		
		age = new JTextField();
		age.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int ccc = e.getKeyChar();
				if(Character.isAlphabetic(ccc)){
					age.setEditable(false);
					lblerror41.setText("Invalide");
				}else{
					age.setEditable(true);
					lblerror41.setText("");
				}
			}
		});
		age.setForeground(Color.BLACK);
		age.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		age.setColumns(16);
		age.setBackground(new Color(184, 54, 52));
		age.setBounds(227, 287, 155, 26);
		contentPane.add(age);
		
		lblerror41 = new JLabel("");
		lblerror41.setForeground(Color.RED);
		lblerror41.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		lblerror41.setBounds(227, 312, 79, 14);
		contentPane.add(lblerror41);
		
		JLabel label_6 = new JLabel("Age");
		label_6.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_6.setBounds(227, 263, 79, 26);
		contentPane.add(label_6);
		
		email = new JTextField();
		email.setText("abcdef@email.com");
		email.setForeground(Color.BLACK);
		email.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		email.setColumns(16);
		email.setBackground(new Color(184, 54, 52));
		email.setBounds(19, 290, 155, 26);
		contentPane.add(email);
		
		JLabel label_7 = new JLabel("Email");
		label_7.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_7.setBounds(19, 266, 79, 26);
		contentPane.add(label_7);
		
		 etatsante = new JComboBox();
		etatsante.setModel(new DefaultComboBoxModel(new String[] {"Maladie Chronique", "Maladie Contagieuse", "Sans Maladie "}));
		etatsante.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		etatsante.setBackground(new Color(184, 54, 52));
		etatsante.setBounds(19, 408, 155, 26);
		contentPane.add(etatsante);
		
		JLabel label_8 = new JLabel("Etat de Sant\u00E9");
		label_8.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_8.setBounds(19, 385, 98, 26);
		contentPane.add(label_8);
		
		username = new JTextField();
		username.setForeground(Color.BLACK);
		username.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		username.setColumns(16);
		username.setBackground(new Color(184, 54, 52));
		username.setBounds(227, 408, 155, 26);
		contentPane.add(username);
		
		JLabel label_10 = new JLabel("Username");
		label_10.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_10.setBounds(227, 384, 79, 26);
		contentPane.add(label_10);
		
		confirmepassword = new JPasswordField();
		confirmepassword.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		confirmepassword.setBackground(new Color(184, 54, 52));
		confirmepassword.setBounds(227, 475, 155, 26);
		contentPane.add(confirmepassword);
		
		JLabel label_11 = new JLabel("Confirm Password");
		label_11.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_11.setBounds(227, 449, 141, 26);
		contentPane.add(label_11);
		
		password = new JPasswordField();
		password.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		password.setBackground(new Color(184, 54, 52));
		password.setBounds(19, 475, 155, 26);
		contentPane.add(password);
		
		JLabel label_12 = new JLabel("Password");
		label_12.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_12.setBounds(19, 449, 79, 26);
		contentPane.add(label_12);
		
		 gs = new JComboBox();
		gs.setModel(new DefaultComboBoxModel(new String[] {"A-", "A+", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
		gs.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		gs.setBackground(new Color(184, 54, 52));
		gs.setBounds(227, 344, 155, 26);
		contentPane.add(gs);
		
		JLabel label_13 = new JLabel("Groupe Sanguin");
		label_13.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_13.setBounds(227, 323, 119, 26);
		contentPane.add(label_13);
		
		 feminin = new JRadioButton("Feminin");
		feminin.setFont(new Font("Lucida Fax", Font.ITALIC, 11));
		feminin.setBackground(new Color(253, 198, 197));
		feminin.setBounds(104, 350, 70, 23);
		contentPane.add(feminin);
		
		 masculin = new JRadioButton("Masculin");
		masculin.setFont(new Font("Lucida Fax", Font.ITALIC, 11));
		masculin.setBackground(new Color(253, 198, 197));
		masculin.setBounds(19, 350, 75, 23);
		contentPane.add(masculin);
		
		ButtonGroup group=new ButtonGroup();
		group.add(masculin);
		group.add(feminin);
		
		
		JLabel label_14 = new JLabel("Sexe");
		label_14.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_14.setBounds(19, 326, 79, 26);
		contentPane.add(label_14);
		
		numero = new JTextField();
		numero.setEditable(false);
		numero.setForeground(Color.BLACK);
		numero.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		numero.setColumns(16);
		numero.setBackground(new Color(184, 54, 52));
		numero.setBounds(316, 111, 59, 26);
		contentPane.add(numero);
		
		JLabel lblNumro = new JLabel("Num\u00E9ro");
		lblNumro.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblNumro.setBounds(316, 88, 79, 26);
		contentPane.add(lblNumro);
		
		JLabel label_8SW = new JLabel("");
		label_8SW.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a=JOptionPane.showConfirmDialog(null,"Voulez-vous vous deconnecter ?","Deconnexion",JOptionPane.YES_NO_CANCEL_OPTION);
				if(a==0){
				Auth obj=new Auth();
				obj.setLocationRelativeTo(null);
				obj.setVisible(true);
				dispose();
			}}
		});
		label_8SW.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\Logout_37127.png"));
		label_8SW.setBounds(349, 528, 59, 49);
		contentPane.add(label_8SW);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\7.png"));
		label.setBounds(-10, 0, 414, 749);
		contentPane.add(label);
		remplirchamps();
		
	}
	 void remplirchamps() {
		
		 String num=null;
			String adr=null;
			 String sql="select * from donneurconnecte";
			try {
				preparedStatement=cnx.prepareStatement(sql);
				resultat=preparedStatement.executeQuery();
				if(resultat.next()){
					adr=resultat.getString("nomdonneurconnecte");
					num=resultat.getString("prenomdonneurconnecte");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sql1="select * from donneur where nomdonneur='"+adr+"' and prenomdonneur='"+num+"'";
			try {
				preparedStatement1=cnx1.prepareStatement(sql1);
				resultat1=preparedStatement1.executeQuery();
				if(resultat1.next()){
					numero.setText(resultat1.getString("numdonneur"));
					nom.setText(resultat1.getString("nomdonneur"));
					prenom.setText(resultat1.getString("prenomdonneur"));
					
					adresse.setText(resultat1.getString("adressedonneur"));
					tel.setText(resultat1.getString("teldonneur"));
					email.setText(resultat1.getString("emaildonneur"));
					age.setText(resultat1.getString("age"));
					if(resultat1.getString("genre").equals("Masculin")){
						masculin.setSelected(true);
					}
					if(resultat1.getString("genre").equals("Feminin")){
						feminin.setSelected(true);
					}
					nom.setText(resultat1.getString("nomdonneur"));
					gs.setSelectedItem(resultat1.getString("groupesangdonneur"));
					username.setText(resultat1.getString("username"));
					password.setText(resultat1.getString("password"));
					etatsante.setSelectedItem(resultat1.getString("etatsante"));
					
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	void remplirnomprenom() {
		String nom=null;
		String prenom=null;
		 String sql="select * from donneurconnecte";
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			if(resultat.next()){
				nom=resultat.getString("nomdonneurconnecte");
				prenom=resultat.getString("prenomdonneurconnecte");
				labelnomprenom = new JLabel(nom+" "+prenom);
				labelnomprenom.setFont(new Font("Lucida Fax", Font.ITALIC, 13));
				labelnomprenom.setBounds(220,43, 200, 14);
				contentPane.add(labelnomprenom);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		}
}
