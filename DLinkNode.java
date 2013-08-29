/**
 * An internal class for the utility package. It aids in the creation of
 * doubly-linked lists. Since it is internal, the data has package
 * access.
 */
class DLinkNode< E > {

    /**
     * Create a new node from the given arguments.
     * @param prevLink the node that should precede this one
     * @param value the value to be placed in this node
     * @param nextLink the node that should precede follow one
     */
    DLinkNode( DLinkNode< E > prevLink, E value, DLinkNode< E > nextLink ) {
        prev = prevLink;
        this.value = value;
        next = nextLink;
    }

    /**
     * Provide a string describing this node. The contents are listed
     * inside parentheses and separated by commas. The prev and next
     * links are simply marked as null ("NUL") or non-null ("OBJ").
     */
    @Override
    public String toString() {
        return getClass().getName() + "( " +
               ( (null!=prev)?"OBJ":"NUL" ) +
               ", " + value + ", " +
               ( (null!=next)?"OBJ":"NUL" ) +
            " )";
    }

// attributes

    /**
     * References to the adjacent nodes in the list.
     */
    DLinkNode< E > prev, next;

    /**
     * The value in this node.
     */
    E value;

}
