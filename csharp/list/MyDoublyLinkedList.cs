namespace CSharp.List;

using CSharp.Exceptions;

public class MyDoublyLinkedList<T> : AbstractList<T>
{
    private class Node
    {
        public T Item { get; set; }
        public Node? Next { get; set; }
        public Node? Back { get; set; }

        public Node() : this(default!, null, null)
        {
        }

        public Node(T item) : this(item, null, null)
        {
        }

        public Node(T item, Node? next, Node? back)
        {
            Item = item;
            Next = next;
            Back = back;
        }
    }

    private Node? First;
    private Node? Last;

    private MyDoublyLinkedList(Node? first, Node? last, int quantity)
    {
        First = first;
        Last = last;
        Quantity = quantity;
    }

    public MyDoublyLinkedList() : this(null, null, 0)
    {
    }

    public override void InsertFirst(T item)
    {
        Node newNode = new Node(item);

        if (IsEmpty())
        {
            First = newNode;
            Last = newNode;
        }
        else
        {
            newNode.Next = First;
            First!.Back = newNode;
            First = newNode;
        }

        Quantity++;
    }

    public override void InsertLast(T item)
    {
        Node newNode = new Node(item);

        if (IsEmpty())
        {
            First = newNode;
            Last = newNode;
        }
        else
        {
            Last!.Next = newNode;
            newNode.Back = Last;
            Last = newNode;
        }

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

        Node aux = First!;
        for (int i = 0; i < position - 1; i++)
            aux = aux.Next!;

        Node newNode = new Node(item, aux.Next, aux);

        if (aux.Next != null)
            aux.Next.Back = newNode;

        aux.Next = newNode;

        Quantity++;
    }

    public override T RemoveFirst()
    {
        if (IsEmpty())
            throw new NoSuchItemException();

        T item = First!.Item;
        First = First.Next;

        if (First != null)
            First.Back = null;
        else
            Last = null;

        Quantity--;
        return item;
    }

    public override T RemoveLast()
    {
        if (IsEmpty())
            throw new NoSuchItemException();

        T item = Last!.Item;
        Last = Last.Back;

        if (Last != null)
            Last.Next = null;
        else
            First = null;

        Quantity--;
        return item;
    }

    public override T Remove(int position)
    {
        if (IsEmpty())
            throw new NoSuchItemException();

        if (position < 0 || position >= Quantity)
            throw new PositionInvalidException();

        if (position == 0)
            return RemoveFirst();

        if (position == Quantity - 1)
            return RemoveLast();

        Node aux = First!;
        for (int i = 0; i < position; i++)
            aux = aux.Next!;

        aux.Back!.Next = aux.Next;

        if (aux.Next != null)
            aux.Next.Back = aux.Back;

        Quantity--;
        return aux.Item;
    }

    public override T GetFirst()
    {
        if (IsEmpty())
            throw new NoSuchItemException();

        return First!.Item;
    }

    public override T GetLast()
    {
        if (IsEmpty())
            throw new NoSuchItemException();

        return Last!.Item;
    }

    public override T Get(int position)
    {
        if (position < 0 || position >= Quantity)
            throw new PositionInvalidException();

        Node aux = First!;
        for (int i = 0; i < position; i++)
            aux = aux.Next!;

        return aux.Item;
    }

    public override int Search(T item)
    {
        if (IsEmpty())
            throw new NoSuchItemException();

        int i = 0;
        for (Node? aux = First; aux != null; aux = aux.Next, i++)
            if (aux.Item!.Equals(item))
                return i;

        return -1;
    }
}