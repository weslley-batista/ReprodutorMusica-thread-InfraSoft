import java.util.ArrayList;

public class RemoveMusic extends Thread {
	
	ArrayList <String> lista = new ArrayList<String>();
	private String musica;
		
	public RemoveMusic(String musica) {
		this.musica = musica;
	}
		
	public void run() {
		
		if(lista.isEmpty() || !lista.contains(this.musica)) {
			
			System.out.println("Musica n�o encontrada para remo��o");;
		}
		else{
			lista.remove(this.musica);
			System.out.println("Musica removida com sucesso");
		}
	}
}
