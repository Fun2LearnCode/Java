public class If{
    public static void main(String args[]){
        if(true){
            System.out.println("True");
        }
        if(true){
            System.out.println("True")
        }else{
            System.out.println("false")
        }
        int x = 20;
        if(x < 10){
            System.out.println("x is less than 10");
        }else if(x == 10){
            System.out.println("x is equal to 10");
        }else{
            System.out.println("x is greater than 10");
        }
        int x = 74;
        if(x > 90){
            System.out.println("You have an A");
        }else if(x > 80){
            System.out.println("You have a B");
        }else if(x > 70){
            System.out.println("You have a C");
        }else if(x > 60){
            System.out.println("You have a D");
        }else{
            System.out.println("You have an F");
        }

    }
}
