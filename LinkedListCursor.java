import java.util.Iterator;

/**
 * An iterator for LinkedList. LinkedList and LinkedListCursor were
 * designed so that the latter does not depend on the former's
 * implementation.
 */
public class LinkedListCursor< E > implements Iterator< E > {

    /**
     * Create an empty storage area. Cursor points to first element's
     * position (or "after", if list is empty).
     *
     * @post !before()
     */
    public LinkedListCursor( LinkedList< E > list ) {
        my_list = list;
        cursor_node = list.first_node();
    }

    /**
     * Return the object at the current location.
     * @pre !off()
     */
    public E item() {
        return cursor_node.value;
    }

    /**
     * Return the object at the beginning of the list, irrespective of
     * location of cursor.
     * Cursor position is unchanged.
     * It is an error to call this routine if the list is empty.
     */
    public E first() {
        return my_list.first();
    }

    /**
     * Return the object at the end of the list, irrespective of
     * location of cursor.
     * Cursor position is unchanged.
     * It is an error to call this routine if the list is empty.
     */
    public E last() {
        return my_list.last();
    }

    /**
     * Place the object before the current cursor position.
     * Cursor position is unchanged.
     * It is an error to call this routine if the cursor is "before".
     * @pre !before()
     */
    public void put_before( E v ) {
        my_list.put_before( v, cursor_node );
    }

    /**
     * Place the object after the current cursor position.
     * Cursor position is unchanged.
     * It is an error to call this routine if the cursor is "after".
     * @pre !after()
     */
    public void put_after( E v ) {
        my_list.put_before( v, cursor_node.next );
    }

    /**
     * Remove the object at the current location.
     * Cursor position advances to the next item.
     * It is an error to call this routine if the cursor is "before"
     * or "after".
     * @pre !off()
     */
    public void discard() {
        DLinkNode< E > c2 = cursor_node.next;
        my_list.discard( cursor_node );
        cursor_node = c2;
    }

    /**
     * Set cursor to start of list
     * @post !before()
     */
    public void start() {
        cursor_node = my_list.first_node();
    }

    /**
     * Set cursor to previous position in list.
     * It is an error to call this routine if the cursor is "before".
     * @pre !before()
     */
    public void back() {
        cursor_node = cursor_node.prev;
    }

    /**
     * Set cursor to next position in list.
     * It is an error to call this routine if the cursor is "after".
     * @pre !after()
     */
    public void forth() {
        cursor_node = cursor_node.next;
    }

    /**
     * Set cursor to end of list
     * @post !after()
     */
    public void finish() {
        cursor_node = my_list.last_node();
    }

    /**
     * Return true iff the cursor is in front of the first element
     * in the list.
     */
    public boolean before() {
        return my_list.is_before( cursor_node );
    }

    /**
     * Return true iff the cursor is after the last element
     * in the list.
     */
    public boolean after() {
        return my_list.is_after( cursor_node );
    }

    /**
     * Return true iff the cursor is off the list.
     * @post Result == before() || after()
     */
    public boolean off() {
        return after() | before();
    }

    /**
     * @retrun a string description of this cursor
     */
    public String toString() {
        return getClass().getName() + "( " + cursor_node + " )";
    }

    /**
     * The list to which this cursor is attached
     */
    protected LinkedList< E > my_list;

    /**
     * The node to which this cursor is pointing
     */
    DLinkNode< E > cursor_node;

// **** Iterator Implementation ****

    public boolean hasNext() { return !after(); }

    public E next() {
        E result = item();
        forth();
        return result;
    }

    public void remove() {
        my_list.discard( cursor_node );
    }

}
