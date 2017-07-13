
public class Lab1 {
	public static void main(String args[]){
		int[][] matrix = new int[13][13];
		for(int y = 0; y < 13; y++){
			for(int x = 0; x< 13; x++){
				if(x == 0){
					matrix[0][y] = y;
				}else if(y == 0){
					matrix[x][0] = x;
				}else{
					matrix[x][y] = x*y;
				}
			}
		}
		for(int y = 0; y < 13; y++){
			for(int x = 0; x< 13; x++){
				switch((matrix[x][y] + "").length()){ // this switch is only for formating, it is not needed
					case 1: System.out.print(matrix[x][y] + "   ");
						break;
					case 2: System.out.print(matrix[x][y] + "  ");
						break;
					case 3: System.out.print(matrix[x][y] + " ");
						break;

				};
			}
			System.out.println();
		}

	}
}
