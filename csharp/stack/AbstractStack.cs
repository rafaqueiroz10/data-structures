namespace CSharp.Stack;

using CSharp.Stack;

public abstract class AbstractStack<T> : IMyStack<T>
{
    protected int Quantity;

    public AbstractStack()
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

    public abstract void Push(T item);
    public abstract T Pop();
    public abstract T GetTop();
}