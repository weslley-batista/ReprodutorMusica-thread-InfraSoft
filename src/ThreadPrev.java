import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JProgressBar;

public class ThreadPrev extends Thread {
	JList listaReproducao;
	JLabel textAmount;
	int handleOptionIndex;
	DefaultListModel ListaAtualizada;
	JProgressBar depositProgressBar;
	int duracaoMusicaPause;
	int duracaoMusicaPlay;
	boolean trocaDeMusica;
	boolean randomMode;
	int[] IndexMusicaRandom;
	int musicaIndexPrev;
	int quantidadeMusicaArray;
	int contadorPrev;
	public ThreadPrev(JList listaReproducao, JLabel textAmount, int handleOptionIndex, JProgressBar depositProgressBar,
			int duracaoMusicaPause, int duracaoMusicaPlay, boolean trocaDeMusica, DefaultListModel ListaAtualizada,boolean randomMode
			, int[] IndexMusicaRandom,int quantidadeMusicaArray,int contadorPrev) {
		this.listaReproducao=listaReproducao;
		this.textAmount=textAmount;
		this.handleOptionIndex=handleOptionIndex;
		this.ListaAtualizada=ListaAtualizada;
		this.depositProgressBar=depositProgressBar;
		this.duracaoMusicaPause=duracaoMusicaPause;
		this.duracaoMusicaPlay=duracaoMusicaPlay;
		this.trocaDeMusica=trocaDeMusica;
		this.randomMode=randomMode;
		this.IndexMusicaRandom=IndexMusicaRandom;
		this.quantidadeMusicaArray=quantidadeMusicaArray;
		this.contadorPrev=contadorPrev;
	}

	public void run() {
		if (listaReproducao.getSelectedValue() == null) {
			textAmount.setText("| Não existe musica anterior |");
		} else {
			if(randomMode==false) {
				int indexMusicaAnterior = (handleOptionIndex - 1);// index da musica clicada menos 1
			listaReproducao.setSelectedIndex(indexMusicaAnterior);
			ZerarProgressBar threadZerarBar = new ZerarProgressBar(depositProgressBar, duracaoMusicaPause,
					duracaoMusicaPlay, trocaDeMusica);
			threadZerarBar.start();
			textAmount.setText("| Musica anterior: " + (String) ListaAtualizada.get(indexMusicaAnterior) + " |");// imprime o nome da musica anterior
			}else {
				if(quantidadeMusicaArray>2) {
					musicaIndexPrev =  IndexMusicaRandom[(quantidadeMusicaArray-2)-contadorPrev];
				listaReproducao.setSelectedIndex(musicaIndexPrev);
				ZerarProgressBar threadZerarBar = new ZerarProgressBar(depositProgressBar, duracaoMusicaPause,
						duracaoMusicaPlay, trocaDeMusica);
				threadZerarBar.start();
				textAmount.setText("| Musica anterior: " + (String) ListaAtualizada.get(musicaIndexPrev) + " |");// imprime o nome da musica anterior
				}else {
					textAmount.setText("| Você está no inicio da lista da reprodução aleatória |");
				}
				
			}																											
		}
	}
}
