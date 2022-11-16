package view;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblData;
	// atribuir o modificador publico para manipular estes objetos de outra classe
	public JButton btnUsuarios;
	public JButton btnRelatorios;
	public JPanel panelUsuario;
	public JLabel lblUsuario;
	private JLabel lblUsurio;
	private JLabel lblNewLabel;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		addWindowListener(new WindowAdapter() {
			//evento ativar janela
			@Override
			public void windowActivated(WindowEvent e) {
				Date data = new Date();
		        DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
		        lblData.setText(formatador.format(data));
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/favicon.png")));
		setTitle("Lojinha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnUsuarios = new JButton("");
		btnUsuarios.setDefaultCapable(false);
		btnUsuarios.setContentAreaFilled(false);
		btnUsuarios.setEnabled(false);
		btnUsuarios.addActionListener(new ActionListener() {
			//evento clicar no botão
			public void actionPerformed(ActionEvent e) {
				// Link para o jDialog
				Usuarios usuarios = new Usuarios();
				usuarios.setVisible(true);
			}
		});
		btnUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUsuarios.setToolTipText("Usu\u00E1rios");
		btnUsuarios.setIcon(new ImageIcon(Principal.class.getResource("/img/users.png")));
		btnUsuarios.setBounds(146, 11, 128, 128);
		contentPane.add(btnUsuarios);
		
		JButton btnFornecedores = new JButton("");
		btnFornecedores.setDefaultCapable(false);
		btnFornecedores.setContentAreaFilled(false);
		btnFornecedores.setBorderPainted(false);
		btnFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fornecedores fornecedores = new Fornecedores();
				fornecedores.setVisible(true);
			}
		});
		btnFornecedores.setToolTipText("Fornecedores");
		btnFornecedores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFornecedores.setIcon(new ImageIcon(Principal.class.getResource("/img/supliers.png")));
		btnFornecedores.setBounds(344, 11, 113, 96);
		contentPane.add(btnFornecedores);
		
		JButton btnProdutos = new JButton("");
		btnProdutos.setDefaultCapable(false);
		btnProdutos.setContentAreaFilled(false);
		btnProdutos.setBorderPainted(false);
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Produtos produtos = new Produtos();
				produtos.setVisible(true);
			}
		});
		btnProdutos.setToolTipText("Produtos");
		btnProdutos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProdutos.setIcon(new ImageIcon(Principal.class.getResource("/img/products.png")));
		btnProdutos.setBounds(344, 229, 128, 128);
		contentPane.add(btnProdutos);
		
		btnRelatorios = new JButton("");
		btnRelatorios.setDefaultCapable(false);
		btnRelatorios.setContentAreaFilled(false);
		btnRelatorios.setBorderPainted(false);
		btnRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorios relatorios = new Relatorios();
				relatorios.setVisible(true);
			}
		});
		btnRelatorios.setEnabled(false);
		btnRelatorios.setToolTipText("Relat\u00F3rios");
		btnRelatorios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRelatorios.setIcon(new ImageIcon(Principal.class.getResource("/img/report.png")));
		btnRelatorios.setBounds(146, 229, 128, 128);
		contentPane.add(btnRelatorios);
		
		JButton btnSobre = new JButton("");
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setDefaultCapable(false);
		btnSobre.setContentAreaFilled(false);
		btnSobre.setBorderPainted(false);
		btnSobre.setToolTipText("Sobre");
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setIcon(new ImageIcon(Principal.class.getResource("/img/informacoes (1).png")));
		btnSobre.setBounds(582, 11, 32, 32);
		contentPane.add(btnSobre);
		
		panelUsuario = new JPanel();
		panelUsuario.setBackground(SystemColor.textHighlight);
		panelUsuario.setBounds(0, 388, 624, 53);
		contentPane.add(panelUsuario);
		panelUsuario.setLayout(null);
		
		lblData = new JLabel("");
		lblData.setForeground(SystemColor.window);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblData.setBounds(259, 11, 355, 31);
		panelUsuario.add(lblData);
		
		lblUsuario = new JLabel("");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsuario.setBounds(83, 11, 203, 31);
		panelUsuario.add(lblUsuario);
		
		lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setForeground(Color.WHITE);
		lblUsurio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsurio.setBounds(10, 11, 76, 31);
		panelUsuario.add(lblUsurio);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/img/logocarrinho.png")));
		lblNewLabel.setBounds(146, 50, 326, 252);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(0, 0, 624, 390);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
