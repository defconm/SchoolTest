package jsjf;

import java.util.Iterator;

public class DoubleOrderedList<T> extends DoubleList<T>
        implements OrderedListADT<T>
       
{	
	public DoubleOrderedList()
	{
		super();
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