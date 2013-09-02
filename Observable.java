import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class Observable {

    public List<Observer> observers;

    public void register( Observer o ){
        if( observers == null) {
            observers = new ArrayList<Observer>();
        }
        observers.add( o );
    }

    public void deregister(Observer o){
        if(observers != null){
            observers.remove(o);
        }
    }

    public void setUpdated(){
        if( observers == null ) return;

        for(Iterator<Observer> o = observers.iterator(); o.hasNext(); ) {
             o.next().update( this );
        }
    }
}
