package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Calcula.
 */
public class Calcula {
	
	/**
	 * Calcula investimento.
	 *
	 * @param investimento the investimento
	 */
	public static void calculaInvestimento(float investimento) {
		float valor=0;		
		int visualizacoes=0, cliques=0, compartilhamentos=0;
		
		  //Cálculo das visualizações(a cada R$1,00 temos=> 30 visualizações )
		  visualizacoes = (int) (valor*30);

		  //Cálculo dos cliques(a cada 100 visualizações temos=> 12 cliques)
		  cliques = (visualizacoes*12)/100;

		  //Cálculo dos compartilhamentos(a cada 20 cliques temos=> 3 compartilhamentos )
		  compartilhamentos = (cliques*3)/20;

		  // a cada compartilhamento temos no maximo 4 compartilhamento em sequência(como a projeção deseja ter o maximo de compartilhamentos utilizarei o modelo no qual teremos todos os 4 compartilhamentos)
		  compartilhamentos += compartilhamentos*3;

		  visualizacoes += compartilhamentos*40;
	}
	
}
