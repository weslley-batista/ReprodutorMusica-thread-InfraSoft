import java.util.ArrayList;

public class RemoveMusic extends Thread {
	String musica;
	ArrayList <String> listaDeReproducao;
	
	public RemoveMusic(String musica,  ArrayList <String> listaDeReproducao) {
		this.musica = musica;
		this.listaDeReproducao = listaDeReproducao;
	}

	public void run() {
		if(listaDeReproducao.isEmpty() || !listaDeReproducao.contains(this.musica)) {
			System.out.println("Musica não encontrada para remoção");
		}
		else {
			listaDeReproducao.remove(this.musica);
			System.out.println("Musica removida com sucesso");
		}
	}
}
