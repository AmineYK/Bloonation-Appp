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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FenInscriptionMedecin extends JFrame {

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
	private JTextField nomMED;
	private JTextField prenomMED;
	private JTextField usernameMED;
	private JComboBox categorieMED;
	private JPasswordField passwordMED;
	private JPasswordField confirmepasswordMED;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new NimbusLookAndFeel());
					FenInscriptionMedecin frame = new FenInscriptionMedecin();
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
	public FenInscriptionMedecin() {
		super("Inscription -- Medecin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 600);
		super.setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ImageIcon obj1= new ImageIcon(getClass().getResource("/Icones/transfuse_38039.png"));
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
		label_3.setIcon(new ImageIcon(getClass().getResource("/Icones/Doctor_Male_icon-icons.com_75051.png")));
		label_3.setBounds(15, 2, 46, 49);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Medecin");
		label_4.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 24));
		label_4.setBounds(154, 12, 110, 39);
		contentPane.add(label_4);
		//remplirnomprenom1();
		
		ButtonGroup group = new ButtonGroup();
		ButtonGroup group1 = new ButtonGroup();
		ButtonGroup group2 = new ButtonGroup();
		ButtonGroup group3 = new ButtonGroup();
		
		JLabel lblInscription = new JLabel("Inscription");
		lblInscription.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 24));
		lblInscription.setBounds(145, 70, 167, 39);
		contentPane.add(lblInscription);
		//remplirbanquesang();
		JLabel Nom = new JLabel("Nom");
		Nom.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		Nom.setBounds(53, 120, 79, 26);
		contentPane.add(Nom);
		
		nomMED = new JTextField();
		nomMED.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				if(key==10){
					prenomMED.requestFocus();
				}
			}
		});
		nomMED.setForeground(Color.BLACK);
		nomMED.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		nomMED.setColumns(16);
		nomMED.setBackground(new Color(184, 54, 52));
		nomMED.setBounds(53, 144, 155, 26);
		contentPane.add(nomMED);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblPrenom.setBounds(207, 171, 79, 26);
		contentPane.add(lblPrenom);
		
		prenomMED = new JTextField();
		prenomMED.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				if(key==10){
					usernameMED.requestFocus();
				}
			}
		});
		prenomMED.setForeground(Color.BLACK);
		prenomMED.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		prenomMED.setColumns(16);
		prenomMED.setBackground(new Color(184, 54, 52));
		prenomMED.setBounds(207, 197, 155, 26);
		contentPane.add(prenomMED);
		
		JLabel lblCatgorie = new JLabel("Cat\u00E9gorie");
		lblCatgorie.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblCatgorie.setBounds(53, 234, 79, 26);
		contentPane.add(lblCatgorie);
		
		JLabel label_20 = new JLabel("Username ");
		label_20.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_20.setBounds(207, 294, 79, 26);
		contentPane.add(label_20);
		
		usernameMED = new JTextField();
		usernameMED.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				if(key==10){
					passwordMED.requestFocus();
				}
			}
		});
		usernameMED.setForeground(Color.BLACK);
		usernameMED.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		usernameMED.setColumns(16);
		usernameMED.setBackground(new Color(184, 54, 52));
		usernameMED.setBounds(207, 316, 155, 26);
		contentPane.add(usernameMED);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblPassword.setBounds(53, 360, 79, 26);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmePassword = new JLabel("Confirm Password");
		lblConfirmePassword.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblConfirmePassword.setBounds(207, 423, 132, 26);
		contentPane.add(lblConfirmePassword);
		
		JButton btnSinscrire = new JButton("S'inscrire");
		btnSinscrire.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSinscrire.setBackground(new Color(253,198,197));
				btnSinscrire.setForeground(Color.BLACK);
			}	
			public void mouseExited(MouseEvent e) {
				btnSinscrire.setBackground(new Color(184,54,52));
				btnSinscrire.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int bgh=0;
				
				String sql1="select * from medecin where username='"+usernameMED.getText().toString()+"'";
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
				String sql="insert into medecin (nommedecin,prenommedecin,categorie,username,password) values (?,?,?,? , ? )";
				if(usernameMED.getText().equals("") || passwordMED.getText().equals("") || nomMED.getText().equals("") 
						|| prenomMED.getText().equals("")  || confirmepasswordMED.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Remplissez le(s) champ(s) vide(s) ! ");
				}else{
					if(!passwordMED.getText().equals(confirmepasswordMED.getText())){
						JOptionPane.showMessageDialog(null,"Please confirm password ! ");
					}else{
						try {
							preparedStatement=cnx.prepareStatement(sql);
							preparedStatement.setString(1,nomMED.getText().toString());
							preparedStatement.setString(2,prenomMED.getText().toString());
							preparedStatement.setString(3,categorieMED.getSelectedItem().toString());
							preparedStatement.setString(4,usernameMED.getText().toString());
							preparedStatement.setString(5,passwordMED.getText().toString());
							preparedStatement.execute();
							JOptionPane.showMessageDialog(null,"Inscription reussie !");
							nomMED.setText("");
							prenomMED.setText("");
							usernameMED.setText("");
							confirmepasswordMED.setText("");
							passwordMED.setText("");
							Auth obj = new Auth();
							obj.setVisible(true);
							obj.setLocationRelativeTo(null);
							dispose();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				}
			}

			}
		});
		btnSinscrire.setForeground(Color.BLACK);
		btnSinscrire.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 13));
		btnSinscrire.setBackground(new Color(184, 54, 52));
		btnSinscrire.setBounds(145, 544, 119, 30);
		contentPane.add(btnSinscrire);
		
		 categorieMED = new JComboBox();
		categorieMED.setBackground(new Color(184,54,52));
		categorieMED.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		categorieMED.setModel(new DefaultComboBoxModel(new String[] {"G\u00E9n\u00E9raliste", "Sp\u00E8cialiste"}));
		categorieMED.setBounds(53, 259, 155, 26);
		contentPane.add(categorieMED);
		
		passwordMED = new JPasswordField();
		passwordMED.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				if(key==10){
					confirmepasswordMED.requestFocus();
				}
			}
		});
		passwordMED.setBackground(new Color(184,54,52));
		passwordMED.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		passwordMED.setBounds(53, 384, 155, 26);
		contentPane.add(passwordMED);
		
		confirmepasswordMED = new JPasswordField();
		confirmepasswordMED.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		confirmepasswordMED.setBackground(new Color(184, 54, 52));
		confirmepasswordMED.setBounds(207, 450, 155, 26);
		contentPane.add(confirmepasswordMED);
		
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
		JLabel label_b = new JLabel("");
		label_b.setIcon(new ImageIcon(getClass().getResource("/Icones/5.png")));
				label_b.setBounds(-13, 0, 605, 628);
		contentPane.add(label_b);
		
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
