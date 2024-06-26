package view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;
import java.awt.Toolkit;

public class Relatorios extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Relatorios dialog = new Relatorios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Relatorios() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Relatorios.class.getResource("/img/favicon.png")));
		setModal(true);
		setTitle("Relat\u00F3rios");
		setBounds(100, 100, 581, 235);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnRelClientes = new JButton("Clientes");
		btnRelClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioClientes();
			}
		});
		btnRelClientes.setBounds(10, 52, 191, 23);
		contentPanel.add(btnRelClientes);
		
		JButton btnrelFornecedores = new JButton("Fornecedores");
		btnrelFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioFornecedores();
			}
		});
		btnrelFornecedores.setBounds(354, 52, 201, 23);
		contentPanel.add(btnrelFornecedores);
		
		JButton btnRelReposicao = new JButton("Reposi\u00E7\u00E3o de estoque");
		btnRelReposicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioReposicao();
			}
		});
		btnRelReposicao.setBounds(354, 116, 201, 23);
		contentPanel.add(btnRelReposicao);
		
		JButton btnRelInventario = new JButton("Invent\u00E1rio");
		btnRelInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioInventario();
			}
		});
		btnRelInventario.setBounds(10, 116, 191, 23);
		contentPanel.add(btnRelInventario);
	}//fim do construtor
	
	//acesso ao banco de dados
	DAO dao = new DAO();
	
	//m�todo respons�vel pela impress�o do relat�rio de clientes
	private void relatorioClientes() {
		//criar objeto para construir a p�gina pdf
		Document document = new Document();
		//gerar o documento pdf
		try {
			//cria um documento pdf em branco de nome clientes.pdf
			PdfWriter.getInstance(document, new FileOutputStream("clientes.pdf"));
			document.open();
			//gerar o conte�do do documento
			Date data = new Date();			
	        DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Clientes cadastrados"));
			document.add(new Paragraph(" "));
			//... Demais conte�dos (imagem, tabela, gr�fico, etc)
			PdfPTable tabela = new PdfPTable(4);
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Fone"));
			PdfPCell col3 = new PdfPCell(new Paragraph("CPF"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Email"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			// Acessar o banco de dados
			String relClientes = "select nome,fone,cpf,email from clientes";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relClientes);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
				}				
				
			} catch (Exception e) {
				System.out.println(e);
			}
			//Adicionar a tabela ao documento pdf
			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);
		} finally { //executa o c�digo independente do resultado OK ou n�o
			document.close();
		}
		
		//abrir o documento que foi gerado no leitor padr�o de pdf do sistema (PC)
		try {
			Desktop.getDesktop().open(new File("clientes.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	private void relatorioFornecedores() {
		//criar objeto para construir a p�gina pdf
		Document document = new Document();
		//gerar o documento pdf
		try {
			//cria um documento pdf em branco de nome clientes.pdf
			PdfWriter.getInstance(document, new FileOutputStream("fornecedores.pdf"));
			document.open();
			//gerar o conte�do do documento
			Date data = new Date();			
	        DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
			document.add(new Paragraph(new Paragraph(formatador.format(data))));
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Fornecedores cadastrados"));
			document.add(new Paragraph(" "));
			//... Demais conte�dos (imagem, tabela, gr�fico, etc)
			PdfPTable tabela = new PdfPTable(4);
			PdfPCell col1 = new PdfPCell(new Paragraph("Id"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Fantasia"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Bairro"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Cidade"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			// Acessar o banco de dados
			String relFornecedores = "select idfor,fantasia,bairro,cidade from fornecedores";
			try {
				Connection con = dao.conectar();
				PreparedStatement pst = con.prepareStatement(relFornecedores);
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					tabela.addCell(rs.getString(1));
					tabela.addCell(rs.getString(2));
					tabela.addCell(rs.getString(3));
					tabela.addCell(rs.getString(4));
				}				
				
			} catch (Exception e) {
				System.out.println(e);
			}
			//Adicionar a tabela ao documento pdf
			document.add(tabela);
		} catch (Exception e) {
			System.out.println(e);
		} finally { //executa o c�digo independente do resultado OK ou n�o
			document.close();
		}
		
		//abrir o documento que foi gerado no leitor padr�o de pdf do sistema (PC)
		try {
			Desktop.getDesktop().open(new File("fornecedores.pdf"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	//m�todo respons�vel pela impress�o do relat�rio de clientes
		private void relatorioReposicao() {
			//criar objeto para construir a p�gina pdf
			Document document = new Document(PageSize.A4.rotate(), 30f, 30f, 20f, 0f);
			//gerar o documento pdf
			try {
				//cria um documento pdf em branco de nome clientes.pdf
				PdfWriter.getInstance(document, new FileOutputStream("reposi��o.pdf"));
				document.open();
				//gerar o conte�do do documento
				Date data = new Date();			
		        DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
				document.add(new Paragraph(new Paragraph(formatador.format(data))));
				document.add(new Paragraph(" "));
				document.add(new Paragraph("Reposi��o de estoque"));
				document.add(new Paragraph(" "));
				//... Demais conte�dos (imagem, tabela, gr�fico, etc)
				PdfPTable tabela = new PdfPTable(5);
				PdfPCell col1 = new PdfPCell(new Paragraph("C�digo"));
				PdfPCell col2 = new PdfPCell(new Paragraph("Produto"));
				PdfPCell col3 = new PdfPCell(new Paragraph("Validade"));
				PdfPCell col4 = new PdfPCell(new Paragraph("Estoque"));
				PdfPCell col5 = new PdfPCell(new Paragraph("Estoque m�nimo"));
				tabela.addCell(col1);
				tabela.addCell(col2);
				tabela.addCell(col3);
				tabela.addCell(col4);
				tabela.addCell(col5);
				// Acessar o banco de dados
				String relReposicao = "select codigo,produto,date_format(dataval,'%d/%m/%Y'), estoque, estoquemin from produtos where estoque < estoquemin";
				try {
					Connection con = dao.conectar();
					PreparedStatement pst = con.prepareStatement(relReposicao);
					ResultSet rs = pst.executeQuery();
					while (rs.next()) {
						tabela.addCell(rs.getString(1));
						tabela.addCell(rs.getString(2));
						tabela.addCell(rs.getString(3));
						tabela.addCell(rs.getString(4));
						tabela.addCell(rs.getString(5));
					}				
					
				} catch (Exception e) {
					System.out.println(e);
				}
				//Adicionar a tabela ao documento pdf
				document.add(tabela);
			} catch (Exception e) {
				System.out.println(e);
			} finally { //executa o c�digo independente do resultado OK ou n�o
				document.close();
			}
			
			//abrir o documento que foi gerado no leitor padr�o de pdf do sistema (PC)
			try {
				Desktop.getDesktop().open(new File("reposi��o.pdf"));
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		
		//m�todo respons�vel pela impress�o do relat�rio de clientes
				private void relatorioInventario() {
					//criar objeto para construir a p�gina pdf
					Document document = new Document(PageSize.A4.rotate(), 30f, 30f, 20f, 0f);
					//gerar o documento pdf
					try {
						//cria um documento pdf em branco de nome clientes.pdf
						PdfWriter.getInstance(document, new FileOutputStream("inventario.pdf"));
						document.open();
						//gerar o conte�do do documento
						Date data = new Date();			
				        DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
						document.add(new Paragraph(new Paragraph(formatador.format(data))));
						document.add(new Paragraph(" "));
						document.add(new Paragraph("Inventario"));
						document.add(new Paragraph(" "));
						//... Demais conte�dos (imagem, tabela, gr�fico, etc)
						PdfPTable tabela = new PdfPTable(4);
						PdfPCell col1 = new PdfPCell(new Paragraph("C�digo"));
						PdfPCell col2 = new PdfPCell(new Paragraph("Produto"));
						PdfPCell col3 = new PdfPCell(new Paragraph("Estoque"));
						PdfPCell col4 = new PdfPCell(new Paragraph("Estoquemin"));
				
						tabela.addCell(col1);
						tabela.addCell(col2);
						tabela.addCell(col3);
						tabela.addCell(col4);
						
						// Acessar o banco de dados
						String relInventario = "select codigo,produto,estoque,estoquemin from produtos where estoque < estoquemin";
						try {
							Connection con = dao.conectar();
							PreparedStatement pst = con.prepareStatement(relInventario);
							ResultSet rs = pst.executeQuery();
							while (rs.next()) {
								tabela.addCell(rs.getString(1));
								tabela.addCell(rs.getString(2));
								tabela.addCell(rs.getString(3));
								tabela.addCell(rs.getString(4));
							}				
							
						} catch (Exception e) {
							System.out.println(e);
						}
						//Adicionar a tabela ao documento pdf
						document.add(tabela);
					} catch (Exception e) {
						System.out.println(e);
					} finally { //executa o c�digo independente do resultado OK ou n�o
						document.close();
					}
					
					//abrir o documento que foi gerado no leitor padr�o de pdf do sistema (PC)
					try {
						Desktop.getDesktop().open(new File("inventario.pdf"));
					} catch (Exception e) {
						System.out.println(e);
					}
				}
		
		
	
}// fim do codigo
