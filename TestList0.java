/**
 * 
 *
 * @author James Heliotis (jeh)
 *
 */
public class TestList0 {

    /**
     * Play around with LinkedList
     * 
     * @param args unused
     */
    public static void main( String[] args ) {
        LinkedList< String > names = new LinkedList< String >();
        names.register(new ListObserver<String>());
        names.register(new SortObserver<String>());
        names.append( "James" );
        names.append( "Elias"  );
        names.append( "Heliotis" );
        print( names );
        sort( names );
        print( names );
        names.append( "Athanasios" );
        print( names );
        sort( names );
        print( names );
        names.prepend( "Amerigo" );
        print( names );
    }
    
    /**
     * Print the contents of a list. Elements are printed using their own
     * toString() methods.
     * 
     * @param <E> The element type of the list
     * @param l The list to be printed
     */
    private static < E > void print( LinkedList< E > l ) {
        System.out.println( "*--------------------*" );
        LinkedListCursor< E > iter = new LinkedListCursor< E >( l );
        iter.start();
        while ( !iter.after() ) {
            System.out.println( iter.item() );
            iter.forth();
        }
        System.out.println( "======================" );
    }

    /**
     * Sort the contents of a list.
     * 
     * @param <E> The element type of the list
     * @param l The list to be sorted
     */
    private static < E extends Comparable< E > > void sort( LinkedList< E > l ) {
        int listSize = l.get_size();
        for ( int end = listSize - 1; end > 0; --end ) {
            for ( int i = 0; i < end; ++i ) {
                if ( i_th( l, i ).compareTo( i_th( l, i + 1 ) ) > 0 ) {
                    swap( l, i );
                }
            }
        }
    }

    /**
     * Move the cursor to the i<sup>th</sup> element in a list.
     * 
     * @param <E> The element type of the list
     * @param l The list
     * @param i The position to be sought
     */
    private static < E > void go_i_th( LinkedListCursor< E > iter, int i ) {
        iter.start();
        for ( int index = 0; !iter.after() && index != i; ++index ) {
            iter.forth();
        }
    }
    
    /**
     * Get the value of the element at the i<sup>th</sup> location in the list.
     * 
     * @param <E> The element type of the list
     * @param l The list
     * @param i The position to be sought
     * @return the value stored at the i<sup>th</sup> position.
     */
    private static < E > E i_th( LinkedList< E > l, int i ) {
        E result = null;
        LinkedListCursor< E > iter = new LinkedListCursor< E >( l );
        go_i_th( iter, i );
        if ( !iter.after() ) {
            result = iter.item();
        }
        return result;
    }
    
    /**
     * Swap the element at the i<sup>th</sup> location in the list with the
     * one after it.
     * 
     * @param <E> The element type of the list
     * @param l The list
     * @param i The location of the first of the pair of elements to be swapped
     */
    private static < E > void swap( LinkedList< E > l, int i ) {
        LinkedListCursor< E > iter = new LinkedListCursor< E >( l );
        go_i_th( iter, i );
        E temp = iter.item();
        iter.discard();
        iter.put_after( temp );
    }

}

