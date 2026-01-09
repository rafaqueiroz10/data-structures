namespace CSharp.List;

using CSharp.List;
using CSharp.Exceptions;

public class MyLinkedList<T> : AbstractList<T>
{
    public class Node {
        public T Item { get; set; }
        public Node? Next { get; set; }

        public Node() : this(default!, null)
        {
        }

        public Node(T item) : this(item, null)
        {
        }

        public Node(T item, Node next) {
            this.Item = item;
            this.Next = next;
        }
    }

    private Node First, Last;
    private int Quantity;

    private MyLinkedList(Node first, Node last, int quantity)
    {   
        this.First = first;
        this.Last = last;
        this.Quantity = quantity;
    }

    public MyLinkedList() : this(null, null, 0)
    {
    }

    public override void InsertFirst(T item)
    {
        Node newNode = new Node(item);
        
        if (IsEmpty()) 
            Last = newNode;
        
        newNode.Next = First;
        First = newNode;
        
        Quantity++;
    }
    public override void InsertLast(T item)
    {
        Node newNode = new Node(item);
        
        if (IsEmpty()) {
            First = newNode;
            Last = newNode;
            newNode.Next = null;
        }
        else {
            Last.Next = newNode;
            newNode.Next = null;
            Last = newNode;
        }
    }
    public override void Insert(T item, int position)
    {
        if (position == 0) {
            InsertFirst(item);
            return;
        }
        
        if (position == Size()) {
            InsertLast(item);
            return;
        }
        
        if (position < 0 || position > Quantity-1)
            throw new PositionInvalidException();
        
        Node newNode = new Node(item);
        Node aux = First;

        for(int i = 0; i < position - 1; i++)
            aux = aux.Next;

        newNode.Next = aux.Next;
        aux.Next = newNode;
        Quantity++;
    }

    public override T RemoveFirst()
    {
        if (IsEmpty())
            throw new NoSuchItemException();

        T item = GetFirst();
        First = First.Next;
        Quantity--;

        return item;
    }
    public override T RemoveLast()
    {
        if (IsEmpty())
            throw new NoSuchItemException();

        T item = GetLast();

        if(First.Equals(Last)) {
            First = null;
            Last = null;
        }
        else {
            Node aux = First;
            while(!aux.Next.Equals(Last)) 
                aux = aux.Next;
         
            aux.Next = null;
            Last = aux;
        }

        Quantity--;

        return item;
    }
    public override T Remove(int position)
    {
        if(position == 0)
            return RemoveFirst();
        
        if(position == Size()-1)
            return RemoveLast();

        T item = Get(position);
        Node aux = First;
        for (int i = 0; i < position - 1; i++) 
            aux = aux.Next;
        
        Node next = aux.Next;
        aux.Next = next.Next;
        Quantity--;

        return item;
    }

    public override T GetFirst()
    {
        if (IsEmpty())
            throw new NoSuchItemException();

        return First.Item;
    }
    public override T GetLast()
    {
        if (IsEmpty())
            throw new NoSuchItemException();

        return Last.Item;
    }
    public override T Get(int position)
    {
        int p = 0;
        for(Node aux = First; aux != null; aux = aux.Next) {
            if(p == position)
                return aux.Item;

            p++;
        }

        throw new NoSuchItemException();
    }

    public override int Search(T item)
    {
        if(IsEmpty())
            throw new NoSuchItemException();
        
        int position = 0;
        for(Node aux = First; aux != null; aux = aux.Next) {
            if(aux.Item.Equals(item))
                return position;

            position++;
        }

        return -1;
    }
}