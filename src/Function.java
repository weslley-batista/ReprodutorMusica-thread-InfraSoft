import java.util.*;

public class Function {
	Scanner scan = new Scanner(System.in);
	Vector <String> lista = new Vector<String>(); int a=1;//parametro de sossego do codigo
	String mensagem;
	
	public String addmusic () {
		System.out.println("Digite o nome da musica que deseja adcionar");
		String musica = scan.nextLine();
		if(lista.contains(musica)) {
			mensagem = "A musica já está na lista";
		}
		else{
			lista.add(musica);
			mensagem ="Musica adcionada com sucesso";
		}
		return mensagem;
	}
	
	public String RemoveMusic () {
		System.out.println("Digite o nome da musica que deseja remover");
		String musica = scan.nextLine();
		if(lista.isEmpty() || lista.contains(musica)) {
			
			mensagem="Musica Não encontrada para remoção";
		}
		else{
			lista.remove(musica);
			mensagem ="Musica removida com sucesso";
		}
		return mensagem;
		
	}
}
