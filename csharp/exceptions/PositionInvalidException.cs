namespace CSharp.Exceptions;

public class PositionInvalidException : Exception
{
    public PositionInvalidException() 
        :base("Atenção!! Posição inválida")
    { }
    public PositionInvalidException(string message) 
        : base(message) 
    { }
    public PositionInvalidException(string message, Exception inner) 
        : base(message, inner) 
    { }
    protected PositionInvalidException(
        System.Runtime.Serialization.SerializationInfo info,
        System.Runtime.Serialization.StreamingContext context) 
        : base(info, context) 
    { }
}