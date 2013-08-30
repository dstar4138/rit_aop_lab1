import java.util.Iterator;

/*
 *
 */
class SortObserver< E extends Comparable< E > > implements Observer {

    @SuppressWarnings("unchecked")
    public void update( Observable observed ) {
        if( observed instanceof LinkedList ){
            System.out.println( is_sorted((LinkedList<E>)observed) ? "Sorted" : "Not Sorted" );
        }
    }

    private boolean is_sorted( LinkedList< E > o ){
        E prev = null;
        for ( Iterator<E> i = o.iterator(); i.hasNext(); ){
            E cur = i.next();
            if( prev!=null && prev.compareTo( cur ) > 0){
                return false;
            }
            prev = cur;
        } 
        return true;
    }
}
