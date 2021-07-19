import java.util.*;
import java.io.*;

public class Comandos {

	public static void main(String[] args) throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> listaDeReproducao = new ArrayList<String>(); // Um array de musicas
		InterfaceTexto interfaceTexto = new InterfaceTexto(); // menu
		Musica askMusic = new Musica();

		boolean parar = false;
		while (!parar) {
			interfaceTexto.opcoesMenu();
			int acao = scan.nextInt();

			interfaceTexto.verificacaoOpcaoMenu(acao, askMusic); // Verifica se o usuario escolheu add ou Remove

			switch (acao) {
			case 1:
				AddMusic threadAdd = new AddMusic(askMusic.getMusica(), listaDeReproducao);
				threadAdd.start(); // programa sequencial com join
				break;
			case 2:
				RemoveMusic threadRemove = new RemoveMusic(askMusic.getMusica(), listaDeReproducao);
				threadRemove.start();
				break;
			}
		}
	}
}
