
public class GenericExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Generic foo = new Generic("foo", 0);
		GenericObserver obs1 = new GenericObserver();
		GenericObserver obs2 = new GenericObserver();
		foo.register(obs1);
		foo.register(obs2);
		foo.setInt(3);
		foo.setStr("oof");
		
		Generic bar = new Generic("bar", 1);
		Generic stool = new Generic("stool", 2);
		GenericObserver obs3 = new GenericObserver();
		bar.register(obs3);
		stool.register(obs3);
		bar.setStr("foobar");
		stool.setInt(4);
		

	}

}
