package desafios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Desafio2 {
	
	private static String lerArquivo(File arquivo) throws FileNotFoundException{
		Scanner read = new Scanner(arquivo);
		read.useDelimiter("\\Z");
		
		String texto = new String(read.next());
		
		read.close();
		
		return texto;
	}
	
	private static boolean checarVerbo(String palavra) {
		boolean tem6letras = false;
		boolean terminaComFoo = false;
		boolean isVerbo = false;
		String letrasFoo = "vkbps";
		
		tem6letras = palavra.length() >= 6;
		
		terminaComFoo = letrasFoo.contains(palavra.charAt(palavra.length()-1) + "");
		
		isVerbo = tem6letras && terminaComFoo;
		
		return isVerbo;
		
	}
	
	private static boolean checarPrimeiraPessoa(String palavra) {
		boolean comecaComFoo = false;
		String letrasFoo = "vkbps";
		
		comecaComFoo = letrasFoo.contains(palavra.charAt(0) + "");
		
		return comecaComFoo;
	}

	public static void main(String[] args) throws FileNotFoundException {
		File arquivo = new File("./src/desafios/arquivos/TextoA.txt");
		
		String[] texto = lerArquivo(arquivo).split("\\s+");

		int verbos = 0;
		
		int primeiraPessoa = 0;
		
		for (String palavra : texto) {
			if(checarVerbo(palavra)) {
				verbos++;
				if(checarPrimeiraPessoa(palavra)) {
					primeiraPessoa++;
				}
			}
		}
		
		System.out.println("Verbos: " + verbos);
		System.out.println("Verbos em primeira pessoa: " + primeiraPessoa);
	}

}
