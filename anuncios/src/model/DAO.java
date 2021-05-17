package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	// Modulo de Conex�o
	/** The drive. */
	// Pam�metros da cone��o
	private String drive = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/dbanuncio?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "card265!@";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	// M�todo de conex�o
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(drive);
			// "con" estabelece uma se��o com o banco de dados
			// DriverManager � classe que vai gerenciar o driver
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	// teste de conex�o
	/*
	 * public void testeConexao() { try { Connection con = conectar();
	 * System.out.println(con); con.close(); } catch (Exception e) {
	 * System.out.println(e); }
	 */

	/**
	 * Inserir anuncio.
	 *
	 * @param anuncio the anuncio
	 */
	/* Cria��o do CRUD */
	public void inserirAnuncio(JavaBeans anuncio) {
		String create = "insert into anuncio (nomeAnuncio,cliente,dataInicio,dataTermino,investimento) values (?,?,?,?,?)";
		try {
			// abrir conex�o com o banco de dados
			Connection con = conectar();
			// Preparar a query para execu��o no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os par�metros (?) pelo conte�do das vari�veis JavaBeans
			pst.setString(1, anuncio.getNomeAnuncio());
			pst.setString(2, anuncio.getCliente());
			pst.setString(3, anuncio.getDataInicio());
			pst.setString(4, anuncio.getDatatermino());
			pst.setString(5, anuncio.getInvestimento());
			// Executar a query
			pst.executeUpdate();
			// Encerrar a conex�o com o banco
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Listar anuncios.
	 *
	 * @return the array list
	 */
	/* CRUD READ */
	public ArrayList<JavaBeans> listarAnuncios() {
		// Criando objeto para acessar a classe javaBeans
		ArrayList<JavaBeans> anuncios = new ArrayList<>();
		String read = "select * from anuncio order by nomeAnuncio;";
		try {
			// abrir conex�o com o banco de dados
			Connection con = conectar();
			// Preparar a query para execu��o no banco de dados
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// O while ser� executado enquanto existir anuncios
			while (rs.next()) {
				// variaveis de auxilio para receber o dados do banco
				String idAnuncio = rs.getString(1);
				String nomeAnuncio = rs.getString(2);
				String cliente = rs.getString(3);
				String dataInicio = rs.getString(4);
				String dataTermino = rs.getString(5);
				String investimento = rs.getString(6);
				// Populando o ArrayList
				anuncios.add(new JavaBeans(idAnuncio, nomeAnuncio, cliente, dataInicio, dataTermino, investimento));
			}
			// Encerrar a conex�o com o banco
			con.close();
			return anuncios;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	
	/**
	 * Listar anuncios rlt.
	 *
	 * @param anuncio the anuncio
	 * @return the array list
	 */
	//CRUD Relatorio personalizado
	public ArrayList<JavaBeans> listarAnunciosRlt(JavaBeans anuncio) {
		// Criando objeto para acessar a classe javaBeans
		ArrayList<JavaBeans> RltAnuncio = new ArrayList<>();
		// String read2 = "SELECT * FROM anuncio WHERE dataInicio >= ? AND dataTermino = ? AND cliente LIKE %?";
        String read2 = "Select * from anuncio" + "where dataInicio >=?" + " and dataTermino =?" + " and cliente =?";
		try {	
		// abrir conex�o com o banco de dados
			Connection con = conectar();
			// Preparar a query para execu��o no banco de dados
			PreparedStatement pst = con.prepareStatement(read2);
			ResultSet rs = pst.executeQuery();
			// Substituir os par�metros (?) pelo conte�do das vari�veis JavaBeans			
			pst.setString(1, anuncio.getDataInicio());
			pst.setString(2, anuncio.getDatatermino());
			pst.setString(3, anuncio.getCliente());			
			// O while ser� executado enquanto existir anuncios
			while (rs.next()) {
				// variaveis de auxilio para receber o dados do banco
				String idAnuncio = rs.getString(1);
				String nomeAnuncio = rs.getString(2);
				String cliente = rs.getString(3);
				String dataInicio = rs.getString(4);
				String dataTermino = rs.getString(5);
				String investimento = rs.getString(6);
				// Populando o ArrayList
				RltAnuncio.add(new JavaBeans(idAnuncio, nomeAnuncio, cliente, dataInicio, dataTermino, investimento));
			}
			// Encerrar a conex�o com o banco
			con.close();
			return RltAnuncio;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
		
}

