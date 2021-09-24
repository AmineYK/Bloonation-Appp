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

public class FenMedecinModification extends JFrame {

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
	private JTextField username;
	private JTextField password;
	private JTextField confirmepassword;
	private JTextField numero;
	private JComboBox categorie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new NimbusLookAndFeel());
					FenMedecinModification frame = new FenMedecinModification();
					
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
	public FenMedecinModification() {
		super("Medecin - Modification du Profile");
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
		label_1.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\Doctor_Male_icon-icons.com_75051.png"));
		label_1.setBounds(9, 2, 46, 49);
		contentPane.add(label_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(184, 54, 52));
		panel.setBounds(5, 55, 389, 10);
		contentPane.add(panel);
		
		JLabel label_2 = new JLabel("Medecin");
		label_2.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 24));
		label_2.setBounds(140, 10, 110, 39);
		contentPane.add(label_2);
		
		nom = new JTextField();
		nom.setForeground(Color.BLACK);
		nom.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		nom.setColumns(16);
		nom.setBackground(new Color(184, 54, 52));
		nom.setBounds(20, 167, 155, 26);
		contentPane.add(nom);
		
		JLabel label_3 = new JLabel("Nom");
		label_3.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_3.setBounds(20, 143, 79, 26);
		contentPane.add(label_3);
		
		prenom = new JTextField();
		prenom.setForeground(Color.BLACK);
		prenom.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		prenom.setColumns(16);
		prenom.setBackground(new Color(184, 54, 52));
		prenom.setBounds(228, 219, 155, 26);
		contentPane.add(prenom);
		
		JLabel label_4 = new JLabel("Prenom");
		label_4.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_4.setBounds(228, 193, 79, 26);
		contentPane.add(label_4);
		
		 categorie = new JComboBox();
		categorie.setModel(new DefaultComboBoxModel(new String[] {"G\u00E9n\u00E9raliste", "Sp\u00E8cialiste"}));
		categorie.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		categorie.setBackground(new Color(184, 54, 52));
		categorie.setBounds(20, 272, 155, 26);
		contentPane.add(categorie);
		
		JLabel label_5 = new JLabel("Cat\u00E9gorie");
		label_5.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_5.setBounds(20, 247, 79, 26);
		contentPane.add(label_5);
		
		username = new JTextField();
		username.setForeground(Color.BLACK);
		username.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		username.setColumns(16);
		username.setBackground(new Color(184, 54, 52));
		username.setBounds(228, 328, 155, 26);
		contentPane.add(username);
		
		JLabel label_6 = new JLabel("Username ");
		label_6.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_6.setBounds(228, 306, 79, 26);
		contentPane.add(label_6);
		
		password = new JTextField();
		password.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		password.setBackground(new Color(184, 54, 52));
		password.setBounds(20, 363, 155, 26);
		contentPane.add(password);
		
		JLabel label_7 = new JLabel("Password");
		label_7.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_7.setBounds(20, 339, 79, 26);
		contentPane.add(label_7);
		
		confirmepassword = new JTextField();
		confirmepassword.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		confirmepassword.setBackground(new Color(184, 54, 52));
		confirmepassword.setBounds(228, 438, 155, 26);
		contentPane.add(confirmepassword);
		
		JLabel label_8 = new JLabel("Confirm Password");
		label_8.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_8.setBounds(228, 411, 132, 26);
		contentPane.add(label_8);
		
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
				
				String sql="update medecin set nommedecin = ? ,prenommedecin=?,categorie=?,username=?,password=? where nummedecin ="+numero.getText().toString()+"";
				String sql1="update medecinconnecte set nom = ? ,prenom=? ";
				
				if(username.getText().equals("") || password.getText().equals("") || nom.getText().equals("") 
						|| prenom.getText().equals("") ){
					JOptionPane.showMessageDialog(null,"Remplissez le(s) champ(s) vide(s) ! ");
				}else{
					if(!password.getText().equals(confirmepassword.getText())){
						JOptionPane.showMessageDialog(null,"Please confirm password ! ");
					}else{
						try {
						
							preparedStatement1=cnx1.prepareStatement(sql1);
							preparedStatement1.setString(1,nom.getText().toString());
							preparedStatement1.setString(2,prenom.getText().toString());
							preparedStatement1.execute();
							preparedStatement=cnx.prepareStatement(sql);
							preparedStatement.setString(1,nom.getText().toString());
							preparedStatement.setString(2,prenom.getText().toString());
							preparedStatement.setString(3,categorie.getSelectedItem().toString());
							preparedStatement.setString(4,username.getText().toString());
							preparedStatement.setString(5,password.getText().toString());
							preparedStatement.execute();
							JOptionPane.showMessageDialog(null,"Modification(s) Enregistrée(s) !");
							nom.setText("");
							prenom.setText("");
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
		
		JLabel lblNumro = new JLabel("Num\u00E9ro ");
		lblNumro.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblNumro.setBounds(325, 121, 79, 26);
		contentPane.add(lblNumro);
		
		numero = new JTextField();
		numero.setEditable(false);
		numero.setForeground(Color.BLACK);
		numero.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		numero.setColumns(16);
		numero.setBackground(new Color(184, 54, 52));
		numero.setBounds(325, 143, 59, 26);
		contentPane.add(numero);
		
		JLabel lblModification = new JLabel("Modification");
		lblModification.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 24));
		lblModification.setBounds(110, 76, 167, 39);
		contentPane.add(lblModification);
		
		JLabel label_9 = new JLabel("");
		label_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FenMedecin obj=new FenMedecin();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		label_9.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\arrow-address-back_icon-icons.com_54065.png"));
		label_9.setBounds(9, 70, 59, 39);
		contentPane.add(label_9);
		
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
		
		 String nom1=null;
			String prenom1=null;
			 String sql="select * from medecinconnecte";
			try {
				preparedStatement=cnx.prepareStatement(sql);
				resultat=preparedStatement.executeQuery();
				if(resultat.next()){
					nom1=resultat.getString("nom");
					prenom1=resultat.getString("prenom");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sql1="select * from medecin where nommedecin='"+nom1+"' and prenommedecin ='"+prenom1+"'";
			try {
				preparedStatement1=cnx1.prepareStatement(sql1);
				resultat1=preparedStatement1.executeQuery();
				if(resultat1.next()){
					numero.setText(resultat1.getString("nummedecin"));
					nom.setText(resultat1.getString("nommedecin"));
					prenom.setText(resultat1.getString("prenommedecin"));
					categorie.setSelectedItem(resultat1.getString("categorie"));
					username.setText(resultat1.getString("username"));
					password.setText(resultat1.getString("password"));
					
					
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
				prenom=resultat.getString("prenom");
				labelnomprenom = new JLabel("Dr "+nom+" "+prenom);
				labelnomprenom.setFont(new Font("Lucida Fax", Font.ITALIC, 13));
				labelnomprenom.setBounds(265,38, 150, 14);
				contentPane.add(labelnomprenom);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		}
	
}
