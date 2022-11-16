package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JTextField;

import model.DAO;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Clientes extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtFone;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtCep;
	private JTextField txtEndereco;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtBairro;
	private JTextField txtCidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes dialog = new Clientes();
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
	public Clientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Clientes.class.getResource("/img/favicon.png")));
		setTitle("Clientes");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 633, 451);
		getContentPane().setLayout(null);
		
		txtId = new JTextField();
		txtId.setBounds(76, 41, 97, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(75, 81, 140, 20);
		getContentPane().add(txtNome);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(30, 44, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(30, 84, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone");
		lblNewLabel_2.setBounds(227, 124, 59, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cpf");
		lblNewLabel_3.setBounds(238, 84, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setBounds(30, 124, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Marketing");
		lblNewLabel_5.setBounds(30, 184, 69, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("CEP");
		lblNewLabel_6.setBounds(30, 233, 46, 14);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Endere\u00E7o");
		lblNewLabel_7.setBounds(195, 233, 59, 14);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("N\u00FAmero");
		lblNewLabel_8.setBounds(30, 273, 46, 14);
		getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Complemento");
		lblNewLabel_9.setBounds(195, 273, 86, 14);
		getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Bairro");
		lblNewLabel_10.setBounds(360, 233, 46, 14);
		getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Cidade");
		lblNewLabel_11.setBounds(388, 273, 46, 14);
		getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("UF");
		lblNewLabel_12.setBounds(30, 321, 46, 14);
		getContentPane().add(lblNewLabel_12);
		
		txtFone = new JTextField();
		txtFone.setColumns(10);
		txtFone.setBounds(281, 121, 121, 20);
		getContentPane().add(txtFone);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(281, 81, 121, 20);
		getContentPane().add(txtCpf);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(75, 121, 140, 20);
		getContentPane().add(txtEmail);
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(76, 230, 109, 20);
		getContentPane().add(txtCep);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(264, 230, 86, 20);
		getContentPane().add(txtEndereco);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(396, 230, 121, 20);
		getContentPane().add(txtNumero);
		
		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(76, 273, 113, 20);
		getContentPane().add(txtComplemento);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(281, 270, 97, 20);
		getContentPane().add(txtBairro);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(444, 270, 86, 20);
		getContentPane().add(txtCidade);
		
		JButton btnAdicionar = new JButton("");
		btnAdicionar.setBorderPainted(false);
		btnAdicionar.setIcon(new ImageIcon(Clientes.class.getResource("/img/create.png")));
		btnAdicionar.setBounds(371, 346, 64, 64);
		getContentPane().add(btnAdicionar);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setBorderPainted(false);
		btnExcluir.setIcon(new ImageIcon(Clientes.class.getResource("/img/delete.png")));
		btnExcluir.setBounds(518, 346, 64, 64);
		getContentPane().add(btnExcluir);
		
		JButton btnAlterar = new JButton("");
		btnAlterar.setBorderPainted(false);
		btnAlterar.setIcon(new ImageIcon(Clientes.class.getResource("/img/update.png")));
		btnAlterar.setBounds(444, 346, 64, 64);
		getContentPane().add(btnAlterar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(69, 317, 69, 22);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "sim", "n\u00E3o"}));
		comboBox_1.setBounds(95, 180, 106, 22);
		getContentPane().add(comboBox_1);

	}// fim do construtor

	
	DAO dao = new DAO();
	
	private void adicionarClientes() {
		
	}
}// fim do codigo
