package islands;

public class FindNumberOfIslandsFunction {
	public int numIslands(char[][] grid) {
		// Error checking, always do error checking first
		if (grid == null || grid.length == 0) {
			return 0;
		}

		// number of islands
		int numOfIslands = 0;

		// loop through the whole grid
		// n x m since the col and row doesn't need to be the same
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				// If we see 1, thats mean it is an island
				if (grid[row][col] == '1') {
					// We could've just numOfIslands++ and make dfs as a void method
					// This will always add 1 no matter what
					numOfIslands += dfs(grid, row, col);
				}
			}
		}

		return numOfIslands;
	}

	// Main point of dfs is to switch all 1 to 0 that is connected
	// This dfs will just go down from current element and swap any 1 to zero, always return 1 when the recursive is done
	public int dfs(char[][] grid, int row, int col) {
		// row < 0, means it went above the grid
		// row >= grid.length, means we went below the grid
		// col < 0, means when left out of the grid
		// col >= grid[row].length, mean we went right out of the grid
		// grid[row][col] == '0', if its 0, we don't care
		if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == '0') {
			// return 0 does not do anything, just a place holder
			return 0;
		}

		// If the index we are on is 1, then set it to 0 so we don't revisit it
		grid[row][col] = '0';

		// Down
		dfs(grid, row + 1, col);

		// Up
		dfs(grid, row - 1, col);

		// To the right
		dfs(grid, row, col + 1);

		// To the left
		dfs(grid, row, col - 1);

		// Return 1 when we complete marking the island
		return 1;
	}
}
