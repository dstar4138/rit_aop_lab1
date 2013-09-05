/*
 *
 */
class GenericObserver implements Observer {

    public void update( Observable observed ) {
        System.out.println( "\t" + observed.toString() );
    }

}
