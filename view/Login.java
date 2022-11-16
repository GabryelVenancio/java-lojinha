package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				status();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/favicon.png")));
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("10.26.49.131");
		lblNewLabel_8.setBounds(67, 326, 109, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_5 = new JLabel("I.P:");
		lblNewLabel_5.setBounds(23, 326, 75, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("Terminal:");
		lblNewLabel_4.setBounds(23, 297, 82, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_9 = new JLabel("Village Market");
		lblNewLabel_9.setBounds(65, 265, 210, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_3 = new JLabel("Loja:");
		lblNewLabel_3.setBounds(23, 265, 82, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Status");
		lblNewLabel_2.setBounds(430, 254, 75, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(389, 63, 92, 14);
		contentPane.add(lblNewLabel);

		txtLogin = new JTextField();
		txtLogin.setBounds(437, 60, 127, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(389, 121, 92, 14);
		contentPane.add(lblNewLabel_1);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(437, 118, 127, 20);
		contentPane.add(txtSenha);

		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Login.class.getResource("/img/dboff.png")));
		lblStatus.setBounds(430, 276, 64, 64);
		contentPane.add(lblStatus);

		JButton btnLogar = new JButton("Acessar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}
		});
		btnLogar.setBounds(427, 191, 108, 23);
		contentPane.add(btnLogar);

		// validação Atxy2k
		RestrictedTextField login = new RestrictedTextField(txtLogin);
		login.setLimit(10);

		RestrictedTextField senha = new RestrictedTextField(txtSenha);
		senha.setLimit(255);
		
		// Usar o Enter ao invés de "clicar" no botão para logar
		getRootPane().setDefaultButton(btnLogar);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBackground(SystemColor.inactiveCaption);
		textField.setBounds(375, 242, 204, 124);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBackground(SystemColor.inactiveCaption);
		textField_1.setBounds(375, 174, 204, 56);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBackground(SystemColor.inactiveCaption);
		textField_2.setBounds(10, 242, 354, 126);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBackground(SystemColor.inactiveCaption);
		textField_3.setBounds(375, 15, 204, 148);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Login.class.getResource("/img/logocarrinho.png")));
		lblNewLabel_6.setBounds(10, 31, 355, 199);
		contentPane.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setBounds(0, 0, 603, 388);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
	}// fim do construtor

	// Criação de um objeto para acessar a camada model
	DAO dao = new DAO();
	private JLabel lblStatus;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Método usado para verificar o status do servidor
	 */
	private void status() {
		try {
			// abrir a conexão
			Connection con = dao.conectar();
			if (con == null) {
				// escolher a imagem dboff
				lblStatus.setIcon(new ImageIcon(Login.class.getResource("/img/dboff.png")));
			} else {
				// escolher a imagem dbon
				lblStatus.setIcon(new ImageIcon(Login.class.getResource("/img/dbon.png")));
			}
			// Não esquecer de fechar a conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Método usado para autenticar um usuário
	 */
	private void logar() {
		// validação da senha (captura segura)
		String capturaSenha = new String(txtSenha.getPassword());
		// validação
		if (txtLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Informe o seu Login");
			txtLogin.requestFocus();
		} else if (txtSenha.getPassword().length == 0) {
			JOptionPane.showMessageDialog(null, "Digite a sua senha");
			txtSenha.requestFocus();
		} else {
			// lógica principal
			String read = "select * from usuarios where login=? and senha = md5(?)";
			try {
				// abrir a conexão
				Connection con = dao.conectar();
				// Preparar a execução da query
				PreparedStatement pst = con.prepareStatement(read);
				// Setar os argumentos (login e senha)
				// Substituir os ?(argumentos) pelo conteúdo das caixas de texto
				pst.setString(1, txtLogin.getText());
				pst.setString(2, capturaSenha);
				// Executar a query e de acordo com o resultado liberar os recursos da tela
				// principal
				ResultSet rs = pst.executeQuery();
				// Validação (autenticação de usuário)
				// rs.next() -> existência de login e senha correspondente
				if (rs.next()) {
					//Verificar o perfil do usuário
					String perfil = rs.getString(5);
					//System.out.println(perfil);
					Principal principal = new Principal();
					if (perfil.equals("admin")) {						
						//abrir a tela principal
						principal.setVisible(true);
						//habilitar recursos
						principal.btnRelatorios.setEnabled(true);
						principal.btnUsuarios.setEnabled(true);
						//personalizar
						principal.panelUsuario.setBackground(Color.RED);
						//setar o nome do usuário na tela principal
						principal.lblUsuario.setText(rs.getString(2));
					} else {
						//abrir a tela principal
						principal.setVisible(true);
						//setar o nome do usuário na tela principal
						principal.lblUsuario.setText(rs.getString(2));
					}
					//encerrar a conexão
					con.close();
					//fechar a tela de login
					this.dispose();
					
				} else {
					JOptionPane.showMessageDialog(null, "Login e/ou senha inválido(s)");
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}// fim do código
