namespace CSharp.List;

using CSharp.List;

public abstract class AbstractList<T> : IMyList<T>
{
    protected int Quantity;

    public AbstractList()
    {
        Quantity = 0;
    }

    public bool IsEmpty()
    {
        return Quantity == 0;
    }

    public int Size()
    {
        return Quantity;
    }

    public abstract void InsertFirst(T item);
    public abstract void InsertLast(T item);
    public abstract void Insert(T item, int position);

    public abstract T RemoveFirst();
    public abstract T RemoveLast();
    public abstract T Remove(int position);

    public abstract T GetFirst();
    public abstract T GetLast();
    public abstract T Get(int position);

    public abstract int Search(T item);
}