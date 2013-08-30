/*
 * Simple Observer Interface.
 */
interface Observer {

    // When the Observed object is changed, this function will be called.
    public void update( Observable observed );
}
