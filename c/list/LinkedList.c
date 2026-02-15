#include <stdio.h>
#include <stdlib.h>

#define NENHUM_ITEM_ENCONTRADO -1
#define LISTA_VAZIA -1
#define TRUE 1
#define FALSE 0
#define POSICAO_INVALIDA -1

typedef int Item;

typedef struct No {
    Item item;
    struct No* proximo;
} No;

typedef struct {
    No* inicio, *ultimo;
    int quantidade;
} LinkedList;

// função para criar o linkedlist
LinkedList* criarLinkedList() {
    LinkedList* lista = (LinkedList*) malloc(sizeof(LinkedList));
    
    if(lista == NULL)
        return NULL;
    
    lista->quantidade = 0;
    lista->ultimo = NULL;
    lista->inicio = NULL;

    return lista;
}

// retorna o tamanho da lista
int tamanho(LinkedList* lista) {
    return lista->quantidade;
}

// verifica se a lista está vazia;
// true: se vazia; caso contrário, false;
int vazia(LinkedList* lista) {
    return tamanho(lista) == 0;
}

// insere um item no inicio da lista
void inserirInicio(LinkedList* lista, Item item) {
    No* novoNo = (No*) malloc(sizeof(No));
    novoNo->item = item;

    if(vazia(lista)) {
        novoNo->proximo = NULL;
        lista->ultimo = novoNo;
    }
    else {
        novoNo->proximo = lista->inicio;
    }

    lista->inicio = novoNo;
    lista->quantidade++;
}

// insere um item no fim da lista
void inserirFim(LinkedList* lista, Item item) {
    No* novoNo = (No*) malloc(sizeof(No));
    novoNo->item = item;

    if(vazia(lista)) {
        lista->inicio = novoNo;
        lista->ultimo = novoNo;
    }
    else {
        lista->ultimo->proximo = novoNo;
        lista->ultimo = novoNo;
    }

    novoNo->proximo = NULL;
    lista->quantidade++;
}

// obter um No dada uma determinada posição
No* obterNo(LinkedList* lista, int posicao) {
    if (lista == NULL)
        return NULL;

    if (posicao < 0 || posicao >= lista->quantidade)
        return NULL;

    No* no = lista->inicio;
    for(int i = 0; i < posicao; i++) 
        no = no->proximo;

    return no;
}

// insere um item na lista, de acordo
// com uma determinada posição
void inserir(LinkedList* lista, Item item, int posicao) {
    if(posicao < 0 || posicao > tamanho(lista))
        return;

    if(posicao == 0) {
        inserirInicio(lista, item);
        return;   
    }

    No* novoNo = (No*) malloc(sizeof(No));
    novoNo->item = item;

    No* noAnterior = obterNo(lista, posicao-1);
    novoNo->proximo = noAnterior->proximo;
    noAnterior->proximo = novoNo;

    if(posicao == tamanho(lista))
        lista->ultimo = novoNo;

    lista->quantidade++;
}

// obtem um item no iní­cio da lista;
// retorna o item obtido
Item obterInicio(LinkedList* lista) {
    if(vazia(lista))
        return LISTA_VAZIA;

    return lista->inicio->item;
}

//  obtem um item no fim da lista;
// retorna o item obtido
Item obterFim(LinkedList* lista) {
    if(vazia(lista))
        return LISTA_VAZIA;

    return lista->ultimo->item;
}

// obtem um item da lista,
// dada uma posição;
// retorna o item obtido
Item obter(LinkedList* lista, int posicao) {
    if(vazia(lista))
        return LISTA_VAZIA;

    if(posicao < 0 || posicao >= tamanho(lista))
        return POSICAO_INVALIDA;

    No* no = obterNo(lista, posicao);
    
    return no->item;
}

// remove um item no inicio da lista;
// retorna o item removido
Item removerInicio(LinkedList* lista) {
    if(vazia(lista))
        return LISTA_VAZIA;

    Item item = obterInicio(lista);

    No* inicio = lista->inicio;
    lista->inicio = lista->inicio->proximo;

    if(tamanho(lista) == 1)
        lista->ultimo = NULL;

    lista->quantidade--;

    free(inicio);

    return item;
}

// remove um item no fim da lista;
// retorna o item removido
Item removerFim(LinkedList* lista) {
    if(tamanho(lista) == 0)
        return LISTA_VAZIA;

    Item item = obterFim(lista);
    
    No* fim = lista->ultimo;
    No* noAnterior = obterNo(lista, tamanho(lista)-2);

    if(noAnterior != NULL) {
        lista->ultimo = noAnterior;
        noAnterior->proximo = NULL;
    }
    else {
        lista->inicio = NULL;
        lista->ultimo = NULL;   
    }

    free(fim);

    lista->quantidade--;

    return item;
}

// remove um item no meio da lista,
// de acordo com uma determinada posição;
// retorna o item removido
Item remover(LinkedList* lista, int posicao) {
    if(posicao < 0 || posicao >= tamanho(lista))
        return POSICAO_INVALIDA;

    if(vazia(lista))
        return LISTA_VAZIA;

    if(posicao == 0) 
        return removerInicio(lista);

    Item item = obter(lista, posicao);
    
    No* noAnterior = obterNo(lista, posicao - 1);
    No* noItem = noAnterior->proximo;
    
    noAnterior->proximo = noItem->proximo;
    
    if(posicao == tamanho(lista)-1) 
        lista->ultimo = noAnterior;
    
    free(noItem);

    lista->quantidade--;

    return item;
}

// obtém a posição de um item da lista
// retorna a posição do item
int pesquisar(LinkedList* lista, Item item) {
    if(vazia(lista))
        return LISTA_VAZIA;

    int posicaoAtual = 0;
    for(No* no = lista->inicio; no != NULL; no = no->proximo, posicaoAtual++)
        if(no->item == item) 
            return posicaoAtual;

    return POSICAO_INVALIDA;
}

// exibe toda a lista
void exibirLista(LinkedList* lista) {
    if(vazia(lista)) {
        printf("Lista vazia\n");
        return;
    }

    int p = 0;
    printf("Itens da lista:");
    for(No* no = lista->inicio; no != NULL; no = no->proximo, p++) 
        printf(" %d", no->item);
    printf("\n");
}

// libera o LinkedList
void desalocarLinkedList(LinkedList* lista) {
    while(!vazia(lista)) 
        removerInicio(lista);

    free(lista);
}

int main() {
    LinkedList* lista = criarLinkedList();

    inserir(lista, 1, 0);
    exibirLista(lista);

    inserir(lista, 2, 1);
    exibirLista(lista);

    Item item = remover(lista, 0);
    
    printf("%d removido\n", item);

    exibirLista(lista);
    
    inserir(lista, 3, 1);
    exibirLista(lista);

    inserir(lista, 4, 2);
    exibirLista(lista);

    item = remover(lista, 1);
    printf("%d removido\n", item);

    exibirLista(lista);

    inserir(lista, 5, 1);
    exibirLista(lista);

    item = remover(lista, 2);
    printf("%d removido\n", item);

    exibirLista(lista);

    desalocarLinkedList(lista);

    return 0;
}