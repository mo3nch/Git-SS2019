package A01_Stack;


public class Stack<T>
{
	 private Node<T> first = null;
	 private int numElements = 0;
    /**
     * Oberstes Element entfernen und zurückliefern.
     * Existiert kein Element, wird eine Exception ausgelöst.
     * @throws StackEmptyException 
     */
    public T pop() throws StackEmptyException {

        if (numElements == 0)
            throw new StackEmptyException();

        Node<T> temp = first;
        first = first.getNext();
        --numElements;
        return temp.getData();
    }
    
    /**
     * Übergebenen T auf Stack (als oberstes Element) speichern.
     * @param i data
     */
    public void push(T i) {

        Node<T> toAdd = new Node<>(i);

        toAdd.setNext(first);
        first = toAdd;

        ++numElements;
    }
    
    /**
     * Liefert die Anzahl der Elemente im Stack
     * @return
     */
    public int getCount() {
    	return numElements;
    }
}
