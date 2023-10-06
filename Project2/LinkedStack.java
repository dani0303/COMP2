package utils;

import java.util.EmptyStackException;
import utils.Node;

public class LinkedStack<T> implements StackInterface<T>
{
    private Node <T> topNode;

    public LinkedStack()
    {
        topNode = null;
    }

    public void push(T anEntry) 
    {
        Node <T> dataNode = new Node<>(anEntry);
        dataNode.setNext(topNode);
        topNode = dataNode;
    }

    public T pop() 
    {
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        T outData = topNode.getData();
        topNode = topNode.getNext();
        return outData;
    }

    public T peek() 
    {
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }        

    public boolean isEmpty() 
    {
        return (topNode == null);
    }

    public void clear() 
    {
        topNode = null;
    }
}
