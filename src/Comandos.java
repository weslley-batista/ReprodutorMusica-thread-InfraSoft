import java.util.*;
import java.io.*;
//java.util.concurrent; biblioteca para thread
public class Comandos {
	// codico de leitura
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Function funcao = new Function(); // Classe de funções

		System.out.println("O que deseja fazer?");
		System.out.println("1 - Adicionar Musica");
		System.out.println("2 - Remover Musica");
		System.out.println("teste git");

		while (scan.hasNext()) { // Sempre ler entrada
			int acao = scan.nextInt();

			switch (acao) {
			case 1:
				AddMusic threadAdd = new AddMusic("asd");
				threadAdd.start();
				break;

			case 2:
				RemoveMusic threadRemove = new RemoveMusic("sels");
				threadRemove.start();
				break;
			}
		}

	}

}
