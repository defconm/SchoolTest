package jsjf;

import java.util.Iterator;

public class DoubleOrderedList<T> 
        implements OrderedListADT<T>
       
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
	@Override
	public String toString()
	{
		String str = "";
		tmp = first;
		boolean done = false;
		while(!done)
                {
                    str += tmp.getElement() + " ";
                    tmp = tmp.getNext();
                    if(tmp == null)
                        done = true;
                }
		return str;
	}
	
	
        @Override
	public void add(T element) 
	{
            DoubleNode<T> current = null;
            DoubleNode<T> previous = null;
            DoubleNode<T> tmp = null;
            if(!(element instanceof Comparable))
                throw new NonComparableElementException("DoubleList");
            Comparable<T> comparableElement = (Comparable<T>)element;
            if(first == null)
            {
                first = new DoubleNode<T>(element);
                count++;
                return;
            }
            current = previous = first;
            if(first.getNext() == null)
            {
                if(comparableElement.compareTo(current.getElement()) > 0)
                {
                    tmp = new DoubleNode<T>(element);
                    first.setNext(tmp);
                    tmp.setPrevious(first);
                    last = tmp;
                }
                else
                {
                    first.setPrevious(new DoubleNode<T>(element));
                    first = first.getPrevious();
                    first.setNext(current);
                    last = current;
                }
                count++;
                return;
            }
            while(current.getNext() != null)
            {
                if(comparableElement.compareTo(current.getElement()) < 0)
                {
                    tmp = new DoubleNode<T>(element);
                    if(current == first)
                    {
                        first = tmp;
                        first.setNext(current);
                        current.setPrevious(first);
                    }
                    else
                    {
                        tmp.setNext(current);
                        tmp.setPrevious(previous);
                        current.setPrevious(tmp);
                        previous.setNext(tmp);
                    }
                    count++;
                    return;
                }
                else
                {
                    previous = current;
                    current = current.getNext();
                }
            }
        }

}
