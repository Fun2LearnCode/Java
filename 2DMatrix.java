public class 2dMatrix{
    public static void main(String args[]){
        int[][] matrix = new int[3][3];
        for(int x = 0; x < matrix.length();x++){
            for(int y = 0; y < matrix[x].length();y++){
                matrix[y][x] = x * y;
            }
        }

        for(int x = 0; x < matrix.length();x++){
            for(int y = 0; y < matrix[x].length();y++){
                System.out.print(matrix[y][x]);
            }
            System.out.println("");
        }

    }
}
