
import java.util.Random;
import javax.swing.JOptionPane;

public class BatalhaNavalV5 {
	// baseado em: http://tixplicando.blogspot.com/2015/04/batalha-naval-utilizando-matrizes-em.html
	
	private char[][] tabuleiro; // declara uma variavel do tipo array
	private static final int LINHAS = 3;
	private static final int COLUNAS = 3;

	// metodo CONSTRUTOR
	public BatalhaNavalV5() {
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
	
	public int pegaCoordenada(char lc) {
		String linCol = "Linha";
		boolean repetir = true;
		int valor = 0;
		int tamanho = LINHAS; // tabuleiro pode ser retangular

		if (lc == 'c') {
			linCol = "Coluna";
			tamanho = COLUNAS; // tabuleiro pode ser retangular
		}
		while (repetir) {
			try {
				valor = Integer.valueOf(JOptionPane.showInputDialog("Digite um valor para a " + linCol));
				if (valor >= 0 && valor < tamanho) {
					repetir = false;
				} else {
					JOptionPane.showMessageDialog(null, "Valor inválido");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Valor inválido");
			}

		}
		return valor;
	}

	public boolean validaTiro(int lin, int col) {
		if (tabuleiro[lin][col] == 'N') {// acertou navio
			tabuleiro[lin][col] = 'n'; // marca navio como afundado
			System.out.println ("Acertou!");
			return true;
		} else {
			tabuleiro[lin][col] = '.';
		}
		return false;
	}

	public boolean restamNavios() {
		for (int i = 0; i < LINHAS; i++) {
			for (int j = 0; j < COLUNAS; j++) {
				if (tabuleiro[i][j] == 'N') {// achou pelo menos 1 navio
					return true; // sim, restam navios
				}
			}
		}
		return false; // nao ha mais navios
	}
	public static void main(String[] args) {

		BatalhaNavalV5 bn = new BatalhaNavalV5();
		System.out.println(bn.mostraCoordenadas());
		bn.montaMar();
		bn.posicionaNavios(3);
		System.out.println(bn);

		//System.out.println(bn.pegaCoordenada('l'));

		//System.out.println(bn.pegaCoordenada('c'));
		bn.validaTiro(1, 1);
		System.out.println(bn);
		bn.validaTiro(0, 2);
		System.out.println(bn);
		bn.validaTiro(1, 2);
		System.out.println(bn);
		
		
	}
}