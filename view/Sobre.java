package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Sobre extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre dialog = new Sobre();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Sobre() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/informacoes (1).png")));
		setBounds(100, 100, 481, 403);
		getContentPane().setLayout(null);
		
		JTextPane txtpnOSupermercadoVillage = new JTextPane();
		txtpnOSupermercadoVillage.setEditable(false);
		txtpnOSupermercadoVillage.setBackground(SystemColor.menu);
		txtpnOSupermercadoVillage.setText("O supermercado Village Marker possui produtos voltados para a classe A, onde a grande maioria \u00E9 de marca importada, tem tamb\u00E9m muita variedade de produtos de origem org\u00E2nica. Faz tamb\u00E9m muito Merchandising de produtos importados, pois s\u00E3o os que mais encontramos no interior das lojas e das suas marcas pr\u00F3prias, que s\u00E3o Qualit\u00E1 e Taeq. Possui uma arruma\u00E7\u00E3o de produtos impec\u00E1veis, divididos por marcas e g\u00EAneros, sempre identificados por placas que ficam acima das g\u00F4ndolas. Em suas cores, percebemos maior destaque no verde, pois uma das maiores caracter\u00EDsticas do Village Marker \u00E9 a preocupa\u00E7\u00E3o s\u00F3cio ambiental.");
		txtpnOSupermercadoVillage.setBounds(10, 79, 314, 274);
		getContentPane().add(txtpnOSupermercadoVillage);
		
		JLabel lblNewLabel = new JLabel("Sobre N\u00F3s");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(88, 29, 119, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Sobre.class.getResource("/img/github (1).png")));
		lblNewLabel_1.setBounds(374, 11, 64, 64);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("GitHub");
		lblNewLabel_2.setBounds(391, 87, 64, 14);
		getContentPane().add(lblNewLabel_2);

	}
}
