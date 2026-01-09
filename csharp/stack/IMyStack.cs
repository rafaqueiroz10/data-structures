namespace CSharp.Stack;

public interface IMyStack<T>
{
    public void Push(T item);

    public T Pop();

    public int Size();

    public bool IsEmpty();

    public T GetTop();
}