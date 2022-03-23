package desafios;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Desafio1 {
	
	public static String lerArquivo(File arquivo) throws FileNotFoundException{
		Scanner read = new Scanner(arquivo);
		read.useDelimiter("\\Z");
		
		String texto = new String(read.next());
		
		read.close();
		
		return texto;
	}
	
	public static boolean checarPreposicao(String palavra) {
		String[] foo = {"v", "k", "b", "p", "s"};
		boolean isPreposicao = false;
		boolean terminaComFoo;
		if(palavra.length()==5) {
			terminaComFoo = false;
			for (String letra : foo) {
				if(palavra.endsWith(letra)) {
					terminaComFoo = true;
				}
			}
			if(!terminaComFoo) {
				isPreposicao = true;
				for(int i = 0; i<5; i++) {
					if(palavra.charAt(i)=='w') {
						isPreposicao = false;
					}
				}
			}
		}
		return isPreposicao;
	}

	public static void main(String[] args) throws FileNotFoundException  {
		File arquivo = new File("./src/desafios/arquivos/TextoA.txt");
		
		String[] texto = lerArquivo(arquivo).split("\\s+");
		
		int preposicoes = 0;
		
		for (String palavra : texto) {
			if(checarPreposicao(palavra)) {
				preposicoes++;
			}
		}
		
		System.out.println(preposicoes);
	}
		
}
