package view;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import model.DAO;
import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fornecedores extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtPesquisarFornecedor;
	private JTextField txtForId;
	private JTextField txtForCNPJ;
	private JTextField txtForIE;
	private JTextField txtForIM;
	private JTextField txtForRazao;
	private JTextField txtForFantasia;
	private JTextField txtForSite;
	private JTextField txtForFone;
	private JTextField txtForContato;
	private JTextField txtForEmail;
	private JTextField txtForCep;
	private JTextField txtForEndereco;
	private JTextField txtForNumero;
	private JTextField txtForComplemento;
	private JTextField txtForBairro;
	private JTextField txtForCidade;
	private JTable tblFornecedores;
	private JComboBox cboForUF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fornecedores dialog = new Fornecedores();
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
	public Fornecedores() {
		setTitle("Fornecedores");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Fornecedores.class.getResource("/img/favicon.png")));
		setModal(true);
		setBounds(100, 100, 731, 505);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fornecedor");
		lblNewLabel.setBounds(10, 18, 87, 14);
		getContentPane().add(lblNewLabel);
		
		txtPesquisarFornecedor = new JTextField();
		txtPesquisarFornecedor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//evento digitação
				pesquisarFornecedorTabela();
			}
		});
		txtPesquisarFornecedor.setBounds(97, 15, 181, 20);
		getContentPane().add(txtPesquisarFornecedor);
		txtPesquisarFornecedor.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setBounds(10, 139, 47, 14);
		getContentPane().add(lblNewLabel_2);
		
		txtForId = new JTextField();
		txtForId.setBounds(52, 136, 33, 20);
		getContentPane().add(txtForId);
		txtForId.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("CNPJ");
		lblNewLabel_3.setBounds(182, 139, 74, 14);
		getContentPane().add(lblNewLabel_3);
		
		txtForCNPJ = new JTextField();
		txtForCNPJ.setBounds(227, 136, 128, 20);
		getContentPane().add(txtForCNPJ);
		txtForCNPJ.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("IE");
		lblNewLabel_4.setBounds(365, 139, 53, 14);
		getContentPane().add(lblNewLabel_4);
		
		txtForIE = new JTextField();
		txtForIE.setBounds(409, 136, 112, 20);
		getContentPane().add(txtForIE);
		txtForIE.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("IM");
		lblNewLabel_4_1.setBounds(531, 139, 51, 14);
		getContentPane().add(lblNewLabel_4_1);
		
		txtForIM = new JTextField();
		txtForIM.setColumns(10);
		txtForIM.setBounds(572, 136, 112, 20);
		getContentPane().add(txtForIM);
		
		JLabel lblNewLabel_5 = new JLabel("Raz\u00E3o Social");
		lblNewLabel_5.setBounds(0, 182, 105, 14);
		getContentPane().add(lblNewLabel_5);
		
		txtForRazao = new JTextField();
		txtForRazao.setBounds(108, 179, 187, 20);
		getContentPane().add(txtForRazao);
		txtForRazao.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Nome de fantasia");
		lblNewLabel_6.setBounds(316, 182, 154, 14);
		getContentPane().add(lblNewLabel_6);
		
		txtForFantasia = new JTextField();
		txtForFantasia.setBounds(480, 179, 204, 20);
		getContentPane().add(txtForFantasia);
		txtForFantasia.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Site");
		lblNewLabel_7.setBounds(10, 223, 60, 14);
		getContentPane().add(lblNewLabel_7);
		
		txtForSite = new JTextField();
		txtForSite.setBounds(63, 220, 187, 20);
		getContentPane().add(txtForSite);
		txtForSite.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Fone");
		lblNewLabel_8.setBounds(260, 223, 67, 14);
		getContentPane().add(lblNewLabel_8);
		
		txtForFone = new JTextField();
		txtForFone.setBounds(311, 220, 107, 20);
		getContentPane().add(txtForFone);
		txtForFone.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Contato");
		lblNewLabel_9.setBounds(435, 223, 74, 14);
		getContentPane().add(lblNewLabel_9);
		
		txtForContato = new JTextField();
		txtForContato.setBounds(505, 220, 179, 20);
		getContentPane().add(txtForContato);
		txtForContato.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("E-mail");
		lblNewLabel_10.setBounds(10, 266, 75, 14);
		getContentPane().add(lblNewLabel_10);
		
		txtForEmail = new JTextField();
		txtForEmail.setBounds(71, 263, 179, 20);
		getContentPane().add(txtForEmail);
		txtForEmail.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("CEP");
		lblNewLabel_11.setBounds(260, 266, 67, 14);
		getContentPane().add(lblNewLabel_11);
		
		txtForCep = new JTextField();
		txtForCep.setBounds(316, 263, 81, 20);
		getContentPane().add(txtForCep);
		txtForCep.setColumns(10);
		
		JButton btnBuscarCep = new JButton("Buscar CEP");
		btnBuscarCep.setBounds(414, 260, 168, 23);
		getContentPane().add(btnBuscarCep);
		
		JLabel lblNewLabel_12 = new JLabel("Endere\u00E7o");
		lblNewLabel_12.setBounds(10, 306, 95, 14);
		getContentPane().add(lblNewLabel_12);
		
		txtForEndereco = new JTextField();
		txtForEndereco.setBounds(94, 303, 218, 20);
		getContentPane().add(txtForEndereco);
		txtForEndereco.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("N\u00FAmero");
		lblNewLabel_13.setBounds(322, 306, 75, 14);
		getContentPane().add(lblNewLabel_13);
		
		txtForNumero = new JTextField();
		txtForNumero.setBounds(379, 303, 87, 20);
		getContentPane().add(txtForNumero);
		txtForNumero.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Complemento");
		lblNewLabel_14.setBounds(480, 306, 116, 14);
		getContentPane().add(lblNewLabel_14);
		
		txtForComplemento = new JTextField();
		txtForComplemento.setBounds(585, 303, 99, 20);
		getContentPane().add(txtForComplemento);
		txtForComplemento.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("Bairro");
		lblNewLabel_15.setBounds(10, 350, 75, 14);
		getContentPane().add(lblNewLabel_15);
		
		txtForBairro = new JTextField();
		txtForBairro.setBounds(71, 347, 200, 20);
		getContentPane().add(txtForBairro);
		txtForBairro.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("Cidade");
		lblNewLabel_16.setBounds(281, 350, 74, 14);
		getContentPane().add(lblNewLabel_16);
		
		txtForCidade = new JTextField();
		txtForCidade.setBounds(349, 347, 200, 20);
		getContentPane().add(txtForCidade);
		txtForCidade.setColumns(10);
		
		JLabel lblNewLabel_17 = new JLabel("UF");
		lblNewLabel_17.setBounds(559, 350, 65, 14);
		getContentPane().add(lblNewLabel_17);
		
		cboForUF = new JComboBox();
		cboForUF.setModel(new DefaultComboBoxModel(new String[] {"", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cboForUF.setBounds(603, 346, 81, 22);
		getContentPane().add(cboForUF);
		
		JLabel lblNewLabel_18 = new JLabel("Observa\u00E7\u00E3o");
		lblNewLabel_18.setBounds(10, 409, 108, 14);
		getContentPane().add(lblNewLabel_18);
		
		JTextArea txtForObs = new JTextArea();
		txtForObs.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		txtForObs.setBounds(128, 394, 313, 41);
		getContentPane().add(txtForObs);
		
		btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarFornecedor();
			}
		});
		btnAdicionar.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/create.png")));
		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setBorderPainted(false);
		btnAdicionar.setToolTipText("Adicionar");
		btnAdicionar.setBounds(495, 391, 64, 64);
		getContentPane().add(btnAdicionar);
		
		btnAlterar = new JButton("");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarFornecedor();
			}
		});
		btnAlterar.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/update.png")));
		btnAlterar.setToolTipText("Alterar");
		btnAlterar.setContentAreaFilled(false);
		btnAlterar.setBorderPainted(false);
		btnAlterar.setBounds(560, 391, 64, 64);
		getContentPane().add(btnAlterar);
		
		btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirFornecedor();
			}
		});
		btnExcluir.setIcon(new ImageIcon(Fornecedores.class.getResource("/img/delete.png")));
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.setToolTipText("Excluir");
		btnExcluir.setContentAreaFilled(false);
		btnExcluir.setBorderPainted(false);
		btnExcluir.setBounds(623, 391, 64, 64);
		getContentPane().add(btnExcluir);
		
		JButton btnPesquisar = new JButton("Buscar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencherCampos();
			}
		});
		btnPesquisar.setBounds(91, 134, 81, 23);
		getContentPane().add(btnPesquisar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 46, 660, 70);
		getContentPane().add(scrollPane);
		
		tblFornecedores = new JTable();
		tblFornecedores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//evento clicar com o mouse na tabela
				setarCaixasTexto();
			}
		});
		scrollPane.setViewportView(tblFornecedores);

	}// fim do construtor
	
	// Criar objeto para acessar o banco
	DAO dao = new DAO();
	private JButton btnExcluir;
	private JButton btnAlterar;
	private JButton btnAdicionar;
	
	/**
	 * Método responsável pela pesquisa avançada do fornecedor
	 * usando o nome de fantasia e a biblioteca rs2xml
	 */
	private void pesquisarFornecedorTabela() {
		String readT = "select idfor as ID,fantasia as fornecedor,fone,contato from fornecedores where fantasia like ?";
		try {
			// Estabelecer a conexão
			Connection con = dao.conectar();
			// Preparar a execução da query
			PreparedStatement pst = con.prepareStatement(readT);
			// Setar o argumento (fantasia)
			// Substituir o ? pelo conteúdo da caixa de texto
			pst.setString(1, txtPesquisarFornecedor.getText() + "%");
			ResultSet rs = pst.executeQuery();
			//uso da biblioteca rs2xml para "popular" a tabela
			tblFornecedores.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	/**
	 * Método responsável por setar as caixas de texto
	 * de acordo com os campos da tabela (mouse click)
	 */
	private void setarCaixasTexto() {
		//criar uma variável para receber a linha da tabela
		int setar = tblFornecedores.getSelectedRow();
		txtForId.setText(tblFornecedores.getModel().getValueAt(setar, 0).toString());
		//txtForFantasia.setText(tblFornecedores.getModel().getValueAt(setar, 1).toString());
	}
	
	// demais métodos do CRUD
	

	
	/**
	 * Limpar campos
	 */
	private void limparCamposFornecedor() {
		//limpar a tabela
		((DefaultTableModel) tblFornecedores.getModel()).setRowCount(0);
	}
	
	private void adicionarFornecedor() {
		if (txtForCNPJ.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o CNPJ");
			txtForCNPJ.requestFocus();
		} else if (txtForRazao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Razão Social");
			txtForRazao.requestFocus();
		} else if (txtForFantasia.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o nome fantasia");
			txtForFantasia.requestFocus();
		} else if (txtForFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o seu telefone");
			txtForFone.requestFocus();
		} else if (txtForCep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o CEP");
			txtForCep.requestFocus();
		} else if (txtForEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Endereço");
			txtForEndereco.requestFocus();
		} else if (txtForNumero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o número");
			txtForNumero.requestFocus();
		} else if (txtForBairro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o bairro");
			txtForBairro.requestFocus();
		} else if (txtForCidade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a cidade");
			txtForCidade.requestFocus();
		} else if (cboForUF.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione o UF");
			cboForUF.requestFocus();
		} else {
			String create = "insert into fornecedores(cnpj,razao,fantasia,fone,cep,endereco,numero,bairro,cidade,uf)"
					+ "values(?,?,?,?,?,?,?,?,?,?)";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(create);
				pst.setString(1, txtForCNPJ.getText());
				pst.setString(2, txtForRazao.getText());
				pst.setString(3, txtForFantasia.getText());
				pst.setString(4, txtForFone.getText());
				pst.setString(5, txtForCep.getText());
				pst.setString(6, txtForEndereco.getText());
				pst.setString(7, txtForNumero.getText());
				pst.setString(8, txtForBairro.getText());
				pst.setString(9, txtForCidade.getText());
				pst.setString(10, cboForUF.getSelectedItem().toString());
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso");
				limparCampos();
				con.close();
			} catch (SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "Fornecedor existente.");
				txtForCNPJ.setText(null);
				txtForCNPJ.requestFocus();
				
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	private void alterarFornecedor() {
		if (txtForCNPJ.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o CNPJ");
			txtForCNPJ.requestFocus();
		} else if (txtForRazao.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Razão Social");
			txtForRazao.requestFocus();
		} else if (txtForFantasia.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o nome fantasia");
			txtForFantasia.requestFocus();
		} else if (txtForFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o seu telefone");
			txtForFone.requestFocus();
		} else if (txtForCep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o CEP");
			txtForCep.requestFocus();
		} else if (txtForEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Endereço");
			txtForEndereco.requestFocus();
		} else if (txtForNumero.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o número");
			txtForNumero.requestFocus();
		} else if (txtForBairro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o bairro");
			txtForBairro.requestFocus();
		} else if (txtForCidade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a cidade");
			txtForCidade.requestFocus();
		} else if (cboForUF.getSelectedItem().equals("")) {
			JOptionPane.showMessageDialog(null, "Selecione o UF");
			cboForUF.requestFocus();
		} else {
			String update = "update fornecedores set cnpj=?, razao=?, fantasia=?, fone=?, cep=?,"
					+ "endereco=?, numero=?, bairro=?, cidade=?, uf=? where idfor=?";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(update);
				pst.setString(1, txtForCNPJ.getText());
				pst.setString(2, txtForRazao.getText());
				pst.setString(3, txtForFantasia.getText());
				pst.setString(4, txtForFone.getText());
				pst.setString(5, txtForCep.getText());
				pst.setString(6, txtForEndereco.getText());
				pst.setString(7, txtForNumero.getText());
				pst.setString(8, txtForBairro.getText());
				pst.setString(9, txtForCidade.getText());
				pst.setString(10, cboForUF.getSelectedItem().toString());
				pst.setString(11, txtForId.getText());
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Dados do fornecedor alterado");
				limparCampos();
				txtForCNPJ.setText(null);
				txtForCNPJ.requestFocus();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	private void excluirFornecedor() {
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do fornecedor?", "Atenção!",
			JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String delete = "delete from fornecedores where idfor=?";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, txtForId.getText());
				pst.executeUpdate();
				limparCampos();
				JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso");
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}	
	}
	
	private void preencherCampos() {
		String read = "select * from fornecedores where idfor = ?";
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setString(1, txtForId.getText());
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtForCNPJ.setText(rs.getString(2));
				txtForRazao.setText(rs.getString(5));
				txtForFantasia.setText(rs.getString(6));
				txtForFone.setText(rs.getString(8));
				txtForCep.setText(rs.getString(11));
				txtForEndereco.setText(rs.getString(12));
				txtForNumero.setText(rs.getString(13));
				txtForBairro.setText(rs.getString(15));
				txtForCidade.setText(rs.getString(16));
				cboForUF.setSelectedItem(rs.getString(17));
			}
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void limparCampos() {
		txtForCNPJ.setText(null);
		txtForBairro.setText(null);
		txtForCep.setText(null);
		txtForCidade.setText(null);
		txtForComplemento.setText(null);
		txtForContato.setText(null);
		txtForEmail.setText(null);
		txtForEndereco.setText(null);
		txtForFantasia.setText(null);
		txtForFone.setText(null);
		txtForId.setText(null);
		txtForIE.setText(null);
		txtForIM.setText(null);
		txtForNumero.setText(null);
		txtForRazao.setText(null);
		txtForSite.setText(null);
		btnAdicionar.setEnabled(false);
		btnAlterar.setEnabled(false);
		btnExcluir.setEnabled(false);
	}
}// fim do codigo 
