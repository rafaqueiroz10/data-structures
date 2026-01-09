namespace CSharp.Stack;

using CSharp.Stack;
using CSharp.Exceptions;

public class MyArrayStack<T> : AbstractStack<T>
{
    private T[] Itens;
    
    public override void Push(T item)
    {
        Itens[0] = item;
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