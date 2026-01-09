namespace CSharp.Queue;

public interface IMyQueue<T>
{
    public T GetFirst();

    public void Enqueue(T item);

    public T Dequeue();

    public int Size();

    public bool IsEmpty();
}