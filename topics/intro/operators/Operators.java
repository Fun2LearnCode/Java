public class Operators{
    public static void main(String args[]){
        //number operators
        System.out.println(3++);
        System.out.println(++3);
        System.out.println(3 + 2);
        System.out.println(3 - 2);
        System.out.println(3 * 2);
        System.out.println(3 / 2);
        System.out.println(3 % 2);
        int x = 3;
        x += 2;
        x -= 2;
        x /= 2;
        x *= 2;

        //Boolean operators
        System.out.println(3 > 2);
        System.out.println(3 < 2);
        System.out.println(3 >= 2);
        System.out.println(3 <= 2);
        System.out.println(3 == 2);
        System.out.println(true && true);
        System.out.println(true || true);

        //String operators
        System.out.println("String" + 5);

        //Bitwise operators
        System.out.println(3 | 2);
        System.out.pritnln(3 & 2);
        System.out.pritnln(3 ^ 2);
        System.out.println(3<<2);
        System.out.println(3>>2);
        System.out.println(3>>>2);
    }
}
