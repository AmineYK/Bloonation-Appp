import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;

public class FenDonneurDemandeur extends JFrame {

	private JPanel contentPane;
	private CardLayout cardLayout;
	private JPanel paneldon;
	private JPanel paneldonnneur;
	private JPanel panelstock;
	private JPanel panelactivite;
	private JPanel panelprincipale;
	Connection cnx=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultat=null;
	Connection cnx2=null;
	PreparedStatement preparedStatement2=null;
	ResultSet resultat2=null;
	Connection cnx3=null;
	PreparedStatement preparedStatement3=null;
	ResultSet resultat3=null;
	Connection cnx4=null;
	PreparedStatement preparedStatement4=null;
	ResultSet resultat4=null;
	int a=0;
	int aa=0;
	int b=0;
	int c=0;
	private JTable table;
	private JTable table_1;
	private String adr=null;
	private String adr1=null;
	private String adr2=null;
	private JPanel panelcarnet;
	private JPanel paneldemande;
	private JPanel panelconsult;
	private JPanel panelnotifs;
	private JTextField nom;
	private JTextField prenom;
	private JTextField nomdest;
	String[] vvv;
	private JTextField prenomdest;
	private JTextField nb;
	private JComboBox groupesanguin;
	private JComboBox banquedesang;
	private JDateChooser dateChooser;
	private JComboBox quantite;
	private JTable tablereponses;
	private JTable tablecarnets;
	private JLabel lblAaaaAEssay;
	private JLabel label_18;
	private JLabel lblVousEtesDeja;
	private JLabel lblConsultezVotreCarnet;
	private JTable tableremarques;
	private JTextField banquedesangRQ;
	private JTextArea textArea;
	private JLabel lblerror4;
	private JLabel lblVotreDemandeDe;
	private JTable tablebanquedesang;
	private JTextField nb1;
	private JLabel lblerror41;
	private JCheckBox chckbxJapporteDesDonneurs;
	private Container lblDonneurs;
	private JLabel lblActivits;
	private JLabel lblBanqueDeSang_2;
	private JLabel lblDeSang;
	private JLabel lblDeSant;;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new NimbusLookAndFeel());
					FenDonneurDemandeur frame = new FenDonneurDemandeur();
					
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
	public FenDonneurDemandeur() {
		super("Donneur/Demandeur");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 422);
		super.setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ImageIcon obj1  = new ImageIcon(getClass().getResource("/Icones/transfuse_38039.png"));
		super.setIconImage(obj1.getImage());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		cnx=ConnexionMySql.ConnectionDB();
		cnx2=ConnexionMySql.ConnectionDB();
		cnx3=ConnexionMySql.ConnectionDB();
		cnx4=ConnexionMySql.ConnectionDB();
		
		JLabel label_2 = new JLabel("BlooNation");
		label_2.setFont(new Font("Lucida Handwriting", Font.BOLD | Font.ITALIC, 17));
		label_2.setBounds(2, 373, 135, 32);
		contentPane.add(label_2);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int a=JOptionPane.showConfirmDialog(null,"Voulez-vous eteindre le logiciel ?","Eteint du Logiciel", JOptionPane.YES_NO_OPTION);
				if(a==0){
			 dispose();
				}
			}
		});
		label_1.setIcon(new ImageIcon(getClass().getResource("/Icones/close_delete_delete_theaction_theoutput_10252.png")));
		label_1.setBounds(2, 4, 32, 38);
		contentPane.add(label_1);
		
		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FenDonneurDemandeurModification obj = new FenDonneurDemandeurModification();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		label_3.setIcon(new ImageIcon(getClass().getResource("/Icones/Patient_Male_icon-icons.com_75053.png")));
		label_3.setBounds(80, 8, 46, 49);
		contentPane.add(label_3);
		
		JLabel lblDons = new JLabel("          Carnet ");
		lblDons.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				panelcarnet.setVisible(true);
				paneldemande.setVisible(false);
				lblDons.setForeground(Color.white);
				lblDeSant.setForeground(Color.white);
				lblDonneurs.setForeground(Color.black);
				lblBanqueDeSang_2.setForeground(Color.black);
				lblActivits.setForeground(Color.black);
				lblDeSang.setForeground(Color.black);
				/*vertBS.setVisible(true);
				vertdd.setVisible(false);
				vertmed.setVisible(false);
				*/
				cardLayout.show(panelprincipale,"1");
				
				
				
			}
		});
		lblDons.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblDons.setBounds(-2, 75, 139, 32);
		contentPane.add(lblDons);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 255));
		panel_1.setBounds(10, 119, 113, 7);
		contentPane.add(panel_1);
		
		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				panelcarnet.setVisible(true);
				paneldemande.setVisible(false);
				lblDons.setForeground(Color.white);
				lblDeSant.setForeground(Color.white);
				lblDonneurs.setForeground(Color.black);
				lblBanqueDeSang_2.setForeground(Color.black);
				lblActivits.setForeground(Color.black);
				lblDeSang.setForeground(Color.black);
				/*vertBS.setVisible(true);
				vertdd.setVisible(false);
				vertmed.setVisible(false);
				*/
				cardLayout.show(panelprincipale,"1");
				
				
				
			}
		});
		label_4.setIcon(new ImageIcon(getClass().getResource("/Icones/addressbook_36282.png")));
		label_4.setBounds(3, 81, 32, 39);
		contentPane.add(label_4);
		
		 lblDonneurs = new JLabel("       Demandes");
		lblDonneurs.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				panelcarnet.setVisible(false);
				paneldemande.setVisible(true);
				lblDons.setForeground(Color.black);
				lblDeSant.setForeground(Color.black);
				lblDonneurs.setForeground(Color.white);
				lblBanqueDeSang_2.setForeground(Color.black);
				lblActivits.setForeground(Color.black);
				lblDeSang.setForeground(Color.black);
				
				/*vertBS.setVisible(true);
				vertdd.setVisible(false);
				vertmed.setVisible(false);
				*/
				cardLayout.show(panelprincipale,"2");
				
				
				
			}
		});
		lblDonneurs.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblDonneurs.setBounds(0, 158, 139, 39);
		contentPane.add(lblDonneurs);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 204, 255));
		panel_2.setBounds(14, 193, 113, 7);
		contentPane.add(panel_2);
		
		JLabel label_6 = new JLabel("");
		label_6.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				panelcarnet.setVisible(false);
				paneldemande.setVisible(true);
				lblDons.setForeground(Color.black);
				lblDeSant.setForeground(Color.black);
				lblDonneurs.setForeground(Color.white);
				lblBanqueDeSang_2.setForeground(Color.black);
				lblActivits.setForeground(Color.black);
				lblDeSang.setForeground(Color.black);
				/*vertBS.setVisible(true);
				vertdd.setVisible(false);
				vertmed.setVisible(false);
				*/
				cardLayout.show(panelprincipale,"2");
				
				
				
			}
		});
		label_6.setIcon(new ImageIcon(getClass().getResource("/Icones/document_report_16751.png")));
		label_6.setBounds(4, 155, 32, 39);
		contentPane.add(label_6);
		
		JLabel label_8 = new JLabel("");
		label_8.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				panelcarnet.setVisible(false);
				paneldemande.setVisible(false);
				panelconsult.setVisible(false);
				panelnotifs.setVisible(true);	
				lblDons.setForeground(Color.black);
				lblDeSant.setForeground(Color.black);
				lblDonneurs.setForeground(Color.black);
				lblBanqueDeSang_2.setForeground(Color.black);
				lblActivits.setForeground(Color.white);
				lblDeSang.setForeground(Color.black);
				/*vertBS.setVisible(true);
				vertdd.setVisible(false);
				vertmed.setVisible(false);
				*/
				cardLayout.show(panelprincipale,"3");
				
				
				
			}
		});
		label_8.setIcon(new ImageIcon(getClass().getResource("/Icones/iconfinder-bellnotificationsnoticenotifyalert-3993856_112639.png")));
		label_8.setBounds(2, 227, 32, 39);
		contentPane.add(label_8);
		
		 lblActivits = new JLabel("     Notifications");
		lblActivits.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				panelcarnet.setVisible(false);
				paneldemande.setVisible(false);
				panelconsult.setVisible(false);
				panelnotifs.setVisible(true);
				lblDons.setForeground(Color.black);
				lblDeSant.setForeground(Color.black);
				lblDonneurs.setForeground(Color.black);
				lblBanqueDeSang_2.setForeground(Color.black);
				lblActivits.setForeground(Color.white);
				lblDeSang.setForeground(Color.black);
				/*vertBS.setVisible(true);
				vertdd.setVisible(false);
				vertmed.setVisible(false);
				*/
				cardLayout.show(panelprincipale,"3");
				
				
				
			}
		});
		lblActivits.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblActivits.setBounds(2, 228, 139, 39);
		contentPane.add(lblActivits);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 204, 255));
		panel_4.setBounds(13, 263, 113, 7);
		contentPane.add(panel_4);
		
		JLabel label_5 = new JLabel("by AmineYK");
		label_5.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		label_5.setBounds(45, 399, 88, 14);
		contentPane.add(label_5);
		
		 panelprincipale = new JPanel();
		panelprincipale.setBounds(141, 0, 846, 421);
		contentPane.add(panelprincipale);
		cardLayout = new CardLayout(0, 0);
		panelprincipale.setLayout(cardLayout);
		
		panelcarnet = new JPanel();
		panelprincipale.add(panelcarnet, "1");
		panelcarnet.setLayout(null);
		paneldemande = new JPanel();
		panelprincipale.add(paneldemande, "2");
		paneldemande.setLayout(null);
		
		nom = new JTextField();
		nom.setEditable(false);
		nom.setForeground(Color.BLACK);
		nom.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		nom.setColumns(16);
		nom.setBackground(new Color(184, 54, 52));
		nom.setBounds(10, 46, 155, 26);
		paneldemande.add(nom);
		
		JLabel label_13 = new JLabel("Nom");
		label_13.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_13.setBounds(10, 22, 79, 26);
		paneldemande.add(label_13);
		
		JLabel label_14 = new JLabel("Prenom");
		label_14.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_14.setBounds(176, 22, 79, 26);
		paneldemande.add(label_14);
		
		prenom = new JTextField();
		prenom.setEditable(false);
		prenom.setForeground(Color.BLACK);
		prenom.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		prenom.setColumns(16);
		prenom.setBackground(new Color(184, 54, 52));
		prenom.setBounds(176, 46, 155, 26);
		paneldemande.add(prenom);
		
		 quantite = new JComboBox();
		quantite.setModel(new DefaultComboBoxModel(new String[] {"500"}));
		quantite.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		quantite.setBackground(new Color(184, 54, 52));
		quantite.setBounds(176, 203, 155, 26);
		paneldemande.add(quantite);
		
		JLabel lblQauntit = new JLabel("Quantit\u00E9 ");
		lblQauntit.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblQauntit.setBounds(176, 178, 119, 26);
		paneldemande.add(lblQauntit);
		
		JLabel lblNomDuDestinataire = new JLabel("Nom du Destinataire");
		lblNomDuDestinataire.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblNomDuDestinataire.setBounds(10, 105, 155, 26);
		paneldemande.add(lblNomDuDestinataire);
		
		nomdest = new JTextField();
		nomdest.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				if(key==10){
					prenomdest.requestFocus();
				}
			}
		});
		nomdest.setForeground(Color.BLACK);
		nomdest.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		nomdest.setColumns(16);
		nomdest.setBackground(new Color(184, 54, 52));
		nomdest.setBounds(10, 129, 155, 26);
		paneldemande.add(nomdest);
		
		prenomdest = new JTextField();
		prenomdest.setForeground(Color.BLACK);
		prenomdest.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		prenomdest.setColumns(16);
		prenomdest.setBackground(new Color(184, 54, 52));
		prenomdest.setBounds(176, 129, 155, 26);
		paneldemande.add(prenomdest);
		
		JLabel lblPrenomDuDestinataire = new JLabel("Prenom du Destinataire");
		lblPrenomDuDestinataire.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblPrenomDuDestinataire.setBounds(176, 105, 155, 26);
		paneldemande.add(lblPrenomDuDestinataire);
		
		 groupesanguin = new JComboBox();
		 groupesanguin.setModel(new DefaultComboBoxModel(new String[] {"A-", "A+", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
		groupesanguin.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		groupesanguin.setBackground(new Color(184, 54, 52));
		groupesanguin.setBounds(10, 203, 155, 26);
		paneldemande.add(groupesanguin);
		
		JLabel label_19 = new JLabel("Groupe Sanguin");
		label_19.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_19.setBounds(10, 178, 119, 26);
		paneldemande.add(label_19);
		
		 banquedesang = new JComboBox();
		banquedesang.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		banquedesang.setBackground(new Color(184, 54, 52));
		banquedesang.setBounds(10, 284, 155, 26);
		paneldemande.add(banquedesang);
		
		JLabel lblBanqueDeSang = new JLabel("Banque de Sang");
		lblBanqueDeSang.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblBanqueDeSang.setBounds(10, 257, 119, 26);
		paneldemande.add(lblBanqueDeSang);
		
		 dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy/MM/dd");
		dateChooser.setBackground(new Color(184, 54, 52));
		dateChooser.setBounds(176, 284, 155, 26);
		paneldemande.add(dateChooser);
		
		JLabel label_21 = new JLabel("Date");
		label_21.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_21.setBounds(176, 257, 136, 26);
		paneldemande.add(label_21);
		
		nb = new JTextField();
		nb.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int ccc = e.getKeyChar();
				if(Character.isAlphabetic(ccc)){
					nb.setEditable(false);
					lblerror4.setText("Invalide");
				}else{
					nb.setEditable(true);
					lblerror4.setText("");
				}
			}
		});
		nb.setForeground(Color.BLACK);
		nb.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		nb.setColumns(16);
		nb.setBackground(new Color(184, 54, 52));
		nb.setBounds(305, 335, 31, 26);
		paneldemande.add(nb);
		
		nb1 = new JTextField();
		nb1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int ccc = e.getKeyChar();
				if(Character.isAlphabetic(ccc)){
					nb1.setEditable(false);
					lblerror41.setText("Invalide");
				}else{
					nb1.setEditable(true);
					lblerror41.setText("");
				}
			}
		});
		nb1.setForeground(Color.BLACK);
		nb1.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		nb1.setColumns(16);
		nb1.setBackground(new Color(184, 54, 52));
		nb1.setBounds(341, 203, 31, 26);
		paneldemande.add(nb1);
		
		lblerror4 = new JLabel("");
		lblerror4.setForeground(Color.RED);
		lblerror4.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		lblerror4.setBounds(282, 360, 79, 14);
		paneldemande.add(lblerror4);
		
		lblerror41 = new JLabel("");
		lblerror41.setForeground(Color.RED);
		lblerror41.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		lblerror41.setBounds(325, 230, 79, 14);
		paneldemande.add(lblerror41);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnValider.setBackground(new Color(253,198,197));
				btnValider.setForeground(Color.BLACK);
			}	
			public void mouseExited(MouseEvent e) {
				btnValider.setBackground(new Color(184,54,52));
				btnValider.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
                    
				    
					
						
						if(nomdest.getText().equals("") ||prenomdest.getText().equals("") ||
								nb1.getText().equals("") ){
							JOptionPane.showMessageDialog(null,"Remplissez le(s) champ(s) vide(s) ");
						}else{
							int a=0;
							int b=0;
							String SS=null;
							String xcv="En Attente";
							a=Integer.valueOf(nb1.getText().toString());
							if(a==0){JOptionPane.showMessageDialog(null,"Nombre de flacons invalide !");}
							else{
							if(a>=10){JOptionPane.showMessageDialog(null,"Vous n'avez pas le privilége d'avoir plus de 10 falcons !");}
							else{
								if(chckbxJapporteDesDonneurs.isSelected() && nb.getText().equals("")){
									JOptionPane.showMessageDialog(null,"Remplissez le champ du nombre de donneurs !");
								}else{
								String sql="insert into demandesang (nomdemandeur,prenomdemandeur,nomdest,prenomdest,datedemande,groupesang,qtesac,decision,banquedesang) values (?,?,?,?,?,?,?,?, ? )";
						try {
							String dt = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
							preparedStatement=cnx.prepareStatement(sql);
							preparedStatement.setString(1,nom.getText().toString());
							preparedStatement.setString(2,prenom.getText().toString());
							preparedStatement.setString(3,nomdest.getText().toString());
							preparedStatement.setString(4,prenomdest.getText().toString());
							preparedStatement.setString(5,dt);
							preparedStatement.setString(6,groupesanguin.getSelectedItem().toString());
							b=Integer.valueOf(quantite.getSelectedItem().toString());
							SS = String.valueOf(a*b);
							preparedStatement.setString(7,SS);
							preparedStatement.setString(8,xcv);
							preparedStatement.setString(9,banquedesang.getSelectedItem().toString());
							preparedStatement.execute();
							JOptionPane.showMessageDialog(null,"Demande Validée et Envoyée!");
							nomdest.setText("");
							prenomdest.setText("");
							nb.setText("0");
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null,"Inserez la date!");
						}
					
						}}}}
				
				

			}
		});
		btnValider.setForeground(Color.BLACK);
		btnValider.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 13));
		btnValider.setBackground(new Color(184, 54, 52));
		btnValider.setBounds(110, 380, 119, 30);
		paneldemande.add(btnValider);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(184, 54, 52));
		panel_5.setBounds(382, 11, 454, 399);
		paneldemande.add(panel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 434, 377);
		panel_5.add(scrollPane);
		
		tablereponses = new JTable();
		tablereponses.setBackground(new Color(252,198, 197));
		tablereponses.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		scrollPane.setViewportView(tablereponses);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblNombre.setBounds(326, 178, 58, 26);
		paneldemande.add(lblNombre);
		
		 chckbxJapporteDesDonneurs = new JCheckBox("j'apporte de(s) donneur(s)");
		chckbxJapporteDesDonneurs.setBackground(new Color(255, 204, 255));
		chckbxJapporteDesDonneurs.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		chckbxJapporteDesDonneurs.setBounds(10, 336, 196, 23);
		paneldemande.add(chckbxJapporteDesDonneurs);
		
		JLabel label_27 = new JLabel("Nombre");
		label_27.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_27.setBounds(237, 335, 58, 26);
		paneldemande.add(label_27);
		
		
		
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(-64, 0, 900, 421);
		label_9.setIcon(new ImageIcon(getClass().getResource("/Icones/12.png")));
		paneldemande.add(label_9);
		
		panelconsult = new JPanel();
		panelprincipale.add(panelconsult, "4");
		panelconsult.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(184, 54, 52));
		panel_6.setBounds(20, 11, 816, 399);
		panelconsult.add(panel_6);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 11, 796, 377);
		panel_6.add(scrollPane_3);
		
		tablebanquedesang = new JTable();
		tablebanquedesang.setBackground(new Color(252,198, 197));
		tablebanquedesang.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		scrollPane_3.setViewportView(tablebanquedesang);
		
		
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon(getClass().getResource("/Icones/12.png")));
		label_11.setBounds(-25, 0, 886, 421);
		panelconsult.add(label_11);
		panelnotifs = new JPanel();
		panelprincipale.add(panelnotifs, "3");
		panelnotifs.setLayout(null);
		
		 lblAaaaAEssay = new JLabel("Aucun Appel en absence ");
		lblAaaaAEssay.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblAaaaAEssay.setBounds(43, 50, 370, 39);
		panelnotifs.add(lblAaaaAEssay);
		
		JLabel label_15 = new JLabel("");
		label_15.setText(
		           DateFormat.getDateTimeInstance().format(new Date())
		         );
		label_15.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_15.setBounds(256, 0, 242, 39);
		panelnotifs.add(label_15);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(184, 54, 52));
		panel.setBounds(255, 32, 153, 7);
		panelnotifs.add(panel);
		
		JLabel label_16 = new JLabel("");
		label_16.setIcon(new ImageIcon(getClass().getResource("/Icones/phone-volume_icon-icons.com_56474 (1).png")));
		label_16.setBounds(4, 47, 46, 46);
		panelnotifs.add(label_16);
		
		JLabel label_17 = new JLabel("");
		label_17.setIcon(new ImageIcon(getClass().getResource("/Icones/email-envelope-outline-shape-with-rounded-corners_icon-icons.com_56530.png")));
		label_17.setBounds(3, 171, 46, 46);
		panelnotifs.add(label_17);
		
		 label_18 = new JLabel(" Aucun email recu  ");
		label_18.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_18.setBounds(39, 174, 370, 39);
		panelnotifs.add(label_18);
		
		JLabel label_20 = new JLabel("");
		label_20.setIcon(new ImageIcon(getClass().getResource("/Icones/hospital_medical_consultation_icon_140164 (1).png")));
		label_20.setBounds(4, 302, 46, 46);
		panelnotifs.add(label_20);
		
		 lblVousEtesDeja = new JLabel("Vous etes deja pass\u00E9 chez le medecin ");
		lblVousEtesDeja.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblVousEtesDeja.setBounds(38, 297, 370, 39);
		panelnotifs.add(lblVousEtesDeja);
		
		 lblConsultezVotreCarnet = new JLabel("  Consultez votre carnet de sant\u00E9");
		lblConsultezVotreCarnet.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblConsultezVotreCarnet.setBounds(41, 314, 370, 39);
		panelnotifs.add(lblConsultezVotreCarnet);
		
		JLabel label_22 = new JLabel("");
		label_22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String adrrr1=null;
				String adrrr2=null;
				String adrrr3=null;
				int cpt=0;
				String sql1="select * from donneurconnecte";
				try {
					preparedStatement2=cnx2.prepareStatement(sql1);
					resultat2=preparedStatement2.executeQuery();
					if(resultat2.next()){
						adrrr1=resultat2.getString("nomdonneurconnecte");
						adrrr2=resultat2.getString("prenomdonneurconnecte");
					}
					
				} catch (SQLException Qe) {
					// TODO Auto-generated catch block
					Qe.printStackTrace();
				}
				String sql2="select * from nombretel where nom='"+adrrr1+"' and prenom='"+adrrr2+"'";
				try {
					preparedStatement3=cnx3.prepareStatement(sql2);
					resultat3=preparedStatement3.executeQuery();
					if(resultat3.next()){
						adrrr3=resultat3.getString("bs");
					}
					
				} catch (SQLException ce) {
					// TODO Auto-generated catch block
					ce.printStackTrace();			
			
		}        
				int a = JOptionPane.showConfirmDialog(null,"Voulez-vous effacer ces appels ?","Suppression d'emails",JOptionPane.YES_NO_CANCEL_OPTION);
				if(a==0){
				String sql="delete from telephone where nomdonneur='"+adrrr1+"' and prenomdonneur='"+adrrr2+"' and banquedesang ='"+adrrr3+"'";
				try {
					preparedStatement=cnx.prepareStatement(sql);
					preparedStatement.execute();
					joindretel();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		label_22.setIcon(new ImageIcon(getClass().getResource("/Icones/seo-social-web-network-internet_262_icon-icons.com_61518.png")));
		label_22.setBounds(156, 84, 46, 46);
		panelnotifs.add(label_22);
		
		JLabel lblEffacer = new JLabel("Effacer");
		lblEffacer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String adrrr1=null;
				String adrrr2=null;
				String adrrr3=null;
				int cpt=0;
				String sql1="select * from donneurconnecte";
				try {
					preparedStatement2=cnx2.prepareStatement(sql1);
					resultat2=preparedStatement2.executeQuery();
					if(resultat2.next()){
						adrrr1=resultat2.getString("nomdonneurconnecte");
						adrrr2=resultat2.getString("prenomdonneurconnecte");
					}
					
				} catch (SQLException Qe) {
					// TODO Auto-generated catch block
					Qe.printStackTrace();
				}
				String sql2="select * from nombretel where nom='"+adrrr1+"' and prenom='"+adrrr2+"'";
				try {
					preparedStatement3=cnx3.prepareStatement(sql2);
					resultat3=preparedStatement3.executeQuery();
					if(resultat3.next()){
						adrrr3=resultat3.getString("bs");
					}
					
				} catch (SQLException ce) {
					// TODO Auto-generated catch block
					ce.printStackTrace();			
			
		}        
				int a = JOptionPane.showConfirmDialog(null,"Voulez-vous effacer ces appels ?","Suppression d'emails",JOptionPane.YES_NO_CANCEL_OPTION);
				if(a==0){
				String sql="delete from telephone where nomdonneur='"+adrrr1+"' and prenomdonneur='"+adrrr2+"' and banquedesang ='"+adrrr3+"'";
				try {
					preparedStatement=cnx.prepareStatement(sql);
					preparedStatement.execute();
					joindretel();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		lblEffacer.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 13));
		lblEffacer.setBounds(190, 89, 62, 39);
		panelnotifs.add(lblEffacer);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(184, 54, 52));
		panel_10.setBounds(126, 127, 153, 7);
		panelnotifs.add(panel_10);
		
		JLabel label_23 = new JLabel("");
		label_23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String adrrr1=null;
				String adrrr2=null;
				String adrrr3=null;
				int cpt=0;
				String sql1="select * from donneurconnecte";
				try {
					preparedStatement2=cnx2.prepareStatement(sql1);
					resultat2=preparedStatement2.executeQuery();
					if(resultat2.next()){
						adrrr1=resultat2.getString("nomdonneurconnecte");
						adrrr2=resultat2.getString("prenomdonneurconnecte");
					}
					
				} catch (SQLException Qe) {
					// TODO Auto-generated catch block
					Qe.printStackTrace();
				}
				String sql2="select * from nombremail where nom='"+adrrr1+"' and prenom='"+adrrr2+"'";
				try {
					preparedStatement3=cnx3.prepareStatement(sql2);
					resultat3=preparedStatement3.executeQuery();
					if(resultat3.next()){
						adrrr3=resultat3.getString("bs");
					}
					
				} catch (SQLException ce) {
					// TODO Auto-generated catch block
					ce.printStackTrace();			
			
		}        
				int a = JOptionPane.showConfirmDialog(null,"Voulez-vous effacer ces emails ?","Suppression d'emails",JOptionPane.YES_NO_CANCEL_OPTION);
				if(a==0){
				String sql="delete from email where nomdonneur='"+adrrr1+"' and prenomdonneur='"+adrrr2+"' and banquedesang ='"+adrrr3+"'";
				try {
					preparedStatement=cnx.prepareStatement(sql);
					preparedStatement.execute();
					joindreemail();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		label_23.setIcon(new ImageIcon(getClass().getResource("/Icones/seo-social-web-network-internet_262_icon-icons.com_61518.png")));
		label_23.setBounds(152, 205, 46, 46);
		panelnotifs.add(label_23);
		
		JLabel label_24 = new JLabel("Effacer");
		label_24.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String adrrr1=null;
				String adrrr2=null;
				String adrrr3=null;
				int cpt=0;
				String sql1="select * from donneurconnecte";
				try {
					preparedStatement2=cnx2.prepareStatement(sql1);
					resultat2=preparedStatement2.executeQuery();
					if(resultat2.next()){
						adrrr1=resultat2.getString("nomdonneurconnecte");
						adrrr2=resultat2.getString("prenomdonneurconnecte");
					}
					
				} catch (SQLException Qe) {
					// TODO Auto-generated catch block
					Qe.printStackTrace();
				}
				String sql2="select * from nombremail where nom='"+adrrr1+"' and prenom='"+adrrr2+"'";
				try {
					preparedStatement3=cnx3.prepareStatement(sql2);
					resultat3=preparedStatement3.executeQuery();
					if(resultat3.next()){
						adrrr3=resultat3.getString("bs");
					}
					
				} catch (SQLException ce) {
					// TODO Auto-generated catch block
					ce.printStackTrace();			
			
		}        
				int a = JOptionPane.showConfirmDialog(null,"Voulez-vous effacer ces emails ?","Suppression d'emails",JOptionPane.YES_NO_CANCEL_OPTION);
				if(a==0){
				String sql="delete from email where nomdonneur='"+adrrr1+"' and prenomdonneur='"+adrrr2+"' and banquedesang ='"+adrrr3+"'";
				try {
					preparedStatement=cnx.prepareStatement(sql);
					preparedStatement.execute();
					joindreemail();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		label_24.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 13));
		label_24.setBounds(186, 210, 62, 39);
		panelnotifs.add(label_24);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(184, 54, 52));
		panel_11.setBounds(122, 248, 153, 7);
		panelnotifs.add(panel_11);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(184, 54, 52));
		panel_8.setBounds(423, 11, 413, 228);
		panelnotifs.add(panel_8);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 393, 206);
		panel_8.add(scrollPane_2);
		
		tableremarques = new JTable();
		tableremarques.addMouseListener(new MouseAdapter() {
			private JLabel label_32;

			@Override
			public void mouseClicked(MouseEvent e) {
			int ligne = tableremarques.getSelectedRow();
			String id = tableremarques.getModel().getValueAt(ligne,0).toString();
			
			String adrrr1=null;
			String adrrr2=null;
			String sql1="select * from donneurconnecte";
			try {
				preparedStatement2=cnx2.prepareStatement(sql1);
				resultat2=preparedStatement2.executeQuery();
				if(resultat2.next()){
					adrrr1=resultat2.getString("nomdonneurconnecte");
					adrrr2=resultat2.getString("prenomdonneurconnecte");
				}
				
			} catch (SQLException ee) {
				// TODO Auto-generated catch block
				ee.printStackTrace();
			}
			String sql="select numcontact,remarque,banquedesang from contact where nomdonneur='"+adrrr1+"' and prenomdonneur='"+adrrr2+"'";
			try {
				preparedStatement=cnx.prepareStatement(sql);
				resultat=preparedStatement.executeQuery();
				if(resultat.next()){
					banquedesangRQ.setText(resultat.getString("banquedesang"));
					textArea.setText(resultat.getString("remarque"));
				}
				
			} catch (SQLException eee) {
				// TODO Auto-generated catch block
				eee.printStackTrace();
			
		
	}
		
			}
		});
		tableremarques.setBackground(new Color(252,198, 197));
		tableremarques.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		scrollPane_2.setViewportView(tableremarques);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(184, 54, 52));
		panel_7.setBounds(433, 289, 397, 121);
		panelnotifs.add(panel_7);
		
		JLabel label_25 = new JLabel("Remarques");
		label_25.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_25.setBounds(10, 0, 79, 26);
		panel_7.add(label_25);
		
		 textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setForeground(new Color(184, 54, 52));
		textArea.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		textArea.setBackground(new Color(252, 198, 197));
		textArea.setBounds(10, 25, 377, 85);
		panel_7.add(textArea);
		
		JLabel lblBanqueDeSang_1 = new JLabel("Banque de Sang");
		lblBanqueDeSang_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblBanqueDeSang_1.setBounds(573, 235, 155, 26);
		panelnotifs.add(lblBanqueDeSang_1);
		
		banquedesangRQ = new JTextField();
		banquedesangRQ.setForeground(Color.BLACK);
		banquedesangRQ.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		banquedesangRQ.setColumns(16);
		banquedesangRQ.setBackground(new Color(184, 54, 52));
		banquedesangRQ.setBounds(550, 257, 155, 26);
		panelnotifs.add(banquedesangRQ);
		
		JLabel label_10 = new JLabel("");
		label_10.setIcon(new ImageIcon(getClass().getResource("/Icones/Patient_Male_icon-icons.com_75053 (1).png")));
		label_10.setBounds(4, 358, 46, 46);
		panelnotifs.add(label_10);
		
		 lblVotreDemandeDe = new JLabel("Votre demande de devenir donneur est en cours de traitement");
		lblVotreDemandeDe.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblVotreDemandeDe.setBounds(30, 365, 397, 39);
		panelnotifs.add(lblVotreDemandeDe);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(getClass().getResource("/Icones/12.png")));
		
		label_12.setBounds(-23, 0, 886, 421);
		panelnotifs.add(label_12);
		
		ButtonGroup group=new ButtonGroup();
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBackground(new Color(184, 54, 52));
		panel_9.setBounds(10, 11, 826, 399);
		panelcarnet.add(panel_9);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 806, 377);
		panel_9.add(scrollPane_1);
		
		tablecarnets = new JTable();
		tablecarnets.setBackground(new Color(252,198, 197));
		tablecarnets.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		scrollPane_1.setViewportView(tablecarnets);
		
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(getClass().getResource("/Icones/12.png")));
		label_7.setBounds(-21, 0, 886, 421);
		panelcarnet.add(label_7);
		
		 lblDeSant = new JLabel("         De Sant\u00E9");
		lblDeSant.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				panelcarnet.setVisible(true);
				paneldemande.setVisible(false);
				lblDons.setForeground(Color.white);
				lblDeSant.setForeground(Color.white);
				lblDonneurs.setForeground(Color.black);
				lblBanqueDeSang_2.setForeground(Color.black);
				lblActivits.setForeground(Color.black);
				lblDeSang.setForeground(Color.black);
				/*vertBS.setVisible(true);
				vertdd.setVisible(false);
				vertmed.setVisible(false);
				*/
				cardLayout.show(panelprincipale,"1");
				
				
				
			}
		});
		lblDeSant.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblDeSant.setBounds(-2, 94, 139, 32);
		contentPane.add(lblDeSant);
		
		JLabel label_26 = new JLabel("");
		label_26.setIcon(new ImageIcon(getClass().getResource("/Icones/blood_drop_icon-icons.com_76228 (2).png")));
		label_26.setBounds(3, 304, 32, 39);
		contentPane.add(label_26);
		
		 lblBanqueDeSang_2 = new JLabel("         Banque ");
		lblBanqueDeSang_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelconsult.setVisible(true);
				paneldemande.setVisible(false);
				lblDons.setForeground(Color.black);
				lblDeSant.setForeground(Color.black);
				lblDonneurs.setForeground(Color.black);
				lblBanqueDeSang_2.setForeground(Color.white);
				lblActivits.setForeground(Color.black);
				lblDeSang.setForeground(Color.white);
				/*vertBS.setVisible(true);
				vertdd.setVisible(false);
				vertmed.setVisible(false);
				*/
				cardLayout.show(panelprincipale,"4");
			}
		});
		lblBanqueDeSang_2.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblBanqueDeSang_2.setBounds(2, 295, 139, 39);
		contentPane.add(lblBanqueDeSang_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 204, 255));
		panel_3.setBounds(13, 345, 113, 7);
		contentPane.add(panel_3);
		
		 lblDeSang = new JLabel("       De Sang");
		lblDeSang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelconsult.setVisible(true);
				paneldemande.setVisible(false);
				lblDons.setForeground(Color.black);
				lblDeSant.setForeground(Color.black);
				lblDonneurs.setForeground(Color.black);
				lblBanqueDeSang_2.setForeground(Color.white);
				lblActivits.setForeground(Color.black);
				lblDeSang.setForeground(Color.white);
				/*vertBS.setVisible(true);
				vertdd.setVisible(false);
				vertmed.setVisible(false);
				*/
				cardLayout.show(panelprincipale,"4");
			}
		});
		lblDeSang.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblDeSang.setBounds(10, 313, 139, 39);
		contentPane.add(lblDeSang);
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(getClass().getResource("/Icones/11.png")));
		label.setBounds(-19, 0, 1041, 430);
		contentPane.add(label);
		remplirnomprenom();
		remplirbanquedesang();
		remplirtablereponses();
		remplircarnet();
		joindretel();
		joindreemail();
		remplirconsult();
		remplirremarque();
		remplirdonneur();
		remplirbanquedesang1();
	}
	void remplirnomprenom(){
		
		 String sql="select * from donneurconnecte";
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			if(resultat.next()){
				nom.setText(resultat.getString("nomdonneurconnecte"));
				prenom.setText(resultat.getString("prenomdonneurconnecte"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void remplirbanquedesang(){
		
		 String sql="select * from banquesang";
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			while(resultat.next()){
				banquedesang.addItem(resultat.getString("adressebs")+" "+resultat.getString("numbs"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void remplirtablereponses(){
		String adrrr1=null;
		String adrrr2=null;
		String sql1="select * from donneurconnecte";
		try {
			preparedStatement2=cnx2.prepareStatement(sql1);
			resultat2=preparedStatement2.executeQuery();
			if(resultat2.next()){
				adrrr1=resultat2.getString("nomdonneurconnecte");
				adrrr2=resultat2.getString("prenomdonneurconnecte");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql ="select * from repdemande where nomdest in  ( select nomdest from demandesang where nomdemandeur='"+adrrr1+"' and prenomdemandeur ='"+adrrr2+"' )";		
		try {
			preparedStatement2 = cnx2.prepareStatement(sql);
			resultat2=preparedStatement2.executeQuery();
			tablereponses.setModel(DbUtils.resultSetToTableModel(resultat2));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	
	}
	void remplircarnet(){
		String adrrr1=null;
		String adrrr2=null;
		String sql1="select * from donneurconnecte";
		try {
			preparedStatement2=cnx2.prepareStatement(sql1);
			resultat2=preparedStatement2.executeQuery();
			if(resultat2.next()){
				adrrr1=resultat2.getString("nomdonneurconnecte");
				adrrr2=resultat2.getString("prenomdonneurconnecte");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql ="select * from consultation where nomdonneur ='"+adrrr1+"' and prenomdonneur ='"+adrrr2+"'";		
		try {
			preparedStatement2 = cnx2.prepareStatement(sql);
			resultat2=preparedStatement2.executeQuery();
			tablecarnets.setModel(DbUtils.resultSetToTableModel(resultat2));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	
	}
	
	void remplirbanquedesang1(){
		String adrrr1=null;
		String adrrr2=null;
		String sql1="select numbs,adressebs,telbs,siege from banquesang";
		try {
			preparedStatement2=cnx2.prepareStatement(sql1);
			resultat2=preparedStatement2.executeQuery();
			tablebanquedesang.setModel(DbUtils.resultSetToTableModel(resultat2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	void joindretel(){
		 vvv = new String[30];
		String adrrr1=null;
		String adrrr2=null;
		int cpt=0;
		String sql1="select * from donneurconnecte";
		try {
			preparedStatement2=cnx2.prepareStatement(sql1);
			resultat2=preparedStatement2.executeQuery();
			if(resultat2.next()){
				adrrr1=resultat2.getString("nomdonneurconnecte");
				adrrr2=resultat2.getString("prenomdonneurconnecte");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="select * from nombretel where nom='"+adrrr1+"' and prenom='"+adrrr2+"'";
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			if(resultat.next()){
				lblAaaaAEssay.setText(resultat.getString("bs")+" a essayé de vous joindre "+resultat.getString("nb")+" fois !! ");
			}else{
				lblAaaaAEssay.setText("Aucun Appel recu");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void joindreemail(){
		 vvv = new String[30];
		String adrrr1=null;
		String adrrr2=null;
		int cpt=0;
		String sql1="select * from donneurconnecte";
		try {
			preparedStatement2=cnx2.prepareStatement(sql1);
			resultat2=preparedStatement2.executeQuery();
			if(resultat2.next()){
				adrrr1=resultat2.getString("nomdonneurconnecte");
				adrrr2=resultat2.getString("prenomdonneurconnecte");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="select * from nombremail where nom='"+adrrr1+"' and prenom='"+adrrr2+"'";
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			if(resultat.next()){
				label_18.setText(resultat.getString("bs")+" vous a envoyé "+resultat.getString("nb")+" emails !! ");
			}else{
				label_18.setText("Aucun email recu ");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	
}}
	void remplirconsult(){
		 vvv = new String[30];
			String adrrr1=null;
			String adrrr2=null;
			int cpt=0;
			String sql1="select * from donneurconnecte";
			try {
				preparedStatement2=cnx2.prepareStatement(sql1);
				resultat2=preparedStatement2.executeQuery();
				if(resultat2.next()){
					adrrr1=resultat2.getString("nomdonneurconnecte");
					adrrr2=resultat2.getString("prenomdonneurconnecte");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sql="select * from consultation where nomdonneur='"+adrrr1+"' and prenomdonneur='"+adrrr2+"'";
			try {
				preparedStatement=cnx.prepareStatement(sql);
				resultat=preparedStatement.executeQuery();
				if(!resultat.next()){
					lblVousEtesDeja.setText("Vous devez faire une consultation chez un medecin ");
					lblConsultezVotreCarnet.setText("au niveau de la banque ou vous voulez faire un don");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		
	}
	}
	void remplirremarque(){
		String adrrr1=null;
		String adrrr2=null;
		String sql1="select * from donneurconnecte";
		try {
			preparedStatement2=cnx2.prepareStatement(sql1);
			resultat2=preparedStatement2.executeQuery();
			if(resultat2.next()){
				adrrr1=resultat2.getString("nomdonneurconnecte");
				adrrr2=resultat2.getString("prenomdonneurconnecte");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="select numcontact,remarque,banquedesang from contact where nomdonneur='"+adrrr1+"' and prenomdonneur='"+adrrr2+"'";
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			tableremarques.setModel(DbUtils.resultSetToTableModel(resultat));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	
}
	}
	void remplirdonneur(){
		String adrrr1=null;
		String adrrr2=null;
		String sql1="select * from donneurconnecte";
		try {
			preparedStatement2=cnx2.prepareStatement(sql1);
			resultat2=preparedStatement2.executeQuery();
			if(resultat2.next()){
				adrrr1=resultat2.getString("nomdonneurconnecte");
				adrrr2=resultat2.getString("prenomdonneurconnecte");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="select banquedesang from donneurfinale where nomdonneurfinale='"+adrrr1+"' and prenomdonneurfinale='"+adrrr2+"'";
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			if(resultat.next()){
				lblVotreDemandeDe.setText("Vous etes desormais donneur chez"+" "+resultat.getString("banquedesang"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	
}}
}
