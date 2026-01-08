using System;
using System.Runtime.Serialization;

namespace CSharp.Exceptions;

[Serializable]
public class NoSuchItemException : Exception
{
    public NoSuchItemException() 
        : base("Atenção: Lista vazia!!") 
    { }
    public NoSuchItemException(string message) 
        : base(message) 
    { }
    public NoSuchItemException(string message, Exception inner) 
        : base(message, inner) 
    { }
    protected NoSuchItemException(SerializationInfo info, StreamingContext context)
        : base(info, context) 
    { }
}