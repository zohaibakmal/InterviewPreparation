package testing;

public class TestFunction {

	public static void mys(int i){
		if (i<=0){
			return;
		}
		System.out.println(i);
		mys(i-1);
		System.out.println(i);
	}
	public static void main(String[] args) {
		
		System.out.println(11/2);
	}

}
