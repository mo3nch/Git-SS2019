package A02_Queue;

public class Queue<T>
{
    private int count;

    private Node<T> first;
    
    private Node<T> last;
    /**
     * Das vorderste (=erste) Element aus der Queue entfernen und zurückliefern.
     * Existiert kein Element, wird eine Exception ausgelöst.
     * @throws QueueEmptyException 
     */
    public T dequeue() throws QueueEmptyException
    {
        Node<T> toReturn = first;

        --count;

        if (first == null)
            throw new QueueEmptyException();

        if (first != last)
        {
            first = first.getNext();
        }
        else
        {
            first = last = null;
        }

        return toReturn.getData();
    }
    
    
    
    /**
     * Übergebenen Integer am Ende der Queue anhängen.
     * @param i Zahl
     */
    public void enqueue(T i)
    {
        Node toAdd = new Node<>(i);
        ++count;

        if (last == null)
        {
            last = toAdd;
            last.setNext(null);
            first = last;
        }
        else
        {
            toAdd.setNext(null);
            last.setNext(toAdd);
            last = toAdd;
        }
    }
    
    /**
     * Liefert die Anzahl der Elemente im Stack
     * @return
     */
    public int getCount() {
    	return count;
    }
}
