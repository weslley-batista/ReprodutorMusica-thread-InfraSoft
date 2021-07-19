import java.util.ArrayList;

public class AddMusic extends Thread {

	String musica;
	ArrayList<String> listaDeReproducao;

	public AddMusic(String musica, ArrayList<String> listaDeReproducao) {
		this.musica = musica;
		this.listaDeReproducao = listaDeReproducao;
	}

	public void run() {

		if (listaDeReproducao.contains(this.musica)) {
			System.out.println("A musica já está na lista");
		} else {
			listaDeReproducao.add(this.musica);
			System.out.println("Musica adcionada com sucesso");
		}
	}
}
