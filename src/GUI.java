import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GUI implements ActionListener, ListSelectionListener {

	int totalAmount = 0;
	int handleOptionIndex;
	private JLabel pedidoMusicaTempo;
	int contador=-1;
	int contadorPrev=-1;
	int quantidadeMusicaArray=0;
	String aauuxx= "OFF";
	String handleDepositValue;
	String nomeMusicaFieldText;
	String musicaSendoReproduzida = "Nenhuma";
	
	// Inicializa os componentes do JavaSwing
	private JButton playButton;
	private JButton pauseButton;
	private JButton nextButton;
	private JButton prevButton;
	private JButton addButton;
	private JButton removeButton;
	private JButton randomButton;
	private JList listaReproducao;

	private JButton depositButton;
	private JTextField musicaUser;
	private JLabel textAmount;
	private JLabel stateRandom;
	private JLabel Div;
	// private JList depositValuesList;
	private JProgressBar depositProgressBar;
	private DefaultListModel ListaAtualizada = new DefaultListModel();// Lista com propriedade de atualizar quando
																		// adiciona a musica

	ArrayList<String> listaDeReproducaoSwing;
	ListIterator<String> listIterator;
	Iterator<String> iterator;

	public GUI(ArrayList<String> listaDeReproducao, ListIterator<String> listIterator) {
		this.listaDeReproducaoSwing = listaDeReproducao;
		this.listIterator = listIterator;
		iterator = listaDeReproducaoSwing.iterator();

		// entrada de testes brutos
		
		 /* ListaAtualizada.addElement("close Your eye 12");
		  ListaAtualizada.addElement("Cut my lip 20");
		  ListaAtualizada.addElement("Pedro l1 14");*/
		 
		listaReproducao = new JList<>(listaDeReproducaoSwing.toArray(new String[0]));
		listaReproducao.setModel(ListaAtualizada);
		listaReproducao.setSelectedIndex(0);
		listaReproducao.addListSelectionListener(this);

		JScrollPane scrollPanel = new JScrollPane(listaReproducao);// coloca a Jlist dentro do ScrollPanel

		depositButton = new JButton("Deposit");// Inicializa um componente botão com o texto "Deposit".
		depositButton.addActionListener(this);// Seta o listener de clique para nossa própria classe.
		depositButton.setActionCommand("deposit_act");// Seta uma ação a ser disparada quando o botão for clicado.

		playButton = new JButton("Play");
		playButton.addActionListener(this);
		playButton.setActionCommand("play_action");
		// playButton.setForeground(new Color(63, 0, 69));

		pauseButton = new JButton("Pause");
		pauseButton.addActionListener(this);
		pauseButton.setActionCommand("pause_action");

		nextButton = new JButton("Proxima");
		nextButton.addActionListener(this);
		nextButton.setActionCommand("next_action");

		prevButton = new JButton("Anterior");
		prevButton.addActionListener(this);
		prevButton.setActionCommand("prev_action");

		addButton = new JButton("Adicionar");
		addButton.addActionListener(this);
		addButton.setActionCommand("add_action");

		removeButton = new JButton("Remover");
		removeButton.addActionListener(this);
		removeButton.setActionCommand("remove_action");
		
		randomButton = new JButton("Random mode ");
		randomButton.addActionListener(this);
		randomButton.setActionCommand("random_action");

		musicaUser = new JTextField(30);
		musicaUser.addActionListener(this);
		musicaUser.setActionCommand("musicaUser_action");
		// musicaUser.setText("Informe o nome da musica que quer alterar");
		musicaUser.setSize(70, 30);

		// Inicializa um componente barra de progresso.
		depositProgressBar = new JProgressBar();
		depositProgressBar.setStringPainted(true);// Mostra a porcentagem na barra
		depositProgressBar.setValue(0);// Seta o valor inicial 0.
		depositProgressBar.setSize(100, 50);// Seta o tamanho da barra.
		depositProgressBar.setForeground(new Color(54, 0, 69));

		// Inicializa um componente de texto com o valor "Amount: R$ 0".
		textAmount = new JLabel("| Musica sendo reproduzida: " + musicaSendoReproduzida + " |");
		pedidoMusicaTempo = new JLabel("Informe o nome da musica da musica e um tempo:");
		stateRandom = new JLabel("|Modo aleatorio deslisgado|");
		
		Div = new JLabel();

		// Inicializacao de componente de panel.
		JPanel panelListaMusica = new JPanel();
		panelListaMusica.setBorder(BorderFactory.createEmptyBorder(30, 30, 0, 30));// Cria margens em todas as direções.
		panelListaMusica.setLayout(new GridLayout(0, 1));// Seta GridLayout em nosso panel. (Existe uma variedade de
															// layout que podem ser utilizados)
		panelListaMusica.add(scrollPanel);// itens da lista em scrollPanel

		JPanel panelNomeMusica/* (painel de botoes linha 1) */ = new JPanel();
		panelNomeMusica.setLayout(new GridLayout(0, 2));
		panelNomeMusica.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 100));
		panelNomeMusica.add(stateRandom);
		panelNomeMusica.add(pedidoMusicaTempo);
		panelNomeMusica.add(textAmount);
		panelNomeMusica.add(musicaUser);

		JPanel panelBotoesL1/* (painel de botoes linha 1) */ = new JPanel();
		panelBotoesL1.setLayout(new GridLayout(0, 5));
		panelBotoesL1.setBorder(BorderFactory.createEmptyBorder(00, 200, 10, 200));
		panelBotoesL1.add(removeButton);
		panelBotoesL1.add(playButton);
		panelBotoesL1.add(pauseButton);
		panelBotoesL1.add(addButton);
		panelBotoesL1.add(randomButton);

		JPanel panelBotoesL2 = new JPanel();
		panelBotoesL2.setLayout(new GridLayout(0, 3));
		panelBotoesL2.setBorder(BorderFactory.createEmptyBorder(10, 30, 30, 30));
		panelBotoesL2.add(prevButton);
		panelBotoesL2.add(depositProgressBar);
		panelBotoesL2.add(nextButton);

		// Inicializa a janela da GUI.
		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(4, 0)); // transcendi (nao tem, como o pai é um deus do swing (4:31))
		frame.add(panelListaMusica);
		frame.add(panelNomeMusica);
		frame.add(panelBotoesL1);
		frame.add(panelBotoesL2);
		frame.setTitle("Lond player");// Seta o titulo da janela.
		frame.setSize(1100, 700);// Seta o tamanho da janela.
		frame.setVisible(true);

	}
	int[] IndexMusicaRandom = new int[100];
	int duracaoMusicaPlay;
	int duracaoMusicaPause = 0;
	boolean pause = false;
	boolean trocaDeMusica = false;
	boolean musicaTocando = false;
	boolean entrarThreadADD = false;
	boolean NextPrevMusica = false;
	boolean removeThread = false;
	boolean randomMode = false;
	int Tempo;
	
	Tempo tempo = new Tempo();// classe de separacao de tempo (musica que o usuario da entrada)
	Musica musicaSeparada = new Musica();// classe de separacao de musica (musica que o usuario da entrada)
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if ("play_action".equals(command)) {
			new Thread() {
				public void run() {
					pause = false;
					musicaSendoReproduzida = handleDepositValue;
					textAmount.setText("| Musica sendo reproduzida: " + musicaSendoReproduzida + " |");
					musicaTocando = true; // flag para verfificar se tem alguma musica tocando

					if (listaReproducao.getSelectedValue() == null) {
						textAmount.setText("| Nenhuma musica selecionada |");
					} else {
						// É igual a duracaoMuscaPause pois, pause inicia com 0, caso seja pausa
						// continua daquele ponto
						for (duracaoMusicaPlay = duracaoMusicaPause; duracaoMusicaPlay <= 100; duracaoMusicaPause++, duracaoMusicaPlay++) {
							depositProgressBar.setValue(duracaoMusicaPlay);
							if (pause == true) {// pausar a musica
								break;
							}
							if (duracaoMusicaPause == 100) {// zerar ProgressBar quando bater 100%
								duracaoMusicaPause=0;
								//necessario para o primeiro ciclo da reprodução em sequencia
								duracaoMusicaPlay = 0;
								if(randomMode==true) {contador+=1;quantidadeMusicaArray= quantidadeMusicaArray+1;}
								ThreadNext threadNext = new ThreadNext(listaReproducao, textAmount, handleOptionIndex, ListaAtualizada,randomMode,IndexMusicaRandom,contador,quantidadeMusicaArray);
								threadNext.start();
								depositProgressBar.setValue(0);
							} else if ((removeThread == true && pause == true)) {// zera o progresso da musica quando ela é trocada

								depositProgressBar.setValue(0);
								duracaoMusicaPause = 0;
								duracaoMusicaPlay = 0;
								trocaDeMusica = false;
								break;
							}
							try {
								Thread.sleep(tempo.Tempo(nomeMusicaFieldText)); // Separa o tempo e musica recebido na
																				// entrada
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}
			}.start();
		} else if ("pause_action".equals(command)) {
			new Thread() {
				public void run() {
					pause = true;
					depositProgressBar.setValue(duracaoMusicaPause);// imprimi o valor no momento da pagina
				}
			}.start();

		} else if ("next_action".equals(command)) {//comando relacionados a proxima musica (sequencia, aleatorio, botao proximo)
			
			if(duracaoMusicaPlay==100) {//musica em sequencia
				duracaoMusicaPlay = 0;
				if(randomMode==true) {contador+=1;quantidadeMusicaArray= quantidadeMusicaArray+1;}
				ThreadNext threadNext = new ThreadNext(listaReproducao, textAmount, handleOptionIndex, ListaAtualizada,randomMode,IndexMusicaRandom,contador,quantidadeMusicaArray);
				threadNext.start();
				depositProgressBar.setValue(0);
			}else { //botao proximo
				ThreadNext threadNext = new ThreadNext(listaReproducao, textAmount, handleOptionIndex, ListaAtualizada,randomMode,IndexMusicaRandom,contador,quantidadeMusicaArray);
			threadNext.start();
			}
		
		} else if ("prev_action".equals(command)) {
			if(randomMode==true) {contadorPrev+=1;}
			ThreadPrev threadPrev = new ThreadPrev(listaReproducao, textAmount, handleOptionIndex,depositProgressBar,
					 duracaoMusicaPause, duracaoMusicaPlay, trocaDeMusica, ListaAtualizada,randomMode, IndexMusicaRandom,quantidadeMusicaArray,contadorPrev);
			threadPrev.start();
		} else if ("add_action".equals(command)) {
			nomeMusicaFieldText = musicaUser.getText();// entrada do usuario no textField
			AddMusic threadAdd = new AddMusic(Musica.Music(nomeMusicaFieldText), listaDeReproducaoSwing, textAmount,
					ListaAtualizada);// nova thread de adicionar
			threadAdd.start();
		} else if ("remove_action".equals(command)) {
			RemoveMusic threadRemove = new RemoveMusic(handleDepositValue, listaDeReproducaoSwing, textAmount,
					ListaAtualizada, removeThread, depositProgressBar, listaReproducao);// nova thread de remover
			threadRemove.start();
		}
		else if ("random_action".equals(command)) {
			new Thread() {
				public void run() {
					if(randomMode==false) {
						randomMode=true;
						stateRandom.setText("|Modo aleatorio ligado|");
					}else {
						randomMode=false;
						stateRandom.setText("|Modo aleatorio deslisgado|");
					}					
				}				
			}.start();
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		// verifica quando o NOME DA MUSICA que foi clicado e o INDEX DA MUSICA
		new Thread() {
			public void run() {
				String selectedOption = (String) listaReproducao.getSelectedValue();// nome da musica clicada na
																					// interface
				handleDepositValue = selectedOption; // nome da musica selecionada
				int selectedOptionIndex = listaReproducao.getSelectedIndex();
				handleOptionIndex = selectedOptionIndex;// index da musica selecionada

				if (musicaTocando == true && duracaoMusicaPause != 100) {// bandeiras para play
					trocaDeMusica = true;
					musicaTocando = false;
				}
			}
		}.start();

	}

}