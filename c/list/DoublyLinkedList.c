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
    struct No* proximo, *anterior;
} No;

typedef struct {
    No* inicio, *ultimo;
    int quantidade;
} DoublyLinkedList;

// função para criar o DoublyLinkedList
DoublyLinkedList* criarDoublyLinkedList() {
    DoublyLinkedList* lista = (DoublyLinkedList*) malloc(sizeof(DoublyLinkedList));
    
    if(lista == NULL)
        return NULL;
    
    lista->quantidade = 0;
    lista->ultimo = NULL;
    lista->inicio = NULL;

    return lista;
}

// retorna o tamanho da lista
int tamanho(DoublyLinkedList* lista) {
    return lista->quantidade;
}

// verifica se a lista está vazia;
// true: se vazia; caso contrário, false;
int vazia(DoublyLinkedList* lista) {
    return tamanho(lista) == 0;
}

// insere um item no inicio da lista
void inserirInicio(DoublyLinkedList* lista, Item item) {
    No* novoNo = (No*) malloc(sizeof(No));
    novoNo->item = item;
    novoNo->anterior = NULL;
    novoNo->proximo = lista->inicio;

    if(vazia(lista)) 
        lista->ultimo = novoNo;
    else 
        lista->inicio->anterior = novoNo;

    lista->inicio = novoNo;
    lista->quantidade++;
}

// insere um item no fim da lista
void inserirFim(DoublyLinkedList* lista, Item item) {
    No* novoNo = (No*) malloc(sizeof(No));
    novoNo->item = item;
    novoNo->proximo = NULL;
    novoNo->anterior = lista->ultimo;

    if(vazia(lista))
        lista->inicio = novoNo;
    else 
        lista->ultimo->proximo = novoNo;

    lista->ultimo = novoNo;
    lista->quantidade++;
}

// obtem um nó de um item da lista
No* obterNo(DoublyLinkedList* lista, int posicao) {
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
void inserir(DoublyLinkedList* lista, Item item, int posicao) {
    if(posicao < 0 || posicao > tamanho(lista))
        return;

    if(posicao == 0) {
        inserirInicio(lista, item);
        return;
    }

    if(posicao == tamanho(lista)) {
        inserirFim(lista, item);
        return;
    }

    No* novoNo = (No*) malloc(sizeof(No));
    novoNo->item = item;

    No* noItem = obterNo(lista, posicao);
    No* noAnterior = noItem->anterior;

    novoNo->anterior = noAnterior;
    novoNo->proximo = noItem;
    
    noAnterior->proximo = novoNo;
    noItem->anterior = novoNo;

    lista->quantidade++;
}

// obtem um item no iní­cio da lista;
// retorna o item obtido
Item obterInicio(DoublyLinkedList* lista) {
    if(vazia(lista))
        return LISTA_VAZIA;

    return lista->inicio->item;
}

//  obtem um item no fim da lista;
// retorna o item obtido
Item obterFim(DoublyLinkedList* lista) {
    if(vazia(lista))
        return LISTA_VAZIA;

    return lista->ultimo->item;
}

// obtem um item da lista,
// dada uma posição;
// retorna o item obtido
Item obter(DoublyLinkedList* lista, int posicao) {
    if(vazia(lista))
        return LISTA_VAZIA;

    if(posicao < 0 || posicao > tamanho(lista)-1)
        return POSICAO_INVALIDA;

    No* no = obterNo(lista, posicao);
    return no->item;
}

// remove um item no inicio da lista;
// retorna o item removido
Item removerInicio(DoublyLinkedList* lista) {
    if(vazia(lista))
        return LISTA_VAZIA;

    Item item = obterInicio(lista);

    No* inicio = lista->inicio;

    if(tamanho(lista) == 1) {
        lista->ultimo = NULL;
        lista->inicio = NULL;
    }
    else {
        lista->inicio = lista->inicio->proximo;
        lista->inicio->anterior = NULL;
    }

    lista->quantidade--;

    free(inicio);

    return item;
}

// remove um item no fim da lista;
// retorna o item removido
Item removerFim(DoublyLinkedList* lista) {
    if(tamanho(lista) == 0)
        return LISTA_VAZIA;

    Item item = obterFim(lista);
    
    No* noFim = lista->ultimo;
    No* noAnterior = noFim->anterior;

    if(lista->quantidade == 1) {
        lista->inicio = NULL;
        lista->ultimo = NULL;
    }
    else {
        noAnterior->proximo = NULL;
        lista->ultimo = noAnterior;
    }

    lista->quantidade--;
    
    free(noFim);

    return item;
}

// remove um item no meio da lista,
// de acordo com uma determinada posição;
// retorna o item removido
Item remover(DoublyLinkedList* lista, int posicao) {
    if(vazia(lista))
        return LISTA_VAZIA;

    if(posicao < 0 || posicao > tamanho(lista)-1)
        return POSICAO_INVALIDA;

    if(posicao == 0) 
        return removerInicio(lista); 
    
    if(posicao == tamanho(lista)-1)
        return removerFim(lista);

    Item item = obter(lista, posicao);

    No* noItem = obterNo(lista, posicao);
    No* noAnterior = noItem->anterior;

    noAnterior->proximo = noItem->proximo;
    noItem->proximo->anterior = noAnterior;

    free(noItem);

    lista->quantidade--;

    return item;
}

// obtém a posição de um item da lista
// retorna a posição do item
int pesquisar(DoublyLinkedList* lista, Item item) {
    if(vazia(lista))
        return LISTA_VAZIA;

    int posicaoAtual = 0;
    for(No* no = lista->inicio; no != NULL; no = no->proximo, posicaoAtual++)
        if(no->item == item) 
            return posicaoAtual;

    return POSICAO_INVALIDA;
}

// exibe toda a lista
void exibirLista(DoublyLinkedList* lista) {
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

// libera o DoublyLinkedList
void desalocarDoublyLinkedList(DoublyLinkedList* lista) {
    int indice = 0; 
    while(!vazia(lista)) 
        removerInicio(lista);

    free(lista);
}

int main() {
    DoublyLinkedList* lista = criarDoublyLinkedList();

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

    desalocarDoublyLinkedList(lista);

    return 0;
}