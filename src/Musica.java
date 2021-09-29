
public class Musica {
	public static String Music(String musica) {
		String[] musicas = musica.split(" ");
		int n = musicas.length - 1;
		String resposta = "";
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				resposta = musicas[i];
			} else {
				resposta = resposta + " " + musicas[i];
			}
		}
		return resposta;
	}
}
