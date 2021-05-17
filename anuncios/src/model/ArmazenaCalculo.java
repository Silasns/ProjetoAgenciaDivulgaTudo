package model;

// TODO: Auto-generated Javadoc
/**
 * The Class ArmazenaCalculo.
 */
public class ArmazenaCalculo {

/** The nome anuncio. */
private String nomeAnuncio;

/** The cliente rlt. */
private String clienteRlt;

/** The quant max clique. */
private String quantMaxClique;

/** The quant max visualizacao. */
private String quantMaxVisualizacao;

/** The quant max compartilhamento. */
private String quantMaxCompartilhamento;

/** The valor total. */
private float valorTotal;

/**
 * Instantiates a new armazena calculo.
 */
public ArmazenaCalculo() {
	super();
}

/**
 * Instantiates a new armazena calculo.
 *
 * @param nomeAnuncio the nome anuncio
 * @param clienteRlt the cliente rlt
 * @param quantMaxClique the quant max clique
 * @param quantMaxVisualizacao the quant max visualizacao
 * @param quantMaxCompartilhamento the quant max compartilhamento
 * @param valorTotal the valor total
 */
public ArmazenaCalculo(String nomeAnuncio, String clienteRlt, String quantMaxClique, String quantMaxVisualizacao,
		String quantMaxCompartilhamento, float valorTotal) {
	super();
	this.nomeAnuncio = nomeAnuncio;
	this.clienteRlt = clienteRlt;
	this.quantMaxClique = quantMaxClique;
	this.quantMaxVisualizacao = quantMaxVisualizacao;
	this.quantMaxCompartilhamento = quantMaxCompartilhamento;
	this.valorTotal = valorTotal;
}

/**
 * Gets the nome anuncio.
 *
 * @return the nome anuncio
 */
public String getNomeAnuncio() {
	return nomeAnuncio;
}

/**
 * Sets the nome anuncio.
 *
 * @param nomeAnuncio the new nome anuncio
 */
public void setNomeAnuncio(String nomeAnuncio) {
	this.nomeAnuncio = nomeAnuncio;
}

/**
 * Gets the cliente rlt.
 *
 * @return the cliente rlt
 */
public String getClienteRlt() {
	return clienteRlt;
}

/**
 * Sets the cliente rlt.
 *
 * @param clienteRlt the new cliente rlt
 */
public void setClienteRlt(String clienteRlt) {
	this.clienteRlt = clienteRlt;
}

/**
 * Gets the quant max clique.
 *
 * @return the quant max clique
 */
public String getQuantMaxClique() {
	return quantMaxClique;
}

/**
 * Sets the quant max clique.
 *
 * @param quantMaxClique the new quant max clique
 */
public void setQuantMaxClique(String quantMaxClique) {
	this.quantMaxClique = quantMaxClique;
}

/**
 * Gets the quant max visualizacao.
 *
 * @return the quant max visualizacao
 */
public String getQuantMaxVisualizacao() {
	return quantMaxVisualizacao;
}

/**
 * Sets the quant max visualizacao.
 *
 * @param quantMaxVisualizacao the new quant max visualizacao
 */
public void setQuantMaxVisualizacao(String quantMaxVisualizacao) {
	this.quantMaxVisualizacao = quantMaxVisualizacao;
}

/**
 * Gets the quant max compartilhamento.
 *
 * @return the quant max compartilhamento
 */
public String getQuantMaxCompartilhamento() {
	return quantMaxCompartilhamento;
}

/**
 * Sets the quant max compartilhamento.
 *
 * @param quantMaxCompartilhamento the new quant max compartilhamento
 */
public void setQuantMaxCompartilhamento(String quantMaxCompartilhamento) {
	this.quantMaxCompartilhamento = quantMaxCompartilhamento;
}

/**
 * Gets the valor total.
 *
 * @return the valor total
 */
public float getValorTotal() {
	return valorTotal;
}

/**
 * Sets the valor total.
 *
 * @param valorTotal the new valor total
 */
public void setValorTotal(float valorTotal) {
	this.valorTotal = valorTotal;
} 



}

