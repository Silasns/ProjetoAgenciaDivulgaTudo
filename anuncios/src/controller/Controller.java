package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;
import model.JavaBeans;
import model.ArmazenaCalculo;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/report" })
public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The dao. */
	DAO dao = new DAO();
	
	/** The anuncio. */
	JavaBeans anuncio = new JavaBeans();
	
	/** The calc. */
	ArmazenaCalculo calc = new ArmazenaCalculo();

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		super();

	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			anuncios(request, response);
		} else if (action.equals("/insert")) {
			novoAnuncio(request, response);
		} else if (action.equals("/report")) {
			gerarRelatorio(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	/**
	 * Anuncios.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Listar anuncios
	protected void anuncios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que receberá os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarAnuncios();
		/**
		 * Teste recebimento da lista for (int i = 0; i < lista.size(); i++) {
		 * System.out.println(lista.get(i).getIdAnuncio());
		 * System.out.println(lista.get(i).getNomeAnuncio());
		 * System.out.println(lista.get(i).getCliente());
		 * System.out.println(lista.get(i).getDataInicio());
		 * System.out.println(lista.get(i).getDatatermino());
		 * System.out.println(lista.get(i).getInvestimento()); }
		 **/
		// Encaminhar a lista ao documento anuncio.jsp
		request.setAttribute("anuncios", lista);
		RequestDispatcher rd = request.getRequestDispatcher("anuncio.jsp");
		rd.forward(request, response);
	}

	/**
	 * Novo anuncio.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Novo anuncios
	protected void novoAnuncio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * teste de recebimento dos dados do fomulário
		 * System.out.println(request.getParameter("nomeAnuncio"));
		 * System.out.println(request.getParameter("cliente"));
		 * System.out.println(request.getParameter("dataInicio"));
		 * System.out.println(request.getParameter("dataFim"));
		 * System.out.println(request.getParameter("investimento"));
		 */

		// Setar variaveis JavaBeans
		anuncio.setNomeAnuncio(request.getParameter("nomeAnuncio"));
		anuncio.setCliente(request.getParameter("cliente"));
		anuncio.setDataInicio(request.getParameter("dataInicio"));
		anuncio.setDatatermino(request.getParameter("dataFim"));
		anuncio.setInvestimento(request.getParameter("investimento"));
		// Invocar o método inserirAnuncio passando o objeto anuncio
		dao.inserirAnuncio(anuncio);
		// Redirecionar para o documento anuncio.jsp
		response.sendRedirect("main");
	}
	
	/**
	 * Gerar relatorio.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	//Gerar Relatório em PDF
	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			//Tipo de conteúdo
			response.setContentType("apllication/pdf");
			//Nome do documento
			response.addHeader("Content-Disposition", "inline; filename="+"anuncio.pdf");
			//Criar o documento
			PdfWriter.getInstance(documento,response.getOutputStream());
			//Abrir documento para gerar o conteúdo
			documento.open();
			documento.add(new Paragraph("Lista de Anúncios:"));
			documento.add(new Paragraph(" "));
			//Criar tabela
			PdfPTable tabela = new PdfPTable(5);
			//cabeçalho
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome do Anuncio"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Cliente"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Data de Início"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Data de Término"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Valor Investido"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);
			//Popular a tabela com os anuncios
			ArrayList<JavaBeans> lista = dao.listarAnuncios();
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getNomeAnuncio());
				tabela.addCell(lista.get(i).getCliente());
				tabela.addCell(lista.get(i).getDataInicio());
				tabela.addCell(lista.get(i).getDatatermino());
				tabela.addCell(lista.get(i).getInvestimento());
			}
					
			
			documento.add(tabela);
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
		
	}
	/*
	 * teste conexão dao.testeConexao();
	 */

}

