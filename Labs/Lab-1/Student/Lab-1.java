
public class Lab1 {
	public static void main(String[] args) {
		int[][] name = new int[13][13];
		int x = 0;
		for (x = 0; x < 13; x++) {	
			}
			System.out.println();
			for (int y = 0; y < 13; y++) {
				if(x!=0){
					name[x][y]= name[x][0]*name[0][y];	
				System.out.print(name[x][y] + " ");
			}
		}
	}
}
