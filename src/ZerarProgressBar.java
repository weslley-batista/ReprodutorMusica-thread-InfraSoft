import javax.swing.JProgressBar;

public class ZerarProgressBar extends Thread{
	JProgressBar depositProgressBar;
	int duracaoMusicaPlay;
	int duracaoMusicaPause;
	boolean trocaDeMusica;
	public ZerarProgressBar(JProgressBar depositProgressBar, int duracaoMusicaPause, int duracaoMusicaPlay, boolean trocaDeMusica){
		this.depositProgressBar=depositProgressBar;
		this.duracaoMusicaPlay=duracaoMusicaPlay;
		this.duracaoMusicaPause=duracaoMusicaPause;
		this.trocaDeMusica=trocaDeMusica;
	}
	public void run() {
		depositProgressBar.setValue(0);
		duracaoMusicaPause = 0;
		duracaoMusicaPlay = 0;
		trocaDeMusica = false;
	}
}
