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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class FenInscriptionBanquedeSang extends JFrame {

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
	private JTextField adresseBS;
	private JTextField telBS;
	private JTextField usernameBS;
	private JPasswordField passwordBS;
	private JPasswordField confirmepasswordBS;
	private JLabel lblerror4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new NimbusLookAndFeel());
					FenInscriptionBanquedeSang frame = new FenInscriptionBanquedeSang();
					frame.setUndecorated(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FenInscriptionBanquedeSang() {
		super("Inscription - Banque de Sang");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 600);
		super.setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ImageIcon obj1 = new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\transfuse_38039.png");
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
		label_3.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\blood_drop_icon-icons.com_76228 (1).png"));
		label_3.setBounds(7, 2, 46, 49);
		contentPane.add(label_3);
		
		JLabel lblBanqueDeSang = new JLabel("Banque de Sang");
		lblBanqueDeSang.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 24));
		lblBanqueDeSang.setBounds(116, 12, 217, 39);
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
		
		adresseBS = new JTextField();
		adresseBS.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				if(key==10){
					telBS.requestFocus();
				}
			}
		});
		adresseBS.setForeground(Color.BLACK);
		adresseBS.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		adresseBS.setColumns(16);
		adresseBS.setBackground(new Color(184, 54, 52));
		adresseBS.setBounds(38, 167, 155, 26);
		contentPane.add(adresseBS);
		
		JLabel lblAdresse_1 = new JLabel("Adresse");
		lblAdresse_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblAdresse_1.setBounds(38, 142, 79, 26);
		contentPane.add(lblAdresse_1);
		
		JLabel lblTelephone_1 = new JLabel("Telephone");
		lblTelephone_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblTelephone_1.setBounds(238, 204, 79, 26);
		contentPane.add(lblTelephone_1);
		
		telBS = new JTextField();
		telBS.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int ccc = e.getKeyChar();
				if(Character.isAlphabetic(ccc)){
					telBS.setEditable(false);
					lblerror4.setText("Invalide");
				}else{
					telBS.setEditable(true);
					lblerror4.setText("");
				}
				int key=e.getKeyCode();
				if(key==10){
					usernameBS.requestFocus();
				}
			}
			
		});
		telBS.setForeground(Color.BLACK);
		telBS.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		telBS.setColumns(16);
		telBS.setBackground(new Color(184, 54, 52));
		telBS.setBounds(238, 230, 155, 26);
		contentPane.add(telBS);
		
		lblerror4 = new JLabel("");
		lblerror4.setForeground(Color.RED);
		lblerror4.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		lblerror4.setBounds(219, 218, 79, 14);
		contentPane.add(lblerror4);
		
		JComboBox siege = new JComboBox();
		siege.setModel(new DefaultComboBoxModel(new String[] {"Centre Hospitalier", "Externe"}));
		siege.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		siege.setBackground(new Color(184, 54, 52));
		siege.setBounds(38, 292, 155, 26);
		contentPane.add(siege);
		
		JLabel lblSige = new JLabel("Si\u00E9ge");
		lblSige.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblSige.setBounds(38, 267, 79, 26);
		contentPane.add(lblSige);
		
		usernameBS = new JTextField();
		usernameBS.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				if(key==10){
					passwordBS.requestFocus();
				}
			}
		});

		usernameBS.setForeground(Color.BLACK);
		usernameBS.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		usernameBS.setColumns(16);
		usernameBS.setBackground(new Color(184, 54, 52));
		usernameBS.setBounds(238, 342, 155, 26);
		contentPane.add(usernameBS);
		
		JButton button_3 = new JButton("S'inscrire");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button_3.setBackground(new Color(253,198,197));
				button_3.setForeground(Color.BLACK);
			}	
			public void mouseExited(MouseEvent e) {
				button_3.setBackground(new Color(184,54,52));
				button_3.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
                 int bgh=0;
				
				String sql1="select * from banquesang where username='"+usernameBS.getText().toString()+"'";
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
				String sql="insert into banquesang (adressebs,telbs,siege,username,password) values (?,?,?,? , ? )";
				if(usernameBS.getText().equals("") || passwordBS.getText().equals("") || adresseBS.getText().equals("") 
						|| telBS.getText().equals("")  || confirmepasswordBS.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Remplissez le(s) champ(s) vide(s) ! ");
				}else{
					if(!passwordBS.getText().equals(confirmepasswordBS.getText())){
						JOptionPane.showMessageDialog(null,"Please confirm password ! ");
					}else{
						try {
							preparedStatement=cnx.prepareStatement(sql);
							preparedStatement.setString(1,adresseBS.getText().toString());
							preparedStatement.setString(2,telBS.getText().toString());
							preparedStatement.setString(3,siege.getSelectedItem().toString());
							preparedStatement.setString(4,usernameBS.getText().toString());
							preparedStatement.setString(5,passwordBS.getText().toString());
							preparedStatement.execute();
							JOptionPane.showMessageDialog(null,"Inscription reussie !");
							adresseBS.setText("");
							telBS.setText("");
							usernameBS.setText("");
							confirmepasswordBS.setText("");
							passwordBS.setText("");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				}
			}

			}
			
		});
		button_3.setForeground(Color.BLACK);
		button_3.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 13));
		button_3.setBackground(new Color(184, 54, 52));
		button_3.setBounds(155, 540, 119, 30);
		contentPane.add(button_3);
		
		JLabel label_22 = new JLabel("Confirm Password");
		label_22.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_22.setBounds(238, 448, 132, 26);
		contentPane.add(label_22);
		
		JLabel label_23 = new JLabel("Username ");
		label_23.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_23.setBounds(238, 320, 79, 26);
		contentPane.add(label_23);
		
		JLabel label_24 = new JLabel("Password");
		label_24.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_24.setBounds(38, 379, 79, 26);
		contentPane.add(label_24);
		
		passwordBS = new JPasswordField();
		passwordBS.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				if(key==10){
					confirmepasswordBS.requestFocus();
				}
			}
		});
		passwordBS.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		passwordBS.setBackground(new Color(184, 54, 52));
		passwordBS.setBounds(38, 407, 155, 26);
		contentPane.add(passwordBS);
		
		confirmepasswordBS = new JPasswordField();
		confirmepasswordBS.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		confirmepasswordBS.setBackground(new Color(184, 54, 52));
		confirmepasswordBS.setBounds(238, 470, 155, 26);
		contentPane.add(confirmepasswordBS);
		
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
		label_9.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\arrow-address-back_icon-icons.com_54065.png"));
		label_9.setBounds(9, 70, 59, 39);
		contentPane.add(label_9);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\2.png"));
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
