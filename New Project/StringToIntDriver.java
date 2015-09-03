public class StringToIntDriver {
	
	public static void main(String[] args) {
		Library lib = new Library();
		Integer number = lib.stringToInt("-123");
		System.out.println(number);
		number = lib.stringToInt("abc");
		System.out.println(number);
		number = lib.stringToInt("123ab45");
		System.out.println(number);
	}

}
