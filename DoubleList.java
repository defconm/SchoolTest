package jsjf;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class DoubleList<T> implements ListADT<T>, Iterable<T>
		
{
	private class Itr<T> implements Iterator<T>
	{
		private int itrCount;
		private DoubleNode<T> current;
		
		public Itr()
		{
			current = (DoubleNode<T>) first;
			itrCount = count;
		}
		public boolean hasNext() throws ConcurrentModificationException
		{
			 if(itrCount != count)
				 throw new ConcurrentModificationException();
			 return (current != null);
		}
		public T next() throws ConcurrentModificationException
		{
			if(!hasNext())
				throw new ConcurrentModificationException();
			T result = current.getElement();
			current = current.getNext();
			return result;
		}
		public void remove() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
	}

	DoubleNode<T> first;
	DoubleNode<T> last;
	int count = 0;
	DoubleNode<T> tmp;
	
	public DoubleList()
	{
		first = null;
		last = null;
		tmp = null;
	}
	
	@Override
	public Iterator<T> iterator() 
	{
		Itr<T> itr = new Itr<>();
		return itr;
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
                if(!(element instanceof Comparable))
                    throw new NonComparableElementException("DoubleLink");
                Comparable<T> comparableElement = (Comparable<T>)element;
		while(tmp.getNext() != null)
		{
			if(comparableElement.compareTo(tmp.getElement()) == 0)
			{
				tmp.getNext().setPrevious(tmp.getPrevious());
				tmp.getPrevious().setNext(tmp.getNext());
				count--;
				return tmp.getElement();
			}
                        tmp = tmp.getNext();
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
