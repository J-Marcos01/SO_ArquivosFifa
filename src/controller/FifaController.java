package controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
/*
 * O método empilhaBrasileiros recebe o caminho e o nome do arquivo, deverá inicializar uma pilha, abrir o arquivo, 
ler o arquivo, verificar se na coluna referente à nacionalidade existe o valor “Brazil” e empilhar (push) a linha 
inteira, apenas de jogadores brasileiros. O método deve retornar essa pilha. 
O método desempilhaBonsBrasileiros deve receber uma pilha de Strings como parâmetro, percorrer a pilha, 
desempilhar (pop) e imprimir (somente nome e Overall) apenas de jogadores com Overall acima de 80. Perceba 
que, como estão ordenados, no arquivo, do melhor para o pior, os jogadores serão empilhados do melhor para o 
pior, portanto, o primeiro impresso deverá ser o pior dentre os escolhidos e o último deverá ser Neymar Jr, com 
Overall 92. 
O método listaRevelacoes recebe o caminho e o nome do arquivo, deverá inicializar uma lista encadeada, abrir o 
arquivo, ler o arquivo, verificar se na coluna referente à idade o valor é menor ou igual a 20, e adicionar ao final da 
lista, a linha inteira, apenas de jogadores jovens. O método deve retornar essa lista. 
O método buscaListaBonsJovens deve receber uma lista de Strings como parâmetro, percorrer a lista do último 
para o primeiro, imprimir (somente nome, idade e Overall) apenas de jogadores com Overall acima de 80 e 20 
anos ou menos.

Nome [2] ,idade[3],overall[7]
*/
import java.io.IOException;
import java.io.Writer;

import javax.swing.JOptionPane;

import br.edu.fateczl.Lista.Lista;
import br.edu.fateczl.pilha.Pilha;
/*O método empilhaBrasileiros recebe o caminho e o nome do arquivo, deverá inicializar uma pilha, abrir o arquivo, 
ler o arquivo, verificar se na coluna referente à nacionalidade existe o valor “Brazil” e empilhar (push) a linha 
inteira, apenas de jogadores brasileiros. O método deve retornar essa pilha. 
O método desempilhaBonsBrasileiros deve receber uma pilha de Strings como parâmetro, percorrer a pilha, 
desempilhar (pop) e imprimir (somente nome e Overall) apenas de jogadores com Overall acima de 80. Perceba 
que, como estão ordenados, no arquivo, do melhor para o pior, os jogadores serão empilhados do melhor para o 
pior, portanto, o primeiro impresso deverá ser o pior dentre os escolhidos e o último deverá ser Neymar Jr, com 
Overall 92. 
O método listaRevelacoes recebe o caminho e o nome do arquivo, deverá inicializar uma lista encadeada, abrir o 
arquivo, ler o arquivo, verificar se na coluna referente à idade o valor é menor ou igual a 20, e adicionar ao final da 
lista, a linha inteira, apenas de jogadores jovens. O método deve retornar essa lista. 
O método buscaListaBonsJovens deve receber uma lista de Strings como parâmetro, percorrer a lista do último 
para o primeiro, imprimir (somente nome, idade e Overall) apenas de jogadores com Overall acima de 80 e 20 
anos ou menos.

Nome [2] ,idade[3],nacionalidade[5],overall[7]
*/

public class FifaController implements IFifaController {

	public FifaController() {
		super();
	}

	@Override
	public Pilha<String> empilhaBrasileiros(String caminho, String nome) throws IOException {
		
		Pilha<String>pilha=new Pilha<String>();
		
		caminho=validaCaminho(caminho);
		if(caminho.contains("Inválido")) {
			JOptionPane.showMessageDialog(null, caminho,"Erro",JOptionPane.ERROR_MESSAGE);
		}
		String arquivo=caminho+File.separator+nome;
		arquivo=validaArquivo(arquivo);
		if(nome.contains("Inválido")) {
			JOptionPane.showMessageDialog(null, nome,"Erro",JOptionPane.ERROR_MESSAGE);
		}
		System.out.println("Diretório e arquivo válido , empilhando Brasileiros ...");
		
		File path=new File(arquivo);
		
		BufferedReader br=new BufferedReader(new FileReader(path));
		
		br.readLine();
		
		String linha=br.readLine();
		
		while(linha!=null) {
			pilha=verificaLinha(linha,pilha);
			linha=br.readLine();
		}
		br.close();
		
		return pilha ;
	}
	
	@Override
	public void desempilhaBonsBrasileiros(Pilha<String> pilha) throws IOException {
		System.out.println("\n\n");
		System.out.println("Desempilhando bons Brasileiros: ");
		System.out.printf("%15s %-30s%n","", "Bons Brasileiros ");
		System.out.println("----------------------------------------------");
		System.out.printf("%-30s %-30s%n","Nome", "Overall");
		try {
			while(!pilha.isEmpty()) {
			String linha=pilha.pop();
			String[]vetlinha=linha.split(",");
			if(Double.parseDouble(vetlinha[7])>80) {
				System.out.printf("%-30s %-30s%n",vetlinha[2], vetlinha[7]);

			}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public Lista<String> listaRevelacoes(String caminho, String nome) throws IOException {

		Lista<String>lista=new Lista<String>();
		
		caminho=validaCaminho(caminho);
		if(caminho.contains("Inválido")) {
			JOptionPane.showMessageDialog(null, caminho,"Erro",JOptionPane.ERROR_MESSAGE);
		}
		String arquivo=caminho+File.separator+nome;
		arquivo=validaArquivo(arquivo);
		if(nome.contains("Inválido")) {
			JOptionPane.showMessageDialog(null, nome,"Erro",JOptionPane.ERROR_MESSAGE);
		}
		System.out.println("Diretório e arquivo válido , Listando Revelações ...");
		
		File path=new File(arquivo);
		
		BufferedReader br=new BufferedReader(new FileReader(path));
		
		br.readLine();
		
		String linha=br.readLine();
		
		while(linha!=null) {
			try {
				lista=validaRevelacoes(linha,lista);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			linha=br.readLine();
		}
		br.close();
		
		return lista ;
		
	}

	private Lista<String> validaRevelacoes(String linha, Lista<String> lista) throws Exception {

		String [] vetlinha=linha.split(",");
		
		if(Integer.parseInt(vetlinha[3])<=20) {
			if(lista.isEmpty()) {
				lista.addFirst(linha);
			}else {
		lista.addLast(linha);
		}
		return lista;
	}
		return lista;
	}

	@Override
	public void buscaBonsJovens(Lista<String> lista) throws IOException {
		System.out.println("\n\n");
		System.out.println("Listando bons Jovens:");
		System.out.printf("%18s %-30s%n","", "Bons Jovens: ");
		System.out.println("----------------------------------------------");
		System.out.printf("%-20s %-20s %-20s%n","Nome","Idade", "Overall");
		try {
			while(!lista.isEmpty()) {
			int tamanho=lista.size();	
			String linha=lista.get(tamanho-1);
			String[]vetlinha=linha.split(",");
			if(Double.parseDouble(vetlinha[7])>80) {
				System.out.printf("%-20s %-20s %-20s%n",vetlinha[2],vetlinha[3], vetlinha[7]);
			}
			lista.removeLast();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private Pilha<String> verificaLinha(String linha, Pilha<String> pilha) {
		
		String [] vetlinha=linha.split(",");
		
	if(vetlinha[5].equals("Brazil")) {
		pilha.push(linha);
		return pilha;
	}
		return pilha;
	}

	private String validaArquivo(String nome) {
		
		File arquivo=new File(nome);
		
		if(arquivo.exists()&&arquivo.isFile()) {
			return nome;
		}return"Arquivo Inválido";
		
	}

	private String validaCaminho(String caminho) {

		File dir=new File(caminho);
		
		if(dir.exists()&&dir.isDirectory()) {
			return caminho;
		}return"Diretório Inválido";

		
	}

	
	
}
