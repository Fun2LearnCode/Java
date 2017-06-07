public class Switches{
    public static void main(String args[]){
        int foo = 4;
        // A switch is like many if and if else statements, but can only check if the
        // item equals a value of the same time. The argument must be the same type
        // as all the switch cases or it will throw an error.
        // in switches only constants can be used as a case choice. This means that
        // only enums, final variables and constants such as numbers can be used.
        switch(foo){
            case 0:
                System.out.println("Foo equals 0");
                break;
            case 1:
                System.out.println("Foo equals 1");
                break;
            case 2:
                System.out.println("Foo equals 2");
                break;
            case 3:
                System.out.println("Foo equals 3");
                break;
            case 4:
                System.out.println("Foo equals 4");
                break;
            default:
                System.out.println("Foo is larger than 4 or less than 0");
                break;
        }
    }
}
