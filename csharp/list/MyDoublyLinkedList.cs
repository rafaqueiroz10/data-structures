namespace CSharp.List;

using CSharp.List;
using CSharp.Exceptions;

public class MyDoublyLinkedList<T> : AbstractList<T>
{
    class Node
    {
        
    }

    public MyDoublyLinkedList(int numeroItens)
    {
        
    }

    public MyDoublyLinkedList()
    {
        
    }

    public override void InsertFirst(T item)
    {
        Quantity++;
    }
    public override void InsertLast(T item)
    {
        Quantity++;
    }
    public override void Insert(T item, int position)
    {
        Quantity++;
    }

    public override T RemoveFirst()
    {
        if (IsEmpty())
            throw new NoSuchItemException();

        Quantity--;

        return null;
    }
    public override T RemoveLast()
    {
        if (IsEmpty())
            throw new NoSuchItemException();

        
        Quantity--;

        return null;
    }
    public override T Remove(int position)
    {
        if (IsEmpty())
            throw new NoSuchItemException();


        Quantity--;

        return item;
    }

    public override T GetFirst()
    {
        if (IsEmpty())
            throw new NoSuchItemException();

        return null;
    }
    public override T GetLast()
    {
        if (IsEmpty())
            throw new NoSuchItemException();

        return null;
    }
    public override T Get(int position)
    {
        if (IsEmpty())
            throw new NoSuchItemException();

        return null;
    }

    public override int Search(T item)
    {
        if (IsEmpty())
            throw new NoSuchItemException();

        return -1;
    }
}