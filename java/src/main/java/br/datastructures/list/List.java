package br.datastructures.list;

import br.datastructures.exceptions.NoItemException;
import br.datastructures.exceptions.PositionInvalidException;

public interface List<I> {
    // retorna o tamanho da lista
    public int size();

    // verifica se a lista estÃ¡ vazia;
    // true: se vazia; caso contrÃ¡rio, false;
    public boolean empty();

    // insere um item no inicio da lista
    public void insertFirst(I item);

    // insere um item no fim da lista
    public void insertLast(I item);

    // insere um item na lista, de acordo
    // com uma determinada posiÃ§Ã£o
    public void insert(I item, int position)
            throws PositionInvalidException;

    // remove um item no inicio da lista;
    // retorna o item removido
    public I removeFirst() throws NoItemException;

    // remove um item no fim da lista;
    // retorna o item removido
    public I removeLast() throws NoItemException;

    // remove um item no meio da lista,
    // de acordo com uma determinada posiÃ§Ã£o;
    // retorna o item removido
    public I remove(int position)
            throws PositionInvalidException, NoItemException;

    // obtem um item no inÃ­cio da lista;
    // retorna o item obtido
    public I getFirst() throws NoItemException;

    //  obtem um item no fim da lista;
    // retorna o item obtido
    public I getLast() throws NoItemException;

    // obtem um item da lista,
    // dada uma posição;
    // retorna o item obtido
    public I get(int position)
            throws NoItemException, PositionInvalidException;

    //  obtem a posiÃ§Ã£o de um item da lista
    // retorna a posiÃ§Ã£o do item
    public int search(I item) throws NoItemException;
}