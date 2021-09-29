import java.util.ArrayList;
import java.util.ListIterator;

public class Comandos {
	static ArrayList<String> listaDeReproducao = new ArrayList<String>();
	static ListIterator<String> listIterator;

	public static void main(String[] args) {
		new GUI(listaDeReproducao, listIterator);
	}

}
