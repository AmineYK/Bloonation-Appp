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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.mysql.jdbc.StreamingNotifiable;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FenBanqueDeSang extends JFrame {

	private JPanel contentPane;
	private CardLayout cardLayout;
	private JPanel paneldon;
	private JPanel paneldonnneur;
	private JPanel panelstock;
	private JPanel panelactivite;
	private JPanel panelprincipale;
	private JTextField nomDONN;
	private JTextField prenomDONN;
	private JTextField adresseDONN;
	private JTextField telDONN;
	private JTextField ageDONN;
	private JTextField emailDONN;
	String[] ert;
	String[] ert1;
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
	private JComboBox nommedDONN;
	private JComboBox prenommedDONN;
	int a=0;
	int aa=0;
	int b=0;
	int c=0;
	private int NP1=0;
	private int NP2=0;
	private JRadioButton masculinDONN;
	private JRadioButton femininDONN;
	private JComboBox groupesangDONN;
	private JComboBox etatsanteDONN;
	private JTable table;
	private JTable table_1;
	private String adr=null;
	private String adr1=null;
	private JComboBox nomdonneur;
	private JComboBox groupesanguin;
	private JComboBox qte;
	private JComboBox nommed;
	private JComboBox prenommed;
	int jsk=0;
	private JComboBox prenomdonneur;
	private JComboBox nomdonneurTRAN;
	private JComboBox prenomdonneurTRAN;
	private JComboBox numerodemande;
	private JTextField nomdestTRAN;
	private JTextField prenomdestTRAN;
	private JLabel lblDonneurIndisponiblePour;
	private String adr2=null;
	private JTextField groupesanguinTRAN;
	private JTextField groupesanguinSTCK;
	private JTextField qteSTCK;
	private JTextField BBB;
	private JTextField qteTOTALE;
	private JTable tablestock;
	private JTextField datefield;
	private JComboBox AAA;
	private String adr4;
	private JTable tablecollectes;
	private JTable tabledistribution;
	private JTextField emailCONTC;
	private JTextField telCONTC;
	private JComboBox donneurCONTC;
	private JTextArea textArea;
	private String adr5;
	private JLabel lblerror4;
	private JLabel lblerror41;
	private JLabel lblerror411;
	private JComboBox datetransaction;
	private JComboBox datedon;
	private JPanel panel_1;
	private JLabel lblDonneurs;
	private JLabel lblStocks;
	private JLabel lblActivits;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new NimbusLookAndFeel());
					FenBanqueDeSang frame = new FenBanqueDeSang();
					
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
	public FenBanqueDeSang() {
		super("Banque de Sang");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985,422);
		super.setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ImageIcon obj = new ImageIcon(getClass().getResource("/Icones/transfuse_38039.png"));
		//ImageIcon obj1 = new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\transfuse_38039.png");
		super.setIconImage(obj.getImage());

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
		//label_1.setIcon(new ImageIcon(getClass().getResource("/Icones/close_delete_delete_theaction_theoutput_10252.png")));
		label_1.setBounds(2, 4, 32, 38);
		contentPane.add(label_1);
		
		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FenBanqueSangModification obj = new FenBanqueSangModification();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		label_3.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\blood_drop_icon-icons.com_76228 (1).png"));
		label_3.setBounds(80, 8, 46, 49);
		contentPane.add(label_3);
		
		JLabel lblDons = new JLabel("             Dons");
		lblDons.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				paneldon.setVisible(false);
				paneldonnneur.setVisible(true);
				panelstock.setVisible(false);
				panelactivite.setVisible(false);	
				lblDons.setForeground(Color.white);
				lblDonneurs.setForeground(Color.black);
				lblStocks.setForeground(Color.black);
				lblActivits.setForeground(Color.black);
				/*vertBS.setVisible(true);
				vertdd.setVisible(false);
				vertmed.setVisible(false);
				*/
				cardLayout.show(panelprincipale,"2");
				
				
				
			}
		});
		lblDons.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblDons.setBounds(-2, 71, 139, 39);
		contentPane.add(lblDons);
		
		 panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 255));
		panel_1.setBounds(10, 106, 113, 7);
		contentPane.add(panel_1);
		
		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				paneldon.setVisible(false);
				paneldonnneur.setVisible(true);
				panelstock.setVisible(false);
				panelactivite.setVisible(false);	
				lblDons.setForeground(Color.white);
				lblDonneurs.setForeground(Color.black);
				lblStocks.setForeground(Color.black);
				lblActivits.setForeground(Color.black);
				/*vertBS.setVisible(true);
				vertdd.setVisible(false);
				vertmed.setVisible(false);
				*/
				cardLayout.show(panelprincipale,"2");
				
				
				
			}
		});
		label_4.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\blood_icon_149283 (1).png"));
		label_4.setBounds(11, 68, 32, 39);
		contentPane.add(label_4);
		
		 lblDonneurs = new JLabel("         Donneurs");
		lblDonneurs.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				paneldon.setVisible(true);
				paneldonnneur.setVisible(false);
				panelstock.setVisible(false);
				panelactivite.setVisible(false);	
				lblDons.setForeground(Color.black);
				lblDonneurs.setForeground(Color.white);
				lblStocks.setForeground(Color.black);
				lblActivits.setForeground(Color.black);
				/*vertBS.setVisible(true);
				vertdd.setVisible(false);
				vertmed.setVisible(false);
				*/
				cardLayout.show(panelprincipale,"1");
				
				
				
			}
		});
		lblDonneurs.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblDonneurs.setBounds(-2, 143, 139, 39);
		contentPane.add(lblDonneurs);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 204, 255));
		panel_2.setBounds(10, 178, 113, 7);
		contentPane.add(panel_2);
		
		JLabel label_6 = new JLabel("");
		label_6.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				paneldon.setVisible(true);
				paneldonnneur.setVisible(false);
				panelstock.setVisible(false);
				panelactivite.setVisible(false);	
				lblDons.setForeground(Color.black);
				lblDonneurs.setForeground(Color.white);
				lblStocks.setForeground(Color.black);
				lblActivits.setForeground(Color.black);
				/*vertBS.setVisible(true);
				vertdd.setVisible(false);
				vertmed.setVisible(false);
				*/
				cardLayout.show(panelprincipale,"1");
				
				
				
			}
		});
		label_6.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\Patient_Male_icon-icons.com_75053 (1).png"));
		label_6.setBounds(11, 140, 32, 39);
		contentPane.add(label_6);
		
		 lblStocks = new JLabel("           Stocks");
		lblStocks.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				paneldon.setVisible(false);
				paneldonnneur.setVisible(false);
				panelstock.setVisible(true);
				panelactivite.setVisible(false);
				lblDons.setForeground(Color.black);
				lblDonneurs.setForeground(Color.black);
				lblStocks.setForeground(Color.white);
				lblActivits.setForeground(Color.black);
				/*vertBS.setVisible(true);
				vertdd.setVisible(false);
				vertmed.setVisible(false);
				*/
				cardLayout.show(panelprincipale,"3");
				
				
				
			}
		});
		lblStocks.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblStocks.setBounds(-2, 212, 139, 39);
		contentPane.add(lblStocks);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 204, 255));
		panel_3.setBounds(10, 247, 113, 7);
		contentPane.add(panel_3);
		
		JLabel label_8 = new JLabel("");
		label_8.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				paneldon.setVisible(false);
				paneldonnneur.setVisible(false);
				panelstock.setVisible(true);
				panelactivite.setVisible(false);	
				lblDons.setForeground(Color.black);
				lblDonneurs.setForeground(Color.black);
				lblStocks.setForeground(Color.white);
				lblActivits.setForeground(Color.black);
				/*vertBS.setVisible(true);
				vertdd.setVisible(false);
				vertmed.setVisible(false);
				*/
				cardLayout.show(panelprincipale,"3");
				
				
				
			}
		});
		label_8.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\businessapplication_database_database_accepteitheracceptthedatabase_connect_connectdatabase_negocios_aplicacion_basededato_2310.png"));
		label_8.setBounds(11, 209, 32, 39);
		contentPane.add(label_8);
		
		 lblActivits = new JLabel("         Activit\u00E9s");
		lblActivits.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				paneldon.setVisible(false);
				paneldonnneur.setVisible(false);
				panelstock.setVisible(false);
				panelactivite.setVisible(true);
				lblDons.setForeground(Color.black);
				lblDonneurs.setForeground(Color.black);
				lblStocks.setForeground(Color.black);
				lblActivits.setForeground(Color.white);
				/*vertBS.setVisible(true);
				vertdd.setVisible(false);
				vertmed.setVisible(false);
				*/
				cardLayout.show(panelprincipale,"4");
				
				
				
			}
		});
		lblActivits.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblActivits.setBounds(2, 286, 139, 39);
		contentPane.add(lblActivits);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 204, 255));
		panel_4.setBounds(13, 321, 113, 7);
		contentPane.add(panel_4);
		
		JLabel label_10 = new JLabel("");
		label_10.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				paneldon.setVisible(false);
				paneldonnneur.setVisible(false);
				panelstock.setVisible(false);
				panelactivite.setVisible(true);	
				lblDons.setForeground(Color.black);
				lblDonneurs.setForeground(Color.black);
				lblStocks.setForeground(Color.black);
				lblActivits.setForeground(Color.white);
				/*vertBS.setVisible(true);
				vertdd.setVisible(false);
				vertmed.setVisible(false);
				*/
				cardLayout.show(panelprincipale,"4");
				
				
				
			}
		});
		label_10.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\doc_success_icon_155483.png"));
		label_10.setBounds(11, 283, 32, 39);
		contentPane.add(label_10);
		
		JLabel label_5 = new JLabel("by AmineYK");
		label_5.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		label_5.setBounds(45, 399, 88, 14);
		contentPane.add(label_5);
		
		 panelprincipale = new JPanel();
		panelprincipale.setBounds(141, 0, 846, 421);
		contentPane.add(panelprincipale);
		cardLayout = new CardLayout(0, 0);
		panelprincipale.setLayout(cardLayout);
		
		paneldon = new JPanel();
		panelprincipale.add(paneldon, "1");
		paneldon.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(184, 54, 52));
		panel.setBounds(419, 11, 10, 399);
		paneldon.add(panel);
		
		nomDONN = new JTextField();
		nomDONN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				if(key==10){
					prenomDONN.requestFocus();
				}
			}
		});
		nomDONN.setForeground(Color.BLACK);
		nomDONN.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		nomDONN.setColumns(16);
		nomDONN.setBackground(new Color(184, 54, 52));
		nomDONN.setBounds(59, 35, 155, 26);
		paneldon.add(nomDONN);
		
		JLabel label_13 = new JLabel("Nom");
		label_13.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_13.setBounds(59, 11, 79, 26);
		paneldon.add(label_13);
		
		JLabel label_14 = new JLabel("Prenom");
		label_14.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_14.setBounds(225, 11, 79, 26);
		paneldon.add(label_14);
		
		prenomDONN = new JTextField();
		prenomDONN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				if(key==10){
					adresseDONN.requestFocus();
				}
			}
		});
		prenomDONN.setForeground(Color.BLACK);
		prenomDONN.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		prenomDONN.setColumns(16);
		prenomDONN.setBackground(new Color(184, 54, 52));
		prenomDONN.setBounds(225, 35, 155, 26);
		paneldon.add(prenomDONN);
		
		adresseDONN = new JTextField();
		adresseDONN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				if(key==10){
					telDONN.requestFocus();
				}
			}
		});
		adresseDONN.setForeground(Color.BLACK);
		adresseDONN.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		adresseDONN.setColumns(16);
		adresseDONN.setBackground(new Color(184, 54, 52));
		adresseDONN.setBounds(59, 96, 155, 26);
		paneldon.add(adresseDONN);
		
		JLabel label_15 = new JLabel("Adresse");
		label_15.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_15.setBounds(59, 72, 79, 26);
		paneldon.add(label_15);
		
		telDONN = new JTextField();
		telDONN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int ccc = e.getKeyChar();
				if(Character.isAlphabetic(ccc)){
					telDONN.setEditable(false);
					lblerror4.setText("Invalide");
				}else{
					telDONN.setEditable(true);
					lblerror4.setText("");
				}
				int key=e.getKeyCode();
				if(key==10){
					emailDONN.requestFocus();
				}
			}
		});
		telDONN.setForeground(Color.BLACK);
		telDONN.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		telDONN.setColumns(16);
		telDONN.setBackground(new Color(184, 54, 52));
		telDONN.setBounds(225, 96, 155, 26);
		paneldon.add(telDONN);
		
		lblerror4 = new JLabel("");
		lblerror4.setForeground(Color.RED);
		lblerror4.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		lblerror4.setBounds(225, 122, 79, 14);
		paneldon.add(lblerror4);
		
		JLabel label_16 = new JLabel("Telephone");
		label_16.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_16.setBounds(225, 72, 79, 26);
		paneldon.add(label_16);
		
		ageDONN = new JTextField();
		ageDONN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int ccc = e.getKeyChar();
				if(Character.isAlphabetic(ccc)){
					ageDONN.setEditable(false);
					lblerror41.setText("Invalide");
				}else{
					ageDONN.setEditable(true);
					lblerror41.setText("");
				}
				int key=e.getKeyCode();
				if(key==10){
					ageDONN.requestFocus();
				}
			}
		});
		ageDONN.setForeground(Color.BLACK);
		ageDONN.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		ageDONN.setColumns(16);
		ageDONN.setBackground(new Color(184, 54, 52));
		ageDONN.setBounds(225, 159, 155, 26);
		paneldon.add(ageDONN);
		
		lblerror41 = new JLabel("");
		lblerror41.setForeground(Color.RED);
		lblerror41.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		lblerror41.setBounds(225, 185, 79, 14);
		paneldon.add(lblerror41);
		
		emailDONN = new JTextField();
		emailDONN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int key=e.getKeyCode();
				if(key==10){
					ageDONN.requestFocus();
				}
			}
		});
		emailDONN.setText("abcdef@email.com");
		emailDONN.setForeground(Color.BLACK);
		emailDONN.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		emailDONN.setColumns(16);
		emailDONN.setBackground(new Color(184, 54, 52));
		emailDONN.setBounds(59, 159, 155, 26);
		paneldon.add(emailDONN);
		
		JLabel label_17 = new JLabel("Email");
		label_17.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_17.setBounds(59, 135, 79, 26);
		paneldon.add(label_17);
		
		JLabel label_18 = new JLabel("Age");
		label_18.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_18.setBounds(225, 135, 79, 26);
		paneldon.add(label_18);
		
		 etatsanteDONN = new JComboBox();
		etatsanteDONN.setModel(new DefaultComboBoxModel(new String[] {"Maladie Chronique", "Maladie Contagieuse", "Sans Maladie "}));
		etatsanteDONN.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		etatsanteDONN.setBackground(new Color(184, 54, 52));
		etatsanteDONN.setBounds(62, 217, 155, 26);
		paneldon.add(etatsanteDONN);
		
		JLabel label_20 = new JLabel("Etat de Sant\u00E9");
		label_20.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_20.setBounds(59, 190, 98, 26);
		paneldon.add(label_20);
		
		JLabel label_23 = new JLabel("Sexe");
		label_23.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_23.setBounds(59, 310, 79, 26);
		paneldon.add(label_23);
		
		 masculinDONN = new JRadioButton("Masculin");
		masculinDONN.setFont(new Font("Lucida Fax", Font.ITALIC, 11));
		masculinDONN.setBackground(new Color(253, 198, 197));
		masculinDONN.setBounds(59, 334, 75, 23);
		paneldon.add(masculinDONN);
		
		 femininDONN = new JRadioButton("Feminin");
		femininDONN.setFont(new Font("Lucida Fax", Font.ITALIC, 11));
		femininDONN.setBackground(new Color(253, 198, 197));
		femininDONN.setBounds(144, 334, 70, 23);
		paneldon.add(femininDONN);
		
		 groupesangDONN = new JComboBox();
		groupesangDONN.setModel(new DefaultComboBoxModel(new String[] {"A-", "A+", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
		groupesangDONN.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		groupesangDONN.setBackground(new Color(184, 54, 52));
		groupesangDONN.setBounds(225, 217, 155, 26);
		paneldon.add(groupesangDONN);
		
		JLabel label_24 = new JLabel("Groupe Sanguin");
		label_24.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_24.setBounds(225, 190, 119, 26);
		paneldon.add(label_24);
		
		JButton btnInsrer = new JButton("Ajouter");
		btnInsrer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnInsrer.setBackground(new Color(253,198,197));
				btnInsrer.setForeground(Color.BLACK);
			}	
			public void mouseExited(MouseEvent e) {
				btnInsrer.setBackground(new Color(184,54,52));
				btnInsrer.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
                    int bgh=0;
                    int i=0;
                    int jf=0;
                    int mpo=0;
				    String ssString=null;
				    if( nomDONN.getText().equals("") 
							|| prenomDONN.getText().equals("")  ||  adresseDONN.getText().equals("")  
							|| telDONN.getText().equals("")   || emailDONN.getText().equals("")  
							 || ageDONN.getText().equals("")
							|| (!masculinDONN.isSelected() && !femininDONN.isSelected())
							) 
							{
						JOptionPane.showMessageDialog(null,"Remplissez le(s) champ(s) vide(s) ! ");
					}else{
						
				    String sql1="select * from donneurfinale where nomdonneurfinale='"+nomDONN.getText().toString()+
				    		"' and prenomdonneurfinale ='"+prenomDONN.getText().toString()+"'";
					try {
						preparedStatement= cnx.prepareStatement(sql1);
						resultat=preparedStatement.executeQuery();
						if(resultat.next()){
							JOptionPane.showMessageDialog(null," Donneur Deja Enregistré !");
							bgh=1;
						}
						if(etatsanteDONN.getSelectedItem().equals("Maladie Chronique")){JOptionPane.showMessageDialog(null," Donneur Malade , il est pas apte pour faire un don de sang!");
						jf=1;
						}
						if(Integer.valueOf(ageDONN.getText().toString()) > 45 ){
							JOptionPane.showMessageDialog(null," Donneur agé(e), il est pas apte pour faire un don de sang!");
							mpo=1;
						}
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				
				if((bgh==0) && (jf==0)){
				
					
				String sql2="select * from consultation where nomdonneur='"+nomDONN.getText().toString()+"'"
						+ " and prenomdonneur ='"+prenomDONN.getText().toString()+"'";
				try {
					preparedStatement2=cnx2.prepareStatement(sql2);
					resultat2=preparedStatement2.executeQuery();
					if(!resultat2.next()){
						JOptionPane.showMessageDialog(null,"Ce Donneur n'a pas effctué de consultation chez le medecin !");
					}else{
						if(resultat2.getString("resultat").equals("Positif")){
							JOptionPane.showMessageDialog(null,"Ce donneur n'est pas apte à faire un don de sang");
						}else{
							i=1;
						}
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
					if(i==1){
						medecincorrecte();
						if(a==0){
							JOptionPane.showMessageDialog(null,"Medecin Inexistant , choisissez le bon !!");
						}else{
							
				String sql="insert into donneurfinale (nomdonneurfinale,prenomdonneurfinale,adressedonneurfinale,teldonneurfinale,emaildonneurfinale,agedonneurfinale,genredonneurfinale,groupesangdonneurfinale,etatsantedonneurfinale,banquedesang) "
						+ "values (?,?,?,?,?,?,?,? , ?, ? )";
				
						if(masculinDONN.isSelected()){ssString="Masculin";}
						if(femininDONN.isSelected()){ssString="Feminin";}
						try {
							AMINE();
							preparedStatement=cnx.prepareStatement(sql);
							preparedStatement.setString(1,nomDONN.getText().toString());
							preparedStatement.setString(2,prenomDONN.getText().toString());
							preparedStatement.setString(3,adresseDONN.getText().toString());
							preparedStatement.setString(4,telDONN.getText().toString());
							preparedStatement.setString(5,emailDONN.getText().toString());
							preparedStatement.setString(6,ageDONN.getText().toString());
							preparedStatement.setString(7,ssString);
							preparedStatement.setString(8,groupesangDONN.getSelectedItem().toString());
							preparedStatement.setString(9,etatsanteDONN.getSelectedItem().toString());
							preparedStatement.setString(10,adr);
							preparedStatement.execute();
							JOptionPane.showMessageDialog(null,"Donneur de sang Enregistré !");
							remplirdonneurcontact();
							nomDONN.setText("");
							prenomDONN.setText("");
							emailDONN.setText("");
							ageDONN.setText("");
							telDONN.setText("");
							adresseDONN.setText("");
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}	
				}
				
				}

			}
			
			}
		});
		btnInsrer.setForeground(Color.BLACK);
		btnInsrer.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 13));
		btnInsrer.setBackground(new Color(184, 54, 52));
		btnInsrer.setBounds(21, 380, 119, 30);
		paneldon.add(btnInsrer);
		
		JLabel lblConsultPar = new JLabel("Nom du Medecin Consultant");
		lblConsultPar.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblConsultPar.setBounds(10, 248, 194, 26);
		paneldon.add(lblConsultPar);
		
		 nommedDONN = new JComboBox();
		nommedDONN.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		nommedDONN.setBackground(new Color(184, 54, 52));
		nommedDONN.setBounds(49, 277, 155, 26);
		paneldon.add(nommedDONN);
		
		JLabel lblPrenomDuMedecin = new JLabel("Prenom du Medecin Consultant");
		lblPrenomDuMedecin.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblPrenomDuMedecin.setBounds(209, 248, 200, 26);
		paneldon.add(lblPrenomDuMedecin);
		
		 prenommedDONN = new JComboBox();
		prenommedDONN.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		prenommedDONN.setBackground(new Color(184, 54, 52));
		prenommedDONN.setBounds(225, 277, 155, 26);
		paneldon.add(prenommedDONN);
		paneldonnneur = new JPanel();
		panelprincipale.add(paneldonnneur, "2");
		paneldonnneur.setLayout(null);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(184, 54, 52));
		panel_8.setBounds(420, 11, 10, 399);
		paneldonnneur.add(panel_8);
		
		 nomdonneur = new JComboBox();
		nomdonneur.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		nomdonneur.setBackground(new Color(184, 54, 52));
		nomdonneur.setBounds(46, 49, 155, 26);
		paneldonnneur.add(nomdonneur);
		
		JLabel lblDonneur = new JLabel("Nom du Donneur");
		lblDonneur.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblDonneur.setBounds(43, 22, 158, 26);
		paneldonnneur.add(lblDonneur);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAjouter.setBackground(new Color(253,198,197));
				btnAjouter.setForeground(Color.BLACK);
			}	
			public void mouseExited(MouseEvent e) {
				btnAjouter.setBackground(new Color(184,54,52));
				btnAjouter.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
                    int bgh=0;
                    int i=0;
				    String ssString=null;
				    
					
						
						if(NP1==0 || NP2==0){
							JOptionPane.showMessageDialog(null,"Medecin ou donneur Inexistant , Actualisez-les !!");
						}else{
							
				String sql="insert into don (nomdonneur,prenomdonneur,banquedesang,groupesanguin,qte,datedon,nommed,prenommed) "
						+ "values (?,?,?,?,?,?,?, ? )";
						try {
							//String dt = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
							AMINE1();
							remplirGS();
							preparedStatement=cnx.prepareStatement(sql);
							preparedStatement.setString(1,nomdonneur.getSelectedItem().toString());
							preparedStatement.setString(2,prenomdonneur.getSelectedItem().toString());
							preparedStatement.setString(3,adr1);
							preparedStatement.setString(4,groupesanguin.getSelectedItem().toString());
							preparedStatement.setString(5,qte.getSelectedItem().toString());
							preparedStatement.setString(6,datedon.getSelectedItem().toString());
							preparedStatement.setString(7,nommed.getSelectedItem().toString());
							preparedStatement.setString(8,prenommed.getSelectedItem().toString());
							preparedStatement.execute();
							JOptionPane.showMessageDialog(null,"Don de sang Enregistré !");
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null,"Inserez la date SVP!");
						}
				}	
					
				
				

			}
		});
		btnAjouter.setForeground(Color.BLACK);
		btnAjouter.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 13));
		btnAjouter.setBackground(new Color(184, 54, 52));
		btnAjouter.setBounds(25, 355, 119, 30);
		paneldonnneur.add(btnAjouter);
		
		JLabel lblGroupeSanguin = new JLabel("Groupe Sanguin");
		lblGroupeSanguin.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblGroupeSanguin.setBounds(43, 97, 136, 26);
		paneldonnneur.add(lblGroupeSanguin);
		
		 groupesanguin = new JComboBox();
		 groupesanguin.setModel(new DefaultComboBoxModel(new String[] {"A-", "A+", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
		groupesanguin.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		groupesanguin.setBackground(new Color(184, 54, 52));
		groupesanguin.setBounds(46, 124, 155, 26);
		paneldonnneur.add(groupesanguin);
		
		JLabel lblQuantit = new JLabel("Quantit\u00E9 ");
		lblQuantit.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblQuantit.setBounds(46, 174, 98, 26);
		paneldonnneur.add(lblQuantit);
		
		 qte = new JComboBox();
		 qte.setModel(new DefaultComboBoxModel(new String[] {"500"}));
		qte.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		qte.setBackground(new Color(184, 54, 52));
		qte.setBounds(49, 201, 155, 26);
		paneldonnneur.add(qte);
		
		 nommed = new JComboBox();
		nommed.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		nommed.setBackground(new Color(184, 54, 52));
		nommed.setBounds(46, 281, 155, 26);
		paneldonnneur.add(nommed);
		
		JLabel lblMedecinCollecteur = new JLabel("Nom du Medecin Collecteur");
		lblMedecinCollecteur.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblMedecinCollecteur.setBounds(25, 254, 191, 26);
		paneldonnneur.add(lblMedecinCollecteur);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblDate.setBounds(235, 97, 136, 26);
		paneldonnneur.add(lblDate);
		
		JLabel lblPrenomMedecinCollecteur = new JLabel("Prenom du Medecin Collecteur");
		lblPrenomMedecinCollecteur.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblPrenomMedecinCollecteur.setBounds(211, 254, 199, 26);
		paneldonnneur.add(lblPrenomMedecinCollecteur);
		
		 prenommed = new JComboBox();
		prenommed.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		prenommed.setBackground(new Color(184, 54, 52));
		prenommed.setBounds(235, 281, 155, 26);
		paneldonnneur.add(prenommed);
		
		 prenomdonneur = new JComboBox();
		prenomdonneur.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		prenomdonneur.setBackground(new Color(184, 54, 52));
		prenomdonneur.setBounds(235, 49, 155, 26);
		paneldonnneur.add(prenomdonneur);
		
		JLabel lblPrenomDuDonneur = new JLabel("Prenom du Donneur");
		lblPrenomDuDonneur.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblPrenomDuDonneur.setBounds(232, 22, 158, 26);
		paneldonnneur.add(lblPrenomDuDonneur);
		
		JLabel lblEnMl = new JLabel("en ml");
		lblEnMl.setForeground(Color.RED);
		lblEnMl.setBackground(Color.RED);
		lblEnMl.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblEnMl.setBounds(163, 181, 45, 26);
		paneldonnneur.add(lblEnMl);
		
		JButton button = new JButton("Voir le Contenu des Tables ");
		button.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				button.setBackground(new Color(253,198,197));
				button.setForeground(Color.BLACK);
			}	
			public void mouseExited(MouseEvent e) {
				button.setBackground(new Color(184,54,52));
				button.setForeground(Color.BLACK);
			}
			public void mouseClicked(MouseEvent e) {
				FenBanqueDeSangAffichage obj=new FenBanqueDeSangAffichage();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 13));
		button.setBackground(new Color(184, 54, 52));
		button.setBounds(154, 355, 246, 30);
		paneldonnneur.add(button);
		
		 numerodemande = new JComboBox();
		numerodemande.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		numerodemande.setBackground(new Color(184, 54, 52));
		numerodemande.setBounds(464, 49, 155, 26);
		paneldonnneur.add(numerodemande);
		remplirdemande();
		
		JLabel lblNumeroDemande = new JLabel("Numero Demande");
		lblNumeroDemande.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNumeroDemande.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblNumeroDemande.setBounds(461, 22, 158, 26);
		paneldonnneur.add(lblNumeroDemande);
		
		JLabel label_22 = new JLabel("Date");
		label_22.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_22.setBounds(666, 22, 136, 26);
		paneldonnneur.add(label_22);
		
		JLabel lblNomDuDestinataire = new JLabel("Nom du Destinataire");
		lblNomDuDestinataire.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblNomDuDestinataire.setAlignmentX(1.0f);
		lblNomDuDestinataire.setBounds(460, 131, 158, 26);
		paneldonnneur.add(lblNomDuDestinataire);
		
		JLabel lblPrenomDuDestinataire = new JLabel("Prenom du Destinataire");
		lblPrenomDuDestinataire.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblPrenomDuDestinataire.setAlignmentX(1.0f);
		lblPrenomDuDestinataire.setBounds(663, 131, 158, 26);
		paneldonnneur.add(lblPrenomDuDestinataire);
		
		 nomdonneurTRAN = new JComboBox();
		nomdonneurTRAN.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		nomdonneurTRAN.setBackground(new Color(184, 54, 52));
		nomdonneurTRAN.setBounds(464, 281, 155, 26);
		paneldonnneur.add(nomdonneurTRAN);
		
		JLabel lblNomDuDonneur = new JLabel("Nom du Donneur");
		lblNomDuDonneur.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblNomDuDonneur.setAlignmentX(1.0f);
		lblNomDuDonneur.setBounds(461, 254, 158, 26);
		paneldonnneur.add(lblNomDuDonneur);
		
		 prenomdonneurTRAN = new JComboBox();
		prenomdonneurTRAN.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		prenomdonneurTRAN.setBackground(new Color(184, 54, 52));
		prenomdonneurTRAN.setBounds(666, 281, 155, 26);
		paneldonnneur.add(prenomdonneurTRAN);
		
		JLabel lblPrenomDuDonneur_1 = new JLabel("Prenom du Donneur");
		lblPrenomDuDonneur_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblPrenomDuDonneur_1.setAlignmentX(1.0f);
		lblPrenomDuDonneur_1.setBounds(663, 254, 158, 26);
		paneldonnneur.add(lblPrenomDuDonneur_1);
		
		JLabel label_21 = new JLabel("");
		label_21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				remplirdonneursTRAN();
				
			}
		});
		label_21.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\refresh-arrow_icon-icons.com_53911 (1).png"));
		label_21.setBounds(444, 217, 37, 36);
		paneldonnneur.add(label_21);
		
		lblDonneurIndisponiblePour = new JLabel("Si la liste est vide alors donneurs indisponibles pour ce groupe sanguin");
		lblDonneurIndisponiblePour.setForeground(Color.RED);
		lblDonneurIndisponiblePour.setFont(new Font("Lucida Fax", Font.ITALIC, 11));
		lblDonneurIndisponiblePour.setBounds(455, 302, 382, 26);
		paneldonnneur.add(lblDonneurIndisponiblePour);
		
		JButton button_1 = new JButton("Ajouter");
		button_1.addMouseListener(new MouseAdapter() {
			private String dec;
			public void mouseEntered(MouseEvent e) {
				button_1.setBackground(new Color(253,198,197));
				button_1.setForeground(Color.BLACK);
			}	
			public void mouseExited(MouseEvent e) {
				button_1.setBackground(new Color(184,54,52));
				button_1.setForeground(Color.BLACK);
			}
			public void mouseClicked(MouseEvent e) {
				 int bgh=0;
                 int i;
				    String ssString=null;
				    
				    if(nomdonneurTRAN.getItemCount() == 0 ){JOptionPane.showMessageDialog(null,"Donneur Indisponible pour cette transaction !");
				    AMINE4();
					//String dtt11 = ((JTextField) dateChooser_1.getDateEditor().getUiComponent()).getText();
					String sql11="insert into repdemande (numerodemande,nomdest,prenomdest,date,groupesanguin,decision,banquedesang) values(?,?,?,?,?,?,?)";
					dec="En Attente";
					try {
						preparedStatement3=cnx3.prepareStatement(sql11);
						preparedStatement3.setString(1,numerodemande.getSelectedItem().toString());
						preparedStatement3.setString(2,nomdestTRAN.getText().toString());
						preparedStatement3.setString(3,prenomdestTRAN.getText().toString());
						preparedStatement3.setString(4,datetransaction.getSelectedItem().toString());
						preparedStatement3.setString(5,groupesanguinTRAN.getText().toString());
						preparedStatement3.setString(6,dec);
						preparedStatement3.setString(7,adr4);
						preparedStatement3.execute();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					}
					else{
					if( nomdestTRAN.getText().equals("") 
							|| prenomdestTRAN.getText().toString().equals("")){
						JOptionPane.showMessageDialog(null,"Remplissez le(s) champ(s) vide(s) !");
					}else{
						donneurcorrecte1();
						if(c == 0){
							JOptionPane.showMessageDialog(null,"donneur Invalide , choisissez le bon !!");
						}else{
							AMINE2();
						//String dtt1 = ((JTextField) dateChooser_1.getDateEditor().getUiComponent()).getText();
							String sql1="insert into repdemande (numerodemande,nomdest,prenomdest,date,groupesanguin,decision,banquedesang) values(?,?,?,?,?,?,?)";
							if(nomdonneurTRAN.getItemCount() == 0 ){dec="En Attente";}else{dec="Attribué";}
							try {
								preparedStatement2=cnx2.prepareStatement(sql1);
								preparedStatement2.setString(1,numerodemande.getSelectedItem().toString());
								preparedStatement2.setString(2,nomdestTRAN.getText().toString());
								preparedStatement2.setString(3,prenomdestTRAN.getText().toString());
								preparedStatement2.setString(4,datetransaction.getSelectedItem().toString());
								preparedStatement2.setString(5,groupesanguinTRAN.getText().toString());
								preparedStatement2.setString(6,dec);
								preparedStatement2.setString(7,adr2);
								preparedStatement2.execute();
							} catch (SQLException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							
											String sql="insert into transaction (numdemande,nomdonneur,prenomdonneur,nomdest,prenomdest,groupesang,datetran,banquedesang) values (?,?,?,?,?,?,?,? )";
						try {
							//String dtt = ((JTextField) dateChooser_1.getDateEditor().getUiComponent()).getText();
							AMINE2();
							//i=Integer.valueOf(numerodemande.getSelectedItem().toString());
							preparedStatement=cnx.prepareStatement(sql);
							preparedStatement.setString(1,numerodemande.getSelectedItem().toString());
							preparedStatement.setString(2,nomdonneurTRAN.getSelectedItem().toString());
							
							preparedStatement.setString(3,prenomdonneurTRAN.getSelectedItem().toString());
							preparedStatement.setString(4,nomdestTRAN.getText().toString());
							preparedStatement.setString(5,prenomdestTRAN.getText().toString());
							preparedStatement.setString(6,groupesanguinTRAN.getText().toString());
							preparedStatement.setString(7,datetransaction.getSelectedItem().toString());
							preparedStatement.setString(8,adr2);
							
							
							preparedStatement.execute();
							JOptionPane.showMessageDialog(null,"Transaction de sang Enregistrée !");
							String jhd="Attribué";
							String Sql2="update  demandesang set decision = ? where numdemande='"+numerodemande.getSelectedItem().toString()+"'";
							
								preparedStatement4=cnx4.prepareStatement(Sql2);
								preparedStatement4.setString(1,jhd);
								preparedStatement4.execute();
								remplirdemande();
						} catch (SQLException e1) { 
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null,"Inserez la date!");
						
						
					
					}
							}}
					
					}

			
			}
		});
	
		button_1.setForeground(Color.BLACK);
		button_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 13));
		button_1.setBackground(new Color(184, 54, 52));
		button_1.setBounds(444, 355, 119, 30);
		paneldonnneur.add(button_1);
		
		JButton button_2 = new JButton("Voir le Contenu des Tables ");
		button_2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				button_2.setBackground(new Color(253,198,197));
				button_2.setForeground(Color.BLACK);
			}	
			public void mouseExited(MouseEvent e) {
				button_2.setBackground(new Color(184,54,52));
				button_2.setForeground(Color.BLACK);
			}
			public void mouseClicked(MouseEvent e) {
				FenBanqueDeSangAffichage obj=new FenBanqueDeSangAffichage();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		button_2.setForeground(Color.BLACK);
		button_2.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 13));
		button_2.setBackground(new Color(184, 54, 52));
		button_2.setBounds(578, 355, 246, 30);
		paneldonnneur.add(button_2);
		
		JLabel label_25 = new JLabel("");
		label_25.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				remplirdest();
			}
		});
		label_25.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\refresh-arrow_icon-icons.com_53911 (1).png"));
		label_25.setBounds(440, 99, 37, 36);
		paneldonnneur.add(label_25);
		
		nomdestTRAN = new JTextField();
		nomdestTRAN.setEditable(false);
		nomdestTRAN.setForeground(Color.BLACK);
		nomdestTRAN.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		nomdestTRAN.setColumns(16);
		nomdestTRAN.setBackground(new Color(184, 54, 52));
		nomdestTRAN.setBounds(464, 162, 155, 26);
		paneldonnneur.add(nomdestTRAN);
		
		prenomdestTRAN = new JTextField();
		prenomdestTRAN.setEditable(false);
		prenomdestTRAN.setForeground(Color.BLACK);
		prenomdestTRAN.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		prenomdestTRAN.setColumns(16);
		prenomdestTRAN.setBackground(new Color(184, 54, 52));
		prenomdestTRAN.setBounds(666, 162, 155, 26);
		paneldonnneur.add(prenomdestTRAN);
		
		groupesanguinTRAN = new JTextField();
		groupesanguinTRAN.setEditable(false);
		groupesanguinTRAN.setForeground(Color.BLACK);
		groupesanguinTRAN.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		groupesanguinTRAN.setColumns(16);
		groupesanguinTRAN.setBackground(new Color(184, 54, 52));
		groupesanguinTRAN.setBounds(619, 210, 37, 26);
		paneldonnneur.add(groupesanguinTRAN);
		
		JLabel lblGroupeSanguin_1 = new JLabel("Groupe Sanguin");
		lblGroupeSanguin_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblGroupeSanguin_1.setAlignmentX(1.0f);
		lblGroupeSanguin_1.setBounds(593, 189, 158, 26);
		paneldonnneur.add(lblGroupeSanguin_1);
		
		JLabel lblDon = new JLabel("Don");
		lblDon.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 18));
		lblDon.setBounds(188, 389, 56, 26);
		paneldonnneur.add(lblDon);
		
		JLabel lblTransaction = new JLabel("Transaction");
		lblTransaction.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 18));
		lblTransaction.setBounds(588, 391, 119, 26);
		paneldonnneur.add(lblTransaction);
		
		JLabel label_44 = new JLabel("");
		label_44.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				actualiserNP();
				NP1=1;
			}
		});
		label_44.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\refresh-arrow_icon-icons.com_53911 (1).png"));
		label_44.setBounds(10, 11, 37, 36);
		paneldonnneur.add(label_44);
		
		JLabel label_45 = new JLabel("");
		label_45.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				actualiserNP1();
				NP2=1;
			}
		});
		label_45.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\refresh-arrow_icon-icons.com_53911 (1).png"));
		label_45.setBounds(10, 219, 37, 36);
		paneldonnneur.add(label_45);
		
		 datetransaction = new JComboBox();
		datetransaction.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		datetransaction.setBackground(new Color(184, 54, 52));
		datetransaction.setBounds(666, 49, 155, 26);
		paneldonnneur.add(datetransaction);
		
		 datedon = new JComboBox();
		datedon.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		datedon.setBackground(new Color(184, 54, 52));
		datedon.setBounds(235, 124, 155, 26);
		paneldonnneur.add(datedon);
		
		
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(-54, 0, 900, 421);
		paneldonnneur.add(label_9);
		label_9.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\12.png"));
		panelstock = new JPanel();
		panelprincipale.add(panelstock, "3");
		panelstock.setLayout(null);
		
		groupesanguinSTCK = new JTextField();
		groupesanguinSTCK.setForeground(Color.BLACK);
		groupesanguinSTCK.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		groupesanguinSTCK.setColumns(16);
		groupesanguinSTCK.setBackground(new Color(184, 54, 52));
		groupesanguinSTCK.setBounds(218, 100, 55, 26);
		panelstock.add(groupesanguinSTCK);
		
		JLabel lblQuantit_1 = new JLabel("Groupe Sanguin");
		lblQuantit_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblQuantit_1.setAlignmentX(1.0f);
		lblQuantit_1.setBounds(202, 73, 122, 26);
		panelstock.add(lblQuantit_1);
		
		JLabel label_27 = new JLabel("Date");
		label_27.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_27.setBounds(18, 73, 136, 26);
		panelstock.add(label_27);
		
		 AAA = new JComboBox();
		AAA.setModel(new DefaultComboBoxModel(new String[] {"A-", "A+", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
		AAA.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		AAA.setBackground(new Color(184, 54, 52));
		AAA.setBounds(174, 349, 99, 26);
		panelstock.add(AAA);
		
		JLabel label_30 = new JLabel("Groupe Sanguin");
		label_30.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_30.setBounds(171, 322, 136, 26);
		panelstock.add(label_30);
		
		JLabel label_26 = new JLabel("Quantit\u00E9");
		label_26.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_26.setAlignmentX(1.0f);
		label_26.setBounds(327, 73, 64, 26);
		panelstock.add(label_26);
		
		qteSTCK = new JTextField();
		qteSTCK.setForeground(Color.BLACK);
		qteSTCK.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		qteSTCK.setColumns(16);
		qteSTCK.setBackground(new Color(184, 54, 52));
		qteSTCK.setBounds(331, 100, 55, 26);
		panelstock.add(qteSTCK);
		
		JButton btnDetruireStock = new JButton("Detruire Stock");
		btnDetruireStock.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnDetruireStock.setBackground(new Color(253,198,197));
				btnDetruireStock.setForeground(Color.BLACK);
			}	
			public void mouseExited(MouseEvent e) {
				btnDetruireStock.setBackground(new Color(184,54,52));
				btnDetruireStock.setForeground(Color.BLACK);
			}
			public void mouseClicked(MouseEvent e) {
				int ligne = tablestock.getSelectedRow();
				if(ligne == -1){
					JOptionPane.showMessageDialog(null,"Selectionnez une ligne");
				}else{
					int a = JOptionPane.showConfirmDialog(null,"Voulez-vous vraiment detruire ce stock ?","Confirmation de destruction du stock",JOptionPane.YES_NO_CANCEL_OPTION);
				if(a==0){	
				String id = tablestock.getModel().getValueAt(ligne,0).toString();
				String sql = " delete from don where numdon="+id+" ";
				
				
				try {
					preparedStatement=cnx.prepareStatement(sql);
					preparedStatement.execute();
				    JOptionPane.showMessageDialog(null,"Stock de sang Detruit ");
				    qteSTCK.setText("");
				    groupesanguinSTCK.setText("");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				}}}
				
				
			
		});
		btnDetruireStock.setForeground(Color.BLACK);
		btnDetruireStock.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 13));
		btnDetruireStock.setBackground(new Color(184, 54, 52));
		btnDetruireStock.setBounds(133, 167, 136, 30);
		panelstock.add(btnDetruireStock);
		
		BBB = new JTextField();
		BBB.setForeground(Color.BLACK);
		BBB.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		BBB.setColumns(16);
		BBB.setBackground(new Color(184, 54, 52));
		BBB.setBounds(331, 349, 55, 26);
		panelstock.add(BBB);
		
		JLabel label_28 = new JLabel("Quantit\u00E9");
		label_28.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_28.setAlignmentX(1.0f);
		label_28.setBounds(327, 322, 64, 26);
		panelstock.add(label_28);
		
		JLabel label_29 = new JLabel("");
		label_29.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			remplirquantitepargs();
			}
		});
		label_29.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\refresh-arrow_icon-icons.com_53911 (1).png"));
		label_29.setBounds(145, 294, 37, 36);
		panelstock.add(label_29);
		
		JLabel label_31 = new JLabel("");
		label_31.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				stocktotale();
			}
		});
		label_31.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\refresh-arrow_icon-icons.com_53911 (1).png"));
		label_31.setBounds(18, 296, 37, 36);
		panelstock.add(label_31);
		
		qteTOTALE = new JTextField();
		qteTOTALE.setForeground(Color.BLACK);
		qteTOTALE.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		qteTOTALE.setColumns(16);
		qteTOTALE.setBackground(new Color(184, 54, 52));
		qteTOTALE.setBounds(67, 350, 55, 26);
		panelstock.add(qteTOTALE);
		
		JLabel lblQuantitTotale = new JLabel("Quantit\u00E9 Totale");
		lblQuantitTotale.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblQuantitTotale.setAlignmentX(1.0f);
		lblQuantitTotale.setBounds(47, 326, 99, 26);
		panelstock.add(lblQuantitTotale);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(184, 54, 52));
		panel_5.setBounds(414, 11, 422, 399);
		panelstock.add(panel_5);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 402, 377);
		panel_5.add(scrollPane);
		
		tablestock = new JTable();
		tablestock.addMouseListener(new MouseAdapter() {
			private JLabel label_32;

			@Override
			public void mouseClicked(MouseEvent e) {
			int ligne = tablestock.getSelectedRow();
			String id = tablestock.getModel().getValueAt(ligne,0).toString();
			
			String sql = "select * from don where numdon ="+id+" ";
			
			try {
				preparedStatement=cnx.prepareStatement(sql);
		        resultat =preparedStatement.executeQuery();
		        
		        if(resultat.next()){
		            datefield.setText(resultat.getString("datedon"));
		        	groupesanguinSTCK.setText(resultat.getString("groupesanguin"));
		        	qteSTCK.setText(resultat.getString("qte"));
		        	
		        
		        }
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		tablestock.setBackground(new Color(252,198, 197));
		tablestock.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		scrollPane.setViewportView(tablestock);
		
		datefield = new JTextField();
		datefield.setForeground(Color.BLACK);
		datefield.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		datefield.setColumns(16);
		datefield.setBackground(new Color(184, 54, 52));
		datefield.setBounds(18, 100, 128, 26);
		panelstock.add(datefield);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(184, 54, 52));
		panel_9.setBounds(9, 230, 395, 11);
		panelstock.add(panel_9);
		
		JLabel label_32 = new JLabel("en ml");
		label_32.setForeground(Color.RED);
		label_32.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_32.setBackground(Color.RED);
		label_32.setBounds(333, 122, 45, 26);
		panelstock.add(label_32);
		
		JLabel label_33 = new JLabel("en ml");
		label_33.setForeground(Color.RED);
		label_33.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_33.setBackground(Color.RED);
		label_33.setBounds(333, 370, 45, 26);
		panelstock.add(label_33);
		
		JLabel label_34 = new JLabel("en ml");
		label_34.setForeground(Color.RED);
		label_34.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_34.setBackground(Color.RED);
		label_34.setBounds(69, 371, 45, 26);
		panelstock.add(label_34);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(184, 54, 52));
		panel_15.setBounds(155, 39, 96, 7);
		panelstock.add(panel_15);
		
		JLabel lblStocks_1 = new JLabel("Stocks");
		lblStocks_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 18));
		lblStocks_1.setBounds(171, 11, 119, 26);
		panelstock.add(lblStocks_1);
		
		
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\12.png"));
		label_11.setBounds(-25, 0, 886, 421);
		panelstock.add(label_11);
		panelactivite = new JPanel();
		panelprincipale.add(panelactivite, "4");
		panelactivite.setLayout(null);
		
		JLabel lblLieu = new JLabel("Lieu ");
		lblLieu.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblLieu.setBounds(25, 57, 133, 26);
		panelactivite.add(lblLieu);
		
		JComboBox collectee = new JComboBox();
		collectee.setModel(new DefaultComboBoxModel(new String[] {"Bureaux des centres hospitaliers", "Camps militaires", "Universit\u00E9s", "Ecoles"}));
		collectee.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		collectee.setBackground(new Color(184, 54, 52));
		collectee.setBounds(25, 85, 252, 26);
		panelactivite.add(collectee);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setDateFormatString("yyyy/MM/dd");
		dateChooser_2.setBackground(new Color(184, 54, 52));
		dateChooser_2.setBounds(227, 149, 155, 26);
		panelactivite.add(dateChooser_2);
		
		JLabel label_36 = new JLabel("Date");
		label_36.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_36.setBounds(227, 122, 136, 26);
		panelactivite.add(label_36);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(184, 54, 52));
		panel_6.setBounds(11, 205, 395, 11);
		panelactivite.add(panel_6);
		
		JComboBox distibution = new JComboBox();
		distibution.setModel(new DefaultComboBoxModel(new String[] {"Bureaux des centres hospitaliers"}));
		distibution.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		distibution.setBackground(new Color(184, 54, 52));
		distibution.setBounds(25, 291, 252, 26);
		panelactivite.add(distibution);
		
		JLabel label_35 = new JLabel("Lieu ");
		label_35.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_35.setBounds(25, 263, 133, 26);
		panelactivite.add(label_35);
		
		JDateChooser dateChooser_3 = new JDateChooser();
		dateChooser_3.setDateFormatString("yyyy/MM/dd");
		dateChooser_3.setBackground(new Color(184, 54, 52));
		dateChooser_3.setBounds(227, 355, 155, 26);
		panelactivite.add(dateChooser_3);
		
		JLabel label_37 = new JLabel("Date");
		label_37.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_37.setBounds(227, 328, 136, 26);
		panelactivite.add(label_37);
		
		JLabel lblDistribution = new JLabel("Distribution");
		lblDistribution.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 18));
		lblDistribution.setBounds(136, 227, 119, 26);
		panelactivite.add(lblDistribution);
		
		JLabel lblCollecte = new JLabel("Collecte");
		lblCollecte.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 18));
		lblCollecte.setBounds(158, 11, 119, 26);
		panelactivite.add(lblCollecte);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(184,54,52));
		panel_10.setBounds(142, 39, 113, 7);
		panelactivite.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(184, 54,52));
		panel_11.setBounds(125, 258, 140, 7);
		panelactivite.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBackground(new Color(184, 54, 52));
		panel_12.setBounds(416, 11, 418, 198);
		panelactivite.add(panel_12);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 398, 176);
		panel_12.add(scrollPane_1);
		
		tablecollectes = new JTable();
		tablecollectes.setBackground(new Color(252,198, 197));
		tablecollectes.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		scrollPane_1.setViewportView(tablecollectes);
		
		JPanel panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setBackground(new Color(184, 54, 52));
		panel_13.setBounds(416, 212, 418, 198);
		panelactivite.add(panel_13);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 398, 176);
		panel_13.add(scrollPane_2);
		
		tabledistribution = new JTable();
		tabledistribution.setBackground(new Color(252,198, 197));
		tabledistribution.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		scrollPane_2.setViewportView(tabledistribution);
		
		JButton btnValider_1 = new JButton("valider");
		btnValider_1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnValider_1.setBackground(new Color(253,198,197));
				btnValider_1.setForeground(Color.BLACK);
			}	
			public void mouseExited(MouseEvent e) {
				btnValider_1.setBackground(new Color(184,54,52));
				btnValider_1.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				String adf=null;
			
				String sql1="select * from banquesangconnecte";
				try {
					preparedStatement2=cnx2.prepareStatement(sql1);
					resultat2=preparedStatement2.executeQuery();
					if(resultat2.next()){
						adf=resultat2.getString("adresse")+" "+resultat2.getString("numerobs");	
					}
					
				} catch (SQLException ee) {
					// TODO Auto-generated catch block
					ee.printStackTrace();
				
				}
				String cv = ((JTextField) dateChooser_2.getDateEditor().getUiComponent()).getText();
				String sql="insert into  collecte(datecollecte,lieu,banquedesang) values(?,?,?)";
				try {
					preparedStatement=cnx.prepareStatement(sql);
					preparedStatement.setString(1,cv);
					preparedStatement.setString(2,collectee.getSelectedItem().toString());
					preparedStatement.setString(3,adf);
					preparedStatement.execute();
					JOptionPane.showMessageDialog(null,"Journée de collecte ajoutée !");
					remplirdatedon();
					
				} catch (SQLException e1e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Inserez la date!");
				
				}
			}
		});
		
		btnValider_1.setForeground(Color.BLACK);
		btnValider_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 13));
		btnValider_1.setBackground(new Color(184, 54, 52));
		btnValider_1.setBounds(64, 145, 119, 30);
		panelactivite.add(btnValider_1);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addMouseListener(new MouseAdapter() {
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
				String adf=null;
			
				String sql1="select * from banquesangconnecte";
				try {
					preparedStatement2=cnx2.prepareStatement(sql1);
					resultat2=preparedStatement2.executeQuery();
					if(resultat2.next()){
						adf=resultat2.getString("adresse")+" "+resultat2.getString("numerobs");	
					}
					
				} catch (SQLException ee) {
					// TODO Auto-generated catch block
					ee.printStackTrace();
				
				}
				String cv = ((JTextField) dateChooser_3.getDateEditor().getUiComponent()).getText();
				String sql="insert into  distribution (datedistribution,lieu,banquedesang) values(?,?,?)";
				try {
					preparedStatement=cnx.prepareStatement(sql);
					preparedStatement.setString(1,cv);
					preparedStatement.setString(2,distibution.getSelectedItem().toString());
					preparedStatement.setString(3,adf);
					preparedStatement.execute();
					JOptionPane.showMessageDialog(null,"Journée de Distribution ajoutée !");
					remplirdatetransaction();
					
				} catch (SQLException e1e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Inserez la date!");
				
				
			}
			}
		});
		btnValider.setForeground(Color.BLACK);
		btnValider.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 13));
		btnValider.setBackground(new Color(184, 54, 52));
		btnValider.setBounds(64, 351, 119, 30);
		panelactivite.add(btnValider);
		
		JLabel label_38 = new JLabel("");
		label_38.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			remplircollecte();
			}
		});
		label_38.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\refresh-arrow_icon-icons.com_53911 (1).png"));
		label_38.setBounds(374, 11, 32, 36);
		panelactivite.add(label_38);
		
		JLabel label_39 = new JLabel("");
		label_39.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			remplirdistribution();
			}
		});
		label_39.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\refresh-arrow_icon-icons.com_53911 (1).png"));
		label_39.setBounds(374, 223, 32, 36);
		panelactivite.add(label_39);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\12.png"));
		label_12.setBounds(-23, 0, 886, 421);
		panelactivite.add(label_12);
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\11.png"));
		label.setBounds(-19, 0, 1041, 430);
		contentPane.add(label);
		remplirmed();
		remplirmed1();
		ButtonGroup group=new ButtonGroup();
		group.add(femininDONN);
		group.add(masculinDONN);
		
		JLabel label_19 = new JLabel("");
		label_19.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actualiser();
			}

			
		});
		label_19.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\refresh-arrow_icon-icons.com_53911 (1).png"));
		label_19.setBounds(21, 61, 39, 37);
		paneldon.add(label_19);
		
		JButton voir = new JButton("Voir le Contenu des Tables ");
		voir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				voir.setBackground(new Color(253,198,197));
				voir.setForeground(Color.BLACK);
			}	
			public void mouseExited(MouseEvent e) {
				voir.setBackground(new Color(184,54,52));
				voir.setForeground(Color.BLACK);
			}
			public void mouseClicked(MouseEvent e) {
				FenBanqueDeSangAffichage obj= new FenBanqueDeSangAffichage();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		voir.setForeground(Color.BLACK);
		voir.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 13));
		voir.setBackground(new Color(184, 54, 52));
		voir.setBounds(150, 380, 246, 30);
		paneldon.add(voir);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 21));
		lblContact.setBounds(597, 11, 89, 26);
		paneldon.add(lblContact);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(184, 54, 52));
		panel_7.setBounds(586, 37, 113, 7);
		paneldon.add(panel_7);
		
		JButton btnEnvoyer = new JButton("Envoyer");
		btnEnvoyer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEnvoyer.setBackground(new Color(253,198,197));
				btnEnvoyer.setForeground(Color.BLACK);
			}	
			public void mouseExited(MouseEvent e) {
				btnEnvoyer.setBackground(new Color(184,54,52));
				btnEnvoyer.setForeground(Color.BLACK);
			}
			public void mouseClicked(MouseEvent e) {
			
			if(textArea.getText().equals("") ){
			JOptionPane.showMessageDialog(null,"Remplissez le(s) champ(s) vide(s) ");
			}else{
			
			String sql="insert into contact(nomdonneur,prenomdonneur,emaildonneur,remarque,banquedesang) values( ?,?,?,?,?) ";
			try {
				preparedStatement=cnx.prepareStatement(sql);
				AMINE5();
				 int mm = donneurCONTC.getSelectedIndex();
				 preparedStatement.setString(1,ert[mm]);
				 preparedStatement.setString(2,ert1[mm]);
				 preparedStatement.setString(3,emailCONTC.getText().toString());
				 preparedStatement.setString(4,textArea.getText().toString());
				 preparedStatement.setString(5,adr5);
				 preparedStatement.execute();
				 JOptionPane.showMessageDialog(null,"Remarques Envoyées au donneur ");
				 textArea.setText("");
				 telCONTC.setText("");
				 emailCONTC.setText("");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
			}
		});
		btnEnvoyer.setForeground(Color.BLACK);
		btnEnvoyer.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 13));
		btnEnvoyer.setBackground(new Color(184, 54, 52));
		btnEnvoyer.setBounds(586, 374, 119, 30);
		paneldon.add(btnEnvoyer);
		
		 donneurCONTC = new JComboBox();
		donneurCONTC.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		donneurCONTC.setBackground(new Color(184, 54, 52));
		donneurCONTC.setBounds(477, 72, 155, 26);
		paneldon.add(donneurCONTC);
		
		JLabel lblDonneur_1 = new JLabel("Donneur");
		lblDonneur_1.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblDonneur_1.setBounds(476, 47, 119, 26);
		paneldon.add(lblDonneur_1);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblEmail.setBounds(439, 123, 79, 26);
		paneldon.add(lblEmail);
		
		emailCONTC = new JTextField();
		emailCONTC.setEditable(false);
		emailCONTC.setForeground(Color.BLACK);
		emailCONTC.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		emailCONTC.setColumns(16);
		emailCONTC.setBackground(new Color(184, 54, 52));
		emailCONTC.setBounds(439, 147, 155, 26);
		paneldon.add(emailCONTC);
		
		JLabel label_42 = new JLabel("Telephone");
		label_42.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		label_42.setBounds(637, 123, 79, 26);
		paneldon.add(label_42);
		
		telCONTC = new JTextField();
		telCONTC.setEditable(false);
		telCONTC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int ccc = e.getKeyChar();
				if(Character.isAlphabetic(ccc)){
					telCONTC.setEditable(false);
					lblerror411.setText("Invalide");
				}else{
					telCONTC.setEditable(true);
					lblerror411.setText("");
				}
			}
		});
		telCONTC.setForeground(Color.BLACK);
		telCONTC.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		telCONTC.setColumns(16);
		telCONTC.setBackground(new Color(184, 54, 52));
		telCONTC.setBounds(637, 147, 155, 26);
		paneldon.add(telCONTC);
		
		lblerror411 = new JLabel("");
		lblerror411.setForeground(Color.RED);
		lblerror411.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		lblerror411.setBounds(637, 173, 79, 14);
		paneldon.add(lblerror411);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(184, 54, 52));
		panel_14.setBounds(439, 223, 397, 121);
		paneldon.add(panel_14);
		panel_14.setLayout(null);
		
		JLabel lblRemarques = new JLabel("Remarques");
		lblRemarques.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 12));
		lblRemarques.setBounds(10, 0, 79, 26);
		panel_14.add(lblRemarques);
		
		 textArea = new JTextArea();
		textArea.setForeground(new Color(184, 54, 52));
		textArea.setBackground(new Color(252, 198,197));
		textArea.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		textArea.setLineWrap(true);
		textArea.setBounds(10, 25, 377, 85);
		panel_14.add(textArea);
		
		JLabel label_40 = new JLabel("");
		label_40.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			remplirtelemail();
			}
		});
		label_40.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\refresh-arrow_icon-icons.com_53911 (1).png"));
		label_40.setBounds(443, 93, 39, 37);
		paneldon.add(label_40);
		
		JLabel label_41 = new JLabel("");
		label_41.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			if(telCONTC.getText().equals("")){JOptionPane.showMessageDialog(null,"Remplissez le champ Telephone");}
			else{
			JOptionPane.showMessageDialog(null,"Vous venez d'appeller un donneur au "+telCONTC.getText().toString()+" ");
			int mm = donneurCONTC.getSelectedIndex();
			AMINE5();
			String sql="insert into telephone(nomdonneur,prenomdonneur,banquedesang) values(?,?,?)";
			try {
				preparedStatement=cnx.prepareStatement(sql);
				preparedStatement.setString(1,ert[mm]);
				preparedStatement.setString(2,ert1[mm]);
				preparedStatement.setString(3,adr5);
				preparedStatement.execute();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			}}
		});
		label_41.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\phone-volume_icon-icons.com_56474 (1).png"));
		label_41.setBounds(798, 139, 39, 37);
		paneldon.add(label_41);
		
		JLabel label_43 = new JLabel("");
		label_43.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			if(emailCONTC.getText().equals("")){JOptionPane.showMessageDialog(null,"Remplissez le champ Email");}
			else{
			JOptionPane.showMessageDialog(null,"Vous venez de contacter un donneur à l'email "+emailCONTC.getText().toString()+" ");
			
			int mm = donneurCONTC.getSelectedIndex();
			AMINE5();
			String sql="insert into email(nomdonneur,prenomdonneur,banquedesang) values(?,?,?)";
			try {
				preparedStatement=cnx.prepareStatement(sql);
				preparedStatement.setString(1,ert[mm]);
				preparedStatement.setString(2,ert1[mm]);
				preparedStatement.setString(3,adr5);
				preparedStatement.execute();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}}
			
		});
		label_43.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\email-envelope-outline-shape-with-rounded-corners_icon-icons.com_56530.png"));
		label_43.setBounds(600, 142, 39, 37);
		paneldon.add(label_43);
		
		JLabel label_46 = new JLabel("");
		label_46.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				actualiserNPPP();
			}
		});
		label_46.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\refresh-arrow_icon-icons.com_53911 (1).png"));
		label_46.setBounds(10, 277, 39, 37);
		paneldon.add(label_46);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\12.png"));
		label_7.setBounds(-22, 0, 886, 421);
		paneldon.add(label_7);
		remplirdonn1();
		remplirdonn();
		if(jsk==1){remplirGS();}
		remplirtablestock();
		remplirdistribution();
		remplircollecte();
		remplirdonneurcontact();
		remplirdatetransaction();
		remplirdatedon();
	}
	void remplirmed(){
		String adrrr=null;
		String sql1="select * from banquesangconnecte";
		try {
			preparedStatement2=cnx2.prepareStatement(sql1);
			resultat2=preparedStatement2.executeQuery();
			if(resultat2.next()){
				adrrr=resultat2.getString("adresse")+" "+resultat2.getString("numerobs");	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="select distinct nommed from consultation where banquedesang ='"+adrrr+"'";
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			while(resultat.next()){
				nommedDONN.addItem(resultat.getString("nommed"));
				nommed.addItem(resultat.getString("nommed"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void remplirmed1(){
		String adrrr=null;
		String sql1="select * from banquesangconnecte";
try {
	preparedStatement2=cnx2.prepareStatement(sql1);
	resultat2=preparedStatement2.executeQuery();
	if(resultat2.next()){
		adrrr=resultat2.getString("adresse")+" "+resultat2.getString("numerobs");	
	}
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

		String sql="select distinct prenommed from consultation where banquedesang='"+adrrr+"'";
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			while(resultat.next()){
				prenommedDONN.addItem(resultat.getString("prenommed"));
				prenommed.addItem(resultat.getString("prenommed"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void remplirdonn(){
		
		String adrrr=null;
		String sql1="select * from banquesangconnecte";
		try {
			preparedStatement2=cnx2.prepareStatement(sql1);
			resultat2=preparedStatement2.executeQuery();
			if(resultat2.next()){
				adrrr=resultat2.getString("adresse")+" "+resultat2.getString("numerobs");	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="select distinct nomdonneurfinale from donneurfinale where banquedesang ='"+adrrr+"'";
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			while(resultat.next()){
				nomdonneur.addItem(resultat.getString("nomdonneurfinale"));
				jsk=1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void remplirGS(){
		String sql="select * from donneurfinale where nomdonneurfinale ='"+nomdonneur.getSelectedItem().toString()+"' "
				+ "and prenomdonneurfinale ='"+prenomdonneur.getSelectedItem().toString()+"'";
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			if(resultat.next()){
				groupesanguin.setSelectedItem(resultat.getString("groupesangdonneurfinale"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	void remplirdonn1(){
		String adrrr=null;
		String sql1="select * from banquesangconnecte";
		try {
			preparedStatement2=cnx2.prepareStatement(sql1);
			resultat2=preparedStatement2.executeQuery();
			if(resultat2.next()){
				adrrr=resultat2.getString("adresse")+" "+resultat2.getString("numerobs");	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="select distinct prenomdonneurfinale from donneurfinale where banquedesang ='"+adrrr+"'";
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			while(resultat.next()){
				prenomdonneur.addItem(resultat.getString("prenomdonneurfinale"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void actualiser() {
		String ssString=null;
		String sql="select * from donneur where nomdonneur='"+nomDONN.getText().toString()+"'"
						+ " and prenomdonneur ='"+prenomDONN.getText().toString()+"'";
		if(masculinDONN.isSelected()){ssString="Masculin";}
		if(femininDONN.isSelected()){ssString="Feminin";}
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			if(resultat.next()){
				adresseDONN.setText(resultat.getString("adressedonneur"));
				telDONN.setText(resultat.getString("teldonneur"));
				emailDONN.setText(resultat.getString("emaildonneur"));
				ageDONN.setText(resultat.getString("age"));
				if(resultat.getString("genre").equals("Masculin") ){masculinDONN.setSelected(true);femininDONN.setSelected(false);}
				if(resultat.getString("genre").equals("Feminin") ){masculinDONN.setSelected(false);femininDONN.setSelected(true);}
				groupesangDONN.setSelectedItem(resultat.getString("groupesangdonneur"));
				etatsanteDONN.setSelectedItem(resultat.getString("etatsante"));
			}else{
				adresseDONN.setText("");
				telDONN.setText("");
				emailDONN.setText("");
				ageDONN.setText("");
				masculinDONN.setSelected(false);
				femininDONN.setSelected(false);
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void medecincorrecte(){
		
		String sql="select * from consultation where nommed='"+nommedDONN.getSelectedItem().toString()+"'";
						
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			while(resultat.next()){
				if(resultat.getString("prenommed").equals(prenommedDONN.getSelectedItem().toString())){
					a=1;
				}else{
					a=0;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
        public void medecincorrecte1(){
		
		String sql="select * from consultation where nommed='"+nommed.getSelectedItem().toString()+"'";
						
		try {
			preparedStatement4=cnx4.prepareStatement(sql);
			resultat4=preparedStatement4.executeQuery();
			while(resultat4.next()){
				if(resultat4.getString("prenommed").equals(prenommed.getSelectedItem().toString())){
					aa=1;
				}else{
					aa=0;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
      public void donneurcorrecte(){
		
		String sql="select * from donneurfinale where nomdonneurfinale='"+nomdonneur.getSelectedItem().toString()+"'";
						
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			while(resultat.next()){
				if(resultat.getString("prenomdonneurfinale").equals(prenomdonneur.getSelectedItem())){
					b=1;
				}else{
					b=0;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
      public void donneurcorrecte1(){
  		
  		String sql="select * from donneurfinale where nomdonneurfinale='"+nomdonneurTRAN.getSelectedItem().toString()+"'";
  						
  		try {
  			preparedStatement=cnx.prepareStatement(sql);
  			resultat=preparedStatement.executeQuery();
  			while(resultat.next()){
  				if(resultat.getString("prenomdonneurfinale").equals(prenomdonneurTRAN.getSelectedItem())){
  					c=1;
  				}else{
  					c=0;
  				}
  			}
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  	}
	void AMINE() {
		 		
		 String sql="select * from consultation  where nomdonneur='"+nomDONN.getText().toString()+"'"
						+ " and prenomdonneur ='"+prenomDONN.getText().toString()+"'";
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			if(resultat.next()){
				adr=resultat.getString("banquedesang");	
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		}
	void AMINE1() {
 		
		 String sql="select * from consultation  where nomdonneur='"+nomdonneur.getSelectedItem().toString()+"'"
						+ " and prenomdonneur ='"+prenomdonneur.getSelectedItem().toString()+"'";
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			if(resultat.next()){
				adr1=resultat.getString("banquedesang");	
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		}
	void AMINE2() {
 		
		 String sql="select * from consultation  where nomdonneur='"+nomdonneurTRAN.getSelectedItem().toString()+"'"
						+ " and prenomdonneur ='"+prenomdonneurTRAN.getSelectedItem().toString()+"'";
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			if(resultat.next()){
				adr2=resultat.getString("banquedesang");	
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		}
	void AMINE4() {
 		
		 String sql="select * from demandesang  where numdemande='"+numerodemande.getSelectedItem().toString()+"'";
						
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			if(resultat.next()){
				adr4=resultat.getString("banquedesang");	
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		}
	void remplirdemande(){
		String adrrr=null;
		String sql1="select * from banquesangconnecte";
		try {
			preparedStatement2=cnx2.prepareStatement(sql1);
			resultat2=preparedStatement2.executeQuery();
			if(resultat2.next()){
				adrrr=resultat2.getString("adresse")+" "+resultat2.getString("numerobs");	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="Select * from demandesang where decision = 'En Attente' and banquedesang='"+adrrr+"'";
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			while(resultat.next()){
				numerodemande.addItem(resultat.getString("numdemande"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void remplirdest(){
		String sql="Select * from demandesang where numdemande ='"+numerodemande.getSelectedItem().toString()+"'";
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			while(resultat.next()){
				nomdestTRAN.setText(resultat.getString("nomdest"));
				prenomdestTRAN.setText(resultat.getString("prenomdest"));
				groupesanguinTRAN.setText(resultat.getString("groupesang"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void remplirdonneursTRAN(){
		nomdonneurTRAN.removeAllItems();
		prenomdonneurTRAN.removeAllItems();
		String gString=null;
		int ml=0;
		String sql="Select * from demandesang where numdemande ='"+numerodemande.getSelectedItem().toString()+"'";
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			while(resultat.next()){
				gString= resultat.getString("groupesang");	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql1="select * from donneurfinale where groupesangdonneurfinale ='"+gString+"'";
		try {
			preparedStatement2=cnx2.prepareStatement(sql1);
			resultat2=preparedStatement2.executeQuery();
			while(resultat2.next()){
				ml=1;
				nomdonneurTRAN.addItem(resultat2.getString("nomdonneurfinale"));
				prenomdonneurTRAN.addItem(resultat2.getString("prenomdonneurfinale"));
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	void remplirtablestock(){
		String adrrr=null;
		String sql1="select * from banquesangconnecte";
		try {
			preparedStatement2=cnx2.prepareStatement(sql1);
			resultat2=preparedStatement2.executeQuery();
			if(resultat2.next()){
				adrrr=resultat2.getString("adresse")+" "+resultat2.getString("numerobs");	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql ="select numdon,datedon,qte,groupesanguin from don where banquedesang ='"+adrrr+"'";		
		try {
			preparedStatement2 = cnx2.prepareStatement(sql);
			resultat2=preparedStatement2.executeQuery();
			tablestock.setModel(DbUtils.resultSetToTableModel(resultat2));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	
	}
	void stocktotale(){
		String ss=null;
		int a=0;
		int v=0;
		
		String adrrr=null;
		String sql1="select * from banquesangconnecte";
		try {
			preparedStatement2=cnx2.prepareStatement(sql1);
			resultat2=preparedStatement2.executeQuery();
			if(resultat2.next()){
				adrrr=resultat2.getString("adresse")+" "+resultat2.getString("numerobs");	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="select * from don where banquedesang='"+adrrr+"'";
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			while(resultat.next()){
			 a = resultat.getInt("qte");
			 v=v+a;
			}
			String ss1 = String.valueOf(v);
			qteTOTALE.setText(ss1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void remplirquantitepargs(){
		String adrrr=null;
		int v=0;
		String sql1="select * from banquesangconnecte";
		try {
			preparedStatement2=cnx2.prepareStatement(sql1);
			resultat2=preparedStatement2.executeQuery();
			if(resultat2.next()){
				adrrr=resultat2.getString("adresse")+" "+resultat2.getString("numerobs");	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="select * from don where banquedesang='"+adrrr+"' and groupesanguin ='"+AAA.getSelectedItem().toString()+"'";
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			while(resultat.next()){
			 a = resultat.getInt("qte");
			 v=v+a;
			}
			String ss1 = String.valueOf(v);
			BBB.setText(ss1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void remplircollecte(){
		String adrrr=null;
		int v=0;
		String sql1="select * from banquesangconnecte";
		try {
			preparedStatement2=cnx2.prepareStatement(sql1);
			resultat2=preparedStatement2.executeQuery();
			if(resultat2.next()){
				adrrr=resultat2.getString("adresse")+" "+resultat2.getString("numerobs");	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="select * from collecte where banquedesang='"+adrrr+"'";
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			tablecollectes.setModel(DbUtils.resultSetToTableModel(resultat));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void remplirdistribution(){
		String adrrr=null;
		int v=0;
		String sql1="select * from banquesangconnecte";
		try {
			preparedStatement2=cnx2.prepareStatement(sql1);
			resultat2=preparedStatement2.executeQuery();
			if(resultat2.next()){
				adrrr=resultat2.getString("adresse")+" "+resultat2.getString("numerobs");	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="select * from distribution where banquedesang='"+adrrr+"'";
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			tabledistribution.setModel(DbUtils.resultSetToTableModel(resultat));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void remplirdonneurcontact(){
		String adrrr=null;
		String sql="select * from banquesangconnecte";
		try {
			preparedStatement2=cnx2.prepareStatement(sql);
			resultat2=preparedStatement2.executeQuery();
			if(resultat2.next()){
				adrrr=resultat2.getString("adresse")+" "+resultat2.getString("numerobs");	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 ert = new String[30];
	ert1 = new String[30];
	int i=0;
		String sql1="select * from donneurfinale where banquedesang ='"+adrrr+"'";
		try {
			preparedStatement2=cnx2.prepareStatement(sql1);
			resultat2=preparedStatement2.executeQuery();
			while(resultat2.next()){
				donneurCONTC.addItem(resultat2.getString("nomdonneurfinale")+" "+resultat2.getString("prenomdonneurfinale"));	
				ert[i] = resultat2.getString("nomdonneurfinale");
				ert1[i] = resultat2.getString("prenomdonneurfinale");	
				i++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void remplirtelemail(){
	    String ss = donneurCONTC.getSelectedItem().toString();
	    int mm = donneurCONTC.getSelectedIndex();
	    String sql="select * from donneurfinale where nomdonneurfinale = '"+ert[mm]+"' and prenomdonneurfinale='"+ert1[mm]+"'";
	      try {
			preparedStatement2=cnx2.prepareStatement(sql);
			resultat2=preparedStatement2.executeQuery();
			if(resultat2.next()){
			   telCONTC.setText(resultat2.getString("teldonneurfinale"));
			   emailCONTC.setText(resultat2.getString("emaildonneurfinale"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	void AMINE5(){
	    
	    int mm = donneurCONTC.getSelectedIndex();
	    String sql="select * from donneurfinale where nomdonneurfinale = '"+ert[mm]+"' and prenomdonneurfinale='"+ert1[mm]+"'";
	      try {
			preparedStatement2=cnx2.prepareStatement(sql);
			resultat2=preparedStatement2.executeQuery();
			if(resultat2.next()){
			   adr5=resultat2.getString("banquedesang");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	void actualiserNP(){
		
			String adrrr=null;
			String sql1="select * from banquesangconnecte";
			try {
				preparedStatement2=cnx2.prepareStatement(sql1);
				resultat2=preparedStatement2.executeQuery();
				if(resultat2.next()){
					adrrr=resultat2.getString("adresse")+" "+resultat2.getString("numerobs");	
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sql="select distinct prenomdonneurfinale from donneurfinale where banquedesang ='"+adrrr+"' and nomdonneurfinale ='"+nomdonneur.getSelectedItem().toString()+"'";
			
			try {
				preparedStatement=cnx.prepareStatement(sql);
				resultat=preparedStatement.executeQuery();
				if(resultat.next()){
					prenomdonneur.setSelectedItem(resultat.getString("prenomdonneurfinale"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	void actualiserNPPP(){
		
		String sql="select distinct prenommedecin from medecin where nommedecin ='"+nommedDONN.getSelectedItem().toString()+"'";
		
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			if(resultat.next()){
				prenommedDONN.setSelectedItem(resultat.getString("prenommedecin"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	void actualiserNP1(){
		
		String adrrr=null;
		String sql1="select * from banquesangconnecte";
		try {
			preparedStatement2=cnx2.prepareStatement(sql1);
			resultat2=preparedStatement2.executeQuery();
			if(resultat2.next()){
				adrrr=resultat2.getString("adresse")+" "+resultat2.getString("numerobs");	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="select distinct prenommed from consultation where banquedesang ='"+adrrr+"' and nommed='"+nommed.getSelectedItem().toString()+"'";
		
		try {
			preparedStatement=cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			if(resultat.next()){
				prenommed.setSelectedItem(resultat.getString("prenommed"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void remplirdatetransaction(){
		datetransaction.removeAllItems();
		
		String adrrr=null;
		String sql1="select * from banquesangconnecte";
		try {
			preparedStatement2=cnx2.prepareStatement(sql1);
			resultat2=preparedStatement2.executeQuery();
			if(resultat2.next()){
				adrrr=resultat2.getString("adresse")+" "+resultat2.getString("numerobs");	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="select distinct datedistribution from distribution where banquedesang ='"+adrrr+"'";
		try {
			preparedStatement2=cnx2.prepareStatement(sql);
			resultat2=preparedStatement2.executeQuery();
			while(resultat2.next()){
				datetransaction.addItem(resultat2.getString("datedistribution"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void remplirdatedon(){
		datedon.removeAllItems();
		String adrrr=null;
		String sql1="select * from banquesangconnecte";
		try {
			preparedStatement2=cnx2.prepareStatement(sql1);
			resultat2=preparedStatement2.executeQuery();
			if(resultat2.next()){
				adrrr=resultat2.getString("adresse")+" "+resultat2.getString("numerobs");	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="select distinct datecollecte from collecte where banquedesang ='"+adrrr+"'";
		try {
			preparedStatement2=cnx2.prepareStatement(sql);
			resultat2=preparedStatement2.executeQuery();
			while(resultat2.next()){
				datedon.addItem(resultat2.getString("datecollecte"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
