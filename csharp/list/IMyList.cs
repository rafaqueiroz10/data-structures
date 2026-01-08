namespace CSharp.List;

public interface IMyList<T>
{
    // retorna o tamanho da lista
    public int Size();

    // verifica se a lista está vazia;
    // true: se vazia; caso contrário, false;
    public bool IsEmpty();

    // insere um item no inicio da lista
    public void InsertFirst(T item);

    // insere um item no fim da lista
    public void InsertLast(T item);

    // insere um item na lista, de acordo
    // com uma determinada posição
    public void Insert(T item, int position);

    // remove um item no inicio da lista;
    // retorna o item removido
    public T RemoveFirst();

    // remove um item no fim da lista;
    // retorna o item removido
    public T RemoveLast();

    // remove um item no meio da lista,
    // de acordo com uma determinada posição;
    // retorna o item removido
    public T Remove(int position);

    // obtem um item no inÃ­cio da lista;
    // retorna o item obtido
    public T GetFirst();

    //  obtem um item no fim da lista;
    // retorna o item obtido
    public T GetLast();

    // obtem um item da lista,
    // dada uma posição;
    // retorna o item obtido
    public T Get(int position);

    //  obtem a posição de um item da lista
    // retorna a posição do item
    public int Search(T item);
}