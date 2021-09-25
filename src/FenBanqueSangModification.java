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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FenBanqueSangModification extends JFrame {

	private JPanel contentPane;
	Connection cnx=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultat =null;
	Connection cnx1=null;
	PreparedStatement preparedStatement1=null;
	ResultSet resultat1 =null;
	private JLabel labelnomprenom;
	private JTextField adresse;
	private JTextField tel;
	private JTextField username;
	private JTextField password;
	private JTextField confirmepassword;
	private JTextField numero;
	private JComboBox siege;
	private JLabel lblerror4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new NimbusLookAndFeel());
					FenBanqueSangModification frame = new FenBanqueSangModification();
					
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
	public FenBanqueSangModification() {
		super("Banque de Sang - Modification du Profile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404,580);
		super.setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ImageIcon obj1 = new ImageIcon(getClass().getResource("/Icones/transfuse_38039.png"));
		
		super.setIconImage(obj1.getImage());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		cnx=ConnexionMySql.ConnectionDB();
		cnx1=ConnexionMySql.ConnectionDB();
		remplirnomprenom();
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(getClass().getResource("/Icones/blood_drop_icon-icons.com_76228 (1).png")));
		label_1.setBounds(9, 5, 46, 49);
		contentPane.add(label_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(184, 54, 52));
		panel.setBounds(5, 62, 389, 10);
		contentPane.add(panel);
		
		JLabel lblBanqueDeSang = new JLabel("Banque de Sang");
		lblBanqueDeSang.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 24));
		lblBanqueDeSang.setBounds(107, 7, 202, 39);
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
				
				String sql="update banquesang set adressebs = ? ,telbs=?,siege=?,username=?,password=? where numbs ="+numero.getText().toString()+"";
				String sql1="update banquesangconnecte set adresse = ? ,numerobs=? ";
				
				if(username.getText().equals("") || password.getText().equals("") || adresse.getText().equals("") 
						|| tel.getText().equals("") ){
					JOptionPane.showMessageDialog(null,"Remplissez le(s) champ(s) vide(s) ! ");
				}else{
					if(!password.getText().equals(confirmepassword.getText())){
						JOptionPane.showMessageDialog(null,"Please confirm password ! ");
					}else{
						try {
						
							preparedStatement1=cnx1.prepareStatement(sql1);
							preparedStatement1.setString(1,adresse.getText().toString());
							preparedStatement1.setString(2,numero.getText().toString());
							preparedStatement1.execute();
							preparedStatement=cnx.prepareStatement(sql);
							preparedStatement.setString(1,adresse.getText().toString());
							preparedStatement.setString(2,tel.getText().toString());
							preparedStatement.setString(3,siege.getSelectedItem().toString());
							preparedStatement.setString(4,username.getText().toString());
							preparedStatement.setString(5,password.getText().toString());
							preparedStatement.execute();
							JOptionPane.showMessageDialog(null,"Modification(s) Enregistrée(s) !");
							adresse.setText("");
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
		btnModifier.setBounds(140, 520, 119, 30);
		contentPane.add(btnModifier);
		
		JLabel lblModification = new JLabel("Modification");
		lblModification.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 24));
		lblModification.setBounds(110, 82, 167, 39);
		contentPane.add(lblModification);
		
		JLabel label_9 = new JLabel("");
		label_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FenBanqueDeSang obj=new FenBanqueDeSang();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		label_9.setIcon(new ImageIcon(getClass().getResource("/Icones/arrow-address-back_icon-icons.com_54065.png")));
		label_9.setBounds(9, 76, 59, 39);
		contentPane.add(label_9);
		
		JLabel label_2 = new JLabel("Adresse");
		label_2.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_2.setBounds(20, 156, 79, 26);
		contentPane.add(label_2);
		
		adresse = new JTextField();
		adresse.setForeground(Color.BLACK);
		adresse.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		adresse.setColumns(16);
		adresse.setBackground(new Color(184, 54, 52));
		adresse.setBounds(20, 178, 155, 26);
		contentPane.add(adresse);
		
		JLabel label_3 = new JLabel("Telephone");
		label_3.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_3.setBounds(228, 208, 79, 26);
		contentPane.add(label_3);
		
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
		tel.setBounds(228, 234, 155, 26);
		contentPane.add(tel);
		
		lblerror4 = new JLabel("");
		lblerror4.setForeground(Color.RED);
		lblerror4.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		lblerror4.setBounds(228, 260, 79, 14);
		contentPane.add(lblerror4);
		
		 siege = new JComboBox();
		 siege.setModel(new DefaultComboBoxModel(new String[] {"Centre Hospitalier", "Externe"}));
		siege.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		siege.setBackground(new Color(184, 54, 52));
		siege.setBounds(20, 285, 155, 26);
		contentPane.add(siege);
		
		JLabel label_4 = new JLabel("Si\u00E9ge");
		label_4.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_4.setBounds(20, 260, 79, 26);
		contentPane.add(label_4);
		
		username = new JTextField();
		username.setForeground(Color.BLACK);
		username.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		username.setColumns(16);
		username.setBackground(new Color(184, 54, 52));
		username.setBounds(228, 340, 155, 26);
		contentPane.add(username);
		
		JLabel label_5 = new JLabel("Username ");
		label_5.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_5.setBounds(228, 318, 79, 26);
		contentPane.add(label_5);
		
		password = new JTextField();
		password.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		password.setBackground(new Color(184, 54, 52));
		password.setBounds(20, 391, 155, 26);
		contentPane.add(password);
		
		JLabel label_6 = new JLabel("Password");
		label_6.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_6.setBounds(20, 363, 79, 26);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Confirm Password");
		label_7.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_7.setBounds(228, 423, 132, 26);
		contentPane.add(label_7);
		
		confirmepassword = new JTextField();
		confirmepassword.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		confirmepassword.setBackground(new Color(184, 54, 52));
		confirmepassword.setBounds(228, 445, 155, 26);
		contentPane.add(confirmepassword);
		
		numero = new JTextField();
		numero.setEditable(false);
		numero.setForeground(Color.BLACK);
		numero.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		numero.setColumns(16);
		numero.setBackground(new Color(184, 54, 52));
		numero.setBounds(304, 138, 79, 26);
		contentPane.add(numero);
		
		JLabel lblNumro = new JLabel("Num\u00E9ro");
		lblNumro.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblNumro.setBounds(304, 112, 79, 26);
		contentPane.add(lblNumro);
		
		JLabel label_8 = new JLabel("");
		label_8.addMouseListener(new MouseAdapter() {
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
		label_8.setIcon(new ImageIcon(getClass().getResource("/Icones/Logout_37127.png")));
		label_8.setBounds(349, 528, 59, 49);
		contentPane.add(label_8);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(getClass().getResource("/Icones/7.png")));
		label.setBounds(-10, 0, 414, 749);
		contentPane.add(label);
		remplirchamps();
		
	}
	 void remplirchamps() {
		
		 String num=null;
			String adr=null;
			 String sql="select * from banquesangconnecte";
			try {
				preparedStatement=cnx.prepareStatement(sql);
				resultat=preparedStatement.executeQuery();
				if(resultat.next()){
					adr=resultat.getString("adresse");
					num=resultat.getString("numerobs");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sql1="select * from banquesang where adressebs='"+adr+"' and numbs ='"+num+"'";
			try {
				preparedStatement1=cnx1.prepareStatement(sql1);
				resultat1=preparedStatement1.executeQuery();
				if(resultat1.next()){
					numero.setText(resultat1.getString("numbs"));
					adresse.setText(resultat1.getString("adressebs"));
					tel.setText(resultat1.getString("telbs"));
					siege.setSelectedItem(resultat1.getString("siege"));
					username.setText(resultat1.getString("username"));
					password.setText(resultat1.getString("password"));
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	void remplirnomprenom() {
		String adr=null;
		String num=null;
		 String sql="select * from banquesangconnecte";
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			if(resultat.next()){
				adr=resultat.getString("adresse");
				num=resultat.getString("numerobs");
				labelnomprenom = new JLabel(num+" "+adr);
				labelnomprenom.setFont(new Font("Lucida Fax", Font.ITALIC, 13));
				labelnomprenom.setBounds(255,43, 150, 14);
				contentPane.add(labelnomprenom);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		}
	
}
