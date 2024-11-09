package controller;
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

Empilhar linha inteira ;
slplit para pesquisar e validar 

Nome [2] ,idade[3],overall[7]

*/
import java.io.IOException;

import br.edu.fateczl.Lista.Lista;
import br.edu.fateczl.pilha.Pilha;

public interface IFifaController {
	
	public Pilha<String> empilhaBrasileiros(String caminho,String nome)throws IOException;
	public void desempilhaBonsBrasileiros(Pilha<String> pilha)throws IOException;
	public Lista<String>listaRevelacoes(String caminho,String nome)throws IOException;
	public void buscaBonsJovens(Lista<String>lista)throws IOException;

}

