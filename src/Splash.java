import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.UIManager;

public class Splash extends JFrame {

	private JPanel contentPane;
	private static JLabel label_1;
	private static JProgressBar progressBar;
	private JLabel lblChargement;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel lblBloo;
	private JLabel lblD;
	private JLabel lblDon;
	private JLabel lblAtion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
			

			
				
					int x;
					Splash frame = new Splash();
					frame.setVisible(true);
					try {
						UIManager.setLookAndFeel(new NimbusLookAndFeel());
					for(x=0;x<=100;x++){
						Splash.progressBar.setValue(x);
						Thread.sleep(50);
					    Splash.label_1.setText(Integer.toString(x)+"%");
					    if(x==100){
					    	Auth obj = new Auth();
					    	obj.setVisible(true);
					    	obj.setLocationRelativeTo(null);
					    	frame.dispose();
					    }
					}
				
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
	
	

	/**
	 * Create the frame.
	 */
	public Splash() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710,400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		ImageIcon obj1 = new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\transfuse_38039.png");
		super.setIconImage(obj1.getImage());
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		 progressBar = new JProgressBar();
		 progressBar.setBackground(Color.DARK_GRAY);
		 progressBar.setForeground(Color.LIGHT_GRAY);
		// progressBar.setForeround(Color.green)
		progressBar.setBounds(95, 350, 500, 13);
		contentPane.add(progressBar);
		
		label_1 = new JLabel("");
		label_1.setForeground(Color.LIGHT_GRAY);
		label_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 14));
		label_1.setBounds(386, 316, 53, 30);
		contentPane.add(label_1);
		
		lblChargement = new JLabel("Chargement ...");
		lblChargement.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 13));
		lblChargement.setForeground(Color.LIGHT_GRAY);
		lblChargement.setBounds(268, 324, 110, 14);
		contentPane.add(lblChargement);
		
		JLabel lblBloonation = new JLabel("Bloonation");
		lblBloonation.setForeground(Color.LIGHT_GRAY);
		lblBloonation.setFont(new Font("Lucida Handwriting", Font.BOLD | Font.ITALIC, 64));
		lblBloonation.setBounds(115, 6, 494, 135);
		contentPane.add(lblBloonation);
		
		label_2 = new JLabel("La vie , on a  \u00E7a dans le sang  ");
		label_2.setForeground(Color.LIGHT_GRAY);
		label_2.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 30));
		label_2.setBounds(125, 203, 484, 48);
		contentPane.add(label_2);
		
		label_3 = new JLabel("Partageons-la en donnant");
		label_3.setForeground(Color.LIGHT_GRAY);
		label_3.setFont(new Font("Lucida Fax", Font.BOLD | Font.ITALIC, 30));
		label_3.setBounds(150, 256, 429, 48);
		contentPane.add(label_3);
		
		label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("C:\\Users\\m2k\\Desktop\\Amine YKh\\amine\\Travaux \u00E0 faire\\PROJET TP GL2\\transfuse_38039.png"));
		label_4.setBounds(620, 306, 78, 81);
		contentPane.add(label_4);
		
		lblBloo = new JLabel("Bloo");
		lblBloo.setForeground(new Color(255, 0, 0));
		lblBloo.setFont(new Font("Lucida Handwriting", Font.BOLD | Font.ITALIC, 46));
		lblBloo.setBounds(50, 92, 157, 94);
		contentPane.add(lblBloo);
		
		
		lblD = new JLabel("d");
		lblD.setForeground(Color.LIGHT_GRAY);
		lblD.setFont(new Font("Lucida Handwriting", Font.BOLD | Font.ITALIC, 46));
		lblD.setBounds(185, 91, 78, 94);
		contentPane.add(lblD);
		
		lblDon = new JLabel("Don");
		lblDon.setForeground(Color.LIGHT_GRAY);
		lblDon.setFont(new Font("Lucida Handwriting", Font.BOLD | Font.ITALIC, 46));
		lblDon.setBounds(344, 102, 132, 81);
		contentPane.add(lblDon);
		
		lblAtion = new JLabel("ation");
		lblAtion.setForeground(new Color(255, 0, 0));
		lblAtion.setFont(new Font("Lucida Handwriting", Font.BOLD | Font.ITALIC, 46));
		lblAtion.setBounds(471, 94, 179, 94);
		contentPane.add(lblAtion);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Belinfo\\Bureau\\Amine YK\\Amine YK\\Amine YKh\\amine\\Bloonation Ressources\\cassi-josh-lhnOvu72BM8-unsplash.jpg"));
		lblNewLabel.setBounds(0, 0, 710, 400);
		contentPane.add(lblNewLabel);
	}
}
