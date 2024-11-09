package view;

import java.io.IOException;

import br.edu.fateczl.Lista.Lista;
import br.edu.fateczl.pilha.Pilha;
import controller.FifaController;
import controller.IFifaController;

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
Nome [2] ,idade[3],overall[7]
*/

public class Principal {

	public static void main(String[] args) {

		IFifaController cont=new FifaController();
		
		String caminho="C:\\TEMP\\fifa19";
		String nome="data.csv";
		Pilha<String> pilhaBrasileiros=new Pilha<String>();
		Lista<String>listaBonsJov=new Lista<String>();
	
		
		try {
			pilhaBrasileiros=cont.empilhaBrasileiros(caminho, nome);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			listaBonsJov=cont.listaRevelacoes(caminho, nome);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			cont.desempilhaBonsBrasileiros(pilhaBrasileiros);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			cont.buscaBonsJovens(listaBonsJov);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
