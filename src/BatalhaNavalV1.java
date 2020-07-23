
import java.util.Random;
import javax.swing.JOptionPane;

public class BatalhaNavalV1 {
	// baseado em: http://tixplicando.blogspot.com/2015/04/batalha-naval-utilizando-matrizes-em.html
	
	private char[][] tabuleiro; // declara uma variavel do tipo array
	private static final int LINHAS = 10;
	private static final int COLUNAS = 10;

	// metodo CONSTRUTOR
	public BatalhaNavalV1() {
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

	

	public static void main(String[] args) {

		BatalhaNavalV1 bn = new BatalhaNavalV1();
		System.out.println(bn.mostraCoordenadas());
		
		
	}
}