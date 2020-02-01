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
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				// If we see 1, thats mean it is an island
				if (grid[i][j] == '1') {
					// Make sure to add, not equal
					// This will always add 1 no matter what
					numOfIslands += dfs(grid, i, j);
				}
			}
		}

		return numOfIslands;
	}

	// This dfs will just go down from current element and swap any 1 to zero, always return 1 when the recursive is done
	// Reason why there is Down, Up, right, left because an islands could be all 1's next to each other
	public int dfs(char[][] grid, int i, int j) {
		// i < 0, means it went above the grid
		// i >= grid.length, means we went below the grid
		// j < 0, means when left out of the grid
		// j >= grid[i].length, mean we went right out of the grid
		// grid[i][j] == '0', if its 0, we don't care
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
			// REMEMBER, returning zero doesn't stop the recursion, it just means nothing happened and do the next call
			return 0;
		}

		// If the index we are on is 1, then set it to 0 so we don't revisit it
		grid[i][j] = '0';

		// Make sense to go down, top, right, left since we start from index 0
		
		// Down
		dfs(grid, i + 1, j);

		// Up
		dfs(grid, i - 1, j);

		// To the right
		dfs(grid, i, j + 1);

		// To the left
		dfs(grid, i, j - 1);

		
		// If its gets here, that means there is an island
		// No matter what we always return 1, not 0
		return 1;
	}
}
