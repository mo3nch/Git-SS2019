package A03_DoubleLinkedList;

public class DoubleLinkedList<T>
{
    private Node<T> first = null;
    private Node<T> last = null;
    private Node<T> next = null;


    /**
     * Einf�gen einer neuen <T>
     * @param a <T>
     */
    public void add(T a) {
        Node<T> toAdd = new Node<>(a);
        last.setNext(toAdd);
        toAdd.setPrevious(last);
        last = toAdd;
    }

    /**
     * Internen Zeiger f�r next() zur�cksetzen
     */
    public void reset() {
        next = null;
    }

    /**
     * analog zur Funktion reset()
     */
    public void resetToLast() {
        next = last;
    }

    /**
     * Liefert erste Node der Liste retour oder null, wenn Liste leer
     * @return Node|null
     */
    public Node<T> getFirst() {
    	return first;
    }
    
    /**
     * Liefert letzte Node der Liste retour oder null, wenn Liste leer
     * @return Node|null
     */
    public Node<T> getLast() {
    	return last;
    }
    
    /**
     * Gibt aktuelle <T> zur�ck und setzt internen Zeiger weiter.
     * Falls current nicht gesetzt, wird null retourniert.
     * @return <T>|null
     */
    public T next() {
        if (next != null)
        {
            T toReturn = next.getData();
            next = next.getNext();
            return toReturn;
        }
        else
            return null;
    }

    /**
     * analog zur Funktion next()
     * @return <T>|null
     */
    public T previous() {
        if (next != null)
        {
            T toReturn = next.getData();
            next = next.getPrevious();
            return toReturn;
        }
        else
            return null;
    }
    
    /**
     * Current-Pointer auf n�chste <T> setzen (aber nicht auslesen).
     * Ignoriert still, dass current nicht gesetzt ist.
     */
    public void moveNext() {
        next = next.getNext();
    }
    
    /**
     * Analog zur Funktion moveNext()
     */
    public void movePrevious() {
        next = next.getPrevious();
    }
   
    /**
     * Retourniert aktuelle (current) <T>, ohne Zeiger zu �ndern
     * @return <T>
     * @throws CurrentNotSetException
     */
    public T getCurrent() throws CurrentNotSetException {

        if (next == null)
            throw new CurrentNotSetException();

        return next.getData();
    }

    /**
     * Gibt <T> an bestimmter Position zur�ck
     * @param pos Position, Nummerierung startet mit 1
     * @return <T>|null
     */
    public T get(int pos) {
        Node<T> current = first;

        for (int i = 1; i < pos; i++)
        {
            if (current != null)
                current = current.getNext();
            else
                return null;
        }

        return current.getData();
    }

    /**
     * Entfernen des Elements an der angegebenen Position.
     * Falls das entfernte Element das aktuelle Element ist, wird current auf null gesetzt.
     * @param pos
     */
    public void remove(int pos) {

    }
    
    /**
     * Entfernt das aktuelle Element.
     * Als neues aktuelles Element wird der Nachfolger gesetzt oder
     * (falls kein Nachfolger) das vorhergehende Element 
     * @throws CurrentNotSetException
     */
    public void removeCurrent() throws CurrentNotSetException {
        if (next == null)
            throw new CurrentNotSetException();

        next.getPrevious().setNext(next.getNext());
    }
    
    /**
     * Die Methode f�gt die �bergebene <T> nach der aktuellen (current) ein
     * und setzt dann die neu eingef�gte <T> als aktuelle (current) <T>.
     * @throws CurrentNotSetException 
     */
    public void insertAfterCurrentAndMove(T a) throws CurrentNotSetException {

    }
}
