package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;
import net.proteanit.sql.DbUtils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Produtos extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtBarcode;
	private JTextField txtCodigo;
	private JTextField txtPesquisarFornecedor;
	private JTextField txtIdFor;
	private JTextField txtProduto;
	private JTextField txtFabricante;
	private JTextField txtEstoque;
	private JTextField txtEstoqueMin;
	private JTextField txtLocal;
	private JTextField txtCusto;
	private JTextField txtLucro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Produtos dialog = new Produtos();
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
	public Produtos() {
		setModal(true);
		setTitle("Produtos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Produtos.class.getResource("/img/favicon.png")));
		setBounds(100, 100, 800, 496);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Produtos.class.getResource("/img/barcode.png")));
		lblNewLabel.setBounds(10, 11, 64, 45);
		getContentPane().add(lblNewLabel);

		txtBarcode = new JTextField();
		txtBarcode.addKeyListener(new KeyAdapter() {
			@Override
			
			public void keyReleased(KeyEvent e) {
				
			}
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			@Override
			//evento usado no leitor de código de barras
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					pesquisarProdutoCodigoBarras();
				}
				
			}
		});
		txtBarcode.setBounds(84, 25, 227, 20);
		getContentPane().add(txtBarcode);
		txtBarcode.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo");
		lblNewLabel_1.setBounds(10, 79, 74, 14);
		getContentPane().add(lblNewLabel_1);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(84, 76, 111, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarProdutoCodigo();
			}
		});
		btnPesquisar.setBounds(211, 74, 128, 23);
		getContentPane().add(btnPesquisar);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Fornecedor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(349, 25, 394, 152);
		getContentPane().add(panel);
		panel.setLayout(null);

		txtPesquisarFornecedor = new JTextField();
		txtPesquisarFornecedor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//evento de digitalização
				pesquisarFornecedorTabela();
			}
		});
		txtPesquisarFornecedor.setBounds(20, 30, 144, 20);
		panel.add(txtPesquisarFornecedor);
		txtPesquisarFornecedor.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Produtos.class.getResource("/img/pesquisar.png")));
		lblNewLabel_2.setBounds(174, 22, 32, 32);
		panel.add(lblNewLabel_2);

		JLabel txtForId = new JLabel("ID");
		txtForId.setBounds(236, 33, 46, 14);
		panel.add(txtForId);

		txtIdFor = new JTextField();
		txtIdFor.setBounds(267, 30, 86, 20);
		panel.add(txtIdFor);
		txtIdFor.setColumns(10);

		scroolPane = new JScrollPane();
		scroolPane.setBounds(20, 63, 352, 78);
		panel.add(scroolPane);

		tblFornecedores = new JTable();
		scroolPane.setViewportView(tblFornecedores);

		JLabel lblNewLabel_4 = new JLabel("Produto");
		lblNewLabel_4.setBounds(10, 134, 74, 14);
		getContentPane().add(lblNewLabel_4);

		txtProduto = new JTextField();
		txtProduto.setBounds(84, 131, 227, 20);
		getContentPane().add(txtProduto);
		txtProduto.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_5.setBounds(10, 201, 74, 14);
		getContentPane().add(lblNewLabel_5);

		txtAreaDesc = new JTextArea();
		txtAreaDesc.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtAreaDesc.setBounds(84, 186, 227, 73);
		getContentPane().add(txtAreaDesc);

		JButton btnAdicionar = new JButton("");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarProduto();
			}
		});
		btnAdicionar.setIcon(new ImageIcon(Produtos.class.getResource("/img/boxadd.png")));
		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.setBorderPainted(false);
		btnAdicionar.setToolTipText("Adicionar");
		btnAdicionar.setBounds(488, 355, 64, 64);
		getContentPane().add(btnAdicionar);

		JButton btnAlterar = new JButton("");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarProduto();
			}
		});
		btnAlterar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlterar.setIcon(new ImageIcon(Produtos.class.getResource("/img/boxupdate.png")));
		btnAlterar.setToolTipText("Alterar");
		btnAlterar.setContentAreaFilled(false);
		btnAlterar.setBorderPainted(false);
		btnAlterar.setBounds(580, 355, 64, 64);
		getContentPane().add(btnAlterar);

		JButton btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirProduto();
			}
		});
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.setIcon(new ImageIcon(Produtos.class.getResource("/img/boxdel.png")));
		btnExcluir.setToolTipText("Excluir");
		btnExcluir.setContentAreaFilled(false);
		btnExcluir.setBorderPainted(false);
		btnExcluir.setBounds(669, 355, 64, 64);
		getContentPane().add(btnExcluir);

		JLabel lblNewLabel_6 = new JLabel("Fabricante");
		lblNewLabel_6.setBounds(10, 294, 91, 14);
		getContentPane().add(lblNewLabel_6);

		txtFabricante = new JTextField();
		txtFabricante.setBounds(84, 291, 227, 20);
		getContentPane().add(txtFabricante);
		txtFabricante.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Estoque");
		lblNewLabel_7.setBounds(10, 344, 74, 14);
		getContentPane().add(lblNewLabel_7);

		txtEstoque = new JTextField();
		txtEstoque.setBounds(84, 341, 46, 20);
		getContentPane().add(txtEstoque);
		txtEstoque.setColumns(10);

		JLabel lblNewLabel_7_1 = new JLabel("Estoque m\u00EDnimo");
		lblNewLabel_7_1.setBounds(140, 344, 115, 14);
		getContentPane().add(lblNewLabel_7_1);

		txtEstoqueMin = new JTextField();
		txtEstoqueMin.setColumns(10);
		txtEstoqueMin.setBounds(265, 341, 46, 20);
		getContentPane().add(txtEstoqueMin);

		JLabel lblNewLabel_8 = new JLabel("Unidade");
		lblNewLabel_8.setBounds(10, 405, 74, 14);
		getContentPane().add(lblNewLabel_8);

		cboUnidade = new JComboBox();
		cboUnidade.setModel(new DefaultComboBoxModel(new String[] { "", "UN", "CX", "P\u00C7", "KG", "PCT", "M" }));
		cboUnidade.setBounds(85, 399, 68, 22);
		getContentPane().add(cboUnidade);

		JLabel lblNewLabel_9 = new JLabel("Local");
		lblNewLabel_9.setBounds(163, 405, 74, 14);
		getContentPane().add(lblNewLabel_9);

		txtLocal = new JTextField();
		txtLocal.setBounds(223, 399, 161, 20);
		getContentPane().add(txtLocal);
		txtLocal.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Entrada");
		lblNewLabel_10.setBounds(329, 201, 84, 14);
		getContentPane().add(lblNewLabel_10);

		dataEntrada = new JDateChooser();
		dataEntrada.setBounds(386, 195, 143, 20);
		getContentPane().add(dataEntrada);

		JLabel lblNewLabel_11 = new JLabel("Validade");
		lblNewLabel_11.setBounds(560, 201, 84, 14);
		getContentPane().add(lblNewLabel_11);

		dataValidade = new JDateChooser();
		dataValidade.setBounds(631, 195, 143, 20);
		getContentPane().add(dataValidade);

		JLabel lblNewLabel_12 = new JLabel("Custo");
		lblNewLabel_12.setBounds(329, 260, 84, 14);
		getContentPane().add(lblNewLabel_12);

		txtCusto = new JTextField();
		txtCusto.setBounds(386, 257, 131, 20);
		getContentPane().add(txtCusto);
		txtCusto.setColumns(10);

		JLabel lblNewLabel_12_1 = new JLabel("Lucro(%)");
		lblNewLabel_12_1.setBounds(539, 260, 84, 14);
		getContentPane().add(lblNewLabel_12_1);

		txtLucro = new JTextField();
		txtLucro.setBounds(618, 257, 64, 20);
		getContentPane().add(txtLucro);
		txtLucro.setColumns(10);
		
		RestrictedTextField validarId = new RestrictedTextField(txtCodigo);
		validarId.setOnlyNums(true);
		validarId.setLimit(9);
		
		RestrictedTextField barcode = new RestrictedTextField(txtBarcode);
		barcode.setOnlyNums(true);
		barcode.setLimit(9);
		
		RestrictedTextField estoque = new RestrictedTextField(txtEstoque);
		estoque.setOnlyNums(true);
		
		RestrictedTextField estoquemin = new RestrictedTextField(txtEstoqueMin);
		estoquemin.setOnlyNums(true);
		

	}// fim do construtor

	// Criar objeto para acessar o banco
	DAO dao = new DAO();
	private JComboBox cboUnidade;
	private JTextArea txtAreaDesc;
	private JDateChooser dataEntrada;
	private JDateChooser dataValidade;
	private JScrollPane scroolPane;
	private JTable tblFornecedores;
	
	private void pesquisarFornecedorTabela() {
		String readT = "select idfor as ID,fantasia as fornecedor,fone,contato from fornecedores where fantasia like ?";
		try {
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(readT);
			pst.setString(1, txtPesquisarFornecedor.getText() + "%");
			ResultSet rs = pst.executeQuery();
			tblFornecedores.setModel(DbUtils.resultSetToTableModel(rs));
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}


	// pesquisar produto por código do produto
	private void pesquisarProdutoCodigo() {
		String read = "select * from produtos where codigo = ?";
		try {			
			Connection con = dao.conectar();
			PreparedStatement pst = con.prepareStatement(read);
			pst.setString(1, txtCodigo.getText());			
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				txtBarcode.setText(rs.getString(2));
				txtProduto.setText(rs.getString(3));
				txtAreaDesc.setText(rs.getString(4));
				txtFabricante.setText(rs.getString(5));
				// JCalendar - formatação para exibição
				String setarDataCad = rs.getString(6);
				//apoio a lógica
				//System.out.println(setarDataCad);
				Date dataVal = new SimpleDateFormat("yyyy-MM-dd").parse(setarDataCad);
				dataEntrada.setDate(dataVal);
				
				
				//...
			} else {
				JOptionPane.showMessageDialog(null, "Produto não cadastrado");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	// pesquisar produto por código de barras
		private void pesquisarProdutoCodigoBarras() {
			String read2 = "select * from produtos where barcode = ?";
			try {			
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(read2);
				pst.setString(1, txtBarcode.getText());			
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					txtCodigo.setText(rs.getString(1));
					txtProduto.setText(rs.getString(3));
					txtAreaDesc.setText(rs.getString(4));
					txtFabricante.setText(rs.getString(5));
					// JCalendar - formatação para exibição
					String setarDataCad = rs.getString(6);
					//apoio a lógica
					//System.out.println(setarDataCad);
					Date dataVal = new SimpleDateFormat("yyyy-MM-dd").parse(setarDataCad);
					dataEntrada.setDate(dataVal);
					
					//...
				} else {
					JOptionPane.showMessageDialog(null, "Produto não cadastrado");
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		private void adicionarProduto() {
			if (txtBarcode.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o barcode");
				txtBarcode.requestFocus();
			} else if (txtProduto.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o produto");
				txtProduto.requestFocus();
			} else if (txtAreaDesc.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha a descrição");
				txtAreaDesc.requestFocus();
			} else if (txtFabricante.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o fabricante");
				txtFabricante.requestFocus();
			} else if (dataEntrada.getDateFormatString().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha a data de entrada");
				dataEntrada.requestFocus();
			} else if (dataValidade.getDateFormatString().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha a validade");
				dataValidade.requestFocus();
			} else if (txtEstoque.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o estoque");
				txtEstoque.requestFocus();
			} else if (txtEstoqueMin.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha estoque min");
				txtEstoqueMin.requestFocus();
			} else if (cboUnidade.getSelectedItem().equals("")) {
				JOptionPane.showMessageDialog(null, "Selecione a unidade do produto");
				cboUnidade.requestFocus();
			} else if (txtLocal.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha a localização");
				txtLocal.requestFocus();
			} else if (txtCusto.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o custo");
				txtCusto.requestFocus();
			} else if (txtLucro.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o lucro");
				txtLucro.requestFocus();
			} else {
				String create = "insert into produtos(barcode,produto,descricao,fabricante,dataval,"
						+ "estoque,estoquemin,unidade,localizacao,custo,lucro,idfor) values(?,?,?,?,?,?,?,?,?,?,?,?)";
				try {
					Connection con = dao.conectar();
					PreparedStatement pst = con.prepareStatement(create);
					
					pst.setString(1, txtBarcode.getText());
					pst.setString(2, txtProduto.getText());
					pst.setString(3, txtAreaDesc.getText());
					pst.setString(4, txtFabricante.getText());
					pst.setString(5, dataValidade.getDateFormatString());
					pst.setString(6, txtEstoque.getText());
					pst.setString(7, txtEstoqueMin.getText());
					pst.setString(8, cboUnidade.getSelectedItem().toString());
					pst.setString(9, txtLocal.getText());
					pst.setString(10, txtCusto.getText());
					pst.setString(11, txtLucro.getText());
					pst.setString(12, txtCodigo.getText());
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
					con.close();
				} catch (SQLIntegrityConstraintViolationException ex) {
					JOptionPane.showMessageDialog(null, "Produto existente.");
					txtProduto.setText(null);
					txtProduto.requestFocus();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		
		private void alterarProduto() {
			if (txtBarcode.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o barcode");
				txtBarcode.requestFocus();
			} else if (txtProduto.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o produto");
				txtProduto.requestFocus();
			} else if (txtAreaDesc.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha a descrição");
				txtAreaDesc.requestFocus();
			} else if (txtFabricante.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o fabricante");
				txtFabricante.requestFocus();
			} else if (dataEntrada.getDateFormatString().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha a data de entrada");
				dataEntrada.requestFocus();
			} else if (dataValidade.getDateFormatString().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha a validade");
				dataValidade.requestFocus();
			} else if (txtEstoque.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o estoque");
				txtEstoque.requestFocus();
			} else if (txtEstoqueMin.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha estoque min");
				txtEstoqueMin.requestFocus();
			} else if (cboUnidade.getSelectedItem().equals("")) {
				JOptionPane.showMessageDialog(null, "Selecione a unidade do produto");
				cboUnidade.requestFocus();
			} else if (txtLocal.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha a localização");
				txtLocal.requestFocus();
			} else if (txtCusto.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o custo");
				txtCusto.requestFocus();
			} else if (txtLucro.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o lucro");
				txtLucro.requestFocus();
			} else {
				String update = "update produtos set barcode=?, descricao=?, fabricante=?";
				try {
					Connection con = dao.conectar();
					PreparedStatement pst = con.prepareStatement(update);
					
					pst.setString(1, txtBarcode.getText());
					pst.setString(2, txtProduto.getText());
					pst.setString(3, txtAreaDesc.getText());
					pst.setString(4, txtFabricante.getText());
					pst.setString(5, txtEstoque.getText());
					pst.setString(6, txtEstoqueMin.getText());
					pst.setString(7, cboUnidade.getSelectedItem().toString());
					pst.setString(8, txtLocal.getText());
					pst.setString(9, txtCusto.getText());
					pst.setString(10, txtLucro.getText());
					pst.setString(11,txtIdFor.getText());
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
					//limparCampos();
					con.close();
				} catch (SQLIntegrityConstraintViolationException ex) {
					JOptionPane.showMessageDialog(null, "Dados incompletos");
					txtProduto.setText(null);
					txtProduto.requestFocus();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		
		private void excluirProduto() {
			int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão do produto?");
			if (confirma == JOptionPane.YES_OPTION) {
				String delete = "delete from produtos where codigo=?";
				try {
					Connection con = dao.conectar();
					PreparedStatement pst = con.prepareStatement(delete);
					pst.setString(1, txtCodigo.getText());
					pst.executeUpdate();
					//limparCampos();
					JOptionPane.showMessageDialog(null, "Produto excluído com sucesso.");
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}

}// fim do codigo
