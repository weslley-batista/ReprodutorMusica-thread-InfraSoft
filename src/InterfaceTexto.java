import java.util.Scanner;

public class InterfaceTexto {
	Scanner scan = new Scanner(System.in);

	public void opcoesMenu() {
		System.out.println("O que deseja fazer?");
		System.out.println("1 - Adicionar Musica");
		System.out.println("2 - Remover Musica");
	}

	public void verificacaoOpcaoMenu(int acao, Musica askMusic) {
		String musica;
		if (acao == 1 || acao == 2) {
			System.out.println("Digite o nome da musica");
			/* String lixo = scan.nextLine(); */ // ler o resto da linha do nome da musica
			musica = scan.nextLine();
			askMusic.setMusica(musica);
		}
	}
}
