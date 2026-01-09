namespace CSharp.Queue;

using CSharp.Queue;

public abstract class AbstractQueue<T> : IMyQueue<T>
{
    protected int Quantity;

    public AbstractQueue()
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

    public abstract void Enqueue(T item);
    public abstract T Dequeue();
    public abstract T GetFirst();
}