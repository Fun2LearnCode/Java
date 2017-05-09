public class NamingConvetion{
    public static void main(String args[]){
        //Not allowed
        int 123 = 0; // number begining
        int hi@ = 0; // has a special character
        int public = 0; // uses a keyword as a name
        int foo = 0, int bar = 1;
        int baz = 0; quux = 1;

        //allowed
        int _foo = 0;
        int $bar = 0;
        int bar123 = 0;
        int abc = 0, def = 0;
        int ghi = 0; int jkl = 0;
        int mno, pqr;
        int stu = 0, vwx;
    }
}
