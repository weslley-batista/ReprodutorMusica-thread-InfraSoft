
public class Tempo {

	public static int Tempo(String musica) {
		String[] musicas = musica.split(" ");
		return Integer.parseInt(musicas[musicas.length - 1]) * 100;
	}
}
