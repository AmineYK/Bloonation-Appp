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
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FenBanqueDeSangAffichage extends JFrame {

	private JPanel contentPane;
	private JPanel panelprincipale;
	private CardLayout cardLayout;
	private JPanel paneldonneur;
	private JPanel panelconsultations;
	private JTable tableconsultations;
	private JTable tabledonneurs;
	Connection cnx=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultat=null;
	Connection cnx2=null;
	PreparedStatement preparedStatement2=null;
	ResultSet resultat2=null;
	private JPanel paneldons;
	private JTable tabledons;
	private JPanel paneltransactions;
	private JTable tabletransactions;
	private JPanel paneldemandes;
	private JTable tabledemandes;
	private JPanel panelstocks;
	private JTable tablestocks;
	private JPanel panelcarnet;
	private JTable tablecarnets;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new NimbusLookAndFeel());
					FenBanqueDeSangAffichage frame = new FenBanqueDeSangAffichage();
					
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
	public FenBanqueDeSangAffichage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985,422);
		super.setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ImageIcon obj1 = new ImageIcon(getClass().getResource("/Icones/transfuse_38039.png"));
		super.setIconImage(obj1.getImage());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		cnx=ConnexionMySql.ConnectionDB();
		cnx2=ConnexionMySql.ConnectionDB();
		
		JLabel lblDonneur = new JLabel("     Donneurs");
		lblDonneur.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				paneldonneur.setVisible(true);
				panelconsultations.setVisible(false);
				cardLayout.show(panelprincipale,"1");
				remplirtable2();
				
				
			}
		});
		lblDonneur.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblDonneur.setBounds(-4, 0, 139, 39);
		contentPane.add(lblDonneur);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 255));
		panel.setBounds(8, 35, 113, 7);
		contentPane.add(panel);
		
		JLabel lblConsultations = new JLabel("  Consultations");
		lblConsultations.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				paneldonneur.setVisible(false);
				panelconsultations.setVisible(true);
				cardLayout.show(panelprincipale,"2");
				remplirtable1();
				
				
			}
		});
		lblConsultations.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblConsultations.setBounds(-4, 50, 139, 39);
		contentPane.add(lblConsultations);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 255));
		panel_1.setBounds(8, 85, 113, 7);
		contentPane.add(panel_1);
		
		JLabel lblDons = new JLabel("         Dons");
		lblDons.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				paneldonneur.setVisible(false);
				panelconsultations.setVisible(false);
				paneldons.setVisible(true);
				cardLayout.show(panelprincipale,"3");
				remplirtable3();
				
				
			}
		});
		lblDons.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblDons.setBounds(-4, 100, 139, 39);
		contentPane.add(lblDons);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 204, 255));
		panel_2.setBounds(8, 135, 113, 7);
		contentPane.add(panel_2);
		
		JLabel lblTransctions = new JLabel("   Transctions");
		lblTransctions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				paneldonneur.setVisible(false);
				panelconsultations.setVisible(false);
				paneldons.setVisible(false);
				panelstocks.setVisible(false);
				paneltransactions.setVisible(true);
				cardLayout.show(panelprincipale,"4");
				remplirtable4();
			}
		});
		lblTransctions.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblTransctions.setBounds(-4, 201, 139, 39);
		contentPane.add(lblTransctions);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 204, 255));
		panel_3.setBounds(8, 236, 113, 7);
		contentPane.add(panel_3);
		
		JLabel lblDemandes = new JLabel("    Demandes");
		lblDemandes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				paneldonneur.setVisible(false);
				panelconsultations.setVisible(false);
				paneldons.setVisible(false);
				paneltransactions.setVisible(false);
				panelcarnet.setVisible(false);
				paneldemandes.setVisible(true);
				cardLayout.show(panelprincipale,"5");
				remplirtable5();
			
			}
		});
		lblDemandes.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblDemandes.setBounds(-4, 249, 139, 39);
		contentPane.add(lblDemandes);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 204, 255));
		panel_4.setBounds(8, 284, 113, 7);
		contentPane.add(panel_4);
		
		JLabel label_11 = new JLabel("BlooNation");
		label_11.setFont(new Font("Lucida Handwriting", Font.BOLD | Font.ITALIC, 17));
		label_11.setBounds(0, 370, 135, 32);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("by AmineYK");
		label_12.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		label_12.setBounds(43, 396, 88, 14);
		contentPane.add(label_12);
		
		panelprincipale = new JPanel();
		panelprincipale.setBounds(141, 0, 846, 421);
		contentPane.add(panelprincipale);
		cardLayout = new CardLayout(0, 0);
		panelprincipale.setLayout(cardLayout);
		
		paneldonneur = new JPanel();
		panelprincipale.add(paneldonneur, "1");
		paneldonneur.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(184, 54, 52));
		panel_6.setBounds(67, 11, 769, 399);
		paneldonneur.add(panel_6);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 4, 749, 384);
		panel_6.add(scrollPane_1);
		
		tabledonneurs = new JTable();
		tabledonneurs.setBackground(new Color(252,198, 197));
		tabledonneurs.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		scrollPane_1.setViewportView(tabledonneurs);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FenBanqueDeSang obj=new FenBanqueDeSang();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		label_1.setIcon(new ImageIcon(getClass().getResource("/Icones/arrow-address-back_icon-icons.com_54065.png")));
		label_1.setBounds(10, 0, 59, 39);
		paneldonneur.add(label_1);
		JLabel labelA = new JLabel("");
		labelA.setIcon(new ImageIcon(getClass().getResource("/Icones/12.png")));
		labelA.setBounds(-21, 0, 886, 421);
		paneldonneur.add(labelA);
		
		panelconsultations = new JPanel();
		panelprincipale.add(panelconsultations, "2");
		panelconsultations.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(184, 54, 52));
		panel_5.setBounds(67, 11, 769, 399);
		panelconsultations.add(panel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 4, 749, 384);
		panel_5.add(scrollPane);
		
		tableconsultations = new JTable();
		tableconsultations.setBackground(new Color(252,198, 197));
		tableconsultations.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		scrollPane.setViewportView(tableconsultations);
		
		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FenBanqueDeSang obj=new FenBanqueDeSang();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		label_2.setIcon(new ImageIcon(getClass().getResource("/Icones/arrow-address-back_icon-icons.com_54065.png")));
		label_2.setBounds(10, 0, 59, 39);
		panelconsultations.add(label_2);
		JLabel labelB = new JLabel("");
		labelB.setIcon(new ImageIcon(getClass().getResource("/Icones/12.png")));
		labelB.setBounds(-21, 0, 886, 421);
		panelconsultations.add(labelB);
		
		paneldons = new JPanel();
		panelprincipale.add(paneldons, "3");
		paneldons.setLayout(null);
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBackground(new Color(184, 54, 52));
		panel3.setBounds(67, 11, 769, 399);
		paneldons.add(panel3);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 4, 749, 384);
		panel3.add(scrollPane_2);
		
		tabledons = new JTable();
		tabledons.setBackground(new Color(252,198, 197));
		tabledons.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		scrollPane_2.setViewportView(tabledons);
		
		JLabel label_23 = new JLabel("");
		label_23.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FenBanqueDeSang obj=new FenBanqueDeSang();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		label_23.setIcon(new ImageIcon(getClass().getResource("/Icones/arrow-address-back_icon-icons.com_54065.png")));
		label_23.setBounds(10, 0, 59, 39);
		paneldonneur.add(label_23);
		
		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FenBanqueDeSang obj=new FenBanqueDeSang();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		label_3.setIcon(new ImageIcon(getClass().getResource("/Icones/arrow-address-back_icon-icons.com_54065.png")));
		label_3.setBounds(10, 0, 59, 39);
		paneldons.add(label_3);
		JLabel labelC = new JLabel("");
		labelC.setIcon(new ImageIcon(getClass().getResource("/Icones/12.png")));
		
		paneldons.add(labelC);

		paneltransactions = new JPanel();
		panelprincipale.add(paneltransactions, "4");
		paneltransactions.setLayout(null);
		
		JPanel panel_98 = new JPanel();
		panel_98.setLayout(null);
		panel_98.setBackground(new Color(184, 54, 52));
		panel_98.setBounds(67, 11, 769, 399);
		paneltransactions.add(panel_98);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 4, 749, 384);
		panel_98.add(scrollPane_3);
		
		tabletransactions = new JTable();
		tabletransactions.setBackground(new Color(252,198, 197));
		tabletransactions.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		scrollPane_3.setViewportView(tabletransactions);
		
		JLabel label_D = new JLabel("");
		label_D.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FenBanqueDeSang obj=new FenBanqueDeSang();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		label_D.setIcon(new ImageIcon(getClass().getResource("/Icones/arrow-address-back_icon-icons.com_54065.png")));
		label_D.setBounds(10, 0, 59, 39);
		paneltransactions.add(label_D);
		JLabel labelSD = new JLabel("");
		labelSD.setIcon(new ImageIcon(getClass().getResource("/Icones/12.png")));
		labelSD.setBounds(-21, 0, 886, 421);
		paneltransactions.add(labelSD);
		
		paneldemandes = new JPanel();
		panelprincipale.add(paneldemandes, "5");
		paneldemandes.setLayout(null);
		
		JPanel panel_62 = new JPanel();
		panel_62.setLayout(null);
		panel_62.setBackground(new Color(184, 54, 52));
		panel_62.setBounds(67, 11, 769, 399);
		paneldemandes.add(panel_62);
		
		JScrollPane scrollPane_12 = new JScrollPane();
		scrollPane_12.setBounds(10, 4, 749, 384);
		panel_62.add(scrollPane_12);
		
		tabledemandes = new JTable();
		tabledemandes.setBackground(new Color(252,198, 197));
		tabledemandes.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		scrollPane_12.setViewportView(tabledemandes);
		
		JLabel label_111 = new JLabel("");
		label_111.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FenBanqueDeSang obj=new FenBanqueDeSang();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		label_111.setIcon(new ImageIcon(getClass().getResource("/Icones/arrow-address-back_icon-icons.com_54065.png")));
		paneldemandes.add(label_111);
		JLabel labeZlA = new JLabel("");
		labeZlA.setIcon(new ImageIcon(getClass().getResource("/Icones/12.png")));
		labeZlA.setBounds(-21, 0, 886, 421);
		paneldemandes.add(labeZlA);
		
		panelstocks = new JPanel();
		panelprincipale.add(panelstocks, "6");
		panelstocks.setLayout(null);
		
		JPanel panel_63 = new JPanel();
		panel_63.setLayout(null);
		panel_63.setBackground(new Color(184, 54, 52));
		panel_63.setBounds(67, 11, 769, 399);
		panelstocks.add(panel_63);
		
		JScrollPane scrollPane_111 = new JScrollPane();
		scrollPane_111.setBounds(10, 4, 749, 384);
		panel_63.add(scrollPane_111);
		
		tablestocks = new JTable();
		tablestocks.setBackground(new Color(252,198, 197));
		tablestocks.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		scrollPane_111.setViewportView(tablestocks);
		
		JLabel label_190 = new JLabel("");
		label_190.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FenBanqueDeSang obj=new FenBanqueDeSang();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		label_190.setIcon(new ImageIcon(getClass().getResource("/Icones/arrow-address-back_icon-icons.com_54065.png")));
		label_190.setBounds(10, 0, 59, 39);
		panelstocks.add(label_190);
		JLabel labelEA = new JLabel("");
	    labelEA.setIcon(new ImageIcon(getClass().getResource("/Icones/12.png")));
		labelEA.setBounds(-21, 0, 886, 421);
		panelstocks.add(labelEA);
		
		
		panelcarnet = new JPanel();
		panelprincipale.add(panelcarnet, "7");
		panelcarnet.setLayout(null);
		
		JPanel panel_363 = new JPanel();
		panel_363.setLayout(null);
		panel_363.setBackground(new Color(184, 54, 52));
		panel_363.setBounds(67, 11, 769, 399);
		panelcarnet.add(panel_363);
		
		JScrollPane scrollPane_1191 = new JScrollPane();
		scrollPane_1191.setBounds(10, 4, 749, 384);
		panel_363.add(scrollPane_1191);
		
		tablecarnets = new JTable();
		tablecarnets.setBackground(new Color(252,198, 197));
		tablecarnets.setFont(new Font("Lucida Fax", Font.ITALIC, 12));
		scrollPane_1191.setViewportView(tablecarnets);
		
		JLabel label_10 = new JLabel("");
		label_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FenBanqueDeSang obj=new FenBanqueDeSang();
				obj.setVisible(true);
				obj.setLocationRelativeTo(null);
				dispose();
			}
		});
		label_10.setIcon(new ImageIcon(getClass().getResource("/Icones/arrow-address-back_icon-icons.com_54065.png")));
		label_10.setBounds(10, 0, 59, 39);
		panelcarnet.add(label_10);
		JLabel labelEPA = new JLabel("");
		labelEPA.setIcon(new ImageIcon(getClass().getResource("/Icones/12.png")));
		labelEPA.setBounds(-21, 0, 886, 421);
		panelcarnet.add(labelEPA);
		
		
		
		JLabel lblStocks = new JLabel("        Stocks");
		lblStocks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				paneldonneur.setVisible(false);
				panelstocks.setVisible(true);
				paneltransactions.setVisible(false);
				cardLayout.show(panelprincipale,"6");
				remplirtable6();
			}
		});
		lblStocks.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblStocks.setBounds(-4, 150, 139, 39);
		contentPane.add(lblStocks);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 204, 255));
		panel_7.setBounds(8, 185, 113, 7);
		contentPane.add(panel_7);
		
		JLabel lblDeSant = new JLabel("      De Sant\u00E9");
		lblDeSant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				paneldonneur.setVisible(false);
				panelcarnet.setVisible(true);
				cardLayout.show(panelprincipale,"7");
				remplirtable7();
			}
		});
		lblDeSant.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblDeSant.setBounds(-4, 318, 139, 32);
		contentPane.add(lblDeSant);
		
		JLabel lblCarnet = new JLabel("        Carnet ");
		lblCarnet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				paneldonneur.setVisible(false);
				panelcarnet.setVisible(true);
				cardLayout.show(panelprincipale,"7");
				remplirtable7();
			}
		});
		lblCarnet.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 16));
		lblCarnet.setBounds(-4, 299, 139, 32);
		contentPane.add(lblCarnet);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 204, 255));
		panel_8.setBounds(8, 343, 113, 7);
		contentPane.add(panel_8);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(getClass().getResource("/Icones/11.png")));
		label.setBounds(-19, 0, 1041, 430);
		contentPane.add(label);
	}
	void remplirtable1(){
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
		String sql="select * from consultation where banquedesang ='"+adrrr+"'";
        
		
		try {
			preparedStatement = cnx.prepareStatement(sql);
			resultat=preparedStatement.executeQuery();
			tableconsultations.setModel(DbUtils.resultSetToTableModel(resultat));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	void remplirtable2(){
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
    String sql="select * from donneurfinale where banquedesang ='"+adrrr+"'";
        
		
		try {
			preparedStatement2 = cnx2.prepareStatement(sql);
			resultat2=preparedStatement2.executeQuery();
			tabledonneurs.setModel(DbUtils.resultSetToTableModel(resultat2));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
	void remplirtable3(){
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
    String sql="select * from don where banquedesang ='"+adrrr+"'";
        
		
		try {
			preparedStatement2 = cnx2.prepareStatement(sql);
			resultat2=preparedStatement2.executeQuery();
			tabledons.setModel(DbUtils.resultSetToTableModel(resultat2));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
	void remplirtable4(){
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
    String sql="select * from transaction where banquedesang ='"+adrrr+"'";
        
		
		try {
			preparedStatement2 = cnx2.prepareStatement(sql);
			resultat2=preparedStatement2.executeQuery();
			tabletransactions.setModel(DbUtils.resultSetToTableModel(resultat2));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
	void remplirtable5(){
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
    String sql="select * from demandesang where banquedesang ='"+adrrr+"'";
        
		
		try {
			preparedStatement2 = cnx2.prepareStatement(sql);
			resultat2=preparedStatement2.executeQuery();
			tabledemandes.setModel(DbUtils.resultSetToTableModel(resultat2));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
	void remplirtable6(){
	
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
			String sql ="select numdon,banquedesang,datedon,qte,groupesanguin from don where banquedesang ='"+adrrr+"'";		
			try {
				preparedStatement2 = cnx2.prepareStatement(sql);
				resultat2=preparedStatement2.executeQuery();
				tablestocks.setModel(DbUtils.resultSetToTableModel(resultat2));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
		
	
	}
	void remplirtable7(){
		
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
		String sql ="select * from consultation where banquedesang ='"+adrrr+"'";		
		try {
			preparedStatement2 = cnx2.prepareStatement(sql);
			resultat2=preparedStatement2.executeQuery();
			tablecarnets.setModel(DbUtils.resultSetToTableModel(resultat2));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	

}

}
