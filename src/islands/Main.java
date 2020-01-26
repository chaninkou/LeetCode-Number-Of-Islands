package islands;

import java.util.Arrays;

public class Main {
	// Very good coding problem, need to know this for sure
	public static void main(String[] args) {
		char[][] grid = {{'1','0','0','0','1'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}};
		
		// How to print out double array
		System.out.println("Grid: " + Arrays.deepToString(grid));
		
		FindNumberOfIslandsFunction solution = new FindNumberOfIslandsFunction();
		
		System.out.println("Number of islands: " + solution.numIslands(grid));
	}
}
