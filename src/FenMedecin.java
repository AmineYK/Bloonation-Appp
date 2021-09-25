import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
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

public class FenMedecin extends JFrame {

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
	private JTextField nom;
	private JTextField prenom;
	private JComboBox numerodon;
	private JComboBox banquesang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new NimbusLookAndFeel());
					FenMedecin frame = new FenMedecin();
					
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
	public FenMedecin() {
		super("Medecin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 621);
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
		
		
		JLabel label_21 = new JLabel("");
		label_21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a=JOptionPane.showConfirmDialog(null,"Voulez-vous Eteindre le logiciel ?","Eteint du Logiciel", JOptionPane.YES_NO_OPTION);
				if(a==0){
			 dispose();
				}
			}
		});
		label_21.setIcon(new ImageIcon(getClass().getResource("/Icones/close_delete_delete_theaction_theoutput_10252.png")));
		label_21.setBounds(392, 5, 32, 38);
		contentPane.add(label_21);
		
		JLabel lblVih = new JLabel("VIH");
		lblVih.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblVih.setBounds(30, 288, 79, 26);
		contentPane.add(lblVih);
		
		JRadioButton rdbtnPositifVIH = new JRadioButton("Positif");
		rdbtnPositifVIH.setFont(new Font("Lucida Fax", Font.ITALIC, 11));
		rdbtnPositifVIH.setBackground(new Color(253, 198, 197));
		rdbtnPositifVIH.setBounds(30, 312, 75, 23);
		contentPane.add(rdbtnPositifVIH);
		
		JRadioButton rdbtnNgatifVIH = new JRadioButton("N\u00E9gatif");
		rdbtnNgatifVIH.setFont(new Font("Lucida Fax", Font.ITALIC, 11));
		rdbtnNgatifVIH.setBackground(new Color(253, 198, 197));
		rdbtnNgatifVIH.setBounds(115, 312, 70, 23);
		contentPane.add(rdbtnNgatifVIH);
		
		 numerodon = new JComboBox();
		numerodon.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		numerodon.setBackground(new Color(184, 54, 52));
		numerodon.setBounds(30, 160, 155, 26);
		contentPane.add(numerodon);
		remplirnumerodon();
		
		
		
		JLabel lblNumeroDuDonneur = new JLabel("Numero du Donneur");
		lblNumeroDuDonneur.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblNumeroDuDonneur.setBounds(30, 135, 155, 26);
		contentPane.add(lblNumeroDuDonneur);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(184,54,52));
		panel.setBounds(10, 54, 414, 10);
		contentPane.add(panel);
		
		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FenMedecinModification obj=new FenMedecinModification();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		label_3.setIcon(new ImageIcon(getClass().getResource("/Icones/Doctor_Male_icon-icons.com_75051.png")));
		label_3.setBounds(15, 2, 46, 49);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Medecin");
		label_4.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 24));
		label_4.setBounds(154, 12, 110, 39);
		contentPane.add(label_4);
		
		nom = new JTextField();
		nom.setForeground(Color.BLACK);
		nom.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		nom.setColumns(16);
		nom.setBackground(new Color(184, 54, 52));
		nom.setBounds(30, 249, 155, 26);
		contentPane.add(nom);
		
		JLabel label_2 = new JLabel("Nom");
		label_2.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_2.setBounds(30, 225, 79, 26);
		contentPane.add(label_2);
		
		prenom = new JTextField();
		prenom.setForeground(Color.BLACK);
		prenom.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		prenom.setColumns(16);
		prenom.setBackground(new Color(184, 54, 52));
		prenom.setBounds(254, 251, 155, 26);
		contentPane.add(prenom);
		remplirnomprenom1();
		
		JLabel label_5 = new JLabel("Prenom");
		label_5.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_5.setBounds(254, 225, 79, 26);
		contentPane.add(label_5);
		
		JLabel lblVhb = new JLabel("VHB");
		lblVhb.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblVhb.setBounds(254, 288, 79, 26);
		contentPane.add(lblVhb);
		
		JLabel lblSyphilis = new JLabel("SYPHILIS");
		lblSyphilis.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblSyphilis.setBounds(254, 380, 79, 26);
		contentPane.add(lblSyphilis);
		
		JLabel lblVhc = new JLabel("VHC");
		lblVhc.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblVhc.setBounds(30, 380, 79, 26);
		contentPane.add(lblVhc);
		
		JRadioButton negatifVHB = new JRadioButton("N\u00E9gatif");
		negatifVHB.setFont(new Font("Lucida Fax", Font.ITALIC, 11));
		negatifVHB.setBackground(new Color(253, 198, 197));
		negatifVHB.setBounds(339, 312, 70, 23);
		contentPane.add(negatifVHB);
		
		JRadioButton positifVHB = new JRadioButton("Positif");
		positifVHB.setFont(new Font("Lucida Fax", Font.ITALIC, 11));
		positifVHB.setBackground(new Color(253, 198, 197));
		positifVHB.setBounds(254, 312, 75, 23);
		contentPane.add(positifVHB);
		
		JRadioButton negatifSYPH = new JRadioButton("N\u00E9gatif");
		negatifSYPH.setFont(new Font("Lucida Fax", Font.ITALIC, 11));
		negatifSYPH.setBackground(new Color(253, 198, 197));
		negatifSYPH.setBounds(339, 410, 70, 23);
		contentPane.add(negatifSYPH);
		
		JRadioButton positifSYPH = new JRadioButton("Positif");
		positifSYPH.setFont(new Font("Lucida Fax", Font.ITALIC, 11));
		positifSYPH.setBackground(new Color(253, 198, 197));
		positifSYPH.setBounds(254, 410, 75, 23);
		contentPane.add(positifSYPH);
		
		JRadioButton negatifVHC = new JRadioButton("N\u00E9gatif");
		negatifVHC.setFont(new Font("Lucida Fax", Font.ITALIC, 11));
		negatifVHC.setBackground(new Color(253, 198, 197));
		negatifVHC.setBounds(109, 410, 70, 23);
		contentPane.add(negatifVHC);
		
		JRadioButton positifVHC = new JRadioButton("Positif");
		positifVHC.setFont(new Font("Lucida Fax", Font.ITALIC, 11));
		positifVHC.setBackground(new Color(253, 198, 197));
		positifVHC.setBounds(24, 410, 75, 23);
		contentPane.add(positifVHC);
		
		ButtonGroup group = new ButtonGroup();
		group.add(positifVHC);
		group.add(negatifVHC);
		ButtonGroup group1 = new ButtonGroup();
		group1.add(positifVHB);
		group1.add(negatifVHB);
		ButtonGroup group2 = new ButtonGroup();
		group2.add(positifSYPH);
		group2.add(negatifSYPH); 
		ButtonGroup group3 = new ButtonGroup();
		group3.add(rdbtnPositifVIH);
		group3.add(rdbtnNgatifVIH);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy/MM/dd");
		dateChooser.setBackground(new Color(184, 54, 52));
		dateChooser.setBounds(254, 160, 155, 26);
		contentPane.add(dateChooser);
		
		JButton btnValiderConsultation = new JButton("Valider Consultation");
		btnValiderConsultation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnValiderConsultation.setBackground(new Color(253,198,197));
				btnValiderConsultation.setForeground(Color.BLACK);
			}	
			public void mouseExited(MouseEvent e) {
				btnValiderConsultation.setBackground(new Color(184,54,52));
				btnValiderConsultation.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				String sql1="select * from medecinconnecte";
				String nom1=null;
				String prenom1=null;
				String resultat=null,vih=null,vhb=null,vhc=null,syph=null;
				
				
				try {
					preparedStatement1=cnx1.prepareStatement(sql1);
					resultat1=preparedStatement1.executeQuery();
					if(resultat1.next()){
						nom1=resultat1.getString("nom");
						prenom1=resultat1.getString("prenom");
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				
				
				
				
				
				String sql="insert into consultation (nomdonneur,prenomdonneur,resultat,datecons,nommed,prenommed,vih,vhb,vhc,syphilis,banquedesang) values (?,?,?,?,?,?,?,?,?,?,? )";
				if(nom.getText().equals("") || prenom.getText().equals("") || (!rdbtnNgatifVIH.isSelected() && !rdbtnPositifVIH.isSelected()) 
						|| (!negatifVHB.isSelected() && !positifVHB.isSelected()) || (!negatifSYPH.isSelected() && !positifSYPH.isSelected())
						| (!positifVHC.isSelected() && !negatifVHC.isSelected())){
					JOptionPane.showMessageDialog(null,"Remplissez le(s) champ(s) vide(s) ! ");
				}else{
					String dt = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
					 if(!rdbtnNgatifVIH.isSelected() || !negatifSYPH.isSelected() || !negatifVHC.isSelected() || !negatifVHB.isSelected() ){
						 resultat="Positif";
					 }else{
						 resultat="Négatif";
					 }
					 if(positifSYPH.isSelected()){syph="Positif";}else{syph="Négatif";}
					 if(positifVHB.isSelected()){vhb="Positif";}else{vhb="Négatif";}
					 if(positifVHC.isSelected()){vhc="Positif";}else{vhc="Négatif";}
					 if(rdbtnPositifVIH.isSelected()){vih="Positif";}else{vih="Négatif";}
					 
						try {
							preparedStatement=cnx.prepareStatement(sql);
							preparedStatement.setString(1,nom.getText().toString());
							preparedStatement.setString(2,prenom.getText().toString());
							preparedStatement.setString(3,resultat);
							preparedStatement.setString(4,dt);
							preparedStatement.setString(5,NOMM);
							preparedStatement.setString(6,PRENOMM);
							preparedStatement.setString(7,vih);
							preparedStatement.setString(8,vhb);
							preparedStatement.setString(9,vhc);
							preparedStatement.setString(10,syph);
							preparedStatement.setString(11,banquesang.getSelectedItem().toString());
							preparedStatement.execute();
							JOptionPane.showMessageDialog(null,"Consultation enregistrée!");
							nom.setText("");
							prenom.setText("");
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null,"Selectionnez une date");
						}
						
					
				
			}

			
			}
		});
		btnValiderConsultation.setForeground(Color.BLACK);
		btnValiderConsultation.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 13));
		btnValiderConsultation.setBackground(new Color(184, 54, 52));
		btnValiderConsultation.setBounds(128, 557, 176, 32);
		contentPane.add(btnValiderConsultation);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				remplirnomprenom1();
			}
		});
		label_1.setIcon(new ImageIcon(getClass().getResource("/Icones/refresh-arrow_icon-icons.com_53911 (1).png")));
		
		label_1.setBounds(28, 191, 46, 36);
		contentPane.add(label_1);
		
		JLabel label_6 = new JLabel("Consultation");
		label_6.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 24));
		label_6.setBounds(128, 70, 167, 39);
		contentPane.add(label_6);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblDate.setBounds(254, 135, 155, 26);
		contentPane.add(lblDate);
		
		JLabel lblBanqueDeSang = new JLabel("Banque de Sang");
		lblBanqueDeSang.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblBanqueDeSang.setBounds(30, 449, 155, 26);
		contentPane.add(lblBanqueDeSang);
		
		 banquesang = new JComboBox();
		banquesang.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		banquesang.setBackground(new Color(184, 54, 52));
		banquesang.setBounds(30, 474, 214, 26);
		contentPane.add(banquesang);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(getClass().getResource("/Icones/2.png")));
		label.setBounds(-11, -13, 450, 641);
		contentPane.add(label);
		remplirbanquesang();
	}

	  void remplirnumerodon() {
		 
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
		 String sql="select * from donneur where numdonneur = '"+numerodon.getSelectedItem().toString()+"'";
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
		
			
		}
}
