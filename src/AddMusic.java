import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JProgressBar;

public class AddMusic extends Thread {
	String nomeMusicaFieldText;
	ArrayList<String> listaDeReproducao;
	JLabel textAmount;
	JList listaReproducao;
	DefaultListModel ListaAtualizada;

	public AddMusic(String nomeMusicaFieldText, ArrayList<String> listaDeReproducao, JLabel textAmount,
			DefaultListModel ListaAtualizada) {
		this.nomeMusicaFieldText = nomeMusicaFieldText;
		this.listaDeReproducao = listaDeReproducao;
		this.textAmount = textAmount;
		this.ListaAtualizada = ListaAtualizada;

	}

	public void run() {

		if (listaDeReproducao.contains(nomeMusicaFieldText)) {
			textAmount.setText("| A Musica já Adicionada |");
		} else {
			listaDeReproducao.add(nomeMusicaFieldText);
			ListaAtualizada.addElement(nomeMusicaFieldText);
			textAmount.setText("| Musica Adicionada com sucesso|");

		}
	}
}
