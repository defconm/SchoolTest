package jsjf;

public class DoubleNode<T> {

	private T element;
	private DoubleNode next;
	private DoubleNode previous;
	
	public DoubleNode(T element)
	{
		this.element = element;
		next = null;
		previous = null;
	}
	
	public void setNext(DoubleNode next)
	{
		this.next = next;
	}
	
	public DoubleNode getNext()
	{
		return next;
	}
	
	public void setPrevious(DoubleNode previous)
	{
		this.previous = previous;
	}
	
	public DoubleNode getPrevious()
	{
		return previous;
	}
	
	public T getElement()
	{
		return element;
	}
	
	
}
