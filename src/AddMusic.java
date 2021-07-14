import java.util.ArrayList;

public class AddMusic extends Thread {
	ArrayList <String> lista = new ArrayList<String>();
	private String musica;
	
	
	public AddMusic(String musica) {
		this.musica = musica;
	}
	
	
	public void run() {
		
		if(lista.contains(this.musica)) {
			System.out.println("A musica já está na lista");
		}
		else{
			lista.add(this.musica);
			System.out.println("Musica adcionada com sucesso");
		}
	}
}
