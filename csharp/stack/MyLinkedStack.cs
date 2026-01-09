namespace CSharp.Stack;

using CSharp.Stack;
using CSharp.Exceptions;

public class MyLinkedStack<T> : AbstractStack<T>
{
    private T Top, Next;

    public override void Push(T item)
    {
        return;
    }
    public override T Pop()
    {
        T item = GetTop();
        return item;
    }
    public override T GetTop()
    {
        T item = GetTop();
        return item;
    }
}