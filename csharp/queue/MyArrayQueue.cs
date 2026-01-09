namespace CSharp.Queue;

using CSharp.Queue;
using CSharp.Exceptions;

public class MyArrayQueue<T> : AbstractQueue<T>
{
    public override void Enqueue(T item)
    {
        return;
    }
    public override T Dequeue()
    {
        T item = GetFirst();
        return item;
    }
    public override T GetFirst()
    {
        T item = GetFirst();
        return item;
    }
}