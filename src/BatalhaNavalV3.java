
import java.util.Random;
import javax.swing.JOptionPane;

public class BatalhaNavalV3 {
	// baseado em: http://tixplicando.blogspot.com/2015/04/batalha-naval-utilizando-matrizes-em.html
	
	private char[][] tabuleiro; // declara uma variavel do tipo array
	private static final int LINHAS = 10;
	private static final int COLUNAS = 10;

	// metodo CONSTRUTOR
	public BatalhaNavalV3() {
		tabuleiro = new char[LINHAS][COLUNAS]; // ALOCA memoria para o tabuleiro
	}

	public String mostraCoordenadas() {
		String mundo = "";
		for (int i = 0; i < LINHAS; i++) {
			mundo = mundo + "|";
			for (int j = 0; j < COLUNAS; j++) {
				mundo = mundo + "("+i+","+j+ ") ";
			}

			mundo = mundo + "|" + "\n";
		}
		return mundo;
	}
	
	public String toString() {
		String mundo = "";
		for (int i = 0; i < LINHAS; i++) {
			mundo = mundo + "|";
			for (int j = 0; j < COLUNAS; j++) {
				mundo = mundo + tabuleiro[i][j] + " ";
			}

			mundo = mundo + "|" + "\n";
		}
		return mundo;
	}
	
	
	public void sorteiaPosicao() {
		Random random = new Random();
		int lin, col;
		boolean repetir = true;
		while (repetir) {
			lin = random.nextInt(LINHAS);
			col = random.nextInt(COLUNAS);
			if (tabuleiro[lin][col] == 'A') {
				tabuleiro[lin][col] = 'N';
				repetir = false;
			} else {
				// aquela posição já está ocupada por um navio
			}
		} // while
	}
	
	public void posicionaNavios(int totalNavios) {
		for (int i = 0; i < totalNavios; i++) {
			sorteiaPosicao(); // posiciona 1 navio
		}
	}
	

	public void montaMar() {
		for (int i = 0; i < LINHAS; i++) {
			for (int j = 0; j < COLUNAS; j++) {
				tabuleiro[i][j] = 'A';
			}
		}
	}
	

	public static void main(String[] args) {

		BatalhaNavalV3 bn = new BatalhaNavalV3();
		System.out.println(bn.mostraCoordenadas());
		bn.montaMar();
		bn.posicionaNavios(3);
		System.out.println(bn);
		
		
	}
}