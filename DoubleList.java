package jsjf;

import java.util.Iterator;

public class DoubleList<T> implements ListADT<T>, Iterable<T>
		
{

	private DoubleNode<T> first;
	private DoubleNode<T> last;
	private int count = 0;
	private DoubleNode<T> tmp;
	
	@Override
	public Iterator<T> iterator() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T removeFirst() 
	{
		tmp = first;
		first = tmp.getNext();
		first.setPrevious(tmp.getPrevious());
		count--;
		return tmp.getElement();
	}

	@Override
	public T removeLast() 
	{
		tmp = last;
		last = tmp.getPrevious();
		last.setNext(tmp.getNext());
		count--;
		return tmp.getElement();
	}

	@Override
	public T remove(T element) 
	{
		tmp = first;
		while(tmp.getNext() != null)
		{
			if(tmp.getElement().equals(element))
			{
				tmp.getNext().setPrevious(tmp.getPrevious());
				tmp.getPrevious().setNext(tmp.getNext());
				count--;
				return tmp.getElement();
			}
		}
		throw new ElementNotFoundException("DoubleList");
	}

	@Override
	public T first() 
	{
		if(count == 0)
			throw new EmptyCollectionException("DoubleList");
		return first.getElement();
	}

	@Override
	public T last() 
	{
		if(count == 0)
			throw new EmptyCollectionException("DoubleList");
		return last.getElement();
	}

	@Override
	public boolean contains(T target) 
	{
		tmp = first;
		while(tmp.getNext() != null)
		{
			if(tmp.getElement().equals(target))
				return true;
			tmp = tmp.getNext();
		}
		throw new ElementNotFoundException("DoubleList");
	}

	@Override
	public boolean isEmpty() 
	{
		return count == 0;
	}

	@Override
	public int size() 
	{
		return count;
	}
	
	public String toString()
	{
		String str = "";
		tmp = first;
		while(tmp.getNext() != null)
		{
			str += " " + tmp.getElement();
			tmp = tmp.getNext();
		}
		return str;
	}
	
}
