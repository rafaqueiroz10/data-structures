#include <stdio.h>
#include <stdlib.h>

#define NENHUM_ITEM_ENCONTRADO -1
#define LISTA_VAZIA -1
#define TRUE 1
#define FALSE 0
#define POSICAO_INVALIDA -1

typedef int Item;

typedef struct {
    Item* itens;
    int quantidade, capacidade;
} ArrayList;

// função para criar o arraylist
ArrayList* criarArrayList(int capacidade) {
    ArrayList* lista = (ArrayList*) malloc(sizeof(ArrayList));
    
    if(lista == NULL)
        return NULL;
    
    lista->quantidade = 0;
    lista->capacidade = capacidade;
    lista->itens = (Item*) malloc(lista->capacidade * sizeof(Item));
    
    if(lista->itens == NULL)
        return NULL;

    return lista;
}

// retorna o tamanho da lista
int tamanho(ArrayList* lista) {
    return lista->quantidade;
}

// verifica se a lista está cheia
int cheia(ArrayList* lista) {
    return lista->capacidade == tamanho(lista);
}

// aumenta a capacidade da lista
Item* redimensionarArrayList(ArrayList* lista) {
    int novaCapacidade = lista->capacidade * 2;
    Item* itens = realloc(lista->itens, novaCapacidade * sizeof(Item));

    if(itens == NULL)
        return NULL;
    
    lista->itens = itens;
    lista->capacidade = novaCapacidade;

    return lista->itens;
}

// verifica se a lista está vazia;
// true: se vazia; caso contrário, false;
int vazia(ArrayList* lista) {
    return tamanho(lista) == 0;
}

// insere um item no inicio da lista
void inserirInicio(ArrayList* lista, Item item) {
    if(cheia(lista) && redimensionarArrayList(lista) == NULL)
        return;

    for(int i = tamanho(lista); i > 0; i--) 
        lista->itens[i] = lista->itens[i-1];
    
    lista->itens[0] = item;
    lista->quantidade++;
}

// insere um item no fim da lista
void inserirFim(ArrayList* lista, Item item) {
    if(cheia(lista) && redimensionarArrayList(lista) == NULL)
        return;

    lista->itens[lista->quantidade++] = item;
}

// insere um item na lista, de acordo
// com uma determinada posição
void inserir(ArrayList* lista, Item item, int posicao) {
    if(posicao < 0 || posicao > tamanho(lista))
        return;

    if(cheia(lista) && redimensionarArrayList(lista) == NULL)
        return;

    for(int i = tamanho(lista); i > posicao; i--)
        lista->itens[i] = lista->itens[i-1];

    lista->itens[posicao] = item;
    lista->quantidade++;
}

// obtem um item no iní­cio da lista;
// retorna o item obtido
Item obterInicio(ArrayList* lista) {
    if(vazia(lista))
        return LISTA_VAZIA;

    return lista->itens[0];
}

//  obtem um item no fim da lista;
// retorna o item obtido
Item obterFim(ArrayList* lista) {
    if(vazia(lista))
        return LISTA_VAZIA;

    return lista->itens[tamanho(lista)-1];
}

// obtem um item da lista,
// dada uma posição;
// retorna o item obtido
Item obter(ArrayList* lista, int posicao) {
    if(vazia(lista))
        return LISTA_VAZIA;

    if(posicao < 0 || posicao > tamanho(lista))
        return POSICAO_INVALIDA;

    return lista->itens[posicao];
}

// remove um item no inicio da lista;
// retorna o item removido
Item removerInicio(ArrayList* lista) {
    if(tamanho(lista) == 0)
        return LISTA_VAZIA;

    Item item = obterInicio(lista);

    for(int i = 0; i < tamanho(lista)-1; i++) 
        lista->itens[i] = lista->itens[i+1];

    lista->quantidade--;

    return item;
}

// remove um item no fim da lista;
// retorna o item removido
Item removerFim(ArrayList* lista) {
    if(tamanho(lista) == 0)
        return LISTA_VAZIA;

    Item item = obterFim(lista);
    lista->quantidade--;

    return item;
}

// remove um item no meio da lista,
// de acordo com uma determinada posição;
// retorna o item removido
Item remover(ArrayList* lista, int posicao) {
    if(posicao < 0 || posicao > tamanho(lista))
        return POSICAO_INVALIDA;

    if(vazia(lista))
        return LISTA_VAZIA;
    
    if(posicao == tamanho(lista)-1) 
        return removerFim(lista);

    if(posicao == 0)
        return removerInicio(lista);

    Item item = obter(lista, posicao);

    for(int i = posicao + 1; i < tamanho(lista); i++)
        lista->itens[i-1] = lista->itens[i];

    lista->quantidade--;

    return item;
}

// obtém a posição de um item da lista
// retorna a posição do item
int pesquisar(ArrayList* lista, Item item) {
    if(vazia(lista))
        return LISTA_VAZIA;

    for(int i = 0; i < tamanho(lista); i++) 
        if(lista->itens[i] == item)
            return i;

    return NENHUM_ITEM_ENCONTRADO;
}

// exibe toda a lista
void exibirLista(ArrayList* lista) {
    if(vazia(lista)) {
        printf("Lista vazia\n");
        return;
    }

    for(int i = 0; i < tamanho(lista); i++)        
        printf("%d\n", obter(lista, i));

    printf("\n");
}

// libera o arraylist
void desalocarArrayList(ArrayList* lista) {
    free(lista->itens);
    free(lista);
}

int main() {
    ArrayList* lista = criarArrayList(5);

    inserir(lista, 1, 0);
    exibirLista(lista);

    inserir(lista, 2, 1);
    exibirLista(lista);

    Item item = remover(lista, 0);
    printf("%d removido", item);

    exibirLista(lista);
    
    inserir(lista, 3, 2);
    exibirLista(lista);

    inserir(lista, 4, 3);
    exibirLista(lista);

    item = remover(lista, 1);
    printf("%d removido", item);

    inserir(lista, 5, 4);
    exibirLista(lista);

    desalocarArrayList(lista);

    return 0;
}