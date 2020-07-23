
import java.util.Random;
import javax.swing.JOptionPane;

public class BatalhaNavalV2 {
	// baseado em: http://tixplicando.blogspot.com/2015/04/batalha-naval-utilizando-matrizes-em.html
	
	private char[][] tabuleiro; // declara uma variavel do tipo array
	private static final int LINHAS = 10;
	private static final int COLUNAS = 10;

	// metodo CONSTRUTOR
	public BatalhaNavalV2() {
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

	public void montaMar() {
		for (int i = 0; i < LINHAS; i++) {
			for (int j = 0; j < COLUNAS; j++) {
				tabuleiro[i][j] = 'A';
			}
		}
	}
	

	public static void main(String[] args) {

		BatalhaNavalV2 bn = new BatalhaNavalV2();
		System.out.println(bn.mostraCoordenadas());
		bn.montaMar();
		System.out.println(bn);
		
		
	}
}