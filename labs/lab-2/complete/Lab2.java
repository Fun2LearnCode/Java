import java.util.Scanner;

public class Lab2 {
	public static void main(String args[]){
		myName();
		anyName();
	}
	public static void myName(){
		char[] foo = "Nolan".toCharArray();
		String s = "";
		for(char bar : foo){
			s += bar;
			System.out.println(s);
		}
	}
	public static void anyName(){
		Scanner in = new Scanner(System.in);
		char[] foo = in.next().toCharArray();
		String s = "";
		for(char bar : foo){
			s += bar;
			System.out.println(s);
		}
		in.close();
	}
}
