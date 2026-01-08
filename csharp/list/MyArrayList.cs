namespace CSharp.List;

using CSharp.List;
using CSharp.Exceptions;

public class MyArrayList<T> : AbstractList<T>
{
    public T[] Itens;
    public int Capacity;

    public MyArrayList(int numeroItens)
    {
        Itens = new T[numeroItens];
        Capacity = numeroItens;
    }

    public MyArrayList()
    {
        Itens = new T[5];
        Capacity = 5;
    }

    private void Resize()
    {
        Capacity *= 2;
        T[] aux = new T[Capacity];

        Array.Copy(Itens, aux, Quantity);

        Itens = aux;
    }

    private bool Full()
    {
        return Capacity == Quantity;
    }

    public override void InsertFirst(T item)
    {
        if (Full())
            Resize();

        Array.Copy(Itens, 0, Itens, 1, Quantity);
        Itens[0] = item;
        Quantity++;
    }
    public override void InsertLast(T item)
    {
        if (Full())
            Resize();

        Itens[Quantity] = item;
        Quantity++;
    }
    public override void Insert(T item, int position)
    {
        if (position == 0)
        {
            InsertFirst(item);
            return;
        }

        if (position == Quantity)
        {
            InsertLast(item);
            return;
        }

        if (position < 0 || position > Quantity)
            throw new PositionInvalidException();

        if (Full())
            Resize();

        Array.Copy(Itens, position, Itens, position + 1, Quantity - position);

        Itens[position] = item;
        Quantity++;
    }

    public override T RemoveFirst()
    {
        if (IsEmpty())
            throw new NoSuchItemException();

        T item = Get(0);
        for (int i = 1; i < Quantity; i++)
            Itens[i - 1] = Itens[i];

        Quantity--;

        return item;
    }
    public override T RemoveLast()
    {
        if (IsEmpty())
            throw new NoSuchItemException();

        T item = Get(Quantity - 1);
        Quantity--;

        return item;
    }
    public override T Remove(int position)
    {
        if (IsEmpty())
            throw new NoSuchItemException();

        if (position < 0 || position > Quantity-1)
            throw new PositionInvalidException();

        T item = Itens[position];

        for (int i = position + 1; i < Quantity; i++)
            Itens[i - 1] = Itens[i];

        Quantity--;

        return item;
    }

    public override T GetFirst()
    {
        if (IsEmpty())
            throw new NoSuchItemException();

        return Itens[0];
    }
    public override T GetLast()
    {
        if (IsEmpty())
            throw new NoSuchItemException();

        return Itens[Quantity - 1];
    }
    public override T Get(int position)
    {
        if (IsEmpty())
            throw new NoSuchItemException();

        if (position < 0 || position > Quantity-1)
            throw new PositionInvalidException();

        return Itens[position];
    }

    public override int Search(T item)
    {
        if (IsEmpty())
            throw new NoSuchItemException();

        for (int i = 0; i < Quantity; i++)
            if (item.Equals(Itens[i]))
                return i;

        return -1;
    }
}