import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JProgressBar;

public class RemoveMusic extends Thread {
	String nomeMusicaFieldText;
	ArrayList<String> listaDeReproducao;
	JLabel textAmount;
	DefaultListModel ListaAtualizada;
	boolean removeThread;
	JProgressBar depositProgressBar;
	JList listaReproducaoParaIF;

	public RemoveMusic(String nomeMusicaFieldText, ArrayList<String> listaDeReproducao, JLabel textAmount,
			DefaultListModel ListaAtualizada, boolean removeThread, JProgressBar depositProgressBar,
			JList listaReproducaoParaIF) {
		this.nomeMusicaFieldText = nomeMusicaFieldText;
		this.listaDeReproducao = listaDeReproducao;
		this.textAmount = textAmount;
		this.ListaAtualizada = ListaAtualizada;
		this.removeThread = removeThread;
		this.depositProgressBar = depositProgressBar;
		this.listaReproducaoParaIF = listaReproducaoParaIF;
	}

	public void run() {
		if (listaDeReproducao.isEmpty() || !listaDeReproducao.contains(nomeMusicaFieldText)) {
			textAmount.setText("| Musica não encontrada na lista |");
		} else {
			listaDeReproducao.remove(nomeMusicaFieldText);
			ListaAtualizada.removeElement(nomeMusicaFieldText);
			removeThread = true;
			textAmount.setText("| Musica Removida com sucesso |");

			if (listaReproducaoParaIF.getSelectedValue() == null) {
				depositProgressBar.setValue(0);
			}
		}
	}
}
