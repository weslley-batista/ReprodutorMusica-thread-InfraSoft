import java.util.*;
import java.io.*;

public class Comandos {

	public static void main(String[] args) throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		ArrayList <String> listaDeReproducao = new ArrayList<String>(); // Um array de musicas
		InterfaceTexto interfaceTexto = new InterfaceTexto();	//menu
		Musica askMusic = new Musica();
		
		boolean parar = false;
		while(!parar) {
			interfaceTexto.opcoesMenu();
			int acao = scan.nextInt();
			
			String musica;
			if(acao==1 || acao==2){
				System.out.println("Digite o nome da musica");
				String lixo = scan.nextLine();	//ler o resto da linha do nome da musica
				musica = scan.nextLine();
				askMusic.setMusica(musica);
			}
			
			switch (acao) {
				case 1:
					AddMusic threadAdd = new AddMusic(askMusic.getMusica(), listaDeReproducao);
					threadAdd.start();	//programa sequencia
					threadAdd.join();
					break;
				case 2:
					RemoveMusic threadRemove = new RemoveMusic (askMusic.getMusica(), listaDeReproducao);
					threadRemove.start();
					break;
			}
			
			for(String printMusic : listaDeReproducao) {//imprimir todas as musicas
				System.out.println(printMusic);
			}
		}
		
	}
}
