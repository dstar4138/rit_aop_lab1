import java.util.Iterator;

/**
 * A linear data structure using doubly-linked nodes.
 * It contains no cursor to allow the client to choose an internal
 * cursor (implemented in a subclass) or external cursor (separate
 * class).
 */
public class LinkedList< E >
        extends Observable
        implements Iterable< E > {

    /**
     * Create an empty list.
     * @post is_empty()
     */
    public LinkedList() {
        beginning = new DLinkNode< E >( null, null, null );
        ending = new DLinkNode< E >( beginning, null, null );
        beginning.next = ending;
        size = 0;
    }

    /**
     * How big is the list?
     * @return the number of elements currently in the list.
     */
    public int get_size() {
        return size;
    }

    /**
     * Is the list empty?
     * @return true iff get_size() == 0.
     * @post is_empty() == ( size() == 0 )
     */
    public boolean is_empty() {
        return beginning.next == ending;
    }

    /**
     * Get the first element.
     * @return the object at the beginning of the list.
     * @pre !is_empty()
     */
    public E first() {
        return beginning.next.value;
    }

    /**
     * Get the last element.
     * @return the object at the end of the list.
     * @pre !is_empty()
     */
    public E last() {
        return ending.prev.value;
    }

    /**
     * Place an object at the beginning of the list.
     * @param v object to be added
     * @post first() == v
     * @post !is_empty()
     */
    public void prepend( E v ) {
        put_before( v, beginning.next );
    }

    /**
     * Place an object at the end of the list.
     * @param v object to be added
     * @post last() == v
     * @post !is_empty()
     */
    public void append( E v ) {
        put_before( v, ending );
    }

    /**
     * Remove the object at the beginning of the list.
     * @pre !is_empty()
     */
    public void discard_first() {
        beginning.next.next.prev = beginning;
        beginning.next = beginning.next.next;
        size -= 1;
        setUpdated();
    }

    /**
     * Remove the object at the end of the list.
     * @pre !is_empty()
     */
    public void discard_last() {
        ending.prev.prev.next = ending;
        ending.prev = ending.prev.prev;
        size -= 1;
        setUpdated();
    }

    /**
     * Get the first link node.
     * @return the first node in the list, or the "after" node if the
     *         list is empty.
     */
    DLinkNode< E > first_node() {
        return beginning.next;
    }

    /**
     * Get the last link node.
     * @return the last node in the list, or the "before" node if the
     *         list is empty.
     */
    DLinkNode< E > last_node() {
        return ending.prev;
    }

    /**
     * Is this the "before" node?
     * @param n the DLinkNode to be tested
     * @return true iff n is the "before" node.
     */
    boolean is_before( DLinkNode< E > n ) {
        return n == beginning;
    }

    /**
     * Is this the "after" node?
     * @param n the DLinkNode to be tested
     * @return true iff n is the "after" node.
     */
    boolean is_after( DLinkNode< E > n ) {
        return n == ending;
    }

    /**
     * Place the value in a node right before the given node.
     * @param v the value
     * @param spot the the given node
     * @pre !is_before( spot )
     */
    void put_before( E v, DLinkNode< E > spot ) {
        DLinkNode< E > new_one =
            new DLinkNode< E >( spot.prev, v, spot );
        spot.prev.next = new_one;
        spot.prev = new_one;
        size += 1;
        setUpdated();
    }

    /**
     * Remove the node from the list in which it is contained.
     * @param spot the node to be removed
     * @pre !is_before( spot ) and !is_after( spot )
     */
    void discard( DLinkNode< E > spot ) {
        spot.prev.next = spot.next;
        spot.next.prev = spot.prev;
        size -= 1;
        setUpdated();
    }

    /**
     * Display the contents of the list as a comma-separated
     * sequence, bound in brackets. The elements of the list
     * are displayed using their own toString() methods.
     */
    @Override
    public String toString() {
        String result = getClass().getName() + "[ ";
        DLinkNode< E > node = beginning.next;
        for ( int i = 0; i < size; i += 1 ) {
            result = result + node.value;
            if ( node != ending.prev ) {
                result = result + ", ";
            }
            node = node.next;
        }
        result = result + " ]";
        return result;
    }

    /**
     * Two preallocated non-data nodes that represent the anchor
     * points beyond the ends of the list.
     */
    protected DLinkNode< E > beginning, ending;

    /**
     * Current size of the list
     */
    private int size;

// **** Iterable implementation ****

    public Iterator< E > iterator() {
        return new LinkedListCursor< E >( this );
    }

}
