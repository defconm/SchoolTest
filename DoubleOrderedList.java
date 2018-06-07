package jsjf;

import java.util.Iterator;

public class DoubleOrderedList<T extends Comparable<T>> implements OrderedListADT<T>
{



	private DoubleNode<T> first;
	private DoubleNode<T> last;
	private int count = 0;
	private DoubleNode<T> tmp;
	
	public Iterator<T> iterator() 
	{
		return iterator();
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
		boolean done = false;
		while(!done)
		{
			str += " " + tmp.getElement();
			if(tmp.getNext()!= null)
				tmp = tmp.getNext();
			else
				done = true;
		}
		System.out.println(count);
		return str;
	}
	

	@Override
	public void add(T element) 
	{
		try 
		{
			tmp = first;
			if(count == 0)
			{
				first = new DoubleNode<T>(element);
				count++;
			}
			while(tmp.getNext() != null)
			{
				if(count == 1 && tmp.getElement().compareTo(element) > 0)
				{
					first.setNext(new DoubleNode<T>(element));
					count++;
					return;
				}
				if(count == 1 && tmp.getElement().compareTo(element) < 0)
				{
					first.setPrevious(new DoubleNode<T>(element));
					first.getPrevious().setNext(first);
					first.setNext(null);
					first = first.getPrevious();
					count++;
					return;
				}
				if(tmp.getElement().compareTo(element) > 0 && ((Comparable<T>) tmp.getNext().getElement()).compareTo(element) < 0)
				{
					DoubleNode<T> toAdd = new DoubleNode<T>(element);
					toAdd.setNext(tmp.getNext());
					toAdd.setPrevious(tmp);
					tmp.setNext(toAdd);
					count++;
					return;
				}
				tmp = tmp.getNext();
			}
		}
		catch(Exception e)
		{
			
		}
		
	}
	
	public int compareTo(T a)
	{
		int compared = 0;
		try {
		compared = tmp.getElement().compareTo(a);
		}
		catch(Exception e)
		{
			throw new NonComparableElementException("");
		}
		return compared;
	}

}
