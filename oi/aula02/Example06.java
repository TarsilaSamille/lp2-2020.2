package aula02;

public class Example06 {

	public static void main(String [] args) {
		int x = 4;
		int fat = factorial(x);
		int expected = 4*3*2*1;
		if(fat != expected) {
			System.out.format("Expected %d but was %d.", expected, fat);
		} else {
			System.out.println("OK!");
		}
	}
	
	public static int factorial(int value) {
		return doFactorialTailRecursive(value, 1);
	}
	
	private static int doFactorialTailRecursive(int value, int factorial) {
		if (value <= 1) {
			return 1;
		} else {
			return doFactorialTailRecursive(value - 1, factorial * value);
		}
	}
}
