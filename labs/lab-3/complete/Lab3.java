public class Lab3{
    public static void main(String args[]){
        basicLab();
        //taskOne();
        //taskTwo();
        // Task 3 modifies the calculator class.
    }
    public static void taskTwo(){
        // This is the same as the basic lab.
        // Scanners read one character, or the datatype specified at a time.
        // This means that 3 + 4 is the same as
        // 3
        // +
        // 4
        // This task was to simply test your understanding of how scanners parse data.
        // If BufferedReader was used then you'd just have to parse from it, splitting on spaces.
        // If you made the scanner work with strings like 3+6 then you'd have to use regular expressions (regex)
        // We'll cover this in a later lab.
        Scanner in = new Scanner(System.in);
        Calculator calc = new Calculator();
        String s;
        while(true){
            System.out.println(calc.solve(in.nextInt(), in.next().charAt(0),in.nextInt()));
        }
    }
    public static void taskOne(){
        // There are multiple ways of doing this, however it's best just to use it here without changing
        // the calculator class. This is because you'd still have to check if there is already an answer in order
        // to call the correct method, so it's just more coding.
        Scanner in = new Scanner(System.in);
        Calculator calc = new Calculator();
        int answer = 0;
        while(true){
            if(in.hasNextInt()){
                answer = calc.solve(in.nextInt(), in.next().charAt(0),in.nextInt());
            }else{
                answer = calc.solve(answer, in.next().charAt(0), in.nextInt());
            }
            System.out.println(answer);
        }
    }
    public static void basicLab(){
        Scanner in = new Scanner(System.in);
        Calculator calc = new Calculator();
        while(true){
            System.out.println(calc.solve(in.nextInt(), in.next().charAt(0),in.nextInt()));
        }
    }
}
