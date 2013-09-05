

public class Generic extends Observable {
    private String attribute_str;
    private int attribute_int;
	
    public Generic(String s, int i) {
        attribute_str = s;
        attribute_int = i;
    }
    
    public void setStr(String s)
    {
    	attribute_str = s;
    	setUpdated();
    }
    
    public void setInt(int i)
    {
    	attribute_int = i;
    	setUpdated();
    }

    @Override
    public String toString() {
        return attribute_str + " " + Integer.toString(attribute_int);
    }


}
