namespace CSharp.List;

using CSharp.List;
using CSharp.Exceptions;

public class Program
{
    public static void Main(string[] args)
    {
        IMyList<int> li = new MyArrayList<int>();
        
        try
        {
            li.Insert(10, 0);
            li.Insert(20, 1);
            li.Insert(30, 2);
            li.Insert(40, 3);
            li.Insert(50, 4);
            li.Insert(60, 5);
            li.Insert(70, 6);
            li.Insert(80, 7);
            li.Insert(90, 8);

            int indice = 0;
            while(true)
            {
                Console.WriteLine(li.Get(indice));
                indice++;
            }
        }
        catch(PositionInvalidException e)
        {
            Console.WriteLine("Fim da lista");
        }

        catch(NoSuchItemException e)
        {
            Console.WriteLine("Fim da lista");
        }

        try
        {
            while(true)
            {
                Console.WriteLine(li.Remove(0));   
            }
        }

        catch(PositionInvalidException e)
        {
            Console.WriteLine("Fim da lista");
        }

        catch(NoSuchItemException e)
        {
            Console.WriteLine("Fim da lista");
        }
    }
}