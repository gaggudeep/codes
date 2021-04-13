import java.util.*;

class RobotInAGrid {

	static class Point {

		int row, col;

		Point(int r, int c) {

			row = r;
			col = c;
		}
	}

	static void findPath(boolean[][] maze, int rows, int cols) {

		if(maze == null || maze.length == 0 || rows == 0 || cols == 0) {
			System.out.println("Maze doesn't exist.");
			return;
		}

		if(maze[rows - 1][cols - 1] == false) {
			System.out.println("Finishing point not visitable.");
			return;
		}

		//ArrayList for storing path and HashSet for storing visited points.
		ArrayList<Point> path = new ArrayList<>();
		HashSet<Point> visited = new HashSet<>();

		if(getPath(path, visited, maze, rows - 1, cols - 1)) {
			for(int i = 0 ; i < path.size() ; i++) {
				System.out.print(" (" + path.get(i).row + ", " + path.get(i).col + ")");
			}
		}

		else {
			System.out.println("No path found.");
		}
	}

	static boolean getPath(ArrayList<Point> path, HashSet<Point> visited, boolean[][] maze, int row, int col) {

		if(col < 0 || row < 0 || !maze[row][col]) {
			return false;
		}

		Point p = new Point(row, col);

		if(visited.contains(p)) {
			return false;
		}

		boolean isAtStartingPoint = (row == 0) && (col == 0);

		if(isAtStartingPoint || getPath(path, visited, maze, row - 1, col) || getPath(path, visited, maze, row, col - 1)) {
			path.add(p);
			return true;
		}

		visited.add(p);
		return false;
	}

	public static void main(String args[]) {

		boolean maze[][] = {{true, true, true, true, true},
							{true, true, true, true, true},
							{true, false, false, true, true},
							{true, true, true, true, true},
							{true, true, true, true, true}
							};

		findPath(maze, 5, 5);
	}
}