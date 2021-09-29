import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;

public class ThreadNext extends Thread {
	JList listaReproducao;
	JLabel textAmount;
	int handleOptionIndex;
	DefaultListModel ListaAtualizada;
	boolean randomMode;
	int[] IndexMusicaRandom;
	int contador;
	int quantidadeMusicaArray;
	Random gerador = new Random();
	public ThreadNext(JList listaReproducao, JLabel textAmount,int handleOptionIndex,DefaultListModel ListaAtualizada, boolean randomMode, int[] IndexMusicaRandom
			,int contador,int quantidadeMusicaArray) {
		this.listaReproducao=listaReproducao;
		this.textAmount=textAmount;
		this.handleOptionIndex=handleOptionIndex;
		this.ListaAtualizada=ListaAtualizada;
		this.randomMode=randomMode;
		this.IndexMusicaRandom=IndexMusicaRandom;
		this.contador=contador;
		this.quantidadeMusicaArray=quantidadeMusicaArray;
	}
	public void run() {
		if (listaReproducao.getSelectedValue() == null){
			textAmount.setText("| Não existe proxima musica|");
		} else {
			if(randomMode==false) {//sequencial
				int indexMusicaNext = (handleOptionIndex + 1);// index da musica clicada mais 1
				listaReproducao.setSelectedIndex(indexMusicaNext);
				textAmount.setText("| Musica sendo reproduzida: " + (String) ListaAtualizada.get(indexMusicaNext) + " |");// imprime o nome da proxima musica
			}else {//aleatorio
				
				int numRandom= gerador.nextInt(ListaAtualizada.getSize());// gera um numero aleatorio do tamanho da lista
				while(numRandom==handleOptionIndex) {
						numRandom=gerador.nextInt(ListaAtualizada.getSize());
					}
				IndexMusicaRandom[contador]=numRandom;
				int indexMusicaNext= numRandom;
				listaReproducao.setSelectedIndex(indexMusicaNext);
				textAmount.setText("| Musica sendo reproduzida: " + (String) ListaAtualizada.get(indexMusicaNext) + " |");// imprime o nome da proxima musica
			}
			
		}
	}
}
