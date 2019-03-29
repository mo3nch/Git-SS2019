package A02_Queue;

public class Queue<T>
{
    private int count;

    private Node<T> first;
    
    private Node<T> last;
    /**
     * Das vorderste (=erste) Element aus der Queue entfernen und zur�ckliefern.
     * Existiert kein Element, wird eine Exception ausgel�st.
     * @throws QueueEmptyException
     */
    public T dequeue() throws QueueEmptyException
    {
        Node<T> toReturn = first; //die Node wird zwischengespeichert; return das erste und wirfs dann aus dem speicher hinaus (equals erledigt)

        if (first == null) //prüft, ob first Null ist
            throw new QueueEmptyException();

        if (first != last)
            first = first.getNext();
        else
            first = last = null;

        --count;
        return toReturn.getData();
    }

    /**
     * �bergebenen Integer am Ende der Queue anh�ngen.
     * @param i Zahl
     */
    public void enqueue(T i)
    {
        Node toAdd = new Node<>(i);

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

        ++count;
    }
    
    /**
     * Liefert die Anzahl der Elemente im Stack
     * @return
     */
    public int getCount() {
    	return count;
    }
}
