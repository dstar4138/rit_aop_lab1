/*
 *
 */
class ListObserver < E > implements Observer {

    public void update( Observable observed ) {
        System.out.println( "\t" + observed.toString() );
    }

}
